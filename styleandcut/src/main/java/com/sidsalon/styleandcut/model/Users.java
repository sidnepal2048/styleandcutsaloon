package com.sidsalon.styleandcut.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	@Id
	@GeneratedValue
	private int userId;
	private String username;
	private String password;
	private boolean enabled;
	//@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customerId")
	private int customerId;
	@JoinColumn(name="stylistId")
	private int stylistId;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getStylistId() {
		return stylistId;
	}
	public void setStylistId(int stylistId) {
		this.stylistId = stylistId;
	}
	
	
	
	
}
