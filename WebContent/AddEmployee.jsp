<!-- /* ******************
 * 
 * 
 Author: Komal Patel
 * 
 *
 ********************/ -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<title>Employee Details</title>

<script>
function isValidDate(date)
{
    var matches = /^(\d{1,2})[-\/](\d{1,2})[-\/](\d{4})$/.exec(date);
    if (matches == null) return false;
    var d = matches[2];
    var m = matches[1] - 1;
    var y = matches[3];
    var composedDate = new Date(y, m, d);
    return composedDate.getDate() == d &&
            composedDate.getMonth() == m &&
            composedDate.getFullYear() == y;
}

		function validateDOB() {
			var lblError = document.getElementById("lblError");

			var dateString = document.getElementById("birthDate").value;
			var pattern = /(0[1-9]|1[0-2])\/(((0|1)[0-9]|2[0-9]|3[0-1])\/((19|20)\d\d))$/;

			if (pattern.test(dateString)) {
				var parts = dateString.split("/");
				var dtDOB = new Date(parts[1] + "/" + parts[0] + "/" + parts[2]);
				var dtCurrent = new Date();
				lblError.innerHTML = "Eligibility 18 years ONLY."
				if (dtCurrent.getFullYear() - dtDOB.getFullYear() < 18) {
					return false;
				}

				if (dtCurrent.getFullYear() - dtDOB.getFullYear() == 18) {
					if (dtCurrent.getMonth() < dtDOB.getMonth()) {
						return false;
					}
					if (dtCurrent.getMonth() == dtDOB.getMonth()) {
						if (dtCurrent.getDate() < dtDOB.getDate()) {
							return false;
						}
					}
				}
				lblError.innerHTML = "";
				return true;
			} else {
				lblError.innerHTML = "Enter date in MM/DD/yyyy format ONLY."
				return false;
			}
		}

</script>

</head>
<body>

<%-- <%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	if(session.getAttribute("username")==null){
		response.sendRedirect("Login.jsp");
	} 
%> --%> 
	
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="background-color:#383b43; font-size:15px; height:100px">
			
		<i class="fa fa-clock-o" aria-hidden="true" style="font-size: 24px; color: white"> </i> 
  		<a class="navbar-brand" href="#">TimeKeeper System</a>

  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ColockInTime">Time-In/Out</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Emp_Calendar">Calendar</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Employee Details
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="AddEmployee.jsp">Add New Employee</a>
          <a class="dropdown-item" href="ListEmployee.jsp">All Current Employees</a>
          <a class="dropdown-item" href="ListPreviousEmployee.jsp">Previous Employee</a>
          <a class="dropdown-item" href="ResetPassword.jsp">Reset Password</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Login">Logout</a>
      </li>
    </ul>
  </div>
</nav>
	 <h1 align="center" style="color:blue">Add New Employee Details</h1>
	
	<form name="form" action="AddEmployeeServlet" method="post">
		<div class="container" style="max-width: 1600px;"><br>
			<div class="row">
				<div class="col" style="float: left;">
					<div class="form-group">
						<h3>Personal Details</h3>
					</div>
					<div class="form-group">
						<label for="firstname"><b>First name:<label style="color:red">*</label></b></label><br> 
						<input type="text" name="firstname" class="form-control" placeholder="First Name" required="required">
					</div>
					<div class="form-group">
						<label for="middlename"><b>Middle name:</b></label> 
						<input type="text" name="middlename" class="form-control" placeholder="Middle Name">
					</div>
					<div class="form-group">
						<label for="lastname"><b>Last name:<label style="color:red">*</label></b></label><br> 
						<input type="text" name="lastname" class="form-control" placeholder="Last Name" required="required">
					</div>

					<div class="form-group">
						<label for="birthdate"><b>Birth Date:<label style="color:red">*</label></b></label><br> 
						<input type="text" name="birthdate" id="birthDate" class="form-control"	placeholder="mm/dd/yyyy" onblur="validateDOB()" required="required">
					</div>
					
		<div class="form-group">
			<label for="gender"><b>Gender:<label style="color:red">*</label></b></label><br> 
			<select name="gender" class="form-control" placeholder="Gender" required="required">
				<option value="male">Male</option>
				<option value="female">Female</option>
			</select>
		</div>

		<div class="form-group">
			<label for="phonenumber"><b>Phone number:<label style="color:red">*</label></b></label><br> 
			<input type="text" name="phonenumber" class="form-control" placeholder="Phone Number" required="required">
		</div>
		
		<div class="form-group">
			<label for="email"><b>Email address:<label style="color:red">*</label></b></label><br> 
			<input type="email" name="email" class="form-control" placeholder="Email Address" required="required">
		</div>
					
		<div class="form-group">
			<label for="highesteducations"><b>Choose Highest Education:<label style="color:red">*</label></b></label><br> 
			<select name="highesteducations" class="form-control" placeholder="Choose Highest Education" required="required">
				<option value="doctorate">Doctorate</option>
				<option value="masters">Masters</option>
				<option value="bachelorette">Undergraduate</option>
				<option value="associate">Associate</option>
				<option value="certification">Certification</option>
				<option value="highschool">High School</option>
				<option value="other">Other</option>
			</select>
		</div>
		</div>
			
		<div class="col" style="float: left;">
			<div class="form-group">
				<h3>Employment Details</h3>
			</div>
					
			<div class="form-group">
				<label for="designation"><b>Designation:<label style="color:red">*</label></b></label> 
				<input type="text" name="designation" class="form-control" placeholder="Designation">
			</div>
			
			<div class="form-group">
				<label for="effectivedate"><b>Effective Date:</b></label> 
				<input type="text" name="effectivedate" class="form-control" placeholder="mm/dd/yyyy" onblur="isValidDate">
			</div>
					
			<div class="form-group">
				<label for="joiningdate"><b>Joining Date:<label style="color:red">*</label></b></label><br> 
				<input type="text" name="joiningdate" id="joiningDate" class="form-control" placeholder="mm/dd/yyyy" onblur="ValidateDateFormat()" required="required">
			</div>
			
			<div class="form-group">
				<label for="companyname"><b>Joining Position:<label style="color:red">*</label></b></label><br> 
				<input type="text" name="joiningposition" class="form-control" placeholder="Joining Position" required="required">
			</div>

			<div class="form-group">
				<label for="companyname"><b>Employment Type:<label style="color:red">*</label></b></label><br> 
				<input type="text" name="employmenttype" class="form-control" placeholder="Employment Type" required="required">
			</div>
			
			<div class="form-group">
				<label for="ssn"><b>SSN:<label style="color:red">*</label></b></label><br> 
				<input type="text" name="ssn" pattern="^\d{3}-\d{2}-\d{4}$" class="form-control" placeholder="Social Security Number" required="required">
			</div>
		
			<div class="form-group">
				<label for="managerid"><b>Manager Id:<label style="color:red">*</label></b></label><br> 
				<input type="text" name="managerid" class="form-control" placeholder="Manager Id" required="required">
			</div>
			
			<div class="form-group">
				<label for="departmentname"><b>Department Name:<label style="color:red">*</label></b></label><br> 
				<input type="text" name="departmentname" class="form-control" placeholder="Department Name" required="required">
			</div>
			
			<div class="form-group">
				<label for="project"><b>Project:</b></label><br> 
				<input type="text" name="project" class="form-control" placeholder="Project (if alloted)" required="required">
			</div>
		</div>
	</div>	
			
			<div class="row">
				<div class="mx-auto" style="width:200px; margin-top:20px;">
					<button type="submit" class="btn btn-primary btn-block">Save Details</button>
					<button type="reset" class="btn btn-primary btn-block">Reset Details</button><br>
				</div>
			</div>
		</div>

		<%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%>

	</form>
</body>
</html>