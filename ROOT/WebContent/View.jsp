<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="web.com.ibm.controller.Card" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Details</title>
<jsp:include page="Home.jsp" />

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
<h3>Welcome to View Ticket Details</h3>
PNR No and Date of Journey
<c:forEach items="${array}" var="train">
<br><br>
${train}
</c:forEach>
<br><br>
Enter PNR Number:
<input type="text" name="pnrno" placeholder="tk_2017725_102"><br><br>

<input type="submit" name="s1" value="viewTicket" style="width: 100px; padding: 2px">       <input type="button" onclick="location.href='View Ticket.jsp';" value="Back" style="width: 100px; padding: 2px"/>
</center>
</form>
</body>
</html>