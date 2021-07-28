package com.project.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.springboot.model.Admin;
import com.project.springboot.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	//Display List of all Admin
	@GetMapping("/ViewallAdmins")
	public String viewallAdmins(Model model) {
		model.addAttribute("listAdmins",adminService.getAllAdmins());
		return "ViewAllAdmin";
	}
	@GetMapping("/AdminRegistrationForm")
	public String AdminRegistrationForm(Model model) {
		Admin admin=new Admin();
		model.addAttribute("admin",admin);
		return "adminRegistration";
		
	}
	
	@PostMapping("/saveAdmin")
	public String SaveAdmin(@ModelAttribute("admin") Admin admin) {
		adminService.saveAdmin(admin);
		return "redirect:/";
	}
	
	@GetMapping("showAdminforUpdate/{id}")
	public String ShowformforAdminUpdate(@PathVariable(value="id")int id,Model model) {
		//Get Admin from Service
		Admin admin=adminService.getAdminbyId(id);
		
		//Set ADmin as model attribute to prepopulate the form data
		model.addAttribute("admin",admin);
		return "update_admin";
	}
	
	@GetMapping("/deleteAdmin/{id}")
	public String deleteAdmin(@PathVariable(value="id")int id,Model model) {
		this.adminService.deleteAdminbyId(id);
		return "redirect:/";
	}
}
	
