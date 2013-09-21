package com.ostphoto.app.admin.photo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;





@Entity
public class Photo {

	@Id
    @Column(name = "ID")
    @GeneratedValue
	private int id;
	
	@Column(name = "")
	private List<Cathegory> cathegories;
	private String path;
	private String comment;
	
	
}
