package com.ostphoto.app.admin.photo;


import java.io.IOException;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ostphoto.app.admin.IModule;



/**
 * Handles requests for the application photo management.
 */
@Controller
@RequestMapping("/admin/photo")
public class PhotoControler {
	
	private static final Logger logger = LoggerFactory.getLogger(PhotoModule.class);
	
	@Autowired
	private UploadPhotoFormValidator upfValidator;
		

	@RequestMapping(method = RequestMethod.GET)
	public String start(Locale locale, Model model) {
        model.addAttribute(IModule.VIEW_LIST, PhotoModule.VIEW_NAME);
        model.addAttribute(PhotoModule.VIEW_NAME + "UpForm", new UploadPhotoForm());
		return "admin";
	}
	

	
	@RequestMapping(method = RequestMethod.POST)
	public String uploadPhoto(@ModelAttribute(value="photoUpForm") UploadPhotoForm photo, BindingResult result, Model model
) {
		logger.info("uploadPhoto start");
        model.addAttribute(IModule.VIEW_LIST, PhotoModule.VIEW_NAME);
		upfValidator.validate(photo, result);
		if (result.hasErrors()) {
			logger.info("uploadPhoto haserr");
			return "admin";
		}
		try {
			String finalPath = PhotoModule.saveFile(photo);
			PhotoModule.writeToDB(finalPath, photo);
			model.addAttribute("uploadOk", "Photo " + photo.getFile().getOriginalFilename() + " successfully uploaded.");
		} catch (IOException e) {
			logger.error("Upload I/O error: ", e);
			result.rejectValue("file", "err1", e.getClass().getName() + ": "
					+ e.getMessage());
		}
		return "admin";
	}



	

}
