package com.abhishek.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhishek.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
