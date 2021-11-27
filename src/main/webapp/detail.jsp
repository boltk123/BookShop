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
    <div id="container">
        <div class="left-contain">
            <div class="main-img">
                <img class="main-img-item" src="image/image1.jpg" alt="">
            </div>
            <div class="list-img">
                <img class="book-img" src="data:image/jpg;base64,${book.base64Image}" alt="">
                <img class="book-img" src="image/image2.jpg" alt="">
                <img class="book-img" src="image/image3.jpg" alt="">
                <img class="book-img" src="image/image4.jpg" alt="">
            </div>
        </div>
        <div class="right-contain">
            <div class="title-author">
                <h2 class="book-title">Harry Potter: The Illustrated Collection (Books 1-3 Boxed Set)</h2>
                <p class="book-author">by Jim Kay (Illustrator), J. K. Rowling</p>
            </div>
            <div class="price">
                <span class="cur-price">
                    <sup>$</sup>
                    108.00
                </span>
                <s class="old-price">$120.00</s>
            </div>
            <div class="details">
                <p class="details-title">Product Details</p>
                <table id="details-table">
                    <tbody>
                        <tr>
                            <th>ISBN-13:</th>
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