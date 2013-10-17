package com.ostphoto.app.admin.photo.services;

import java.util.List;

import com.ostphoto.app.admin.photo.domains.Category;
import com.ostphoto.app.admin.photo.domains.Photo;

public interface IPhotoService {

   public void addPhoto(Photo photo);
	
   public List<Photo> getAllPhoto();
	
   public void addCategory(Category cathegory);
	
   public List<Category> getAllCategories();

   public List<Photo> getPhotosByCatName(String name);
      
//   public HashMap<Integer, Category> getCategoriesMap(Integer id);
}
