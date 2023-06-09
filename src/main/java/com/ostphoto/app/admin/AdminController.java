package com.ostphoto.app.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ostphoto.app.admin.photo.PhotoModule;
import com.ostphoto.app.admin.photo.services.IPhotoService;



/**
 * Handles requests for the application admin panel.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private IPhotoService photoService;
	
	/**
	 * Simply selects the admin view to render by returning its name.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String start(Locale locale, Model model) {
		logger.info("Admin panel is loaded", locale);
        List<String> views = new ArrayList<String>();
        IModule photo = new PhotoModule(photoService);
        views.add(photo.getSmallViewName());
//        model.addAttribute("debugInfo", System.getenv("VCAP_SERVICES"));
        model.addAttribute(IModule.VIEW_LIST, views);
        model.addAllAttributes(photo.getSmallAttributes());  
		return "admin";
	}
	



	
	
	
}




