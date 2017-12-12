<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Success</title>
<jsp:include page="Home.jsp" />
</head>
<center><br><br>
<body bgcolor="#d3d3d3"><br><br><br>
<%
        String email=(String)session.getAttribute("logname");
        
        //redirect user to login page if not logged in
        if(email==null){
            response.sendRedirect("Login.jsp");
        }
        %>

<h1><font color="green">Details Added Successfully</font></h1>
<img src="http://www.freeiconspng.com/uploads/success-icon-10.png" alt="Avatar" width="200px" height="200px"><br><br>
</body>
</center>
</html>