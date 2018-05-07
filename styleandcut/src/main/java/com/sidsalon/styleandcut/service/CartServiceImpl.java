package com.sidsalon.styleandcut.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidsalon.styleandcut.dao.CartDao;
import com.sidsalon.styleandcut.model.Cart;
import com.sidsalon.styleandcut.service.CartService;

@Service
public class CartServiceImpl implements CartService, CartDao {
@Autowired 
private CartDao cartDao;
	@Override
	public Cart getCartById(int cartId) {
		
		return cartDao.getCartById(cartId);
	}

	@Override
	public Cart validate(int cardId) throws IOException {
		
		return cartDao.validate(cardId);	
	}

	@Override
	public void update(Cart cart) {
		
		cartDao.update(cart);
	}

}
