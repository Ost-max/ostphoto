package com.ostphoto.app.admin.photo;

import org.springframework.web.multipart.MultipartFile;

public class UploadPhotoForm  {

	private  MultipartFile file;
	
	private  String categoryid;

	public MultipartFile  getFile() {
		return file;
	}

	public void setFile(MultipartFile  file) {
		this.file = file;
	}

	public String getCategoryid() {
		return categoryid;
	}
	
	public void setCategoryid(String categoryId) {
		this.categoryid = categoryId;
	}


	

}
