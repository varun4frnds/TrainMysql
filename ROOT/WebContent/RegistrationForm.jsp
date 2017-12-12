<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
<jsp:include page="Home.jsp"></jsp:include><br>
</head>
<%
 String message="";
if(request.getAttribute("message")!=null)
{
	message=request.getAttribute("message").toString();
}
%>

<body bgcolor="#d3d3d3"><br><br>
<h1 style="text-align:center"> Registration Form </h1>
<%-- <center><span style="color:red">${error}</span></center> --%>
<form method="post" action="Registration">
<table border="0" align="center" cellpadding="20px" >
<tr>
<td>User Name:</td>
<td><input type="text" name="username" required title="UserName Should be in Small Letters" pattern="[A-z]+"/></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="text" name="password" required title="Password should not contain numbers and characters" maxlength="8"/></td> 
</tr>
<tr>
<td>EmailId:</td>
<td><input type="text" name="emailid" required title="Email id should be valid" pattern="[a-zA-Z0-9]{3,}@[a-zA-Z]{5,}.com"/></td> 
</tr>
<tr>
<td><input type="submit" name="s1" value="SubmitRegister" /></td>
<td><center><input type="reset" name="s1" value="Reset"/></center></td>
</tr>
</table>
</form>
</body>
</html>