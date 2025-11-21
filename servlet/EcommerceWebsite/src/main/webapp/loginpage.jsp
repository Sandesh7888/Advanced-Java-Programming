<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 	HttpSession result=request.getSession();
	String msg= "sa";
%>

<%if(msg!=null){ %>

<%} else{
	
}%>

<form action="Login">

		username:<input type="text" name="username"  > <br><br>
		password:<input type="text" name="password"  > <br><br>
		<input type="submit" value="submit" > <br><br>
		
</form>

</body>
</html>