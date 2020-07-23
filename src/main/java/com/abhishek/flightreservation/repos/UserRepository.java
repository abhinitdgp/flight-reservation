package com.abhishek.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhishek.flightreservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
