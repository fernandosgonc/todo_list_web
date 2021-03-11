<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register</title>
<link href="css/style-login.css" rel="stylesheet" type="text/css">
</head>
<body>


	<header>
		<div id="nav">
			<a href="welcome.jsp">HOME</a> <a href="signin.jsp">SIGN IN</a>
		</div>
		<hr>
		<h1>SIGN UP</h1>
	</header>

<main>

	<div class="container" id="signup">


		<form action="mvc/signup" method="POST">
			Name: <input type="text" name="name" required><br> Email: <input
				type="text" name="email" required><br> Username: <input
				type="text" name="login" required><br> Password: <input
				type="password" name="password" required><br> Gender: <select
				name="gender" id="gdrSelect">
				<option value="M">Masculine</option>
				<option value="F">Feminine</option>
				<option value="O">Other</option>
			</select><br> <input type="submit" value="Submit">
		</form>
	</div>
</main>

<footer>
	<jsp:include page="footer.jsp"/>
</footer>

</body>
</html>