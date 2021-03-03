<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TASK</title>
</head>
<body>
	<jsp:include page="../header.jsp" />

			<button onclick="document.getElementById('editTaskForm').style.display = 'block' ">Edit</button>
			<a href="delete?task_id=${task.id}">Delete</a>
		<hr>

	<table border="1">
	
		
	
		<tr>
			<td>Name</td>
			<td>${task.name}</td>

		</tr>

		<tr>
			<td>Category</td>
			<td>${task.category}</td>

		</tr>

		<tr>
			<td>Deadline</td>
			<td>${task.deadline}</td>

		</tr>

		<tr>
			<td>Status</td>
			<c:if test="${task.done}">
				<td>Done</td>
			</c:if>
			<c:if test="${task.done == false}">
				<td>Undone</td>
			</c:if>
		</tr>
		
		<tr>
			<td>Agenda</td>
			<td>${agenda.name}</td>

		</tr>
	</table>

<br>



	<form id="editTaskForm" action="editTask" method="post" style="display: none" >
		<input type="hidden"  name="id" value="${task.id}">
		Name: <input type="text" name="name"> <br> 
		Category: <input type="text" name="category"> <br> 
		Deadline: <input type="text" name="deadline"> <br> 
		Status: <select	name="status">
			<option value="0">Undone</option>
			<option value="1">Done</option>
		</select>
		<select name="agenda">
			<c:forEach var="ag" items="${allAgendas}">
				<option value="${ag.id}">${ag.name}</option>
			</c:forEach>
		</select>
		
		<input type="submit" value="Submit" onclick="document.getElementById('editAgendaForm').style.display = 'none' ">
	</form>

</body>
</html>