<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin books</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/homepage.css">
    <link rel="stylesheet" href="css/table.css">
</head>
<body>
<header>
    <nav class="bg-color-3 d-flex justify-around p-1">
        <ul class="list-style-none d-flex align-center justify-center">
            <li>
                <a href="/index.jsp" class="image-highlight">
                    <img src="./assets/images/book.svg" alt="bookshop-logo">
                    <span class="color-white font-style-3 font-size-md pl-1">BOOKSHOP</span>
                </a>
            </li>
            <li class="pl-2 d-none visible-in-md">
                <a href="/index.jsp">
                    <img src="./assets/images/home-run.svg" alt="home-logo" class="navbar-icon">
                    <span class="color-1 font-style-1 font-size-sm pl-1 white-highlight">HOME</span>
                </a>
            </li>
            <li class="pl-2 d-none visible-in-md">
                <a href="#">
                    <img src="./assets/images/bookshelf.svg" alt="collection-logo" class="navbar-icon">
                    <span class="color-2 font-style-1 font-size-sm pl-1 white-highlight">COLLECTIONS</span>
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
                <a href="#">
                    <span class="color-white font-style-3 font-size-sm pl-1 gray-highlight">User Name</span>
                </a>
            </li>
            <li>
                <a href="#">
                    <img src="./assets/images/person.svg" alt="user-img" class="image-highlight pl-1">
                </a>
            </li>
            <li class="pl-1">
                <a href="search.html" class="search-btn default-btn font-size-sm font-style-2 bg-color-1">Search</a>
            </li>
        </ul>
    </nav>

    <section class="hero-section d-none flex-column p-1">
        <h2 class="d-none">This is added to remove validators errors.</h2>
        <div class="mx-auto">
            <h1 class="hero-title font-style-2 color-white">BOOKSHOP</h1>
            <h4 class="font-style-1 color-white font-size-md py-1">Search for your desired book</h4>
            <form action="#" class="hero-form d-flex align-center py-1">
                <select name="genre" class="genre-selector border-0 bg-white border-right flex-grow-1 pointer">
                    <option value="all" class="genre-selector">All genre</option>
                    <option value="non-fiction" class="genre-selector">Non Fiction</option>
                    <option value="fiction" class="genre-selector" selected>Fiction</option>
                    <option value="academic" class="genre-selector">Academic</option>
                </select>
                <input type="text" placeholder="What do you search for ?" value="philosophy"
                       class="p-1 border-0 font-style-1 font-size-sm border-right flex-grow-1 pointer">
                <input type="text" value="life" placeholder="Search..."
                       class="p-1 border-0 font-style-1 font-size-sm flex-grow-1 pointer">
                <a href="search.html" class="default-btn font-size-sm font-style-2 bg-color-3 ml-1">Search</a>
            </form>
        </div>
    </section>
</header>

<main class="d-flex justify-around">
    <!--Sidebar-->
    <div class="bg-color-3">
        <div class="color-white">
            <div class="bg-color-3 d-flex">
                <a href="homepage.jsp" class="image-highlight">
                    <img src="./assets/images/book.svg" alt="bookshop-logo">
                    <span class="color-white font-style-3 font-size-md pl-1">BOOKSHOP</span>
                </a>
                <div class="bg-color-3">
                    <div class="iq-menu-bt align-self-center">
                        <div class="wrapper-menu">
                            <div class="main-circle">
                                <i class="las la-bars"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="sidebar-scrollbar">
                <nav class="bg-color-4">
                    <ul id="iq-sidebar-toggle" class="list-style-none">
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
    <!-- Content Page -->
    <section class="">
        <h4 class="font-style-1 font-size-s color-2 p-1 border-bottom-3">Books Lists</h4>
        <a href="admin-add-category.html" class="btn btn-primary">Add New Book</a>
        <div class="">
            <div class="table-wrapper">
                <table class="fl-table">
                    <thead>
                    <tr>
                        <th style="width: 3%;">No</th>
                        <th style="width: 12%;">Book Image</th>
                        <th style="width: 15%;">Book Name</th>
                        <th style="width: 15%;">Book Catrgory</th>
                        <th style="width: 15%;">Book Author</th>
                        <th style="width: 18%;">Book Description</th>
                        <th style="width: 7%;">Book Price</th>
                        <th style="width: 7%;">Book pdf</th>
                        <th style="width: 15%;">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td><img class="img-fluid rounded" src="images/browse-books/01.jpg" alt=""></td>
                        <td>Reading on the Worlds</td>
                        <td>General Books</td>
                        <td>Jhone Steben</td>
                        <td>
                            <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed rhoncus non elit a scelerisque. Etiam feugiat luctus est, vel commodo odio rhoncus sit amet</p>
                        </td>
                        <td>$89</td>
                        <td><a href="book-pdf.html"><i class="ri-file-fill text-secondary font-size-18"></i></a></td>
                        <td>
                            <div class="flex align-items-center list-user-action">
                                <a class="bg-primary" data-toggle="tooltip" data-placement="top" title="" data-original-title="Edit" href="admin-add-book.html"><i class="ri-pencil-line"></i></a>
                                <a class="bg-primary" data-toggle="tooltip" data-placement="top" title="" data-original-title="Delete" href="#"><i class="ri-delete-bin-line"></i></a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td><img class="img-fluid rounded" src="images/browse-books/02.jpg" alt=""></td>
                        <td>The Catcher in the Rye</td>
                        <td>History Books</td>
                        <td>Fritz Wold</td>
                        <td>
                            <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed rhoncus non elit a scelerisque. Etiam feugiat luctus est, vel commodo odio rhoncus sit amet</p>
                        </td>
                        <td>$89</td>
                        <td><a href="book-pdf.html"><i class="ri-file-fill text-secondary font-size-18"></i></a></td>
                        <td>
                            <div class="flex align-items-center list-user-action">
                                <a class="bg-primary" data-toggle="tooltip" data-placement="top" title="" data-original-title="Edit" href="admin-add-book.html"><i class="ri-pencil-line"></i></a>
                                <a class="bg-primary" data-toggle="tooltip" data-placement="top" title="" data-original-title="Delete" href="#"><i class="ri-delete-bin-line"></i></a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td><img class="img-fluid rounded" src="images/browse-books/03.jpg" alt=""></td>
                        <td>Little Black Book</td>
                        <td>Comic Books</td>
                        <td>John Klok</td>
                        <td>
                            <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed rhoncus non elit a scelerisque. Etiam feugiat luctus est, vel commodo odio rhoncus sit amet</p>
                        </td>
                        <td>$129</td>
                        <td><a href="book-pdf.html"><i class="ri-file-fill text-secondary font-size-18"></i></a></td>
                        <td>
                            <div class="flex align-items-center list-user-action">
                                <a class="bg-primary" data-toggle="tooltip" data-placement="top" title="" data-original-title="Edit" href="admin-add-book.html"><i class="ri-pencil-line"></i></a>
                                <a class="bg-primary" data-toggle="tooltip" data-placement="top" title="" data-original-title="Delete" href="#"><i class="ri-delete-bin-line"></i></a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td><img class="img-fluid rounded" src="images/browse-books/04.jpg" alt=""></td>
                        <td>Take On The Risk</td>
                        <td>General Books</td>
                        <td>George Strong</td>
                        <td>
                            <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed rhoncus non elit a scelerisque. Etiam feugiat luctus est, vel commodo odio rhoncus sit amet</p>
                        </td>
                        <td>$89</td>
                        <td><a href="book-pdf.html"><i class="ri-file-fill text-secondary font-size-18"></i></a></td>
                        <td>
                            <div class="flex align-items-center list-user-action">
                                <a class="bg-primary" data-toggle="tooltip" data-placement="top" title="" data-original-title="Edit" href="admin-add-book.html"><i class="ri-pencil-line"></i></a>
                                <a class="bg-primary" data-toggle="tooltip" data-placement="top" title="" data-original-title="Delete" href="#"><i class="ri-delete-bin-line"></i></a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>5</td>
                        <td><img class="img-fluid rounded" src="images/browse-books/05.jpg" alt=""></td>
                        <td>Absteact On Background</td>
                        <td>Film & Photography</td>
                        <td>Ichae Semos</td>
                        <td>
                            <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed rhoncus non elit a scelerisque. Etiam feugiat luctus est, vel commodo odio rhoncus sit amet</p>
                        </td>
                        <td>$99</td>
                        <td><a href="book-pdf.html"><i class="ri-file-fill text-secondary font-size-18"></i></a></td>
                        <td>
                            <div class="flex align-items-center list-user-action">
                                <a class="bg-primary" data-toggle="tooltip" data-placement="top" title="" data-original-title="Edit" href="admin-add-book.html"><i class="ri-pencil-line"></i></a>
                                <a class="bg-primary" data-toggle="tooltip" data-placement="top" title="" data-original-title="Delete" href="#"><i class="ri-delete-bin-line"></i></a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>6</td>
                        <td><img class="img-fluid rounded" src="images/browse-books/06.jpg" alt=""></td>
                        <td>Find The Wave Book</td>
                        <td>General Books</td>
                        <td>Fidel Martin</td>
                        <td>
                            <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed rhoncus non elit a scelerisque. Etiam feugiat luctus est, vel commodo odio rhoncus sit amet</p>
                        </td>
                        <td>$100</td>
                        <td><a href="book-pdf.html"><i class="ri-file-fill text-secondary font-size-18"></i></a></td>
                        <td>
                            <div class="flex align-items-center list-user-action">
                                <a class="bg-primary" data-toggle="tooltip" data-placement="top" title="" data-original-title="Edit" href="admin-add-book.html"><i class="ri-pencil-line"></i></a>
                                <a class="bg-primary" data-toggle="tooltip" data-placement="top" title="" data-original-title="Delete" href="#"><i class="ri-delete-bin-line"></i></a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>7</td>
                        <td><img class="img-fluid rounded" src="images/browse-books/07.jpg" alt=""></td>
                        <td>See the More Story</td>
                        <td>Horror Story</td>
                        <td>Jules Boutin</td>
                        <td>
                            <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed rhoncus non elit a scelerisque. Etiam feugiat luctus est, vel commodo odio rhoncus sit amet</p>
                        </td>
                        <td>$79</td>
                        <td><a href="book-pdf.html"><i class="ri-file-fill text-secondary font-size-18"></i></a></td>
                        <td>
                            <div class="flex align-items-center list-user-action">
                                <a class="bg-primary" data-toggle="tooltip" data-placement="top" title="" data-original-title="Edit" href="admin-add-book.html"><i class="ri-pencil-line"></i></a>
                                <a class="bg-primary" data-toggle="tooltip" data-placement="top" title="" data-original-title="Delete" href="#"><i class="ri-delete-bin-line"></i></a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>8</td>
                        <td><img class="img-fluid rounded" src="images/browse-books/08.jpg" alt=""></td>
                        <td>The Wikde Book</td>
                        <td> Computers & Internet</td>
                        <td>Kusti Franti</td>
                        <td>
                            <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed rhoncus non elit a scelerisque. Etiam feugiat luctus est, vel commodo odio rhoncus sit amet</p>
                        </td>
                        <td>$89</td>
                        <td><a href="book-pdf.html"><i class="ri-file-fill text-secondary font-size-18"></i></a></td>
                        <td>
                            <div class="flex align-items-center list-user-action">
                                <a class="bg-primary" data-toggle="tooltip" data-placement="top" title="" data-original-title="Edit" href="admin-add-book.html"><i class="ri-pencil-line"></i></a>
                                <a class="bg-primary" data-toggle="tooltip" data-placement="top" title="" data-original-title="Delete" href="#"><i class="ri-delete-bin-line"></i></a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>9</td>
                        <td><img class="img-fluid rounded" src="images/browse-books/09.jpg" alt=""></td>
                        <td>Conversion Erik Routley</td>
                        <td>Sports</td>
                        <td>Argele Intili</td>
                        <td>
                            <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed rhoncus non elit a scelerisque. Etiam feugiat luctus est, vel commodo odio rhoncus sit amet</p>
                        </td>
                        <td>$79</td>
                        <td><a href="book-pdf.html"><i class="ri-file-fill text-secondary font-size-18"></i></a></td>
                        <td>
                            <div class="flex align-items-center list-user-action">
                                <a class="bg-primary" data-toggle="tooltip" data-placement="top" title="" data-original-title="Edit" href="admin-add-book.html"><i class="ri-pencil-line"></i></a>
                                <a class="bg-primary" data-toggle="tooltip" data-placement="top" title="" data-original-title="Delete" href="#"><i class="ri-delete-bin-line"></i></a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>10</td>
                        <td><img class="img-fluid rounded" src="images/browse-books/10.jpg" alt=""></td>
                        <td>The Leo Dominica</td>
                        <td>General Books</td>
                        <td>Henry Jurk</td>
                        <td>
                            <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed rhoncus non elit a scelerisque. Etiam feugiat luctus est, vel commodo odio rhoncus sit amet</p>
                        </td>
                        <td>$99</td>
                        <td><a href="book-pdf.html"><i class="ri-file-fill text-secondary font-size-18"></i></a></td>
                        <td>
                            <div class="flex align-items-center list-user-action">
                                <a class="bg-primary" data-toggle="tooltip" data-placement="top" title="" data-original-title="Edit" href="admin-add-book.html"><i class="ri-pencil-line"></i></a>
                                <a class="bg-primary" data-toggle="tooltip" data-placement="top" title="" data-original-title="Delete" href="#"><i class="ri-delete-bin-line"></i></a>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    </section>
</main>

<footer class="bg-white border">
    <section class="d-flex flex-wrap justify-around footer-links-container mx-auto">
        <h1 class="d-none">This is hidden</h1>
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
                <li class="font-style-2 color-2 font-size-sm underline pointer py-half"><a href="index.jsp" class="d-block">Home</a></li>
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
                        class="font-style-2 color-3 font-size-sm border px-half ml-half pointer">United
                            States</span></li>
                <li class="font-style-3 color-1 font-size-s  py-half">LANGUAGE<span
                        class="font-style-2 color-3 font-size-sm border px-half ml-half pointer">English</span></li>
                <li class="font-style-3 color-1 font-size-s  py-half">CURRENCY<span
                        class="font-style-2 color-3 font-size-sm border px-half ml-half pointer">US Dollar</span>
                </li>
            </ul>
        </div>
    </section>
    <section class="border">
        <h1 class="d-none">This is hidden</h1>
        <div class="copyright-section p-1 mx-auto d-flex justify-between align-center">
            <p class="font-size-sm font-style-1 color-2">Copyright&copy; 2020 bookshop.com. All rights reserved</p>
            <ul class="list-style-none d-flex">
                <li><img src="./assets/images/twitter.svg" alt="twitter-logo"
                         class="d-block category-heading-icons pointer ml-half"></li>
                <li><img src="./assets/images/google.svg" alt="google-logo"
                         class="d-block category-heading-icons pointer ml-half"></li>
                <li><img src="./assets/images/facebook.svg" alt="facebook-logo"
                         class="d-block category-heading-icons pointer ml-half"></li>
                <li><img src="./assets/images/linkedin.svg" alt="linkedin-logo"
                         class="d-block category-heading-icons pointer ml-half"></li>
            </ul>
        </div>
    </section>
</footer>

</body>
</html>