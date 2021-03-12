<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
	<div class="container ">
		<div class="row margen">
			<div class="col-md-12">
				<div class="panel panel-default sombra">
			  		<div class="panel-body">
			  			<div class="centrar">
			  				<h1>WELCOME</h1>
			  				<script type="text/javascript">
			  					$(document).ready(function (){
		  							$.post('ControllerMostrarInformacion',{
		  								//Esta seccion es para enviar peticiones al servidor
		  								
		  							}, function (response){
		  								//Esta seccion es para recibir informacion
		  								let datos = JSON.parse(response);
		  								console.log(datos);
		  							});
		  						});
			  				</script>
			  				<table>
			  					<thead>
			  						<tr>
			  							<th></th>
			  							<th></th>
			  							<th></th>
			  						</tr>
			  					</thead>
			  					<tbody>
			  						
			  					</tbody>
			  				</table>
			  			</div>
			  		</div>
	  			</div>
			</div>
		</div>
	</div>
</body>
</html>