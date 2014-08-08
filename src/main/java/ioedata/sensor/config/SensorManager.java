package ioedata.sensor.config;

import ioedata.sensor.factory.AccelerometerSensor;
import ioedata.sensor.factory.AllSensors;
import ioedata.sensor.factory.AnalogSoundSensor;
import ioedata.sensor.factory.DigitalTiltSensor;
import ioedata.sensor.factory.DigitalVibrationSensor;
import ioedata.sensor.factory.DustSensor;
import ioedata.sensor.factory.FlameSensor;
import ioedata.sensor.factory.HumiditySensor;
import ioedata.sensor.factory.InfraredMotionSensor;
import ioedata.sensor.factory.LightSensor;
import ioedata.sensor.factory.RaindropSensor;
import ioedata.sensor.factory.Sensor;
import ioedata.sensor.factory.TemperatureCelsiusSensor;
import ioedata.sensor.factory.TemperatureFahrenheitSensor;
import ioedata.sensor.factory.TouchSensor;


public final class SensorManager {
	private SensorManager() {
	}

	private static SensorManager sensorManager = new SensorManager();

	public static SensorManager getSensorManager() {
		return sensorManager;
	}

	public Sensor getSensor(int sensorType) {
		if (sensorType == Sensor.TYPE_ALL) {
			AllSensors sensor = new AllSensors();
			return sensor;
		} else if (sensorType == Sensor.TYPE_ACCELEROMETER) {
			AccelerometerSensor sensor = new AccelerometerSensor();
			return sensor;
		} else if (sensorType == Sensor.TYPE_ANALOG_SOUND) {
			AnalogSoundSensor sensor = new AnalogSoundSensor();
			return sensor;
		} else if (sensorType == Sensor.TYPE_DIGITAL_TILT) {
			DigitalTiltSensor sensor = new DigitalTiltSensor();
			return sensor;
		} else if (sensorType == Sensor.TYPE_DIGITAL_VIBRATION) {
			DigitalVibrationSensor sensor = new DigitalVibrationSensor();
			return sensor;
		} else if (sensorType == Sensor.TYPE_DUST) {
			DustSensor sensor = new DustSensor();
			return sensor;
		} else if (sensorType == Sensor.TYPE_FLAME) {
			FlameSensor sensor = new FlameSensor();
			return sensor;
		} else if (sensorType == Sensor.TYPE_HUMIDITY) {
			HumiditySensor sensor = new HumiditySensor();
			return sensor;
		} else if (sensorType == Sensor.TYPE_INFRARED_MOTION) {
			InfraredMotionSensor sensor = new InfraredMotionSensor();
			return sensor;
		} else if (sensorType == Sensor.TYPE_LIGHT_BRIGHTNESS) {
			LightSensor sensor = new LightSensor();
			return sensor;
		} else if (sensorType == Sensor.TYPE_RAINDROP) {
			RaindropSensor sensor = new RaindropSensor();
			return sensor;
		} else if (sensorType == Sensor.TYPE_TEMPERATURE_CELSIUS) {
			TemperatureCelsiusSensor sensor = new TemperatureCelsiusSensor();
			return sensor;
		} else if (sensorType == Sensor.TYPE_TEMPERATURE_FAHRENHEIT) {
			TemperatureFahrenheitSensor sensor = new TemperatureFahrenheitSensor();
			return sensor;
		} else if (sensorType == Sensor.TYPE_TOUCH) {
			TouchSensor sensor = new TouchSensor();
			return sensor;
		} 
		return null;
	}

}
