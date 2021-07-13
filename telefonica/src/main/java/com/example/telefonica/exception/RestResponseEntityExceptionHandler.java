package com.example.telefonica.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.telefonica.entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	 @ExceptionHandler(InvalidInputException.class)
	    public ResponseEntity<ErrorMessage> invalidInputException(InvalidInputException exception,
	                                                    WebRequest request) {
	        ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST,
	                exception.getMessage());

	        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body(message);
	    }

}
