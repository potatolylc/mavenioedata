package ioedata.sensor.model;

import ioedata.device.model.DeviceValue;

import java.util.Date;

/**
 * This class creates data transport objects that contain the sensors' information. 
 * @author ajou
 */
public class SensorValue {
	private int sensorSerialNum;
	private Date sensorTimestamp;
	private String sensorTimestampStr;
	private DeviceValue deviceValue;
	private SensorTypeValue sensorTypeValue;
	
	public SensorValue() {
		super();
	}
	public SensorValue(int sensorSerialNum) {
		super();
		this.sensorSerialNum = sensorSerialNum;
	}
	public SensorValue(DeviceValue deviceValue, SensorTypeValue sensorTypeValue) {
		super();
		this.deviceValue = deviceValue;
		this.sensorTypeValue = sensorTypeValue;
	}
	public SensorValue(int sensorSerialNum, DeviceValue deviceValue,
			SensorTypeValue sensorTypeValue) {
		super();
		this.sensorSerialNum = sensorSerialNum;
		this.deviceValue = deviceValue;
		this.sensorTypeValue = sensorTypeValue;
	}
	public SensorValue(int sensorSerialNum, String sensorTimestampStr,
			DeviceValue deviceValue, SensorTypeValue sensorTypeValue) {
		super();
		this.sensorSerialNum = sensorSerialNum;
		this.sensorTimestampStr = sensorTimestampStr;
		this.deviceValue = deviceValue;
		this.sensorTypeValue = sensorTypeValue;
	}
	public SensorValue(int sensorSerialNum, Date sensorTimestamp,
			String sensorTimestampStr, DeviceValue deviceValue,
			SensorTypeValue sensorTypeValue) {
		super();
		this.sensorSerialNum = sensorSerialNum;
		this.sensorTimestamp = sensorTimestamp;
		this.sensorTimestampStr = sensorTimestampStr;
		this.deviceValue = deviceValue;
		this.sensorTypeValue = sensorTypeValue;
	}
	
	public int getSensorSerialNum() {
		return sensorSerialNum;
	}
	public void setSensorSerialNum(int sensorSerialNum) {
		this.sensorSerialNum = sensorSerialNum;
	}
	public Date getSensorTimestamp() {
		return sensorTimestamp;
	}
	public void setSensorTimestamp(Date sensorTimestamp) {
		this.sensorTimestamp = sensorTimestamp;
	}
	public String getSensorTimestampStr() {
		return sensorTimestampStr;
	}
	public void setSensorTimestampStr(String sensorTimestampStr) {
		this.sensorTimestampStr = sensorTimestampStr;
	}
	public DeviceValue getDeviceValue() {
		return deviceValue;
	}
	public void setDeviceValue(DeviceValue deviceValue) {
		this.deviceValue = deviceValue;
	}
	public SensorTypeValue getSensorTypeValue() {
		return sensorTypeValue;
	}
	public void setSensorTypeValue(SensorTypeValue sensorTypeValue) {
		this.sensorTypeValue = sensorTypeValue;
	}
	
	@Override
	public String toString() {
		return "SensorValue [sensorSerialNum=" + sensorSerialNum
				+ ", sensorTimestamp=" + sensorTimestamp
				+ ", sensorTimestampStr=" + sensorTimestampStr
				+ ", deviceValue=" + deviceValue + ", sensorTypeValue="
				+ sensorTypeValue + "]";
	}
	
}
