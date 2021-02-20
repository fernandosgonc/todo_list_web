<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Welcome ${sessionScope.loggedUser.name}, here are your agendas</h2>

<table border="1">
<c:forEach var="agenda" items="${agendas}">
<tr>
<td>${agenda.id}</td>
<td>${agenda.name}</td>
<td>${agenda.creationDate}</td>
<td><a href="tasks?agenda_id=${agenda.id}">Open</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>