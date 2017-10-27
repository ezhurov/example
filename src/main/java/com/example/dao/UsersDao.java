package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Users;

@Repository
public class UsersDao {
	
	@PersistenceContext
	private EntityManager session;

	@Transactional
	@SuppressWarnings("all")
	public void addUser(String username, String password, String email) {

		Query query = session.createNativeQuery("INSERT INTO users (username, password, email) VALUES (:username, :password, :email)");
		query.setParameter("username", username);
		query.setParameter("password", password);
		query.setParameter("email", email);
		query.executeUpdate();
		
	}
	
	@Transactional
	@SuppressWarnings("all")
	public List<Users> getUserByUsername(String username) {
		
		Query query = session.createQuery("FROM Users WHERE username = :username");
		query.setParameter("username", username);
		return query.getResultList();
		
	}
	
	@Transactional
	@SuppressWarnings("all")
	public List<Users> getUserByEmail(String email) {
		
		Query query = session.createQuery("FROM Users WHERE email = :email");
		query.setParameter("email", email);
		return query.getResultList();
		
	}
	
	@Transactional
	@SuppressWarnings("all")
	public void deleteUserByUsername(String username) {
		
		Query query = session.createNativeQuery("DELETE FROM Users WHERE username = :username");
		query.setParameter("username", username);
		query.executeUpdate();
		
	}
	
	@Transactional
	@SuppressWarnings("all")
	public void changePasswordByUsername(String username, String password) {
		
		Query query = session.createNativeQuery("UPDATE users SET password = :password WHERE username = :username");
		query.setParameter("username", username);
		query.setParameter("password", password);
		query.executeUpdate();
		
	}
	
	@Transactional
	@SuppressWarnings("all")
	public List<Users> getAllUsersOrderByUsername() {
		
		Query query = session.createQuery("FROM Users ORDER BY username");
		return query.getResultList();
		
	}
	
	@Transactional
	@SuppressWarnings("all")
	public List<Users> getLockedUsersOrderByUsername() {
		
		Query query = session.createQuery("FROM Users WHERE enabled = false ORDER BY username");
		return query.getResultList();
		
	}
	
	@Transactional
	@SuppressWarnings("all")
	public List<Users> getUnlockedUsersOrderByUsername() {
		
		Query query = session.createQuery("FROM Users WHERE enabled = true ORDER BY username");
		return query.getResultList();
		
	}
	
	@Transactional
	@SuppressWarnings("all")
	public void lockAccountByUsername(String username) {
		
		Query query = session.createNativeQuery("UPDATE users SET enabled = false WHERE username = :username");
		query.setParameter("username", username);
		query.executeUpdate();
		
	}
	
	@Transactional
	@SuppressWarnings("all")
	public void unlockAccountByUsername(String username) {
		
		Query query = session.createNativeQuery("UPDATE users SET enabled = true WHERE username = :username");
		query.setParameter("username", username);
		query.executeUpdate();
		
	}
	
	@Transactional
	@SuppressWarnings("all")
	public void setRoleAsAdminByUsername(String username) {
		
		Query query = session.createNativeQuery("UPDATE users SET role = 'ROLE_ADMIN' WHERE username = :username");
		query.setParameter("username", username);
		query.executeUpdate();
		
	}
	
	@Transactional
	@SuppressWarnings("all")
	public void setRoleAsUserByUsername(String username) {
		
		Query query = session.createNativeQuery("UPDATE users SET role = 'ROLE_USER' WHERE username = :username");
		query.setParameter("username", username);
		query.executeUpdate();
		
	}
	
	@Transactional
	@SuppressWarnings("all")
	public List<Users> getAllUsersByHalfUsername(String username) {
		
		Query query = session.createQuery("FROM Users WHERE username LIKE :username");
		query.setParameter("username", username + "%");
		return query.getResultList();
		
	}
	
	@Transactional
	@SuppressWarnings("all")
	public List<Users> getLockedUsersByHalfUsername(String username) {
		
		Query query = session.createQuery("FROM Users WHERE (enabled = false AND username LIKE :username)");
		query.setParameter("username", username + "%");
		return query.getResultList();
		
	}
	
	@Transactional
	@SuppressWarnings("all")
	public List<Users> getUnlockedUsersByHalfUsername(String username) {
		
		Query query = session.createQuery("FROM Users WHERE (enabled = true AND username LIKE :username)");
		query.setParameter("username", username + "%");
		return query.getResultList();
		
	}
	
}
