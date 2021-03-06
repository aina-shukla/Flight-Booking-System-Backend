package com.airlinesService.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airlinesService.Entity.AirlinesEntity;

@Repository
public interface AirlinesRepository extends JpaRepository<AirlinesEntity, Integer> {

	Optional<AirlinesEntity> findByFlightNumber(int flightNumber);

	List<AirlinesEntity> findByAirlineName(String airlineName);

	List<AirlinesEntity> findByBlockStatus(String status);

	List<AirlinesEntity> findAllByFromPlaceAndToPlaceAndStartDateTime(String fromPlace, String toPlace,
			String startDateTime);
}
