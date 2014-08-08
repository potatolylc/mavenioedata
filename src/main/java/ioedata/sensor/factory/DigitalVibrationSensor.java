package ioedata.sensor.factory;

public class DigitalVibrationSensor extends Sensor {

	@Override
	public int getSensorType() {
		return Sensor.TYPE_DIGITAL_VIBRATION;
	}

}
