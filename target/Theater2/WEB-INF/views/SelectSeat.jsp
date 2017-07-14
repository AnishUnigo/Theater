<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.TreeMap"%>
<%@ page import="java.lang.String"%>
<%@ page import="java.lang.Integer"%>
<%@ page import="java.lang.Boolean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SelectSeat</title>
</head>
<body>
	<%
		Map<String, Boolean> map = (Map<String, Boolean>) request.getAttribute("rowsAndSeats");
		Set<String> rows = map.keySet();
		Iterator<String> iterate = rows.iterator();
	%>
	<h1>Select Seats</h1>
	<div>

		<form action="bookSeats.html" method="post">
			<input type="hidden" name="screenId" value="${screen}" />
			
			<h3>Screen ${screen}</h3>
			<table>

				<%
					for (int i = 0; i < 5; i++) {
				%>
				<tr>
					<%
						for (int j = 0; j < 5; j++) {
					%>

					<td>
						<%
							String row = iterate.next();
						%> <%=row%><input type="checkbox" name="seatNo" value="<%=row%>"
						<%if (map.get(row)) {
						  } else {%> disabled <%}%> /> |
					
					</td>
					<%
						}
					%>
				</tr>
				<%
					}
				%>
			</table>
			<input type="submit" value="BookSeats">
		</form>
	</div>
	<div></div>
</body>
</html>