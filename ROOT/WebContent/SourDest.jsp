<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show all Trains</title>
<jsp:include page="Home.jsp" />
<link rel = "stylesheet" type = "text/css" href = "Table.css" />

</head>
<body bgcolor="#d3d3d3"><br><br><Br><br>
<%
        String ss=(String)session.getAttribute("logname");
        
        //redirect user to login page if not logged in
        if(ss==null){
            response.sendRedirect("Login.jsp");
        }
%>

<form method="post" action="Book.jsp">
<input type="hidden" id="start" value="${train.source}"/>
<input type="hidden" id="end" value="${train.destination}"/>
<center>
<table>
<tr>
    <th>Train Number</th>
    <th>Train Name</th>
    <th>Source</th>
    <th>Destination</th>
    <th>Price</th>
    <th>Book Ticket</th>
  </tr>
<c:forEach items="${train2}" var="train">
  <tr>
    <td>${train.trainNo}</td>
    <td>${train.trainName}</td>
    <td>${train.source}</td>
    <td>${train.destination}</td>
    <td>${train.ticketPrice}</td>
    <td><input type="button" name="sourdest" onclick="location.href='Book.jsp?trainName=${train.trainName}&destination=${train.destination}&source=${train.source}&trainNo=${train.trainNo}&ticketPrice=${train.ticketPrice}';" value="Book"/></td>
  </tr>
</c:forEach>
</table>
<br><br>
</center>
</form>
</body>
</html>