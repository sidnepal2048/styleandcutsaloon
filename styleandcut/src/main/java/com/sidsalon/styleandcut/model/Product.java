package com.sidsalon.styleandcut.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "Product" )
@Table(name = "Product" )
public class Product implements Serializable {
	
	private static final long serialVersionUID = -3532377236419382983L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="productId")
	private int productId;

	@NotEmpty(message="Product Name is Required")
	@Column(name="productName")
	private String productName;
	
	@NotEmpty(message="Product Category is Required")
	@Column(name="productCategory")
	private String productCategory;
	
	@NotEmpty(message="Product Description is Required")
	@Column(name="productDescription")
	private String productDescription;
	
	@Column(name="productUnitInStock")
	@Min(value=0, message="Stock must be greater than 0 and must be integer")
	private int productUnitInStock;
	
	@Min(value=0, message="Price must be greater than 0")
	@Column(name="productPrice")
	private double productPrice;
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductUnitInStock() {
		return productUnitInStock;
	}
	public void setProductUnitInStock(int productUnitInStock) {
		this.productUnitInStock = productUnitInStock;
	}
	
	
	
}