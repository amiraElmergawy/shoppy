<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.lang.Math" %>
<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if IE 9 ]><html class="ie ie9" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<!--<![endif]-->
<html lang="zxx">

<!-- index06:45-->
<head>
    <!-- Basic Page Needs -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Furnitica - Minimalist Furniture HTML Template</title>

    <%@ include file="../includes/customer-head.jsp" %>
    <style>

        .nivoSlider{
            height: 600px !important;
        }
        .img-responsive{
            display: block !important;
            position: relative !important;
            width: 100% !important;
            height: 100% !important;
            animation-delay: .1ms;
            animation-duration: .1ms;
        }

        @media screen and (max-width: 991px) {
            .nivoSlider {
                z-index: 2;
                height: 300px !important;
            }
        }


    </style>
</head>

<body id="home" >

<%@ include file="../includes/customer-header.jsp" %>








    <!-- main content -->
        <!-- main content -->
        <div  id="product-sidebar-left" class="product-grid-sidebar-left" style="margin-top: -50px;">
        <div class="main-content">
            <div class="wrap-banner">

                <!-- slide show -->
                <div class="section banner">
                    <div class="tiva-slideshow-wrapper">
                        <div id="tiva-slideshow" class="nivoSlider">
                            <a href="#">
                                <img class="img-responsive" src="../../../assets/images/home/home1-banner1.jpg" height="100%" title="#caption1" alt="Slideshow image">
                            </a>
                            <a href="#">
                                <img class="img-responsive" src="../../../assets/images/home/home1-banner2.jpg" height="100%" title="#caption2" alt="Slideshow image">
                            </a>
                            <a href="#">
                                <img class="img-responsive" src="../../../assets/images/home/home1-banner3.jpg" height="100%" title="#caption3" alt="Slideshow image">
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div id="wrapper-site">
                <div id="content-wrapper" class="full-width">
                    <div id="main">
                        <div class="page-home">

                            <div class="section living-room">
                                <div class="container">
                                    <div class="tiva-row-wrap row">
                                        <div class="groupcategoriestab-vertical col-md-12 col-xs-12 p-0 pt-5">
                                            <div class="grouptab row">

                                                <div class="categoriestab-left product-tab col-md-12 flex-9">
                                                    <div class="title-tab-content d-flex justify-content-start">
                                                        <ul class="nav nav-tabs">
                                                            <li>
                                                                <a href="#new" data-toggle="tab" class="active">New Arrivals</a>
                                                            </li>
                                                            <li>
                                                                <a href="#best" data-toggle="tab">Best Sellers</a>
                                                            </li>
                                                            <li>
                                                                <a href="#sale" data-toggle="tab">Special Products</a>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                    <div class="tab-content">
                                                        <div id="new" class="tab-pane fade in active show">
                                                            <div class="category-product-index owl-carousel owl-theme owl-loaded owl-drag">
                                                                <div class="item text-center ">
                                                                    <div class="product-miniature first-item js-product-miniature item-one">
                                                                        <div class="thumbnail-container">
                                                                            <a href="product-detail.html">
                                                                                <img class="img-fluid image-cover" src="../../../assets/images/product/1.jpg" alt="img">
                                                                                <img class="img-fluid image-secondary" src="../../../assets/images/product/5.jpg" alt="img">
                                                                            </a>
                                                                            <div class="product-flags discount">-30%</div>
                                                                            <div class="highlighted-informations">
                                                                                <div class="variant-links">
                                                                                    <a href="#" class="color beige" title="Beige"></a>
                                                                                    <a href="#" class="color orange" title="Orange"></a>
                                                                                    <a href="#" class="color green" title="Green"></a>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="product-description">
                                                                            <div class="product-groups">
                                                                                <div class="product-title">
                                                                                    <a href="product-detail.html">Nulla et justo non augue</a>
                                                                                </div>
                                                                                <div class="rating">
                                                                                    <div class="star-content">
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="product-group-price">
                                                                                    <div class="product-price-and-shipping">
                                                                                        <span class="price">£20.08</span>
                                                                                        <del class="regular-price">£28.68</del>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="product-buttons d-flex justify-content-center">
                                                                                <form action="#" method="post" class="formAddToCart">
                                                                                    <a class="add-to-cart" href="#" data-button-action="add-to-cart">
                                                                                        <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                                                                    </a>
                                                                                </form>
                                                                                <a class="addToWishlist" href="#" data-rel="1" onclick="">
                                                                                    <i class="fa fa-heart" aria-hidden="true"></i>
                                                                                </a>
                                                                                <a href="#" class="quick-view hidden-sm-down" data-link-action="quickview">
                                                                                    <i class="fa fa-eye" aria-hidden="true"></i>
                                                                                </a>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="item text-center ">
                                                                    <div class="product-miniature js-product-miniature item-one first-item">
                                                                        <div class="thumbnail-container">
                                                                            <a href="product-detail.html">
                                                                                <img class="img-fluid image-cover" src="../../../assets/images/product/3.jpg" alt="img">
                                                                                <img class="img-fluid image-secondary" src="../../../assets/images/product/9.jpg" alt="img">
                                                                            </a>
                                                                            <div class="product-flags discount">-10%</div>
                                                                            <div class="highlighted-informations">
                                                                                <div class="variant-links">
                                                                                    <a href="#" class="color beige" title="Beige"></a>
                                                                                    <a href="#" class="color orange" title="Orange"></a>
                                                                                    <a href="#" class="color green" title="Green"></a>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="product-description">
                                                                            <div class="product-groups">
                                                                                <div class="product-title">
                                                                                    <a href="product-detail.html">Nam semper a ligula nec</a>
                                                                                </div>
                                                                                <div class="rating">
                                                                                    <div class="star-content">
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="product-group-price">
                                                                                    <div class="product-price-and-shipping">
                                                                                        <span class="price">£20.08</span>
                                                                                        <del class="regular-price">£28.68</del>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="product-buttons d-flex justify-content-center">
                                                                                <form action="#" method="post" class="formAddToCart">
                                                                                    <a class="add-to-cart" href="#" data-button-action="add-to-cart">
                                                                                        <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                                                                    </a>
                                                                                </form>
                                                                                <a class="addToWishlist" href="#" data-rel="1" onclick="">
                                                                                    <i class="fa fa-heart" aria-hidden="true"></i>
                                                                                </a>
                                                                                <a href="#" class="quick-view hidden-sm-down" data-link-action="quickview">
                                                                                    <i class="fa fa-eye" aria-hidden="true"></i>
                                                                                </a>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="item text-center ">
                                                                    <div class="product-miniature js-product-miniature item-one first-item">
                                                                        <div class="thumbnail-container">
                                                                            <a href="product-detail.html">
                                                                                <img class="img-fluid image-cover" src="../../../assets/images/product/2.jpg" alt="img">
                                                                                <img class="img-fluid image-secondary" src="../../../assets/images/product/17.jpg" alt="img">
                                                                            </a>
                                                                            <div class="highlighted-informations">
                                                                                <div class="variant-links">
                                                                                    <a href="#" class="color beige" title="Beige"></a>
                                                                                    <a href="#" class="color orange" title="Orange"></a>
                                                                                    <a href="#" class="color green" title="Green"></a>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="product-description">
                                                                            <div class="product-groups">
                                                                                <div class="product-title">
                                                                                    <a href="product-detail.html">Phasellus vitae...</a>
                                                                                </div>
                                                                                <div class="rating">
                                                                                    <div class="star-content">
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="product-group-price">
                                                                                    <div class="product-price-and-shipping">
                                                                                        <span class="price">£20.08</span>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="product-buttons d-flex justify-content-center">
                                                                                <form action="#" method="post" class="formAddToCart">
                                                                                    <a class="add-to-cart" href="#" data-button-action="add-to-cart">
                                                                                        <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                                                                    </a>
                                                                                </form>
                                                                                <a class="addToWishlist" href="#" data-rel="1" onclick="">
                                                                                    <i class="fa fa-heart" aria-hidden="true"></i>
                                                                                </a>
                                                                                <a href="#" class="quick-view hidden-sm-down" data-link-action="quickview">
                                                                                    <i class="fa fa-eye" aria-hidden="true"></i>
                                                                                </a>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="tab-pane fade " id="best">
                                                            <div class="category-product-index owl-carousel owl-theme">
                                                                <div class="item text-center">
                                                                    <div class="product-miniature js-product-miniature item-one first-item">
                                                                        <div class="thumbnail-container">
                                                                            <a href="product-detail.html">
                                                                                <img class="img-fluid image-cover" src="img/product/4.jpg" alt="img">
                                                                                <img class="img-fluid image-secondary" src="img/product/10.jpg" alt="img">
                                                                            </a>
                                                                            <div class="product-flags discount">-30%</div>
                                                                            <div class="highlighted-informations">
                                                                                <div class="variant-links">
                                                                                    <a href="#" class="color beige" title="Beige"></a>
                                                                                    <a href="#" class="color orange" title="Orange"></a>
                                                                                    <a href="#" class="color green" title="Green"></a>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="product-description">
                                                                            <div class="product-groups">
                                                                                <div class="product-title">
                                                                                    <a href="product-detail.html">Nam semper a ligula nec</a>
                                                                                </div>
                                                                                <div class="rating">
                                                                                    <div class="star-content">
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="product-group-price">
                                                                                    <div class="product-price-and-shipping">
                                                                                        <span class="price">£20.08</span>
                                                                                        <del class="regular-price">£28.68</del>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="product-buttons d-flex justify-content-center">
                                                                                <form action="#" method="post" class="formAddToCart">
                                                                                    <a class="add-to-cart" href="#" data-button-action="add-to-cart">
                                                                                        <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                                                                    </a>
                                                                                </form>
                                                                                <a class="addToWishlist" href="#" data-rel="1" onclick="">
                                                                                    <i class="fa fa-heart" aria-hidden="true"></i>
                                                                                </a>
                                                                                <a href="#" class="quick-view hidden-sm-down" data-link-action="quickview">
                                                                                    <i class="fa fa-eye" aria-hidden="true"></i>
                                                                                </a>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="item text-center">
                                                                    <div class="product-miniature js-product-miniature item-one first-item">
                                                                        <div class="thumbnail-container">
                                                                            <a href="product-detail.html">
                                                                                <img class="img-fluid image-cover" src="img/product/5.jpg" alt="img">
                                                                                <img class="img-fluid image-secondary" src="img/product/12.jpg" alt="img">
                                                                            </a>
                                                                            <div class="product-flags discount">-10%</div>
                                                                            <div class="highlighted-informations">
                                                                                <div class="variant-links">
                                                                                    <a href="#" class="color beige" title="Beige"></a>
                                                                                    <a href="#" class="color orange" title="Orange"></a>
                                                                                    <a href="#" class="color green" title="Green"></a>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="product-description">
                                                                            <div class="product-groups">
                                                                                <div class="product-title">
                                                                                    <a href="product-detail.html">Nulla et justo non augue</a>
                                                                                </div>
                                                                                <div class="rating">
                                                                                    <div class="star-content">
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="product-group-price">
                                                                                    <div class="product-price-and-shipping">
                                                                                        <span class="price">£20.08</span>
                                                                                        <del class="regular-price">£28.68</del>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="product-buttons d-flex justify-content-center">
                                                                                <form action="#" method="post" class="formAddToCart">
                                                                                    <a class="add-to-cart" href="#" data-button-action="add-to-cart">
                                                                                        <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                                                                    </a>
                                                                                </form>
                                                                                <a class="addToWishlist" href="#" data-rel="1" onclick="">
                                                                                    <i class="fa fa-heart" aria-hidden="true"></i>
                                                                                </a>
                                                                                <a href="#" class="quick-view hidden-sm-down" data-link-action="quickview">
                                                                                    <i class="fa fa-eye" aria-hidden="true"></i>
                                                                                </a>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="item text-center">
                                                                    <div class="product-miniature js-product-miniature item-one first-item">
                                                                        <div class="thumbnail-container">
                                                                            <a href="product-detail.html">
                                                                                <img class="img-fluid image-cover" src="img/product/6.jpg" alt="img">
                                                                                <img class="img-fluid image-secondary" src="img/product/13.jpg" alt="img">
                                                                            </a>
                                                                            <div class="highlighted-informations">
                                                                                <div class="variant-links">
                                                                                    <a href="#" class="color beige" title="Beige"></a>
                                                                                    <a href="#" class="color orange" title="Orange"></a>
                                                                                    <a href="#" class="color green" title="Green"></a>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="product-description">
                                                                            <div class="product-groups">
                                                                                <div class="product-title">
                                                                                    <a href="product-detail.html">Nulla et justo non augue</a>
                                                                                </div>
                                                                                <div class="rating">
                                                                                    <div class="star-content">
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="product-group-price">
                                                                                    <div class="product-price-and-shipping">
                                                                                        <span class="price">£20.08</span>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="product-buttons d-flex justify-content-center">
                                                                                <form action="#" method="post" class="formAddToCart">
                                                                                    <a class="add-to-cart" href="#" data-button-action="add-to-cart">
                                                                                        <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                                                                    </a>
                                                                                </form>
                                                                                <a class="addToWishlist" href="#" data-rel="1" onclick="">
                                                                                    <i class="fa fa-heart" aria-hidden="true"></i>
                                                                                </a>
                                                                                <a href="#" class="quick-view hidden-sm-down" data-link-action="quickview">
                                                                                    <i class="fa fa-eye" aria-hidden="true"></i>
                                                                                </a>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="tab-pane fade " id="sale">
                                                            <div class="category-product-index owl-carousel owl-theme">
                                                                <div class="item text-center">
                                                                    <div class="product-miniature js-product-miniature item-one first-item">
                                                                        <div class="thumbnail-container">
                                                                            <a href="product-detail.html">
                                                                                <img class="img-fluid image-cover" src="img/product/7.jpg" alt="img">
                                                                                <img class="img-fluid image-secondary" src="img/product/14.jpg" alt="img">
                                                                            </a>
                                                                            <div class="product-flags discount">-30%</div>
                                                                            <div class="highlighted-informations">
                                                                                <div class="variant-links">
                                                                                    <a href="#" class="color beige" title="Beige"></a>
                                                                                    <a href="#" class="color orange" title="Orange"></a>
                                                                                    <a href="#" class="color green" title="Green"></a>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="product-description">
                                                                            <div class="product-groups">
                                                                                <div class="product-title">
                                                                                    <a href="product-detail.html">Nulla et justo non augue</a>
                                                                                </div>
                                                                                <div class="rating">
                                                                                    <div class="star-content">
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="product-group-price">
                                                                                    <div class="product-price-and-shipping">
                                                                                        <span class="price">£20.08</span>
                                                                                        <del class="regular-price">£28.68</del>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="product-buttons d-flex justify-content-center">
                                                                                <form action="#" method="post" class="formAddToCart">
                                                                                    <a class="add-to-cart" href="#" data-button-action="add-to-cart">
                                                                                        <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                                                                    </a>
                                                                                </form>
                                                                                <a class="addToWishlist" href="#" data-rel="1" onclick="">
                                                                                    <i class="fa fa-heart" aria-hidden="true"></i>
                                                                                </a>
                                                                                <a href="#" class="quick-view hidden-sm-down" data-link-action="quickview">
                                                                                    <i class="fa fa-eye" aria-hidden="true"></i>
                                                                                </a>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="item text-center">
                                                                    <div class="product-miniature js-product-miniature item-one first-item">
                                                                        <div class="thumbnail-container">
                                                                            <a href="product-detail.html">
                                                                                <img class="img-fluid image-cover" src="img/product/8.jpg" alt="img">
                                                                                <img class="img-fluid image-secondary" src="img/product/15.jpg" alt="img">
                                                                            </a>
                                                                            <div class="product-flags discount">-20%</div>
                                                                            <div class="highlighted-informations">
                                                                                <div class="variant-links">
                                                                                    <a href="#" class="color beige" title="Beige"></a>
                                                                                    <a href="#" class="color orange" title="Orange"></a>
                                                                                    <a href="#" class="color green" title="Green"></a>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="product-description">
                                                                            <div class="product-groups">
                                                                                <div class="product-title">
                                                                                    <a href="product-detail.html">Nulla et justo non augue</a>
                                                                                </div>
                                                                                <div class="rating">
                                                                                    <div class="star-content">
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="product-group-price">
                                                                                    <div class="product-price-and-shipping">
                                                                                        <span class="price">£20.08</span>
                                                                                        <del class="regular-price">£28.68</del>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="product-buttons d-flex justify-content-center">
                                                                                <form action="#" method="post" class="formAddToCart">
                                                                                    <a class="add-to-cart" href="#" data-button-action="add-to-cart">
                                                                                        <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                                                                    </a>
                                                                                </form>
                                                                                <a class="addToWishlist" href="#" data-rel="1" onclick="">
                                                                                    <i class="fa fa-heart" aria-hidden="true"></i>
                                                                                </a>
                                                                                <a href="#" class="quick-view hidden-sm-down" data-link-action="quickview">
                                                                                    <i class="fa fa-eye" aria-hidden="true"></i>
                                                                                </a>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="item text-center">
                                                                    <div class="product-miniature js-product-miniature item-one first-item">
                                                                        <div class="thumbnail-container">
                                                                            <a href="product-detail.html">
                                                                                <img class="img-fluid image-cover" src="img/product/9.jpg" alt="img">
                                                                                <img class="img-fluid image-secondary" src="img/product/16.jpg" alt="img">
                                                                            </a>
                                                                            <div class="product-flags discount">-20%</div>
                                                                            <div class="highlighted-informations">
                                                                                <div class="variant-links">
                                                                                    <a href="#" class="color beige" title="Beige"></a>
                                                                                    <a href="#" class="color orange" title="Orange"></a>
                                                                                    <a href="#" class="color green" title="Green"></a>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="product-description">
                                                                            <div class="product-groups">
                                                                                <div class="product-title">
                                                                                    <a href="product-detail.html">Nulla et justo non augue</a>
                                                                                </div>
                                                                                <div class="rating">
                                                                                    <div class="star-content">
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                        <div class="star"></div>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="product-group-price">
                                                                                    <div class="product-price-and-shipping">
                                                                                        <span class="price">£20.08</span>
                                                                                        <del class="regular-price">£28.68</del>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="product-buttons d-flex justify-content-center">
                                                                                <form action="#" method="post" class="formAddToCart">
                                                                                    <a class="add-to-cart" href="#" data-button-action="add-to-cart">
                                                                                        <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                                                                    </a>
                                                                                </form>
                                                                                <a class="addToWishlist" href="#" data-rel="1" onclick="">
                                                                                    <i class="fa fa-heart" aria-hidden="true"></i>
                                                                                </a>
                                                                                <a href="#" class="quick-view hidden-sm-down" data-link-action="quickview">
                                                                                    <i class="fa fa-eye" aria-hidden="true"></i>
                                                                                </a>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <div class="container">
                                <div class="content">
                                    <div class="row">
                                        <div class="sidebar-3 sidebar-collection col-lg-3 col-md-4 col-sm-4">

                                            <!-- category menu -->
                                            <div class="sidebar-block">
                                                <div class="title-block">Categories</div>
                                                <div class="block-content">
                                                    <div class="cateTitle hasSubCategory open level1">
                                                        <span class="arrow collapsed collapse-icons" data-toggle="collapse" data-target="#livingroom" aria-expanded="false" role="status">
                                                            <i class="zmdi zmdi-minus"></i>
                                                            <i class="zmdi zmdi-plus"></i>
                                                        </span>
                                                        <a class="cateItem" href="#">Living Room</a>
                                                        <div class="subCategory collapse" id="livingroom" aria-expanded="true" role="status">
                                                            <div class="cateTitle">
                                                                <a href="#" class="cateItem">Side Table</a>
                                                                <div class="subCategory collapse" id="subCategory-fruits" aria-expanded="true" role="status">
                                                                    <div class="cateTitle">
                                                                        <a href="#" class="cateItem">Side Table</a>
                                                                    </div>
                                                                    <div class="cateTitle">
                                                                        <a href="#" class="cateItem">FIREPLACE</a>
                                                                    </div>
                                                                    <div class="cateTitle">
                                                                        <a href="#" class="cateItem">FIREPLACE</a>
                                                                    </div>
                                                                    <div class="cateTitle">
                                                                        <a href="#" class="cateItem">floor lamp</a>
                                                                    </div>
                                                                    <div class="cateTitle">
                                                                        <a href="#" class="cateItem">ottoman</a>
                                                                    </div>
                                                                    <div class="cateTitle">
                                                                        <a href="#" class="cateItem">armchair</a>
                                                                    </div>
                                                                    <div class="cateTitle">
                                                                        <a href="#" class="cateItem">cushion</a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="cateTitle">
                                                                <a href="#" class="cateItem">FIREPLACE</a>
                                                            </div>
                                                            <div class="cateTitle">
                                                                <a href="#" class="cateItem">FIREPLACE</a>
                                                            </div>
                                                            <div class="cateTitle">
                                                                <a href="#" class="cateItem">floor lamp</a>
                                                            </div>
                                                            <div class="cateTitle">
                                                                <a href="#" class="cateItem">ottoman</a>
                                                            </div>
                                                            <div class="cateTitle">
                                                                <a href="#" class="cateItem">armchair</a>
                                                            </div>
                                                            <div class="cateTitle">
                                                                <a href="#" class="cateItem">cushion</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="cateTitle hasSubCategory open level1">
                                                        <span class="arrow collapsed collapse-icons" data-toggle="collapse" data-target="#bathroom" aria-expanded="false" role="status">
                                                            <i class="zmdi zmdi-minus"></i>
                                                            <i class="zmdi zmdi-plus"></i>
                                                        </span>
                                                        <a class="cateItem" href="#">Bathroom</a>
                                                        <div class="subCategory collapse" id="bathroom" aria-expanded="false" role="status">
                                                            <div class="cateTitle">
                                                                <a href="#" class="cateItem">TOMATO</a>
                                                            </div>
                                                            <div class="cateTitle">
                                                                <a href="#" class="cateItem">BROCCOLI</a>
                                                            </div>
                                                            <div class="cateTitle">
                                                                <a href="#" class="cateItem">CABBAGE</a>
                                                            </div>
                                                            <div class="cateTitle">
                                                                <a href="#" class="cateItem">CUCUMBER</a>
                                                            </div>
                                                            <div class="cateTitle">
                                                                <a href="#" class="cateItem">EGGPLANT</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="cateTitle hasSubCategory open level1">
                                                        <span class="arrow collapsed collapse-icons" data-toggle="collapse" data-target="#diningroom" aria-expanded="false" role="status">
                                                            <i class="zmdi zmdi-minus"></i>
                                                            <i class="zmdi zmdi-plus"></i>
                                                        </span>
                                                        <a class="cateItem" href="#">Dining Rooom</a>
                                                        <div class="subCategory collapse" id="diningroom" aria-expanded="true" role="status">
                                                            <div class="cateTitle">
                                                                <a href="#" class="cateItem">DRY BREAD</a>
                                                            </div>
                                                            <div class="cateTitle">
                                                                <a href="#" class="cateItem">BREAD SLICES</a>
                                                            </div>
                                                            <div class="cateTitle">
                                                                <a href="#" class="cateItem">FRENCH BREAD</a>
                                                            </div>
                                                            <div class="cateTitle">
                                                                <a href="#" class="cateItem">BLACK BREAD</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="cateTitle hasSubCategory open level1">
                                                        <span class="arrow collapsed collapse-icons" data-toggle="collapse" data-target="#bedroom" aria-expanded="false" role="status">
                                                            <i class="zmdi zmdi-minus"></i>
                                                            <i class="zmdi zmdi-plus"></i>
                                                        </span>
                                                        <a class="cateItem" href="#">BedRoom</a>
                                                        <div class="subCategory collapse" id="bedroom" aria-expanded="true" role="status">
                                                            <div class="cateTitle">
                                                                <a href="#" class="cateItem">ORANGE JUICES</a>
                                                            </div>
                                                            <div class="cateTitle">
                                                                <a href="#" class="cateItem">TOMATO JUICES</a>
                                                            </div>
                                                            <div class="cateTitle">
                                                                <a href="#" class="cateItem">APPLE JUICES</a>
                                                            </div>

                                                        </div>
                                                    </div>
                                                    <div class="cateTitle hasSubCategory open level1">
                                                        <span class="arrow collapsed collapse-icons" data-toggle="collapse" data-target="#kitchen" aria-expanded="false" role="status">
                                                            <i class="zmdi zmdi-minus"></i>
                                                            <i class="zmdi zmdi-plus"></i>
                                                        </span>
                                                        <a class="cateItem" href="#">Kitchen</a>
                                                        <div class="subCategory collapse" id="kitchen" aria-expanded="true" role="status">
                                                            <div class="cateTitle">
                                                                <a href="#" class="cateItem">ORANGE JUICES</a>
                                                            </div>
                                                            <div class="cateTitle">
                                                                <a href="#" class="cateItem">TOMATO JUICES</a>
                                                            </div>
                                                            <div class="cateTitle">
                                                                <a href="#" class="cateItem">APPLE JUICES</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <!-- best seller -->
                                            <div class="sidebar-block">
                                                <div class="title-block">Catalog</div>
                                                <div class="new-item-content">
                                                    <h3 class="title-product">categories</h3>
                                                    <ul class="scroll-product">
                                                        <li>
                                                            <label class="check">
                                                                <input type="checkbox">
                                                                <span class="checkmark"></span>
                                                            </label>
                                                            <a href="#">
                                                                <b>side table</b>
                                                                <span class="quantity">(30)</span>
                                                            </a>
                                                        </li>
                                                        <li>
                                                            <label class="check">
                                                                <input type="checkbox">
                                                                <span class="checkmark"></span>
                                                            </label>
                                                            <a href="#">
                                                                <b>floor lamp</b>
                                                                <span class="quantity">(32)</span>
                                                            </a>
                                                        </li>
                                                        <li>
                                                            <label class="check">
                                                                <input type="checkbox">
                                                                <span class="checkmark"></span>
                                                            </label>
                                                            <a href="#">
                                                                <b>ottoman</b>
                                                                <span class="quantity">(67)</span>
                                                            </a>
                                                        </li>
                                                        <li>
                                                            <label class="check">
                                                                <input type="checkbox">
                                                                <span class="checkmark"></span>
                                                            </label>
                                                            <a href="#">
                                                                <b>armchair</b>
                                                                <span class="quantity">(15)</span>
                                                            </a>
                                                        </li>
                                                        <li>
                                                            <label class="check">
                                                                <input type="checkbox">
                                                                <span class="checkmark"></span>
                                                            </label>
                                                            <a href="#">
                                                                <b>ottoman</b>
                                                                <span class="quantity">(24)</span>

                                                            </a>
                                                        </li>
                                                        <li>
                                                            <label class="check">
                                                                <input type="checkbox">
                                                                <span class="checkmark"></span>
                                                            </label>
                                                            <a href="#">
                                                                <b>CUSHION</b>
                                                                <span class="quantity">(20)</span>

                                                            </a>
                                                        </li>
                                                        <li>
                                                            <label class="check">
                                                                <input type="checkbox">
                                                                <span class="checkmark"></span>
                                                            </label>
                                                            <a href="#">
                                                                <b>Pineapple</b>
                                                                <span class="quantity">(21)</span>
                                                            </a>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <div class="new-item-content">
                                                    <h3 class="title-product">Manufacture</h3>
                                                    <ul class="scroll-product">
                                                        <li>
                                                            <label class="check">
                                                                <input type="checkbox">
                                                                <span class="checkmark"></span>
                                                            </label>
                                                            <a href="#">
                                                                <b>Samsung</b>
                                                                <span class="quantity">(30)</span>
                                                            </a>
                                                        </li>
                                                        <li>
                                                            <label class="check">
                                                                <input type="checkbox">
                                                                <span class="checkmark"></span>
                                                            </label>
                                                            <a href="#">
                                                                <b>Dell</b>
                                                                <span class="quantity">(30)</span>
                                                            </a>
                                                        </li>
                                                        <li>
                                                            <label class="check">
                                                                <input type="checkbox">
                                                                <span class="checkmark"></span>
                                                            </label>
                                                            <a href="#">
                                                                <b>Polygon</b>
                                                                <span class="quantity">(30)</span>
                                                            </a>
                                                        </li>
                                                        <li>
                                                            <label class="check">
                                                                <input type="checkbox">
                                                                <span class="checkmark"></span>
                                                            </label>
                                                            <a href="#">
                                                                <b>Newment</b>
                                                                <span class="quantity">(30)</span>
                                                            </a>
                                                        </li>
                                                        <li>
                                                            <label class="check">
                                                                <input type="checkbox">
                                                                <span class="checkmark"></span>
                                                            </label>
                                                            <a href="#">
                                                                <b>Asus</b>
                                                                <span class="quantity">(30)</span>
                                                            </a>
                                                        </li>
                                                        <li>
                                                            <label class="check">
                                                                <input type="checkbox">
                                                                <span class="checkmark"></span>
                                                            </label>
                                                            <a href="#">
                                                                <b>Mac</b>
                                                                <span class="quantity">(30)</span>
                                                            </a>
                                                        </li>
                                                        <li>
                                                            <label class="check">
                                                                <input type="checkbox">
                                                                <span class="checkmark"></span>
                                                            </label>
                                                            <a href="#">
                                                                <b>Vaio</b>
                                                                <span class="quantity">(30)</span>
                                                            </a>
                                                        </li>
                                                        <li>
                                                            <label class="check">
                                                                <input type="checkbox">
                                                                <span class="checkmark"></span>
                                                            </label>
                                                            <a href="#">
                                                                <b>Lettuce</b>
                                                                <span class="quantity">(30)</span>
                                                            </a>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <div class="tiva-filter-price new-item-content sidebar-block">
                                                    <h3 class="title-product">By Price</h3>
                                                    <div id="block_price_filter" class="block">
                                                        <div class="block-content">
                                                            <div id="slider-range" class="tiva-filter">
                                                                <div class="filter-itemprice-filter">
                                                                    <div class="layout-slider">
                                                                        <input id="price-filter" name="price" value="0;100" />
                                                                    </div>
                                                                    <div class="layout-slider-settings"></div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="sidebar-block by-color">
                                                    <h3 class="title-product">By Color</h3>
                                                    <div>
                                                        <span class="left">
                                                            <label class="color-item1"></label>
                                                            <a href="#">
                                                                <span>Blue
                                                                    <span>(30)</span>
                                                                </span>
                                                            </a>
                                                        </span>
                                                        <span class="right">
                                                            <label class="color-item2"></label>
                                                            <a href="#">
                                                                <span>Green
                                                                    <span>(30)</span>
                                                                </span>
                                                            </a>
                                                        </span>
                                                    </div>
                                                    <div>
                                                        <span class="left">
                                                            <label class="color-item3"></label>
                                                            <a href="#">
                                                                <span>Yellow
                                                                    <span>(30)</span>
                                                                </span>
                                                            </a>
                                                        </span>
                                                        <span class="right">
                                                            <label class="color-item4"></label>
                                                            <a href="#">
                                                                <span>Brown
                                                                    <span>(30)</span>
                                                                </span>
                                                            </a>
                                                        </span>

                                                    </div>
                                                    <div>
                                                        <span class="left">
                                                            <label class="color-item5"></label>
                                                            <a href="#">
                                                                <span>Pink
                                                                    <span>(30)</span>
                                                                </span>
                                                            </a>
                                                        </span>
                                                        <span class="right">
                                                            <label class="color-item6"></label>
                                                            <a href="#">
                                                                <span>Red
                                                                    <span>(30)</span>
                                                                </span>
                                                            </a>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>

                                            <!-- product tag -->
                                            <div class="sidebar-block product-tags " >
                                                <div class="title-block">
                                                    Product Tags
                                                </div>
                                                <div class="block-content">
                                                    <ul class="listSidebarBlog list-unstyled">
                                                        <li>
                                                            <a href="#" title="Show products matching tag Hot Trend">Hot Trend</a>
                                                        </li>

                                                        <li>
                                                            <a href="#" title="Show products matching tag Jewelry">Jewelry</a>
                                                        </li>

                                                        <li>
                                                            <a href="man.html" title="Show products matching tag Man">Man</a>
                                                        </li>

                                                        <li>
                                                            <a href="#" title="Show products matching tag Party">Party</a>
                                                        </li>

                                                        <li>
                                                            <a href="#" title="Show products matching tag SamSung">SamSung</a>
                                                        </li>

                                                        <li>
                                                            <a href="#" title="Show products matching tag Shirt Dresses">Shirt Dresses</a>
                                                        </li>

                                                        <li>
                                                            <a href="#" title="Show products matching tag Shoes">Shoes</a>
                                                        </li>

                                                        <li>
                                                            <a href="#" title="Show products matching tag Summer">Summer</a>
                                                        </li>

                                                        <li>
                                                            <a href="#" title="Show products matching tag Sweaters">Sweaters</a>
                                                        </li>

                                                        <li>
                                                            <a href="#" title="Show products matching tag Winter">Winter</a>
                                                        </li>

                                                        <li>
                                                            <a href="#" title="Show products matching tag Woman">Woman</a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-8 col-lg-9 col-md-8 product-container">
                                            <h1>Products</h1>
                                            <div class="js-product-list-top firt nav-top">
                                                <div class="d-flex justify-content-around row">
                                                    <div class="col col-xs-12">
                                                        <ul class="nav nav-tabs bg-transparent">
                                                            <li>
                                                                <a href="#grid" data-toggle="tab" class="active show fa fa-th-large"></a>
                                                            </li>
                                                            <li>
                                                                <a href="#list" data-toggle="tab" class="fa fa-list-ul"></a>
                                                            </li>
                                                        </ul>
                                                        <div class="hidden-sm-down total-products">
                                                            <p>There are 12 products.</p>
                                                        </div>
                                                    </div>
                                                    <div class="col col-xs-12 ">
                                                        <div class="d-flex sort-by-row justify-content-lg-end justify-content-md-end ">

                                                            <div class="products-sort-order dropdown bg-transparent">
                                                                <select class="select-title">
                                                                    <option value="">Sort by</option>
                                                                    <option value="">Name, A to Z</option>
                                                                    <option value="">Name, Z to A</option>
                                                                    <option value="">Price, low to high</option>
                                                                    <option value="">Price, high to low</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tab-content product-items">
                                                <div id="grid" class="related tab-pane fade in active show">
                                                    <div class="row mb-5">
                                                        <c:forEach var="product" items="${helper.getProductDtoList()}">
                                                        <div class="item text-center col-md-4 mb-4 p-1">
                                                            <div class="product-miniature js-product-miniature item-one first-item shadow rounded p-1">
                                                                <div class="thumbnail-container border">
                                                                    <a href="product-details?productID=${product.getId()}">
                                                                        <img class="img-fluid image-cover" src="images${product.getImagesPaths().get(0)}" alt="img">
                                                                        <img class="img-fluid image-secondary" src="images${product.getImagesPaths().get(1)}" alt="img">
                                                                    </a>
                                                                    <div class="highlighted-informations">
                                                                        <div class="variant-links">
                                                                            <a href="#" class="color beige" title="Beige"></a>
                                                                            <a href="#" class="color orange" title="Orange"></a>
                                                                            <a href="#" class="color green" title="Green"></a>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="product-description">
                                                                    <div class="product-groups">
                                                                        <div class="product-title">
                                                                            <a href="product-detail.jsp">${product.getProductDesc()}</a>
                                                                        </div>
                                                                        <div class="rating">
                                                                            <div class="star-content">
                                                                                <div class="star"></div>
                                                                                <div class="star"></div>
                                                                                <div class="star"></div>
                                                                                <div class="star"></div>
                                                                                <div class="star"></div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="product-group-price">
                                                                            <div class="product-price-and-shipping">
                                                                                <span class="price">$ ${product.getPrice()}</span>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="product-buttons d-flex justify-content-center">
                                                                        <form action="#" method="post" class="formAddToCart">
                                                                            <input type="hidden" name="id_product" value="1">
                                                                            <a class="add-to-cart" href="#" data-button-action="add-to-cart">
                                                                                <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                                                            </a>
                                                                        </form>
                                                                        <a class="addToWishlist" href="#" data-rel="1" onclick="">
                                                                            <i class="fa fa-heart" aria-hidden="true"></i>
                                                                        </a>
                                                                        <a href="#" class="quick-view hidden-sm-down" data-link-action="quickview">
                                                                            <i class="fa fa-eye" aria-hidden="true"></i>
                                                                        </a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        </c:forEach>

                                                        </div>
                                                    </div>
                                            </div>

                                            <!-- pagination -->
                                            <div class="pagination mb-3">
                                                <div class="js-product-list-top ">
                                                    <div class="d-flex justify-content-around row">
                                                        <div class="showing col col-xs-12 bg-transparent">
                                                            <span class="bg-transparent">SHOWING 1-3 OF 3 ITEM(S)</span>
                                                        </div>
                                                        <div class="page-list col col-xs-12">
                                                            <c:choose>
                                                                <c:when test="${pageContext.request.servletPath eq '/search'}">
                                                                </c:when>
                                                            <c:otherwise>
                                                            <ul class="bg-transparent">
                                                                    ${pageContext.request.servletPath}
                                                                <c:choose>
                                                                    <c:when test="${param.pageNum <= 1 || empty param.pageNum}">
                                                                       <li>
                                                                        <a rel="prev" href="${param.pageNum-1}" class="previous disabled js-search-link" style="pointer-events: none">
                                                                            Previous
                                                                        </a>
                                                                       </li>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <li style="background-color:#343434 ">
                                                                            <a rel="prev" href="home?pageNum=${param.pageNum-1}" class="previous disabled js-search-link">
                                                                                Previous
                                                                            </a>
                                                                        </li>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                                        <c:forEach var = "pageNumber" begin = "1" end = "${Math.ceil(helper.getAllProductCount()/12)}">
                                                                            <li class="current ">
                                                                                <a rel="nofollow" href="home?pageNum=${pageNumber}" class="disabled js-search-link" id="${pageNumber}">
                                                                                        ${pageNumber}
                                                                                </a>
                                                                            </li>
                                                                        </c:forEach>
                                                                <c:choose>
                                                                    <c:when test="${param.pageNum >= Math.round(helper.getAllProductCount()/12)}">
                                                                        <li>
                                                                            <a rel="next" href="home?pageNum=${param.pageNum+1}" class="next disabled js-search-link" style="pointer-events: none">
                                                                                Next
                                                                            </a>
                                                                        </li>
                                                                    </c:when>
                                                                    <c:otherwise>

                                                                        <li style="background-color: #FF5151">
                                                                            <a rel="next" href="home?pageNum=${param.pageNum+1}" class="next disabled js-search-link">
                                                                                Next
                                                                            </a>
                                                                        </li>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </ul>
                                                            </c:otherwise>
                                                            </c:choose>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <!-- end col-md-9-1 -->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>


    <%@ include file="../includes/customer-mobile-menu.jsp" %>
    <%@ include file="../includes/customer-footer.jsp" %>
<%@ include file="../includes/customer-script.jsp" %>
<script>
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    var currentPage = urlParams.get('pageNum');
    console.log(currentPage)
    if(currentPage == null){
     currentPage=1;
    }
    document.getElementById(currentPage).parentElement.classList.add("active");


</script>
</body>


<!-- index06:45-->
</html>