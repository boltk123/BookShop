<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bookshop</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/homepage.css">
</head>
<body>
<nav class="bg-color-3 d-flex justify-around p-1">
    <ul class="list-style-none d-flex align-center justify-center">
        <li>
            <a href="homepage.jsp" class="image-highlight">
                <img src="./assets/images/book.svg" alt="bookshop-logo">
                <span class="color-white font-style-3 font-size-md pl-1">BOOKSHOP</span>
            </a>
        </li>
        <li class="pl-2 d-none visible-in-md">
            <a href="homepage.jsp">
                <img src="./assets/images/home-run.svg" alt="home-logo" class="navbar-icon">
                <span class="color-1 font-style-1 font-size-sm pl-1 white-highlight">HOME</span>
            </a>
        </li>
        <li class="pl-2 d-none visible-in-md">
            <a href="collection.jsp">
                <img src="./assets/images/bookshelf.svg" alt="collection-logo" class="navbar-icon">
                <span class="color-2 font-style-1 font-size-sm pl-1 white-highlight">COLLECTIONS</span>
            </a>
        </li>
        <li class="pl-2">
            <a href="ShoppingCart">
                <img src="./assets/images/supermarket.svg" alt="cart-logo" class="navbar-icon">
                <span class="color-2 font-style-1 font-size-sm pl-1 white-highlight d-none visible-in-md">SHOPPING LIST</span>
            </a>
        </li>
        <li class="pl-2">
            <c:if test = "${sessionScope.account.role == 'admin'}">
                <button type="button"
                        class="d-none stock-btn default-btn font-size-sm font-style-2 bg-color-1">
                    <a href="BooksTableInput.jsp" class="image-highlight">ADMIN</a>
                </button>
            </c:if>
        </li>
    </ul>

    <ul class="list-style-none d-flex justify-around align-center user-info">
        <li class="d-none visible-in-lg">
            <a href="#" class="image-highlight">
                <img src="./assets/images/mail.svg" alt="mail-icon" class="navbar-icon">
                <span
                        class="d-inline-block bg-color-1 mail-notification font-size-sm font-style-2 color-white">12</span>
            </a>
        </li>
        <li class="d-none visible-in-lg">
            <a href="BooksTableInput.jsp">
                <span class="color-white font-style-3 font-size-sm pl-1 gray-highlight">${indexmessage}</span>
            </a>
        </li>
        <li>
            <a href="#">
                <img src="./assets/images/person.svg" alt="user-img" class="image-highlight pl-1">
            </a>
        </li>
        <li class="pl-1">
            <a href="#" class="search-btn default-btn font-size-sm font-style-2 bg-color-1">Search</a>
        </li>
    </ul>
</nav>
<br>

<form class="Login-form " action="LoginReg" method="post">
    <input type="hidden" name="action" value="register">
    <div class="login-field">
        <label>First Name:</label>
        <input type="text" name="firstname" value="${account.firstname}" required>
    </div>
    <div class="login-field">
        <label>Last Name:</label>
        <input type="text" name="lastname" value="${account.lastname}" required>
    </div>
    <div class="login-field">
        <p><i>${emailmessage}</i></p>
        <label>Email:</label>
        <input type="email" name="email" value="${account.email}" required>
    </div>
    <div class="login-field">
        <p><i>${usernamemessage}</i></p>
        <label>Username:</label>
        <input type="text" name="username" value="${account.username}" required>
    </div>
    <div class="login-field">
        <label>Password:</label>
        <input type="password" name="password" value="${account.password}" required>
    </div>

    <input type="submit" value="Register" class="register-submit">
</form>

</body>
</html>
