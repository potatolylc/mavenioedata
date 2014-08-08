package ioedata.device.service;

import ioedata.device.model.DeviceValue;

/**
 * This interface provides many methods to deal with end devices,
 * such as device registration, check whether the device exists, etc.
 * @author ajou
 *
 */
public interface DeviceService {
	/*
	 * Get device basic information except device password using device ID.
	 */
	public DeviceValue getBasicDeviceInfoByDeviceId(String deviceId) throws Exception;
	/*
	 * Store new device information into database.
	 * Before storing new device into database, it first checks whether the device ID or device IP address has already been stored in the database.
	 * If the device does not exist and has been inserted into database successfully, return true value; else, return false.
	 */
	public boolean deviceRegistration(DeviceValue deviceVal) throws Exception;
	/*
	 * Check whether the device IP already exists, which should be unique in the database.
	 * If IP already exists, return 1; else, return 0.
	 */
	public int checkDeviceIpExist(String deviceIp) throws Exception;
	/*
	 * Check whether the device ID already exists, which should be unique in the database.
	 * If ID already exists, return 1; else, return 0.
	 */
	public int checkDeviceIdExist(String deviceId) throws Exception;
	/*
	 * Check whether the device ID, device IP address and device password match.
	 * If the information matches, return 1; else, return 0, which means there is no existing device information stored in database.
	 */
	public int deviceAuthentication(DeviceValue deviceVal) throws Exception;
}