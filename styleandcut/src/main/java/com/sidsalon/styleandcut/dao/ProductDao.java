package com.sidsalon.styleandcut.dao;

import java.util.List;

import com.sidsalon.styleandcut.model.Product;

public interface ProductDao {
	List<Product> getAllProduct(); //list of product
	Product getProductById(int id);//get product by id
	void addProduct(Product product); //add product to DB
	void editProduct(Product product);//edit the product
	void deleteProduct(Product product);//delete the product

	}
