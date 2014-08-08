package ioedata.device.service;

import ioedata.device.model.DeviceDao;
import ioedata.device.model.DeviceValue;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeviceServiceImpl implements DeviceService {
	@Resource(name = "deviceDaoImpl")
	DeviceDao deviceDao;

	@Override
	public DeviceValue getBasicDeviceInfoByDeviceId(String deviceId)  throws Exception{
		return this.deviceDao.getBasicDeviceInfoByDeviceId(deviceId);
	}

	@Override
	@Transactional
	public boolean deviceRegistration(DeviceValue deviceVal)  throws Exception{
		//int isIpExist = this.checkDeviceIpExist(deviceVal.getDeviceIp());
		int isIdExist = this.checkDeviceIdExist(deviceVal.getDeviceId());
		if(isIdExist == 0){
		//if(isIpExist == 0 && isIdExist == 0){
			int result = this.deviceDao.insertDevice(deviceVal);
			if(result == 1){
				return true;
			}
		}
		return false;
	}

	@Override
	public int checkDeviceIpExist(String deviceIp) throws Exception {
		return this.deviceDao.getDeviceCountByDeviceIp(deviceIp);
	}

	@Override
	public int checkDeviceIdExist(String deviceId) throws Exception {
		return this.deviceDao.getDeviceCountByDeviceId(deviceId);
	}

	@Override
	public int deviceAuthentication(DeviceValue deviceVal) throws Exception {
		return this.deviceDao.getDeviceCountByDeviceIdAndDeviceIpAndDevicePassword(deviceVal);
	}
}