<!-- /* ******************
 * 
 * 
 Author: Komal Patel
 * 
 *
 ********************/ -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Reset Password</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<script type="text/javascript">

function validatePassword() {
	
	  if (document.getElementById('newpassword').value ==
	    document.getElementById('confirmpassword').value) {
	    document.getElementById('message').style.color = 'green';
	    document.getElementById('message').innerHTML = 'Passwords matched'; 
	    document.getElementById('btnReset').disabled = false;
	  } else {
	    document.getElementById('message').style.color = 'red';
	    document.getElementById('message').innerHTML = 'Passwords are not matching';
	    document.getElementById('btnReset').disabled = true;
	  }
	}

</script>

<style>
.reset-form {
    width: 340px;
    margin: 50px auto;
  	font-size: 15px;
}
.reset-form form {
    margin-bottom: 15px;
    background: #f7f7f7;
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    padding: 30px;
}
.reset-form h2 {
    margin: 0 0 15px;
}
.form-control, .btn {
    min-height: 38px;
    border-radius: 2px;
}
.btn {        
    font-size: 15px;
    font-weight: bold;
}
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="background-color:#383b43; font-size:15px; height:100px">
			
		<i class="fa fa-clock-o" aria-hidden="true" style="font-size: 24px; color: white"> </i> 
  		<a class="navbar-brand" href="#">TimeKeeper System</a>

  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      	<li class="nav-item active">
        	<a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a></li>
     	<li class="nav-item">
      		<a class="nav-link" href="ColockInTime.jsp">Time-In/Out</a></li>
      		<li class="nav-item">
      		<a class="nav-link" href="ColockInTime.jsp">Request Time-In/Out</a></li>
      <li class="nav-item">
        <a class="nav-link" href="Emp_Calendar.jsp">Calendar</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Employee Details
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="AddEmployee.jsp">Add New Employee</a>
          <a class="dropdown-item" href="ListEmployee.jsp">All Current Employees</a>
          <a class="dropdown-item" href="ListPreviousEmployee.jsp">Previous Employee</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Login.jsp">Logout</a>
      </li>
    </ul>
  </div>
</nav>
<div class="reset-form">
    <form action="ResetPasswordServlet" method="post">
        <h2 class="text-center">Reset Password</h2>       
        <div class="form-group">
            <input type="text" name="employeeid" class="form-control" placeholder="Employee Id" required="required">
        </div>
        
        <div class="form-group">
            <input type="text" name="username" class="form-control" placeholder="User Name" required="required">
        </div>
        
        <div class="form-group">
            <input type="password" id="newpassword" name="newpassword" class="form-control" placeholder="New Password" onchange="validatePassword()" required="required">
        </div>
        
        <div class="form-group">
            <input type="password" id="confirmpassword" name="confirmpassword" class="form-control" onchange="validatePassword()" placeholder="Confirm Password" required="required">
        	<span id='message'></span>
        </div>
        
        <div class="form-group">
            <button type="submit" id="btnReset" class="btn btn-primary btn-block" disabled>Reset Password</button>
        </div>
               
    </form>
</div>
</body>
</html>