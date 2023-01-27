<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Vaalikone</title>
</head>
<body>
<div class="topnav">
  <a href="/index.html">Etusivu</a>
  <a href="/showquestion">Kysymykset</a>
</div>
<div class="content">
<h2>Muokkaa kysymyksiä</h2>
<form action='update' method='post'>
<p>Kysymys id</p>
<label><input type='text' name='kysymys_id' value='${requestScope.question.kysymys_id}'></label><br>
<p>Kysymys</p>
<label><input type='text' id='box' name='kysymys' value='${requestScope.question.kysymys}'></label><br>
<br>
<input type='submit' name='ok' value='Send'> 

</form>
</div>

<script>
$('#box').focus(function()
		{
		    $(this).animate({ width: '+=1000' }, 'slow');
		}).blur(function()
		{
		    $(this).animate({ width: '-=1000' }, 'slow');
		});

</script>

</body>
</html>