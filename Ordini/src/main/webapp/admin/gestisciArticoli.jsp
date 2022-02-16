<%@page import="java.util.ArrayList"%>
<%@page import="businesscomponent.AdminFacade"%>
<%@page import="businesscomponent.model.Ordine"%>
<%@ page import="businesscomponent.model.Articolo"%>
<%@ page import="businesscomponent.ClientFacade"%>
<%@ page import="businesscomponent.model.Immagine"%>
<%
String admin = (String)session.getAttribute("admin");

if(admin == null){
	response.sendRedirect("../login.jsp");
} else {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../CDN.html"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/style.css">
<meta charset="ISO-8859-1">
<title>Gestione Articoli</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
	<div class="container">
	
		<div class="page-header">
			<h3>Lista articoli</h3>
		</div>
				
		<form action="#" method="post" class="form-inline my-2 my-lg-4">
		<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span>
					<input type="text" name="ricerca" id="ricerca" placeholder="Ricerca articolo" class="form-control">
				</div>
		</div>
		<hr>
		</form>
		
		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
				<tr>
					<th>ID</th>
					<th>Marca</th>
					<th>Modello</th>
					<th>Prezzo</th>
					<th>Aggiorna</th>
					<th>Elimina</th>
				</tr>
				</thead>
				<tbody>
					<%
						ArrayList<Articolo> articoli = ClientFacade.getInstance().getArrayArticoli();
					
						if(request.getParameter("ricerca") != null) {
							String search = (String)request.getParameter("ricerca");
							articoli = ClientFacade.getInstance().getArticoliSearch(search);
							
						} else {
							articoli = ClientFacade.getInstance().getArrayArticoli();
						}
						
						for(Articolo a : articoli) {
							
					%>
					<tr>
						<td><%= a.getId_articolo()%></td>
						<td><%= a.getMarca() %></td>
						<td><%= a.getModello()%></td>
						<td><%= String.format("%.2f", a.getPrezzo()) %>&euro;</td>
						<td><button type="button" class="btn btn-light btn-xs" data-toggle="modal" data-target="#editModal_<%=a.getId_articolo()%>">
							<span class="glyphicon glyphicon-wrench"></span>
							</button>
							</td>
						<td><form action="/<%= application.getServletContextName() %>/rimuoviArticolo" method="post">
							<input type="hidden" name="id" value="<%= a.getId_articolo() %>">
							<input type="hidden" name="marca" value="<%= a.getMarca() %>">
							<input type="hidden" name="modello" value="<%= a.getModello() %>">
							<input type="hidden" name="prezzo" value="<%= a.getPrezzo() %>">
							<button type="submit" class="btn btn-dark btn-xs" >
							<span class="input-group-addon"><i class="bi bi-trash"></i></span>
							</button>
						</form></td>
						<td><jsp:include page="editArticoloModal.jsp">
								<jsp:param value="<%=a.getId_articolo()%>" name="id" />
							</jsp:include></td>
					</tr>
					<% 
						}
					%>
				</tbody>
			</table>
		</div>	
		<hr>
	</div>
	<footer><%@ include file="footer.html"%></footer>

</body>
</html>

<%
	}
%>

