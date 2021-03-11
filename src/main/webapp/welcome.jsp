<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="../template.jsp" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>HOME</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>

<body>


	<header id="welcome-header">
		<h1>WELCOME TO OUR SYSTEM! :)</h1>
		<hr>
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


	<footer>
		<%@ include file="footer.jsp"%>
	</footer>
</body>

</html>