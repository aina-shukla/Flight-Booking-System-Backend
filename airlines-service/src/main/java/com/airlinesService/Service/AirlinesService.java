package com.airlinesService.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.airlinesService.Entity.AirlinesEntity;
import com.airlinesService.Exceptions.AirlineNotFoundException;
import com.airlinesService.Exceptions.FlightNotFoundException;
import com.airlinesService.Repository.AirlinesRepository;

@Service
public class AirlinesService {

	@Autowired
	private AirlinesRepository airlinesRepository;

	public List<AirlinesEntity> findAllAirlines() {
		return airlinesRepository.findAll();
	}

	@KafkaListener(topics = "registerflights", groupId = "group_id", containerFactory = "userKafkaListenerFactory")
	public AirlinesEntity create(AirlinesEntity a) {
		return airlinesRepository.save(a);
	}

	public AirlinesEntity updateAirline(int flightNumber, AirlinesEntity a) {
		if (airlinesRepository.existsById(flightNumber)) {
			a.setFlightNumber(flightNumber);
			return airlinesRepository.save(a);
		} else {
			throw new FlightNotFoundException("Flight with flight number \" " + flightNumber + " \" doesnot exist.");
		}
	}

	public List<AirlinesEntity> searchAllFlights( String fromPlace, String toPlace, String startDateTime
			) {
		List<AirlinesEntity> list = airlinesRepository.findAllByFromPlaceAndToPlaceAndStartDateTime(fromPlace,toPlace, startDateTime );
		if (list.isEmpty()) {
			throw new FlightNotFoundException("Flight doesnot exist.");
		} else {
			return list;
		}
	}

	public AirlinesEntity blockAirline(int flightNumber) {
		Optional<AirlinesEntity> findByAirlineName = airlinesRepository.findById(flightNumber);
		if (findByAirlineName.isPresent()) {
			AirlinesEntity a = findByAirlineName.get();
			a.setBlockStatus("BLOCKED");
			return airlinesRepository.save(a);
		} else
			throw new AirlineNotFoundException("Airline with flightnumber \" " + flightNumber + " \" not exists");
	}

	public List<AirlinesEntity> findUnblockedFlights() {
		String status = "UNBLOCKED";
		List<AirlinesEntity> list = airlinesRepository.findByBlockStatus(status);
		if (list.isEmpty())
			throw new FlightNotFoundException("Flight is blocked");
		else
			return list;
	}
}