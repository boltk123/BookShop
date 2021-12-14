<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/purchase_history.css">
    <title>Purchase History</title>
</head>
<body>
<%@ include file="/includes/header.jsp" %>
<div class="purchase-title">Purchase History</div>
<div id="table-contain">
    <table class="purchase-table">
        <thead>
        <tr>
            <th>Product</th>
            <th>Quantity</th>
            <th>Order Date</th>
            <th>Delivery Date</th>
            <th>Total Price</th>
            <th>Status</th>
            <th>Details</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${invoices}">
            <c:forEach var="book" items="${booksList}">
                <c:if test = "${item.product_id eq book.book_id}">
                    <tr>
                        <td>${book.title}</td>
                        <td>${item.quantity}</td>
                        <td>${item.purchase_date}</td>
                        <td>${item.delivery_date}</td>
                        <td>${item.total}</td>
                        <c:choose>
                            <c:when test="${item.delivered eq true}">
                                <td>
                                    Delivered
                                </td>
                            </c:when>
                           <c:otherwise>
                               <td>
                                   Processing
                               </td>
                           </c:otherwise>
                        </c:choose>
                        <td><a href="Detail?book_id=${book.book_id}" class="detail-link">Detail</a></td>
                    </tr>
                </c:if>
            </c:forEach>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>