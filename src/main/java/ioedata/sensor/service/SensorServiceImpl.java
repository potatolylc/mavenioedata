package ioedata.sensor.service;

import ioedata.device.model.DeviceValue;
import ioedata.sensor.config.TypeFormat;
import ioedata.sensor.model.SensorDao;
import ioedata.sensor.model.SensorTypeValue;
import ioedata.sensor.model.SensorValue;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class provides services about sensors.
 * It implements SensorService interface.
 * @author ajou
 *
 */
@Service
public class SensorServiceImpl implements SensorService {
	@Resource(name = "sensorDaoImpl")
	private SensorDao sensorDao;

	@Override
	public SensorValue getBasicSensorInfoByDeviceIdAndSensorTypeNum(
			String deviceId, int sensorTypeNum) throws Exception {
		return this.sensorDao.getBasicSensorInfoByDeviceIdAndSensorTypeNum(new SensorValue(new DeviceValue(deviceId), new SensorTypeValue(sensorTypeNum)));
	}

	@Override
	public List<SensorValue> getBasicSensorInfoListByDeviceId(String deviceId) throws Exception {
		return this.sensorDao.getBasicSensorInfoListByDeviceId(deviceId);
	}

	@Override
	@Transactional
	public boolean sensorRegistration(String deviceId, String sensorType)
			throws Exception {
		boolean flag = false;
		int sensorTypeNum = TypeFormat.sensorTypeUrlFormat(sensorType);
		SensorValue sensorInfo = this.getBasicSensorInfoByDeviceIdAndSensorTypeNum(deviceId, sensorTypeNum);
		if(sensorInfo == null){ // If there is no existing sensor connected to the device
			// Do sensor registration
			int result = this.sensorDao.insertSensor(new SensorValue(new DeviceValue(deviceId), new SensorTypeValue(sensorTypeNum)));
			if(result ==1 )
				flag = true;
		}
		return flag;
	}
}