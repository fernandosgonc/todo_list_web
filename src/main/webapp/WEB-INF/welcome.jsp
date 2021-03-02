
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<h1>Welcome, ${sessionScope.loggedUser.name}</h1>


</body>
</html>