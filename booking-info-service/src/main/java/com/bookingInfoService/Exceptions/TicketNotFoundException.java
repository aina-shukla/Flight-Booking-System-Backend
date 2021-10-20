package com.bookingInfoService.Exceptions;

public class TicketNotFoundException extends RuntimeException {

	public TicketNotFoundException() {}

	public TicketNotFoundException(String m) {
		super(m);
	}
	public TicketNotFoundException(Exception e) {
		super(e);
	}
	public TicketNotFoundException(String m, Exception e) {
		super(m, e);
	}
}
