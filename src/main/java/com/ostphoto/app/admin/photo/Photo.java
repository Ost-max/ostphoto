package com.ostphoto.app.admin.photo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ostphoto.app.admin.photo.domains.Category;





@Entity
@Table(name="Photo")
public class Photo {

	@Id
    @Column(name = "ID")
    @GeneratedValue
	private int id;
	
	@Column(name = "cathegories")
	private List<Category> cathegories;
	private String path;
	private String comment;
	
	
}
