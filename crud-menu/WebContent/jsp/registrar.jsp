<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

	<!-- Style CSS para lo demás -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/style.css">
	<style type="text/css">
		.title{
			margin-top: 70px;
		}
	</style>
	<title>Crear</title>
	<!-- Icono del título de la página -->
    <link rel = "icon" href = "${pageContext.request.contextPath}/Icons/admin-icon.svg" type = "image/x-icon"> 
</head>
<body>

	
	<!-- Barra de navegación -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="top-bar">
			<div class="navbar-brand">
				<img src="${pageContext.request.contextPath}/Icons/admin.svg" width="40" height="40" class="" alt="">
  				<a class="navbar-brand text-white">Administración Yum</a>
			</div>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			    <div class="navbar-nav">
				      <a class="nav-item nav-link" href="#" id="nav-select">Órdenes</a>
				      <a class="nav-item nav-link" href="adminMenu?action=mostrarMenu">Menú</a>
				      <a class="nav-item nav-link" href="#" >Alimentos</a>
				      <a class="nav-item nav-link" href="#">Repartidores</a>
			      </div>
		      </div>
			<div class="navbar-brand" id="cerrar-sesion">
				<a class="nav-item" href="#">Cerrar Sesión</a>
				<img src="C:/Users/Alma/eclipse-workspace/crud-menu/WebContent/Icons/cerrar-sesion.svg" width="30" height="40" class="ml-3" alt="">
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="	#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="	Toggle navigation">
  				<span class="navbar-toggler-icon"></span>
  				</button>
  			</div>
		</nav>
	
	

	<div class="container">
		<h1 class="text-center title">Crear categoría</h1>
	</div>
	
	<form action="adminMenu?action=agregarCategoria" method="post">
	  <div class="form-group row">
	    <label  class="col-sm-2 col-form-label">ID</label>
	    <div class="col-sm-10">
	       <input type="number" class="form-control" name="id" placeholder="ID">
	    </div>
	  </div>
	  <div class="form-group row">
	    <label  class="col-sm-2 col-form-label">Nombre</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="nombre" placeholder="Nombre">
	    </div>
	  </div>
	  <div class="form-group row">
	  	<input class="col-sm-2 " type="submit" value="Agregar" name="agregar">
		<a class="col-sm-2" href ="adminMenu?action=mostrarMenu">Cancelar</a>
	  </div>
	</form>
	
		<!-- Footer -->
	<footer class="page-footer font-small  pt-1 footer fixed-bottom footer">
		
		  <!-- Footer Elements -->
		
		  <!-- Copyright -->
		  <div class="footer-copyright text-center py-2">2020 Copyright:
		    <a href="#"> 
		  	  Eff;cient organization
		  	  <img class="icon" src="${pageContext.request.contextPath}/Icons/Logo.svg"  class="img-fluid img-thumbnail" alt="Editar" width="40" height="40">
		    </a>
		  </div>
		  <!-- Copyright -->
		
	</footer>
		<!-- Footer -->
</body>
</html>