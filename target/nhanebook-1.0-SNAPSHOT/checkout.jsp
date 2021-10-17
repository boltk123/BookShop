<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="css/cart_exercise.css" type="text/css"/>
</head>
<body>

<h1>Check Out</h1>

<table>
    <tr>
        <th>Quantity</th>
        <th>Description</th>
        <th>Price</th>
        <th>Amount</th>
    </tr>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:forEach var="item" items="${cart.items}">
        <tr>
            <td>${item.quantity}</td>
            <td>${item.product.description}</td>
            <td>${item.product.priceCurrencyFormat}</td>
            <td>${item.totalCurrencyFormat}</td>
        </tr>
    </c:forEach>
    <tr>
        <td>Total</td>
        <td></td>
        <td></td>
        <td>${cart.total}</td>
    </tr>
</table>

<form action="" method="post">
    <input type="hidden" name="action" value="shop">
    <input type="submit" value="Continue Shopping">
</form>

<form action="index.html" method="post">
    <input type="hidden" name="action" value="checkout">
    <input type="submit" value="Return To Home Page">
</form>

</body>
</html>