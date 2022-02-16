<%
	String user = (String) session.getAttribute("username");
	String admin = (String) session.getAttribute("admin");
	if(user != null | admin != null) {
		session.invalidate();
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
<jsp:include page="nav.jsp" />
<div class="container">
<div class="page-header">
	<h2>Alla prossima!</h2>
</div>
	<div class="panel-body">
		<p>Per accedere nuovamente effettuare il login</p>
		<p><a href="#" data-toggle="modal" data-target="#logoutModal">
						<span class="glyphicon glyphicon-log-in"></span> Login
				</a>
	</div>
	
			<!-- Modal -->
		<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<form action="/<%=application.getServletContextName()%>/login"
						method="post" class="form-horizontal">
						<div class="modal-header">
							<h3 class="modal-title" align="center">Login</h3>
						</div>

						<!-- USERNAME -->
						<div class="form-group">
							<div class="col-md-3-auto">
								<label class="col-md-3 control-label">Username</label>
							</div>
							<div class="col-md-6 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"> <i
										class="glyphicon glyphicon-user"></i>
									</span> <input type="text" name="username" placeholder="Username.."
										class="form-control">
								</div>
							</div>
							<div class="col-md-5 control-label" id="infoUsername"></div>
						</div>

						<!-- PASSWORD -->
						<div class="form-group">
							<div class="col-md-3-auto">
								<label class="col-md-3 control-label">Password</label>
							</div>
							<div class="col-md-6 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"> <i
										class="glyphicon glyphicon-lock"></i>
									</span> <input type="password" name="password"
										placeholder="Password.." class="form-control">
								</div>
							</div>
							<div class="col-md-5 control-label" id="infoPassword"></div>
						</div>

						<div class="modal-footer">
					
							<button type="submit" class="btn btn-warning">
								Entra&nbsp;<span class="glyphicon glyphicon-login"></span>
							</button>
							</div>
						
					</form>
				</div>
			</div>
		</div>
	
</div>
<footer><%@include file="footer.html" %></footer>
</body>
</html>

<%
	}
	else {
		response.sendRedirect("accessonegato.jsp");
	}
%>