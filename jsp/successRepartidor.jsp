<%
    if ((session.getAttribute("correoElectronico") == null) || (session.getAttribute("correoElectronico") == "")) {
%>
No se ha podido iniciar sesi�n<br/>
<a href="login.jsp">Por favor inicia sesi�n</a>
<%} else {
%>
Bienvenido a la pagina de repartidores, las ordenes disponibles estar�n lista en un momento   <%=session.getAttribute("userid")%>
<a href='logout.jsp'>Cerrar sesi�n</a>
<%
    }
