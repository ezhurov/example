package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.StatisticDao;
import com.example.dao.UsersDao;
import com.example.entities.Statistic;
import com.example.entities.Users;

@Service
@Transactional
public class StatisticService {

	@Autowired
	private StatisticDao statisticDao;
	
	@Autowired
	private UsersDao usersDao;
	
	public int getWinsByUser(String username) {
		
		Users user = usersDao.getUserByUsername(username).get(0);
		
		List<Statistic> statistic = statisticDao.getStatisticByUser(user.getId());
		
		if ((! statistic.isEmpty()) && (statistic.get(0) != null) ) {
			return statistic.get(0).getWins();
		} else {
			return 0;
		}
		
	}
	
	public int getFailsByUser(String username) {
		
		Users user = usersDao.getUserByUsername(username).get(0);
		
		List<Statistic> statistic = statisticDao.getStatisticByUser(user.getId());
		
		if ((! statistic.isEmpty()) && (statistic.get(0) != null) ) {
			return statistic.get(0).getFails();
		} else {
			return 0;
		}
		
	}
	
	public int getDrawsByUser(String username) {
		
		Users user = usersDao.getUserByUsername(username).get(0);
		
		List<Statistic> statistic = statisticDao.getStatisticByUser(user.getId());
		
		if ((! statistic.isEmpty()) && (statistic.get(0) != null) ) {
			return statistic.get(0).getDraws();
		} else {
			return 0;
		}
		
	}
	
}
