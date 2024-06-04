package com.app.pojos;

public enum Course {
	MERN(80), RDBMS(70), SPRING_BOOT(75);
	private int minScore;

	private Course(int minScore) {
		this.minScore = minScore;
	}

	public int getMinScore() {
		return minScore;
	}
	
	
}
