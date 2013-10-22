package com.ostphoto.app.admin.photo.domains;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;





@Entity
@Table(name="Photo")
public class Photo {

	@Id
    @Column(name = "id")
    @GeneratedValue
	private int id;
	

    public int getId() {
		return id;
	}


	@ManyToMany 
    @JoinTable(name="Photo_Cat", joinColumns={@JoinColumn(name="Photo")}, 
            inverseJoinColumns={@JoinColumn(name="Cat")})
	private List<Category> categories = new ArrayList<>();
	
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
