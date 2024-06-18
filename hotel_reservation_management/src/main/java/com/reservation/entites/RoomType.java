package com.reservation.entites;

public enum RoomType {
	SINGLE(5000), DOUBLE(10000), SUITE(50000);
	
private final int value;

	RoomType(int value) {
		this.value = value;
		// TODO Auto-generated constructor stub
		
	}
	public int getValue() {
		return value;
	}
	
}
