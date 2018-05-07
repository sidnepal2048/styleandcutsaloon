package com.sidsalon.styleandcut.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sidsalon.styleandcut.model.Cart;
import com.sidsalon.styleandcut.model.CartItem;
import com.sidsalon.styleandcut.model.Customer;
import com.sidsalon.styleandcut.service.CartItemService;
import com.sidsalon.styleandcut.service.CartService;
import com.sidsalon.styleandcut.service.CustomerService;
import com.sidsalon.styleandcut.service.ProductService;

@Controller
@RequestMapping("/shopping/cart")
public class CartController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    
    @RequestMapping
    public String getCart(@AuthenticationPrincipal User activeUser){
        Customer customer = customerService.getCustomerByUserName (activeUser.getUsername());
        int cartId = customer.getCart().getCartId();

        return "redirect:/shopping/cart/"+cartId;
    }

    @RequestMapping("/{cartId}")
    public String getCartRedirect(@PathVariable (value = "cartId") int cartId, Model model) {
        model.addAttribute("cartId", cartId);
    	Cart cart = cartService.getCartById(cartId);
    	System.out.println(cart);
    	cart.getCartItems();
    	System.out.println(cart.getCartItems());
    	
        /*List<CartItem> cartItems = cartItemService.getAllCartItem();
        List<Product> products = productService.getAllProduct();
 */     
        for(int i=0; i<cart.getCartItems().size();i++){
        //	Cart cart = cartService.getCartById(cartId);
        	String name = cart.getCartItems().get(i).getProduct().getProductName();
        	 model.addAttribute("name", name);
        	System.out.println(cart.getCartItems().get(i).getProduct().getProductName());
        	double price = cart.getCartItems().get(i).getProduct().getProductPrice();
        	 model.addAttribute("price", price);
        	System.out.println(cart.getCartItems().get(i).getProduct().getProductPrice());
        	int quant = cart.getCartItems().get(i).getQuantity();
        	 model.addAttribute("quant", quant);
        	System.out.println(cart.getCartItems().get(i).getQuantity());
        	
        }
        
        cart.getGrandTotal();
       
    	System.out.println(cart.getGrandTotal());
        return "cart";
    }

}
