<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio de Sesi�n</title>
</head>
<body>
<form method="post" action="enter.jsp">
<table style="background-color: skyblue; margin-left: 20px;margin-left: 20px;">
<tr>
<td><h3 style="color: black;">Inicio de sesi�n Yum </h3></td>
</tr>

<tr><td>Correo electronico:</td><td><input type="text" name="nombre"></td></tr>
<tr><td>Contrase�a:</td><td><input type="password" name="userPassword"></td></tr>
<tr><td><input type="submit" value="Ingresar"></td>
<td><a href="register.jsp">Registrate aqu�</a></td></tr>
</table>
</form>
</body>
</html>