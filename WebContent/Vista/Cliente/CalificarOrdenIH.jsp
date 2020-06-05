<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
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
	
	<!-- Style CSS para lo demás -->
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/CSS/style.css">
	<style type="text/css">
	.title {
		margin-top: 70px;
	}
	</style>
	<title>Calificar</title>
	<!-- Icono del título de la página -->
	<link rel="icon"
		href="${pageContext.request.contextPath}/Icons/admin-icon.svg"
		type="image/x-icon">
	<script src="https://kit.fontawesome.com/cdcab3bf36.js" crossorigin="anonymous"></script>
	<script data-search-pseudo-elements defer src="https://use.fontawesome.com/releases/latest/js/all.js" integrity="sha384-L469/ELG4Bg9sDQbl0hvjMq8pOcqFgkSpwhwnslzvVVGpDjYJ6wJJyYjvG3u8XW7" crossorigin="anonymous"></script>
	<style type="text/css">
		.icon::before {
  display: inline-block;
  font-style: normal;
  font-variant: normal;
  text-rendering: auto;
  -webkit-font-smoothing: antialiased;
}

.stars-outer {
  display: inline-block;
  position: relative;
  font-family: "Font Awesome 5 Free";
}

.stars-outer::before {
  content: "\f005 \f005 \f005 \f005 \f005";
}

.stars-inner {
  position: absolute;
  top: 0;
  left: 0;
  white-space: nowrap;
  overflow: hidden;
  width : 0;
}

.stars-inner::before {
  content: "\f005 \f005 \f005 \f005 \f005";
  color: #f8ce0b;
}
	</style>
</head>
<body>
	<!-- Barra de navegación -->
	<nav class="navbar navbar-expand-lg navbar-dark"
		style="background-color: #28536B">
		<a class="navbar-brand mr-5" href="#"> <img
			src="${pageContext.request.contextPath}/Icons/bear.svg" width="30"
			height="30" class="d-inline-block align-top mr-2" alt=""> Yum
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#barraNavegacion" aria-controls="barraNavegacion"
			aria-expanded="true" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="barraNavegacion">
			<ul class="navbar-nav mr-auto">
				<li><img
					src="${pageContext.request.contextPath}/Icons/menu.svg" width="30" height="30" 
					class="d-inline-block align-top mr-2" alt="">
				</li>
				<li class="nav-item active">
					<a class="nav-link mr-3" href="#">Menú
						<span class="sr-only">(current)</span>
					</a>
				</li>
				<li><img
					src="${pageContext.request.contextPath}/Icons/orden.svg" width="30" height="30" 
					class="d-inline-block align-top mr-2" alt="">
				</li>
				<li class="nav-item"><a class="nav-link mr-3" href="#">Órdenes</a>
				</li>
				<li><img
					src="${pageContext.request.contextPath}/Icons/carro.svg" width="30" height="30"
					class="d-inline-block align-top mr-2" alt=""></li>
				<li class="nav-item mr-3"><a class="nav-link" href="#">Carrito</a>
				</li>
				<li><img
					src="${pageContext.request.contextPath}/Icons/orden.svg" width="30" height="40" 
					class="d-inline-block align-top mr-2" alt=""></li>
				<li class="nav-item"><a class="nav-link" href="modificadorCliente?action=mostrarEditarCliente">Cuenta</a></li>
			</ul>
			<span class="navbar-text"> 
				<img
				src="${pageContext.request.contextPath}/Icons/cerrar-sesion.svg" width="30" height="30"
				 class="d-inline-block align-top mr-2"
				alt="cerrar sesión"> 
				<a href="logout?">Cerrar Sesión</a>
			</span>
		</div>
	</nav>

	<div class="container">
		<h1 class="text-center title">Califica tus órdenes :</h1>
	</div>
	
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope = "col"> Orden</th>
				<th scope = "col"> Calificación</th>
				<th scope = "col"> <i class="far fa-star"></i></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="row">1</th>
				<td>
					<form action= "modificadorCliente?action=calificar&id=1" method="post" class="form-inline">
						<select class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref" name="calificacion">
						    <option selected>Califícanos :)</option>
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
						<button class="btn btn-outline-primary" type="submit">Listo!</button>
					</form>
				</td>
				<td>
					<div class="stars-outer">
						<div class="stars-inner">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<th scope="row">2</th>
				<td>
					<form action= "modificadorCliente?action=calificar&id=2" method="post" class="form-inline">
						<select class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref" name="calificacion">
						    <option selected>Califícanos :)</option>
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
						<button class="btn btn-outline-primary" type="submit">Listo!</button>
					</form>
				</td>
				<td>
					<div class="stars-outer">
						<div class="stars-inner">
						</div>
					</div>
				</td>
			</tr>
		</tbody>
	</table>
	
</body>
</html>