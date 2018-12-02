<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
​<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href = "/style.css" />
<link href='http://fonts.googleapis.com/css?family=Oleo+Script' rel='stylesheet' type='text/css'>
<title>Results</title>
</head>
<body>
	<div class=container>
		<h2>Hotels in ${ city }</h2>
		<table>
			<tr>
				<th>Name</th>
				<th>Price Per Night</th>
			</tr>
			<c:forEach items="${ hotelList }" var="hotel">
				<tr>
					<td>${ hotel.name }</td>
					<td>${ hotel.pricePerNight }</td>
				</tr>
			</c:forEach>
		</table>
		
		<a href="/">Go Back</a>
	</div>
</body>
</html>