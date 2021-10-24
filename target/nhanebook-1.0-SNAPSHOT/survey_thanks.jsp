<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
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

<body>
    <div class="backgr">   
        <div class="box">   
            <h1>Thanks for taking our survey!</h1>

            <p>Here is the information that you entered:</p><br>

            <label>Email:</label>
            <p>${user.email}</p><br>
            <label>First Name:</label>
            <p>${user.firstName}</p><br>
            <label>Last Name:</label>
            <p>${user.lastName}</p><br>
            <label>Heard From:</label>
            <p>${user.heardFrom}</p><br>
            <label>Updates:</label>
            <p>${user.wantsUpdates}</p><br>

            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <c:if test="${user.wantsUpdates == 'Yes'}">
                <label>Contact Via:</label>
                <p>${user.contactVia}</p>
            </c:if>
            <br>
            <form action="index.html">
                <div class="centered"><input class="button" type="submit"  value="Back To Home Page"></div>
            </form><br>
            <%@ include file="/includes/footer.jsp" %>
        </div>
    </div>
</body>
</html>