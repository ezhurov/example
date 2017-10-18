package com.example.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.services.EmailService;

@Controller
public class ForgotPassword {
	
	@Autowired
	private EmailService emailService;
	
	@Value("#{contextParameters.email}")
	private String email;
	
	@Value("#{contextParameters.password}")
	private String password;

	@RequestMapping("/forgotpassword.html")
	public String forgotpassword(Model model) {
		
		return "WEB-INF/pages/forgotpassword.jsp";
		
	}
	
	@RequestMapping("/sendemail.html")
	public String sendEmail(@RequestParam("email") String to, Model model, Locale locale) {
		
		emailService.forgotPassword(to, email, password);
		
		return "redirect:/authorization.html";
		
	}
	
}

