<%
    if ((session.getAttribute("correoElectronico") == null) || (session.getAttribute("correoElectronico") == "")) {
%>
No se ha podido iniciar sesión<br/>
<a href="index.jsp">Por favor inicia sesión</a>
<%} else {
%>
Bienvenido <%=session.getAttribute("userid")%>
<a href='logout.jsp'>Cerrar sesión</a>
<%
    }
%>