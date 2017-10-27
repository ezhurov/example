package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Authorization {

	@RequestMapping("/authorization.html")
	public String authorization(@RequestParam(name="error", required=false) String error, Model model) {
		
		model.addAttribute("error_username_visibility", error != null && error.equals("true") ? "inline" : "none");
		
		return "WEB-INF/pages/authorization.jsp";
		
	}
	
}
