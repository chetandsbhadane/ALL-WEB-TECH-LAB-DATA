package com.app.pojos;

public class Student {
	private String firstName;
	private String lastName;
	private int score;
	private Course course;
	private boolean admitted;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String firstName, String lastName, int score, Course course) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.score = score;
		this.course = course;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public boolean isAdmitted() {
		return admitted;
	}
	public void setAdmitted(boolean admitted) {
		this.admitted = admitted;
	}
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", score=" + score + ", course=" + course
				+ ", admitted=" + admitted + "]";
	}
	
}
