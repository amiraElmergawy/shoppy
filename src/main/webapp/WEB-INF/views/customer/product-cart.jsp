<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if IE 9 ]><html class="ie ie9" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<!--<![endif]-->
<html lang="en">


<!-- product-cart07:06-->
<head>
    <!-- Basic Page Needs -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Furnitica - Minimalist Furniture HTML Template</title>


    <%@ include file="../includes/customer-head.jsp" %>
</head>

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
                                    <div class="cart-container">
                                       <c:forEach var="orderProduct" items="${cart.getOrderProducts()}">
                                        <div class="cart-overview js-cart">
                                            <ul class="cart-items">
                                                <li class="cart-item bg-white rounded shadow-lg mb-2">
                                                    <div class="product-line-grid row justify-content-between">
                                                        <!--  product left content: image-->
                                                        <div class="product-line-grid-left col-md-2">
                                                            <span class="product-image media-middle">
                                                                <a href="product-detail.jsp">
                                                                    <img class="img-fluid" src="images${orderProduct.getProduct().getImagesPaths().get(0)}" alt="Organic Strawberry Fruits">
                                                                </a>
                                                            </span>
                                                        </div>
                                                        <div class="product-line-grid-body col-md-6 ">
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
<%--                                                            <div class="product-line-info">--%>
<%--                                                                <span class="label-atrr">Size:</span>--%>
<%--                                                                <span class="value">S</span>--%>
<%--                                                            </div>--%>
<%--                                                            <div class="product-line-info">--%>
<%--                                                                <span class="label-atrr">Color:</span>--%>
<%--                                                                <span class="value">Blue</span>--%>
<%--                                                            </div>--%>
                                                        </div>
                                                        <div class="product-line-grid-right text-center product-line-actions col-md-4 justify-content-between">
                                                            <div class="row">
                                                                <div class="col-md-5 col m-auto ">
                                                                    <div class="quantity d-flex ">
                                                                        <div id="minus" class="shadow-sm btn-sm btn-primary font-weight-bold">
                                                                            -
                                                                        </div>
                                                                        <div class="btn-sm bg-white font-weight-bold mx-2">
                                                                                ${orderProduct.getQuantity()}
                                                                        </div>
                                                                        <div id="plus" class="shadow-sm btn-sm btn-primary font-weight-bold">
                                                                            +
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-5 price col m-auto">
                                                                    <div class="product-price total ">
                                                                        ${orderProduct.getTotal()} EG
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-2 text-xs-right align-self-end col">
                                                                    <div class="cart-line-product-actions m-0">
                                                                        <a class="remove-from-cart m-0" rel="nofollow" href="#" data-link-action="delete-from-cart" data-id-product="1">
                                                                            <i class="fa fa-trash-o" aria-hidden="true"></i>
                                                                        </a>
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
                                <!-- <div class="cart-grid-right col-xs-12 col-lg-3 mt-5">
                                    <div class="cart-summary bg-white rounded shadow-sm mt-4">
                                        <div >
                                            <div class=" d-flex justify-content-between">
                                                <div class="summary-label text-muted">Products Number: </div>
                                                <div class="summary-label text-muted"><span class="value  text-dark font-weight-bold font-italic">3</span></div>
                                            </div>
                                            <div class=" d-flex justify-content-between">
                                                <div class="summary-label text-muted">Total : </div>
                                                <div class="text-black text-dark font-weight-bold font-italic">£200.00</div>
                                            </div> 
                                            <div class=" d-flex justify-content-between">
                                                <div class="summary-label text-muted">Shipping : </div>
                                                <div class="text-black text-dark font-weight-bold font-italic">Free</div>
                                            </div> 
                                            <div class=" d-flex justify-content-between">
                                                <div class="summary-label text-muted"></div>
                                                <div class="text-black text-dark font-weight-bold font-italic"></div>
                                            </div> 
                                           
                                        </div>
                                    </div>
                                   
                                </div> -->
                                <div class="cart-grid-right col-xs-12 col-lg-3 mt-5 ">
                                    <div class="cart-summary shadow-sm mt-4 rounded">
                                        <div class="cart-detailed-totals">
                                            <div class=" d-flex justify-content-between">
                                                <div class="summary-label  text-white">Products Number: </div>
                                                <div class="summary-label text-white"><span class="value   font-weight-bold font-italic text-white">${cart.getOrderProducts().size()}</span></div>
                                            </div>
                                            <div class=" d-flex justify-content-between">
                                                <div class="summary-label  text-white">Total : </div>
                                                <div class="text-black  font-weight-bold font-italic text-white">${cart.getTotalPrice()}</div>
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

</body>


<!-- product-cart07:12-->
</html>