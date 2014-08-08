package ioedata.sensor.factory;

public class AnalogSoundSensor extends Sensor {

	@Override
	public int getSensorType() {
		return Sensor.TYPE_ANALOG_SOUND;
	}
}
