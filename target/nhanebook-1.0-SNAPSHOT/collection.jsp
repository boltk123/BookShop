<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Collection</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/homepage.css">
</head>
<body>
<header>
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
                    <span class="color-2 font-style-1 font-size-sm pl-1 white-highlight">HOME</span>
                </a>
            </li>
            <li class="pl-2 d-none visible-in-md">
                <a href="collection.jsp">
                    <img src="./assets/images/bookshelf.svg" alt="collection-logo" class="navbar-icon">
                    <span class="color-1 font-style-1 font-size-sm pl-1 white-highlight">COLLECTIONS</span>
                </a>
            </li>
            <li class="pl-2">
                <a href="#">
                    <img src="./assets/images/supermarket.svg" alt="cart-logo" class="navbar-icon">
                    <span
                            class="color-2 font-style-1 font-size-sm pl-1 white-highlight d-none visible-in-md">PURCHASE
                            LIST</span>
                </a>
            </li>
            <li class="pl-2">
                <button type="button"
                        class="d-none stock-btn default-btn font-size-sm font-style-2 bg-color-1">REQUEST
                    FOR STOCK</button>
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
                <a href="uploader.jsp">
                    <span class="color-white font-style-3 font-size-sm pl-1 gray-highlight">User Name</span>
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

    <section class="hero-section d-none flex-column align-center justify-center p-3">
        <h1 class="hero-title font-style-2 color-white p-1">BOOKSHOP</h1>
        <h4 class="font-style-1 color-white font-size-md">An online market place for all kinds of books</h4>
        <form action="#" class="hero-form p-1 d-flex align-center">
            <select name="genre" class="genre-selector border-0 bg-white border-right flex-grow-1 pointer">
                <option value="all" class="genre-selector">All genre</option>
                <option value="non-fiction" class="genre-selector">Non Fiction</option>
                <option value="fiction" class="genre-selector">Fiction</option>
                <option value="academic" class="genre-selector">Academic</option>
            </select>
            <input type="text" placeholder="What do you search for ?"
                   class="p-1 border-0 font-style-1 font-size-sm border-right flex-grow-1 pointer">
            <input type="text" placeholder="Search..." class="p-1 border-0 font-style-1 font-size-sm flex-grow-1 pointer">
            <a href="search.jsp" class="default-btn font-size-sm font-style-2 bg-color-3 ml-1">Search</a>
        </form>
    </section>
</header>

<main class="pb-4">
    <div class="iq-sidebar">
        <div class="iq-sidebar-head">
            <a href="homepage.jsp" class="image-highlight">
                <img src="./assets/images/book.svg" alt="bookshop-logo">
                <span class="color-white font-style-3 font-size-md pl-1">BOOKSHOP</span>
            </a>
        </div>
        <div class="color-white">
            <div class="scroll-content">
                <nav class="iq-sidebar-menu">
                    <ul class="iq-menu">
                        <li class="bg-color-4">
                            <a href="#dashboard" class="bg-color-1 m-left font-style-3 p-1"><span class="ripple rippleEffect"></span><i class="las la-home iq-arrow-left"></i><span>Shop</span><i class="ri-arrow-right-s-line iq-arrow-right"></i></a>
                            <ul id="dashboard" class="bg-color-4 list-style-none m-left-1" data-parent="#iq-sidebar-toggle">
                                <li><a href="homepage.jsp"><i class="#"></i>Home Page</a></li>
                                <li><a href="collection.jsp"><i class="#"></i>Category Page</a></li>
                                <li><a href="#"><i class="#"></i>Book Page</a></li>
                                <li><a href="#"><i class="#"></i>Book PDF</a></li>
                                <li><a href="#"><i class="#"></i>Checkout</a></li>
                                <li><a href="#"><i class="#"></i>wishlist</a></li>
                            </ul>
                        </li>
                        <li class="bg-color-4">
                            <a href="#admin" class="bg-color-1 m-left font-style-3 p-1"><span class="ripple rippleEffect"></span><i class="ri-admin-line"></i><span>Admin</span><i class="ri-arrow-right-s-line iq-arrow-right"></i></a>
                            <ul id="admin" class="bg-color-4 list-style-none m-left-1" data-parent="#iq-sidebar-toggle">
                                <li><a href="admin-dashboard.jsp"><i class="#"></i>Dashboard</a></li>
                                <li><a href="admin-category.jsp"><i class="#"></i>Category Lists</a></li>
                                <li><a href="admin-author.jsp"><i class="#"></i>Author</a></li>
                                <li><a href="admin-books.jsp"><i class="#"></i>Books</a></li>
                            </ul>
                        </li>
                        <li class="bg-color-4">
                            <a href="#userinfo" class="bg-color-1 m-left font-style-3 p-1" data-toggle="collapse" aria-expanded="false"><span class="ripple rippleEffect"></span><i class="las la-user-tie iq-arrow-left"></i><span>User</span><i class="ri-arrow-right-s-line iq-arrow-right"></i></a>
                            <ul id="userinfo" class="bg-color-4 list-style-none m-left-1" data-parent="#iq-sidebar-toggle">
                                <li><a href="#"><i class="#"></i>User Profile</a></li>
                                <li><a href="#"><i class="#"></i>User Edit</a></li>
                                <li><a href="#"><i class="#"></i>User Add</a></li>
                                <li><a href="#"><i class="#"></i>User List</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>

</main>

</body>
</html>
