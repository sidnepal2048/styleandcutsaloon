package com.sidsalon.styleandcut.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Order")
public class Order implements Serializable{
	
	private static final long serialVersionUID = 2072031057521157101L;

	@Id
	@GeneratedValue
	@Column(name="orderId")
	private int orderId;

	@OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

	
	@OneToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="billAddressId")
	private BillingAddress billingAddress;
	
	@OneToOne
	@JoinColumn(name="shipAddressId")
	private ShippingAddress shippingAddress;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
}
