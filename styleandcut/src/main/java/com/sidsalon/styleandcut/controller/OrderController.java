package com.sidsalon.styleandcut.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sidsalon.styleandcut.model.Cart;
import com.sidsalon.styleandcut.model.Customer;
import com.sidsalon.styleandcut.model.Order;
import com.sidsalon.styleandcut.service.CartService;
import com.sidsalon.styleandcut.service.OrderService;


@Controller
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId") int cartId) {
        Order order = new Order();
        Cart cart=cartService.getCartById(cartId);
        order.setCart(cart);
        Customer customer = cart.getCustomer();
        order.setCustomer(customer);
        order.setBillingAddress(customer.getBillingAddress());
        order.setShippingAddress(customer.getShippingAddress());
        orderService.addOrder(order);
        return "redirect:/checkout?cartId="+cartId;
    }
}

