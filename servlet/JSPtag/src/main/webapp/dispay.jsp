<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Display jsp Execution</h1>

	<%
		ArrayList<String> l =(ArrayList<String>) request.getAttribute("arraylist");
	%>

  
   
   
    <%
   
   	for(String s:l){
   	%>
   		<h1> <%= s %></h1>
   <%
   	}
   %>
   
   <%! public int add(int a,int b){
	   return a+b;
   }
   
   int a;
   
	   
	%>
	
	<h1><%=  add(10,20) %></h1>
   
</body>
</html>