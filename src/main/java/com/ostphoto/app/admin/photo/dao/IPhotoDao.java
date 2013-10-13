package com.ostphoto.app.admin.photo.dao;


import java.util.List;

import com.ostphoto.app.admin.photo.domains.Category;
import com.ostphoto.app.admin.photo.domains.Photo;

public interface IPhotoDao {
	
	public void addPhoto(Photo photo);
	
	public List<Photo> getAllPhoto();

	
	public void addCategory(Category category);
			
	public List<Category> getAllCategories();
	
    public List<Photo> getPhotosByCatName(String name);

	


}
