<%@page import="businesscomponent.ImmagineBC"%>
<%@page import="businesscomponent.model.Immagine"%>
<%@page import="java.util.ArrayList"%>
<%@page import="businesscomponent.model.OrdineArticolo"%>
<%@page import="businesscomponent.AdminFacade"%>
<%@ page import="businesscomponent.model.Articolo" %>
<%@page import="businesscomponent.model.Ordine"%>
<% 
	int id = Integer.parseInt(request.getParameter("id")); 
	
	if(request.getParameter("id") == null) {
		response.sendRedirect("admin/gestisciArticoli.jsp");
	} else {

%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%
 	Ordine ordine = AdminFacade.getInstance().getOrdineById(id);
 	OrdineArticolo[] oa = AdminFacade.getInstance().getOrdineArticolo();
 	Immagine img = new Immagine();
 	ImmagineBC imgbc = new ImmagineBC();
	
 	%>
 	
 <div class="modal fade" id="gestisciArticoloModal_<%=ordine.getId_ordine()%>" role="dialog">
 	<div class="modal-dialog modal-md" role="document">
 		<div  class="modal-content">
	 		<div class="modal-header">
	 			<button type="button" class="close" data-dismiss="modal">&times;</button>
	 				<h4 class="modal-title"> Riepilogo ordine </h4>
	 		</div>
	 			
	 		<div class="modal-body">
	 			<div>
	 				<label for="marca">Utente che ha effettuato l'ordine:</label> <%=ordine.getUsername()%>
	 			</div>
	 			<div>
	 				<label for="modello">Totale ordine:</label> <%=ordine.getTotale()%> &euro;
	 			</div>
	 			<br>
	 			<div>
					<table class="table table-warning">
						<thead>
							<tr>
								<th scope="col"></th>
								<th scope="col">Marca</th>
								<th scope="col">Modello</th>
								<th scope="col">Quantita</th>
							</tr>
						</thead>
						<tbody>
   						<tr>
							<%
						 	for(OrdineArticolo temp : oa) {
						 		if(temp.getIdOrdine() == ordine.getId_ordine()){	
						 			img.setIdImg(temp.getIdArticolo());
						 			img = imgbc.getImgById(img);
						 	%>
						<td><img src="../<%=application.getServletContextName()%><%= img.getUrl()%>" style="width: 50px;"></td>
     					<td><%=AdminFacade.getInstance().getArticoloById(temp.getIdArticolo()).getMarca()%></td>
      					<td><%=AdminFacade.getInstance().getArticoloById(temp.getIdArticolo()).getModello()%></td>
      					<td><%=temp.getQuantita()%></td>
      					</tr>
						<% 	
					 		}
					 	}
					 	
					 %>
					</tbody>
					</table>
				</div>
	 		</div>
	 	</div>
 	</div>
 </div> 
 <%
	}
 %>