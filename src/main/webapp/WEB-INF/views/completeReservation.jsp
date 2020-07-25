<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Complete Reservation</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<h2>Complete Reservation</h2>
	Airline: ${flight.operatingAirlines}
	<br /> Departure City: ${flight.departureCity}
	<br /> Arrival City: ${flight.arrivalCity}
	<br /> Date of Departure: ${flight.dateOfDeparture}
	<br /> Departure Time: ${flight.estimatedDepartureTime}
	<br />

	<div class="container">
		<div id="login-row"
			class="row justify-content-center align-items-center">
			<div id="login-column" class="col-md-6">
				<div id="login-box" class="col-md-12">
					<form id="login-form" class="form" action="completeReservation"
						method="post">
						<h3 class="text-center text-info">Passenger Details</h3>
						<div class="form-group">
							<label for="firstName" class="text-info">First Name:</label><br>
							<input type="text" name="firstName" id="email"
								class="form-control">
						</div>
						<div class="form-group">
							<label for="lastName" class="text-info">Last Name:</label><br>
							<input type="text" name="lastName" id="password"
								class="form-control">
						</div>
						<div class="form-group">
							<label for="email" class="text-info">Email:</label><br> <input
								type="text" name="email" id="email" class="form-control">
						</div>
						<div class="form-group">
							<label for="phone" class="text-info">Phone:</label><br> <input
								type="text" name="phone" id="phone" class="form-control">
						</div>

						<h3 class="text-center text-info">Card Details</h3>
						<div class="form-group">
							<label for="nameOnTheCard" class="text-info">Name on the
								Card:</label><br> <input type="text" name="nameOnTheCard"
								id="email" class="form-control">
						</div>
						<div class="form-group">
							<label for="cardNumber" class="text-info">Card Number:</label><br>
							<input type="text" name="cardNumber" id="password"
								class="form-control">
						</div>
						<div class="form-group">
							<label for="expiryDate" class="text-info">Expiry Date:</label><br>
							<input type="text" name="expiryDate" id="email"
								class="form-control">
						</div>
						<div class="form-group">
							<label for="securityCode" class="text-info">Security
								Code(cvv):</label><br> <input type="text" name="securityCode"
								id="phone" class="form-control">
						</div>
						<div class="form-group">
							<input type="hidden" name="flightId" id="flightId"
								class="form-control" value="${flight.id }">
						</div>
						<div class="form-group">
							<input type="submit" name="submit" class="btn btn-info btn-md"
								value="Confirm">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


</body>
</html>