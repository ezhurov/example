package com.example.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UsersDao;
import com.example.entities.Users;

@Service
@Transactional
public class UsersService {
	
	@Autowired
	private UsersDao usersDao;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	public void addUser(String username, String password, String email) {
		
		usersDao.addUser(username, bcryptEncoder.encode(password), email);
		
	}
	
	public String checkUsername(String username, Locale locale) {
		
		List<Users> users = usersDao.getUserByUsername(username);
		if (! users.isEmpty()) {
			return (locale.getLanguage().equals("en") ? "This username is busy" : "Этот логин уже занят");
		} else {
			return "";
		}
		
	}
	
	public String checkEmail(String email, Locale locale) {
		
		List<Users> users = usersDao.getUserByEmail(email);
		if (! users.isEmpty()) {
			return (locale.getLanguage().equals("en") ? "This e-mail is busy" : "Этот e-mail уже занят");
		} else {
			return "";
		}
		
	}
	
	public String checkOldPassword(String username, String oldpassword, Locale locale) {
		
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
	
	public void deleteAccountByUsername(String username) {
		
		usersDao.deleteUserByUsername(username);
		
	}
	
	public void changePasswordByUsername(String username, String oldpassword, String newpassword) {
		
		Users currentUser = usersDao.getUserByUsername(username).get(0);
		if (currentUser.getPassword().equals(oldpassword)) {
			usersDao.changePasswordByUsername(username, newpassword);
		}
		
	}
	
	public List<Users> getAllUsersOrderByUsername() {
		
		return usersDao.getAllUsersOrderByUsername();
		
	}
	
	public List<Users> getLockedUsersOrderByUsername() {
		
		return usersDao.getLockedUsersOrderByUsername();
		
	}
	
	public List<Users> getUnlockedUsersOrderByUsername() {
		
		return usersDao.getUnlockedUsersOrderByUsername();
		
	}
	
	public void lockAccountByUsername(String username) {
		
		usersDao.lockAccountByUsername(username);
		
	}
	
	public void unlockAccountByUsername(String username) {
		
		usersDao.unlockAccountByUsername(username);
		
	}
	
	public void setRoleAsAdminByUsername(String username) {
		
		usersDao.setRoleAsAdminByUsername(username);
		
	}
	
	public void setRoleAsUserByUsername(String username) {
		
		usersDao.setRoleAsUserByUsername(username);
		
	}

	public List<String> getAllUsersByHalfUsername(String username) {
		
		List<String> listUsername = new LinkedList<String>();
		List<Users> users = usersDao.getAllUsersByHalfUsername(username);
		
		for (Users user : users) {
			listUsername.add(user.getUsername());
		}
		
		return listUsername;
		
	}
	
	public List<String> getLockedUsersByHalfUsername(String username) {
		
		List<String> listUsername = new LinkedList<String>();
		List<Users> users = usersDao.getLockedUsersByHalfUsername(username);
		
		for (Users user : users) {
			listUsername.add(user.getUsername());
		}
		
		return listUsername;
		
	}
	
	public List<String> getUnlockedUsersByHalfUsername(String username) {
		
		List<String> listUsername = new LinkedList<String>();
		List<Users> users = usersDao.getUnlockedUsersByHalfUsername(username);
		
		for (Users user : users) {
			listUsername.add(user.getUsername());
		}
		
		return listUsername;
		
	}
	
	public Users getUserByUsername(String username) {
		
		return usersDao.getUserByUsername(username).get(0);
		
	}
	
}
