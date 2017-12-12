<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Confirmation</title>
<jsp:include page="Home.jsp" />
      <br><br><br>
<link rel = "stylesheet" type = "text/css" href = "Table.css" />
</head>

<body bgcolor="#d3d3d3">
<%
        String email=(String)session.getAttribute("logname");
        
        //redirect user to login page if not logged in
        if(email==null){
            response.sendRedirect("Login.jsp");
        }
        %>

<center>
<h4>
<form action="TrainController" >
<jsp:useBean id="Train" class="web.com.ibm.bean.Train" scope="session" />
<table>
<tr>
    <th>Train Number</th>
    <th>Train Name</th>
    <th>Source</th>
    <th>Destination</th>
    <th>Price</th>
    <th><center>Travel Date</center></th>
  </tr>
  <tr>
    <td><%= Train.getTrainNo()%></td>
    <td><%= Train.getTrainName()%></td>
    <td><%= Train.getSource()%></td>
    <td><%= Train.getDestination()%></td>
    <td><%= Train.getTicketPrice()%></td>
    <td><%=session.getAttribute("tdate") %></td>
    </tr>
</table>
<br><br>
<% double price=Train.getTicketPrice();
String source=Train.getSource();
String destination=Train.getDestination();
int trainNo=Train.getTrainNo();
String trainName=Train.getTrainName();


session.setAttribute("trainName", trainName);
session.setAttribute("trainNo",trainNo);
session.setAttribute("source", source);
session.setAttribute("destination", destination);
session.setAttribute("tprice",price);
%>

<c:forEach var="i" begin="1" end="${no}">

Name:  <input type="text" name="name" pattern="[A-z]+"/>
Age:   <input type="age" name="age" pattern="[0-9]{2}" required/>
Gender:<input type="gender" name="gender" pattern="^m$|^M$|^f$|^F$"/>   <br><br>     

</c:forEach>
<input type="submit" name="s1" value="psubmit"/>
 </form>
 </h4>
 </center>
</body>
</html>