package com.adminService.Entity;

public class AirlinesEntity {

	private int flightNumber;
	private String flighId;
	private String airlineName;
	private String fromPlace;
	private String toPlace;
	private String startDateTime;
	private String endDateTime;
	private String scheduledDays;
	private String instrumentUsed;
	private int businessClassSeats;
	private int nonBusinessClassSeats;
	private int ticketCost;
	private int numberOfRows;
	private String meal;
	private String blockStatus;

	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlighId() {
		return flighId;
	}
	public void setFlighId(String flighId) {
		this.flighId = flighId;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getFromPlace() {
		return fromPlace;
	}
	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}
	public String getToPlace() {
		return toPlace;
	}
	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}
	public String getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}
	public String getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}
	public String getScheduledDays() {
		return scheduledDays;
	}
	public void setScheduledDays(String scheduledDays) {
		this.scheduledDays = scheduledDays;
	}
	public String getInstrumentUsed() {
		return instrumentUsed;
	}
	public void setInstrumentUsed(String instrumentUsed) {
		this.instrumentUsed = instrumentUsed;
	}
	public int getBusinessClassSeats() {
		return businessClassSeats;
	}
	public void setBusinessClassSeats(int businessClassSeats) {
		this.businessClassSeats = businessClassSeats;
	}
	public int getNonBusinessClassSeats() {
		return nonBusinessClassSeats;
	}
	public void setNonBusinessClassSeats(int nonBusinessClassSeats) {
		this.nonBusinessClassSeats = nonBusinessClassSeats;
	}
	public int getTicketCost() {
		return ticketCost;
	}
	public void setTicketCost(int ticketCost) {
		this.ticketCost = ticketCost;
	}
	public int getNumberOfRows() {
		return numberOfRows;
	}
	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	public String getBlockStatus() {
		return blockStatus;
	}
	public void setBlockStatus(String blockStatus) {
		this.blockStatus = blockStatus;
	}
	@Override
	public String toString() {
		return "AirlinesEntity [flightNumber=" + flightNumber + ", flighId=" + flighId + ", airlineName=" + airlineName
				+ ", fromPlace=" + fromPlace + ", toPlace=" + toPlace + ", startDateTime=" + startDateTime
				+ ", endDateTime=" + endDateTime + ", scheduledDays=" + scheduledDays + ", instrumentUsed="
				+ instrumentUsed + ", businessClassSeats=" + businessClassSeats + ", nonBusinessClassSeats="
				+ nonBusinessClassSeats + ", ticketCost=" + ticketCost + ", numberOfRows=" + numberOfRows + ", meal="
				+ meal + ", blockStatus=" + blockStatus + "]";
	}
	public AirlinesEntity(int flightNumber, String flighId, String airlineName, String fromPlace, String toPlace,
			String startDateTime, String endDateTime, String scheduledDays, String instrumentUsed,
			int businessClassSeats, int nonBusinessClassSeats, int ticketCost, int numberOfRows, String meal,
			String blockStatus) {
		super();
		this.flightNumber = flightNumber;
		this.flighId = flighId;
		this.airlineName = airlineName;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.scheduledDays = scheduledDays;
		this.instrumentUsed = instrumentUsed;
		this.businessClassSeats = businessClassSeats;
		this.nonBusinessClassSeats = nonBusinessClassSeats;
		this.ticketCost = ticketCost;
		this.numberOfRows = numberOfRows;
		this.meal = meal;
		this.blockStatus = blockStatus;
	}
	public AirlinesEntity(int flightNumber, String flighId, int ticketCost, String blockStatus) {
		super();
		this.flightNumber = flightNumber;
		this.flighId = flighId;
		this.ticketCost = ticketCost;
		this.blockStatus = blockStatus;
	}
	public AirlinesEntity() {
		super();
	}

	
}
