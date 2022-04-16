<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <title>Furnitica - Minimalist Furniture HTML Template</title>

    <%@ include file="../includes/customer-head.jsp" %>
    <c:url value="/" var="imagesUrl" context="/images"/>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

    <script src="assets/scripts/product-details.js"></script>
</head>

<body id="product-detail">
<%@ include file="../includes/customer-header.jsp" %>

    <!-- main content -->
    <div class="main-content container">
        <div id="wrapper-site">
            <div id="content-wrapper">
                <div id="main">
                    <div class="page-home">

                        <!-- breadcrumb -->
                        <div class="container">
                            <div class="content mt-1">
                                <div class="row">
                                    
                                    <div class="col-sm-11 col-lg-12 col-md-12">

                                        <div>
                                             <c:if test="${not empty param.error}">
                                                 <c:if test="${param.error == true}">
                                                    <div class="alert-danger text-center h6 py-2" id="invaled" style="height: 35px">
                                                        could not add product to card
                                                    </div>
                                                 </c:if>
                                                 <c:if test="${param.error == false}">
                                                     <div class="alert-success text-center h6 py-2" id="valed" style="height: 35px">
                                                         product added to cart
                                                     </div>
                                                 </c:if>
                                             </c:if>
                                            <c:if test="${productDto.getStock() == 0}">
                                                <div class="alert-secondary text-center h6 py-2" id="valed" style="height: 35px">
                                                    product out of stock
                                                </div>
                                            </c:if>

                                        </div>
                                        <div class="main-product-detail">
                                            <div class="product-single row">
                                                <div class="product-detail col-xs-12 col-md-5 col-sm-5">
                                                    <div class="page-content" id="content">
                                                        <div class="images-container">
                                                            <div class="js-qv-mask mask tab-content ">
                                                                <div id="item1" class="tab-pane fade active in show border-0">
                                                                    <img src="${imagesUrl}${productDto.getImagesPaths().get(0)}" alt="img">
                                                                </div>
                                                                <c:forEach begin="1" end="${productDto.getImagesPaths().size()-1}" var="current">
                                                                    <div id="item${current}" class="tab-pane fade">
                                                                        <img src="${imagesUrl}${productDto.getImagesPaths().get(current)}" alt="img">
                                                                    </div>
                                                                </c:forEach>
                                                                <div class="layer hidden-sm-down" data-toggle="modal" data-target="#product-modal">
                                                                    <i class="fa fa-expand"></i>
                                                                </div>
                                                            </div>
                                                            <ul class="product-tab nav nav-tabs d-flex">
                                                                <c:forEach begin="1" end="${productDto.getImagesPaths().size()-1}" var="current">
                                                                    <li class="active col ">
                                                                        <a href="#item${current}" data-toggle="tab" aria-expanded="true" class="active show shadow rounded p-1 border-0">
                                                                            <img src="${imagesUrl}${productDto.getImagesPaths().get(current)}" alt="img">
                                                                        </a>
                                                                    </li>
                                                                </c:forEach>
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
                                                                                                <c:forEach begin="1" end="${productDto.getImagesPaths().size()-1}" var="current">
                                                                                                    <div id="modal-item${current}" class="tab-pane fade active in show">
                                                                                                        <img class="img-fluid" src="${imagesUrl}${productDto.getImagesPaths().get(current)}" alt="img">
                                                                                                    </div>
                                                                                                </c:forEach>
                                                                                            </div>
                                                                                            <ul class="product-tab nav nav-tabs">
                                                                                                <c:forEach begin="1" end="${productDto.getImagesPaths().size()-1}" var="current">
                                                                                                    <li class="active">
                                                                                                        <a href="#modal-item${current}" data-toggle="tab" class=" active show">
                                                                                                            <img src="${imagesUrl}${productDto.getImagesPaths().get(current)}" alt="img">
                                                                                                        </a>
                                                                                                    </li>
                                                                                                </c:forEach>
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
                                                            <div class="row d-flex " style="justify-content: space-between; margin: 0px 3px 3px;">
                                                                    <h1 class="product-name" name="productName ">${productDto.getProductName()}</h1>
                                                                <span class="float-right mt-1 mb-sm-1">
                                                                <span class="availb">Availability: </span>
                                                                <span class="check">
                                                                    <i class="fa fa-check-square-o" aria-hidden="true"></i>${productDto.getStock()} IN STOCK</span>
                                                            </span>
                                                            </div>


                                                        </div>
                                                            <h2 font-size="25px"  class="font-color font-weight-bold ">${productDto.getPrice()} LE</h2>
                                                            <h6 font-size="14px" class="text-muted mr-2 mb-4">${productDto.getProductDesc()}</h6>
                                                   

                                                        <div class="cart-area has-border ">
                                                            <div class="product-quantity">
                                                                <div class="qty">
                                                                    <div class="input-group d-flex">
                                                                        <div class="quantity" style="width:120px">
                                                                            
                                                                                <div class="quantity d-flex ">
                                                                                    <div id="minus" class="shadow-sm btn-sm btn-primary font-weight-bold">
                                                                                        -
                                                                                    </div>
                                                                                    <div class="btn-sm bg-white font-weight-bold mx-2">
                                                                                        1
                                                                                    </div>
                                                                                    <div id="plus" class="shadow-sm btn-sm btn-primary font-weight-bold">
                                                                                        +
                                                                                    </div>
                                                                                </div>
                                                                                
                                                                        
                                                                        </div>
                                                                        <span class="add" style="margin-top: -10px;">
<%--                                                                                <button class="btn btn-primary add-to-cart add-item" type="submit">--%>
<%--                                                                                <button class="btn btn-primary add-to-cart add-item" onclick="addProduct(${productDto.getId()})">--%>
<%--                                                                                    <a href="add-to-cart?productId=${productDto.getId()}">--%>
                                                                                        <form method="get" action="add-to-cart">
                                                                                            <input style="display: none" type="number" name="productId" value="${productDto.getId()}"/><br>
                                                                                            <c:choose>
                                                                                                <c:when test="${productDto.getStock() > 0}">
                                                                                                    <button class="btn btn-primary add-to-cart add-item" type="submit">
                                                                                                            <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                                                                                            <span>Add to cart</span>
                                                                                                    </button>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                    <button class="btn btn-primary disabled add-to-cart add-item" disabled>
                                                                                                            <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                                                                                            <span>Add to cart</span>
                                                                                                    </button>
                                                                                                </c:otherwise>
                                                                                            </c:choose>



                                                                                       </form>
                                                                            <a class="addToWishlist" href="#">
                                                                                <i class="fa fa-heart" aria-hidden="true"></i>
                                                                            </a>
                                                                        </span>
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
<%--                                                        <div class="review">--%>
<%--                                                            <ul class="nav nav-tabs">--%>
<%--                                                                <li class="active">--%>
<%--                                                                    <a data-toggle="tab" href="#description" class="active show font-weight-bold font-italic h6">Description</a>--%>
<%--                                                                </li>--%>
<%--                                                                <li  style="margin-top: 0px;">--%>
<%--                                                                    <a data-toggle="tab" href="#review" class="font-weight-bold font-italic h6">Reviews (2)</a>--%>
<%--                                                                </li>--%>
<%--                                                            </ul>--%>
<%--                                                            --%>
<%--                                                            <div class="tab-content">--%>
<%--                                                                <div id="description" class="tab-pane fade in active show">--%>
<%--                                                                    <p  class="text-muted  mb-2 text-2" style="font-family: 'Open Sans', 'Roboto' ;font-size: 14px">--%>
<%--                                                                        ${productDto.getProductDesc()}--%>
<%--                                                                    </p>--%>
<%--                                                                </div>--%>
<%--                                                                --%>
<%--                                                                <div id="review" class="tab-pane fade">--%>
<%--                                                                    <div class="spr-form">--%>
<%--                                                                        <div class="user-comment">--%>
<%--                                                                            <div class="spr-review">--%>
<%--                                                                                <div class="spr-review-header">--%>
<%--                                                                                    <span class="spr-review-header-byline">--%>
<%--                                                                                        <strong>Peter Capidal</strong> ---%>
<%--                                                                                        <span>Apr 14, 2018</span>--%>
<%--                                                                                    </span>--%>
<%--                                                                                    <div class="rating">--%>
<%--                                                                                        <div class="star-content">--%>
<%--                                                                                            <div class="star"></div>--%>
<%--                                                                                            <div class="star"></div>--%>
<%--                                                                                            <div class="star"></div>--%>
<%--                                                                                            <div class="star"></div>--%>
<%--                                                                                            <div class="star"></div>--%>
<%--                                                                                        </div>--%>
<%--                                                                                    </div>--%>
<%--                                                                                </div>--%>
<%--                                                                                <div class="spr-review-content">--%>
<%--                                                                                    <p class="spr-review-content-body">In feugiat venenatis enim, non finibus metus bibendum--%>
<%--                                                                                        eu. Proin massa justo, eleifend fermentum varius--%>
<%--                                                                                        quis, semper gravida quam. Cras nec enim sed--%>
<%--                                                                                        lacus viverra luctus. Nunc quis accumsan mauris.--%>
<%--                                                                                        Aliquam fermentum sit amet est id scelerisque.--%>
<%--                                                                                        Nam porta risus metus.</p>--%>
<%--                                                                                </div>--%>
<%--                                                                            </div>--%>
<%--                                                                            <div class="spr-review preview2">--%>
<%--                                                                                <div class="spr-review-header">--%>
<%--                                                                                    <span class="spr-review-header-byline">--%>
<%--                                                                                        <strong>David James</strong> ---%>
<%--                                                                                        <span>Apr 13, 2018</span>--%>
<%--                                                                                    </span>--%>
<%--                                                                                    <div class="rating">--%>
<%--                                                                                        <div class="star-content">--%>
<%--                                                                                            <div class="star"></div>--%>
<%--                                                                                            <div class="star"></div>--%>
<%--                                                                                            <div class="star"></div>--%>
<%--                                                                                            <div class="star"></div>--%>
<%--                                                                                            <div class="star"></div>--%>
<%--                                                                                        </div>--%>
<%--                                                                                    </div>--%>
<%--                                                                                </div>--%>
<%--                                                                                <div class="spr-review-content">--%>
<%--                                                                                    <p class="spr-review-content-body">In feugiat venenatis enim, non finibus metus bibendum--%>
<%--                                                                                        eu. Proin massa justo, eleifend fermentum varius--%>
<%--                                                                                        quis, semper gravida quam. Cras nec enim sed--%>
<%--                                                                                        lacus viverra luctus. Nunc quis accumsan mauris.--%>
<%--                                                                                        Aliquam fermentum sit amet est id scelerisque.--%>
<%--                                                                                        Nam porta risus metus.</p>--%>
<%--                                                                                </div>--%>
<%--                                                                            </div>--%>
<%--                                                                        </div>--%>
<%--                                                                    </div>--%>
<%--                                                                    <form method="post" action="#" class="new-review-form">--%>
<%--                                                                        <input type="hidden" name="review[rating]" value="3">--%>
<%--                                                                        <input type="hidden" name="product_id">--%>
<%--                                                                        <h3 class="spr-form-title">Write a review</h3>--%>
<%--                                                                        <fieldset>--%>
<%--                                                                            <div class="spr-form-review-rating">--%>
<%--                                                                                <label class="spr-form-label">Your Rating</label>--%>
<%--                                                                                <fieldset class="ratings">--%>
<%--                                                                                    <input type="radio" id="star5" name="rating" value="5" />--%>
<%--                                                                                    <label class="full" for="star5" title="Awesome - 5 stars"></label>--%>
<%--                                                                                    <input type="radio" id="star4half" name="rating" value="4 and a half" />--%>
<%--                                                                                    <input type="radio" id="star4" name="rating" value="4" />--%>
<%--                                                                                    <label class="full" for="star4" title="Pretty good - 4 stars"></label>--%>
<%--                                                                                    <input type="radio" id="star3half" name="rating" value="3 and a half" />--%>
<%--                                                                                    <input type="radio" id="star3" name="rating" value="3" />--%>
<%--                                                                                    <label class="full" for="star3" title="Meh - 3 stars"></label>--%>
<%--                                                                                    <input type="radio" id="star2half" name="rating" value="2 and a half" />--%>
<%--                                                                                    <input type="radio" id="star2" name="rating" value="2" />--%>
<%--                                                                                    <label class="full" for="star2" title="Kinda bad - 2 stars"></label>--%>
<%--                                                                                    <input type="radio" id="star1half" name="rating" value="1 and a half" />--%>
<%--                                                                                    <input type="radio" id="star1" name="rating" value="1" />--%>
<%--                                                                                    <label class="full" for="star1" title="Sucks big time - 1 star"></label>--%>
<%--                                                                                    <input type="radio" id="starhalf" name="rating" value="half" />--%>
<%--                                                                                </fieldset>--%>
<%--                                                                            </div>--%>
<%--                                                                        </fieldset>--%>
<%--                                                                        <fieldset class="spr-form-contact">--%>
<%--                                                                            <div class="spr-form-contact-name">--%>
<%--                                                                                <input class="spr-form-input spr-form-input-text form-control" value="" placeholder="Enter your name">--%>
<%--                                                                            </div>--%>
<%--                                                                            <div class="spr-form-contact-email">--%>
<%--                                                                                <input class="spr-form-input spr-form-input-email form-control" value="" placeholder="Enter your email">--%>
<%--                                                                            </div>--%>
<%--                                                                        </fieldset>--%>
<%--                                                                        <fieldset>--%>
<%--                                                                            <div class="spr-form-review-body">--%>
<%--                                                                                <div class="spr-form-input">--%>
<%--                                                                                    <textarea class="spr-form-input-textarea" rows="10" placeholder="Write your comments here"></textarea>--%>
<%--                                                                                </div>--%>
<%--                                                                            </div>--%>
<%--                                                                        </fieldset>--%>
<%--                                                                        <div class="submit">--%>
<%--                                                                            <input type="submit" name="addComment" id="submitComment" class="btn btn-default" value="Submit Review">--%>
<%--                                                                        </div>--%>
<%--                                                                    </form>--%>
<%--                                                                </div>--%>
<%--                                                                --%>
<%--                                                            </div>--%>
<%--                                                        </div>--%>
<%--                                                       --%>
                                                    </div>
                                                </div>
                                            </div>
											
                                           
                                            <div class="related">
                                                <div class="title-tab-content ">
                                                    <div class="title-product justify-content-start">
                                                        <h2>Related Products</h2>
                                                    </div>
                                                </div>
                                                <div class="tab-content">
                                                    <div class="row ">
                                                        <div class="item text-center col-md-3">
                                                            <div class="product-miniature js-product-miniature item-one first-item">
                                                                <div class="thumbnail-container border">
                                                                    <a href="product-detail.jsp">
                                                                        <img class="img-fluid image-cover" src="assets/images/product/1.jpg" alt="img">
                                                                        <img class="img-fluid image-secondary" src="assets/images/product/22.jpg" alt="img">
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
                                                                            <a href="product-detail.jsp">Nulla et justo non augue</a>
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
                                                                                <span class="price">£28.08</span>
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
                                                        <div class="item text-center col-md-3">
                                                            <div class="product-miniature js-product-miniature item-one first-item">
                                                                <div class="thumbnail-container border">
                                                                    <a href="product-detail.jsp">
                                                                        <img class="img-fluid image-cover" src="assets/images/product/2.jpg" alt="img">
                                                                        <img class="img-fluid image-secondary" src="assets/images/product/11.jpg" alt="img">
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
                                                                            <a href="product-detail.jsp">Nulla et justo non augue</a>
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
                                                                                <span class="price">£31.08</span>
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
                                                        <div class="item text-center col-md-3">
                                                            <div class="product-miniature js-product-miniature item-one first-item">
                                                                <div class="thumbnail-container border">
                                                                    <a href="product-detail.jsp">
                                                                        <img class="img-fluid image-cover" src="assets/images/product/3.jpg" alt="img">
                                                                        <img class="img-fluid image-secondary" src="assets/images/product/14.jpg" alt="img">
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
                                                                            <a href="product-detail.jsp">Nulla et justo non augue</a>
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

                                                        <div class="item text-center col-md-3">
                                                            <div class="product-miniature js-product-miniature item-one first-item">
                                                                <div class="thumbnail-container border">
                                                                    <a href="product-detail.jsp">
                                                                        <img class="img-fluid image-cover" src="assets/images/product/3.jpg" alt="img">
                                                                        <img class="img-fluid image-secondary" src="assets/images/product/14.jpg" alt="img">
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
                                                                            <a href="product-detail.jsp">Nulla et justo non augue</a>
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

    <!-- footer -->


<%@ include file="../includes/customer-mobile-menu.jsp" %>
<%@ include file="../includes/customer-footer.jsp" %>
<%@ include file="../includes/customer-script.jsp" %>

</body>
</html>