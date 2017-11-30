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
			games.setWhiteId(usersDao.getUserByUsername(user.getUsername()).get(0));
		} else if (color.equals("black")) {
			games.setBlackId(usersDao.getUserByUsername(user.getUsername()).get(0));
		} else if (color.equals("random")) {
			int random = (int) (Math.random() * 2 + 1);
			if (random == 1) {
				games.setWhiteId(usersDao.getUserByUsername(user.getUsername()).get(0));
			} else {
				games.setBlackId(usersDao.getUserByUsername(user.getUsername()).get(0));
			}	
		}
		
		gamesDao.addGame(games);
		
		return games.getId();
		
	}
	
	public List<Games> selectPendingGames() {
		
		return gamesDao.selectPendingGames();
		
	}
	
}
