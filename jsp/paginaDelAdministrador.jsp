<%
    if ((session.getAttribute("correoElectronico") == null) || (session.getAttribute("correoElectronico") == "")) {
%>
No se ha podido iniciar sesi�n<br/>
<a href="login.jsp">Por favor inicia sesi�n</a>
<%} else {
%>
Bienvenido a la pagina de administrador   <%=session.getAttribute("userid")%>
<a href='crudMenu.jsp'>CRUD Men�</a>
<a href='CrudRepartidor.jsp'>CRUD Repartidor</a>
<a href='logout.jsp'>Cerrar sesi�n</a>
<%
    }