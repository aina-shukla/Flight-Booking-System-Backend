package com.bookingInfoService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingInfoService.Entity.BookingInfoEntity;
import com.bookingInfoService.Exceptions.EmailNotFoundException;
import com.bookingInfoService.Exceptions.TicketNotFoundException;
import com.bookingInfoService.Exceptions.UserNotFoundException;
import com.bookingInfoService.Repository.BookingInfoRepository;

@Service
public class BookingInfoService {

	@Autowired
	private BookingInfoRepository bookingInfoRepository;

	public List<BookingInfoEntity> findAllHistory() {
		return bookingInfoRepository.findAll();
	}
	
	public BookingInfoEntity findTicket(int pNR) {
		Optional<BookingInfoEntity> optional = bookingInfoRepository.findById(pNR);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new TicketNotFoundException("Ticket with PNR " + pNR + " doesnot exist.");
		}
	}

	public BookingInfoEntity createTicket(BookingInfoEntity b) {
		return bookingInfoRepository.save(b);
	}

	public BookingInfoEntity cancelTicket(int pNR) {
		Optional<BookingInfoEntity> findBypNR = bookingInfoRepository.findById(pNR);
		if (findBypNR.isPresent()) {
			BookingInfoEntity b = findBypNR.get();
			b.setBookingStatus("CANCELLED");
			return bookingInfoRepository.save(b);
		} else
			throw new TicketNotFoundException("Ticket" + pNR + " not exists");
	}

	public BookingInfoEntity findTicketByEmail(String userId) {
		Optional<BookingInfoEntity> optional = bookingInfoRepository.findByUserId(userId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new EmailNotFoundException("Ticket with email \" " + userId + "\" doesnot exist.");
		}
	}

	public BookingInfoEntity create(BookingInfoEntity a) {
		return bookingInfoRepository.save(a);
	}

	public BookingInfoEntity bookTicket(BookingInfoEntity b, String flightNumber) {
		return bookingInfoRepository.save(b);
	}
	
	public List<BookingInfoEntity> findAllHistoryOfUser(String userId) {
		List<BookingInfoEntity> li = bookingInfoRepository.findUserByUserId(userId);
		if(li.isEmpty())
			throw new UserNotFoundException("User with email \" " + userId + "\" doesnot exist.");
		else
			return li;
	}
	}
