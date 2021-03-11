
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

	<header>
		<%@ include file="header.jsp"%>

		<h1>Welcome, ${sessionScope.loggedUser.name}</h1>
	</header>

	<main>
		
	</main>


	<footer>
		<%@ include file="../footer.jsp"%>
	</footer>

</body>
</html>