<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ include file="/template.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AGENDAS</title>

</head>
<body>

	<header>

		
		<h2 id="currentPage">AGENDAS</h2>

		<div id="obj-crud">
			<button
				onclick="hideAndShowForm('createForm')">Create</button>
		</div>
		<hr>

	</header>



	<main>

		<div class="container">


			<form id="createForm" action="createAgenda" style="display: none"
				method="post">
				<input type="text" name="name" placeholder="New Agenda"> <input type="submit"
					value="Submit"
					onclick="document.getElementById('createForm').style.display = 'none' ">
			</form>

			<c:if test="${not empty listAgendas}">

				<div id="tableContainer">

					<table id="data-table">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Creation Date</th>
								<th></th>
							</tr>
						</thead>
						<c:forEach var="agenda" items="${listAgendas}">
							<tbody>
								<tr>
									<td>${agenda.id}</td>
									<td>${agenda.name}</td>
									<td><tags:localDate date="${agenda.creationDate}"/></td>
									<td><a href="viewAgenda?agenda_id=${agenda.id}"><i
											class="material-icons">view_list</i></a></td>
								</tr>
							</tbody>
						</c:forEach>
					</table>
				</div>


			</c:if>

			<c:if test="${empty listAgendas}">
				<h2>${error}</h2>
			</c:if>
		</div>

	</main>

	<footer>
	</footer>

</body>
</html>