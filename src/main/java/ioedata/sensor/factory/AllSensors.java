package ioedata.sensor.factory;

public class AllSensors extends Sensor {

	@Override
	public int getSensorType() {
		return Sensor.TYPE_ALL;
	}
}
