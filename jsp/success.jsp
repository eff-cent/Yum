<%
    if ((session.getAttribute("correoElectronico") == null) || (session.getAttribute("correoElectronico") == "")) {
%>
No se ha podido iniciar sesi�n<br/>
<a href="index.jsp">Por favor inicia sesi�n</a>
<%} else {
%>
Bienvenido <%=session.getAttribute("userid")%>
<a href='logout.jsp'>Cerrar sesi�n</a>
<%
    }
%>