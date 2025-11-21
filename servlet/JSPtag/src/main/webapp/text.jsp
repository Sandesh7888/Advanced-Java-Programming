<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Example</title>
<style type="text/css">
  .table{
  	color:red;
  	border:2px solid black;
  }
  td{
  	border:2px solid black;
  	padding:5px
  }
</style>
</head>
<body>

<h1>Welcome</h1>

<!-- Declaration tag -->
	<%! 
	    int a = 12;
	    public int add() {
	        return a + 11;
	    }
	%>

<!-- Expression tag -->
<h2>Variable value is: <%= a %></h2>
<h2>Add() method returns: <%= add() %></h2>

<!-- Scriptlet tag -->
	<%
	    ArrayList<String> list = new ArrayList<String>();
	    list.add("Hello");
	    list.add("Hi");
	    list.add("Bye");
	    list.add("OK");
	    
	%>

<h3> Values:</h3>
<table class="table">
 <tr>
	<%
	    for(String s : list){
		%>
		       <td><%= s %></td>
		<%
	    }
	%>
	</tr>
</table>

</body>
</html>
