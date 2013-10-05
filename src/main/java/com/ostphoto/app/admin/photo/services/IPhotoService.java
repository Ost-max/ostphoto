package com.ostphoto.app.admin.photo.services;

import java.util.List;

import com.ostphoto.app.admin.photo.domains.Photo;

public interface IPhotoService {

   public void addPhoto(Photo photo);
	
	public List<Photo> getAllPhoto();
}
