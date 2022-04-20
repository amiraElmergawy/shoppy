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
    <title>Shoppy</title>


    <%@ include file="../includes/customer-head.jsp" %>
    <style>
        .minusAndPlusFont{
            font-size: 20px;
            font-weight: bold;
        }
        .minusAndPlusBtnView{
            width: 40px;
            justify-content: center;
            align-items: center;
            text-align: center;
            color: white;
        }
        .quantity{
            width: 40px;
            justify-content: center;
            align-items: center;
            text-align: center;
            /* height: 40px; */
            /* color: white; */
            margin-top: 8px;
            font-size: 16px;
        }
    </style>

    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>

<body class="product-cart checkout-cart blog">
<%@ include file="../includes/customer-header.jsp" %>

    <!-- main content -->
    <div class="main-content bg-light pb-5" id="cart">
        <!-- main -->
        <div id="wrapper-site">
            <div class="container ">
                <div class="row">
                    <div id="content-wrapper" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 onecol">
                        <section id="main" class="mt-2">
                            <div class="cart-grid row">
                                <div class="col-md-9 col-xs-12 check-info" id="cartContainer">
                                    <h1 class="title-page mt-4">Shopping Cart</h1>
                                    <div class="d-none alert-danger p-2 mb-4 text-center h6" id="error"></div>
                                    <div class="cart-container" id="productsContainer">
                                       <c:forEach var="orderProduct" items="${cart.getOrderProducts()}">
                                        <div class="cart-overview js-cart" id=${orderProduct.getProduct().getId()}>
                                            <ul class="cart-items">
                                                <li class="cart-item bg-white rounded shadow-lg mb-2 py-4">
                                                    <div class="product-line-grid row justify-content-between">
                                                        <div class="product-line-grid-left col-md-2">
                                                            <span class="product-image media-middle">
                                                                <a href="product-details?productID">
                                                                    <img class="img-fluid" src="images${orderProduct.getProduct().getImagesPaths().get(0)}" alt="Organic Strawberry Fruits"/>
                                                                </a>
                                                            </span>
                                                        </div>
                                                        <div class="product-line-grid-body col-md-4 ">
                                                            <div class="product-line-info">
                                                                <a class="label" href="product-detail.jsp" data-id_customization="0" style="font-size: 18px">
                                                                    ${orderProduct.getProduct().getProductName()}
                                                                </a>
                                                               
                                                            </div>
                                                            <div class="product-line-info product-price">
                                                                  <span class="font-weight-bold text-muted text-lg-center" style="font-size: 14px">
                                                                          ${orderProduct.getProduct().getProductDesc()}
                                                                  </span>
<%--                                                                <span class="value" id=${orderProduct.getProduct().getId()}price>${orderProduct.getProduct().getPrice()}</span> EG--%>
                                                            </div>
                                                        </div>
                                                        <div class="product-line-grid-right text-center product-line-actions col-md-6 justify-content-between">
                                                            <div class="row mt-2">
                                                                <div class="col-md-3 col m-auto ">
                                                                    <div class="quantity d-flex ml-0" style="width: 140px;">
                                                                        <div id="minus" class="btn shadow-sm rounded minusAndPlusBtnView" onclick="decreaseProduct(${orderProduct.getProduct().getId()})">
                                                                            <span class="minusAndPlusFont">
                                                                                -
                                                                            </span>
                                                                        </div>
                                                                        <div id=${orderProduct.getProduct().getId()}quantity class="btn-sm bg-white font-weight-bold mx-2 quantity">
                                                                                ${orderProduct.getQuantity()}
                                                                        </div>
                                                                        <div id="plus" class="btn shadow-sm rounded minusAndPlusBtnView" onclick="increaseProduct(${orderProduct.getProduct().getId()})">
                                                                             <span class="minusAndPlusFont">
                                                                                +
                                                                            </span>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-3 price col m-auto">
                                                                    <span class="product-price total " id=${orderProduct.getProduct().getId()}productTotal style="font-size: 16px;">
                                                                            ${Math.round(orderProduct.getTotal())}
                                                                    </span>
                                                                    <span class="product-price total " style="font-size: 16px; margin-left: 10px">
                                                                     EG
                                                                    </span>

                                                                </div>
                                                                <div class="col-md-1 text-xs-right align-self-end col mt-4">
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
                                       <%@ include file="../includes/cart-modal.jsp" %>
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
                                                <div class="text-black  font-weight-bold font-italic text-white" id="productsTotal">
                                                    <c:if test="${not empty cart}">
                                                        ${Math.round(cart.getTotalPrice())}
                                                    </c:if>
                                                </div>
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
                                                    <div class="summary-label font-weight-bold font-italic"><h6 class="value" id="creditLimit">${cart.getCustomer().getCreditLimit()}</h6></div>
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