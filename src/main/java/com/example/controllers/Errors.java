package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Errors {

	@RequestMapping("/403.html")
	public String error403() {
		
		return "WEB-INF/pages/403.jsp";
		
	}

	@RequestMapping("/404.html")
	public String error404() {
		
		return "WEB-INF/pages/404.jsp";
			
	}
	
}
