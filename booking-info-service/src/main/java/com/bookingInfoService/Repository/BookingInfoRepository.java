package com.bookingInfoService.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookingInfoService.Entity.BookingInfoEntity;

@Repository
public interface BookingInfoRepository extends JpaRepository<BookingInfoEntity, Integer> {

	Optional<BookingInfoEntity> findByUserId(String userId);

	boolean existsByFlightNumber(String flightNumber);

	List<BookingInfoEntity> findUserByUserId(String userId);
	
}
