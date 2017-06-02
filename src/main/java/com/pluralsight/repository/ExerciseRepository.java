package com.pluralsight.repository;

import java.util.List;

import com.pluralsight.model.Activity;
import com.pluralsight.model.Exercise;

public interface ExerciseRepository {

	Exercise save(Exercise exercise);

	List<Activity> save(List<Activity> activities);

}