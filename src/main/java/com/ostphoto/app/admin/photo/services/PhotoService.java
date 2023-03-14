package com.ostphoto.app.admin.photo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ostphoto.app.admin.photo.dao.IPhotoDao;
import com.ostphoto.app.admin.photo.domains.Category;
import com.ostphoto.app.admin.photo.domains.Photo;

@Service
public class PhotoService implements IPhotoService {

	@Autowired
	private IPhotoDao photoDao;

	@Transactional
	@Override
	public void addPhoto(Photo photo) {
		photoDao.addPhoto(photo);
		
	}

	@Transactional
	@Override
	public List<Photo> getAllPhoto() {
		return photoDao.getAllPhoto();
	}
	
	
	@Override
    @Transactional
	public void addCategory(Category cathegory) {
		photoDao.addCategory(cathegory);

	}

	@Override
    @Transactional
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		List<Category> categories =  photoDao.getAllCategories();	
		return categories;
	}

	@Override
    @Transactional
	public List<Photo> getPhotosByCatName(String name) {
		// TODO Auto-generated method stub
		return photoDao.getPhotosByCatName(name);
	}

	@Override
    @Transactional
	public void deletePhoto(Photo photo) {
		photoDao.deletePhoto(photo);
		
	}

	@Override
    @Transactional
	public Photo getPhotoById(Integer id) {
		return photoDao.getPhotoById(id);
	}

	@Override
	   @Transactional
	public Category getCategotyByName(String name) {
		return photoDao.getCategotyByName(name);
	}

//	@Override
//	@Transactional
//	public HashMap<Integer, Category> getCategoriesMap(Integer id) {
//		// TODO Auto-generated method stub
//		return photoDao.getCategoriesMap(id);
//	}
		

}