<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Train</title>
<jsp:include page="AdminHeadder.jsp" />
</head>
<body bgcolor="#d3d3d3"><br><br><br>
<%
        String email=(String)session.getAttribute("alogname");
        if(email==null)
        {
        	response.sendRedirect("Login.jsp");
        }
        %>



<center>
<pre>
<form action="TrainController" method="post">
<span><h4>${success}</h4></span>
Enter Train Number:<br>	
<input type="text" name="tno"><br><br>
Enter Train Name:<br>
<input type="text" name="tname"><br><br>
Enter Source:<br>
<input type="text" name="source"><br><br>
Enter Destination:<br>
<input type="text" name="destination"><br><br>
Enter Ticket Price:<br>
<input type="text" name="price"><br><br>
<input type="submit" name="s1" value="asubmit" />
</form></pre>
</center>
</body>
</html>