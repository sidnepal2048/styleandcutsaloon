package com.sidsalon.styleandcut.dao;

import java.io.IOException;

import com.sidsalon.styleandcut.model.Cart;

public interface CartDao {
	Cart getCartById(int cartId);
	Cart validate(int cardId) throws IOException;
	void update(Cart cart);
}
