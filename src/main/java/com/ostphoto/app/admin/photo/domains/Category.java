package com.ostphoto.app.admin.photo.domains;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="Category")
public class Category {

	
	@Id
    @Column(name = "ID")
    @GeneratedValue
	private int id;
	
    @Column(name = "name")
	private String name;
    
    
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="Photo_Cat", joinColumns={@JoinColumn(name="Cat")}, 
            inverseJoinColumns={@JoinColumn(name="Photo")})
    private Set<Photo> photos;

    
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
