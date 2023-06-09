package com.ostphoto.app.admin.photo;


import com.ostphoto.app.admin.IModule;
import com.ostphoto.app.admin.photo.PhotoUtils.PhotoSize;
import com.ostphoto.app.admin.photo.domains.Category;
import com.ostphoto.app.admin.photo.domains.Photo;
import com.ostphoto.app.admin.photo.services.IPhotoService;
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

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.*;



/**
 * Handles requests for the application photo management.
 */
@Controller
@RequestMapping("/admin/photo")
public class PhotoController {
	 
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
		if (Category.ALL.equalsIgnoreCase(catName)) {
			Category allCat = new Category();
			allCat.setName(Category.ALL);
			model.addAttribute("curCat", allCat);
			model.addAttribute("photoList", photoService.getAllPhoto());
		} else if(Category.NONE.equalsIgnoreCase(catName)){			
			List<Photo> photos = photoService.getAllPhoto();
			Category noneCat = new Category();
			noneCat.setName(Category.NONE);
			model.addAttribute("curCat", noneCat); 
			List<Photo> none = new ArrayList<>();
			for(Photo photo : photos) {			
				if(photo.getCategories().isEmpty()) {
					none.add(photo);
				}
			}
			model.addAttribute("photoList", none);
		} else {
			model.addAttribute("photoList",photoService.getPhotosByCatName(catName));
			model.addAttribute("curCat", photoService.getCategotyByName(catName));
		}
		return "admin";
	}
	
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET) 
	public String deletePhoto(@PathVariable("id") Integer id, Locale locale, Model model) throws IOException {
        Photo photo = photoService.getPhotoById(id);
        Resourse.deletePhoto(photo);
        photoService.deletePhoto(photo);
		return "redirect:/admin/photo";
	}
	

	@RequestMapping(value="addcat", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute(value="categoryEdit") Category category, BindingResult result, Model model
) {    
        photoService.addCategory(category);
        model.addAttribute("editOk", "Category " + category.getName() + " has been added");
		return "redirect:/admin/photo";
	}
	

	
	@RequestMapping(method = RequestMethod.POST)
	public String uploadPhoto(@ModelAttribute(value="photoUpForm") UploadPhotoForm photoForm, BindingResult result, Model model
) {
		logger.info("uploadPhoto start");
		Map<Integer,Category> categories = new HashMap<>();
		for (Category cat : photoService.getAllCategories()) categories.put(cat.getId(),cat);
		model.addAttribute(IModule.VIEW_LIST, Arrays.asList(PhotoModule.SMALL_VIEW_NAME, "categoryeditor"));
		upfValidator.validate(photoForm, result);
		if (result.hasErrors()) {
			logger.info("uploadPhoto haserr");
	         model.addAttribute("categoryEdit", new Category());
			 model.addAttribute("photoList",  photoService.getAllPhoto());  
			 model.addAttribute("categoryList", categories.values());
			return "admin";
		}
		try {
			String fileName = Resourse.saveFile(photoForm);
			Photo photo = new Photo();
			photo.setFileName(fileName);
			if (photoForm.getCategory() != null) {
				for (String catId : photoForm.getCategory()) {
					photo.getCategories().add(
							categories.get(Integer.valueOf(catId)));
				}
			}
			photo.setUpdate(Date.valueOf(Resourse.DATE_DIR));	
			photoService.addPhoto(photo);
			model.addAttribute("uploadOk", "Photo " + photoForm.getFile().getOriginalFilename() + " successfully uploaded. " 
	        + photoForm.getCategory());
		} catch (IOException e) {
			logger.error("Upload I/O error: ", e);
	        model.addAttribute("categoryEdit", new Category());
	        model.addAttribute("photoList",  photoService.getAllPhoto());  
			model.addAttribute("categoryList", categories.values());
			result.rejectValue("file", "err1", e.getClass().getName() + ": "
					+ e.getMessage());
		}

		return "redirect:/admin/photo";
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
			ImageIO.write(PhotoUtils.getImage(photoFile, sizeType), "png", baos );
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

