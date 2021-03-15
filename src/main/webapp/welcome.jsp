<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>HOME</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="shortcut icon" href="<c:url value='/favicon.ico'/>" />
</head>

<body>


	<header id="welcome-header">
		<h1>TAS.K.IT</h1>
		<hr>
		<h2>WELCOME TO OUR SYSTEM! :)</h2>
		<p id="dev">developed by: fernandosgonc</p>
	</header>

	<main>
		<div class="container" id="welcome-container">
			<p>
				<a href="signup2.jsp">Register</a> <br> OR<br> <a
					href="signin.jsp">Sign In</a><br> in order to get access to
				it.
			</p>
		</div>


	</main>


	<footer> </footer>
</body>

</html>