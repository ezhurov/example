package com.example.controllers;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.entities.Users;
import com.example.services.UsersService;
import com.google.gson.Gson;

@Controller
@Secured("ROLE_ADMIN")
@SessionAttributes("typeFilter")
public class ManagementOfUsers {

	@Autowired
	private UsersService usersService;
	
	@RequestMapping("/management_of_all_users.html")
	public String managementOfAllUsers(Model model, Locale locale) {
		
		List<Users> allUsers = usersService.getAllUsers();
		
		model.addAttribute("users", allUsers);
		model.addAttribute("table_visibility", allUsers.isEmpty() ? "none" : "table");
		model.addAttribute("table_is_empty", allUsers.isEmpty() ? messageTableIsEmpty(locale) : "");
		model.addAttribute("typeFilter", "all");
		model.addAttribute("checked_all_users", "checked");
		
		return "WEB-INF/pages/managementofusers.jsp";
		
	}
	
	@RequestMapping("/management_of_locked_users.html")
	public String managementOfLockedUsers(Model model, Locale locale) {
		
		List<Users> lockedUsers = usersService.getLockedUsers();
		
		model.addAttribute("users", lockedUsers);
		model.addAttribute("table_visibility", lockedUsers.isEmpty() ? "none" : "table");
		model.addAttribute("table_is_empty", lockedUsers.isEmpty() ? messageTableIsEmpty(locale) : "");
		model.addAttribute("typeFilter", "locked");
		model.addAttribute("checked_locked_users", "checked");
		
		return "WEB-INF/pages/managementofusers.jsp";
		
	}
	
	@RequestMapping("/management_of_unlocked_users.html")
	public String managementOfUnlockedUsers(Model model, Locale locale) {
		
		List<Users> unlockedUsers = usersService.getUnlockedUsers();
		
		model.addAttribute("users", unlockedUsers);
		model.addAttribute("table_visibility", unlockedUsers.isEmpty() ? "none" : "table");
		model.addAttribute("table_is_empty", unlockedUsers.isEmpty() ? messageTableIsEmpty(locale) : "");
		model.addAttribute("typeFilter", "unlocked");
		model.addAttribute("checked_unlocked_users", "checked");
		
		return "WEB-INF/pages/managementofusers.jsp";
		
	}
	
	@RequestMapping("/delete_account_by_username.html")
	public String deleteAccountByUsername(@RequestParam("username") String username,
			@ModelAttribute("typeFilter") String typeFilter, SessionStatus sessionStatus) {
		
		sessionStatus.setComplete();
		
		usersService.deleteAccountByUsername(username);
		
		if (typeFilter.equals("locked")) {
			return "redirect:/management_of_locked_users.html";
		} else if (typeFilter.equals("unlocked")) {
			return "redirect:/management_of_unlocked_users.html";
		} else {
			return "redirect:/management_of_all_users.html";
		}
		
	}

	@RequestMapping("/lock_account_by_username.html")
	public String lockAccountByUsername(@RequestParam("username") String username, @RequestParam("enabled") String enabled,
			@ModelAttribute("typeFilter") String typeFilter, SessionStatus sessionStatus) {
		
		sessionStatus.setComplete();
		
		if (enabled.equals("true")) {
			usersService.lockAccountByUsername(username);
		} else if (enabled.equals("false")) {
			usersService.unlockAccountByUsername(username);
		}
		
		if (typeFilter.equals("locked")) {
			return "redirect:/management_of_locked_users.html";
		} else if (typeFilter.equals("unlocked")) {
			return "redirect:/management_of_unlocked_users.html";
		} else {
			return "redirect:/management_of_all_users.html";
		}
		
	}
	
	@RequestMapping("/set_as_admin_user.html")
	public String setAsAdminUser(@RequestParam("username") String username, @RequestParam("role") String role,
			@ModelAttribute("typeFilter") String typeFilter, SessionStatus sessionStatus) {
		
		sessionStatus.setComplete();
		
		if (role.equals("ROLE_ADMIN")) {
			usersService.setRoleAsUserByUsername(username);
		} else if (role.equals("ROLE_USER")) {
			usersService.setRoleAsAdminByUsername(username);
		}
		
		if (typeFilter.equals("locked")) {
			return "redirect:/management_of_locked_users.html";
		} else if (typeFilter.equals("unlocked")) {
			return "redirect:/management_of_unlocked_users.html";
		} else {
			return "redirect:/management_of_all_users.html";
		}
		
	}
	
	@RequestMapping("/get_users_by_half_username.html")
	@ResponseBody
	public String getUsersByHalfUsername(@RequestParam("username") String username,
			@ModelAttribute("typeFilter") String typeFilter, SessionStatus sessionStatus) {
		
		if (typeFilter.equals("locked")) {
			List<String> usersList = usersService.getLockedUsersByHalfUsername(username);
			return new Gson().toJson(usersList);
		} else if (typeFilter.equals("unlocked")) {
			List<String> usersList = usersService.getUnlockedUsersByHalfUsername(username);
			return new Gson().toJson(usersList);
		} else {
			List<String> usersList = usersService.getAllUsersByHalfUsername(username);
			return new Gson().toJson(usersList);
		}

	}
	
	@RequestMapping("/select_user_by_half_username.html")
	@ResponseBody
	public String selectUserByHalfUsername(@RequestParam("username") String username) {
		
		Users user = usersService.getMapOfUserByUsername(username);
		
		if (user != null) {
			return new Gson().toJson(user);
		} else {
			return "";
		}
		
	}
	
	public String messageTableIsEmpty(Locale locale) {
		
		return locale.getLanguage().equals("en") ? "Table is empty" : "Таблица пуста";
		
	}
	
}
