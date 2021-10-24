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

<h1 class="centered">Your cart</h1>

<table class="box cart">
  <tr>
    <th>Quantity</th>
    <th>Description</th>
    <th>Price</th>
    <th>Amount</th>
    <th></th>
  </tr>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="item" items="${cart.items}">
  <tr>
    <td>
      <form action="cart" method="post">
        <input type="hidden" name="productCode"
               value="<c:out value='${item.product.code}'/>">
        <input class="quant" type=text name="quantity"
               value="<c:out value='${item.quantity}'/>" id="quantity">
        <input type="submit" value="Update">
      </form>
    </td>
    <td><c:out value='${item.product.description}'/></td>
    <td>${item.product.priceCurrencyFormat}</td>
    <td>${item.totalCurrencyFormat}</td>
    <td>
      <!-- <a href="cart?productCode={item.product.code}&amp;quantity=0">Remove Item</a> -->
      <form action="" method="post">
        <input type="hidden" name="productCode" 
               value="<c:out value='${item.product.code}'/>">
        <input type="hidden" name="quantity" 
               value="0">
        <input type="submit" value="Remove Item">
      </form>

    </td>
  </tr>
</c:forEach>
</table>

<p class="centered"><b>To change the quantity</b>, enter the new quantity 
      and click on the Update button.</p>
  
<form action="" method="post">
  <input type="hidden" name="action" value="shop">
  <div class="centered"><input class="button" type="submit" value="Continue Shopping"></div>
</form>

<form action="cart" method="post">
  <input type="hidden" name="action" value="checkout">
  <div class="centered"><input class="button" type="submit" value="Checkout"></div>
</form>

</body>
</html>