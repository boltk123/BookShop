<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="css/exercise.css" type="text/css"/>
    <link
      href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap"
      rel="stylesheet"
    />
</head>
<body class="backgr">

<h1 class="centered">Cookies</h1>

<p class="centered">Here's a table with all of the cookies that this 
browser is sending to the current server.</p>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="box">
  <tr>
      <th><h2>Name</h2></th>
      <th><h2>Value</h2></th>
  </tr>
  <c:forEach var="c" items="${cookie}">      
  <tr>
      <td><p>${c.value.name}<p></td>
      <td><p>${c.value.value}</p></td>
  </tr>
  </c:forEach>  
</table>

<p class="centered"><a href="download?action=viewAlbums">View list of albums</a></p>

<p class="centered"><a href="download?action=deleteCookies">Delete all persistent cookies</a></p>

</body>
</html>