<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Ticket</title>
 <jsp:include page="Home.jsp" />
<link rel = "stylesheet" type = "text/css" href = "Table.css" />
</head>
<body bgcolor="#d3d3d3"><br><br><br><br>
<%
        String email=(String)session.getAttribute("logname");
        
        //redirect user to login page if not logged in
        if(email==null){
            response.sendRedirect("Login.jsp");
        }
        %>

<center>
<h3>Your Train Details Are</h3><br>

<table>
<tr>
    <th>Train Number</th>
    <th>Train Name</th>
    <th>Source</th>
    <th>Destination</th>
    <th>Price</th>
  </tr>
  <tr>
    <td>${param.trainNo}</td>
    <td>${param.trainName}</td>
    <td>${param.source}</td>
    <td>${param.destination}</td>
    <td>${param.ticketPrice}</td>
    </tr>
  </table>
<%-- <h2>                                       
Train no is:        ${param.trainNo}<br><br>
Train name is:      ${param.trainName}<br><br>
Source is: 	        ${param.source}<br><br>
Destination is :    ${param.destination}<br><br>
Price is:           ${param.ticketPrice}<br><br>
</h2> --%>
<jsp:useBean id="Train" class="web.com.ibm.bean.Train" scope="session"/>
<jsp:setProperty name="Train" property="source" value="${param.source}" />   
<jsp:setProperty name="Train" property="destination" value="${param.destination}" />
<jsp:setProperty name="Train" property="trainName" value="${param.trainName}" />
<jsp:setProperty name="Train" property="trainNo" value="${param.trainNo}" />
<jsp:setProperty name="Train" property="ticketPrice" value="${param.ticketPrice}" /> 
<form method="post" action="TrainController">
<h3>
<pre>

Number of passengers: <input type="text" name="PassNo" placeholder="No.of passengers" required> <h5><span style="color:red">${error3}</span></h5>
Date               : <input type="text" name="date" placeholder="dd/MM/yyyy" title="Wrong Format" pattern="^(0[1-9]|[12][0-9]|3[01])[/.](0[1-9]|1[012])[/.](19|20)\d\d$" required>
                      <span style="color:red">${error4}</span></pre>
                      <input type="submit" name="s1" value="PassVerify" /><br>
                   
</h3>
</form>
</center>
</body>
</html>
