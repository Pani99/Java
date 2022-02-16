<%@page import="businesscomponent.AdminFacade"%>
<%@page import="businesscomponent.model.Articolo"%>
<% 
	long id = Long.parseLong(request.getParameter("id"));
	Articolo a = null;
	
	if(request.getParameter("id") == null) {
		response.sendRedirect("admin/gestisciArticoli.jsp");
	} else {

%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%
 	a = AdminFacade.getInstance().getArticoloById(id);
 	
 	if(a == null)
 		a = new Articolo();
 %>
 <div class="modal fade" id="editModal_<%=id%>" role="dialog">
 	<div class="modal-dialog modal-md" role="document">
 		<form action="/<%= application.getServletContextName()%>/inserisciArticolo" method="post">
 			<div  class="modal-content">
	 			<div class="modal-header">
	 				<button type="button" class="close" data-dismiss="modal">&times;</button>
	 				<h4 class="modal-title"> Modifica articolo </h4>
	 			</div>
	 			
	 			<div class="modal-body">
	 				<input type="hidden" name="id" value="<%=a.getId_articolo()%>">
	 				
	 				<div class="form-group">
	 					<label for="marca">Marca</label>
	 					<input type="text" class="form-control" name="marca" value="<%=a.getMarca() == null ? "" : a.getMarca()%>">
	 				</div>
	 				<div class="form-group">
	 					<label for="modello">Modello</label>
	 					<input type="text" class="form-control" name="modello" value="<%=a.getModello() == null ? "" : a.getModello()%>">
	 				</div>
	 				<div class="form-group">
	 					<label for="prezzo">Prezzo</label>
	 					<input type="text" class="form-control" name="prezzo" value="<%=a.getPrezzo()%>">
	 				</div>
	 			</div>
	 			
	 			<div class="modal-footer">
	       			<button type="submit" class="btn btn-success btn-lg">Salva modifiche</button>
	       			<button type="submit" class="btn btn-default" data-dismiss="modal">Annulla</button>
	      		</div>
      		 </div>>
 		</form>
 	</div>
 </div>
 
 <%
	}
 %>
