<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AGENDAS</title>


<script type="text/javascript">

</script>

</head>
<body>

<jsp:include page="../header.jsp"/>

<h2>Welcome ${sessionScope.loggedUser.name}, here are your agendas</h2>


<button onclick="document.getElementById('createForm').style.display = 'block' ">Create</button> <br>

<form id="createForm" action="createAgenda" style="display: none" method="post">
<input type="text" name="name">
<input type="submit" value="Submit" onclick="document.getElementById('createForm').style.display = 'none' ">
</form> <br>

<table border="1">
<tr>
<th>ID</th>
<th>Name</th>
<th>Creation Date</th>
</tr>
<c:forEach var="agenda" items="${agendas}">
<tr>
<td>${agenda.id}</td>
<td>${agenda.name}</td>
<td>${agenda.creationDate}</td>
<td><a href="tasks?agenda_id=${agenda.id}">Open</a></td>
<td><a href="editAgenda?agenda_id=${agenda.id}">Edit</a></td>
<td><a href="deleteAgenda?agenda_id=${agenda.id}">Delete</a></td>
</tr>
</c:forEach>
</table>



</body>
</html>