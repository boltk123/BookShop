<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bookshop</title>
    <link type="text/css" rel="stylesheet" href="css/homepage.css">
    <link type="text/css" rel="stylesheet" href="css/homepagePlus.css">
    <link type="text/css" rel="stylesheet" href="css/normalize.css">

    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>

<body>
<header>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <nav class="bg-color-3 d-flex justify-around p-1">
        <ul class="list-style-none d-flex align-center justify-center">
            <li>
                <a href="HomePage" class="image-highlight">
                    <img src="image/rsz_120px-vector_book_bluesvg.png" alt="bookshop-logo">
                    <span class="color-white font-style-3 font-size-md pl-1">DANDELION FIELD</span>
                </a>
            </li>
            <li class="pl-2 d-none visible-in-md">
                <a href="HomePage">
                    <img src="./assets/images/home-run.svg" alt="home-logo" class="navbar-icon">
                    <span class="color-1 font-style-1 font-size-sm pl-1 white-highlight">HOME</span>
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
                        <a href="AdminDashboard" class="image-highlight">ADMIN</a>
                    </button>
                </c:if>

            </li>
        </ul>

        <ul class="list-style-none d-flex justify-around align-center user-info">
            <li class="d-none visible-in-lg">
                <!--
                <a href="#" class="image-highlight">
                    <img src="./assets/images/mail.svg" alt="mail-icon" class="navbar-icon">
                    <span
                            class="d-inline-block bg-color-1 mail-notification font-size-sm font-style-2 color-white">12</span>
                </a>
                -->
            </li>
            <li class="d-none visible-in-lg">
                <a href="Account">
                    <c:if test="${sessionScope.account != null}">
                        <input type="hidden" name="action" value="">
                    </c:if>
                    <span class="color-white font-style-3 font-size-sm pl-1 gray-highlight user-status">${indexmessage}</span>
                </a>
            </li>
            <li class="d-none visible-in-lg">
                <c:if test = "${sessionScope.account != null}">
                    <a href="LogOut">
                        <span class="color-white font-style-3 font-size-sm pl-1 gray-highlight user-status">LOG OUT</span>
                    </a>
                </c:if>
            </li>
            <li>
                <!--
                <a href="Account">
                    <img src="./assets/images/person.svg" alt="user-img" class="image-highlight pl-1">
                </a>
                -->
                <a href="EditFetching?book_id=2">
                    <img src="./assets/images/person.svg" alt="user-img" class="image-highlight pl-1">
                </a>
            </li>
        </ul>
    </nav>

    <section class="hero-section flex-column align-center justify-center p-3">
        <h1 class="hero-title font-style-2 color-white p-1">DANDELION FIELD</h1>
        <h4 class="font-style-1 color-white font-size-md">An online market place for all kinds of books</h4>
        <form action="Search" class="hero-form p-1 d-flex align-center">
            <select name="genre" class="genre-selector border-0 bg-white border-right flex-grow-1 pointer">
                <option value="all" class="genre-selector">All genre</option>
                <option value="Non-Fiction" class="genre-selector">Non Fiction</option>
                <option value="Fiction" class="genre-selector">Fiction</option>
                <option value="Academic" class="genre-selector">Academic</option>
            </select>
            <input type="text" placeholder="Search..." class="p-1 border-0 font-style-1 font-size-sm flex-grow-1 pointer" name="key_word">
            <input class="default-btn font-size-sm font-style-2 bg-color-3 ml-1" type="submit" value="SEARCH">
        </form>
    </section>
</header>

<main class="pb-4">
    <section class="home" id="home">

        <div class="row">

            <div class="content">
                <h4>Back to school</h4>
                <h1>Special 50% OFF </h1>
                <h4>For our student community</h4>
                <a href="#" class="btn">shop now</a>
            </div>

            <div class="swipes books-slider">
                <div class="wrapper">
                    <a href="#" class="swipe"><img src="image/book-1.png" alt=""></a>
                    <a href="#" class="swipe"><img src="image/book-2.png" alt=""></a>
                    <a href="#" class="swipe"><img src="image/book-3.png" alt=""></a>
                   <!-- <a href="#" class="swipe"><img src="image/book-4.png" alt=""></a>
                    <a href="#" class="swipe"><img src="image/book-5.png" alt=""></a>
                    <a href="#" class="swipe"><img src="image/book-6.png" alt=""></a>-->
                </div>
                <img src="image/stand.png" class="stand" alt="">
            </div>

        </div>

    </section>
    <section class="icons-container">

        <div class="icons">
            <i class="fas fa-shipping-fast" id="moveleft"></i>
            <div class="content">
                <h3>free shipping</h3>
                <p>order over $100</p>
            </div>
        </div>

        <div class="icons">
            <i class="fas fa-lock" id="Moveleftt"></i>
            <div class="content">
                <h3>secure payment</h3>
                <p>100 secure payment</p>
            </div>
        </div>

        <div class="icons">
            <i class="fas fa-redo-alt" id="movelefts"></i>
            <div class="content">
                <h3>easy returns</h3>
                <p>10 days returns</p>
            </div>
        </div>

        <div class="icons">
            <i class="fas fa-headset" id="moveleFtss"></i>
            <div class="content">
                <h3>24/7 support</h3>
                <p>call us anytime</p>
            </div>
        </div>

    </section>

    <!-- Non Fiction Books -->
    <section class="book-genre-container mx-auto p-1">
        <h4 class="font-style-2 font-size-md color-2  border-bottom my-1 py-1 black-highlight pointer"><img
                src="assets/images/ai.svg" alt="non-fiction" class="category-heading-icons mr-half">Non Fiction Books</h4>
        <section class="book-cards-container d-flex flex-wrap justify-between">
            <h2 class="d-none">This is hidden</h2>
            <c:forEach var="book" items="${non_fiction_books}">
                <article class="book-card bg-white my-1">
                    <h2 class="d-none">This is hidden</h2>
                    <a href="Detail?book_id=${book.book_id}">
                        <img class= "book-card-img d-block" src="data:image/jpg;base64,${book.base64Image}" alt="non-fiction-img-1">
                    </a>

                    <div class="p-half pointer d-flex flex-column justify-between h-200">
                        <p class="font-style-1 font-size-md color-3 py-1 gray-highlight">${book.title}</p>
                        <div>
                            <p class="font-size-sm font-style-2 color-3 gray-highlight">by ${book.author}</p>
                            <p class="font-size-s font-style-2 color-3  py-1 gray-highlight">Rating: ${book.rating}/5</p>
                            <p class="py-1 d-flex justify-between align-center">
                                <a href="AddCart?book_id=${book.book_id}">
                                    <span class="add-to-cart font-size-lg px-half  gray-highlight">+</span>
                                </a>
                                <span class="font-size-md color-5 font-style-2 gray-highlight">$${book.cost}</span>
                            </p>
                        </div>
                    </div>
                </article>
            </c:forEach>
        </section>
    </section>
    <div class="offer">
        <div class="small-container">
            <div class="row">
                <div class="col-2">
                    <img src="image/arrival_4.jpg" class="offer-img">
                </div>
                <div class="cols-2">
                    <h1>RED QUEEN</h1>
                    <p>$15.99</p>
                    <div class="stars">
                        <i class="fas fa-star" class="sizeStar"></i>
                        <i class="fas fa-star" class="sizeStar"></i>
                        <i class="fas fa-star" class="sizeStar"></i>
                        <i class="fas fa-star" class="sizeStar"></i>
                        <i class="fas fa-star" class="sizeStar"></i>
                        <p>1,368 reviews</p>
                    </div>
                    <h2>Author: Victoria Averya</h2>
                </div>
            </div>
        </div>
    </div>
    <!-- Fiction Books-->
    <section class="book-genre-container mx-auto p-1">
        <h4 class="font-style-2 font-size-md color-2  border-bottom my-1 py-1 black-highlight pointer"><img
                src="assets/images/fiction.svg" alt="non-fiction" class="category-heading-icons mr-half">Fiction Books</h4>
        <section class="book-cards-container d-flex flex-wrap justify-between">
            <h2 class="d-none">This is hidden</h2>
            <c:forEach var="book" items="${fiction_books}">
                <article class="book-card bg-white my-1">
                    <h2 class="d-none">This is hidden</h2>
                    <a href="Detail?book_id=${book.book_id}">
                        <img class= "book-card-img d-block" src="data:image/jpg;base64,${book.base64Image}" alt="fiction-img-1">
                    </a>
                    <div class="p-half pointer d-flex flex-column justify-between h-200">
                        <p class="font-style-1 font-size-md color-3 py-1 gray-highlight">${book.title}</p>
                        <div>
                            <p class="font-size-sm font-style-2 color-3 gray-highlight">by ${book.author}</p>
                            <p class="font-size-s font-style-2 color-3  py-1 gray-highlight">Rating: ${book.rating}/5</p>
                            <p class="py-1 d-flex justify-between align-center">
                                <a href="AddCart?book_id=${book.book_id}">
                                    <span class="add-to-cart font-size-lg px-half  gray-highlight">+</span>
                                </a>
                                <span class="font-size-md color-5 font-style-2 gray-highlight">$${book.cost}</span>
                            </p>
                        </div>
                    </div>
                </article>
            </c:forEach>
        </section>
    </section>

    <!-- Academic Books -->
    <section class="book-genre-container mx-auto p-1 ">
        <h4 class="font-style-2 font-size-md color-2  border-bottom my-1 py-1 black-highlight pointer"><img
                src="assets/images/opportunity.svg" alt="non-fiction" class="category-heading-icons mr-half">Academic Books</h4>
        <section class="book-cards-container d-flex flex-wrap justify-between">
            <h2 class="d-none">This is hidden</h2>
            <c:forEach var="book" items="${academic_books}">
                <article class="book-card bg-white my-1">
                    <h2 class="d-none">This is hidden</h2>
                    <a href="Detail?book_id=${book.book_id}">
                        <img class= "book-card-img d-block" src="data:image/jpg;base64,${book.base64Image}" alt="academic-img">
                    </a>

                    <div class="p-half pointer d-flex flex-column justify-between h-200">
                        <p class="font-style-1 font-size-md color-3 py-1 gray-highlight">${book.title}</p>
                        <div>
                            <p class="font-size-sm font-style-2 color-3 gray-highlight">by ${book.author}</p>
                            <p class="font-size-s font-style-2 color-3  py-1 gray-highlight">Rating: ${book.rating}/5</p>
                            <p class="py-1 d-flex justify-between align-center">
                                <a href="AddCart?book_id=${book.book_id}">
                                    <span class="add-to-cart font-size-lg px-half  gray-highlight">+</span>
                                </a>
                                <span class="font-size-md color-5 font-style-2 gray-highlight">$${book.cost}</span>
                            </p>
                        </div>
                    </div>
                </article>
            </c:forEach>
        </section>
    </section>

    <section class="deal">

        <div class="content">
            <h3>deal of the day</h3>
            <h1>upto 50% off</h1>
            <p>Buy now to receive a lot of good deal. I believe that, you will pleasure for this services.</p>
            <a href="#" class="btn">shop now</a>
        </div>

        <div class="image">
            <img src="image/deal-img.jpg" alt="">
        </div>

    </section>


</main>

<footer class="bg-white border">
    <section class="d-flex flex-wrap justify-around footer-links-container mx-auto">
        <h2 class="d-none">This is hidden</h2>
        <div class="p-1">
            <div class="d-flex justify-center align-center">
                <img src="./assets/images/book-gray.svg" alt="bookshop-logo">
                <span class="color-2 font-style-3 font-size-md pl-1">DANDELION FIELD</span>
            </div>
            <p class="font-style-2 color-2 font-size-sm py-half">
                Dandelion Field is a market place for books. Here you can find<br>
                a huge collection of books. You can browse through our<br>
                search box. Our search algorithm will help you find your<br>
                preferred books. </p>
        </div>

        <div class="flex-grow-1 p-1">
            <p class="font-style-2 color-1 font-size-s  border-bottom-2">Categories</p>
            <ul class="list-style-none py-half">
                <li class="font-style-2 color-2 font-size-sm underline pointer py-half">Non Fiction</li>
                <li class="font-style-2 color-2 font-size-sm underline pointer py-half">Fiction</li>
                <li class="font-style-2 color-2 font-size-sm underline pointer py-half">Academic</li>
            </ul>
        </div>

        <div class="flex-grow-1 p-1">
            <p class="font-style-2 color-1 font-size-s  border-bottom-2">Navigation</p>
            <ul class="list-style-none py-half">
                <li class="font-style-2 color-2 font-size-sm underline pointer py-half">Home</li>
                <li class="font-style-2 color-2 font-size-sm underline pointer py-half">Sign In</li>
                <li class="font-style-2 color-2 font-size-sm underline pointer py-half">Sign Up</li>
                <li class="font-style-2 color-2 font-size-sm underline pointer py-half">Terms & Conditions</li>
                <li class="font-style-2 color-2 font-size-sm underline pointer py-half">FAQ</li>
                <li class="font-style-2 color-2 font-size-sm underline pointer py-half">Help</li>
            </ul>
        </div>
        <div class="flex-grow-1 d-flex flex-column p-1 location-info">
            <ul class="list-style-none">
                <li class="font-style-3 color-1 font-size-s py-half">COUNTRY<span
                        class="font-style-2 color-3 font-size-sm border px-half ml-half pointer">United States</span></li>
                <li class="font-style-3 color-1 font-size-s  py-half">LANGUAGE<span
                        class="font-style-2 color-3 font-size-sm border px-half ml-half pointer">English</span></li>
                <li class="font-style-3 color-1 font-size-s  py-half">CURRENCY<span
                        class="font-style-2 color-3 font-size-sm border px-half ml-half pointer">US Dollar</span></li>
            </ul>
        </div>
    </section>
    <section class="border">
        <h2 class="d-none">This is hidden</h2>
        <div class="copyright-section p-1 mx-auto d-flex justify-between align-center">
            <p class="font-size-sm font-style-1 color-2">Copyright&copy; 2021 bookshop.com.</p>
            <ul class="list-style-none d-flex">
                <li><img src="./assets/images/twitter.svg" alt="twitter-logo" class="d-block category-heading-icons pointer ml-half"></li>
                <li><img src="./assets/images/google.svg" alt="google-logo" class="d-block category-heading-icons pointer ml-half"></li>
                <li><img src="./assets/images/facebook.svg" alt="facebook-logo" class="d-block category-heading-icons pointer ml-half"></li>
                <li><img src="./assets/images/linkedin.svg" alt="linkedin-logo" class="d-block category-heading-icons pointer ml-half"></li>
            </ul>
        </div>
    </section>
</footer>

<script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
<!-- custom js file link  -->
<script src="script.js"></script>
</body>

</html>