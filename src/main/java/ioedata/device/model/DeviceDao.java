package ioedata.device.model;

/**
 * This interface provides methods to access and manipulate database about devices.
 * @author ajou
 *
 */
public interface DeviceDao {
	/*
	 * Get device basic information except device password using device ID.
	 */
	public DeviceValue getBasicDeviceInfoByDeviceId(String deviceId) throws Exception;
	/*
	 * Store new device information into database.
	 * If succeeded, return true value; else, return false.
	 */
	public int insertDevice(DeviceValue deviceVal) throws Exception;
	/*
	 * Get the number of device using the device ID and return the number value.
	 */
	public int getDeviceCountByDeviceId(String deviceId) throws Exception;
	/*
	 * Get the number of device using the device IP and return the number value.
	 */
	public int getDeviceCountByDeviceIp(String deviceIp) throws Exception;
	/*
	 * Get the number of device using the device ID, IP address and password and return the number value.
	 */
	public int getDeviceCountByDeviceIdAndDeviceIpAndDevicePassword(DeviceValue deviceVal) throws Exception;
}