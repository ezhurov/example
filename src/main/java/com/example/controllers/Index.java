package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.services.UsersService;

@Controller
public class Index {
	
	@Autowired
	private UsersService usersService;

	@RequestMapping({"/", "/index.html"})
	public String index(Model model) {
		
		if (SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) {
			model.addAttribute("authorizationvisibility", "inline");
			model.addAttribute("logoutvisibility", "none");
			model.addAttribute("deletevisibility", "none");
			model.addAttribute("changepasswordvisibility", "none");
		} else {
			model.addAttribute("authorizationvisibility", "none");
			model.addAttribute("logoutvisibility", "inline");
			model.addAttribute("deletevisibility", "inline");
			model.addAttribute("changepasswordvisibility", "inline");
		}
		
		return "WEB-INF/pages/index.jsp";
		
	}
	
	@RequestMapping("/deleteaccount.html")
	public String deleteaccount() {
		
		usersService.deleteaccount(SecurityContextHolder.getContext().getAuthentication().getName());
		
		return "redirect:/authorization.html";
		
	}
	
}
