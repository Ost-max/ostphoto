package com.ostphoto.app.admin.photo.domains;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




//
//@Entity
//@Table(name="Photo")
public class Photo {

//	@Id
//    @Column(name = "ID")
//    @GeneratedValue
	private int id;
	
//	@Column(name = "cathegories")
//	@OneToMany()
//	private List<Category> cathegories;
	private String fileName;
	private String comment;
	
	
}
