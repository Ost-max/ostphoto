package com.ostphoto.app.admin.photo;

import java.util.HashMap;
import java.util.Map;

import com.ostphoto.app.admin.IModule;
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
        attrs.put("categoryList", photoService.getAllCategories());
		return attrs;
	}



	









}
