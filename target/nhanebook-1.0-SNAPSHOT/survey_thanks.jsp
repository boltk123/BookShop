<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="css/exercise.css" type="text/css"/>
</head>

<body>
    <div class="backgr">   
        <div>   
            <h1>Thanks for taking our survey!</h1>

            <p>Here is the information that you entered:</p>

            <label>Email:</label>
            <span>${user.email}</span><br>
            <label>First Name:</label>
            <span>${user.firstName}</span><br>
            <label>Last Name:</label>
            <span>${user.lastName}</span><br>
            <label>Heard From:</label>
            <span>${user.heardFrom}</span><br>
            <label>Updates:</label>
            <span>${user.wantsUpdates}</span><br>

            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <c:if test="${user.wantsUpdates == 'Yes'}">
                <label>Contact Via:</label>
                <span>${user.contactVia}</span>
            </c:if>   
        </div>
    </div>
</body>
</html>