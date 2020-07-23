package com.abhishek.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhishek.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
