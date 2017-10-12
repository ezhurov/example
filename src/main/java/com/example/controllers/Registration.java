package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String adduser(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
		
		usersService.addUser(username, password);
		
		return "redirect:/index.html";
		
	}
	
}
