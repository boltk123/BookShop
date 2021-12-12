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

<h1 class="centered">Download registration</h1>

<p class="centered">To register for our downloads, enter your name and email
   address below. Then, click on the Submit button.</p>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="box" action="download" method="post">
    <input type="hidden" name="action" value="registerUser">        
    <label class="pad_top">Email:</label>
    <input type="email" name="email" value="<c:out value='${user.email}'/>"><br>
    <label class="pad_top">First Name:</label>
    <input type="text" name="firstName" value="<c:out value='${user.firstName}'/>"><br>
    <label class="pad_top">Last Name:</label>
    <input type="text" name="lastName" value="<c:out value='${user.lastName}'/>"><br>
    <label class="pad_top">Phone</label>
    <input type="text" name="phone" value="<c:out value='${user.phone}'/>"><br>
    <label class="pad_top">Address</label>
    <input type="text" name="address" value="<c:out value='${user.address}'/>"><br>
    <label>&nbsp;</label>
    <br>
    <div class="centered"><input class="button" type="submit" value="Register" class="margin_left"></div>
</form>

</body>

</html>
