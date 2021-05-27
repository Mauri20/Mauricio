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
<script type="text/javascript">
$(document).ready(function (){
		$.get('ControllerFiles',{
			//Esta seccion es para enviar peticiones al servidor
			
		}, function (response){
			//Esta seccion es para recibir informacion
			let datos = JSON.parse(response);
			//let datos = response.getAttribute("names");
			console.log(datos);
			//HACIENDO LA UNION DE CODIGO PARA MOSTRAR LOS DATOS
			
			var tabla = document.getElementById('tablaDatos');
			for(let item of datos){
				
				tabla.innerHTML += `
					<tr>
						<td><img class="m-1 img-thumbnail" src="Files/${item}""></td>
					</tr>
					
				
				`
				
				console.log(item);
			}
		});
	});
</script>
</head>
		  				
<body>
	<div class="container">
		<div class="row ">
			<div class="col-6 offset-3">
				<div class="mt-5 rounded card card-body bg-secondary text-white">
					<div id="">
						<table id="tablaDatos" class="table table-dark table-striped">
		  					<thead>
		  						<tr>
		  							<th style="text-align: center">Imagen</th>
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
</body>
</html>