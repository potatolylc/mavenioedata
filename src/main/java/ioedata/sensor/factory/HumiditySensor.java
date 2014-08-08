package ioedata.sensor.factory;

public class HumiditySensor extends Sensor {

	@Override
	public int getSensorType() {
		return Sensor.TYPE_HUMIDITY;
	}
}
