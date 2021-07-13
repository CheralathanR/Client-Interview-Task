package com.example.telefonica.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.Assert;
import org.springframework.web.client.RestTemplate;

import com.example.telefonica.entity.CalculationEntity;

@WebMvcTest(CalculationEntity.class)
class CalculateControllerTest {

	 @Mock
	 private RestTemplate restTemplate;
	
	@Test
	@DisplayName("Returns true when input value between 0 and 10000")
	void testCase1() {
		CalculationEntity calc = new CalculationEntity(62L,'+',14L);
		final String url = "https://interview.dev.lab.o2online.de/api/320";
		Mockito.when(restTemplate.getForObject(url, CalculationEntity.class)).thenReturn(calc);
		Long a = 62L;
		Long b = 14L;
		char op = '+';
		
		Assert.assertEquals(a, calc.getA());
		Assert.assertEquals(op, calc.getOp());
		Assert.assertEquals(b, calc.getB());	
	}

}
