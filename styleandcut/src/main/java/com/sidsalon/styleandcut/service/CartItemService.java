package com.sidsalon.styleandcut.service;

import java.util.List;

import com.sidsalon.styleandcut.model.Cart;
import com.sidsalon.styleandcut.model.CartItem;

public interface CartItemService {
	void addCartItem(CartItem cartItem);
	void removeCartItem(CartItem cartItem);
	void removeAllCartItems(Cart cart);
	CartItem getCartItemByProductId(int productId);
	List<CartItem> getAllCartItem();
}
