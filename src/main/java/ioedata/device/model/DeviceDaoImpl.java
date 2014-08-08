package ioedata.device.model;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DeviceDaoImpl implements DeviceDao {
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	@Override
	public DeviceValue getBasicDeviceInfoByDeviceId(String deviceId) throws Exception {
		return this.template.selectOne("device.getBasicDeviceInfoByDeviceId", deviceId);
	}

	@Override
	public int insertDevice(DeviceValue deviceVal) throws Exception {
		return this.template.insert("device.insertDevice", deviceVal);
	}

	@Override
	public int getDeviceCountByDeviceId(String deviceId) throws Exception {
		return this.template.selectOne("device.getDeviceCountByDeviceId", deviceId);
	}

	@Override
	public int getDeviceCountByDeviceIp(String deviceIp) throws Exception {
		return this.template.selectOne("device.getDeviceCountByDeviceIp", deviceIp);
	}

	@Override
	public int getDeviceCountByDeviceIdAndDeviceIpAndDevicePassword(
			DeviceValue deviceVal) throws Exception {
		return this.template.selectOne("device.getDeviceCountByDeviceIdAndDeviceIpAndDevicePassword", deviceVal);
	}
}