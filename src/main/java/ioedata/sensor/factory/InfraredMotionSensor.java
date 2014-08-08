package ioedata.sensor.factory;

public class InfraredMotionSensor extends Sensor {

	@Override
	public int getSensorType() {
		return Sensor.TYPE_INFRARED_MOTION;
	}

}
