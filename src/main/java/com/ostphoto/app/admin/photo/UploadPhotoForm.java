package com.ostphoto.app.admin.photo;

import org.springframework.web.multipart.MultipartFile;

public class UploadPhotoForm  {

	private  MultipartFile file;

	public MultipartFile  getFile() {
		return file;
	}

	public void setFile(MultipartFile  file) {
		this.file = file;
	}


	

}