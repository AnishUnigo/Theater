<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import="java.lang.String"%>    
<%@ page import="java.util.Map"%>
<%@ page import="java.util.LinkedHashMap"%>
<%@ page import="java.lang.Integer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking</title>
</head>
<body>
	 	
	<%String alpha[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P"}; %>	
	<%int rows= (Integer) request.getAttribute("rows"); %>	
	<%int seats= (Integer) request.getAttribute("screens"); %>
	<div>
		
		<form action="display.html" method="post">
				
			<h1 name="theaterName"> Welcome <span>${theaterName}</span></h1>
			
			<h2>Select a Movie</h2>
				
			<select name="movie" value=this.value >
				<option value="dispicableMe3">DispicableMe 3</option>
				<option value="bayWatch">BayWatch</option>
				<option value="Cars3">Cars 3</option>
				<option value="Transformers">Transformers</option>
				<option value="KongSkull">Kong Skull</option>
				
			</select><br>
			<%-- <c:forEach var = "i" begin = "1" end = "<%=seats%>" >
         			 <option value="i">Screen_<c:out value = "${i}"/></option>
      			</c:forEach> --%>	
			<h2>Select Screen Type</h2>
			
			<select name="screenId"  value=this.value>
				<option value="1">Screen_1</option>
				<option value="2">Screen_2</option>
				<option value="3">Screen_3</option>
			</select>	<br>
			<h2>No Of Tickets</h2>
			<input type="number" name="tickets" /> 
			<table>
			<%-- <%int counter=0; %>
			<%for(int i=1; i<=rows ;i++) { %>
				
				<tr>
				<% for(int j=1; j<=10; j++){ %>
					
					<td>
						<%=alpha[counter]%><%=j %> : <input type="checkbox" name="RowAndSeat" value= "<%=alpha[counter]%><%=j %>" />
					</td>
					
				<% } %>
				</tr>
				<%counter++; %>
		<% }%>
		
 --%>		</table>
			
			<input type="submit" value="Book Tickets">
			
		</form>
	</div>
</body>
</html>