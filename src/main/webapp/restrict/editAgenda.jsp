<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Agenda</title>
</head>
<body>
<jsp:include page="../header.jsp" />

Editing agenda: ${agenda.name}

<form id="updateForm" action="updateAgenda" method="post">
<input name="agenda_id" value="${agenda.id}" type="hidden">
<input type="text" name="name">
<input type="submit" value="Submit">
</form> <br>

</body>
</html>