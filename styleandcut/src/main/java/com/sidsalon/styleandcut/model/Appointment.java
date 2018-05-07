package com.sidsalon.styleandcut.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
@Entity
@Table(name="Appointment")
@Scope("session")
public class Appointment {
	@Id
	@GeneratedValue
	private int appointmentId;
	private String date;
	private boolean confirmed;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customerId")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="stylistId")
	private Stylist stylist;
	
	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Stylist getStylist() {
		return stylist;
	}

	public void setStylist(Stylist stylist) {
		this.stylist = stylist;
	}

	
		
	
}
