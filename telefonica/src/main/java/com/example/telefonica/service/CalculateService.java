package com.example.telefonica.service;

import org.springframework.stereotype.Service;
import com.example.telefonica.entity.CalculationEntity;
import com.example.telefonica.entity.ResultEntity;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CalculateService {
	
	public ResultEntity getOperationData(CalculationEntity calculationEntity, int id) {
		
		log.info("Inside CalculateService");
		Long first = calculationEntity.getA();
		Long second = calculationEntity.getB();
		char op = calculationEntity.getOp();
		Long result = operationIdentify(first, second, op);
		
		String resultString = first+" "+op+" "+ second+" = "+result;
		
		return new ResultEntity(id, resultString, result);
		
	}

	private Long operationIdentify(Long first, Long second, char op) {
		
		switch(op){
	    case '+':
	        return first + second;
	    case '-':
	        return first - second;
	    case '*':
	        return first * second;
	    case '/':
	        return first / second;
	    default:
	        return null;
	    }
		
	}

}
