package com.ostphoto.app.admin.photo.services;

import java.util.List;

import com.ostphoto.app.admin.photo.domains.Category;

public interface ICategoryService {
	
	public void addCategory(Category cathegory);
	
	public List<Category> getAllCathegories();

}
