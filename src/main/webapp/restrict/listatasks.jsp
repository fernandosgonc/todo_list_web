<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TASKS</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<h2>Hey ${sessionScope.loggedUser.name}, those are your tasks</h2>

<table border="1">
<tr>
<th>ID</th>
<th>Name</th>
<th>Category</th>
<th>Deadline</th>
<th>Status</th>
</tr>
<c:forEach var="task" items="${tasks}">
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
</tr>
</c:forEach>
</table>

</body>
</html>