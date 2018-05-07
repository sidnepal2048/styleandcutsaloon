package com.sidsalon.styleandcut.dao;

import java.util.List;

import com.sidsalon.styleandcut.model.Customer;

public interface CustomerDao {
	List<Customer> getAllCustomer(); //list of customer
	Customer getCustomerById(int customerId);//get customer by customerId
	void addCustomer(Customer customer); //add customer to DB
	Customer getCustomerByUserName(String username);
}
