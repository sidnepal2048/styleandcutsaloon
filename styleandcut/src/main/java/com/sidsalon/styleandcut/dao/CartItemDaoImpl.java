package com.sidsalon.styleandcut.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.sidsalon.styleandcut.model.Cart;
import com.sidsalon.styleandcut.model.CartItem;
import com.sidsalon.styleandcut.model.Product;

@Repository

public class CartItemDaoImpl implements CartItemDao {

	@Autowired
private SessionFactory sessionFactory;
	
	
	@Transactional
	public void addCartItem(CartItem cartItem) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(cartItem);
		session.flush();
	}

	
	@Transactional
	public void removeCartItem(CartItem cartItem) {
		Session session = sessionFactory.openSession();
		session.delete(cartItem);
		session.flush();
	}

	@Transactional
	public void removeAllCartItems(Cart cart) {
		List<CartItem> cartItems = cart.getCartItems();
		for(CartItem item: cartItems){
			removeCartItem(item);
		}
	}

	@Transactional
	public CartItem getCartItemByProductId(int productId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from CartItem where productId=?");
		query.setInteger(0, productId);
		session.flush();
		return (CartItem)query.uniqueResult();
	}


	@Override
	@Transactional
	public List<CartItem> getAllCartItem() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from CartItem");
		List<CartItem> cartItem  = query.list();
		session.flush();
		return cartItem;
	}

}

