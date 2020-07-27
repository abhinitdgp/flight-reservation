package com.abhishek.flightreservation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.flightreservation.controllers.UserController;
import com.abhishek.flightreservation.dto.ReservationRequest;
import com.abhishek.flightreservation.entities.Flight;
import com.abhishek.flightreservation.entities.Passenger;
import com.abhishek.flightreservation.entities.Reservation;
import com.abhishek.flightreservation.repos.FlightRepository;
import com.abhishek.flightreservation.repos.PassengerRepository;
import com.abhishek.flightreservation.repos.ReservationRepository;
import com.abhishek.flightreservation.util.EmailUtil;
import com.abhishek.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private PDFGenerator pdfGenerator;

	@Autowired
	private EmailUtil emailUtil;

	@Override
	public Reservation bookFlight(ReservationRequest request) {

		// Make payment

		Long id = request.getFlightId();
		Flight flight = flightRepository.findById(id).get();
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());

		Passenger savedPassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		Reservation savedReservation = reservationRepository.save(reservation);

		String filepath = "/Users/abaggarw/Documents/Personal/Java/J2EE/flightreservation/Reservations/reservation"
				+ savedReservation.getId() + ".pdf";
		pdfGenerator.generateItinerary(savedReservation, filepath);
		// emailUtil.sendItinerary(savedPassenger.getEmail(), filepath);
		return savedReservation;
	}

}
