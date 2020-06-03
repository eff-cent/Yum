<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmar Compra</title>
</head>
<body>
<h1 align="center">Tu Pedido</h1>

<table border="0"  width="40%" align="center">
    
	<td align="center">Platillo(s)</td>
	<td align="center">Precio</td>
    

	<c:forEach var="platillo" items="${platillos} ">
	<tr>
	<td>
        Descripcion:
        <c:out value="${platillo.descripcion}"/> 
        
        </td>
    <td>precio<c:out value="${platillo.precio}"/></td>
	</tr>
	</c:forEach>
	<tr>
		<td></td>
		<td>
            Total: 
        </td>
	</tr>    
</table>
    
    <h1 align="center">Direccion</h1>
    
<table border="1" align="center" width="40%">
    
    <td>
        
        <c:foreach var="direccion" items="${pedidos}">
            Calle: <c:out value="${direccion.calle}"/>
            <br>
            Numero: <c:out value="${direccion.numero}"/>
            <br>
            Ciudad: <c:out value="${direccion.municipio}"/>
            <br>
            Destinatario: <c:out value="${direccion.destinatario}"/> 
            <br>
        </c:foreach>
    </td>
    <tr>
    <tr></tr>
    <tr></tr>
    <tr>
    <td align="center">
        <input type="button" id="cambiar" value="Cambiar direccion"/>    
        <input type="button" id="confirmar" value="Confirmar compra"/>
    </td>
        
        </tr>
    </table>
	
</body>
</html>