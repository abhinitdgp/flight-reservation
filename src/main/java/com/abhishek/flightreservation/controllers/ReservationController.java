package com.abhishek.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.abhishek.flightreservation.dto.ReservationRequest;
import com.abhishek.flightreservation.entities.Flight;
import com.abhishek.flightreservation.entities.Reservation;
import com.abhishek.flightreservation.repos.FlightRepository;
import com.abhishek.flightreservation.services.ReservationService;

@Controller
public class ReservationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private ReservationService reservationService;

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		LOGGER.info("Inside " + methodName + " flight id: " + flightId);
		Flight flight = flightRepository.findById(flightId).get();
		modelMap.addAttribute("flight", flight);

		LOGGER.info("Flight is: " + flight);
		return "completeReservation";

	}

	@RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		LOGGER.info("Inside " + methodName + " reuest: " + request);
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation created successfully and the id is: " + reservation.getId());

		LOGGER.info("Generated Reservation id: " + reservation.getId());
		return "reservationConfirmation";

	}

}
