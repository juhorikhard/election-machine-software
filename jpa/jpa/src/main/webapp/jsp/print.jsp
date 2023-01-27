<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% 
    String username = "admin";
    String password = "admin";
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/style.css">
<title>Vaalikone</title>

</head>





<h1 style="text-align: center; ">Admin kirjautuminen</h1>

<form style="text-align: center; " name="loginForm" method="post" action="/loginServlet">
	<fieldset>
    <label>Käyttäjänimi<input type="text" name="username"/></label><br><br>
    <label>Salasana<input type="password" name="password"/></label><br><br>
    <input type="submit" value="Kirjaudu"/>
    </fieldset>
</form>


</body>
</html>