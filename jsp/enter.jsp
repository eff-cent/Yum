<%@ page import="java.sql.*"%>
<%
    String correo = request.getParameter("correoElectronico");    
    String password = request.getParameter("userPassword");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yum_db",
            "root", "bigmama1");
    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from Cliente c, Persona p where p.correoElectronico ='" + correo + "' and c.userPassword='" + password + "'");
    if (rs.next()) {
        session.setAttribute("userid", correo);
        response.sendRedirect("success.jsp");
    } else {
        out.println("Contraseña incorrecta <a href='login.jsp'>intenta de nuevo.</a>");
    }
%>