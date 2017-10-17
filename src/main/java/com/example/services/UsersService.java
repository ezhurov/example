package com.example.services;

import java.util.List;
import java.util.Locale;

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
	
	public String checkusername(String username, Locale locale) {
		
		List<Users> users = usersDao.checkusername(username);
		if (! users.isEmpty()) {
			return (locale.getLanguage().equals("en") ? "This username is busy" : "Этот логин уже занят");
		} else {
			return "";
		}
		
	}
	
	public String checkemail(String email, Locale locale) {
		
		List<Users> users = usersDao.checkemail(email);
		if (! users.isEmpty()) {
			return (locale.getLanguage().equals("en") ? "This e-mail is busy" : "Этот e-mail уже занят");
		} else {
			return "";
		}
		
	}
	
}
