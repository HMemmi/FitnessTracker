package com.pluralsight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;
import com.pluralsight.repository.GoalRepository;

@Service("goalService")
public class GoalServiceImpl implements GoalService {

	@Autowired
	private GoalRepository goalRepository;

	
	public Goal save(Goal goal) {
		return goalRepository.save(goal);
	}


	public List<Goal> findAllGoals() {
		
		return goalRepository.loadGoals();
	}


	public List<GoalReport> findAllGoalReports() {
		return goalRepository.loadAllGoalReports();
	}

}
