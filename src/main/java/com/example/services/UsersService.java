package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UsersDao;
import com.example.entities.Users;

@Service
public class UsersService {
	
	@Autowired
	private UsersDao usersDao;

	public void addUser(String username, String password, String email) {
		
		usersDao.addUser(username, password, email);
		
	}
	
	public String checkusername(String username) {
		
		if (username.isEmpty()) {
			return "Fill this field";
		}
		
		List<Users> users = usersDao.checkusername(username);
		if (! users.isEmpty()) {
			return "This username is busy";
		} else {
			return "";
		}
		
	}
	
	public String checkemail(String email) {
		
		if (email.isEmpty()) {
			return "Fill this field";
		}
		
		List<Users> users = usersDao.checkemail(email);
		if (! users.isEmpty()) {
			return "This email is busy";
		} else {
			return "";
		}
		
	}
	
}
