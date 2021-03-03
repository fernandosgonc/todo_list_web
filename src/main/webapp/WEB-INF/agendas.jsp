<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>A G E N D A S</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<button onclick="document.getElementById('createForm').style.display = 'block' ">Create</button> <br>

<form id="createForm" action="createAgenda" style="display: none" method="post">
<input type="text" name="name">
<input type="submit" value="Submit" onclick="document.getElementById('createForm').style.display = 'none' ">
</form> 




	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Creation Date</th>
		</tr>
		<c:forEach var="agenda" items="${listAgendas}">
			<tr>
				<td>${agenda.id}</td>
				<td>${agenda.name}</td>
				<td>${agenda.creationDate}</td>
				<td><a href="open?agenda_id=${agenda.id}">Open</a></td>
				<!--  <td><a href="edit?agenda_id=${agenda.id}">Edit</a></td>
				<td><a href="deleteAgenda?agenda_id=${agenda.id}">Delete</a></td>-->
			</tr>
		</c:forEach>
	</table>

</body>
</html>