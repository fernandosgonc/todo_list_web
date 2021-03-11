<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Sign in</title>
        <link href="css/style-login.css" rel="stylesheet" type="text/css">

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
                    <label for="Password"></label>Password</span><br>
                    <input id="txtPassword" type="password" name="password" placeholder="Password" required><br>
                    <input type="submit" value="Login">
                </form>

            </div>
        </main>



        <footer id="dev">
            <%@ include file="footer.jsp" %>
        </footer>

    </body>

    </html>