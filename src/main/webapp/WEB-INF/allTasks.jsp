<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../template.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TASKS</title>

</head>
<body>

	<header>
		<%@ include file="header.jsp"%>
		<h2 id="currentPage">ALL TASKS</h2>
		<div id="obj-crud">
			<button
				onclick="hideAndShowForm('addTaskForm')">Create</button>
		</div>
		<hr>
	</header>

	<main>

		<div class="container" id="content">

			<form id="addTaskForm" action="addTask" style="display: none"
				method="post">
				<input type="text" name="name" placeholder="Name"> <input
					type="text" name="category" placeholder="Category"> <input
					type="text" name="deadline" placeholder="Deadline"> <select
					name="status">
					<option value="0">Undone</option>
					<option value="1">Done</option>
				</select> <select name="agenda">
					<c:forEach var="ag" items="${allAgendas}">
						<option value="${ag.id}">${ag.name}</option>
					</c:forEach>
				</select> <input type="submit" value="Submit"
					onclick="document.getElementById('addTaskForm').style.display = 'none' ">

			</form>
			

			<c:if test="${not empty allTasks}">

				<div id="tableContainer">

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
						<c:forEach var="task" items="${allTasks}">
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

				</div>

			</c:if>

			<c:if test="${empty allTasks}">
				<h2>${error}</h2>
			</c:if>
		</div>

	</main>


	<footer>
		<%@ include file="../footer.jsp"%>
	</footer>
</body>
</html>