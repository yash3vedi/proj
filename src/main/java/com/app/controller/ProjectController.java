package com.app.controller;

import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.customexception.ProjectCustomException;
import com.app.pojos.Project;
import com.app.pojos.ProjectStatus;
import com.app.pojos.ProjectType;
import com.app.services.IProjectService;
@Controller
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	private IProjectService projectService;

	public ProjectController() {
		System.out.println("in ctor of :: " + getClass());
	}

	@GetMapping("/add_project")
	public String addproject(Model map) {
		ProjectType arr[] = ProjectType.values();
		map.addAttribute("projecttype",arr);
		ProjectStatus arr1[] = ProjectStatus.values();
		map.addAttribute("projectstatus",arr1);
		System.out.println("Enum Value"+Arrays.toString(arr));
		System.out.println("Enum Value"+Arrays.toString(arr1));
		System.out.println("in project");
		return "/project/add_project";
	}

	@PostMapping("/add_project")
	public String ProjectEnrolment(@RequestParam String projectLocation, @RequestParam String projectName,
			@RequestParam String projectPinCode, @RequestParam String projectType1,
			@RequestParam String projectStatus1,
			Model map, RedirectAttributes flashMap, HttpSession session) {
		System.out.println(projectType1+"  "+projectStatus1);
		ProjectType projectType =ProjectType.valueOf(projectType1);
		ProjectStatus projectStatus =ProjectStatus.valueOf(projectStatus1);
		System.out.println(projectType+"  "+projectStatus);
		System.out.println("id :: " + projectName);
		// create Emplyee Transient pojo n invoke employeeService layer method
		Project pjt = new Project(projectLocation,projectName,projectPinCode,projectType,projectStatus);
		try {
			session.setAttribute("message", projectService.addProject(pjt));
			// =>success : redirect client to the logout page to avoid double submit issue
			return "/admin/home";
		} catch (ProjectCustomException e) {
			map.addAttribute("err_message", e.getMessage());
			return "/project/add_project";
		}

	}
}
