<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.TreeMap"%>
<%@page import="java.util.Set"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <script type="text/javascript">
        
        function closeSelf(){
               alert("Ticket is Downloaded to default Directory");
               document.forms['certform'].submit();
               
            } 
        
        
        </script>

<center>
<h1><font color="green">Ticket Booked Successfully</font></h1>

<form action="Card" method="post" ><!-- name="certform" -->
<jsp:useBean id="Train" class="web.com.ibm.bean.Train" scope="session"/>
<% String date=session.getAttribute("tdate").toString(); %><br>

<table>
<tr>
	<th>PNR Number</th>
    <th>Train Number</th>
    <th>Train Name</th>
    <th>Source</th>
    <th>Destination</th>
    <th>Travel Date</th>
  </tr>
  <tr>
  <td><%=session.getAttribute("mypnr") %></td>
    <td><%= Train.getTrainNo()%></td>
    <td><%= Train.getTrainName()%></td>
    <td><%= Train.getSource()%></td>
    <td><%= Train.getDestination()%></td>
    <td>${tdate}</td>
    </tr>
</table><br>

<table>
<tr>
<th>Name</th>
<th>Age</th>
<th>Gender</th>
<th>Price</th>
</tr>

<c:forEach items="${passenger}" var="entry">
    	<c:set var="total" value="${total + entry.value}" />
<tr>
<td>${entry.key.name}</td>
<td>${entry.key.age}</td>
<td>${entry.key.gender}</td>
<td>${entry.value}</td>
</tr>
</c:forEach>
 <c:set var="total" value="${total}"/> 
 <% 
 double total=(double)pageContext.getAttribute("total");
session.setAttribute("totalprice",total);
%>
</table>
 <br>
<b>Total fare:       ${total}</b> <br><br>
<!-- <input type="submit" value="Download" name="s1"  /> -->
<input type="submit" value="Download"  name="s1" "/><!-- onclick="closeSelf(); -->
 </form>

 </center>
</body>
</html>