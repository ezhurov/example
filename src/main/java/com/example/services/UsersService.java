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
		
		List<Users> users = usersDao.getUserByUsername(username);
		if (! users.isEmpty()) {
			return (locale.getLanguage().equals("en") ? "This username is busy" : "Этот логин уже занят");
		} else {
			return "";
		}
		
	}
	
	public String checkemail(String email, Locale locale) {
		
		List<Users> users = usersDao.getUserByEmail(email);
		if (! users.isEmpty()) {
			return (locale.getLanguage().equals("en") ? "This e-mail is busy" : "Этот e-mail уже занят");
		} else {
			return "";
		}
		
	}
	
	public String checkoldpassword(String username, String oldpassword, Locale locale) {
		
		Users currentUser = usersDao.getUserByUsername(username).get(0);
		if (currentUser.getPassword().equals(oldpassword)) {
			return "";
		} else {
			return (locale.getLanguage().equals("en") ? "Uncorrectly password" : "Неправильно введен пароль");
		}
		
	}
	
	public List<Users> getUserByEmail(String email) {
		
		return usersDao.getUserByEmail(email);
		
	}
	
	public void deleteaccount(String username) {
		
		usersDao.deleteUserByUsername(username);
		
	}
	
	public void changePasswordByUsername(String username, String oldpassword, String newpassword) {
		
		Users currentUser = usersDao.getUserByUsername(username).get(0);
		if (currentUser.getPassword().equals(oldpassword)) {
			usersDao.changePasswordByUsername(username, newpassword);
		}
		
	}
	
}
