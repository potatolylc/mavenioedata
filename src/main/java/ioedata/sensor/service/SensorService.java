package ioedata.sensor.service;

import ioedata.sensor.model.SensorValue;

import java.util.List;

/**
 * This interface provides methods about sensor services,
 * such as sensor registration and getting sensor information of specific devices.
 * @author ajou
 *
 */
public interface SensorService {
	/*
	 * Get basic sensor information using device ID and sensor type number,
	 * then return the sensor information instance.
	 */
	public SensorValue getBasicSensorInfoByDeviceIdAndSensorTypeNum(String deviceId, int sensorTypeNum) throws Exception;
	/*
	 * Get all basic sensor information in a list using device ID,
	 * then return the sensor information instance list.
	 */
	public List<SensorValue> getBasicSensorInfoListByDeviceId(String deviceId) throws Exception;
	/*
	 * Register new sensor to a specific device.
	 * If registration succeeded, return true value;else, return false.
	 */
	public boolean sensorRegistration(String deviceId, String sensorType) throws Exception;
}