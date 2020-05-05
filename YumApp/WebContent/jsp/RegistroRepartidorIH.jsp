<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<!-- Style CSS para lo demás -->
		 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/style.css">	
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Registrar repartidor</title>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
		<link rel="stylesheet"  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/css/bootstrap.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" />
		<script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		
		
		
	</head>

	<body>

		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="top-bar">
			<div class="navbar-brand">
				<img src="${pageContext.request.contextPath}/Icons/admin.svg" width="40" height="40" class="" alt="">
  				<a class="navbar-brand text-white">Administración Yum</a>
			</div>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			    <div class="navbar-nav">
				      <a class="nav-item nav-link" href="#" >Órdenes</a>
				      <a class="nav-item nav-link" href="adminMenu?action=mostrarMenu">Menú</a>
				      <a class="nav-item nav-link" href="#" >Alimentos</a>
				      <a class="nav-item nav-link" href="modificadorRepartidor?action=mostrar" >Repartidores</a>
			      </div>
			</div>
			<div class="navbar-brand" id="cerrar-sesion">
				<a class="nav-item" href="#">Cerrar sesión</a>
				<img src="${pageContext.request.contextPath}/Icons/cerrar-sesion.svg" width="30" height="40" class="ml-3" alt="">
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="	#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="	Toggle navigation">
  				<span class="navbar-toggler-icon"></span>
  				</button>
  			</div>
		</nav>
	
		<div class = "text-center">
			<h1 class="text-center">Registrar Repartidor</h1>
			<p> Se le enviará un correo con su usario y contraseña al repartidor </p>
		</div>
		
		<form action="modificadorRepartidor?action=register" method="post" role="form" data-toggle="validator" novalidate="true"  class="needs-validation"  novalidate  >

			<div class=" text-center form schedule-assessment col-sm-6 col-md-6 col-lg-6 offset-sm-3 offset-md-3 offset-lg-3" >
				<div class=" form-group">
					<label for="nombre"  >Nombre</label>
					<input type="text" class="form-control" name="nombre" id="nombreRepartidor" placeholder="Escribe el/los nombres del repartidor" required>
		  		</div>
			  
	  
				<div class="form-group  ">
	    			<label for="apellidoPaterno">Apellido paterno</label>
	    			<input type="text" class="form-control" name="apellidoPaterno" id="apellidoPaterno" placeholder="Escribe el apellido paterno del repartidor" required="required" data-error="Please enter your full name.">
	  			</div>
				<div class="help-block with-errors"></div>
				<div class="form-group  ">
					<label for="apellidoMaterno">Apellido materno</label>
					<input type="text" class="form-control" name="apellidoMaterno" id="apellidoMaterno" placeholder="Escribe el apellido materno del repartidor" required="required" data-error="Please enter your full name.">
				</div>
			  	<div class="help-block with-errors"></div>
			  	<div class="form-group ">
					<label for="email">Correo electrónico</label>
					<input type="email" class="form-control" name="correoElectronico" id="correoElectronico" placeholder="Escribe el correo electrónico del repartidor" required="required" data-error="Please enter a valid email.">
				</div>
				<div class=" text-center ">
					<button  class="btn btn-primary" type = "submit" name = "agregar" data-toggle="modal"  >Registrar Repartidor</button>
					
				</div>
				<div> 
					<a class = "btn btn-link" href="modificadorRepartidor?action=mostrar">Cancelar</a>
				</div>	
 			</div>
 
	</form>
	
	
	<!-- Footer -->
	<footer class="page-footer font-small  pt-1 footer fixed-bottom">
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

<!-- JavaScript for disabling form submissions if there are invalid fields -->    
    <script>
        // Self-executing function
        (function() {
            'use strict';
            window.addEventListener('load', function() {
                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.getElementsByClassName('needs-validation');
                // Loop over them and prevent submission
                var validation = Array.prototype.filter.call(forms, function(form) {
                    form.addEventListener('submit', function(event) {
                        if (form.checkValidity() === false) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
            }, false);
        })();
    </script>
	</body>
</html>