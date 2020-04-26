<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar repartidor</title>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<link rel="stylesheet"  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" />


<!-- Style CSS para lo demás -->
	   	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/style.css">
	 
	
		<!-- Icono del título de la página -->
        <img src = "${pageContext.request.contextPath}/Icons/admin-icon.svg" />
</head>

	<body>
		<nav class="navbar navbar-expand-lg navbar-dark" id="top-bar">
			<div class="navbar-brand">
				<img src="${pageContext.request.contextPath}/Icons/admin.svg" width="40" height="40" class="" alt="">
  				<a class="navbar-brand text-white">Administración Yum</a>
			</div>
  			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		    <div class="navbar-nav">
		      <a class="nav-item nav-link" href="#">Alimentos</a>
		      <a class="nav-item nav-link" href="#">Órdenes</a>
		      <a class="nav-item nav-link" href="#">Menú</a>
		      <a class="nav-item nav-link" href="#" id="nav-select"s>Repartidores</a>
		    </div>
		  </div>
				<div class="navbar-brand" id="cerrar-sesion">
					<a class="nav-item" href="#">Cerrar Sesión</a>
					<img src="${pageContext.request.contextPath}/Icons/cerrar-sesion.svg" width="40" height="40" class="ml-3" alt="">
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="	#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="	Toggle navigation">
  					<span class="navbar-toggler-icon"></span>
  					</button>
  				</div>
		</nav>

		<h1 class="text-center">Editar Repartidor</h1>
		
		
  </div>

	
	<form action="modificadorRepartidor?action=editar" method="post" >

		<div class = "form-group ">
			<label for = "nombre">Nombre</label>
			<input type="text" class="form-control"  id = "nombre" name="nombre" value="${repartidor.nombre}" >
		</div>
			
		<div class = "form-group">
			<label for = "apellidoPaterno">Apellido Paterno</label>
			<input type="text" class="form-control" name="apellidoPaterno" id="apellidoPaterno" value="${repartidor.apellidoPaterno}" >
		</div>		
				
		<div class = "form-group">
			<label for = "apellidoMaterno" >Apellido Materno</label>
			<input type="text" class="form-control" id = "apellidoMaterno" name="apellidoMaterno" value="${repartidor.apellidoMaterno}">
		</div>
		
		<div class = "form-group">
				<label>Correo electrónico</label>
				<input type="text" class="form-control " name="correoElectronico" value="${repartidor.correoElectronico}" >
			</div>
		
	
		<input id=idPersona name="idPersona" type = "hidden" value="${repartidor.idPersona}">

			<div class = "text-center">
			<button type="submit"  name = "registrar" class="btn btn-primary">Guardar</button>
			</div>
			<div class = "text-right">
				
			</div>
			
	</form>
		
		
	</body>

</html>