package com.example.controllers;

import java.util.Locale;

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
	
	@RequestMapping("/add_user.html")
	public String addUser(@RequestParam("username") String username, @RequestParam("password") String password, 
			@RequestParam("email") String email, Model model) {
		
		usersService.addUser(username, password, email);
		
		return "redirect:/index.html";
		
	}
	
	@RequestMapping("/check_username.html")
	@ResponseBody
	public String checkUsername(@RequestParam("username") String username, Locale locale) {
		
		return usersService.checkUsername(username, locale);
		
	}
	
	@RequestMapping("/check_email.html")
	@ResponseBody
	public String checkEmail(@RequestParam("email") String email, Locale locale) {
	
		return usersService.checkEmail(email, locale);
		
	}
	
}
