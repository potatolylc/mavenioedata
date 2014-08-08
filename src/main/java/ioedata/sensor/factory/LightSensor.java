package ioedata.sensor.factory;

public class LightSensor extends Sensor {

	@Override
	public int getSensorType() {
		return Sensor.TYPE_LIGHT_BRIGHTNESS;
	}
}
