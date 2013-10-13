package com.ostphoto.app.admin.photo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ostphoto.app.admin.photo.domains.Category;
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




	@SuppressWarnings("unchecked")
	@Override
	public List<Photo> getPhotosByCatName(String catName) {
		 Query query =  sessionFactory.getCurrentSession().createQuery(
	            " select p "
                + " from Photo p INNER JOIN p.categories category"
                + " where category.name = :catName ").setString("catName", catName);
	   
	   
//		Long driver_id = driver.getId();
//	    Query query = session.createQuery(
//	            " select b "
//	                + " from Bus b INNER JOIN b.drivers driver"
//	                + " where driver.id = :driverId "
//	        )
//	            .setLong(«driverId», driver_id);
//	        busses = (List<Bus>) query.list();
		return query.list();
	}


}
