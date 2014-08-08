package ioedata.sensor.controller;

import ioedata.sensor.service.SensorService;

import javax.annotation.Resource;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * This class is the controller for requests and responses about sensor services,
 * such as add or remove sensors attached to devices.
 * @author ajou
 *
 */
@Controller
@RequestMapping(value = "/sensor")
public class SensorController {
	@Resource(name = "sensorServiceImpl")
	SensorService sensorService;
	
	@RequestMapping(value = "/register/{deviceId}/{sensorType}", method = RequestMethod.POST)
	@ResponseBody
	public String sensorRegistration(@PathVariable("deviceId") String deviceId, @PathVariable("sensorType") String sensorType) throws JSONException{
		System.out.println("sensorRegistration: "+deviceId+" "+sensorType);
		boolean flag = false;
		String msg = null;
		try {
			flag = this.sensorService.sensorRegistration(deviceId, sensorType);
			if(flag)
				msg = "Sensor registered successfully.";
			else
				msg = "Something goes wrong with sensor registration. Please check whether the sensor has already been registered to the same device.";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JSONObject().put("result", flag).put("message", msg).toString();
	}
}