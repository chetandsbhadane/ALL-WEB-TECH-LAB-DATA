package com.jobpost.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResonse {

	private String msg;
	private LocalDateTime ldt;
	public ApiResonse(String msg) {
		super();
		this.msg = msg;
		this.ldt = LocalDateTime.now();
	}
	
	
	
}
