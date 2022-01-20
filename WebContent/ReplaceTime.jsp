<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request time off</title>
</head>
<body>

	<form method="post" action='RequestTimeOff'>
		<label for="olddate">Date To Replace:</label><br>
  		<input type="date" id="olddate" name="olddate"><br>
  		
  		<label for="oldtime">Time To Replace:</label><br>
  		<input type="time" id="oldtime" name="oldtime"><br>
  		
  		<label for="newdate">New Date:</label><br>
  		<input type="date" id="newdate" name="newdate"><br>
  		
  		<label for="newtime">New Time:</label><br>
  		<input type="time" id="newtime" name="newtime"><br>
  		
  		<label for="reason">Text:</label><br>
  		<input type="text" id="reason" name="reason"><br>
  		<input type="submit" value="Submit">
	</form>

</body>
</html>