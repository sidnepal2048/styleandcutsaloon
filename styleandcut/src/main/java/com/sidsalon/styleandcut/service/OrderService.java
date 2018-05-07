package com.sidsalon.styleandcut.service;

import com.sidsalon.styleandcut.model.Order;

public interface OrderService {
	void addOrder(Order order);

	double getOrderGrandTotal(int cartId);
}
