<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Train</title>
</head>
 <jsp:include page="AdminHeadder.jsp" />
 <body bgcolor="#d3d3d3"><br><br><br>
 <%
        String email=(String)session.getAttribute("alogname");
        if(email==null)
        {
        	response.sendRedirect("Login.jsp");
        }
        %>

 
 
 <br><br>
 <center>
<form action="TrainController" method="post">
Enter Train Number:<br>	<br>
<input type="text" name="tno" placeholder="Ex:1001" required><br><br>
<input type="submit" name="s1" value="deletet" />
</form>
</center>
</body>
</html>