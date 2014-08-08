package ioedata.sensor.config;

import ioedata.sensor.factory.Sensor;

public class TypeFormat {
	public static int sensorTypeUrlFormat(String sensorType){
		int sensorTypeNum = -1;
		if(sensorType.equals("all")){
			sensorTypeNum = Sensor.TYPE_ALL;
		} else if(sensorType.equals("analogsound")){
			sensorTypeNum = Sensor.TYPE_ANALOG_SOUND;
		} else if(sensorType.equals("dust")){
			sensorTypeNum = Sensor.TYPE_DUST;
		} else if(sensorType.equals("flame")){
			sensorTypeNum = Sensor.TYPE_FLAME;
		} else if(sensorType.equals("humidity")){
			sensorTypeNum = Sensor.TYPE_HUMIDITY;
		} else if(sensorType.equals("lightbrightness")){
			sensorTypeNum = Sensor.TYPE_LIGHT_BRIGHTNESS;
		} else if(sensorType.equals("raindrop")){
			sensorTypeNum = Sensor.TYPE_RAINDROP;
		} else if(sensorType.equals("temperaturecelsius")){
			sensorTypeNum = Sensor.TYPE_TEMPERATURE_CELSIUS;
		} else if(sensorType.equals("temperaturefahrenheit")){
			sensorTypeNum = Sensor.TYPE_TEMPERATURE_FAHRENHEIT;
		} else if(sensorType.equals("accelerometer")){
			sensorTypeNum = Sensor.TYPE_ACCELEROMETER;
		} else if(sensorType.equals("digitaltilt")){
			sensorTypeNum = Sensor.TYPE_DIGITAL_TILT;
		} else if(sensorType.equals("digitalvibration")){
			sensorTypeNum = Sensor.TYPE_DIGITAL_VIBRATION;
		} else if(sensorType.equals("infraredmotion")){
			sensorTypeNum = Sensor.TYPE_INFRARED_MOTION;
		} else if(sensorType.equals("touch")){
			sensorTypeNum = Sensor.TYPE_TOUCH;
		}
		return sensorTypeNum;
	}
	
	public static String sensorTypeResponseJsonKeyFormat(String sensorType){
		if(sensorType.equals("ANALOG_SOUND")){
			return "analogsound";
		} else if(sensorType.equals("DUST")){
			return "dust";
		} else if(sensorType.equals("FLAME")){
			return "flame";
		} else if(sensorType.equals("HUMIDITY")){
			return "humidity";
		} else if(sensorType.equals("LIGHT_BRIGHTNESS")){
			return "lightbrightness";
		} else if(sensorType.equals("RAINDROP")){
			return "raindrop";
		} else if(sensorType.equals("TEMPERATURE_CELSIUS")){
			return "temperaturecelsius";
		} else if(sensorType.equals("TEMPERATURE_FAHRENHEIT")){
			return "temperaturefahrenheit";
		} else if(sensorType.equals("ACCELEROMETER")){
			return "accelerometer";
		} else if(sensorType.equals("DIGITAL_TILT")){
			return "digitaltilt";
		} else if(sensorType.equals("DIGITAL_VIBRATION")){
			return "digitalvibration";
		} else if(sensorType.equals("INFRARED_MOTION")){
			return "infraredmotion";
		} else if(sensorType.equals("TOUCH")){
			return "touch";
		}
		return null;
	}
	
	public static int dataCollectionIntervalFormat(String dataCollectionIntervalType){
		int dataCollectionInterval = -1;
		if(dataCollectionIntervalType.equals("realtime"))
			dataCollectionInterval = Sensor.DATA_COLLECTION_INTERVAL_REAL_TIME;
		else if(dataCollectionIntervalType.equals("rapid"))
			dataCollectionInterval = Sensor.DATA_COLLECTION_INTERVAL_RAPID;
		else if(dataCollectionIntervalType.equals("medium"))
			dataCollectionInterval = Sensor.DATA_COLLECTION_INTERVAL_MEDIUM;
		else if(dataCollectionIntervalType.equals("slow"))
			dataCollectionInterval = Sensor.DATA_COLLECTION_INTERVAL_SLOW;
		else if(dataCollectionIntervalType.equals("single"))
			dataCollectionInterval = Sensor.DATA_COLLECTION_INTERVAL_SINGLE;
		return dataCollectionInterval;
	}
}