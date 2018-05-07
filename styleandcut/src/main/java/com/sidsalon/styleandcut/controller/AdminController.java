package com.sidsalon.styleandcut.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sidsalon.styleandcut.model.Appointment;
import com.sidsalon.styleandcut.model.Customer;
import com.sidsalon.styleandcut.model.Product;
import com.sidsalon.styleandcut.model.Stylist;
import com.sidsalon.styleandcut.model.UploadImage;
import com.sidsalon.styleandcut.service.AppointmentService;
import com.sidsalon.styleandcut.service.CustomerService;
import com.sidsalon.styleandcut.service.ImageService;
import com.sidsalon.styleandcut.service.ProductService;
import com.sidsalon.styleandcut.service.SendEmail;
import com.sidsalon.styleandcut.service.StylistService;


@Controller

public class AdminController {
	@Autowired
	private SendEmail sendEmail;
	@Autowired
	private ProductService productService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private StylistService stylistService;
	@Autowired
	private ImageService imageService;
	@Autowired
	private AppointmentService appointmentService;
	
	@RequestMapping("/Admin")
public String adminPage(){
	return "admin";
}
@RequestMapping("/Admin/productInventory")
public String productInventory(Model model){
	List<Product> products = productService.getAllProduct();
	model.addAttribute("products", products);
	return "productInventory";
}
@RequestMapping("/Admin/productInventory/addProduct")
public String addProduct(Model model){
	Product product = new Product();
	model.addAttribute("product", product);
	return "addProduct";
}

@RequestMapping(value="/Admin/productInventory/addProduct", method=RequestMethod.POST)
public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model, HttpServletRequest request){
	if(result.hasErrors()){
		return "addProduct";
	}
	 
	productService.addProduct(product);
	return "redirect:/Admin/productInventory";
}
@RequestMapping("/Admin/productInventory/deleteProduct/{id}")
public String deleteProduct(@PathVariable int id, Model model){
Product product = productService.getProductById(id);
	productService.deleteProduct(product);
	return "redirect:/productInventory";
}

@RequestMapping("/Admin/productInventory/editProduct/{id}")
public String editProductPre(@PathVariable("id") int id, Model model){
	Product product= productService.getProductById(id);
	model.addAttribute(product);
	
	//System.out.println(product.getProductName());
	return "editProduct";	
}

@RequestMapping(value="/Admin/productInventory/editProduct", method=RequestMethod.POST)
public String editProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request){
	if(result.hasErrors()){
		return "editProduct";
	}
	productService.editProduct(product);
	//System.out.println(product.getProductName());
	return  "redirect:/Admin/productInventory";
	}

@RequestMapping("/Admin/email")
public String email(Model model){
	return "email";
}

@RequestMapping(value="/Admin/email", method=RequestMethod.POST)
public String sendEmail(HttpServletRequest request){
	
	String to = request.getParameter("to");
	String subject = request.getParameter("subject");
	String message = request.getParameter("message");
	sendEmail.sendEmailToUser(to, subject, message);
	System.out.println(to);
	System.out.println(message);
	return "admin";
	}
@RequestMapping(value="/Admin/uploadImage", method=RequestMethod.GET)
public String uploadImage(Model model){
	return "gallery";
	
}
@RequestMapping(value="/Admin/uploadImage", method=RequestMethod.POST)
public String ImageUpload(HttpServletRequest request,
        @RequestParam CommonsMultipartFile[] upload) throws Exception{
	
	if (upload != null && upload.length > 0) {
        for (CommonsMultipartFile aFile : upload){
              
            System.out.println("Saving file: " + aFile.getOriginalFilename());
             
            UploadImage uploadImage = new UploadImage();
            uploadImage.setImageName(aFile.getOriginalFilename());
            uploadImage.setData(aFile.getBytes());
            imageService.saveImage(uploadImage);               
        }
    }

	return "gallery";
}
@RequestMapping("/Admin/customers")
public String custManage(Model model){
	List<Customer> customerList = customerService.getAllCustomer();
	model.addAttribute("customerList", customerList);
	return "customerManagement";
}
@RequestMapping("/Admin/stylist")
public String addStylist(Model model){
	Stylist stylist = new Stylist();
	model.addAttribute("stylist", stylist);
	return "addStylist";
}
@RequestMapping(value = "/Admin/stylist", method = RequestMethod.POST)
@Transactional
public String addStylistPost(@Valid @ModelAttribute("stylist") Stylist stylist, BindingResult result,

		Model model) {

    if (result.hasErrors()) {
        return "addStylist";
    }
    
    
   stylist.setEnabled(false);
   stylistService.addStylist(stylist);
    return "admin";

}
@RequestMapping(value = "/Admin/viewAppointment", method = RequestMethod.GET)
@Transactional
public String viewAppointment(Model model){
	
	List<Appointment> appointmentList = appointmentService.findAllAppointment();
	 for (int i=0; i< appointmentList.size(); i++){
		 if(appointmentList.get(i).getCustomer()!=null ){
			 if(!appointmentList.get(i).getCustomer().getCustomerName().isEmpty() && !appointmentList.get(i).getStylist().getStylistName().isEmpty() && !appointmentList.get(i).getDate().isEmpty()){
				 //appointmentList.get(i).getCustomer().getCustomerName();
				 //System.out.println(appointmentList.get(i).getCustomer().getCustomerName());
				 //System.out.println(appointmentList.get(i));
				 model.addAttribute("appointmentList", appointmentList);
			 }
		 }else{
			 continue;
		 }
		 
	 }
	//model.addAttribute("appointmentList", appointmentList);
	return "viewAppointment";
}
/*@RequestMapping(value="/Admin/viewIndividual")
@Transactional
public String viewIndividual(Model model){
	return "";
}
*/

}