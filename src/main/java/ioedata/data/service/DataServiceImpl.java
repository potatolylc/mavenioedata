package ioedata.data.service;

import ioedata.data.model.DataDao;
import ioedata.data.model.DataValue;
import ioedata.data.model.TimeValue;
import ioedata.device.model.DeviceValue;
import ioedata.device.service.DeviceService;
import ioedata.sensor.config.SensorManager;
import ioedata.sensor.config.TypeFormat;
import ioedata.sensor.factory.Sensor;
import ioedata.sensor.model.SensorTypeValue;
import ioedata.sensor.model.SensorValue;
import ioedata.sensor.service.SensorService;

import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class provides services about sensor data.
 * It implements DataService interface.
 * @author ajou
 */
@Service
public class DataServiceImpl implements DataService {
	@Resource(name = "dataDaoImpl")
	private DataDao dataDao;
	@Resource(name = "deviceServiceImpl")
	private DeviceService deviceService;
	@Resource(name = "sensorServiceImpl")
	private SensorService sensorService;
	
	/**
	 * Methods about data access or manipulation with DB
	 * @throws Exception 
	 */

	@Override
	public int insertSensorData(DataValue dataVal) throws Exception {
		return this.dataDao.insertSensorData(dataVal);
	}
	
	/*
	 * Analyze sensor types and retrieve types, and take actions according to different retrieve types.
	 * If retrieve type comes in as "latest" and sensor type as "all", it means to retrieve the latest one data value set
	 * on a specific device regardless of a sensor type; but if sensor type comes in as a specific type,
	 * then retrieve the latest data record of that type on the request device. 
	 * (non-Javadoc)
	 * @see ioedata.data.service.DataService#retrieveData(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public DataValue retrieveData(String deviceId, String sensorType, String retrieveType) throws Exception {
		DataValue dataVal = null;
		if(sensorType.equals("all")){
			if(retrieveType.equals("latest")){
				dataVal = this.retrieveLatestData(deviceId);				
			}
		} else if(!sensorType.equals("all")){
			int sensorTypeNum = TypeFormat.sensorTypeUrlFormat(sensorType);
			if(retrieveType.equals("latest")){
				dataVal = this.retrieveLatestDataBySensorType(deviceId, sensorTypeNum);				
			} else if(retrieveType.equals("peak")){
				dataVal = this.retrievePeakDataBySensorType(deviceId, sensorTypeNum);
			} else if(retrieveType.equals("trough")){
				dataVal = this.retrieveTroughDataBySensorType(deviceId, sensorTypeNum);
			}
		}
		return dataVal;
	}

	/*
	 * Retrieve the latest data of a specific device despite of a sensor type
	 */
	public DataValue retrieveLatestData(String deviceId) throws Exception {
		return this.dataDao.getLastDataByDeviceIdSortedByTimestamp(deviceId);
	}
	
	/*
	 * Retrieve the latest data of a specific device and a specific sensor type on that device
	 */
	public DataValue retrieveLatestDataBySensorType(String deviceId, int sensorTypeNum) throws Exception {
		SensorValue sensorVal = new SensorValue(new DeviceValue(deviceId), new SensorTypeValue(sensorTypeNum));
		return this.dataDao.getLastDataByDeviceIdAndSensorTypeSortedByTimestamp(sensorVal);
	}
	
	/*
	 * Retrieve the peak data value of a specific sensor type on a specific device
	 */
	public DataValue retrievePeakDataBySensorType(String deviceId, int sensorTypeNum) throws Exception {
		SensorValue sensorVal = new SensorValue(new DeviceValue(deviceId), new SensorTypeValue(sensorTypeNum));
		return this.dataDao.getGreatestDataByDeviceIdAndSensorType(sensorVal);
	}
	
	/*
	 * Retrieve the trough data value of a specific sensor type on a specific device
	 */
	public DataValue retrieveTroughDataBySensorType(String deviceId, int sensorTypeNum) throws Exception {
		SensorValue sensorVal = new SensorValue(new DeviceValue(deviceId), new SensorTypeValue(sensorTypeNum));
		return this.dataDao.getLeastDataByDeviceIdAndSensorType(sensorVal);
	}
	
	@Override
	public List<DataValue> retrieveDataList(String deviceId, String sensorType,
			String retrieveType) throws Exception {
		
		return null;
	}
	
	@Override
	public List<DataValue> retrieveDataList(String deviceId, String sensorType,
			String startDate, String endDate) throws Exception {
		int sensorTypeNum = TypeFormat.sensorTypeUrlFormat(sensorType);
		SensorValue sensorVal = this.sensorService.getBasicSensorInfoByDeviceIdAndSensorTypeNum(deviceId, sensorTypeNum);
		if(sensorVal != null){
			TimeValue timeVal = new TimeValue(startDate, endDate);
			DeviceValue deviceVal = new DeviceValue(deviceId);
			SensorTypeValue sensorTypeVal = new SensorTypeValue(sensorTypeNum);
			SensorValue paramSensorVal = new SensorValue(deviceVal, sensorTypeVal);
			DataValue dataVal = new DataValue(paramSensorVal, timeVal);
			List<DataValue> dataList = this.dataDao.getDataListByDeviceIdAndSensorTypeAndDateSortedByTimestamp(dataVal);
			return dataList;
		}
		return null;
	}

	@Override
	public List<DataValue> retrieveDataList(String deviceId, String sensorType,
			String startDate, String startTime, String endDate, String endTime)
			throws Exception {
		int sensorTypeNum = TypeFormat.sensorTypeUrlFormat(sensorType);
		SensorValue sensorVal = this.sensorService.getBasicSensorInfoByDeviceIdAndSensorTypeNum(deviceId, sensorTypeNum);
		if(sensorVal != null){
			TimeValue timeVal = new TimeValue(null, null, startDate+" "+startTime, endDate+" "+endTime);
			DeviceValue deviceVal = new DeviceValue(deviceId);
			SensorTypeValue sensorTypeVal = new SensorTypeValue(TypeFormat.sensorTypeUrlFormat(sensorType));
			SensorValue paramSensorVal = new SensorValue(deviceVal, sensorTypeVal);
			DataValue dataVal = new DataValue(paramSensorVal, timeVal);
			List<DataValue> dataList = this.dataDao.getDataListByDeviceIdAndSensorTypeAndDateSortedByTimestamp(dataVal);
			return dataList;
		}
		return null;
	}
	
	/**
	 * Methods about data collection or control with Arduino
	 * @throws Exception 
	 */
	/*
	 * Based on the requested sensor type, create a new sensor to collect data on the requested device.
	 * The dataCollectionIntervalType defines the time interval when collecting data, which is divided into 
	 * realtime - for collecting continuous data per 2 seconds,
	 * rapid - for collecting continuous data per 3 minus,
	 * medium - for collecting continuous data per 10 minus,
	 * slow - for collecting continuous data per 30 minus, and
	 * single - for collecting only one data set per request.
	 * The collected data will be stored into sensor database for future use.
	 * If successfully stored, then return TRUE value; else, return FALSE value. 
	 * (non-Javadoc)
	 * @see ioedata.data.service.DataService#collectData(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public boolean collectData(String deviceId, String sensorType, String dataCollectionIntervalType) throws Exception {
		// Get the device info by deviceId
		boolean flag = false;
		int result = 0;
		DeviceValue deviceInfo = this.deviceService.getBasicDeviceInfoByDeviceId(deviceId);
		if(deviceInfo != null){ // If the device exists
			// Format String type to int type
			int sensorTypeNum = TypeFormat.sensorTypeUrlFormat(sensorType);
			int dataCollectionInterval = TypeFormat.dataCollectionIntervalFormat(dataCollectionIntervalType);
			// Get Sensor instance from SensorManager factory
			Sensor sensor = SensorManager.getSensorManager().getSensor(sensorTypeNum);
			if(dataCollectionInterval == Sensor.DATA_COLLECTION_INTERVAL_SINGLE){ // If get data for just once 
				// Get one JSON data only once
				JSONObject jsonData = sensor.subscribeSingleJsonData(deviceId, deviceInfo.getDeviceIp(), deviceInfo.getDeviceIpPort(), sensorType);
				if(sensorType.equals("all")){
					// Get the list of the sensors' information that is connected to the device
					List<SensorValue> list = this.sensorService.getBasicSensorInfoListByDeviceId(deviceId);
					for(SensorValue sensorInfo: list){
						//System.out.println(sensorInfo.getSensorSerialNum()+": "+jsonData.get(TypeFormat.sensorTypeResponseJsonKeyFormat(sensorInfo.getSensorTypeValue().getSensorType()))+", "+jsonData.get("sensorDataTimestamp"));
						// Create data value object of each sensor type and insert into sensor database
						DataValue dataVal = new DataValue(jsonData.get(TypeFormat.sensorTypeResponseJsonKeyFormat(sensorInfo.getSensorTypeValue().getSensorType())), jsonData.getString("sensorDataTimestamp"), sensorInfo);
						result = this.insertSensorData(dataVal);
					}
				}else{
					// Get the single sensor's information that is connected to the device
					SensorValue sensorInfo = this.sensorService.getBasicSensorInfoByDeviceIdAndSensorTypeNum(deviceId, sensorTypeNum);
					DataValue dataVal = new DataValue(jsonData.get(sensorType), jsonData.getString("sensorDataTimestamp"), sensorInfo);
					result = this.insertSensorData(dataVal);
				}
			}else{ // If get data continuously
				// Get continuous JSON data 
				while(!dataCollectionIntervalType.equals("0")){
					sensor.subscribeSingleJsonData(deviceId, deviceInfo.getDeviceIp(), deviceInfo.getDeviceIpPort(), sensorType);
					Thread.sleep(dataCollectionInterval);
				}
			}
		}
		if(result != 0)
			flag = true;
		return flag;
	}
}