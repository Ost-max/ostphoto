package com.ostphoto.app.admin.photo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Where;
import org.hibernate.classic.Session;
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
		 Session session = sessionFactory.openSession();
		 session.beginTransaction();
		 session.save(photo);
		 session.getTransaction().commit();
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
	   		return query.list();
	}
	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Photo> getPhotosByCatName(String catName) {
//		 Query query =  sessionFactory.getCurrentSession().createQuery(
//	            " select p "
//                + " from Photo p INNER JOIN p.categories category"
//                + " where category.name = :catName ").setString("catName", catName);
//	   		return query.list();
//	}

	@Override
	public void deletePhoto(Photo photo) {
		// TODO Auto-generated method stub
		 sessionFactory.getCurrentSession().delete(photo);
	}

	@Override
	public Photo getPhotoById(Integer id) {	   
		return  (Photo) sessionFactory.getCurrentSession().get(Photo.class, id);
	}

	@Override
	public Category getCategotyByName(String name) {
		 return  (Category) sessionFactory.getCurrentSession().createQuery("from Category where name=:name")
				 .setString("name", name).uniqueResult();  
	}

	@Override
	public List<Category> getCategoryByPhoto(Photo photo) {
//		(Category) sessionFactory.getCurrentSession().createQuery("from Category where name=:name")
//		 .setString("name", name).uniqueResult();  
		return null;
	}
	




}
