<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <link rel="stylesheet" href="login.css">
</head>
<body>
<form action="/simplewebapp/application/login" method="post">

  <div class="container">
    <div id="error">
				${error_message}
	</div>
    <label for="uname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" value="${u.username}" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

    <button type="submit">Login</button>
  </div>

</form>
</body>
</html>
