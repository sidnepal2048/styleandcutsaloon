package com.sidsalon.styleandcut.service;

import java.util.List;

import com.sidsalon.styleandcut.model.Customer;

public interface CustomerService {
	List<Customer> getAllCustomer(); //list of customer
	Customer getCustomerById(int customerId);//get customer by customerId
	void addCustomer(Customer customer); //add customer to DB
	Customer getCustomerByUserName(String username);
	}
