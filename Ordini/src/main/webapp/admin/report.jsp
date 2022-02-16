<%@page import="businesscomponent.AdminFacade"%>
<%@page import="businesscomponent.model.Ordine"%>
<%
String admin = (String)session.getAttribute("admin");

if(admin == null){
	response.sendRedirect("../login.jsp");
} else {
%>


<%@ page import="businesscomponent.model.Articolo"%>
<%@ page import="businesscomponent.ClientFacade"%>
<%@ page import="businesscomponent.model.Immagine"%>
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
<title>Pagina degli acquisti</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
	<div class="container">
	
		<div class="page-header">
			<h3>Lista articoli</h3>
		</div>
		<div class="table-responsive">
			<table class="table table-dark">
				<thead>
				<tr>
					<th>ID Ordine</th>
					<th>Riepilogo</th>
					<th>Rimuovi ordine</th>
				</tr>
				</thead>
				<tbody>
					<%
						Ordine[] ordini = AdminFacade.getInstance().getOrdini();
						for(Ordine ordine : ordini) {
					%>
					<tr>
						<td>
						
							<%= ordine.getId_ordine()%>
						
						</td>
						<td>
							<button type="button" class="btn btn-info" 
							data-toggle="modal" data-target="#gestisciArticoloModal_<%=ordine.getId_ordine()%>">Riepilogo
							</button>
						</td>
						<td><form action="/<%= application.getServletContextName() %>/rimuoviOrdine" method="post">
							<input type="hidden" name="id" value="<%= ordine.getId_ordine() %>">
							<input type="hidden" name="username" value="<%= ordine.getUsername() %>">
							<input type="hidden" name="totale" value="<%= ordine.getTotale() %>">
							<input type="hidden" name="data" value="<%= ordine.getData() %>">
							<button type="submit" class="btn btn-danger btn-xs">
							<span class="glyphicon glyphicon-remove"></span>
							</button>
						</form></td>
						<td>
							<jsp:include page="gestisciArticoloModal.jsp">
								<jsp:param value="<%=ordine.getId_ordine()%>" name="id"/>
							</jsp:include>
						</td>
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