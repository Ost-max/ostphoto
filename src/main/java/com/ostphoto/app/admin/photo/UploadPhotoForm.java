package com.ostphoto.app.admin.photo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class UploadPhotoForm  {

	private  MultipartFile file;
	
	private  List<String> category;

	public MultipartFile  getFile() {
		return file;
	}

	public void setFile(MultipartFile  file) {
		this.file = file;
	}

	public List<String> getCategory() {
		return category;
	}
	
	public void setCategory(List<String> category) {
		this.category = category;
	}


	

}
