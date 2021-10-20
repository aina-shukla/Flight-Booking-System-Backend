package com.bookingInfoService;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bookingInfoService.Entity.BookingInfoEntity;
import com.bookingInfoService.Repository.BookingInfoRepository;
import com.bookingInfoService.Service.BookingInfoService;

@SpringBootTest
public class TsetService {

	@MockBean
	private BookingInfoRepository repo;
	
	@Autowired
	private BookingInfoService service;
	
	@Test
	public void testGetHistoryPositive(){
	BookingInfoEntity history = new BookingInfoEntity();
	List<BookingInfoEntity> getHistory = new ArrayList<>();
	getHistory.add(history);
	Mockito.when(repo.findAll()).thenReturn(getHistory);
	List<BookingInfoEntity> getHistory1 = service.findAllHistory();
	Assertions.assertTrue(getHistory1.size() > 0);
	}
	
	@Test
	public void testGetHistoryNegative(){
		BookingInfoEntity history = new BookingInfoEntity();
		List<BookingInfoEntity> getHistory = new ArrayList<>();
		getHistory.add(history);
		Mockito.when(repo.findAll()).thenReturn(getHistory);
		List<BookingInfoEntity> getHistory1 = service.findAllHistory();
	Assertions.assertFalse(getHistory1.size() == 0);

	}
}
