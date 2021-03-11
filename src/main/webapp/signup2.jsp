<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<a href="welcome.jsp">HOME</a>
<a href="signin.jsp">SIGN IN</a>

<hr>
  
  
  
<h2>
    Register in our system in order to get access to it.
</h2>

<form action="mvc/signup" method="POST">
    Name: <input type="text" name="name"><br>
    Email: <input type="text" name="email"><br>
    Username: <input type="text" name="login"><br>
    Password: <input type="password" name="password"><br>
    Gender: <select name="gender" id="gdrSelect"><br>
        <option value="M">Masculine</option>
        <option value="F">Feminine</option>
        <option value="O">Other</option>
    </select><br>
    <input type="submit" value="Submit" >
</form>

</body>
</html>