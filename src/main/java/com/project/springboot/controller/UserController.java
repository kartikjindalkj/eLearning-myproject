package com.project.springboot.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.springboot.model.User;
import com.project.springboot.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	 
	/*
	 * @InitBinder public void initBinder(WebDataBinder binder){
	 * binder.registerCustomEditor( Date.class, new CustomDateEditor(new Simp
	 leDateFormat("yyyy-MM-dd"), true, 10)); }
	 */
	
	//Display List of all Users
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listUsers",userService.getAllUsers());
		return "index";
	}
	
	@GetMapping("/RegistrationForm")
	public String UserRegistration(Model model) {
		User user=new User();
		model.addAttribute("user",user);
		return "userRegistration";
	}
	
	@PostMapping("/saveUser")
	public String SaveUser(@ModelAttribute("user") User user) {
		//save user to DB
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		String formatted=formatter.format(new java.util.Date());
		user.setReg_date(formatted);		
		userService.saveUser(user);
		return "redirect:/";
	}
	
	@GetMapping("showUserforUpdate/{id}")
	public String ShowformforUpdate(@PathVariable(value="id") int id,Model model) {
		//Get user from Service
		User user=userService.getUserbyId(id);
		
		//set user as model attribute to prepopulate the form data
		model.addAttribute("user",user);
		return "update_user";
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable(value="id")int id,Model model) {
		
		//call delete user method from service
		this.userService.deleteUserbyID(id);
		return "redirect:/";
		
	}
}
