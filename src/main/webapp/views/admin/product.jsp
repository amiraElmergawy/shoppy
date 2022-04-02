<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if IE 9 ]><html class="ie ie9" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<!--<![endif]-->
<html lang="zxx">


<!-- product-detail06:46-->
<head>
    <!-- Basic Page Needs -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Shoppy Dashboard</title>

    <%@ include file="../includes/customer-head.jsp" %>

</head>

<body id="product-detail">
<%@ include file="../includes/admin-header.jsp" %>
<!-- main content -->
<div class="main-content">
    <div id="wrapper-site">
        <div id="content-wrapper">
            <div id="main">
                <div class="page-home">
                    <!-- breadcrumb -->
                    <div class="container">
                        <div class="content mt-1">
                            <div class="row">
                                <div class="col-sm-1 col-lg- col-md-1">
                                    <%@ include file="../includes/admin-sidebar.jsp" %>
                                </div>
                                <div class="col-sm-11 col-lg-11 col-md-11">
                                    <div class="main-product-detail">
                                        <div class="product-single row">
                                            <div class="product-detail col-xs-12 col-md-5 col-sm-5">
                                                <div class="page-content" id="content">
                                                    <div class="images-container">
                                                        <div class="js-qv-mask mask tab-content ">
                                                            <div id="item1" class="tab-pane fade active in show border-0">
                                                                <img src="../../assets/images/product/1.jpg" alt="img">
                                                            </div>
                                                            <div id="item2" class="tab-pane fade">
                                                                <img src="../../assets/images/product/2.jpg" alt="img">
                                                            </div>
                                                            <div id="item3" class="tab-pane fade">
                                                                <img src="../../assets/images/product/3.jpg" alt="img">
                                                            </div>
                                                            <div id="item4" class="tab-pane fade">
                                                                <img src="../../assets/images/product/5.jpg" alt="img">
                                                            </div>
                                                            <div class="layer hidden-sm-down" data-toggle="modal" data-target="#product-modal">
                                                                <i class="fa fa-expand"></i>
                                                            </div>
                                                        </div>
                                                        <ul class="product-tab nav nav-tabs d-flex">
                                                            <li class="active col ">
                                                                <a href="#item1" data-toggle="tab" aria-expanded="true" class="active show shadow rounded p-1 border-0">
                                                                    <img src="../../assets/images/product/1.jpg" alt="img">
                                                                </a>
                                                            </li>
                                                            <li class="col">
                                                                <a href="#item2" data-toggle="tab" class=" shadow rounded p-1 border-0">
                                                                    <img src="../../assets/images/product/2.jpg" alt="img">
                                                                </a>
                                                            </li>
                                                            <li class="col">
                                                                <a href="#item3" data-toggle="tab" class=" shadow rounded p-1 border-0">
                                                                    <img src="../../assets/images/product/3.jpg" alt="img">
                                                                </a>
                                                            </li>
                                                            <li class="col">
                                                                <a href="#item4" data-toggle="tab" class=" shadow rounded p-1 border-0">
                                                                    <img src="../../assets/images/product/5.jpg" alt="img">
                                                                </a>
                                                            </li>
                                                        </ul>
                                                        <div class="modal fade" id="product-modal" role="dialog">
                                                            <div class="modal-dialog">

                                                                <!-- Modal content-->
                                                                <div class="modal-content ">
                                                                    <div class="modal-header">
                                                                        <div class="modal-body">
                                                                            <div class="product-detail">
                                                                                <div>
                                                                                    <div class="images-container col-10 m-0">
                                                                                        <div class="js-qv-mask mask tab-content">
                                                                                            <div id="modal-item1" class="tab-pane fade active in show">
                                                                                                <img class="img-fluid" src="../../assets/images/product/2.jpg" alt="img">
                                                                                            </div>
                                                                                            <div id="modal-item2" class="tab-pane fade">
                                                                                                <img src="../../assets/images/product/2.jpg" alt="img">
                                                                                            </div>
                                                                                            <div id="modal-item3" class="tab-pane fade">
                                                                                                <img src="../../assets/images/product/3.jpg" alt="img">
                                                                                            </div>
                                                                                            <div id="modal-item4" class="tab-pane fade">
                                                                                                <img src="../../assets/images/product/5.jpg" alt="img">
                                                                                            </div>
                                                                                        </div>
                                                                                        <ul class="product-tab nav nav-tabs">
                                                                                            <li class="active">
                                                                                                <a href="#modal-item1" data-toggle="tab" class=" active show">
                                                                                                    <img src="../../assets/images/product/1.jpg" alt="img">
                                                                                                </a>
                                                                                            </li>
                                                                                            <li>
                                                                                                <a href="#modal-item2" data-toggle="tab">
                                                                                                    <img src="../../assets/images/product/2.jpg" alt="img">
                                                                                                </a>
                                                                                            </li>
                                                                                            <li>
                                                                                                <a href="#modal-item3" data-toggle="tab">
                                                                                                    <img src="../../assets/images/product/3.jpg" alt="img">
                                                                                                </a>
                                                                                            </li>
                                                                                            <li>
                                                                                                <a href="#modal-item4" data-toggle="tab">
                                                                                                    <img src="../../assets/images/product/5.jpg" alt="img">
                                                                                                </a>
                                                                                            </li>
                                                                                        </ul>
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
                                            <div class="product-info col-xs-12 col-md-7 col-sm-7 py-md-5 ">
                                                <div class="detail-description">
                                                    <div class="price-del">
                                                        <h1 class="product-name" name="productName">Mi Note 11 Pro</h1>
                                                        <h2 font-size="25px"  class="mt-3 font-color font-weight-bold mb-3">$1135.00</h2>
                                                        <span class="float-right mt-1">
                                                                <span class="availb">Availability: </span>
                                                                <span class="check">
                                                                    <i class="fa fa-check-square-o" aria-hidden="true"></i>IN STOCK</span>
                                                            </span>
                                                    </div>
                                                    <h6 font-size="14px" class="text-muted mr-2 mb-4">Proin gravida nibh vel velit auctor aliquet. Aenean lorem quis bibendum
                                                        auctor, nisi elit consequat etiam non auctor.</h6>


                                                    <div class="cart-area has-border ">
                                                        <div class="product-quantity">
                                                            <div class="qty">
                                                                <div class="input-group d-flex">
                                                                    <div class="quantity" style="width:120px">
                                                                        <label>Quantity: </label>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <p class="product-minimal-quantity">
                                                        </p>
                                                    </div>

                                                    <div class="rating-comment  d-flex">
                                                        <div class="review-description d-flex">
                                                            <h6 font-size="14px" class="text-muted mr-2">Rated:</h6>
                                                            <div class="rating">
                                                                <div class="star-content">
                                                                    <div class="star"></div>
                                                                    <div class="star"></div>
                                                                    <div class="star"></div>
                                                                    <div class="star"></div>
                                                                    <div class="star"></div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="review">
                                                        <ul class="nav nav-tabs">
                                                            <li class="active">
                                                                <a data-toggle="tab" href="#description" class="active show">Description</a>
                                                            </li>
                                                            </li>
                                                        </ul>

                                                        <div class="tab-content">
                                                            <div id="description" class="tab-pane fade in active show">
                                                                <p font-size="14px" class="text-muted mr-2 mb-4">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
                                                                    eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem
                                                                    ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                                                    tempor incididunt ut labore et dolore magna aliqua.
                                                                </p>
                                                                <p font-size="14px" class="text-muted mr-2 mb-4">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
                                                                    eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem
                                                                    ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                                                    tempor incididunt ut labore et dolore magna aliqua.
                                                                </p>
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
</div>


    <!-- back top top -->
    <div class="back-to-top">
        <a href="#">
            <i class="fa fa-long-arrow-up"></i>
        </a>
    </div>
        </div>
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js"
        integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"
        integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha"
        crossorigin="anonymous"></script>
<script src="../../assets/scripts/dashboard.js"></script>

<!-- Vendor JS -->
<script src="../../assets/libs/jquery/jquery.min.js"></script>
<script src="../../assets/libs/popper/popper.min.js"></script>
<script src="../../assets/libs/bootstrap/js/bootstrap.min.js"></script>
<script src="../../assets/libs/nivo-slider/js/jquery.nivo.slider.js"></script>
<script src="../../assets/libs/owl-carousel/owl.carousel.min.js"></script>
<script src="../../assets/libs/slider-range/js/tmpl.js"></script>
<script src="../../assets/libs/slider-range/js/jquery.dependClass-0.1.js"></script>
<script src="../../assets/libs/slider-range/js/draggable-0.1.js"></script>
<script src="../../assets/libs/slider-range/js/jquery.slider.js"></script>

</body>


<!-- product-detail07:06-->
</html>