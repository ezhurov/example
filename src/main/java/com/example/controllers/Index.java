package com.example.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
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
		
		Set<String> roles = AuthorityUtils.authorityListToSet(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		
		if (SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) {
			model.addAttribute("registration_visibility", "inline");
			model.addAttribute("authorization_visibility", "inline");
			model.addAttribute("logout_visibility", "none");
			model.addAttribute("delete_visibility", "none");
			model.addAttribute("change_password_visibility", "none");
			model.addAttribute("management_of_users_visibility", "none");
		} else {
			if (roles.contains("ROLE_ADMIN")) {
				model.addAttribute("management_of_users_visibility", "inline");
			} else {
				model.addAttribute("management_of_users_visibility", "none");
			}
			model.addAttribute("registration_visibility", "none");
			model.addAttribute("authorization_visibility", "none");
			model.addAttribute("logout_visibility", "inline");
			model.addAttribute("delete_visibility", "inline");
			model.addAttribute("change_password_visibility", "inline");
		}
		
		return "WEB-INF/pages/index.jsp";
		
	}
	
	@RequestMapping("/delete_account.html")
	public String deleteAccount() {
		
		usersService.deleteAccountByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		
		return "redirect:/authorization.html";
		
	}
	
}
