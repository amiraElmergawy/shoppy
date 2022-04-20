
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <!-- header left mobie -->

        <div class="header-mobile d-md-none " style="background-color: black">
            <div class="mobile hidden-md-up text-xs-center d-flex align-items-center justify-content-around">


                <!-- menu left -->
                <div class="mobile-menutop" data-target="#mobile-pagemenu">
                    <i class="fa fa-bars" aria-hidden="true"></i>
                </div>

                <!-- logo -->
                <div class="mobile-logo">
                    <a href="home">
                        <img class="logo-mobile img-fluid" src="assets/images/home/mobil-logo.png" width="160px" alt="Prestashop_Furnitica">
                    </a>
                </div>
                <div id="block_myaccount_infos header-cart" class="hidden-sm-down dropdown" style="
        margin-top: auto;
        margin-left: 0rem;
    ">

                </div>
            </div>

            <!-- search -->
            <div id="mobile_search" class="d-flex">
                <div id="mobile_search_content">
                    <form method="get" action="#">
                        <input type="text" name="s" value="" placeholder="Search">
                        <button type="submit">
                            <i class="fa fa-search"></i>
                        </button>
                    </form>
                </div>

                <div class="desktop_cart">
                    <div class="blockcart block-cart cart-preview tiva-toggle">
                        <a href="shopping-cart">
                        <div class="header-cart tiva-toggle-btn">
<%--                            <span class="cart-products-count">1</span>--%>
                            <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                        </div>
                        </a>

                    </div>
                </div>
            </div>
        </div>


    <!-- header desktop -->

    <div class="header-top d-xs-none ">
        <div class="container">
            <div class="row">
                <!-- logo -->
                <div class="col-sm-2 col-md-2 d-flex align-items-center">
                    <div id="logo">
                        <a href="home">
                            <img src="assets/images/home/llogo.png" alt="logo" class="img-fluid">
                        </a>
                    </div>
                </div>

                <!-- menu -->
                <div class="main-menu col-sm-3 col-md-3 align-items-center justify-content-center navbar-expand-md">
                    <div class="menu navbar collapse navbar-collapse">
                        <ul class="menu-top navbar-nav">
                            <li class="nav-link">
                                <a href="home" class="parent">Home</a>

                            </li>
                            <li>
                                <a href="about-us" class="parent">About US</a>
                            </li>
                        </ul>
                    </div>
                </div>
<%--                <div class="col-sm-5 col-md-5 align-items-center justify-content-center navbar-expand-md main-menu">--%>
<%--                    <div class="menu navbar collapse navbar-collapse">--%>
<%--                        <ul class="menu-top navbar-nav">--%>
<%--                            <li>--%>
<%--                                <a href="home" class="parent">Home</a>--%>

<%--                            </li>--%>
<%--                            <li>--%>
<%--                                <a href="about-us" class="parent">About Us</a>--%>
<%--                            </li>--%>

<%--                            <li class="nav-link">--%>
<%--                                <a href="#" class="parent">Contact US</a>--%>
<%--                            </li>--%>
<%--                        </ul>--%>
<%--                    </div>--%>
<%--                </div>--%>

                <!-- search and acount -->
                <div class="col-sm-7 col-md-7 d-flex align-items-center justify-content-end" id="search_widget">
                    <form method="get" action="search">
                        <span role="status" aria-live="polite" class="ui-helper-hidden-accessible"></span>
                        <input type="text" name="key" value="" placeholder="Search" class="ui-autocomplete-input w-100" autocomplete="off">
                        <button type="submit">
                            <i class="fa fa-search"></i>
                        </button>
                    </form>

                    <div id="block_myaccount_infos" class="hidden-sm-down dropdown mr-4">
                        <div class="myaccount-title ">
                            <a href="#acount" data-toggle="collapse" class="acount">
                                <i class="fa fa-user" aria-hidden="true"></i>
                                <span>Account</span>
                                <i class="fa fa-angle-down" aria-hidden="true"></i>
                            </a>
                        </div>

                        <div id="acount" class="collapse">

                            <div class="account-list-content">

                               <c:if test="${userId!=null}">
                                   <div>
                                       <a class="login" href="profile" rel="nofollow" title="Log in to your customer account">
                                           <i class="fa fa-cog"></i>
                                           <span>My Account</span>
                                       </a>
                                   </div>
                               </c:if>
                                <c:if test="${userId==null}">
                                <div>
                                    <a class="login" href="login" rel="nofollow" title="Log in to your customer account">
                                        <i class="fa fa-sign-in"></i>
                                        <span>Sign in</span>
                                    </a>
                                </div>
                                </c:if>
                                <c:if test="${userId!=null}">
                                <div>
                                    <a class="register" href="login" rel="nofollow" title="Register Account">
                                        <i class="fa fa-sign-out" aria-hidden="true"></i>
                                        <span>Logout</span>
                                    </a>
                                </div>
                                </c:if>

                            </div>
                        </div>
                    </div>
                    <div class="desktop_cart">
                        <div class="blockcart block-cart cart-preview tiva-toggle">
                            <a href="shopping-cart">
                            <div class="header-cart tiva-toggle-btn ml-0">
<%--                                <span class="cart-products-count">${cart.getOrderProducts().size()}</span>--%>
                                <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                            </div>
                            </a>
<%--                            <div class="dropdown-content">--%>
<%--                                <div class="cart-content">--%>
<%--                                    <table>--%>
<%--                                        <tbody>--%>
<%--                                        <tr>--%>
<%--                                            <td class="product-image">--%>
<%--                                                <a href="product-detail.html">--%>
<%--                                                    <img src="assets/images/product/5.jpg" alt="Product">--%>
<%--                                                </a>--%>
<%--                                            </td>--%>
<%--                                            <td>--%>
<%--                                                <div class="product-name">--%>
<%--                                                    <a href="product-detail.html">Organic Strawberry Fruits</a>--%>
<%--                                                </div>--%>
<%--                                                <div>--%>
<%--                                                    2 x--%>
<%--                                                    <span class="product-price">£28.98</span>--%>
<%--                                                </div>--%>
<%--                                            </td>--%>
<%--                                            <td class="action">--%>
<%--                                                <a class="remove" href="#">--%>
<%--                                                    <i class="fa fa-trash-o" aria-hidden="true"></i>--%>
<%--                                                </a>--%>
<%--                                            </td>--%>
<%--                                        </tr>--%>
<%--                                        <tr class="total">--%>
<%--                                            <td colspan="2">Total:</td>--%>
<%--                                            <td>£92.96</td>--%>
<%--                                        </tr>--%>

<%--                                        <tr>--%>
<%--                                            <td colspan="3" class="d-flex justify-content-center">--%>
<%--                                                <div class="cart-button">--%>
<%--                                                    <a href="shopping-cart" title="View Cart">View Cart</a>--%>
<%--                                                    <a href="product-checkout.html" title="Checkout">Checkout</a>--%>
<%--                                                </div>--%>
<%--                                            </td>--%>
<%--                                        </tr>--%>
<%--                                        </tbody>--%>
<%--                                    </table>--%>
<%--                                </div>--%>
<%--                            </div>--%>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>