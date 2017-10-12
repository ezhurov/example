package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UsersDao;

@Service
public class UsersService {
	
	@Autowired
	private UsersDao usersDao;

	public void addUser(String username, String password) {
		
		usersDao.addUser(username, password);
		
	}
	
}
