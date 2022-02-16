<%@page import="businesscomponent.ClientFacade"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="businesscomponent.AdminFacade"%>
<%@page import="java.sql.Statement"%>
<%
	String admin = (String)session.getAttribute("admin");

	if(admin != null){
		
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="../error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../CDN.html"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/style.css">
<meta charset="ISO-8859-1">
<title>Home page administrator</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
	<div class="container">
		<div class="page-header">
			<h3>Statistiche:</h3>
		</div>
		<% 	String customerMostOrders =  AdminFacade.getInstance().mostOrders();
			String customerMostSpent = AdminFacade.getInstance().mostSpentByUser();
		
		%>
		<h4>Totale vendite: <%= AdminFacade.getInstance().totaleVendite() %> euro</h4>
		<br>
		<h4>Prodotto con vendita maggiore: <%= AdminFacade.getInstance().bestSeller()%></h4>
		<br>
		
		<h4>Cliente con pi&ugrave; ordini: </h4>
		<table class="table table-warning">
			<thead>
				<tr>
					<th scope="col">Username</th>
					<th scope="col">Nome</th>
					<th scope="col">Cognome</th>
					<th scope="col">Email</th>
					<th scope="col">Ordini</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=customerMostOrders%></td>
					<td><%=AdminFacade.getInstance().getUtenteById(customerMostOrders).getNome()%></td>
					<td><%=AdminFacade.getInstance().getUtenteById(customerMostOrders).getCognome()%></td>
					<td><%=AdminFacade.getInstance().getUtenteById(customerMostOrders).getEmail()%></td>
					<td><%=AdminFacade.getInstance().mostOrdersByUser()%></td>
				</tr>
			</tbody>
		</table>
		<h4>Cliente che ha speso di pi&ugrave;: </h4>
		<table class="table table-warning">
			<thead>
				<tr>
					<th scope="col">Username</th>
					<th scope="col">Nome</th>
					<th scope="col">Cognome</th>
					<th scope="col">Email</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=customerMostSpent%></td>
					<td><%=AdminFacade.getInstance().getUtenteById(customerMostSpent).getNome()%></td>
					<td><%=AdminFacade.getInstance().getUtenteById(customerMostSpent).getCognome()%></td>
					<td><%=AdminFacade.getInstance().getUtenteById(customerMostSpent).getEmail()%></td>
				</tr>
			</tbody>
		</table>
		
	</div>
	<footer><%@ include file="footer.html"%></footer>
</body>
</html>

<%

	} else {
		response.sendRedirect("../accessonegato.jsp");
	}
%>