package com.ostphoto.app.admin.photo.dao;


import java.util.List;

import com.ostphoto.app.admin.photo.domains.Photo;

public interface IPhotoDao {
	
	public void addPhoto(Photo photo);
	
	public List<Photo> getAllPhoto();
	


}
