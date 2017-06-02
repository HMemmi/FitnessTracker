package com.pluralsight.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;

@Repository("goalRepository")
public class GoalRepositoryImpl implements GoalRepository {

	@PersistenceContext
	private EntityManager em;

	public Goal save(Goal goal) {
		if (goal.getId() == null) {
			em.persist(goal);
			em.flush();
		} else {
			goal = em.merge(goal);
		}
		return goal;
	}

	public List<Goal> loadGoals() {
		Query query = em.createQuery("select goal from Goal goal");
		List<Goal> goals = query.getResultList();

		TypedQuery<Goal> allGoals = em.createNamedQuery(Goal.GET_ALL_GOALS, Goal.class);
		return allGoals.getResultList();
	}

	public List<GoalReport> loadAllGoalReports() {

		// a.description
		Query query = em.createQuery("select new com.pluralsight.model.GoalReport(g.minutes,e.minutes,a)"
				+ " from Goal g,Activity a, Exercise e where g.id=e.goal.id and a.id=e.activity.id");

		TypedQuery<GoalReport> querys = em.createQuery(
				"select new com.pluralsight.model.GoalReport(g.minutes,e.minutes,a)"
						+ " from Goal g,Activity a, Exercise e where g.id=e.goal.id and a.id=e.activity.id",
				GoalReport.class);

		TypedQuery<GoalReport> namedQuery = em.createNamedQuery(Goal.GET_GOAL_REPORT, GoalReport.class);
		return namedQuery.getResultList();
	}
}
