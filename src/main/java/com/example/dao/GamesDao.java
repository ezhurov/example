package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.entities.Games;

@Repository
@SuppressWarnings("all")
public class GamesDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void addGame(Games game) {
		
		entityManager.persist(game);
		
	}
	
	public List<Games> selectPendingGames() {

		return entityManager.createQuery("FROM Games WHERE (white_id IS NULL OR black_id IS NULL)").getResultList();
		
	}
	
}
