<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>
</head>
<body>
	<form method="post" action="enter.jsp">
		<table 
			style="background-color: skyblue; margin-left: 20px;margin-left: 20px;">
			<tr>
				<td><h3 style="color: black;">Ingresa los datos </h3></td>
			</tr>
		
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre"></td>
			</tr>
			
			<tr>
				<td>Apellido Paterno:</td>
				<td><input type="text" name="apellidoPaterno"></td>
			</tr>
			
			<tr>
				<td>Apellido Materno:</td>
				<td><input type="text" name="apellidoMaterno"></td>
			</tr>
						
			<tr>
				<td>Correo electronico:</td>
				<td><input type="text" name="correoElectronico"></td>
			</tr>
			
			<tr>
				<td>Contraseña:</td>
				<td><input type="password" name="userPassword"></td>
			</tr>
			
			<tr>
				<td>Telefono:</td>
				<td><input type="text" name="telefono"></td>
			</tr>
			
			<tr>
				<td>Dirección:</td>
				<td><input type="text" name="dirección"></td>
			</tr>
			
                    <tr>                    
                        <td><input type="submit" value="Confirmar" /></td>
                        <td><input type="reset" value="Borrar" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">¿Ya estás registrado? <a href="login.jsp">Ingresa aquí</a></td>
                    </tr>
						
		</table>
	</form>
</body>
</html>