<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="DisplayPhoto.jsp">
		ID: <input type="text" name="id"> <br><br>
		<input type="submit" value="Submit"> <br><br>
	</form>
	
	<%
		String id = request.getParameter("id");
	%>
	<%
		if(id != null)
		{
	%>
		<img src="getimage?id=<%= id %>" style="height:600px; width: 1500px">
	<%
		}
	%>
	
</body>
</html>