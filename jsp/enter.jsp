<%@ page import="java.sql.*"%>
<%
    String correo = request.getParameter("correoElectronico");    
    String password = request.getParameter("userPassword");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yum_db",
            "root", "bigmama1");
    Statement st = con.createStatement();
    ResultSet rsA, rsU, rsR; 
    rsA = st.executeQuery("select * from Administrador a, Persona p where p.correoElectronico ='" + correo + "' and a.adminPassword='" + password + "'");    
    if (rsA.next()){
        session.setAttribute("userid", correo);
        response.sendRedirect("paginaDelAdministrador.jsp");
    }
    rsU = st.executeQuery("select * from Cliente c, Persona p where p.correoElectronico ='" + correo + "' and c.userPassword='" + password + "'");
    rsR = st.executeQuery("select * from Repartidor r, Persona p where p.correoElectronico ='" + correo + "' and r.repartidorPassword='" + password + "'");
    if (rsU.next()) {
        session.setAttribute("userid", correo);
        response.sendRedirect("success.jsp");
    } else if (rsrR.next()) {
        session.setAttribute("userid", correo);
        response.sendRedirect("successRepartidor.jsp");		
    } else {
        out.println("Contraseña incorrecta <a href='login.jsp'>intenta de nuevo.</a>");	
    }
%>