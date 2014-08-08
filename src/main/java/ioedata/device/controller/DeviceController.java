package ioedata.device.controller;

import ioedata.device.model.DeviceValue;
import ioedata.device.service.DeviceService;

import javax.annotation.Resource;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * This class is the controller for requests and responses about device services,
 * such as register new devices or authenticate existing devices with device ID and password.
 * @author ajou
 *
 */
@Controller
@RequestMapping(value = "/device")
public class DeviceController {
	@Resource(name = "deviceServiceImpl")
	private DeviceService deviceService;

	@RequestMapping(value = "/register/{deviceId}/{deviceIp}/{deviceIpPort}/{devicePassword}", method = RequestMethod.POST)
	@ResponseBody
	public String deviceRegistration(@PathVariable("deviceId") String deviceId, @PathVariable("deviceIp") String deviceIp, @PathVariable("deviceIpPort") int deviceIpPort, @PathVariable("devicePassword") String devicePassword) throws JSONException{
		System.out.println("deviceRegistration: "+deviceId+" "+deviceIp+" "+deviceIpPort+" "+devicePassword);
		boolean flag = false;
		String msg = null;
		try {
			flag = this.deviceService.deviceRegistration(new DeviceValue(deviceIp, deviceIpPort, deviceId, devicePassword));
			if(flag)
				msg = "Device has been registerd.";
			else
				msg = "Something goes wrong with device registration. Please check whether the device IP is in use, or try changing another device ID.";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JSONObject().put("result", flag).put("message", msg).toString();
	}
	
	@RequestMapping(value = "/authentication/{deviceId}/{deviceIp}/{deviceIpPort}/{devicePassword}", method = RequestMethod.POST)
	@ResponseBody
	public String deviceAuthentication(@PathVariable("deviceId") String deviceId,  @PathVariable("deviceIp") String deviceIp, @PathVariable("deviceIpPort") int deviceIpPort, @PathVariable("devicePassword") String devicePassword) throws JSONException{
		System.out.println("deviceAuthentication: "+deviceId+" "+deviceIp+" "+deviceIpPort+" "+devicePassword);
		boolean flag = false;
		String msg = null;
		try {
			int result = this.deviceService.deviceAuthentication(new DeviceValue(deviceIp, deviceIpPort, deviceId, devicePassword));
			if(result == 1){
				flag = true;
				msg = "Device authenticated successfully.";
			}else{
				msg = "Device authentication failed. Please check the device ID and password again.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JSONObject().put("result", flag).put("message", msg).toString();
	}	
}