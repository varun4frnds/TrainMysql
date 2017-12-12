<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Details</title>
<link rel="stylesheet" type="text/css" href="MyStyle.css">
 <jsp:include page="Home.jsp" />
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
<center><pre>
<h2>Please Enter Your Card Details </h2>
<form action="Card" method="post">
Enter Card Number:<br>	
<input type="text" name="cno" pattern="[0-9]{16}" title="16 digit card number" placeholder="Ex:5890123478656287"><br><br>
Enter Expiry Month/Year:<br>
<span style="color: red"> ${error5}</span>
<input type="text" name="date"  placeholder="MM/YYYY" title="must enter valid date" pattern="(0[1-9]|10|11|12)/20[0-9]{2}"><br><br>
Enter CVV:<br>
<input type="text" name="cvv" pattern="[0-9]{3}" title="please enter valid 3 digit cvv" placeholder="Ex:123"><br><br>	
Email id:<br>   
<input type="text" name="email" title="Email id should be valid"  title="ticket will be sent to this email" placeholder="enter valid emailid"><br><br>
<input type="submit" name="s1" value="csubmit" />
</form></pre>
</center>
</body>
</html>