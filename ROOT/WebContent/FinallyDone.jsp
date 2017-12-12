<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ticket Print Success</title>
<jsp:include page="Home.jsp" />
      <br><br><br>
</head>
<body bgcolor="#d3d3d3">
<%
        String email=(String)session.getAttribute("logname");
        
        //redirect user to login page if not logged in
        if(email==null){
            response.sendRedirect("Login.jsp");
        }
        %>

<br><br><br><br>
<center>
<h2>Thanks you for choosing us</h2>
<h3>Ticket is downloaded to your default directory</h3>
<h3>Happy Booking</h3>
</center>
</body>
</html>