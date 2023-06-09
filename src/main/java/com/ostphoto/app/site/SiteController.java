package com.ostphoto.app.site;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ostphoto.app.admin.photo.domains.Photo;
import com.ostphoto.app.admin.photo.services.IPhotoService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SiteController {
	
	private static final Logger logger = LoggerFactory.getLogger(SiteController.class);
	
	@Autowired
	private IPhotoService photoService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		List<Photo> photos = photoService.getAllPhoto();
        model.addAttribute("photoList",  photos);  	
        if(photos.size() > 3) {        	
            Collections.reverse(photos);
            model.addAttribute("lastPhotos", photos.subList(0, 4) );  	
        }

		return "index";
	}
	
	
	@RequestMapping(value = "/booking", method = RequestMethod.GET)
	public String booking(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "booking";
	}
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
