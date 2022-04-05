package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.customexception.AdminCustomException;
import com.app.dao.PropertyRepository;
import com.app.pojos.Admin;
import com.app.pojos.PropertyStatus;
import com.app.services.IAdminService;
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdminService adminService;

	@Autowired
	private PropertyRepository propertyRepo;
	
	public AdminController() {
		System.out.println("in ctor of :: " + getClass());
	}
	
	
	@GetMapping("/home")
	public String adminHome() {
		System.out.println("in signup admin");
		return "/admin/home";
	}

	@GetMapping("/signup_adm")
	public String signUpAdmin() {
		System.out.println("in signup admin");
		return "/admin/signup_adm";
	}

	@PostMapping("/signup_adm")
	public String AdminEnrolment(@RequestParam String adminName, @RequestParam String adminEmail,
			@RequestParam String adminPassword, @RequestParam String adminMobile,
			Model map, RedirectAttributes flashMap, HttpSession session) {
		System.out.println("id :: " + adminName);
		// create Emplyee Transient pojo n invoke employeeService layer method
		Admin adm = new Admin(adminName,adminEmail,adminPassword,adminMobile);
		try {
			session.setAttribute("message", adminService.signUpAdmin(adm));
			// =>success : redirect client to the logout page to avoid double submit issue
			return "redirect:/";
		} catch (AdminCustomException e) {
			map.addAttribute("err_message", e.getMessage());
			return "/admin/signup_adm";
		}

	}
	
	@GetMapping("/login_adm")
	public String loginAdminForm() {
		System.out.println("in login admin");
		return "/admin/login_adm";
	}
	
	@PostMapping("/login_adm")
	public String adminAuthenticateForm(@RequestParam String email, @RequestParam String password, Model map,
			HttpSession session, RedirectAttributes flashMap) {
		System.out.println("in process login form " + email + " " + password + " " + map);
		try {
			Admin adms = adminService.authenticateAdmin(email, password);
			
			session.setAttribute("admin_details", adms);
			//flashMap.addFlashAttribute("message", "Login Successful");
			map.addAttribute("message","Login Successful");
			return "/admin/home";

		} catch (RuntimeException e) {
			System.out.println("err in process login form " + e);
			map.addAttribute("message", "Invalid Login , Pls retry!!!!!!!!!!!!!");// request scope
			return "/admin/login_adm";
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
	
	@GetMapping("/list")
	public String showTotalPropertyList(Model model) {
		model.addAttribute("properties", propertyRepo.findAll());
		return "/admin/list";
	}
	
	@GetMapping("/list_sold")
	public String showSoldPropertyList(Model model) {
		model.addAttribute("properties", propertyRepo.findByPropertyStatus(PropertyStatus.valueOf("SOLD")));
		return "/admin/list_sold";
	}
	
	@GetMapping("/list_available")
	public String showAvailablePropertyList(Model model) {
		model.addAttribute("properties", propertyRepo.findByPropertyStatus(PropertyStatus.valueOf("AVAILABLE")));
		return "/admin/list_available";
	}
	
}
