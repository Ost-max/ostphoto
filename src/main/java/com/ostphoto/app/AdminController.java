package com.ostphoto.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 * Handles requests for the application admin panel.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the admin view to render by returning its name.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String start(Locale locale, Model model) {
		logger.info("Admin panel is loaded", locale);
		model.addAttribute("uploadPhoto", new UploadPhotoForm());
		return "admin";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String uploadPhoto(UploadPhotoForm photo, BindingResult bindingResult,
			Model model ) {
		model.addAttribute("uploadPhoto", new UploadPhotoForm());
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("error", bindingResult.getAllErrors().get(0));
			return "admin";
		}
	
		
	    MultipartFile file = photo.getFile();
		if (file.isEmpty()) {
			model.addAttribute("uploadError", "empty file");
		}
		try {
			if (!Files.isDirectory(Paths.get("resourse"))) {
				Files.createDirectory(Paths.get("resourse"));
			}
			Path path = Files.createFile(Paths.get(new Date().toString()
					.replace(":", ".") + "_" + file.getOriginalFilename()));
			Files.write(path, file.getBytes());
			model.addAttribute("uploadOk", "true");
		} catch (IOException e) {
			model.addAttribute("uploadError", file.getContentType());
		}
		return "admin";
	}
}
