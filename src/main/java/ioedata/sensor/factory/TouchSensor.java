package ioedata.sensor.factory;

public class TouchSensor extends Sensor {

	@Override
	public int getSensorType() {
		return Sensor.TYPE_TOUCH;
	}
}
