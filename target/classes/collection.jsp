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
    <div id="sidebar-scrollbar">
        <nav class="iq-sidebar-menu">
            <ul id="iq-sidebar-toggle" class="iq-menu">
                <li class="active active-menu">
                    <a href="#dashboard" class="iq-waves-effect" data-toggle="collapse" aria-expanded="true"><span class="ripple rippleEffect"></span><i class="las la-home iq-arrow-left"></i><span>Shop</span><i class="ri-arrow-right-s-line iq-arrow-right"></i></a>
                    <ul id="dashboard" class="iq-submenu collapse show" data-parent="#iq-sidebar-toggle">
                        <li><a href="#"><i class="las la-house-damage"></i>Home Page</a></li>
                        <li class="active"><a href="#"><i class="ri-function-line"></i>Category Page</a></li>
                        <li><a href="#"><i class="ri-book-line"></i>Book Page</a></li>
                        <li><a href="#"><i class="ri-file-pdf-line"></i>Book PDF</a></li>
                        <li><a href="#"><i class="ri-checkbox-multiple-blank-line"></i>Checkout</a></li>
                        <li><a href="#"><i class="ri-heart-line"></i>wishlist</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#admin" class="iq-waves-effect" data-toggle="collapse" aria-expanded="false"><span class="ripple rippleEffect"></span><i class="ri-admin-line"></i><span>Admin</span><i class="ri-arrow-right-s-line iq-arrow-right"></i></a>
                    <ul id="admin" class="iq-submenu collapse" data-parent="#iq-sidebar-toggle">
                        <li><a href="#"><i class="ri-dashboard-line"></i>Dashboard</a></li>
                        <li><a href="#"><i class="ri-list-check-2"></i>Category Lists</a></li>
                        <li><a href="#"><i class="ri-file-user-line"></i>Author</a></li>
                        <li><a href="#"><i class="ri-book-2-line"></i>Books</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#userinfo" class="iq-waves-effect" data-toggle="collapse" aria-expanded="false"><span class="ripple rippleEffect"></span><i class="las la-user-tie iq-arrow-left"></i><span>User</span><i class="ri-arrow-right-s-line iq-arrow-right"></i></a>
                    <ul id="userinfo" class="iq-submenu collapse" data-parent="#iq-sidebar-toggle" style="">
                        <li><a href="#"><i class="las la-id-card-alt"></i>User Profile</a></li>
                        <li><a href="#"><i class="las la-edit"></i>User Edit</a></li>
                        <li><a href="#"><i class="las la-plus-circle"></i>User Add</a></li>
                        <li><a href="#"><i class="las la-th-list"></i>User List</a></li>
                    </ul>
                </li>
                <!--<li>
                    <a href="#ui-elements" class="iq-waves-effect collapsed" data-toggle="collapse" aria-expanded="false"><i class="lab la-elementor iq-arrow-left"></i><span>UI Elements</span><i class="ri-arrow-right-s-line iq-arrow-right"></i></a>
                    <ul id="ui-elements" class="iq-submenu collapse" data-parent="#iq-sidebar-toggle">
                        <li class="elements">
                            <a href="#sub-menu" class="iq-waves-effect collapsed" data-toggle="collapse" aria-expanded="false"><i class="ri-play-circle-line"></i><span>UI Kit</span><i class="ri-arrow-right-s-line iq-arrow-right"></i></a>
                            <ul id="sub-menu" class="iq-submenu collapse" data-parent="#ui-elements">
                                <li><a href="#"><i class="las la-palette"></i>colors</a></li>
                                <li><a href="#"><i class="las la-keyboard"></i>Typography</a></li>
                                <li><a href="#"><i class="las la-tag"></i>Alerts</a></li>
                                <li><a href="#"><i class="lab la-atlassian"></i>Badges</a></li>
                                <li><a href="ui-breadcrumb.html"><i class="las la-bars"></i>Breadcrumb</a></li>
                                <li><a href="ui-buttons.html"><i class="las la-tablet"></i>Buttons</a></li>
                                <li><a href="ui-cards.html"><i class="las la-credit-card"></i>Cards</a></li>
                                <li><a href="ui-carousel.html"><i class="las la-film"></i>Carousel</a></li>
                                <li><a href="ui-embed-video.html"><i class="las la-video"></i>Video</a></li>
                                <li><a href="ui-grid.html"><i class="las la-border-all"></i>Grid</a></li>
                                <li><a href="ui-images.html"><i class="las la-images"></i>Images</a></li>
                                <li><a href="ui-list-group.html"><i class="las la-list"></i>list Group</a></li>
                                <li><a href="ui-media-object.html"><i class="las la-ad"></i>Media</a></li>
                                <li><a href="ui-modal.html"><i class="las la-columns"></i>Modal</a></li>
                                <li><a href="ui-notifications.html"><i class="las la-bell"></i>Notifications</a></li>
                                <li><a href="ui-pagination.html"><i class="las la-ellipsis-h"></i>Pagination</a></li>
                                <li><a href="ui-popovers.html"><i class="las la-eraser"></i>Popovers</a></li>
                                <li><a href="ui-progressbars.html"><i class="las la-hdd"></i>Progressbars</a></li>
                                <li><a href="ui-tabs.html"><i class="las la-database"></i>Tabs</a></li>
                                <li><a href="ui-tooltips.html"><i class="las la-magnet"></i>Tooltips</a></li>
                            </ul>
                        </li>
                        <li class="form">
                            <a href="#forms" class="iq-waves-effect collapsed" data-toggle="collapse" aria-expanded="false"><i class="lab la-wpforms"></i><span>Forms</span><i class="ri-arrow-right-s-line iq-arrow-right"></i></a>
                            <ul id="forms" class="iq-submenu collapse" data-parent="#ui-elements">
                                <li><a href="form-layout.html"><i class="las la-book"></i>Form Elements</a></li>
                                <li><a href="form-validation.html"><i class="las la-edit"></i>Form Validation</a></li>
                                <li><a href="form-switch.html"><i class="las la-toggle-off"></i>Form Switch</a></li>
                                <li><a href="form-chechbox.html"><i class="las la-check-square"></i>Form Checkbox</a></li>
                                <li><a href="form-radio.html"><i class="ri-radio-button-line"></i>Form Radio</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#wizard-form" class="iq-waves-effect collapsed" data-toggle="collapse" aria-expanded="false"><i class="ri-archive-drawer-line"></i><span>Forms Wizard</span><i class="ri-arrow-right-s-line iq-arrow-right"></i></a>
                            <ul id="wizard-form" class="iq-submenu collapse" data-parent="#ui-elements">
                                <li><a href="form-wizard.html"><i class="ri-clockwise-line"></i>Simple Wizard</a></li>
                                <li><a href="form-wizard-validate.html"><i class="ri-clockwise-2-line"></i>Validate Wizard</a></li>
                                <li><a href="form-wizard-vertical.html"><i class="ri-anticlockwise-line"></i>Vertical Wizard</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#tables" class="iq-waves-effect collapsed" data-toggle="collapse" aria-expanded="false"><i class="ri-table-line"></i><span>Table</span><i class="ri-arrow-right-s-line iq-arrow-right"></i></a>
                            <ul id="tables" class="iq-submenu collapse" data-parent="#ui-elements">
                                <li><a href="tables-basic.html"><i class="ri-table-line"></i>Basic Tables</a></li>
                                <li><a href="data-table.html"><i class="ri-database-line"></i>Data Table</a></li>
                                <li><a href="table-editable.html"><i class="ri-refund-line"></i>Editable Table</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#charts" class="iq-waves-effect collapsed" data-toggle="collapse" aria-expanded="false"><i class="ri-pie-chart-box-line"></i><span>Charts</span><i class="ri-arrow-right-s-line iq-arrow-right"></i></a>
                            <ul id="charts" class="iq-submenu collapse" data-parent="#ui-elements">
                                <li><a href="chart-morris.html"><i class="ri-file-chart-line"></i>Morris Chart</a></li>
                                <li><a href="chart-high.html"><i class="ri-bar-chart-line"></i>High Charts</a></li>
                                <li><a href="chart-am.html"><i class="ri-folder-chart-line"></i>Am Charts</a></li>
                                <li><a href="chart-apex.html"><i class="ri-folder-chart-2-line"></i>Apex Chart</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#icons" class="iq-waves-effect collapsed" data-toggle="collapse" aria-expanded="false"><i class="ri-list-check"></i><span>Icons</span><i class="ri-arrow-right-s-line iq-arrow-right"></i></a>
                            <ul id="icons" class="iq-submenu collapse" data-parent="#ui-elements">
                                <li><a href="icon-dripicons.html"><i class="ri-stack-line"></i>Dripicons</a></li>
                                <li><a href="icon-fontawesome-5.html"><i class="ri-facebook-fill"></i>Font Awesome 5</a></li>
                                <li><a href="icon-lineawesome.html"><i class="ri-keynote-line"></i>line Awesome</a></li>
                                <li><a href="icon-remixicon.html"><i class="ri-remixicon-line"></i>Remixicon</a></li>
                                <li><a href="icon-unicons.html"><i class="ri-underline"></i>unicons</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>

                <li>
                    <a href="#menu-level" class="iq-waves-effect collapsed" data-toggle="collapse" aria-expanded="false"><i class="ri-record-circle-line iq-arrow-left"></i><span>Menu Level</span><i class="ri-arrow-right-s-line iq-arrow-right"></i></a>
                    <ul id="menu-level" class="iq-submenu collapse" data-parent="#iq-sidebar-toggle">
                        <li><a href="#"><i class="ri-record-circle-line"></i>Menu 1</a></li>
                        <li>
                            <a href="#"><i class="ri-record-circle-line"></i>Menu 2</a>
                            <ul>
                                <li class="menu-level">
                                    <a href="#sub-menus" class="iq-waves-effect collapsed" data-toggle="collapse" aria-expanded="false"><i class="ri-play-circle-line"></i><span>Sub-menu</span><i class="ri-arrow-right-s-line iq-arrow-right"></i></a>
                                    <ul id="sub-menus" class="iq-submenu iq-submenu-data collapse">
                                        <li><a href="#"><i class="ri-record-circle-line"></i>Sub-menu 1</a></li>
                                        <li><a href="#"><i class="ri-record-circle-line"></i>Sub-menu 2</a></li>
                                        <li><a href="#"><i class="ri-record-circle-line"></i>Sub-menu 3</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li><a href="#"><i class="ri-record-circle-line"></i>Menu 3</a></li>
                        <li><a href="#"><i class="ri-record-circle-line"></i>Menu 4</a></li>
                    </ul>
                </li>-->
            </ul>
        </nav>

    <section>


    </section>
    </div>

</main>

</body>
</html>
