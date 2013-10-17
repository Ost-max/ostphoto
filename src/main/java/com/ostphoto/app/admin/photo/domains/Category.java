package com.ostphoto.app.admin.photo.domains;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="Category")
public class Category {

	public static String ALL = "all";
	
	@Id
    @Column(name = "ID")
    @GeneratedValue
	private int id;
	
    @Column(name = "name")
	private String name;
    
    
	@ManyToMany(mappedBy="categories") 
    private Set<Photo> photos = new HashSet<>();

    
	public Set<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	
	public String toString() {
		return name;
	}
	
	
	
}
