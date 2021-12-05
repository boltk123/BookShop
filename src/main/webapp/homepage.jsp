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
<header>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <nav class="bg-color-3 d-flex justify-around p-1">
        <ul class="list-style-none d-flex align-center justify-center">
            <li>
                <a href="HomePage" class="image-highlight">
                    <img src="./assets/images/book.svg" alt="bookshop-logo">
                    <span class="color-white font-style-3 font-size-md pl-1">BOOKSHOP</span>
                </a>
            </li>
            <li class="pl-2 d-none visible-in-md">
                <a href="HomePage">
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
            <li class="pl-2"><c:if test = "${sessionScope.account.role == 'admin'}">
                <button type="button"
                        class="d-none stock-btn default-btn font-size-sm font-style-2 bg-color-1">
                    <a href="AdminDashboard" class="image-highlight">ADMIN</a>
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
                <a href="Account">
                    <span class="color-white font-style-3 font-size-sm pl-1 gray-highlight user-status">${indexmessage}</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <img src="./assets/images/person.svg" alt="user-img" class="image-highlight pl-1">
                </a>
            </li>
            <li class="pl-1">
                <a href="#" class="search-btn default-btn font-size-sm font-style-2 bg-color-1">SEARCH</a>
            </li>
        </ul>
    </nav>

    <section class="hero-section d-none flex-column align-center justify-center p-3">
        <h1 class="hero-title font-style-2 color-white p-1">BOOKSHOP</h1>
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
    <!-- Featured Book -->
    <div class="bg-white border">
        <section class="featured-book mx-auto p-1">
            <h1 class="font-style-2 font-size-md color-2 black-highlight pointer">FEATURED BOOK</h1>
            <article class="d-flex justify-between py-1">
                <img src="assets/images/siddhartha.jpg" alt="siddhartha" class="d-block h-200">
                <div class="ml-1 d-flex flex-column justify-between">
                    <h4 class="font-style-2 font-size-md color-1 pointer black-highlight">Siddhartha: A Novel <span
                            class="font-style-1 font-size-md color-2 black-highlight">by Hermann Hesse, Hilda Rosner
                                (Translator)</span>
                    </h4>
                    <p class="font-style-1 font-size-s color-3 py-1 d-none visible-in-sm gray-highlight pointer">
                        Herman Hesse's classic novel
                        has delighted, inspired, and influenced generations of readers,
                        writers, and thinkers. In this story of a wealthy Indian Brahmin who casts off a life of
                        privilege to seek spiritual fulfillment.</p>
                    <p class="font-size-md font-style-2 color-3 gray-highlight pointer">Rating: 4/5</p>
                    <div class="d-flex flex-column purchase-details-container">
                        <a href="#" class="default-btn font-size-md font-style-2 bg-color-1 mr-half my-half">$5.49</a>
                        <a href="#" class="default-btn font-size-sm font-style-2 bg-color-1 mr-half my-half"><img
                                src="./assets/images/supermarket-white.svg" alt="cart-logo-2"><span
                                class="pl-1">Purchase
                                    Details</span></a>
                    </div>
                </div>
            </article>
        </section>
    </div>

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
                                <span class="font-size-md color-1 font-style-2 gray-highlight">$${book.cost}</span>
                            </p>
                        </div>
                    </div>
                </article>
            </c:forEach>
        </section>
    </section>
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
                                <span class="font-size-md color-1 font-style-2 gray-highlight">$${book.cost}</span>
                            </p>
                        </div>
                    </div>
                </article>
            </c:forEach>
        </section>
    </section>
    <!-- Academic Books -->
    <section class="book-genre-container mx-auto p-1">
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
                                <span class="font-size-md color-1 font-style-2 gray-highlight">$${book.cost}</span>
                            </p>
                        </div>
                    </div>
                </article>
            </c:forEach>
        </section>
    </section>
</main>

<footer class="bg-white border">
    <section class="d-flex flex-wrap justify-around footer-links-container mx-auto">
        <h2 class="d-none">This is hidden</h2>
        <div class="p-1">
            <div class="d-flex justify-center align-center">
                <img src="./assets/images/book-gray.svg" alt="bookshop-logo">
                <span class="color-2 font-style-3 font-size-md pl-1">BOOKSHOP</span>
            </div>
            <p class="font-style-2 color-2 font-size-sm py-half">
                Bookshop is a market place for books. Here you can find<br>
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
</body>

</html>