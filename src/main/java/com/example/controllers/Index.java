package com.example.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entities.Games;
import com.example.services.GamesService;
import com.example.services.StatisticService;
import com.example.services.UsersService;
import com.google.gson.Gson;

@Controller
public class Index {
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private GamesService gamesService;
	
	@Autowired
	private StatisticService statisticService;

	@RequestMapping({"/", "/index.html"})
	public String index(Model model) {
		
		Set<String> roles = AuthorityUtils.authorityListToSet(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		List<Games> pendingGames = gamesService.selectPendingGames();
		
		if (SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) {
			model.addAttribute("registration_visibility", "inline");
			model.addAttribute("authorization_visibility", "inline");
			model.addAttribute("logout_visibility", "none");
			model.addAttribute("delete_visibility", "none");
			model.addAttribute("create_game_visibility", "none");
			model.addAttribute("statistic_visibility", "none");
			model.addAttribute("change_password_visibility", "none");
			model.addAttribute("management_of_users_visibility", "none");
			model.addAttribute("pendingGames", pendingGames);
			model.addAttribute("pending_games_visibility", (! pendingGames.isEmpty()) ? "table" : "none");
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
			model.addAttribute("create_game_visibility", "inline");
			model.addAttribute("statistic_visibility", "inline");
			model.addAttribute("username", username);
			model.addAttribute("wins", statisticService.getWinsByUser(username));
			model.addAttribute("fails", statisticService.getFailsByUser(username));
			model.addAttribute("draws", statisticService.getDrawsByUser(username));
			model.addAttribute("pendingGames", pendingGames);
			model.addAttribute("pending_games_visibility", (! pendingGames.isEmpty()) ? "table" : "none");
		}
		
		return "WEB-INF/pages/index.jsp";
		
	}
	
	@RequestMapping("/delete_account.html")
	public String deleteAccount() {
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		usersService.deleteAccountByUsername(username);
		
		return "redirect:/authorization.html";
		
	}
	
	@RequestMapping("/auto_update_pending_games.html")
	@ResponseBody
	public String autoUpdatePendingGames() {
		
		List<Games> pendingGames = gamesService.selectPendingGames();
		return new Gson().toJson(pendingGames);
		
	}
	
}
