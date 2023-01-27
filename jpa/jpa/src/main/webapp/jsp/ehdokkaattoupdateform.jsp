<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Update ehdokkaat</title>
</head>
<body>

<div class="topnav">
  <a href="/index.html">Etusivu</a>
  <a href="/jsp/readehdokkaat.jsp">Ehdokkaat</a>
</div>

<div class="content">
<form action='/updateehdokkaat' method='post'>
<label>Ehdokkaan id</label>
<input type='text' name='ehdokasId' value='${requestScope.ehdokkaat.ehdokasId }'>
<br><br>
<label>Etunimi</label>
<input type='text' name='etunimi' value='${requestScope.ehdokkaat.etunimi }'>
<br><br>
<label>Sukunimi</label>
<input type='text' name='sukunimi' value='${requestScope.ehdokkaat.sukunimi }'>
<br><br>
<label>Ammatti</label>
<input type='text' name='ammatti' value='${requestScope.ehdokkaat.ammatti }'>
<br><br>
<label>Ikä</label>
<input type='text' name='ika' value='${requestScope.ehdokkaat.ika }'>
<br><br>
<label>Kotipaikkakunta</label>
<input type='text' name='kotipaikkakunta' value='${requestScope.ehdokkaat.kotipaikkakunta }'>
<br><br>
<label>Miksi haluaisit eduskuntaan?</label>
<input type='text' id="box" name='miksiEduskuntaan' value='${requestScope.ehdokkaat.miksiEduskuntaan }'>
<br><br>
<label>Mitä asioita haluat edistää? </label>
<input type='text' id="box2" name='mitaAsioitaHaluatEdistaa' value='${requestScope.ehdokkaat.mitaAsioitaHaluatEdistaa }'>
<br><br>
<label>Puolue</label>
<input type='text' name='puolue' value='${requestScope.ehdokkaat.puolue }'>
<br><br>

<input type='submit' name='ok' value='OK'>
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
		
$('#box2').focus(function()
		{
		    $(this).animate({ width: '+=1000' }, 'slow');
		}).blur(function()
		{
		    $(this).animate({ width: '-=1000' }, 'slow');
		});
</script>
</body>
</html>