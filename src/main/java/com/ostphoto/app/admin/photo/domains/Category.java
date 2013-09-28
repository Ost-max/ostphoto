package com.ostphoto.app.admin.photo.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	
	
}
