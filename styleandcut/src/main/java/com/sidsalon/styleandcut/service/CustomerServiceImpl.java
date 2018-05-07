/**
 * 
 */
package com.sidsalon.styleandcut.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sidsalon.styleandcut.dao.CustomerDao;
import com.sidsalon.styleandcut.model.Customer;

/**
 * @author sid
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public List<Customer> getAllCustomer() {
		
		return customerDao.getAllCustomer();
	}

		@Override
	public Customer getCustomerById(int customerId) {
		return customerDao.getCustomerById(customerId);
	}

		@Override
	public void addCustomer(Customer customer) {
			customerDao.addCustomer(customer);


	}

		@Override
		public Customer getCustomerByUserName(String username) {
			return customerDao.getCustomerByUserName(username);
			
		}

}
