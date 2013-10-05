package com.ostphoto.app.admin.photo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ostphoto.app.admin.photo.domains.Photo;


@Repository
public class PhotoDao implements IPhotoDao {

	
    @Autowired
    private SessionFactory sessionFactory;
    
    
	@Override
	public void addPhoto(Photo photo) {
		sessionFactory.getCurrentSession().save(photo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Photo> getAllPhoto() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Photo")
	             .list();
	}

}
