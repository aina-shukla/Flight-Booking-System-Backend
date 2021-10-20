package com.bookingInfoService.Exceptions;

public class EmailNotFoundException extends RuntimeException{

	
	public EmailNotFoundException() {}

	public EmailNotFoundException(String m) {
		super(m);
	}
	public EmailNotFoundException(Exception e) {
		super(e);
	}
	public EmailNotFoundException(String m, Exception e) {
		super(m, e);
	}
}

