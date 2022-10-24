<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flights List</title>
<link rel="stylesheet" href="css/style.css">
<style >
body{
   background-image:url("https://img.lovepik.com/photo/50099/3731.jpg_wh300.jpg") ;
   background-repeat:no-repeat;
   background-size:contain;
   
}
form
{
  
  font-style:italic;
}

</style>
</head>
<body>
<h3 align="right"><a href="index.html">Back</a></h3>
<h1 align="center">Available Flights</h1>
<table border="1" cellpadding="20%" align="center" bgcolor="lightgreen">
<tr>
<th>FlightNumber</th>
<th>Source</th>
<th>Destination</th>
<th>Time</th>
<th>Duration</th>
<th>Price</th>
</tr>
	<c:forEach var="items" items="${flightlist}">
	<tr>
	<td>${items.flightNumber}</td>
	<td>${items.source}</td>
	<td>${items.destination}</td>
	<td>${items.time}</td>
	<td>${items.duration}</td>
	<td>${items.price}</td>
	</tr>
	</c:forEach>
	
</table>
<form action="Payment" method="post" align="center">
<b>Name</b>:<input type="text" name="name"><br><br>
<b>Phone</b>:<input type="number" name="phone"><br><br>
<b>Flight Number</b>:<input type="number" name="flight"><br><br>
<h3>Please Provide Correct Flight Number to avoid further Discrepancies</h3>
<input type="submit" value="Proceed to Payment">
</form>
</body>
</html>