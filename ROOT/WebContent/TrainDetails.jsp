<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Train Details</title>
<jsp:include page="Home.jsp" />
<link rel = "stylesheet" type = "text/css" href = "Table.css" />
</head>
<center>
<body bgcolor="#d3d3d3"><br><br><br><center>
<%
        String email=(String)session.getAttribute("logname");
        
        //redirect user to login page if not logged in
        if(email==null){
            response.sendRedirect("Login.jsp");
        }
        %>
<h1>Welcome to the details page of train</h1>
 <table>
<tr>
    <th>Train Number</th>
    <th>Train Name</th>
    <th>Source</th>
    <th>Destination</th>
    <th>Price</th>
    <th>Book</th>
  </tr>
 <tr>
    <td>${object.trainNo}</td>
    <td>${object.trainName}</td>
    <td>${object.source}</td>
    <td>${object.destination}</td>
    <td>${object.ticketPrice}</td>
    <td><input type="button" onclick="location.href='Book.jsp?trainName=${object.trainName}&destination=${object.destination}&source=${object.source}&trainNo=${object.trainNo}&ticketPrice=${object.ticketPrice}';" value="Book"/></td>
 </tr></table>
</center>
</body>
</center>
</html>