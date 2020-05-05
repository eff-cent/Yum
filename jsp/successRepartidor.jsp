<%
    if ((session.getAttribute("correoElectronico") == null) || (session.getAttribute("correoElectronico") == "")) {
%>
No se ha podido iniciar sesión<br/>
<a href="login.jsp">Por favor inicia sesión</a>
<%} else {
%>
Bienvenido a la pagina de repartidores, las ordenes disponibles estarán lista en un momento   <%=session.getAttribute("userid")%>
<a href='logout.jsp'>Cerrar sesión</a>
<%
    }
