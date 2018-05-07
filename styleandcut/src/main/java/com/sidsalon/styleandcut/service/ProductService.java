package com.sidsalon.styleandcut.service;

import java.util.List;
import com.sidsalon.styleandcut.model.Product;

public interface ProductService {
	List<Product> getAllProduct();
	Product getProductById(int id);
	void addProduct(Product product); 
	void editProduct(Product product);
	void deleteProduct(Product product);
}
