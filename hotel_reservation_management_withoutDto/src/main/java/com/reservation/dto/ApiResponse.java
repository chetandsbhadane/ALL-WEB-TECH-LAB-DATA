package com.reservation.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {

	private String msg;
	private LocalDateTime ldt;
	
	public ApiResponse(String msg) {
		super();
		this.msg = msg;
		this.ldt = LocalDateTime.now();
	
}
}