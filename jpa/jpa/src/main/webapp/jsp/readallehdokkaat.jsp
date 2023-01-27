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
<link rel="stylesheet" href="/css/style.css">
<title>Read ehdokkaat</title>
</head>
<body>
<h3>From method</h3>

<ol>
<c:forEach var="ehdokkaat" items="<%=readAll() %>">
	<li>${ehdokkaat} 
</c:forEach>
</ol>
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