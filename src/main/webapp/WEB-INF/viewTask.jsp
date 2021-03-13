<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ include file="../template.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TASK</title>

</head>
<body>

	<header>
		
		<h2 id="currentPage">TASK INFO</h2>

		<div id="obj-crud">
			<button
				onclick="hideAndShowForm('editTaskForm')">Edit</button>
			<a href="delete?task_id=${task.id}"><i class="material-icons">delete</i></a>
		</div>


		<hr>
	</header>

	<main>
	
	<div id="content" class="container">
	
	
	<form id="editTaskForm" action="editTask" method="post"
			style="display: none">
			<input type="hidden" name="id" value="${task.id}">
			<input 	type="text" name="name" placeholder="Name"> 
			<input type="text" name="category" placeholder="Category"> 
			<input 	type="text" name="deadline" placeholder="Deadline">
			<select
				name="status">
				<option value="0">Undone</option>
				<option value="1">Done</option>
			</select>
			<select name="agenda">
				<c:forEach var="ag" items="${allAgendas}">
					<option value="${ag.id}">${ag.name}</option>
				</c:forEach>
			</select> <input type="submit" value="Submit"
				onclick="document.getElementById('editAgendaForm').style.display = 'none' ">
		</form>


			<div id="tableContainer">

				<table id="data-table">

					<thead>
					</thead>

					<tbody>
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
							<td><tags:localDate date="${task.deadline}" /></td>

						</tr>

						<tr>
							<td>Status</td>
							<c:if test="${task.done}">
								<td><i class="material-icons" style="color: #00af91">done</i></td>
							</c:if>
							<c:if test="${task.done == false}">
								<td><i class="material-icons" style="color: crimson">close</i></td>
							</c:if>
						</tr>

						<tr>
							<td>Agenda</td>
							<td>${agenda.name}</td>

						</tr>
					</tbody>
				</table>

			</div>

		</div>
	</main>

	<footer>
	</footer>
</body>
</html>