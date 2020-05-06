<%
session.setAttribute("correoElectronico", null);
session.invalidate();
response.sendRedirect("/jsp/login.jsp");
%>