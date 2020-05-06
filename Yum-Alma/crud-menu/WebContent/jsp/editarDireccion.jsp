<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

	<!-- Style CSS para lo dem�s -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/style.css">
	<style type="text/css">
		.title{
			margin-top: 70px;
		}
		.final{
			margin-bottom: 60px;
		}
	</style>
	<title>Editar</title>
	<!-- Icono del t�tulo de la p�gina -->
    <link rel = "icon" href = "${pageContext.request.contextPath}/Icons/Logo.svg" type = "image/x-icon">
</head>
<body>
	<div class="container">
			<h1 class="text-center title">Editar direcci�n</h1>
	</div>
	<div class="container final">
		<div class="row">
			<div class= "col-sm-8 col-md-8 col-lg-8  offset-sm-2 offset-md-2 offset-lg-2">
				<form action="modificadorCliente?action=editarDireccion&idDireccion=<c:out value='${direccion.getIdDireccion()}'/>"  method="post"> 
					<table class="table w-55  lg-8">
						<tr>
							<td>Delegaci�n</td>
							<td>Colonia</td>
							<td>Calle</td>
						</tr>
						<tr>
							<td>
								<input type="text" name="delegacion"  class="form-control" placeholder="Delegaci�n" value = "<c:out value="${direccion.getDelegacion()}"></c:out>" required >
							</td>
							<td>
								<input type="text" name="colonia" class="form-control" placeholder="Colonia"  value = "<c:out value="${direccion.getColonia()}"></c:out>" required >
							</td>
							<td>
								<input type="text" name="calle" class="form-control" placeholder="Calle" value = "<c:out value="${direccion.getCalle()}"></c:out>" required>
							</td>
						</tr>
						<tr>
							<td>N�mero interior</td>
							<td>N�mero exterior</td>
						</tr>
						<tr>
							<td>
								<input type="number" name="numInt" class="form-control" placeholder="N�mero interior" value = "<c:out value="${direccion.getNumInterior()}"></c:out>" > 
							</td>
							<td>
								<input type="number" name="numExt" class="form-control"  placeholder="N�mero exterior" value = "<c:out value="${direccion.getNumExterior()}"></c:out>" >
							</td>
						</tr>
			
						<tr>
							<td><input type="submit" name="submit" value="Guardar"></td>
							<td></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	

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