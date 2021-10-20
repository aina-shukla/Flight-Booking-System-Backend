package com.airlinesService.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.airlinesService.Entity.AirlinesEntity;
import com.airlinesService.Service.AirlinesService;

@RequestMapping("/airlinesservice")
@CrossOrigin(origins = {"https://hoppscotch.io", "http://localhost:4200"})
@RestController
public class AirlinesController {

	@Autowired
	private AirlinesService airlinesService;

	@GetMapping("/searchairlines") // Searches for flight blocked-unbblocked
	public List<AirlinesEntity> getAllAirlines() {
		return airlinesService.findAllAirlines();
	}

	@GetMapping("/availableairlines") // Searches for unbblocked flights
	public List<AirlinesEntity> getUnblockedFlights() {
		return airlinesService.findUnblockedFlights();
	}
		
	@PutMapping("/airline/inventory/add/{flightNumber}") // Add Inventory/Schedule of an existing Airline
	public AirlinesEntity save(@RequestBody AirlinesEntity a, @PathVariable int flightNumber) {
		System.out.println("Updating airline details where flightnumber is : " + flightNumber);
		return airlinesService.updateAirline(flightNumber, a);
	}

	@PostMapping("/airlines/register") // New airline booking
	public AirlinesEntity saveInAirlines(@RequestBody AirlinesEntity a) {
		return airlinesService.create(a);
	}

	@PostMapping("search/flights")  //search for flights, fromplace, toplace, startdatetime, enddatetime, flightnumber
	public List<AirlinesEntity> searchFlights(
			@RequestParam(value="fromPlace") String fromPlace,
			@RequestParam(value="toPlace") String toPlace,
			@RequestParam(value="startDateTime") String startDateTime
			) {
		return airlinesService.searchAllFlights( fromPlace, toPlace, startDateTime);
	}
	
	@PutMapping("/blockairline/{flightNumber}") // Block Airline
	public AirlinesEntity blockAirline(@PathVariable int flightNumber) {
		return airlinesService.blockAirline(flightNumber);
	}
}
