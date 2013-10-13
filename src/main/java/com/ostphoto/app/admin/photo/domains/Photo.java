package com.ostphoto.app.admin.photo.domains;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;





@Entity
@Table(name="Photo")
public class Photo {

	@Id
    @Column(name = "id")
    @GeneratedValue
	private int id;
	
	@ManyToMany(mappedBy="photos", fetch=FetchType.LAZY)
	private List<Category> categories;
	
	@Column(name = "fileName")
	private String fileName;
	

	@Column(name = "Comment")
	private String comment;

	@Column(name = "[update]", nullable = false)
	private Date update;
	
	public Date getUpdate() {
		return update;
	}

	public void setUpdate(Date update) {
		this.update = update;
	}
	
	
	public List<Category> getCategories() {
		return categories;
	}
		
		
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
