<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flights</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h3>Flights:</h3>
		<table class="table table-striped">
			<tr>
				<th>Airlines</th>
				<th>Departure City</th>
				<th>Arrival City</th>
				<th>Departure Time</th>
				<th>Action</th>

			</tr>
			<c:forEach items="${flights }" var="flight">
				<tr>
					<td>${flight.operatingAirlines }</td>
					<td>${flight.arrivalCity }</td>
					<td>${flight.departureCity }</td>
					<td>${flight.estimatedDepartureTime }</td>
					<td><a href="showCompleteReservation?flightId=${flight.id}">Select</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>