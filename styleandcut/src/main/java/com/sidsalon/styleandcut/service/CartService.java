package com.sidsalon.styleandcut.service;

import java.io.IOException;

import com.sidsalon.styleandcut.model.Cart;

public interface CartService {
	Cart getCartById(int cartId);
	Cart validate(int cardId) throws IOException;
	void update(Cart cart);
}

