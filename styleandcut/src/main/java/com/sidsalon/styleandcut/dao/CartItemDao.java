package com.sidsalon.styleandcut.dao;

import java.util.List;

import com.sidsalon.styleandcut.model.Cart;
import com.sidsalon.styleandcut.model.CartItem;

public interface CartItemDao {
	void addCartItem(CartItem cartItem);
	void removeCartItem(CartItem cartItem);
	void removeAllCartItems(Cart cart);
	CartItem getCartItemByProductId(int productId);
	List<CartItem> getAllCartItem();
}
