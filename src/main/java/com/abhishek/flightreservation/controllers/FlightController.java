package com.abhishek.flightreservation.controllers;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.abhishek.flightreservation.entities.Flight;
import com.abhishek.flightreservation.repos.FlightRepository;

@Controller
public class FlightController {

	@Autowired
	private FlightRepository flightRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

	@RequestMapping(value = "/findFlights", method = RequestMethod.POST)
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate,
			ModelMap modelMap) {

		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		LOGGER.info("Inside " + methodName + " from: " + from + " to: " + to + " departure date: " + departureDate);

		List<Flight> flights = flightRepo.findFlights(from, to, departureDate);
		modelMap.addAttribute("flights", flights);

		LOGGER.info("Inside " + methodName + " flights found are: " + flights);
		return "displayFlights";

	}

	@RequestMapping("admin/showAddFlight")
	public String showAddFlight() {
		return "addFlight";

	}
}
