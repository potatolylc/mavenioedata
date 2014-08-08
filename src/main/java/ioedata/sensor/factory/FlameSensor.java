package ioedata.sensor.factory;

public class FlameSensor extends Sensor {

	@Override
	public int getSensorType() {
		return Sensor.TYPE_FLAME;
	}
}
