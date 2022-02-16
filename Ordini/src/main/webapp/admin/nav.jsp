<nav class="navbar navbar-default">
<div class="container-fluid">
	<div class="navbar-header">
		<button type="button" data-toggle="collapse" class="navbar-toggle" data-target="#menu">
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="admin.jsp">Home</a>
	</div>
	<div class="collapse navbar-collapse" id="menu" >
		<%
			String admin = (String) session.getAttribute("admin");
			if(admin == null) {
		%>
		<ul class="nav navbar-nav navbar-right">
			<li>
			<a href="../login.jsp">
				<span class="glyphicon glyphicon-log-in"></span> Accedi
			</a>
			</li>
		</ul>
		<%
			}
			else {
		%>
	<ul class="nav navbar-nav">
			<li>
			<a href="report.jsp">Report Vendite</a>
			</li>
			<li class="dropdown">
			<a href="#" class="btn btn-default dropdown-toggle"
			type="button" data-toggle="dropdown">Gestione Articoli</a>
			<ul class="dropdown-menu">
				<li>
					<a href="gestisciArticoli.jsp">
					Gestisci Articoli
					</a>
				</li>
				<li>
					<a href="#" data-toggle="modal" data-target="#editModal_0">
						Inserisci
					</a>			
				</li>
			</ul>
			</li>
	</ul>
	
	
	<ul class="nav navbar-nav navbar-right">
			<li>
			<a href="#">
				<span class="glyphicon glyphicon-user"></span> <%= admin  %>
			</a>
			</li>
			<li>
			<a href="../logout.jsp">
				<span class="glyphicon glyphicon-off"></span> Logout
			</a>
			</li>		
		</ul>
		<%
			}
		%>
	</div>
</div>
</nav>
<jsp:include page="editArticoloModal.jsp">
	<jsp:param value="0" name="id" />
</jsp:include>