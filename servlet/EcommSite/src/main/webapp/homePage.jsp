<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	HttpSession session2 = request.getSession();
	String userName = (String)session2.getAttribute("userName");
	String password = (String)session2.getAttribute("password");
%>

<%
	if(userName!= null && password!= null)
	{
%>

<h1>Login Successfully..!</h1>

<form action="logout">
	<input type="submit" value="LogOut">
</form>

<%
	}
	else
	{
%>

<h2>UserName and password not found..!</h2>

<%
	}
%>

</body>
</html>