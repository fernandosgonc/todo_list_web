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
<button onclick="document.getElementById('editAgendaForm').style.display = 'block' ">Edit Agenda</button> <br>
<a href="deleteAgenda?agenda_id=${agenda.id}">Delete</a>
<hr>




<form id="editAgendaForm" action="editAgenda" style="display: none" method="post">
<input type="hidden" name="agenda_id" value="${agenda.id}">
<input type="text" name="name">
<input type="submit" value="Submit" onclick="document.getElementById('editAgendaForm').style.display = 'none' ">
</form> 


<button onclick="document.getElementById('addForm').style.display = 'block' ">Add Task</button> <br>

<form id="addForm" action="addTask" style="display: none" method="post">
<input type="hidden" name="agenda" value="${agenda.id}">
<input type="text" name="name" placeholder="Name">
<input type="text" name="category" placeholder="Category">
<input type="text" name="deadline" placeholder="Deadline">
<select name="status">
<option value="0">Undone</option>
<option value="1">Done</option>
</select>


<input type="submit" value="Submit" onclick="document.getElementById('addForm').style.display = 'none' ">
</form> 

<c:if test="${not empty taskList}">
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
				<!-- <td><a href="edit?task_id=${task.id}">Edit</a></td>
				<td><a href="delete?task_id=${task.id}">Delete</a></td> -->
				<td><a href="viewTask?task_id=${task.id}">See</a></td>
			</tr>
		</c:forEach>
	</table>
	
	</c:if>
	
	<c:if test="${empty taskList}">
    <h2>${error}</h2>
</c:if>

</body>
</html>