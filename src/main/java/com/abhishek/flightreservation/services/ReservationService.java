package com.abhishek.flightreservation.services;

import org.springframework.stereotype.Service;

import com.abhishek.flightreservation.dto.ReservationRequest;
import com.abhishek.flightreservation.entities.Reservation;

public interface ReservationService {
	public Reservation bookFlight(ReservationRequest request);
}
