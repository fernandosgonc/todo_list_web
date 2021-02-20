<%@page import="todo_list_web.model.Task"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tasks</title>
</head>
<body>

	<header>
		<h2>Your tasks are</h2>
	</header>


	<main>
		<ul>
<%List<Task> list = (List<Task> ) session.getAttribute("tasks"); 

for(Task t: list){
	%>
		<li>
		<%out.print(t); %>
		</li>
	<%
}
%>
		</ul>
	<hr><a href="signout.jsp">Sign out</a>
	</main>

</body>
</html>