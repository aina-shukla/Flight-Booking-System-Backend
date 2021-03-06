package com.airlinesService.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.airlinesService.Exceptions.AirlineNotFoundException;

import com.airlinesService.models.ExceptionMessage;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AirlineNotFoundException.class)
	public ResponseEntity<ExceptionMessage> airlineExceptionHandler(AirlineNotFoundException e){
		return new ResponseEntity<ExceptionMessage>(
				new ExceptionMessage(500, e.getMessage())
				, HttpStatus.OK);
	}
}
