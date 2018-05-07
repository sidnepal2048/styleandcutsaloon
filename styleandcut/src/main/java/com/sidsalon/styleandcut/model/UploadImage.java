package com.sidsalon.styleandcut.model;


import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="UploadImage")
public class UploadImage {
	@Id @GeneratedValue
	private Blob imageId;
	
	@Column(name="imageName")
	private String imageName;
	
	@Column(name="data")
	private byte[] data;

		
	public Blob getImageId() {
		return imageId;
	}

	public void setImageId(Blob imageId) {
		this.imageId = imageId;
	}

	
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
	
	
}
