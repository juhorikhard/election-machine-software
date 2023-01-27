<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"  %>
<%@ page import="data.Ehdokkaat"  %>
<%@ page import="javax.ws.rs.client.*"  %>
<%@ page import="javax.ws.rs.client.Invocation.Builder"  %>
<%@ page import="javax.ws.rs.core.*"  %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="/css/style.css">
<title>Read ehdokkaat</title>
</head>
<body>

<div class="topnav">
  <a href="/index.html">Etusivu</a>
</div>
<div class="content">
<h1>Ehdokkaat</h1>

<ol>
<c:forEach var="ehdokkaat" items="<%=readAll() %>">

   <li class="c"><div class="expand"><p>${ehdokkaat.etunimi} ${ehdokkaat.sukunimi}</p></div>
      <div class="text">
        <div>
            Ikä: ${ehdokkaat.ika}
            <br>Paikkakunta: ${ehdokkaat.kotipaikkakunta}
            <br>Puolue: ${ehdokkaat.puolue}
            <br><br>Miksi haluat Eduskuntaan<br><br> -${ehdokkaat.miksiEduskuntaan}
            <br><br>Mitä asioita haluat edistää<br><br> -${ehdokkaat.mitaAsioitaHaluatEdistaa}
            <br><br>
        </div>
      </div>
	</li>
</c:forEach>
</ol>
</div>

<script>
$(document).ready(function() {
	  $(".text").hide();
	  $(".expand").click(function() {
	    $(".text").slideUp(500);
	    if ($(this).next(".text").is(":visible")) {
	      $(this).next(".text").slideUp(500);
	    } else {
	      $(this).next(".text").slideToggle(500);
	    }
	  });
	});
</script>
</body>
</html>

<%!
List<Ehdokkaat> readAll() {
	String uri = "http://127.0.0.1:8080/rest/ehdokkaatservice/readehdokkaat";
	Client c=ClientBuilder.newClient();
	WebTarget wt=c.target(uri);
	Builder b=wt.request();
	GenericType<List<Ehdokkaat>> genericList = new GenericType<List<Ehdokkaat>>() {};
	
	List<Ehdokkaat> list=b.get(genericList);
	return list;
 }
%>


