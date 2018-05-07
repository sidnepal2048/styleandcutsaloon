package com.sidsalon.styleandcut.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Customer")
public class Customer implements Serializable{
	
	private static final long serialVersionUID = -1556762809207142694L;
	@Id
	@GeneratedValue
	private int customerId;
	
	@NotEmpty(message="Customer Name cannot be null")
	private String customerName;
	@Pattern(regexp="[\\d]{10}")
	@NotEmpty(message="Phone number cannot be null")
	private String customerPhoneNumber;
	
	@OneToOne
	@JoinColumn(name="appointmentId")
	private Appointment appointment;
	
	@Column(name="username", nullable = false, unique = true)
	@Email
	private String username;
	
	@NotEmpty(message="Username cannot be null")
	private String customerPassword;
	
	private boolean enabled;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="billAddressId")
	private BillingAddress billingAddress;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="shipAddressId")
	private ShippingAddress shippingAddress;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cartId")
	@JsonIgnore
	private Cart cart;
	
	public Appointment getAppointment() {
		return appointment;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}
	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
}
