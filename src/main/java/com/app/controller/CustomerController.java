package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.customexception.CustomerCustomException;
import com.app.pojos.Customer;
import com.app.services.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	public CustomerController() {
		System.out.println("in ctor of :: " + getClass());
		
	}

	@GetMapping("/home")
	public String customerHome() {
		System.out.println("in signup admin");
		return "/customer/home";
	}
	
	@GetMapping("/signup_cust")
	public String signUpCustomer(Customer stu) {
		System.out.println("in signup customer");
		return "/customer/signup_cust";
	}

	@PostMapping("/signup_cust")
	public String customerEnrolment(@RequestParam String customerName, @RequestParam String customerCoapplicantName,
			@RequestParam String customerpassword, @RequestParam String customerEmail,
			@RequestParam String customerAddress, @RequestParam String customerMobile,
			@RequestParam String customerAdhar, Model map, RedirectAttributes flashMap, HttpSession session) {
		System.out.println("id :: " + customerName);
		// create Emplyee Transient pojo n invoke employeeService layer method
		Customer cust = new Customer(customerName,customerCoapplicantName,customerpassword,customerEmail,customerAddress,customerMobile,customerAdhar);
		try {
			session.setAttribute("message", customerService.signUpCustomer(cust));
			// =>success : redirect client to the logout page to avoid double submit issue
			return "redirect:/";
		} catch (CustomerCustomException e) {
			map.addAttribute("err_message", e.getMessage());
			return "/customer/signup_cust";
		}

	}
//	@PostMapping("/signup_cust")
//	public String customerEnrolment(@Valid Customer cust, BindingResult result, Model map, RedirectAttributes flashMap, HttpSession session) {
//		
//		try {
//			if(result.hasErrors()) //=> P.L failure
//				throw new RuntimeException("Validation Constraints Failed ");
//			flashMap.addFlashAttribute("message", customerService.signUpCustomer(cust));
//			return "redirect:/";
//			
//			// =>success : redirect client to the logout page to avoid double submit issue
//			
//		} catch (CustomerCustomException e) {
//			map.addAttribute("err_message", e.getMessage());
//			return "/customer/signup_cust";
//		}
//
//	}
	@GetMapping("/login_cust")
	public String loginCustomerForm() {
		System.out.println("in login customer");
		return "/customer/login_cust";
	}
	
	@PostMapping("/login_cust")
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model map,
			HttpSession session, RedirectAttributes flashMap) {
		System.out.println("in process login form " + email + " " + password + " " + map);
		try {
			Customer cust = customerService.authenticateCustomer(email, password);
			
			session.setAttribute("customer_details", cust);
			//flashMap.addFlashAttribute("message", "Login Successful");
			map.addAttribute("message","Login Successful");
			return "/customer/home";

		} catch (RuntimeException e) {
			System.out.println("err in process login form " + e);
			map.addAttribute("message", "Invalid Login , Pls retry!!!!!!!!!!!!!");// request scope
			return "/customer/login_cust";
		}

	}
	
	@GetMapping("/logout")
	public String logOutUser(HttpSession session,HttpServletRequest request,HttpServletResponse resp,Model map) {
		System.out.println("in log out");
		session.invalidate();
		//set refresh header of HTTP resp
		resp.setHeader("refresh", "5;url="+request.getContextPath());// value of hdr 5;url=/spring-mvc-boot
		
		return "redirect:/";// AVN : /WEB-INF/views/user/logout.jsp
	}

}
