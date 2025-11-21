<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<%
    String msg = (String) request.getAttribute("msg");
    if (msg != null) {
%>
        <p style="color:red; font-weight:bold;"><%= msg %></p>
<%
    }
%>

<form action="Login" method="get">
    Username: <input type="text" name="username"> <br><br>
    Password: <input type="password" name="password"> <br><br>
    <input type="submit" value="Login">
</form>

</body>
</html>
