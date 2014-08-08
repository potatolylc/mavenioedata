package ioedata.sensor.factory;

public class DustSensor extends Sensor {

	@Override
	public int getSensorType() {
		return Sensor.TYPE_DUST;
	}
}
