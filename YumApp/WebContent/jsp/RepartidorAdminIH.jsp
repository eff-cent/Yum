<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang = "es">
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">	
		
		<!-- Style CSS para lo demás -->
	   	<link rel="stylesheet" type="text/css" href="../CSS/style.css">
	   	
	   	<!-- Style CSS Bootstrap -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<title>Mostrar repartidores</title>
	
		<!-- Icono del título de la página -->
        <img src = "/Icons/admin-icon.svg" />
	
	</head>

	<body>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
	
 
  
		<nav class="navbar navbar-expand-lg navbar-dark" id="top-bar">
			<div class="navbar-brand">
				<img src="../Icons/admin.svg" width="40" height="40" class="" alt="">
  				<a class="navbar-brand text-white">Administración Yum</a>
			</div>
  			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		    <div class="navbar-nav">
		      <a class="nav-item nav-link" href="#">Alimentos</a>
		      <a class="nav-item nav-link" href="#">Órdenes</a>
		      <a class="nav-item nav-link" href="#">Menú</a>
		      <a class="nav-item nav-link" href="#" id="nav-select">Repartidores</a>
		    </div>
		  </div>
				<div class="navbar-brand" id="cerrar-sesion">
					<a class="nav-item" href="#">Cerrar Sesión</a>
					<img src="../Icons/cerrar-sesion.svg" width="40" height="40" class="ml-3" alt="">
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="	#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="	Toggle navigation">
  					<span class="navbar-toggler-icon"></span>
  					</button>
  				</div>
		</nav>
		
		<h1 class="display-4 text-center" >Mostrar Repartidores</h1>
  		<p> Muestra todos los repartidores </p>
	
	
		<div class="container py-2 min-vw-50">
				
				<div class="row py-1 justify-content-center" id="menu-CRUD">
					<div class="col-">
						<img src="../Icons/editar.svg" width="30" height="30" class="ml-3" alt="">
						<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">Editar</button>
					</div>
					
					<div class="col-">
						<img src="../Icons/anadir.svg" width="30" height="30" class="ml-3" alt="">
						<a class = "btn btn-primary" href="modificadorRepartidor?action=registrarRepartidor">Registrar nuevo Repartidor</a>
					</div>
				</div>
			</div>
		<table class="table w-50 mx-auto table-striped table-bordered">
		 <thead class="thead-dark">
		<tr>
			
		  <th class="text-center" scope = "col" > Nombre</th>
		<th  class="text-center" scope = "col" >Apellido Paterno</th>
		 <th  class="text-center" scope = "col" >Apellido Materno</th>
		 <th  class="text-center" scope = "col" >Correo electrónico</th>
		 <th class="text-center" scope = "col"> editar </th>
		 
		</tr>
		</thead>
		<tbody>
		<c:forEach var="repartidor" items="${lista}">
				<td><c:out value="${repartidor.nombre}"/></td>
				<td><c:out value="${repartidor.apellidoPaterno}"/></td>
				<td><c:out value="${repartidor.apellidoMaterno}"/></td>
				<td><c:out value="${repartidor.correoElectronico}"/></td>
				<td><a class = "btn btn-primary" href="modificadorRepartidor?action=showedit&idPersona=<c:out value="${repartidor.idPersona}" />">Editar</a></td>
				
			</tr>
		</c:forEach>s
		</tbody>
	</table>
	
	 <!-- Optional JavaScript -->
	    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
	    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>
