<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Accesso Negato!</title>
</head>
<body>
<jsp:include page="nav.jsp" />
<div class="container">
<div class="page-header">
	<h3>Non puoi accedere a questa pagina</h3>
</div>
<div class="panel panel-danger">
	<div class="panel-heading">
		<h3>Risorsa non disponibile</h3>
	</div>
	<div class="panel-body">
		<p>Per accedere alla pagina:</p>
		<p>Effettuare la registrazione</p>
		<p><a href="registra.jsp">Registrati</a></p>
		<p>Oppure effettuare il login</p>
		<p><a href="#" data-toggle="modal" data-target="#accnegModal">Login</a></p>	
	</div>
</div>

		<!-- Modal -->
		<div class="modal fade" id="accnegModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
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