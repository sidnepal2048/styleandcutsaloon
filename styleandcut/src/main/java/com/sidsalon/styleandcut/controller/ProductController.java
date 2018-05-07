package com.sidsalon.styleandcut.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sidsalon.styleandcut.model.Product;
import com.sidsalon.styleandcut.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/productList", method=RequestMethod.GET)
	public String getProduct(Model model){
		List<Product> product = productService.getAllProduct();
		model.addAttribute("products", product);
		return ("productList");
	}
	
	 @RequestMapping("/viewProduct/{productId}")
	    public String viewProduct(@PathVariable int productId, Model model) throws IOException {
	        Product product=productService.getProductById(productId);
	        model.addAttribute("product", product);

	        return "viewProduct";
	    }


}
