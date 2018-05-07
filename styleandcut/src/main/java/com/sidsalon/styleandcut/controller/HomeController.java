package com.sidsalon.styleandcut.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sidsalon.styleandcut.model.BillingAddress;
import com.sidsalon.styleandcut.model.Customer;
import com.sidsalon.styleandcut.model.Product;
import com.sidsalon.styleandcut.model.ShippingAddress;
import com.sidsalon.styleandcut.service.CustomerService;
import com.sidsalon.styleandcut.service.ProductService;

/**
 * Handles requests for the application home page.
 */
@Controller

public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "";
	}
	@RequestMapping("/")
	public String home(Model model){
		return ("home");
	}
	@RequestMapping("/about")
	public String aboutUs(Model model){
		return "aboutus";
	}
	
}
