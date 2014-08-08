package ioedata.sensor.factory;

public class TemperatureFahrenheitSensor extends TemperatureSensor {

	@Override
	int getSensorType() {
		return Sensor.TYPE_TEMPERATURE_FAHRENHEIT;
	}

}
