package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.entities.Statistic;

@Repository
@SuppressWarnings("all")
public class StatisticDao {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Statistic> getStatisticByUser(int userid) {
		
		Query query = entityManager.createQuery("FROM Statistic WHERE user = (FROM Users WHERE id = :userid)");
		query.setParameter("userid", userid);
		return query.getResultList();

	}
	
}
