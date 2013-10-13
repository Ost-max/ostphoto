package com.ostphoto.app.admin.photo;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;
import java.util.Locale;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ostphoto.app.admin.IModule;
import com.ostphoto.app.admin.photo.PhotoUtils.PhotoSize;
import com.ostphoto.app.admin.photo.domains.Category;
import com.ostphoto.app.admin.photo.domains.Photo;
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
	private IPhotoService photoService;
		

	@RequestMapping(method = RequestMethod.GET)
	public String start(Locale locale, Model model) {
        model.addAttribute(IModule.VIEW_LIST, Arrays.asList(PhotoModule.SMALL_VIEW_NAME, "categoryeditor"));
        model.addAllAttributes(new PhotoModule(photoService).getSmallAttributes());  
        model.addAttribute("categoryEdit", new Category());
        model.addAttribute("photoList",  photoService.getAllPhoto());  
        return "admin";
	}
	
	
	@RequestMapping(value="/{cat}", method = RequestMethod.GET)
	public String getPhotosByCat(@PathVariable("cat") String catName, Locale locale, Model model) {
        model.addAttribute(IModule.VIEW_LIST, Arrays.asList(PhotoModule.SMALL_VIEW_NAME, "categoryeditor"));
        model.addAllAttributes(new PhotoModule(photoService).getSmallAttributes());  
        model.addAttribute("categoryEdit", new Category());
        model.addAttribute("photoList",  photoService.getPhotosByCatName(catName));  
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
//	        model.addAllAttributes(new PhotoModule(photoService).getSmallAttributes());  
//	        model.addAttribute("categoryEdit", new Category());
//	        model.addAttribute("photoList",  photoService.getAllPhoto());
//	        return "admin";
//		
//	}   


	@RequestMapping(value="addcat", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute(value="categoryEdit") Category category, BindingResult result, Model model
) {     model.addAttribute(IModule.VIEW_LIST, Arrays.asList(PhotoModule.SMALL_VIEW_NAME, "categoryeditor"));
        photoService.addCategory(category);
        model.addAllAttributes(new PhotoModule(photoService).getSmallAttributes());  
        model.addAttribute("editOk", "Category " + category.getName() + " has been added");
		return "admin";
	}
	

	
	@RequestMapping(method = RequestMethod.POST)
	public String uploadPhoto(@ModelAttribute(value="photoUpForm") UploadPhotoForm photoForm, BindingResult result, Model model
) {
		logger.info("uploadPhoto start");
		model.addAttribute(IModule.VIEW_LIST, Arrays.asList(PhotoModule.SMALL_VIEW_NAME, "categoryeditor"));
		model.addAttribute("categoryList", photoService.getAllCategories());
        model.addAttribute("categoryEdit", new Category());
		upfValidator.validate(photoForm, result);
		if (result.hasErrors()) {
			logger.info("uploadPhoto haserr");
			return "admin";
		}
		try {
			String fileName = Resourse.saveFile(photoForm);
			Photo photo = new Photo();
			photo.setFileName(fileName);
			photo.setUpdate(Date.valueOf(Resourse.DATE_DIR));
			photoService.addPhoto(photo);
	        model.addAttribute("photoList",  photoService.getAllPhoto());  
			model.addAttribute("uploadOk", "Photo " + photoForm.getFile().getOriginalFilename() + " successfully uploaded.");
			
		} catch (IOException e) {
			logger.error("Upload I/O error: ", e);
			result.rejectValue("file", "err1", e.getClass().getName() + ": "
					+ e.getMessage());
		}
		return "admin";
	}

	
	@RequestMapping(value = "/{size}/{date}/{name}.{ext}",  method = RequestMethod.GET,  produces = {"image/jpeg"})
	public ResponseEntity<byte[]> getPhoto(  @PathVariable("size") String size, @PathVariable("date") final String date, 
			@PathVariable("name") final String name, 
			@PathVariable("ext") final String ext) {
		try {
		byte[] result;		
		size = size.toUpperCase();
		PhotoSize sizeType;
		sizeType = PhotoSize.valueOf(size);	
		File photoFile =  Resourse.getPhotoFile(date, name + "." + ext);
		if(PhotoSize.ORIGINAL.equals(sizeType)) {		  
			result =  IOUtils.toByteArray(new FileInputStream(photoFile));	
		} else {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(PhotoUtils.getImage(photoFile, sizeType), "jpg", baos );
			baos.flush();
			result =  baos.toByteArray();
			baos.close();			
		}
		 return new ResponseEntity<byte[]>(result, HttpStatus.OK);
		} catch(IllegalArgumentException  | IOException ex) {
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}	
	}


	

     
	

}

