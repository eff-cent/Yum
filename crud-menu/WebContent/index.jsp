<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>crud-menu</title>
</head>
<body>
	<h1> Here we go again</h1>
	<h2> Selecciona lo que quieres hacer</h2>
	<ul>
		<li><a href ="adminMenu?action=mostrarMenu">Mostrar men�</a> </li>
		<li><a href= "adminCategoria?action=eliminarCategoria">Borrar categor�a</a>
		<li><a href= "adminMenu?action=showEditar">Editar categor�a</a>
		<li><a href= "adminMenu?action=nuevaCategoria">A�adir categor�a</a>
	</ul>
	<form action ="adminMenu?action=buscarPorCategoria" method= "post">
			<input type="text" name="nombre" value="Nombre">
			<input type="submit" name = "buscar" value="buscar">
	</form>
</body>
</html>