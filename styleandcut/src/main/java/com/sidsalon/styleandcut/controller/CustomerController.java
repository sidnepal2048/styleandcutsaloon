package com.sidsalon.styleandcut.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sidsalon.styleandcut.model.Appointment;
import com.sidsalon.styleandcut.model.BillingAddress;
import com.sidsalon.styleandcut.model.Customer;
import com.sidsalon.styleandcut.model.ShippingAddress;
import com.sidsalon.styleandcut.model.Stylist;
import com.sidsalon.styleandcut.service.AppointmentService;
import com.sidsalon.styleandcut.service.CustomerService;
import com.sidsalon.styleandcut.service.StylistService;

@Controller
@RequestMapping("/RegisterCustomer")
public class CustomerController {
	@Autowired 
	private CustomerService customerService;
	
	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private StylistService stylistService;
	@Scope("session")
	
	@RequestMapping("/register")
	@Transactional
	public String register(Model model){
		Customer customer = new Customer();
		BillingAddress billingAddress = new BillingAddress();
		ShippingAddress shippingAddress = new ShippingAddress();
		customer.setBillingAddress(billingAddress);
		customer.setShippingAddress(shippingAddress);
		model.addAttribute("customer", customer);
		return "registerCustomer";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@Transactional
    public String registerCustomerPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult result,
                                       Model model) {

        if (result.hasErrors()) {
            return "Register";
        }
        List<Customer> customerList = customerService.getAllCustomer();
        for (int i=0; i< customerList.size(); i++){
        if(customer.getUsername().equals(customerList.get(i).getUsername())){
            model.addAttribute("usernameMsg", "Username or email already exists");

            return "registerCustomer";
        }
        }
       customer.setEnabled(true);
       customerService.addCustomer(customer);
        return "redirect:/";

    }
	@RequestMapping(value="/Appointment", method=RequestMethod.GET)
	//@RequestMapping("/{customerId}")
	public String appointment(Model model){
		Appointment appointment = new Appointment();
		Stylist stylist = new Stylist();
		//Customer customer = customerService.getCustomerById(customerId);
		//appointment.setCustomer(customer);
		//customer.setAppointment(appointment);
		
		model.addAttribute("appointment", appointment);
		model.addAttribute("stylist", stylist);
		return "showDate";
	}

	@RequestMapping(value="/Appointment", method=RequestMethod.POST)
	//@RequestMapping(method=RequestMethod.POST)
	public String appointmentPost(@ModelAttribute("appointment") Appointment appointment,@AuthenticationPrincipal User activeUser, BindingResult bindingResult, Model model, HttpServletRequest request, HttpSession session){
		String dob = request.getParameter("dob");
		//System.out.print(dob);
	//	System.out.println(dob);
		List<Appointment> appoint = appointmentService.findAllAppointment();
		 for (int i=0; i< appoint.size(); i++){
			 System.out.println(appoint);
			 String date = appoint.get(i).getDate();
			 System.out.println(date);
				
			// if(dob.equals(appoint.get(i).getDate())){
				 if("dob" != appoint.get(i).getDate()){
					 return "forward:/pickAvailableStylist"+dob;
				/* System.out.println("Date are same. Pick another date or time");
				 	String message = "Date and Time are same. Pick another date or time";
				 	model.addAttribute("msg", message);
				 	return "showDate";
				*/		 
			 }
		 }
		 System.out.println("Date are same. Pick another date or time");
		 	String message = "Date and Time are same. Pick another date or time";
		 	model.addAttribute("msg", message);
		 	return "showDate";
		
		
		//return "forward:/pickAvailableStylist"+dob;
	}
	@RequestMapping(value="/pickAvailableStylist", method=RequestMethod.POST)
	//@RequestMapping(method=RequestMethod.POST)
	public String availableStylist(HttpSession session, Model model, String dob, @ModelAttribute("appointment") Appointment appointment ,HttpServletRequest request){
		String date = dob;
		System.out.println(date);
				String message= "Available stylist";
				System.out.println(message);
		model.addAttribute("msg", message);
		 List<Stylist> stylist = stylistService.getAllStylist();
		 for(int i=0; i<stylist.size(); i++){
			 String stylistName = stylist.get(i).getStylistName();
			 System.out.println(stylistName);
			 model.addAttribute("stylistName", stylist);
		 }
		 session.setAttribute("date", dob);
		
	
		return "pickAvailableStylists";
}
	@RequestMapping(value="/selectedAppointment/{stylistId}", method=RequestMethod.GET)
	public String booked(HttpSession session, @PathVariable int stylistId, @ModelAttribute("appointment") Appointment appointment,@AuthenticationPrincipal User activeUser, BindingResult bindingResult, Model model, HttpServletRequest request){
		String Date = (String) session.getAttribute("date");
		System.out.println(Date);
		Stylist stylist = stylistService.getStylistById(stylistId);
		appointment.setStylist(stylist);
		stylist.setEnabled(true);
		String date=Date;
		System.out.println(date);
		Customer customer = customerService.getCustomerByUserName(activeUser.getUsername());
		System.out.println(customer);
		appointment.setCustomer(customer);
		appointment.setDate(date);
		appointmentService.createAppointment(appointment);
		SimpleMailMessage email = new SimpleMailMessage();
		String to = activeUser.getUsername();
		System.out.println(to);
		email.setTo(activeUser.getUsername());
		String subject = "Appointment confirmation";
		email.setSubject(subject);
		String name = customer.getCustomerName();
		String message="Hi " + name + " your appointment is on" + date + "CDT";
		email.setText(message);
		try {
			this.mailSender.send(email);
		} catch (MailException ex) {
		
			System.err.println(ex.getMessage());
		}
		model.addAttribute("msg", "Your Appointment is Confirmed");
		return "home";
			}
	@RequestMapping("/checkout")
	public String checkout(){
		return "checkout";
	}
	

}
