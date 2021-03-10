<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign in</title>
</head>
<body>

<a href="welcome.jsp">HOME</a>
<a href="signup2.jsp">SIGN UP</a>

<hr>

<form action="mvc/signin" method="post">
Login: <input type="text" name="login"> <br>
Password: <input type="text" name="password">
<input type="submit" value="Login">
</form>

</body>
</html>