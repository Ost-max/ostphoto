package com.ostphoto.app.admin.photo.domains;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name="Photo")
public class Photo {

	@Id
    @Column(name = "id")
    @GeneratedValue
	private int id;
	
//	@Column(name = "cathegories")
//	@OneToMany()
//	private List<Category> cathegories;
	
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
	//	public List<Category> getCathegories() {
//		return cathegories;
//	}
//	public void setCathegories(List<Category> cathegories) {
//		this.cathegories = cathegories;
//	}
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
