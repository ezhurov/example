package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.services.GamesService;

@Controller
@SessionAttributes("url")
public class Chess {
	
	@Autowired
	private GamesService gamesService;
	
	@RequestMapping("/create_game_button.html")
	@ResponseBody
	public String createGameButton(@RequestParam("color") String color, Model model) {
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		int idNewGame = gamesService.createGame(color, username);
		
		model.addAttribute("url", idNewGame);
		
		return String.valueOf(idNewGame) + ".html";
		
	}
	
	@RequestMapping("/{url}.html")
	public String play() {
		
		return "WEB-INF/pages/chess.html";
		
	}
	
}
