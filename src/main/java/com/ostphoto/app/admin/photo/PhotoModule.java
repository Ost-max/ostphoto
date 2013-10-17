package com.ostphoto.app.admin.photo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ostphoto.app.admin.IModule;
import com.ostphoto.app.admin.photo.domains.Category;
import com.ostphoto.app.admin.photo.services.IPhotoService;


public class PhotoModule implements IModule {
	
   final static String SMALL_VIEW_NAME = "photoup";
   final static String VIEW_NAME = "photo";
   
 
	private IPhotoService photoService;

	
	public PhotoModule(IPhotoService photoService) {
		this.photoService = photoService;
	}
	

	@Override
	public String getSmallViewName() {
		return  SMALL_VIEW_NAME;
	}

	@Override
	public Map<String, ?> getSmallAttributes() {
		Map<String, Object> attrs = new HashMap<String, Object>();
		attrs.put(VIEW_NAME + "UpForm", new UploadPhotoForm());
		List<Category> categories = photoService.getAllCategories();
//		Category allCategory = new Category();
//		allCategory.setName("all");
//		categories.add(allCategory);	
        attrs.put("categoryList", categories);
		return attrs;
	}



	









}
