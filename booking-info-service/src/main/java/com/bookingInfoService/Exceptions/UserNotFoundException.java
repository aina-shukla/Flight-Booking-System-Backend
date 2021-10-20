package com.bookingInfoService.Exceptions;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException() {}

	public UserNotFoundException(String m) {
		super(m);
	}
	public UserNotFoundException(Exception e) {
		super(e);
	}
	public UserNotFoundException(String m, Exception e) {
		super(m, e);
	}
}
