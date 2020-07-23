package com.abhishek.flightreservation.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Reservation extends AbstractEntity {

	private boolean checkedIn;
	private int numbetOfBags;

	@OneToOne
	private Passenger passenger;

	@OneToOne
	private Flight flight;

	public boolean isCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public int getNumbetOfBags() {
		return numbetOfBags;
	}

	public void setNumbetOfBags(int numbetOfBags) {
		this.numbetOfBags = numbetOfBags;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Reservation [ checkedIn=" + checkedIn + ", numbetOfBags=" + numbetOfBags + ", passenger=" + passenger
				+ ", flight=" + flight + "]";
	}

}
