<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Tasks</title>
</head>
<body>

<jsp:include page="header.jsp"/>


<h2>${agenda.name}</h2>
<hr>

<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Category</th>
			<th>Deadline</th>
			<th>Status</th>
		</tr>
		<c:forEach var="task" items="${taskList}">
			<tr>
				<td>${task.id}</td>
				<td>${task.name}</td>
				<td>${task.category}</td>
				<td>${task.deadline}</td>
				<c:if test="${task.done}">
					<td>Done</td>
				</c:if>
				<c:if test="${task.done == false}">
					<td>Undone</td>
				</c:if>
				<td><a href="edit?task_id=${task.id}">Edit</a></td>
				<td><a href="delete?task_id=${task.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>