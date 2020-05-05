<%
session.setAttribute("correoElectronico", null);
session.invalidate();
response.sendRedirect("login.jsp");
%>