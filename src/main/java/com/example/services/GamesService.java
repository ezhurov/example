package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.GamesDao;
import com.example.dao.UsersDao;
import com.example.entities.Games;
import com.example.entities.Users;

@Service
@Transactional
public class GamesService {
	
	@Autowired
	private GamesDao gamesDao;
	
	@Autowired 
	private UsersDao usersDao;
	
	public int createGame(String color, String username) {
		
		Users user = usersDao.getUserByUsername(username).get(0);
		Games games = new Games();
		
		if (color.equals("white")) {
			games.setWhite_id(usersDao.getUserByUsername(user.getUsername()).get(0));
			gamesDao.addGame(games);
		} else if (color.equals("black")) {
			games.setBlack_id(usersDao.getUserByUsername(user.getUsername()).get(0));
			gamesDao.addGame(games);
		}
		
		return games.getId();
		
	}
	
	public List<Games> selectPendingGames() {
		
		return gamesDao.selectPendingGames();
		
	}
	
}
