<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.lang.Math" %>
<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if IE 9 ]><html class="ie ie9" lang="en"> <![endif]-->

<html lang="en">


<head>
    <!-- Basic Page Needs -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Furnitica - Minimalist Furniture HTML Template</title>


    <%@ include file="../includes/customer-head.jsp" %>

    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<c:url value="/" var="imagesUrl" context="/images"/>

<body class="product-cart checkout-cart blog">
<%@ include file="../includes/customer-header.jsp" %>

    <!-- main content -->
    <div class="main-content bg-light" id="cart">
        <!-- main -->
        <div id="wrapper-site">
            <div class="container ">
                <div class="row">
                    <div id="content-wrapper" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 onecol">
                        <section id="main" class="mt-2">
                            <div class="cart-grid row">
                                <div class="col-md-9 col-xs-12 check-info">
                                    <h1 class="title-page">Shopping Cart</h1>
                                    <div class="d-none alert-danger p-2 mb-4 text-center h6" id="error"></div>
                                    <div class="cart-container" id="productsContainer">
                                       <c:forEach var="orderProduct" items="${cart.getOrderProducts()}">
                                        <div class="cart-overview js-cart" id=${orderProduct.getProduct().getId()}>
                                            <ul class="cart-items">
                                                <li class="cart-item bg-white rounded shadow-lg mb-2">
                                                    <div class="product-line-grid row justify-content-between">
                                                        <div class="product-line-grid-left col-md-2">
                                                            <span class="product-image media-middle">
                                                                <a href="product-details?productID=${orderProduct.getProduct().getId()}">
                                                                    <img class="img-fluid" src="${imagesUrl}${orderProduct.getProduct().getImagesPaths().get(0)}" alt="Organic Strawberry Fruits">
                                                                </a>
                                                            </span>
                                                        </div>
                                                        <div class="product-line-grid-body col-md-4 ">
                                                            <div class="product-line-info">
                                                                <a class="label" href="product-detail.jsp" data-id_customization="0">
                                                                    ${orderProduct.getProduct().getProductName()}
                                                                    <span class="font-weight-bold text-danger text-lg-center">
                                                                            ${orderProduct.getProduct().getProductDesc()}
                                                                    </span>
                                                                </a>
                                                               
                                                            </div>
                                                            <div class="product-line-info product-price">
                                                                <span class="value">${orderProduct.getProduct().getPrice()} EG</span>
                                                            </div>
                                                        </div>
                                                        <div class="product-line-grid-right text-center product-line-actions col-md-6 justify-content-between">
                                                            <div class="row">
                                                                <div class="col-md-5 col m-auto ">
                                                                    <div class="quantity d-flex ">
                                                                        <button id="minus" class="btn shadow-sm btn-sm btn-primary font-weight-bold" onclick="decreaseProduct(${orderProduct.getProduct().getId()})">
                                                                            -
                                                                        </button>
                                                                        <div id=${orderProduct.getProduct().getId()}quantity class="btn-sm bg-white font-weight-bold mx-2">
                                                                                ${orderProduct.getQuantity()}
                                                                        </div>
                                                                        <button id="plus" class="btn shadow-sm btn-sm btn-primary font-weight-bold " onclick="increaseProduct(${orderProduct.getProduct().getId()})">
                                                                            +
                                                                        </button>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-5 price col m-auto">
                                                                    <div class="product-price total ">
                                                                        ${Math.round(orderProduct.getTotal())} EG
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-2 text-xs-right align-self-end col">
                                                                    <div class="cart-line-product-actions m-0">
                                                                        <button class="btn remove-from-cart m-0" rel="nofollow" data-link-action="delete-from-cart" data-id-product="1" onclick="deleteProduct(${orderProduct.getProduct().getId()})">
                                                                            <i class="fa fa-trash-o" aria-hidden="true"></i>
                                                                        </button>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </li>
                                               
                                            </ul>
                                        </div>
                                       </c:forEach>
                                    </div>
                                   <div class="text-center">
                                    <a href="product-checkout.jsp" class="continue btn btn-primary pull-xs-right">
                                        checkout
                                    </a>
                                   </div>
                                </div>
                                <div class="cart-grid-right col-xs-12 col-lg-3 mt-5 ">
                                    <div class="cart-summary shadow-sm mt-4 rounded">
                                        <div class="cart-detailed-totals">
                                            <div class=" d-flex justify-content-between">
                                                <div class="summary-label  text-white">Products Number: </div>
                                                <div class="summary-label text-white"><span class="value   font-weight-bold font-italic text-white">${cart.getOrderProducts().size()}</span></div>
                                            </div>
                                            <div class=" d-flex justify-content-between">
                                                <div class="summary-label  text-white">Total : </div>
                                                <div class="text-black  font-weight-bold font-italic text-white">${Math.round(cart.getTotalPrice())}</div>
                                            </div> 
                                            <div class=" d-flex justify-content-between">
                                                <div class="summary-label  text-white">Shipping : </div>
                                                <div class="text-black font-weight-bold font-italic text-white">Free</div>
                                            </div> 
                                            <div class=" d-flex justify-content-between">
                                                <div class="summary-label ]text-white"></div>
                                                <div class="text-black font-weight-bold font-italic text-white"></div>
                                            </div> 
                                        </div>
                                    </div>
                                    <div id="block-reassurance">
                                        <ul>
                                            <li style="padding-bottom: 0px">
                                                <div class="summary-label d-flex justify-content-between px-3">
                                                    <div class="row d-flex ">
                                                      <i class="fa fa-user" class="text-muted mr-1" aria-hidden="true"></i>
                                                        <span class="font-weight-bold font-italic h6">Name</span>
                                                    </div>
                                                    <div class="summary-label font-weight-bold font-italic"><h6 class="value">${cart.getCustomer().getUsername()}</h6></div>
                                                </div>
                                            </li>
                                            <li style="padding-bottom: 0px">
                                                <div class="summary-label d-flex justify-content-between px-3">
                                                    <div class="row d-flex ">
                                                        <i class="fa fa-credit-card-alt" class="text-muted mr-1" aria-hidden="true"></i>
                                                        <span class="font-weight-bold font-italic h6">Credit Limit</span>
                                                    </div>
                                                    <div class="summary-label font-weight-bold font-italic"><h6 class="value">${cart.getCustomer().getCreditLimit()}</h6></div>
                                                </div>
                                            </li>
                                            <li style="padding-bottom: 0px">
                                                <div class="summary-label  justify-content-between px-3">
                                                    <div class="row d-flex ">
                                                        <i class="fa fa-map-marker"  class="text-muted mr-1" aria-hidden="true"></i>
                                                        <span class="font-weight-bold font-italic h6">Address</span>
                                                    </div>
                                                        <c:if test="${not empty cart.getCustomer().getAddress()}">
                                                            <div class="summary-label font-weight-bold font-italic">
                                                                <p class="value">
                                                                    ${cart.getCustomer().getAddress().getArea()},
                                                                    ${cart.getCustomer().getAddress().getStreet()},
                                                                    ${cart.getCustomer().getAddress().getBuildingNum()},
                                                                    ${cart.getCustomer().getAddress().getFloorNum()}
                                                                </p>
                                                            </div>
                                                        </c:if>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </div>
                </div>
            </div>
        </div>
    </div>




    <%@ include file="../includes/customer-mobile-menu.jsp" %>
    <%@ include file="../includes/customer-footer.jsp" %>
<%@ include file="../includes/customer-script.jsp" %>

    <script src="assets/scripts/product-cart.js"></script>

</body>


<!-- product-cart07:12-->
</html>