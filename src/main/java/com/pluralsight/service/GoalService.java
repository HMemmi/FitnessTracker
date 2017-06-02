package com.pluralsight.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;

public interface GoalService {
	@Transactional
	Goal save(Goal goal);
	@Transactional
	List<Goal> findAllGoals();
	@Transactional
	List<GoalReport> findAllGoalReports();
}