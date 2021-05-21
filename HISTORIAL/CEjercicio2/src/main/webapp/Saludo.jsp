<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
	<div class="container ">
		<div class="row margen">
			<div class="col-md-12">
				<div class="panel panel-default sombra">
			  		<div class="panel-body">
			  			<div class="centrar">
			  			<h1></h1>
			  			<a class="btn btn-info" href="add.jsp">Agregar Nuevo</a>
			  				<script type="text/javascript">
			  					$(document).ready(function (){
		  							$.post('ControllerMostrarInformacion',{
		  								//Esta seccion es para enviar peticiones al servidor
		  								
		  							}, function (response){
		  								//Esta seccion es para recibir informacion
		  								let datos = JSON.parse(response);
		  								console.log(datos);
		  								//HACIENDO LA UNION DE CODIGO PARA MOSTRAR LOS DATOS
		  								var tabla = document.getElementById('tablaDatos');
		  								for(let item of datos){
		  									
		  									tabla.innerHTML += `
		  										<tr>
		  											<td> ${item.idUsuario} </td>
		  											<td> ${item.Usuario} </td>
		  											<td> ${item.PassWord} </td>
		  											<td> <a href="ControllerMostrarInformacion?IdUsuario=${item.idUsuario}&Eliminar=btne" class="btn btn-danger">Eliminar </td>
		  											<td> <a name="usu" href="add.jsp?Id=${item.idUsuario}&Usuario=${item.Usuario}&Pass=${item.PassWord}" class="btn btn-warning">Actualizar </td>
		  										</tr>
		  										
		  									
		  									`
		  									
		  									console.log(item.Pass);
		  								}
		  							});
		  						});
			  				</script>
			  				<table id="tablaDatos" class="table table-dark table-striped">
			  					<thead>
			  						<tr>
			  							<th>IdUsuario</th>
			  							<th>Usuario</th>
			  							<th>Password</th>
			  							<th colspan="2">Acciones</th>
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