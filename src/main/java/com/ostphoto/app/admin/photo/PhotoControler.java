package com.ostphoto.app.admin.photo;


import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.jar.Attributes.Name;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ostphoto.app.Resourse;
import com.ostphoto.app.admin.IModule;
import com.ostphoto.app.admin.photo.domains.Category;
import com.ostphoto.app.admin.photo.domains.Photo;
import com.ostphoto.app.admin.photo.services.ICategoryService;
import com.ostphoto.app.admin.photo.services.IPhotoService;





/**
 * Handles requests for the application photo management.
 */
@Controller
@RequestMapping("/admin/photo")
public class PhotoControler {
	
	private static final Logger logger = LoggerFactory.getLogger(PhotoModule.class);
	
	@Autowired
	private UploadPhotoFormValidator upfValidator;	
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private IPhotoService photoService;
		

	@RequestMapping(method = RequestMethod.GET)
	public String start(Locale locale, Model model) {
        model.addAttribute(IModule.VIEW_LIST, Arrays.asList(PhotoModule.SMALL_VIEW_NAME, "categoryeditor"));
        model.addAllAttributes(new PhotoModule(categoryService).getSmallAttributes());  
        model.addAttribute("categoryEdit", new Category());
        model.addAttribute("editOk", Resourse.getOriginalPhotoDirPaths().toString());
        model.addAttribute("photoList",  photoService.getAllPhoto());  
        return "admin";
	}
	
//	@RequestMapping(value="test/{paths}", method = RequestMethod.GET)
//	public String test( @PathVariable("paths") final String paths, Locale locale, Model model) throws IOException {
//		String[] splitted = paths.split("_");
//		List<String> splarr = Arrays.asList(splitted);
//	    List<String> respaths = new ArrayList<String>();
//		 Path dir = Paths.get(Resourse.ROOT_DIR);
//			respaths.add(" #" + dir.toString() + "# ");
//		if(!splarr.contains("nulle")){
//			dir = Paths.get(Resourse.ROOT_DIR, splitted);
//		} 		
//
//	     DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
//	        for (Path file: stream) {
//	        	respaths.add(file.getFileName().toString());
//	        }
//	        model.addAttribute("editOk", respaths);
//	        model.addAttribute(IModule.VIEW_LIST, Arrays.asList(PhotoModule.SMALL_VIEW_NAME, "categoryeditor"));
//	        model.addAllAttributes(new PhotoModule(categoryService).getSmallAttributes());  
//	        model.addAttribute("categoryEdit", new Category());
//	        model.addAttribute("photoList",  photoService.getAllPhoto());
//	        return "admin";
//		
//	}   


	@RequestMapping(value="addcat", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute(value="categoryEdit") Category category, BindingResult result, Model model
) {     model.addAttribute(IModule.VIEW_LIST, Arrays.asList(PhotoModule.SMALL_VIEW_NAME, "categoryeditor"));
        model.addAllAttributes(new PhotoModule(categoryService).getSmallAttributes());  
        categoryService.addCategory(category);
        model.addAttribute("editOk", "Category " + category.getName() + " has been added");
		return "admin";
	}
	

	
	@RequestMapping(method = RequestMethod.POST)
	public String uploadPhoto(@ModelAttribute(value="photoUpForm") UploadPhotoForm photoForm, BindingResult result, Model model
) {
		logger.info("uploadPhoto start");
		model.addAttribute(IModule.VIEW_LIST, Arrays.asList(PhotoModule.SMALL_VIEW_NAME, "categoryeditor"));
		model.addAttribute("categoryList", categoryService.getAllCategories());
        model.addAttribute("categoryEdit", new Category());
		upfValidator.validate(photoForm, result);
		if (result.hasErrors()) {
			logger.info("uploadPhoto haserr");
			return "admin";
		}
		try {
			String fileName = PhotoModule.saveFile(photoForm);
			Photo photo = new Photo();
			photo.setFileName(fileName);
			photo.setUpdate(Date.valueOf(Resourse.DATE_DIR));
			photoService.addPhoto(photo);
			model.addAttribute("uploadOk", "Photo " + photoForm.getFile().getOriginalFilename() + " successfully uploaded.");
			
		} catch (IOException e) {
			logger.error("Upload I/O error: ", e);
			result.rejectValue("file", "err1", e.getClass().getName() + ": "
					+ e.getMessage());
		}
		return "admin";
	}

	@RequestMapping(value = "/original/{date}/{name}.{ext}",  method = RequestMethod.GET,  produces = {"image/jpeg"})
	public ResponseEntity<byte[]> getPhoto( @PathVariable("date") final String date, 
			@PathVariable("name") final String name, 
			@PathVariable("ext") final String ext) throws IOException {
	
		 return new ResponseEntity<byte[]>(Resourse.getPhotoFile(date, name + "." + ext), HttpStatus.OK);		
	}


	

}

