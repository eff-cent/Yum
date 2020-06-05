<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<!-- Para calificar -->
	<script src="https://kit.fontawesome.com/cdcab3bf36.js" crossorigin="anonymous"></script>
	<script data-search-pseudo-elements defer src="https://use.fontawesome.com/releases/latest/js/all.js" 
		integrity="sha384-L469/ELG4Bg9sDQbl0hvjMq8pOcqFgkSpwhwnslzvVVGpDjYJ6wJJyYjvG3u8XW7" crossorigin="anonymous"></script>
		
<!-- Style CSS para lo demás -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/style.css">
	
<style type="text/css">
.title {
	margin-top: 70px;
}

.final {
	margin-bottom: 60px;
}
</style>
<meta charset="ISO-8859-1">
<title>Ver Carrito</title>
<!-- Icono del título de la página -->
<link rel="icon"
	href="${pageContext.request.contextPath}/Icons/Logo.svg"
	type="image/x-icon">
</head>
<body>

	<!-- Modal para editar un alimento -->
	<div class="modal fade" id="modalEditar" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLongTitle">Editar Alimento</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <form action="adminAlimento" method="post" enctype="multipart/form-data">
	      <div class="modal-body">
	      	<!-- Formulario para editar la cantidad de la orden -->
	      		<div class="form-group row">
	      			<label for="inputPrecioE" class="col-sm-2 col-form-label">Cantidad</label>
	      			<div class="col-sm-5">
	      			<input type="number" class="form-control" name="cantidad" id="inputCantidad" min="0" max="500" value="0" step="0.01" placeholder="Cantidad" required/>
   					</div>
	      		</div>

	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
	        <input type="submit" class="btn btn-primary" name="editar" value="Guardar cambios" />
	      </div>
	      </form>
	    </div>
	  </div>	  
	</div>
	
	<!-- Modal para eliminar un alimento -->
	<div id="modalEliminaAlimento" class="modal fade">
		<div class="modal-dialog modal-dialog-centered modal-confirm">
			<div class="modal-content">
				<div class="modal-header">		
					<h4 class="modal-title">¿Estás seguro?</h4>	
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				</div>
				<form action="adminAlimento" method="post">
				<div class="modal-body">
					<input type="hidden" class="form-control" name="idAl" id="inputAlimentoDel" placeholder="Id del Alimento" readonly/>
					<p>¿Estás seguro de que deseas borrar este alimento?</p>
				</div>
				<div class="modal-footer">
					<input type="submit" class="btn btn-danger" name="eliminar" value="Borrar Alimento" />
					<button type="button" class="btn btn-info" data-dismiss="modal">Cancelar</button>
				</div>
				</form>
			</div>
		</div>
	</div>
	


	<!-- Barra de navegaci�n -->
	<nav class="navbar navbar-expand-lg navbar-dark"
		style="background-color: #28536B">
		<a class="navbar-brand mr-5" href="#"> <img
			src="${pageContext.request.contextPath}/Icons/bear.svg" width="35"
			height="35" class="d-inline-block align-top mr-2" alt=""> Yum
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#barraNavegacion" aria-controls="barraNavegacion"
			aria-expanded="true" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="barraNavegacion">
			<ul class="navbar-nav mr-auto">
				<li><img
					src="${pageContext.request.contextPath}/Icons/menu.svg" width="30"
					height="30" class="d-inline-block align-top mr-2" alt=""></li>
				<li class="nav-item active"><a class="nav-link mr-3" href="#">Menú
						<span class="sr-only">(current)</span>
				</a></li>
				<li><img
					src="${pageContext.request.contextPath}/Icons/orden.svg" width="30"
					height="30" class="d-inline-block align-top mr-2" alt=""></li>
				<li class="nav-item"><a class="nav-link mr-3" href="#">Órdenes</a>
				</li>
				<li><img
					src="${pageContext.request.contextPath}/Icons/carro.svg" width="30"
					height="30" class="d-inline-block align-top mr-2" alt=""></li>
				<li class="nav-item mr-3"><a class="nav-link" href="modificadorCarrito?action=verCarrito">Carrito</a>
				</li>
				<li><img
					src="${pageContext.request.contextPath}/Icons/orden.svg" width="30"
					height="30" class="d-inline-block align-top mr-2" alt=""></li>
				<li class="nav-item"><a class="nav-link" href="modificadorCliente?action=mostrarEditarCliente">Cuenta</a></li>
			</ul>
			<span class="navbar-text"> <img
				src="${pageContext.request.contextPath}/Icons/cerrar-sesion.svg"
				width="30" height="30" class="d-inline-block align-top mr-2"
				alt="cerrar sesión"> <a href="logout?">Cerrar
					Sesión</a>
			</span>
		</div>
	</nav>

	<div class="container">
		<h1 class="text-center title">Este es tu carrito,
			${cliente.getNombre()}</h1>
	</div>
	
	
	<table border="0" width="60%" align="center">
		
		
		<div class="container">
		<!-- Tabla de alimentos -->	
		<table class="table mx-auto text-center table-striped table-bordered" id="tablaAlimentos">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">Imágen</th>
		      <th scope="col">Nombre</th>
		      <th scope="col">Precio</th>
		      <th scope="col">Cantidad</th>
		      <th colspan=2 scope="col">Acción</th>
		    </tr>
		  </thead>
		  <tbody>
		    <c:forEach var="alimento" items="${lista}">
		    	<tr>
		    		<td> <img class="img-responsive" src="http://localhost:8080/Yum/imagenes/${alimento.path}" alt="${alimento.nombre}" width="100" height="100"> </td>
		    		<td>${alimento.nombre}</td>
		    		<td>${alimento.precio}</td>
		    		<td>
						<form action= "modificadorCarrito?action=editarCarrito&idC=${idCarrito}&alimento=${alimento.getId()}" method="post" class="form-inline">
							<select  id="calificacion" class="custom-select my-1 mr-sm-2"  name="cantidad" >
							    <option selected  ><c:out value="${alimento.cantidad}" /></option>
							    <option value="1">1</option>
							    <option value="2">2</option>
							    <option value="3">3</option>
							    <option value="4">4</option>
							    <option value="5">5</option>
							    <option value="6">6</option>
							    <option value="7">7</option>
							    <option value="8">8</option>
							    <option value="9">9</option>
							    <option value="10">10 </option>
						  </select>
							<button class="btn btn-outline-primary "   type="submit">Listo!</button>
						</form>
					</td>
					<td><a 
					href="modificadorCarrito?action=eliminarDelCarrito&idC=<c:out value="${idCarrito}"/>&alimento=<c:out value="${alimento.getId()}"/>">
								Eliminar <i class="fas fa-trash"></i>
					</a></td>
	    		</tr>
	   		</c:forEach>
	   		<tr>
				<td></td>
				<td align="right">Total: $</td>
				<td> <c:out value="${total}"/> </td>
			</tr>
		  </tbody>
		</table>
	</div>
	
	<input type="button" onClick="" value="Confirmar Orden"> <br>
	
	<!-- Footer -->
	<footer class="page-footer font-small  pt-1 footer fixed-bottom footer">

		<!-- Footer Elements -->

		<!-- Copyright -->
		<div class="footer-copyright text-center py-2">
			2020 Copyright: <a href="#"> Eff;cient organization <img
				class="icon" src="${pageContext.request.contextPath}/Icons/Logo.svg"
				class="img-fluid img-thumbnail" alt="Editar" width="40" height="40">
			</a>
		</div>
		<!-- Copyright -->

	</footer>
	<!-- Footer -->
</body>
</html>
