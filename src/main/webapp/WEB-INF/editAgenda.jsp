<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edting Agenda</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<h3>You are editing this agenda: ${agenda.name}</h3>

<form id="editForm" action="editAgenda" method="post">
<input type="hidden" name="agenda_id" value="${agenda.id}">
<input type="text" name="name">
<input type="submit" value="Submit">
</form> 

</body>
</html>