<%
    if ((session.getAttribute("correoElectronico") == null) || (session.getAttribute("correoElectronico") == "")) {
%>
No se ha podido iniciar sesión<br/>
<a href="login.jsp">Por favor inicia sesión</a>
<%} else {
%>
Bienvenido a la pagina de administrador   <%=session.getAttribute("userid")%>
<a href='crudMenu.jsp'>CRUD Menú</a>
<a href='CrudRepartidor.jsp'>CRUD Repartidor</a>
<a href='logout.jsp'>Cerrar sesión</a>
<%
    }