<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TASKS</title>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<h2>Hey ${sessionScope.loggedUser.name}, those are your tasks</h2>

<button onclick="document.getElementById('createForm').style.display = 'block' ">Create</button> <br>

<form id="createForm" action="addTask" style="display: none" method="post">
<input type="text" name="name" placeholder="Name">
<input type="text" name="category" placeholder="Category">
<input type="text" name="deadline" placeholder="Deadline">
<select name="status">
<option value="0">Undone</option>
<option value="1">Done</option>
</select>
<input type="hidden" name="agendaId" value="${agenda.id}">

<input type="submit" value="Submit" onclick="document.getElementById('createForm').style.display = 'none' ">
</form>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Category</th>
			<th>Deadline</th>
			<th>Status</th>
		</tr>
		<c:forEach var="task" items="${tasks}">
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