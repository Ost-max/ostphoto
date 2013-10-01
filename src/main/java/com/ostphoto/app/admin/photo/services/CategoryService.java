package com.ostphoto.app.admin.photo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ostphoto.app.admin.photo.dao.ICategoryDao;
import com.ostphoto.app.admin.photo.domains.Category;


@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private ICategoryDao categoryDao;
	
	@Override
    @Transactional
	public void addCategory(Category cathegory) {
		categoryDao.addCategory(cathegory);

	}

	@Override
    @Transactional
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryDao.getAllCategories();
	}

}
