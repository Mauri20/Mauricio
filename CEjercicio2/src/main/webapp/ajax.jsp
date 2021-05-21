<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<head>
<meta charset="ISO-8859-1">
<title>Ajax</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
</head>
<body>
<div class="container mt-5">
	<div class="row">
		<div class="col-4 offset-4">
			<div class="row justify-content-center">
				<input type="text" class="form-control" id="caja" name="caja">
				<button type="button" id="btn" class="btn btn-primary mt-3" data-bs-toggle="modal" data-bs-target="#exampleModal">Enviar</button>
			</div>
		</div>
	</div>	
</div>
<script type="text/javascript">
	$(document).ready(function (){
		
		$("#btn").click(function (){
			
			var box = $("#caja").val();
			
			$.post('ControllerAjax',{
			//Esta seccion es para enviar peticiones al servidor
				box
			}, function (response){
				//Esta seccion es para recibir informacion
				console.log(response);
				
				var modificar=document.getElementById("mod");
				
				modificar.innerHTML=response;
				
			});
		});
	});
</script>	
	
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        <h3 id="mod"></h3>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary">Save changes</button>
	      </div>
	    </div>
	  </div>
	</div>
</body>
</html>