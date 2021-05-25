<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
</head>

<body>
	<div class="container ">
		<div class="row margen">
			<div class="col-md-8 box">
				<div class="panel panel-default sombra">
			  		<div class="panel-body">
			  			<div class="">
			  				<h1>Login</h1>
			  				<form action="ControllerAcceso" method="post">
								<label>USER</label>
								<input class="form-control" type="text" name="user" placeholder="Escribe tu usuario">
								<br>
								<label>PASS</label>
								<input class="form-control" type="password" name="pass" placeholder="Escribe tu Contraseña">
								<br>
								<input class="btn btn-success" type="submit" value="Enviar Datos">
							</form>
			  			</div>
			  		</div>
	  			</div>
			</div>
		</div>
	</div>
</body>
</html>