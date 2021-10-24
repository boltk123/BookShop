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
<body class="backgr">  
        <div class="box">            
            <h1>Join our email list</h1>
            <p>To join our email list, enter your name and
               email address below.</p>
            <!--<<p><i>{message}</i></p> -->

            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <c:if test="${message != null}">
                <p><i>${message}</i></p>
            </c:if><br>
                <form action="emailList" method="post">
                    <input type="hidden" name="action" value="add">       
                    <label class="pad_top">Email:</label>
                    <input type="email" name="email" value="${user.email}"><br>
                    <label class="pad_top">First Name:</label>
                    <input type="text" name="firstName" value="${user.firstName}"><br>
                    <label class="pad_top">Last Name:</label>
                    <input type="text" name="lastName" value="${user.lastName}"><br>        
                    <br>
                    <div class="centered"><input type="submit" value="Join Now" class="button" ></div>
                </form>
                    <form action="emailList" method="post">
                <input type="hidden" name="action" value="homepage">
                <div class="centered"><input class="button" type="submit"  value="Back To Home Page"></div>
                    </form><br>
        </div>
<%@ include file="/includes/footer.jsp" %>
        