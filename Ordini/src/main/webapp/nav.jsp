<jsp:useBean id="carrello" class="businesscomponent.Carrello" scope="session" />
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" data-toggle="collapse" class="navbar-toggle"
				data-target="#menu">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="home.jsp">Home</a>
		</div>
		<div class="collapse navbar-collapse" id="menu">
			<%
			String username = (String) session.getAttribute("username");
			if (username == null) {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="registra.jsp"> <span
						class="glyphicon glyphicon-user"></span> Registrati
				</a></li>
				<li><a href="#" data-toggle="modal" data-target="#navModal">
						<span class="glyphicon glyphicon-log-in"></span> Accedi
				</a></li>
			</ul>
			<%
			} else {
			%>
			<ul class="nav navbar-nav">
				<li><a href="acquisti.jsp">Scelta articoli</a></li>
				<li><a href="carrello.jsp">Riepilogo acquisti</a></li>
			</ul>


			<ul class="nav navbar-nav navbar-right">
				<li><a href="carrello.jsp"> <span
						class="glyphicon glyphicon-shopping-cart">&nbsp;</span> <span
						class="badge"><%=carrello.getArticoli()%></span>
				</a></li>
				<li><a href="user.jsp"> <span
						class="glyphicon glyphicon-user"></span> <%=username%>
				</a></li>
				<li><a href="logout.jsp"> <span
						class="glyphicon glyphicon-off"></span> Logout
				</a></li>
			</ul>
			<%
			}
			%>
		</div>

		<!-- Modal -->
		<div class="modal fade" id="navModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
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
</nav>