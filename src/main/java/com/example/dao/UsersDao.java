package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.entities.Users;

@Repository
@SuppressWarnings("all")
public class UsersDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void addUser(String username, String password, String email, String role) {

		Query query = entityManager.createNativeQuery("INSERT IGNORE INTO users (username, password, email, role) VALUES (:username, :password, :email, :role)");
		query.setParameter("username", username);
		query.setParameter("password", password);
		query.setParameter("email", email);
		query.setParameter("role", role);
		query.executeUpdate();
		
	}
	
	public List<Users> getUserByUsername(String username) {
		
		Query query = entityManager.createQuery("FROM Users WHERE username = :username");
		query.setParameter("username", username);
		return query.getResultList();
		
	}
	
	public List<Users> getUserByEmail(String email) {
		
		Query query = entityManager.createQuery("FROM Users WHERE email = :email");
		query.setParameter("email", email);
		return query.getResultList();
		
	}
	
	public void deleteUserByUsername(String username) {
		
		Query query = entityManager.createNativeQuery("DELETE FROM Users WHERE username = :username");
		query.setParameter("username", username);
		query.executeUpdate();
		
	}
	
	public void changePasswordByUsername(String username, String password) {
		
		Query query = entityManager.createNativeQuery("UPDATE users SET password = :password WHERE username = :username");
		query.setParameter("username", username);
		query.setParameter("password", password);
		query.executeUpdate();
		
	}
	
	public List<Users> getAllUsersOrderByUsername() {
		
		Query query = entityManager.createQuery("FROM Users ORDER BY username");
		return query.getResultList();
		
	}
	
	public List<Users> getLockedUsersOrderByUsername() {
		
		Query query = entityManager.createQuery("FROM Users WHERE enabled = false ORDER BY username");
		return query.getResultList();
		
	}
	
	public List<Users> getUnlockedUsersOrderByUsername() {
		
		Query query = entityManager.createQuery("FROM Users WHERE enabled = true ORDER BY username");
		return query.getResultList();
		
	}
	
	public void lockAccountByUsername(String username) {
		
		Query query = entityManager.createNativeQuery("UPDATE users SET enabled = false WHERE username = :username");
		query.setParameter("username", username);
		query.executeUpdate();
		
	}
	
	public void unlockAccountByUsername(String username) {
		
		Query query = entityManager.createNativeQuery("UPDATE users SET enabled = true WHERE username = :username");
		query.setParameter("username", username);
		query.executeUpdate();
		
	}
	
	public void setRoleAsAdminByUsername(String username) {
		
		Query query = entityManager.createNativeQuery("UPDATE users SET role = 'ROLE_ADMIN' WHERE username = :username");
		query.setParameter("username", username);
		query.executeUpdate();
		
	}
	
	public void setRoleAsUserByUsername(String username) {
		
		Query query = entityManager.createNativeQuery("UPDATE users SET role = 'ROLE_USER' WHERE username = :username");
		query.setParameter("username", username);
		query.executeUpdate();
		
	}
	
	public List<Users> getAllUsersByHalfUsername(String username) {
		
		Query query = entityManager.createQuery("FROM Users WHERE username LIKE :username");
		query.setParameter("username", username + "%");
		return query.getResultList();
		
	}
	
	public List<Users> getLockedUsersByHalfUsername(String username) {
		
		Query query = entityManager.createQuery("FROM Users WHERE (enabled = false AND username LIKE :username)");
		query.setParameter("username", username + "%");
		return query.getResultList();
		
	}
	
	public List<Users> getUnlockedUsersByHalfUsername(String username) {
		
		Query query = entityManager.createQuery("FROM Users WHERE (enabled = true AND username LIKE :username)");
		query.setParameter("username", username + "%");
		return query.getResultList();
		
	}
	
}
