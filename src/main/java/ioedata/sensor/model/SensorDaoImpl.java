package ioedata.sensor.model;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SensorDaoImpl implements SensorDao {
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate template;	

	@Override
	public SensorValue getBasicSensorInfoByDeviceIdAndSensorTypeNum(
			SensorValue sensorVal) throws Exception {
		return this.template.selectOne("sensor.getBasicSensorInfoByDeviceIdAndSensorTypeNum", sensorVal);
	}

	@Override
	public List<SensorValue> getBasicSensorInfoListByDeviceId(String deviceId) throws Exception {
		return this.template.selectList("sensor.getBasicSensorInfoListByDeviceId", deviceId);
	}

	@Override
	public int insertSensor(SensorValue sensorVal) throws Exception {
		return this.template.insert("sensor.insertSensor", sensorVal);
	}
}