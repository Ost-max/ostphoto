package com.ostphoto.app.admin.photo;

import java.util.List;

import com.ostphoto.app.admin.photo.domains.Category;

public class CategoryForm {
	
	private List<Category> categories;

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
