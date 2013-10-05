package com.ostphoto.app.admin.calendar;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ostphoto.app.admin.calendar.domains.MeetingDate;
import com.ostphoto.app.admin.calendar.service.IMeetingDateService;

@Controller
@RequestMapping(value = "/admin")
public class BookingController {

	@Autowired
	private IMeetingDateService meetingDateService;

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
	void controllerMethod(@RequestBody String jsonString)
			throws UnsupportedEncodingException {
		System.err.println("setNewDate!!!");
		String result = URLDecoder.decode(jsonString, "UTF-8");
		System.err.println(result);

		MeetingDate date = new MeetingDate();
		
		Calendar c = new GregorianCalendar();
	    c.set(Calendar.HOUR_OF_DAY, 0); //anything 0 - 23
	    c.set(Calendar.MINUTE, 0);
	    c.set(Calendar.SECOND, 0);
	    Date d1 = c.getTime(); //the midnight, that's the first second of the day.
		
		date.setMeetingDate(d1);
		date.setEndTime("");
		date.setFio("test");
		date.setStartTime("");
		meetingDateService.addMeetingDate(date);
		// System.err.println(new Gson().fromJson(jsonString, String.class));
	}

	// @RequestMapping(value = "/calendar/setNewDate", method =
	// RequestMethod.POST)
	// public @ResponseBody
	// void controllerMethod(@RequestBody String[] myArray){
	// System.err.println("setNewDate!!!");
	// System.err.println(myArray);
	// }

}
