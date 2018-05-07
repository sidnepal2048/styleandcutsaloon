package com.sidsalon.styleandcut.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.sidsalon.styleandcut.model.Product;



@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void addProduct(Product product){
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(product);
		session.flush();
	}

@Transactional
	public Product getProductById(int id){
		Session session = sessionFactory.openSession();
		Product product = (Product)session.get(Product.class, id);
		session.flush();
		return product;
	}

@Transactional
	public List<Product> getAllProduct(){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product");
		List<Product> product = query.list();
		session.flush();
		return product;
	}

@Transactional
	public void editProduct(Product product){
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(product);
		session.flush();
	}

@Transactional
	public void deleteProduct(Product product){
		Session session = sessionFactory.openSession();
		session.delete(product);
		session.flush();
	}
	
}
