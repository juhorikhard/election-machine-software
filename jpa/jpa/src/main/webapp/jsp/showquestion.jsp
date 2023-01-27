<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Question" %>   
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
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
  
</div>

<div class="content">
<h2>Vaalikoneen kysymykset</h2>
	<ol>
		<c:forEach var="question" items="${requestScope.questionlist}">
			<li class="c">${question.kysymys} 
			<a href='/delete?kysymys_id=${question.kysymys_id}'>delete</a> 
			<a href='/readtoupdate?kysymys_id=${question.kysymys_id}'>update</a>
		</c:forEach>
	</ol>
<a href='/jsp/showquestiontoadd.jsp'>Create new question</a>
</div>
</body>
</html>