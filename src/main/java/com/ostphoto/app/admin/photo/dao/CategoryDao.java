package com.ostphoto.app.admin.photo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ostphoto.app.admin.photo.domains.Category;

@Repository
public class CategoryDao  implements ICategoryDao {
	
    @Autowired
    private SessionFactory sessionFactory;

	@Override
    public void addCategory(Category category) {
        sessionFactory.getCurrentSession().save(category);
    }



	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategories() {
	     return sessionFactory.getCurrentSession().createQuery("from Category")
	             .list();
	}

}
