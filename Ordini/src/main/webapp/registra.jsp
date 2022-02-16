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
<title>Registrazione utente</title>
<script src="js/validazione.js"></script>
</head>
<body>
<jsp:include page="nav.jsp" />
<div class="container">
<div class="page-header">
	<h3>Inserire i dati per la registrazione</h3>
</div>
<form id="userForm" action="/<%=application.getServletContextName()%>/registra" method="post"
class="form-horizontal">

<!-- NOME -->
<div class="form-group">
	<label class="col-md-1 control-label">Nome</label>
	<div class="col-md-4 inputGroupContainer">
		<div class="input-group">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-user"></i>
			</span>
			<input type="text" name="nome" id="nome" placeholder="Inserisci il tuo Nome.." class="form-control">
		</div>
	</div>
	<div class="col-md-7 control-label" id="infoNome"></div>
</div>

<!-- COGNOME -->
<div class="form-group">
	<label class="col-md-1 control-label">Cognome</label>
	<div class="col-md-4 inputGroupContainer">
		<div class="input-group">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-user"></i>
			</span>
			<input type="text" name="cognome" id="cognome" placeholder="Inserisci il tuo Cognome.." class="form-control">
		</div>
	</div>
	<div class="col-md-7 control-label" id="infoCognome"></div>
</div>

<!-- INDIRIZZO -->
<div class="form-group">
	<label class="col-md-1 control-label">Indirizzo</label>
	<div class="col-md-4 inputGroupContainer">
		<div class="input-group">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-home"></i>
			</span>
			<textarea rows="3" cols="50" name="indirizzo" id="indirizzo" placeholder="Inserisci il tuo indirizzo.." class="form-control"></textarea>
		</div>
	</div>
	<div class="col-md-7 control-label" id="infoIndirizzo"></div>
</div>

<!-- CAP -->
<div class="form-group">
	<label class="col-md-1 control-label">CAP</label>
	<div class="col-md-4 inputGroupContainer">
		<div class="input-group">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-home"></i>
			</span>
			<input type="text" name="cap" id="cap" placeholder="Inserisci il tuo Cap.." class="form-control" maxlength="5">
		</div>
	</div>
	<div class="col-md-7 control-label" id="infoCap"></div>
</div>

<!-- DATA NASCITA -->
<div class="form-group">
	<label class="col-md-1 control-label">Data Nascita</label>
	<div class="col-md-4 inputGroupContainer">
		<div class="input-group date" id="dp">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-calendar"></i>
			</span>
			<input type="text" name="nascita" id="nascita" placeholder="DD/MM/YYYY" class="form-control">
		</div>
	</div>
	<div class="col-md-7 control-label" id="infoNascita"></div>
</div>
<script>
$(function(){
	$('#dp').datepicker({
		format: 'dd/mm/yyyy',
		autoclose: true,
		startDate: '01/01/1900',
		endDate: new Date()	
	}).on(
			'changeDate', function(e){
				$('#userForm').bootstrapValidator('revalidateField', 'nascita');
	});
});
</script>

<!-- USERNAME -->
<div class="form-group">
	<label class="col-md-1 control-label">Username</label>
	<div class="col-md-4 inputGroupContainer">
		<div class="input-group">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-user"></i>
			</span>
			<input type="text" name="username" id="username" placeholder="Inserisci il tuo Username.." class="form-control" maxlength="10">
		</div>
	</div>
	<div class="col-md-7 control-label" id="infoUsername"></div>
</div>

<!-- PASSWORD -->
<div class="form-group">
	<label class="col-md-1 control-label">Password</label>
	<div class="col-md-4 inputGroupContainer">
		<div class="input-group">
			 <span class="input-group-addon">
				<i class="glyphicon glyphicon-lock"></i>
			</span>
			<input type="password" name="password" id="password" placeholder="Inserisci la tua password.." class="form-control">
		</div>
	</div>
	<div class="col-md-7 control-label" id="infoPassword"></div>
</div>

<!-- EMAIL -->
<div class="form-group">
	<label class="col-md-1 control-label">Email</label>
	<div class="col-md-4 inputGroupContainer">
		<div class="input-group">
			 <span class="input-group-addon">
				<i class="glyphicon glyphicon-envelope"></i>
			</span>
			<input type="text" name="email" id="email" placeholder="Inserisci la tua Email.." class="form-control">
		</div>
	</div>
	<div class="col-md-7 control-label" id="infoEmail"></div>
</div>

<div class="row">
	<div class="col-md-4 col-md-offset-1">
		<button type="submit" class="btn btn-warning">
			Registrati&nbsp;<span class="glyphicon glyphicon-send"></span>		
		</button>
	</div>
</div>
</form>
</div>
<footer><%@include file="footer.html" %></footer>
</body>
</html>