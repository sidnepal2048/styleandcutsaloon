package com.sidsalon.styleandcut.dao;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sidsalon.styleandcut.model.Cart;
import com.sidsalon.styleandcut.service.CartService;
import com.sidsalon.styleandcut.service.OrderService;

@Repository
public class CartDaoImpl implements CartDao {
	
@Autowired
private SessionFactory sessionFactory;
@Autowired
private OrderService orderService;
	
@Override
	@Transactional
	public Cart getCartById(int cartId) {
		Session session = sessionFactory.openSession();
		Cart cart = (Cart)session.get(Cart.class, cartId);
		session.flush();
		return cart;
	}

	@Override
	@Transactional
	public Cart validate(int cartId) throws IOException {
		Cart cart = getCartById(cartId);
		if(cart==null||cart.getCartItems().size()==0){
			throw new IOException(cartId+"");
		}
		update(cart);
		return cart;
	}

	@Override
	@Transactional
	public void update(Cart cart) {
		int cartId = cart.getCartId();
		double grandTotal = orderService.getOrderGrandTotal(cartId);
		cart.setGrandTotal(grandTotal);
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(cart);
	}

}
