package com.sidsalon.styleandcut.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidsalon.styleandcut.dao.CartItemDao;
import com.sidsalon.styleandcut.model.Cart;
import com.sidsalon.styleandcut.model.CartItem;

@Service
public class CartItemServiceImpl implements CartItemService {
	
	@Autowired
	private CartItemDao cartItemDao;

	@Override
	public void addCartItem(CartItem cartItem) {
		cartItemDao.addCartItem(cartItem);
	}

	@Override
	public void removeCartItem(CartItem cartItem) {
		cartItemDao.removeCartItem(cartItem);

	}

	@Override
	public void removeAllCartItems(Cart cart) {
		cartItemDao.removeAllCartItems(cart);

	}

	@Override
	public CartItem getCartItemByProductId(int productId) {
		
		return cartItemDao.getCartItemByProductId(productId);
	}

	@Override
	public List<CartItem> getAllCartItem() {
		
		return cartItemDao.getAllCartItem();
	}

}

