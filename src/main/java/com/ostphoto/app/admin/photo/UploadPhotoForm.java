package com.ostphoto.app.admin.photo;

import org.springframework.web.multipart.MultipartFile;

public class UploadPhotoForm  {

	private  MultipartFile file;
	
	private  String category;

	public MultipartFile  getFile() {
		return file;
	}

	public void setFile(MultipartFile  file) {
		this.file = file;
	}

	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}


	

}
