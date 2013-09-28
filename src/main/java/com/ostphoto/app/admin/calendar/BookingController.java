package com.ostphoto.app.admin.calendar;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/admin")
public class BookingController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(BookingController.class);

	@RequestMapping(value = "/calendar/getApprovedDates", method = RequestMethod.GET)
	public @ResponseBody
	String getVacation(HttpServletResponse response) {
		System.err.println("Booking!!!");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 111);
		map.put("title", "event1");
		map.put("start", "2013-9-27");
		map.put("url", "http://yahoo.com/");

		// Convert to JSON string.
		String json = new Gson().toJson(map);

		// Write JSON string.
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		return json;
	}
	
	@RequestMapping(value = "/calendar/setNewDate", method = RequestMethod.POST)
	public @ResponseBody
	void controllerMethod(@RequestBody String jsonString){
	    System.err.println("setNewDate!!!");
	}
}
