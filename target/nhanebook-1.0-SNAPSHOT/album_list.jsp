<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="css/music_download.css" type="text/css"/>
</head>
<body>

<h1>List of albums</h1>

<!--<p>User Email: {cookie.userEmail.value}</p> -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${cookie.firstNameCookie.value} != null">
    <p>Welcome back, <c:out value="${cookie.firstNameCookie.value}"></c:out></p>
</c:if>
<p>
<a href="download?action=checkUser&amp;productCode=8601">
    86 (the band) - True Life Songs and Pictures
</a><br>

<a href="download?action=checkUser&amp;productCode=pf01">
    Paddlefoot - The First CD
</a><br>

<a href="download?action=checkUser&amp;productCode=pf02">
    Paddlefoot - The Second CD
</a><br>

<a href="download?action=checkUser&amp;productCode=jr01">
    Joe Rut - Genuine Wood Grained Finish
</a>
</p>
<br>
<form action="index.html">
    <input type="submit"  value="Back To Home Page">
</form><br>

</body>
</html>