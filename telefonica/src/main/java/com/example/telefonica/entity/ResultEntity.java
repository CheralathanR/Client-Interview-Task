package com.example.telefonica.entity;

import java.beans.JavaBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JavaBean
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultEntity {
	
	private int input;
	private String calculation;
	private Long result;
	
}
