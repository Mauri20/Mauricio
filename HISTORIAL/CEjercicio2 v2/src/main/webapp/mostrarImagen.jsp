<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Archivos</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

</head>
<script type="text/javascript">
$(document).ready(function (){
		$.post('ControllerFiles',{
			//Esta seccion es para enviar peticiones al servidor
			
		}, function (response){
			//Esta seccion es para recibir informacion
			let datos = response;
			//let datos = response.getAttribute("names");
			console.log(datos);
			//HACIENDO LA UNION DE CODIGO PARA MOSTRAR LOS DATOS
			
		});
	});
</script>		  				
<body>
	<div class="container">
		<div class="row ">
			<div class="col-6 offset-3">
				<div class="mt-5 rounded card card-body bg-secondary text-white">
					<div id="aqui">
						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>