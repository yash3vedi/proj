package com.app.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.AppointmentRepository;
import com.app.pojos.Appointment;
import com.app.pojos.AppointmentStatus;
import com.app.pojos.Customer;

@Controller
@RequestMapping("/appoint")
public class AppointmentController {
	
	@Autowired
	private AppointmentRepository appointmentRepo;
	
	
	@GetMapping("/get_apt")
	public String showNewTutForm(Model map) {
		System.out.println("in show new tut form");
		return "/appointment/get_appointment";// AVN : /WEB-INF/views/admin/add_new_tut.jsp
	}
	
	@PostMapping("/get_apt")//@ModelAttribute("appoint") Appointment appoint
	public String getAppointment(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate aptdate,
			Model model,HttpSession session) {
		
		System.out.println("in signup Appointment ");
		Customer customer = (Customer) session.getAttribute("customer_details");
		int id = customer.getId();
		Appointment appoint= new Appointment(id,aptdate,AppointmentStatus.valueOf("REQUESTED"));
		appointmentRepo.save(appoint);
		model.addAttribute("appointment","Your Appointment has been Recorded");
		return "/appointment/get_appointment";
	}
}
