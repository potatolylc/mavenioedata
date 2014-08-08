package ioedata.sensor.model;

import java.util.List;

/**
 * This interface provides methods to access and manipulate database about sensors.
 * @author ajou
 */
public interface SensorDao {
	/*
	 * Get basic sensor information from database using device ID and sensor type number.
	 */
	public SensorValue getBasicSensorInfoByDeviceIdAndSensorTypeNum(SensorValue sensorVal) throws Exception;
	/*
	 * Get basic sensor information list from database using device ID. 
	 */
	public List<SensorValue> getBasicSensorInfoListByDeviceId(String deviceId) throws Exception;
	/*
	 * Insert new sensor information into database.
	 */
	public int insertSensor(SensorValue sensorVal) throws Exception;
}