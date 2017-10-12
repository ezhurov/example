package com.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UsersDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void addUser(String username, String password) {
		
		Session session = sessionFactory.getCurrentSession();
		NativeQuery query = session.createNativeQuery("INSERT INTO users (username, password) VALUES (:username, :password)");
		query.setParameter("username", username);
		query.setParameter("password", password);
		query.executeUpdate();
		
	}
	
}