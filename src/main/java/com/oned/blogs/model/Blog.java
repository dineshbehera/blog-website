package com.oned.blogs.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "blogs")
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String subTitle;
	private String type;

	@Column(name = "content", columnDefinition = "TEXT")
	private String content;
	private String picture;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = false)
	@CreationTimestamp(source = SourceType.DB)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = true)
	@UpdateTimestamp(source = SourceType.DB)
	private Date updateDate;
	private String author;

	@Column(columnDefinition = "boolean default true")
	private boolean isActive;

	public Blog() {
		super();
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", type=" + type + ", name=" + subTitle + ", content=" + content
				+ ", picture=" + picture + ", createDate=" + createDate + ", updateDate=" + updateDate + ", author="
				+ author + ", isActive=" + isActive + ", getId()=" + getId() + ", getTitle()=" + getTitle()
				+ ", getType()=" + getType() + ", getSubTitle()=" + getSubTitle() + ", getContent()=" + getContent()
				+ ", getPicture()=" + getPicture() + ", getCreateDate()=" + getCreateDate() + ", getUpdateDate()="
				+ getUpdateDate() + ", getAuthor()=" + getAuthor() + ", isActive()=" + isActive() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public Blog(Long id, String title, String type, String name, String content, String picture, Date createDate,
			Date updateDate, String author, boolean isActive) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.subTitle = subTitle;
		this.content = content;
		this.picture = picture;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.author = author;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setName(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
