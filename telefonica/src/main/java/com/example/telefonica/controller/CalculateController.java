package com.example.telefonica.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.telefonica.entity.CalculationEntity;
import com.example.telefonica.entity.ResultEntity;
import com.example.telefonica.exception.InvalidInputException;
import com.example.telefonica.service.CalculateService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class CalculateController {
	
	@Autowired
    private RestTemplate restTemplate;

    @Autowired
    CalculateService calculateService;
    
	
	@RequestMapping("/resolve/{id}")
	public ResponseEntity<ResultEntity> testMethod(@PathVariable int id) throws InvalidInputException  {
		
		 log.info("Inside CalculateController");
		 
		 if(id<0 || id>10000) {
			throw new InvalidInputException("Please provide input between 0 and 10000"); 
		 }
		 
		 final String url = "https://interview.dev.lab.o2online.de/api/" + id;
		 log.info(url);
		 CalculationEntity calculationEntity= restTemplate.getForObject(url, CalculationEntity.class);
		 log.info(calculationEntity.toString());
		 ResultEntity resultEntity = calculateService.getOperationData(calculationEntity, id);
		 log.info(resultEntity.toString());
	     return new ResponseEntity<ResultEntity>(resultEntity, HttpStatus.OK);
	}
	

}
