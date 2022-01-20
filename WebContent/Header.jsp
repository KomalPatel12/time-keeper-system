<!-- ****************************Author : Akanksha Gupta **************************************** -->
	<header id="header">
			  <!--    <i class="fas fa-user-clock" style="font-size:30px;color:white;"></i> -->
				<h1>  <i class="fas fa-user-clock" style="font-size:30px;color:white;"></i><a href="index.html">TimeKeeper</a></h1>
				<nav id="nav">
					<ul>
					<li><a href="Home">Home</a></li>
			  	<%if((session.getAttribute("username")== null) )	{ %>	
				
						
						
						<li><a href="IndexServlet" class="button special">Login</a></li> 
						
				<% } %>
				<% if((session.getAttribute("roleId")!= null) )	{ %>	
				
				<li><a href="ClockInTime">Clock In Time</a></li>
						<li><a href="EmpCalendar">Calender</a></li>
						
				
				
			
				
				         <% if(session.getAttribute("roleId").equals("1") ) {%>
					
					 
					    <li><a href="TeamView">Team</a></li>
					       <li><a href="Org">Org</a></li>
							<li><a href="ResetPassword.jsp">Reset Password</a></li>
       
        	<li><a href="AddEmployee.jsp">Add Employee</a></li>
        		<li><a href="ListEmployee.jsp"">Current Employees</a></li>
        			<li><a href="ListPreviousEmployee.jsp">Previous Employees</a></li>
        			
        	
        	
						
					
						<%} %>
				       <% if(session.getAttribute("roleId").equals("2") ) { %>
						
						<li><a href="TeamView">Team</a></li>
						
						
						<%} %>
						<% if((session.getAttribute("roleId")!= null) )	{ %>	
				
				
						<li><a href="logout">Logout</a></li>
				
				<% } %>
				<%} %>
					</ul>
				</nav>
			</header>
