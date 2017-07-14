<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ConfigureTheater</title>
</head>
<body>
	
	<div>
		<form action="configure.html" method="post">
		<h1>Select Theater</h1>
		<input type="checkbox" name ="theaterName" value="AMC Theater">AMC Theater</input>&nbsp;
		<input type="checkbox" name ="theaterName" value="StarPlex Theater">StarPlex Theater</input>&nbsp;
		<input type="checkbox" name ="theaterName" value="HollyWood Theater">HollyWood Theater</input>&nbsp;
		<input type="checkbox" name ="theaterName" value="Cinema World">Cinema World</input>&nbsp;<br>
		
		<h2>Select Number of Screen</h2>
		
		<input type="number" name="screens" min="0" max="3" plceholder="select screens"> <br>
		
		<h3>Select Number of Rows per Screen</h3>
			<input type="number" name="rows" min="0" max="30" >
		<br>
		
		<h4>Select Number of Seats per Rows </h4>
		<input type="number"   name="seats" min="0" max="100" placeholder="select no of seats"><br>
		<input type="submit" name="submit">
		</form>
	</div>
</body>
</html>