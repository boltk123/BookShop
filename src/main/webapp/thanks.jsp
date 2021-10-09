<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="css/exercise.css" type="text/css"/>
</head>

<body>
<%@ include file="/includes/header.html" %>
<h1>Thanks for joining our email list</h1>

<p>Here is the information that you entered:</p>

<label>Email:</label>
<span>${user.email}</span><br>
<label>First Name:</label>
<span>${user.firstName}</span><br>
<label>Last Name:</label>
<span>${user.lastName}</span><br>
<p>If you have a moment, we'd appreciate it if you would fill out this survey.</p>
<form action="survey.jsp" method="get">
    <input type="submit" value="Survey">
</form>
<p>To enter another email address, click on the Back
    button in your browser or the Return button shown
    below.</p>

<form action="" method="post">
    <input type="hidden" name="action" value="add">
    <input type="submit" value="Return">
</form>

<%@ include file="/includes/footer.jsp" %>
</body>
</html>