<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
​<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/style.css" />
<link href='http://fonts.googleapis.com/css?family=Oleo+Script'
	rel='stylesheet' type='text/css'>
<title>Index</title>
</head>
<body>
	<h1>Hotel Search</h1>

	<form action="results" method="POST">
		<select name="city">

			<option>Chicago</option>
			<option>Detroit</option>
			<option>Los Angeles</option>
			<option>Seattle</option>



		</select> <input type="submit" value="Submit" />
	</form>

</body>
</html>