package com.ostphoto.app.admin.photo;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.ostphoto.app.admin.IModule;
import com.ostphoto.app.admin.photo.domains.Category;
import com.ostphoto.app.admin.photo.domains.Photo;
import com.ostphoto.app.admin.photo.services.ICategoryService;


public class PhotoModule implements IModule {
	
   final static String SMALL_VIEW_NAME = "photoup";
   final static String VIEW_NAME = "photo";
   
 
	private ICategoryService categoryService;

	
	public PhotoModule(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}
	

	@Override
	public String getSmallViewName() {
		return  SMALL_VIEW_NAME;
	}

	@Override
	public Map<String, ?> getSmallAttributes() {
		Map<String, Object> attrs = new HashMap<String, Object>();
		attrs.put(VIEW_NAME + "UpForm", new UploadPhotoForm());
        attrs.put("categoryList", categoryService.getAllCategories());
		return attrs;
	}



	









}
