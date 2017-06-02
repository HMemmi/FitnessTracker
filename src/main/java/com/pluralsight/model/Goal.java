package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "Goals")
@NamedQueries({
		@NamedQuery(name = Goal.GET_GOAL_REPORT, query = "select new com.pluralsight.model.GoalReport(g.minutes,e.minutes,a)"
				+ " from Goal g,Activity a, Exercise e where g.id=e.goal.id and a.id=e.activity.id"),
		@NamedQuery(name = Goal.GET_ALL_GOALS, query = "select g from Goal g") })

public class Goal {

	public final static String GET_ALL_GOALS = "findAllGoals";
	public final static String GET_GOAL_REPORT = "findGoalReport";
	@Id
	@GeneratedValue
	@Column(name = "GOAL_ID")
	private Long id;

	@Range(min = 1, max = 120)
	@Column(name = "MINUTES")
	private int minutes;

	@OneToMany(mappedBy = "goal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Exercise> exercises = new ArrayList<Exercise>();

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}
}
