<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detail</title>
    <link rel="stylesheet" href="css/detail.css">
</head>
<body>
    <%@ include file="/includes/header.jsp" %>
    <div id="container">
        <div class="left-contain">
            <div class="main-img">
                <img class="main-img-item" src="data:image/jpg;base64,${book.base64Image}" alt="">
            </div>
            <div class="list-img">
                <c:forEach var="sample" items="${samplesList}">
                    <c:if test="${sample != null}">
                        <img class="book-img" src="data:image/jpg;base64,${sample.base64Sample}" alt="">
                    </c:if>

                </c:forEach>
            </div>
        </div>
        <div class="right-contain">
            <div class="title-author">
                <h2 class="book-title">${book.title}</h2>
                <p class="book-author">${book.author}</p>
            </div>
            <div class="price">
                <span class="cur-price">
                    <sup>$</sup>
                    ${book.cost}
                </span>
                <s class="old-price">$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${book.cost + 10}"/></s>

            </div>
            <div class="details">
                <p class="details-title">Product Details</p>
                <table id="details-table">
                    <tbody>
                        <tr>
                            <th>:</th>
                            <td>9781338312911</td>
                        </tr>
                        <tr>
                            <th>Publisher:</th>
                            <td>Scholastic, Inc.</td>
                        </tr>
                        <tr>
                            <th>Publication date:</th>
                            <td>09/25/2018</td>
                        </tr>
                        <tr>
                            <th>Age Range:</th>
                            <td>8 - 18 Years</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="add-download">
                <button class="add-to-cart">Add to cart</button>
                <button class="download">Download</button>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
    <script>
        $(() => {
            $('.left-contain .list-img img').click(function() {
                var imgPath = $(this).attr('src');
                $('.left-contain .main-img img').attr('src', imgPath);
            })
        })
    </script>
    <script src="js/detail.js"></script>
</body>
</html>