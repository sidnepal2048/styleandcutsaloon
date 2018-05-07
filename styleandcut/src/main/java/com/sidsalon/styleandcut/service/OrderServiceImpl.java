package com.sidsalon.styleandcut.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidsalon.styleandcut.dao.OrderDao;
import com.sidsalon.styleandcut.model.Cart;
import com.sidsalon.styleandcut.model.CartItem;
import com.sidsalon.styleandcut.model.Order;
@Service
public class OrderServiceImpl implements OrderService {
@Autowired
private OrderDao orderDao;
@Autowired CartService cartService;
	
	public void addOrder(Order order) {
		 orderDao.addOrder(order);
	}
	
	public double getOrderGrandTotal(int cartId){
		double grandTotal=0;
		Cart cart = cartService.getCartById(cartId);
		List<CartItem> cartItems = cart.getCartItems();
		for(CartItem item : cartItems){
			grandTotal+=item.getTotalPrice();
		}
		return grandTotal;
	}

}
