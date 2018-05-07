/**
 * 
 */
package com.sidsalon.styleandcut.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sidsalon.styleandcut.model.Order;

/*
 *
 * @author sid
 *
 */
@Repository

public class OrderDaoImpl implements OrderDao {
@Autowired
private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.sidsalon.styleandcut.dao.OrderDao#addOrder(com.sidsalon.styleandcut.model.Order)
	 */
	@Override
	@Transactional
	public void addOrder(Order order) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(order);
		session.flush();
	}

}
