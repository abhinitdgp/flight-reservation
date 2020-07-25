<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Flights</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="css/findFlights.css" rel="stylesheet">
</head>
<body>
	<div class="flight-engine">
		<div class="container">
			<form id="login-form" class="form" action="findFlights" method="post">
				<div class="flight-tab row">
					<div class="persent-one">
						<i class="fa fa-map-marker" aria-hidden="true"></i> <input
							type="text" name="from" class="textboxstyle" id="dep"
							placeholder="From City or airport">
					</div>
					<div class="persent-one">
						<i class="fa fa-map-marker" aria-hidden="true"></i> <input
							type="text" name="to" class="textboxstyle" id="arival"
							placeholder="To City or airport">
					</div>
					<div class="persent-one less-per">
						<i class="fa fa-calendar" aria-hidden="true"></i> <input
							type="text" name="departureDate" class="textboxstyle" id="from-date1"
							placeholder="Depart">
					</div>
					<!-- <div class="persent-one less-per">
					<i class="fa fa-calendar" aria-hidden="true"></i> <input
						type="text" name="dep" class="textboxstyle" id="to-date"
						placeholder="Returrn">
				</div>
				<div class="persent-one">
					<i class="fa fa-user" aria-hidden="true"></i>
					<div class="textboxstyle" id="passenger">01 Passenger</div>
				</div> -->
					<div class="persent-one less-btn">
						<input type="Submit" name="submit" value="Search"
							class="btn btn-info cst-btn" id="srch">
					</div>
				</div>
			</form>
			<!-- flight tab -->

		</div>
	</div>
</body>
</html>