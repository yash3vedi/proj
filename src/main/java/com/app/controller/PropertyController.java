package com.app.controller;

import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.customexception.PropertyCustomException;
import com.app.pojos.Property;
import com.app.pojos.PropertyStatus;
import com.app.services.IPropertyService;

@Controller
@RequestMapping("/property")
public class PropertyController {

	@Autowired
	private IPropertyService propertyService;
	

	public PropertyController() {
		System.out.println("in ctor of :: " + getClass());
	}

	@GetMapping("/add_property")
	public String addproject(Model map) {
		PropertyStatus arr[] = PropertyStatus.values();
		map.addAttribute("propertystatus", arr);
		System.out.println("Enum Value" + Arrays.toString(arr));
		System.out.println("in project");
		return "/property/add_property";
	}

	@PostMapping("/add_property")
	public String PropertyEnrolment(@RequestParam String propertyStatus1, @RequestParam String propertyArea,
			@RequestParam int projectId, Model map,
			RedirectAttributes flashMap, HttpSession session) {

		PropertyStatus propertyStatus = PropertyStatus.valueOf(propertyStatus1);
	
		Property pjt = new Property(propertyStatus, propertyArea);
		try {
			session.setAttribute("message", propertyService.addNewProperty(pjt,projectId));
			// =>success : redirect client to the logout page to avoid double submit issue
			return "/admin/home";
		} catch (PropertyCustomException e) {
			map.addAttribute("err_message", e.getMessage());
			return "/property/add_property";
		}

	}
	
	@GetMapping("/assign_property")
	public String assignProperty(Model map) {
		System.out.println("in property assign");
		return "/property/assign_property";
	}
	@PostMapping("/assign_property")
	public String propertyAssignment(@RequestParam int projectId, @RequestParam int customerId,
			@RequestParam int propertytId,@ModelAttribute("props") Property props,Model map,RedirectAttributes flashMap, HttpSession session) {
		
		try {
			
			propertyService.assingnPropertyToCustomer(props,propertytId,projectId,customerId);
			// =>success : redirect client to the logout page to avoid double submit issue
			return "/admin/home";
		} catch (PropertyCustomException e) {
			map.addAttribute("err_message", e.getMessage());
			return "/property/add_property";
		}

	}
	@GetMapping("/delete")
	public String deleteProperty(Model map) {
		System.out.println("in property assign");
		return "/property/delete";
	}
	
	@PostMapping("/delete")
	public String deleteProperty(@RequestParam int Id,Model map) {
		try {
		propertyService.deleteProperty(Id);

		return "/admin/home";
		} catch (PropertyCustomException e) {
			map.addAttribute("err_message", e.getMessage());
			return "/property/delete";
		}
	}
}
