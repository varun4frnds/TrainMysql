<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" href="train.jpg" type="image/gif" sizes="16x16">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<jsp:include page="Home.jsp" />
</head><br><br><br><br>
<%
 
String name=(String)session.getAttribute("logname");
if(name!=null){
    response.sendRedirect("Welcome.jsp");
}
        
%>
<% String [] alphanum1 ={"1","0","3","5","8","7"};
String [] alphanum2 ={"2","4","1","2","9","0"};
String [] alphanum3 ={"3","2","1","6","6","9"};
String [] alphanum4 ={"4","2","0","3","8","9"};
String [] alphanum5 ={"6","1","4","6","8","7"};

int a =alphanum1.length;
int b =alphanum2.length;
int c =alphanum3.length;
int d =alphanum4.length;
int e =alphanum5.length;

int rgen1 =(int)(Math.random()* a);
int rgen2 =(int)(Math.random()* b);
int rgen3 =(int)(Math.random()* c);
int rgen4 =(int)(Math.random()* d);
int rgen5 =(int)(Math.random()* e);

String captcha = alphanum1[rgen1]+""+ alphanum2[rgen2]+""+ alphanum3[rgen3]+ ""+ alphanum4[rgen4]+""+ alphanum5[rgen5];
request.setAttribute("captcha", captcha);
%>


<body bgcolor="#E9E9E9" >
<center>
<img alt="Train" src="train.jpg" width="200" height="150" oncontextmenu="return false" onkeydown="return false;" onmousedown="return false;"><br><br>
<form method="post" action="RegistrationController" >
<table cellspacing="20px">
            <tr>
                <td class="f1_label">Login Name :</td><td><input type="text" name="LoginName" title="enter characters only" maxlength="8" pattern="[A-z]+" required/>
                </td>
            </tr>
            <tr>
                <td>Password  :</td><td><input type="password" name="pwd" title="enter password"  required/>
                </td>
            </tr>
            <span style="color:red">${error}</span>
            <tr>
                <td>Captcha	:</td><td align="center" bgcolor="#9FA99F"><font size="5" oncontextmenu="return false" onkeydown="return false;" onmousedown="return false;">${captcha}</font></td><td><font size="5"><a href="Login.jsp">&#10227;</a></td></font>
            </tr>
            <tr>
                <td>Enter Captcha :</td><td><input type="text" name="ucaptcha" title="enter Captcha" /></td>
            </tr>
            <span style="color:red">${errorr}</span>
        </table>
<input type="submit" name="s1" value="SubmitLogin" />  <button onclick="location.href='RegistrationForm.jsp'" name="reg" type="button">Registration</button><br><br>
<input type="reset" name="reset" value="Reset"/>

<input type="hidden" name="hidden" value="<%=captcha%>" >
</form>
</center>
</body>
</html>