package com.sidsalon.styleandcut.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="Stylist")
public class Stylist implements Serializable {

	private static final long serialVersionUID = 8607474363205059141L;
	@Id
	@GeneratedValue
	private int stylistId;
	
	@OneToOne
	@JoinColumn(name="appointmentId")
	private Appointment appointment;
	
	@NotBlank(message = "fieldEmpty")
	private String stylistName;
	
	@Email
	private String username;
	
	@NotBlank(message="password cannot be empty")
	@Pattern.List({
        @Pattern(regexp = "(?=.*[0-9]).+", message = "Password must contain one digit."),
        @Pattern(regexp = "(?=.*[a-z]).+", message = "Password must contain one lowercase letter."),
        @Pattern(regexp = "(?=.*[A-Z]).+", message = "Password must contain one upper letter."),
        @Pattern(regexp = "(?=.*[!@#$%^&*+=?-_()/\"\\.,<>~`;:]).+", message ="Password must contain one special character."),
        @Pattern(regexp = "(?=\\S+$).+", message = "Password must contain no whitespace.")
})
	private String stylistPassword;
	private boolean enabled;
	public int getStylistId() {
		return stylistId;
	}
	public void setStylistId(int stylistId) {
		this.stylistId = stylistId;
	}
	public String getStylistName() {
		return stylistName;
	}
	public void setStylistName(String stylistName) {
		this.stylistName = stylistName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getStylistPassword() {
		return stylistPassword;
	}
	public void setStylistPassword(String stylistPassword) {
		this.stylistPassword = stylistPassword;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	
}
