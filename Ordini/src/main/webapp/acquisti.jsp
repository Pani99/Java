<%@page import="businesscomponent.ImmagineBC"%>
<%@page import="businesscomponent.model.Immagine"%>
<%@page import="businesscomponent.model.Articolo"%>
<%@page import="businesscomponent.ClientFacade"%>

<%
String user = (String) session.getAttribute("username");
	if(user != null) {
%>
<%@ page language="java" contentType="text/html;image/jpg; charset=ISO-8859-1"
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
<title>Pagina degli acquisti</title>
</head>
<body>
<jsp:include page="nav.jsp" />
<div class="container">
<div class="page-header">
	<h3>Lista articoli</h3>
</div>
<form  action="#" method="POST" class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" name="ricerca" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Cerca</button>
    </form>
<div class="table-responsive">	
	<table class="table table-hover">
		<thead>
		<tr>
			<th>Foto</th>
			<th>Marca</th>
			<th>Modello</th>
			<th>Prezzo</th>
			<th>Ordine</th>
		</tr>
		</thead>
		<tbody>
			<%
			ClientFacade cF = ClientFacade.getInstance();
			Articolo[] articoli;
			System.out.println("valore ricerca "+(String)request.getParameter("ricerca"));
			if(request.getParameter("ricerca")==null){
					 articoli = cF.getArticoli();	
			}else{
			articoli = cF.searchArticolo((String)request.getParameter("ricerca"));
			}
			for(Articolo a : articoli) {	
					Immagine img = new Immagine();
					img.setIdImg(a.getId_articolo());
					img = cF.getImgById(img);
			%>
			<tr>
				<td><img src="/<%=application.getServletContextName()%><%= img.getUrl()%>" style="width: 50px;"></td>
				<td><%= a.getMarca() %></td>
				<td><%= a.getModello() %></td>
				<td><%= String.format("%.2f", a.getPrezzo()) %></td>
				<td>
				<form action="/<%=application.getServletContextName()%>/aggiungi" method="post">
				<input type="hidden" name="id" value="<%= a.getId_articolo() %> ">
				<input type="hidden" name="marca" value="<%= a.getMarca() %> ">
				<input type="hidden" name="modello" value="<%= a.getModello() %> ">
				<input type="hidden" name="prezzo" value="<%= a.getPrezzo() %> ">
				<button type="submit" class="btn btn-primary btn-xs">
					Aggiungi
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
<p>Totale carrello: <strong><%= String.format("%.2f", carrello.totaleComplessivo()) %></strong></p>
<hr>
<a href="carrello.jsp">Riepilogo Carrello</a>
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