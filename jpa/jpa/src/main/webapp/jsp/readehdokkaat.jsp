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

   <li class="c"><p>${ehdokkaat.etunimi} ${ehdokkaat.sukunimi}</p>
    	<a href='/rest/ehdokkaatservice/deleteehdokkaat/${ehdokkaat.ehdokasId}'>Delete</a> <a href='/readtoupdateehdokkaat?ehdokasId=${ehdokkaat.ehdokasId}'>Update</a>
	</li>
	
</c:forEach>
</ol>
<p><a href='/jsp/ehdokkaatform.jsp'>Luo uusi ehdokas</a></p>

</div>


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


