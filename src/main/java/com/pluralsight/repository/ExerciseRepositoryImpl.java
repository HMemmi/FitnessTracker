package com.pluralsight.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pluralsight.model.Activity;
import com.pluralsight.model.Exercise;

@Repository("exerciseRepository")
public class ExerciseRepositoryImpl implements ExerciseRepository {

	@PersistenceContext
	private EntityManager em;

	public Exercise save(Exercise exercise) {
		em.persist(exercise);
		System.out.println(exercise.getActivity().getDescription());
		em.flush();
		return exercise;
	}

	@Transactional
	public List<Activity> save(List<Activity> activities) {
		for (Activity activity : activities) {
			System.out.println(activities);
			em.persist(activity);
			em.flush();
		}
		return activities;
	}

}
