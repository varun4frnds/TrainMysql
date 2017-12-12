<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.io.File" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cancel Ticket</title>
 <jsp:include page="Home.jsp" />
</head><br><br><br><br><br><br>
<body  bgcolor="#d3d3d3">
<%
        String name1=(String)session.getAttribute("logname");
        if(name1!=null){
            response.sendRedirect("Admin.jsp");
        }
        else
        	response.sendRedirect("Login.jsp");

%>

<center>
<%

String pnrno =request.getParameter("pnr");
String name = pnrno+".txt";

String path ="C:/Users/Admin/Downloads/";
String s1=path+name;
File file = new File(s1);


if(file.exists())
{
	file.delete();
	out.println("Ticket cancelled");
	
}
else
{
	out.println("File not found");
}

%>

</center>
</body>
</html>