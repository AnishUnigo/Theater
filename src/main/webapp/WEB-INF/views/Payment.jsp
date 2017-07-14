<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
</head>
<body>
	<div>
		
			<form action="payment.html" method="post">
			<table>
				<tr>
					<td>
						<input type="hidden" name="screenId" value="${screenId}">Screen : ${screenId}
					</td>
				</tr>
				<tr>
					<td> Total price :<input type="hidden" name="totalPrice" value=" ${price}" > $ ${price} /-
					</td>
				</tr>
				<tr>
					<td> Seat # </td>
					<td><label name="SeatNo" >${bookedSeats} </label>
						<input type="hidden" name="SeatNo" value="${bookedSeats}">
					</td> 
				</tr>
			</table>
			
			<table>
				<tr>
					<td>Account no : </td>
					<td><input type="text" name="acc_no" ></td>
				</tr>
				<tr>
					<td>password : </td>
					<td><input type="password" name="password" ></td>
				</tr>
				<tr>
					<td>
						
					</td>	
				</tr>
				
				
			</table>
			<input type="submit" name="submit" value="Proceed Payment" />
			</form>
		
	</div>
</body>
</html>