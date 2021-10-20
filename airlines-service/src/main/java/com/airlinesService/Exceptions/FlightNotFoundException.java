package com.airlinesService.Exceptions;

public class FlightNotFoundException extends RuntimeException {

	public FlightNotFoundException() {}

	public FlightNotFoundException(String m) {
		super(m);
	}
	public FlightNotFoundException(Exception e) {
		super(e);
	}
	public FlightNotFoundException(String m, Exception e) {
		super(m, e);
	}
}
