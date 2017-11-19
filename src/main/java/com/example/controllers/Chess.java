package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.services.GamesService;

@Controller
public class Chess {
	
	@Autowired
	private GamesService gamesService;
	
	@RequestMapping("/create_game_button.html")
	@ResponseBody
	public String createGameButton(@RequestParam("color") String color) {
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		int idNewGame = gamesService.createGame(color, username);
		
		return String.valueOf(idNewGame);
		
	}
	
	@RequestMapping("/{url}.html")
	public String openBoard(@PathVariable("url") String url) {
		
		return "WEB-INF/pages/chess.jsp";
		
	}
	
}
