package com.sidsalon.styleandcut.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sidsalon.styleandcut.model.Authorities;
import com.sidsalon.styleandcut.model.Cart;
import com.sidsalon.styleandcut.model.Customer;
import com.sidsalon.styleandcut.model.Users;

@Repository
public class CustomerDaoImpl implements CustomerDao {
@Autowired
private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getAllCustomer() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Customer");
		List<Customer> customer = query.list();
		session.flush();
		return customer;
	}

	@Override
	@Transactional
	public Customer getCustomerById(int customerId) {
		Session session = sessionFactory.openSession();
		Customer customer = (Customer)session.get(Customer.class, customerId);
		session.flush();
		return customer;
	}

	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		customer.getBillingAddress().setCustomer(customer);
		customer.getShippingAddress().setCustomer(customer);
		session.saveOrUpdate(customer);
		session.saveOrUpdate(customer.getBillingAddress());
		session.saveOrUpdate(customer.getShippingAddress());
		
		Users user = new Users();
		user.setUsername(customer.getUsername());
		user.setPassword(customer.getCustomerPassword());
		user.setEnabled(true);
		user.setCustomerId(customer.getCustomerId());
		session.saveOrUpdate(user);
		
		Authorities authority = new Authorities();
		authority.setUsername(customer.getUsername());
		authority.setAuthority("ROLE_USER");
		session.saveOrUpdate(authority);
		session.flush();
		
		Cart newCart = new Cart();
		newCart.setCustomer(customer);
		customer.setCart(newCart);
		session.saveOrUpdate(customer);
		session.flush();
	}

	@Override
	@Transactional
	public Customer getCustomerByUserName(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Customer where username=?");
		query.setString(0, username);
		return (Customer)query.uniqueResult();
	}

}
