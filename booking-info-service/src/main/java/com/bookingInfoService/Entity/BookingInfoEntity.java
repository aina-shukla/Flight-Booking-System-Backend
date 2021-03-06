package com.bookingInfoService.Entity;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookingInfoEntity {

	@Id
	private int pNR;
	private String name;
	private char gender;
	private int age;
	private int seatNumber;
	private String mealReq;
	private String mealType;
	private String userId;
	private long contactNumber;
	private String flightNumber;
	private String airlineName;
	private String fromPlace;
	private String toPlace;
	private Date startDateTime;
	private Date endDateTime;
	private int numberOfSeats;
    private String bookingStatus;
	
	
	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public int getpNR() {
		return pNR;
	}

	public void setpNR(int pNR) {
		this.pNR = pNR;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getMealReq() {
		return mealReq;
	}

	public void setMealReq(String mealReq) {
		this.mealReq = mealReq;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
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

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	
	@Override
	public String toString() {
		return "BookingInfoEntity [pNR=" + pNR + ", name=" + name + ", gender=" + gender + ", age=" + age
				+ ", seatNumber=" + seatNumber + ", mealReq=" + mealReq + ", mealType=" + mealType + ", userId="
				+ userId + ", contactNumber=" + contactNumber + ", flightNumber=" + flightNumber + ", airlineName="
				+ airlineName + ", fromPlace=" + fromPlace + ", toPlace=" + toPlace + ", startDateTime=" + startDateTime
				+ ", endDateTime=" + endDateTime + ", numberOfSeats=" + numberOfSeats + ", bookingStatus=" + bookingStatus + "]";
	}

	public BookingInfoEntity(int pNR, String name, char gender, int age, int seatNumber, String mealReq,
			String mealType, String userId, long contactNumber, String flightNumber, String airlineName,
			String fromPlace, String toPlace, Date startDateTime, Date endDateTime, int numberOfSeats, String bookingStatus) {
		super();
		this.pNR = pNR;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.seatNumber = seatNumber;
		this.mealReq = mealReq;
		this.mealType = mealType;
		this.userId = userId;
		this.contactNumber = contactNumber;
		this.flightNumber = flightNumber;
		this.airlineName = airlineName;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.numberOfSeats = numberOfSeats;
		this.bookingStatus=bookingStatus;
	}
	
	public BookingInfoEntity(int pNR, String userId) {
		super();
		this.pNR = pNR;
		this.userId = userId;
	}

	public BookingInfoEntity() {
	}
}
