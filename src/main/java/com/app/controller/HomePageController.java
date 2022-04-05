package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

	public HomePageController() {
		System.out.println("in ctor of :: " + getClass());
	}
	
	@RequestMapping("/")
	private String indexPage() {
		System.out.println("in indexPage()");
		return "/index";
	}
}
