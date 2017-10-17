package com.example.controllers;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {

	@RequestMapping({"/", "/index.html"})
	public String index(Model model) {
		
		if (SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) {
			model.addAttribute("authorizationvisibility", "inline");
			model.addAttribute("indexvisibility", "none");
		} else {
			model.addAttribute("authorizationvisibility", "none");
			model.addAttribute("indexvisibility", "inline");
		}
		
		return "WEB-INF/pages/index.jsp";
		
	}
	
}
