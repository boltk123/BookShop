<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/e487c6bc79.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/shopping_list.css">
    <title>Shopping Cart</title>
</head>
<body>
<div class="container">
    <div class="column-left">
        <div class="sub-container">
            <div id="shopping-cart">
                <div class="shopping-cart-title">My Shopping Cart</div>

                <div class="shopping-cart-item">
                    <div class="message">(3) Items from Barnes & Noble</div>
                    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                    <c:forEach var="book_item" items="${book_items}">
                        <div class="item">
                            <div class="item-name">
                                <a href="">The Man Who Died Twice (B&N Exclusive Edition) (Thursday Murder Club Series #2)</a>
                            </div>
                            <div class="director">By: Richard Osman</div>

                            <div class="item-details">
                                <div class="book-detail">
                                    <a class="book-img" src="#"><img src="image/first-book.jpg" alt=""></a>
                                    <p class="book-format">Hardcover</p>
                                </div>
                                <div class="shipping-detail">
                                    <div class="ship-to-home">
                                        <label class="radio-label-container" for="ship-this">
                                            <input type="radio" class="ship-this" checked>
                                            <span class="radio-circle"></span>
                                            <p>Ship this item</p>
                                        </label>
                                    </div>

                                    <p class="make-at-gift"><a href="">Make It a Gift</a> (optional)</p>

                                    <div class="pick-in-store">
                                        <label class="radio-label-container" for="buy-online">
                                            <input type="radio" class="buy-online" disabled>
                                            <span class="radio-circle"></span>
                                            <p>Buy Online, Pick up in Store</p>
                                        </label>
                                    </div>

                                    <a href="" class="find-my-store">Find My Store</a>

                                    <div class="remove-save">
                                        <a href="" class="remove">Remove</a>
                                        <a href="" class="save-for-later">Save for Later</a>
                                    </div>
                                </div>
                                <div class="price-detail">
                                    <div class="retail-discounted-price">
                                        <p class="retail-price">$26.00</p>
                                        <p class="discounted-price">$19.99</p>
                                    </div>
                                    <div class="quantity"><input type="text" value="1"></div>
                                    <div class="total-price">
                                        <p>$19.99</p>
                                    </div>
                                </div>
                            </div>

                            <div class="expedited-shipping">
                                <i>Choose Expedited Shipping at checkout for delivery by Wednesday, November 10</i>
                            </div>

                            <div class="horizontal-line"></div>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <div class="recent-view">

            </div>
        </div>
    </div>

    <div class="column-right stick">
        <div id="order-summary">
            <p class="head-title">Oder Summary</p>
            <div class="order-infos">
                <div class="order-info">
                    <p class="item">Subtotal (2 items)</p>
                    <p class="price">$42.94</p>
                </div>
                <div class="order-info">
                    <p class="item">Estimated Shipping</p>
                    <p class="price">Free</p>
                </div>
                <div class="order-info">
                    <p class="item">Estimated Tax</p>
                    <p class="price">$0.00</p>
                </div>
            </div>

            <div class="horizontal-line"></div>

            <div class="order-total">
                Order Total:
                <div class="order-total-price">$42.94</div>
            </div>

            <div class="checkout">
                <button class="checkout-btn">Checkout</button>
                <div class="checkout-with">
                    <p class="title">Or Checkout With</p>
                    <div id="paypal-checkout"><img src="image/paypal-checkout.png" alt="Paypal"></div>
                    <div id="other-checkout"><img src="image/other-checkout.png" alt="Other cards"></div>
                </div>
            </div>
        </div>

        <div id="apply-coupon">
            <div class="input-field">
                <input type="text" id="input-coupon" placeholder="Apply Coupon Code">
            </div>
            <button id="apply-btn">Apply</button>
        </div>

        <div id="have-membership">
            <p class="title">Have a BN Membership?</p>
            <p><a href="#" class="sign-in">Sign In</a> and add your member number to your account to start enjoying free Shipping today!</p>
        </div>
    </div>
    <div class="clear"></div>
</div>
</body>
</html>