package com.example.telefonica.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculationEntity {

	private Long a;
	private char op;
	private Long b;
	
}
