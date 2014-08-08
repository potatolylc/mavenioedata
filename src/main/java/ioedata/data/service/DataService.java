package ioedata.data.service;

import ioedata.data.model.DataValue;

import java.util.List;

/**
 * This interface provides methods to both access and manipulate data in the sensor database and collect and control sensor end devices.
 * @author ajou
 */
public interface DataService {
	/**
	 * Methods that are related to data access and manipulation with DB
	 */
	/*
	 * Retrieve only one data information set from database using device ID based on different sensor types and retrieve types.
	 */
	public DataValue retrieveData(String deviceId, String sensorType, String retrieveType) throws Exception;
	/*
	 * Retrieve data list set from database according to different sensor types and retrieve types
	 */
	public List<DataValue> retrieveDataList(String deviceId, String sensorType, String retrieveType) throws Exception;
	/*
	 * Retrieve data list set from database according to a specific date interval defined by the one who requests.
	 */
	public List<DataValue> retrieveDataList(String deviceId, String sensorType, String startDate, String endDate) throws Exception;
	/*
	 * Retrieve data list set from database according to a specific time interval defined by the one who requests.
	 */
	public List<DataValue> retrieveDataList(String deviceId, String sensorType, String startDate, String startTime, String endDate, String endTime) throws Exception;
	/*
	 * After collecting data from end devices, insert sensor data value into database.
	 */
	public int insertSensorData(DataValue dataVal) throws Exception;
	
	/**
	 * Methods that are related to data collection and control with Arduino
	 */
	/*
	 * Collect data from end devices and insert into database.
	 */
	public boolean collectData(String deviceId, String sensorType, String dataCollectionIntervalType) throws Exception;
}