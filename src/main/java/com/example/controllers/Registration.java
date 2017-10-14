package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.services.UsersService;

@Controller
public class Registration {
	
	@Autowired
	private UsersService usersService;

	@RequestMapping("/registration.html")
	public String registration() {
		
		return "WEB-INF/pages/registration.jsp";
		
	}
	
	@RequestMapping("/adduser.html")
	public String adduser(@RequestParam("username") String username, @RequestParam("password") String password, 
			@RequestParam("email") String email, Model model) {
		
		usersService.addUser(username, password, email);
		
		return "redirect:/index.html";
		
	}
	
	@RequestMapping("/checkusername.html")
	@ResponseBody
	public String checkusername(@RequestParam("username") String username, Model model) {
		
		return usersService.checkusername(username);
		
	}
	
	@RequestMapping("/checkemail.html")
	@ResponseBody
	public String checkemail(@RequestParam("email") String email) {
	
		return usersService.checkemail(email);
		
	}
	
}
