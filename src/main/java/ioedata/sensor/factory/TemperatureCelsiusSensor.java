package ioedata.sensor.factory;

public class TemperatureCelsiusSensor extends TemperatureSensor {

	@Override
	int getSensorType() {
		return Sensor.TYPE_TEMPERATURE_CELSIUS;
	}

}
