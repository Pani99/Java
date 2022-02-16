<%@page import="businesscomponent.model.Immagine"%>
<%@page import="java.util.Enumeration"%>
<%@page import="businesscomponent.model.Articolo"%>
<%@page import="businesscomponent.ClientFacade"%>

<%
String user = (String) session.getAttribute("username");
	if(user != null) {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page errorPage="error.jsp"%>
<jsp:useBean id="carrello" class="businesscomponent.Carrello" scope="session" />
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Riepilogo acquisti</title>
</head>
<body>
<jsp:include page="nav.jsp" />
<div class="container">
<div class="page-header">
	<h3>Lista articoli</h3>
</div>
<p>Totale carrello: <strong><%= String.format("%.2f", carrello.totaleComplessivo()) %></strong></p>
<div class="table-responsive">	
	<table class="table table-hover">
		<thead>
		<tr>
			<th>Foto</th>
			<th>Marca</th>
			<th>Modello</th>
			<th>Parziale</th>
			<th>Quantit&agrave;</th>
			<th>Rimuovi</th>
		</tr>
		</thead>
		<tbody>
			<%
				ClientFacade cF = ClientFacade.getInstance();
				Enumeration<String[]> prodotti = carrello.getElementi();
				while(prodotti.hasMoreElements()){
				String[] prodotto = prodotti.nextElement();
				Immagine img = new Immagine();
			    img.setIdImg(Long.parseLong(prodotto[4].trim()));
			    img = cF.getImgById(img);
			%>
			<tr>
				<td><img src="/<%=application.getServletContextName()%><%= img.getUrl()%>" style="width: 50px;"></td>
				<td><%=prodotto[0]%></td>
				<td><%=prodotto[1]%></td>
				<td><%=String.format("%.2f", carrello.totaleParziale(prodotto[4]))%>&euro;</td>
				<td><%=prodotto[3]%></td>
				<td>
				<form action="/<%=application.getServletContextName()%>/rimuovi" method="post">
				<input type="hidden" name="id" value="<%=prodotto[4]%>">
				<button type="submit" class="btn btn-danger btn-xs">
					Rimuovi
				</button>
				</form>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</div>
<hr>
<a href="acquisti.jsp">Torna allo shopping</a>

<%

	if(carrello.getArticoli() != 0){

%>
<div class="panel panel-default" style="margin-top:40px;">
	<div class="panel panel-heading">
		<h4><strong>Conferma ordine</strong></h4>
		<div style="text-align: right">Totale articoli nel carrello
		<%= carrello.getArticoli() %>
		</div>
	</div>
	<div class="panel-body">
		<form action="/<%=application.getServletContextName()%>/conferma" method="post">
			<button type="submit" class="btn btn-success btn-lg">
				&#10003; Acquista prodotti
			</button>
		</form>
	</div>
</div>
<%
	}
%>
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