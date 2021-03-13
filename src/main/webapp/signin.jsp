<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Sign in</title>
        <link href="css/style-login.css" rel="stylesheet" type="text/css">
        <link rel="shortcut icon" href="<c:url value='/favicon.ico'/>" />

    </head>

    <body>

		<header>
            <div id="nav">
                <a href="welcome.jsp">HOME</a>
                <a href="signup2.jsp">SIGN UP</a>
            </div>
            <hr>
            <h1>SIGN IN</h1>
        </header>
		<main>

            <div class="container">


                <form action="mvc/signin" method="post">
                    <label for="Login">Login</label><br>
                    <input id="login" name="login" type="text" placeholder="Email" required><br>
                    <label for="Password">Password</label><br>
                    <input id="txtPassword" type="password" name="password" placeholder="Password" required><br>
                    <input type="submit" value="Login">
                </form>

            </div>
        </main>
		<footer id="dev">
            <p id="dev">developed by: fernandosgonc</p>
        </footer>
</body>

    </html>