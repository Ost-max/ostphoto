package com.ostphoto.app.admin.photo.dao;


import java.util.List;

import com.ostphoto.app.admin.photo.domains.Category;

public interface ICategoryDao {
	
	public void addCategory(Category cathegory);
		
	public List<Category> getAllCategories();
	


}
