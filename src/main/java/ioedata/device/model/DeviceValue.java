package ioedata.device.model;

import java.util.Date;

/**
 * This class creates data transport objects that contain the devices' information,
 * such as the IP address, device ID and password of various devices. 
 * @author ajou
 */
public class DeviceValue {
	private int deviceSerialNum;
	private String deviceIp;
	private int deviceIpPort;
	private String deviceId;
	private String devicePassword;
	private Date deviceTimestamp;
	private String deviceTimestampStr;
	
	public DeviceValue() {
		super();
	}
	public DeviceValue(String deviceId) {
		super();
		this.deviceId = deviceId;
	}
	public DeviceValue(String deviceIp, int deviceIpPort, String deviceId,
			String devicePassword) {
		super();
		this.deviceIp = deviceIp;
		this.deviceIpPort = deviceIpPort;
		this.deviceId = deviceId;
		this.devicePassword = devicePassword;
	}
	public DeviceValue(String deviceIp, int deviceIpPort, String deviceId,
			String devicePassword, Date deviceTimestamp) {
		super();
		this.deviceIp = deviceIp;
		this.deviceIpPort = deviceIpPort;
		this.deviceId = deviceId;
		this.devicePassword = devicePassword;
		this.deviceTimestamp = deviceTimestamp;
	}
	public DeviceValue(int deviceSerialNum, String deviceIp, int deviceIpPort,
			String deviceId, String devicePassword, Date deviceTimestamp) {
		super();
		this.deviceSerialNum = deviceSerialNum;
		this.deviceIp = deviceIp;
		this.deviceIpPort = deviceIpPort;
		this.deviceId = deviceId;
		this.devicePassword = devicePassword;
		this.deviceTimestamp = deviceTimestamp;
	}
	
	public int getDeviceSerialNum() {
		return deviceSerialNum;
	}
	public void setDeviceSerialNum(int deviceSerialNum) {
		this.deviceSerialNum = deviceSerialNum;
	}
	public String getDeviceIp() {
		return deviceIp;
	}
	public void setDeviceIp(String deviceIp) {
		this.deviceIp = deviceIp;
	}
	public int getDeviceIpPort() {
		return deviceIpPort;
	}
	public void setDeviceIpPort(int deviceIpPort) {
		this.deviceIpPort = deviceIpPort;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getDevicePassword() {
		return devicePassword;
	}
	public void setDevicePassword(String devicePassword) {
		this.devicePassword = devicePassword;
	}
	public Date getDeviceTimestamp() {
		return deviceTimestamp;
	}
	public void setDeviceTimestamp(Date deviceTimestamp) {
		this.deviceTimestamp = deviceTimestamp;
	}
	public String getDeviceTimestampStr() {
		return deviceTimestampStr;
	}
	public void setDeviceTimestampStr(String deviceTimestampStr) {
		this.deviceTimestampStr = deviceTimestampStr;
	}
	
	@Override
	public String toString() {
		return "DeviceValue [deviceSerialNum=" + deviceSerialNum
				+ ", deviceIp=" + deviceIp + ", deviceIpPort=" + deviceIpPort
				+ ", deviceId=" + deviceId + ", devicePassword="
				+ devicePassword + ", deviceTimestamp=" + deviceTimestamp
				+ ", deviceTimestampStr=" + deviceTimestampStr + "]";
	}
}
