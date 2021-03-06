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

@Entity
@Table(name="BillingAddress")
public class BillingAddress implements Serializable{
	
	private static final long serialVersionUID = 3840551344796967902L;
	@Id
	@GeneratedValue
	private int billAddressId;

	@Column(name="streetName")
	private String streetName;

	@Column(name="apartmentNumber")
	private String apartmentNumber;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;

	@Column(name="country")
	private String country;

	@Column(name="zipCode")
	private String zipCode;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customerId")
	private Customer customer;

	public int getBillAddressId() {
		return billAddressId;
	}

	public void setBillAddressId(int billAddressId) {
		this.billAddressId = billAddressId;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

		
}
