package com.codeassist.CodeAssist.Model;

public class Helper {
	private int activityCount;
	private String activityName;
	private boolean clearDatabase = false;
	
	public int getActivityCount() {
		return activityCount;
	}
	public void setActivityCount(int activityCount) {
		this.activityCount = activityCount;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public boolean isClearDatabase() {
		return clearDatabase;
	}
	public void setClearDatabase(boolean clearDatabase) {
		this.clearDatabase = clearDatabase;
	}
	
}
