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
<%
	String Id = request.getParameter("Id");
	String Usuario= request.getParameter("Usuario");
	String Pass = request.getParameter("Pass");
	if(Id == null){
		Id="";
		Usuario="";
		Pass="";
	}
%>
<div class="container">
	<div class="row text-center">
		<div class="card">
			<div class="card-body">
				<form action="ControllerMostrarInformacion" method="get">
					<input class="form-control" type="hidden" value=<%=Id%> name="IdUsuario">
					<label>Usuario</label>
					<input class="form-control" type="text" value="<%=Usuario%>" name="Usuario">
					<label>Password</label>
					<input class="form-control" type="text" value="<%=Pass%>" name="Pass">
					<br>
					<button name="guardar" value="btna" class="btn btn-success">Guardar</button>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<button name="cancelar" value="" class="btn btn-danger">Cancelar</button>
				</form>
			</div>
		</div>
	</div>
</div>

</body>
</html>