package ioedata.sensor.factory;

public class DigitalTiltSensor extends Sensor {

	@Override
	public int getSensorType() {
		return Sensor.TYPE_DIGITAL_TILT;
	}
}
