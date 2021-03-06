package com.bookingInfoService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bookingInfoService.Entity.BookingInfoEntity;
import com.bookingInfoService.Exceptions.EmailNotFoundException;
import com.bookingInfoService.Exceptions.TicketNotFoundException;
import com.bookingInfoService.Service.BookingInfoService;


@RestController
@RequestMapping("/bookingservice")
@CrossOrigin(origins = {"https://hoppscotch.io", "http://localhost:4200/"})
public class BookingInfoController {

	@Autowired
	private BookingInfoService bookingInfoService;
	
	@GetMapping("/bookinghistory")   //get booked tickets history of all users
	public List<BookingInfoEntity> getAllHistory(){
		return bookingInfoService.findAllHistory();
	}
	
	@PostMapping("/bookticket") // New ticket booking
	public BookingInfoEntity bookNewTicket(@RequestBody BookingInfoEntity a) {
		return bookingInfoService.create(a);
	}

	@GetMapping("/findticket/{pNR}")    //Get Booked ticket details based on PNR
	public BookingInfoEntity getTicketByPNR(@PathVariable int pNR){
		System.out.println("Finding ticket by PNR: "+ pNR);
		return bookingInfoService.findTicket(pNR);
	}
	
	@PostMapping("/bookticket/{flightNumber}")   //Book ticket by flight number
	public BookingInfoEntity bookTicket(@RequestBody BookingInfoEntity b, @PathVariable String flightNumber) {
		b.setFlightNumber(flightNumber);
		return bookingInfoService.bookTicket(b, flightNumber);
	}
	
	@PutMapping("/cancelticket/{pNR}")   //Cancel ticket by PNR
	public BookingInfoEntity cancelTicket(@PathVariable int pNR) {
		return bookingInfoService.cancelTicket( pNR);
	}
	
	@GetMapping("/userhistory/{userId}") //Get Booked tickets history of particular Email ID - list
	public List<BookingInfoEntity> getAllHistoryOfUser(@PathVariable String userId){
		return bookingInfoService.findAllHistoryOfUser(userId);
	}
}
