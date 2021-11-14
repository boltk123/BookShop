<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
<body>
<h1>Hello</h1>
<div align="center">
    <c:forEach var="book" items="${books}">
    <h2><c:out value="${book.title}" /></h2>
    <img src="data:image/jpg;base64,${book.base64Image}" width="240" height="300"/>
    </c:forEach>
</div>
</body>
</html>