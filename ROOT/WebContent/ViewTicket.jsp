<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ticket Details</title>
 <jsp:include page="Home.jsp" />
 <link rel = "stylesheet"
   type = "text/css"
   href = "Table.css" />
</head>
<body bgcolor="#d3d3d3"><br><br><br>
<%
        String email=(String)session.getAttribute("logname");
        
        //redirect user to login page if not logged in
        if(email==null){
            response.sendRedirect("Login.jsp");
        }
        %>

<form method="Post" action="ViewTicketController">
<center>
<h1>Welcome to Ticket Details Page</h1>

 <input type="submit" name="s1" value="view" class="button"/>
 <input type="submit" name="s1" value="cancel" class="button"/>
</center>
</form>
</body>
</html>