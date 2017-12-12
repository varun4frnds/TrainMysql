<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cancel Ticket</title>
 <jsp:include page="Home.jsp" />
</head>
<br><br><br><br>
<%
        String name=(String)session.getAttribute("logname");
        if(name!=null){
            response.sendRedirect("Admin.jsp");
        }
        else
        	response.sendRedirect("Login.jsp");

%>


<body bgcolor="#d3d3d3">
<form method="Post" action="ViewTicketController">
<center>
<h2>Welcome to Cancel Ticket Page</h2>
<h4>Your Details Are:</h4>
<c:forEach items="${array}" var="train">
<b>${train}</b>
<br><br>
</c:forEach>
<br>
Enter PNR Number:
<input type="text" name="pnrno" placeholder="Ex:tk_2017725_102" required><br><br>
Enter Journey Date:
<input type="text" name="date" placeholder="YYYY/MM/DD" required><br><br>
<input type="submit" name="s1" value="cancelTicket" style="width: 100px; padding: 2px">    <input type="button" onclick="location.href='View Ticket.jsp';" value="Back" style="width: 100px; padding: 2px"/>
</center>
</form>
</body>
</html>