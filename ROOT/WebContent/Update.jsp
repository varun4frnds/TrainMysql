<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
<jsp:include page="AdminHeadder.jsp" />
</head>
<body>
<%
        String email=(String)session.getAttribute("alogname");
        if(email==null)
        {
        	response.sendRedirect("Login.jsp");
        }
        %>



<h2>Details updated successfully</h2>
</body>
</html>