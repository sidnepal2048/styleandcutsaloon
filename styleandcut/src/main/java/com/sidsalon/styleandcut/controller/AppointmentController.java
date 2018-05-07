/*package com.sidsalon.styleandcut.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sidsalon.styleandcut.model.Appointment;
import com.sidsalon.styleandcut.model.Customer;
import com.sidsalon.styleandcut.service.AppointmentService;
import com.sidsalon.styleandcut.service.CustomerService;

@Controller
@RequestMapping("/Appointment")
public class AppointmentController {
@Autowired
	private CustomerService customerService;
@Autowired
	private AppointmentService appointmentService;

//@RequestMapping(value="/Appointment/{customerId}", method=RequestMethod.GET)
@RequestMapping("/{customerId}")
public String appointment(@PathVariable("customerId") int customerId, Model model){
	Appointment appointment = new Appointment();
	//Customer customer = customerService.getCustomerById(customerId);
	//appointment.setCustomer(customer);
	//customer.setAppointment(appointment);
	model.addAttribute("customerId", customerId);
	model.addAttribute("appointment", appointment);
	return "showDate";
}

//@RequestMapping(value="/Appointment", method=RequestMethod.POST)
@RequestMapping(method=RequestMethod.POST)
public String appointmentPost(@ModelAttribute("appointment") Appointment appointment, BindingResult bindingResult, Model model, @AuthenticationPrincipal User activeUser, HttpServletRequest request){
	String dob = request.getParameter("dob");
	//System.out.print(dob);
	System.out.println(dob);
	Customer customer = customerService.getCustomerByUserName(activeUser.getUsername());
	appointment.setCustomer(customer);
	appointment.setDate(dob);
	appointmentService.createAppointment(appointment);
	System.out.println(appointment);
	return "home";
	}
}
*/