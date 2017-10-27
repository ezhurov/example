package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.services.EmailService;

@Controller
public class ForgotPassword {
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/forgot_password.html")
	public String forgotPassword(Model model) {
		
		return "WEB-INF/pages/forgotpassword.jsp";
		
	}
	
	@RequestMapping("/send_email.html")
	public String sendEmail(@RequestParam("email") String to) {
		
		emailService.forgotPassword(to);
		
		return "redirect:/authorization.html";
		
	}
	
}

