package com.pluralsight.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pluralsight.model.Activity;
import com.pluralsight.model.Exercise;
import com.pluralsight.repository.ExerciseRepository;


@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService {

	@Autowired
	private ExerciseRepository exerciseRepository;
	
	public List<Activity> findAllActivities() {
		
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity run = new Activity();
		run.setDescription("Run");
		activities.add(run);
		
		Activity bike = new Activity();
		bike.setDescription("Bike");
		activities.add(bike);
		
		Activity swim = new Activity();
		swim.setDescription("Swim");
		activities.add(swim);
		
		return activities;
		//return save(activities);
	}
	
	@Transactional
	public Exercise save(Exercise exercise) {
		return exerciseRepository.save(exercise);
	}

	@Transactional
	public List<Activity> save(List<Activity> activities) {
		return exerciseRepository.save(activities);
	}
	
}
