package com.sidsalon.styleandcut.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Email")
@Table(name="Email")
public class Email implements Serializable{
	private static final long serialVersionUID = -3532377236419382983L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
	private int id;
	
	@Column(name="Email")
	private String emailId;
	
	@Column(name="Subject")
	private String subject;
	
	@Column(name="Message")
	private String message;

	public int getId() {
		return id;
	}
	
	public Email(){
		
	}
	public Email(String emailId, String subject, String message) {
		this.emailId = emailId;
		this.subject = subject;
		this.message = message;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
