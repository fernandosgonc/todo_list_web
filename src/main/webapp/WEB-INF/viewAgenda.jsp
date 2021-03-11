<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Tasks</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>


	<header>
		<%@ include file="header.jsp"%>


		<h2 id="currentPage">${agenda.name}</h2>

		<div id="obj-crud">
		<button
				onclick="document.getElementById('addForm').style.display = 'block' ">Add
				Task</button>
			<button
				onclick="document.getElementById('editAgendaForm').style.display = 'block' ">Edit
				Agenda</button>
			<a href="deleteAgenda?agenda_id=${agenda.id}"><i
				class="material-icons">delete</i></a>
			
		</div>
		<hr>
	</header>

	<main>

		<div class="container" id="content">



			<form id="editAgendaForm" action="editAgenda" style="display: none"
				method="post">
				<input type="hidden" name="agenda_id" value="${agenda.id}">
				<input type="text" name="name"> <input type="submit"
					value="Submit"
					onclick="document.getElementById('editAgendaForm').style.display = 'none' ">
			</form>




			<form id="addForm" action="addTask" style="display: none"
				method="post">
				<input type="hidden" name="agenda" value="${agenda.id}"> <input
					type="text" name="name" placeholder="Name"> <input
					type="text" name="category" placeholder="Category"> <input
					type="text" name="deadline" placeholder="Deadline"> <select
					name="status">
					<option value="0">Undone</option>
					<option value="1">Done</option>
				</select> <input type="submit" value="Submit"
					onclick="document.getElementById('addForm').style.display = 'none' ">
			</form>

			<c:if test="${not empty taskList}">
				<table id="data-table">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Category</th>
							<th>Deadline</th>
							<th>Status</th>
							<th></th>
						</tr>
					</thead>
					<c:forEach var="task" items="${taskList}">
						<tbody>
							<tr>
								<td>${task.id}</td>
								<td>${task.name}</td>
								<td>${task.category}</td>
								<td>${task.deadline}</td>
								<c:if test="${task.done}">
									<td><i class="material-icons" style="color: #00af91">done</i></td>
								</c:if>
								<c:if test="${task.done == false}">
									<td><i class="material-icons" style="color: crimson">close</i></td>
								</c:if>
								<td><a href="viewTask?task_id=${task.id}"><i
										class="material-icons">assignment</i></a></td>
							</tr>
						</tbody>
					</c:forEach>
				</table>

			</c:if>

			<c:if test="${empty taskList}">
				<h2>${error}</h2>
			</c:if>
		</div>
	</main>

	<footer>
		<%@ include file="../footer.jsp"%>
	</footer>

</body>
</html>