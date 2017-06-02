package com.pluralsight.model;

public class GoalReport {

	private int goalMinutes;
	private int exerciseMinutes;
	//private String activityDescription;
	private Activity activityDescription;
	/*public GoalReport(int goalMinutes, int exerciseMinutes, String activityDescription) {
		this.goalMinutes = goalMinutes;
		this.exerciseMinutes = exerciseMinutes;
		this.activityDescription = activityDescription;
	}*/

	public GoalReport(int goalMinutes, int exerciseMinutes, Activity activityDescription) {
		this.goalMinutes = goalMinutes;
		this.exerciseMinutes = exerciseMinutes;
		this.activityDescription = activityDescription;
	}
	public int getGoalMinutes() {
		return goalMinutes;
	}

	public void setGoalMinutes(int goalMinutes) {
		this.goalMinutes = goalMinutes;
	}

	public int getExerciseMinutes() {
		return exerciseMinutes;
	}

	public void setExerciseMinutes(int exerciseMinutes) {
		this.exerciseMinutes = exerciseMinutes;
	}
	
	public Activity getActivityDescription() {
		return activityDescription;
	}

	public void setActivityDescription(Activity activityDescription) {
		this.activityDescription = activityDescription;
	}

	/*public String getActivityDescription() {
		return activityDescription;
	}

	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}*/

}
