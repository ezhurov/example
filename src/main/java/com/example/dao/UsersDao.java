package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Users;

@Repository
public class UsersDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@SuppressWarnings("all")
	public void addUser(String username, String password, String email) {
		
		Session session = sessionFactory.getCurrentSession();
		NativeQuery query = session.createNativeQuery("INSERT INTO users (username, password, email) VALUES (:username, :password, :email)");
		query.setParameter("username", username);
		query.setParameter("password", password);
		query.setParameter("email", email);
		query.executeUpdate();
		
	}
	
	@Transactional
	@SuppressWarnings("all")
	public List<Users> checkusername(String username) {
		
		Session session = sessionFactory.getCurrentSession();
		Query<Users> query = session.createQuery("FROM Users WHERE username = :username");
		query.setParameter("username", username);
		return query.getResultList();
		
	}
	
	@Transactional
	@SuppressWarnings("all")
	public List<Users> checkemail(String email) {
		
		Session session = sessionFactory.getCurrentSession();
		Query<Users> query = session.createQuery("FROM Users WHERE email = :email");
		query.setParameter("email", email);
		return query.getResultList();
		
	}
	
}