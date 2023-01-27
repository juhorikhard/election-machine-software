<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/style.css">
<title>Vaalikone</title>
</head>
<body>
<div class="topnav">
  <a href="/index.html">Etusivu</a>
  <a href="/showquestion">Kysymykset</a>
</div>

<div class="content">
<h2>Lisää uusi kysymys</h2>
<form action='/create' method='post'>
<p>Kysymys id</p>
<label><input type='text' name='kysymys_id' value='${requestScope.question.kysymys_id}'></label><br>
<p>Kysymys</p>
<label><input type='text' id='box' name='kysymys' value='${requestScope.question.kysymys}'></label><br>
<br>
<input type='submit' name='ok' value='Send'> 
</form>
</div>
</body>
</html>