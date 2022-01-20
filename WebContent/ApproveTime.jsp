<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.*,java.lang.String.*,edu.ssdi.model.TITO_Handler" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Approve Time Changes</title>
</head>
<body>
	<%
		TITO_Handler th = new TITO_Handler();
		String s = th.requestsToTable();
	%>
	<%=s %>
	
	<form method="post" action='ResolveRequest'>
		
		<br><br><br><br>
		<div align="center">
	
			<label for="reqpid">ID:</label>
	  		<input type="text" id=reqid" name="reqid"><br>
  			<br>
	  		<label for="approve">Approve</label>
	  		<input type="radio" id="approve" name="ar_stat" value="approve"><br>
	  		<label for="reject">Reject</label>
	  		<input type="radio" id="reject" name="ar_stat" value="reject"><br>
	  		<br>
	  		<input type="submit" value="Submit">
  		</div>
	</form>
	
</body>
</html>