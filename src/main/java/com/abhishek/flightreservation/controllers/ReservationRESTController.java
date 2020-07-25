package com.abhishek.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.flightreservation.dto.ReservationUpdateRequest;
import com.abhishek.flightreservation.entities.Reservation;
import com.abhishek.flightreservation.repos.ReservationRepository;

@RestController
public class ReservationRESTController {
	@Autowired
	private ReservationRepository reservationRepository;

	@RequestMapping(value = "/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long Id) {
		return reservationRepository.findById(Id).get();
	}

	@RequestMapping(value = "/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Reservation reservation = reservationRepository.findById(request.getId()).get();
		reservation.setCheckedIn(request.getCheckedIn());
		reservation.setNumberOfBags(request.getNumberOfBags());
		return reservationRepository.save(reservation);
	}
}