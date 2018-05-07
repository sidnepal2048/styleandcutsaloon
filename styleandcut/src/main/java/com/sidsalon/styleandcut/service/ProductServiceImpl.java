package com.sidsalon.styleandcut.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidsalon.styleandcut.dao.ProductDao;
import com.sidsalon.styleandcut.model.Product;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public Product getProductById(int id){
		return productDao.getProductById(id);
	}
	
	public List<Product> getAllProduct(){
		return productDao.getAllProduct();
	}
	
	public void addProduct(Product product){
		productDao.addProduct(product);
	}
	
	public void editProduct(Product product){
		productDao.editProduct(product);
	}
	
	public void deleteProduct(Product product){
		productDao.deleteProduct(product);
	}
}
