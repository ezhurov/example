package com.example.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.services.UsersService;

@Controller
public class ChangePassword {
	
	@Autowired
	private UsersService usersService;

	@RequestMapping("/changepassword.html")
	public String changePassword() {
		
		return "WEB-INF/pages/changepassword.jsp";
		
	}
	
	@RequestMapping("/changingpassword.html")
	public String changingPassword(@RequestParam("oldpassword") String oldpassword, @RequestParam("newpassword") String newpassword) {
		
		usersService.changePasswordByUsername(SecurityContextHolder.getContext().getAuthentication().getName(), oldpassword, newpassword);
		
		return "redirect:/authorization.html";
		
	}
	
	@RequestMapping("/checkoldpassword.html")
	@ResponseBody
	public String checkoldpassword(@RequestParam("oldpassword") String oldpassword, Locale locale) {
		
		return usersService.checkoldpassword(SecurityContextHolder.getContext().getAuthentication().getName(), oldpassword, locale);
		
	}
	
}
