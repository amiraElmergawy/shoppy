<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.lang.Math" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Shoppy Dashboard</title>

    <%@ include file="../includes/admin-head.jsp" %>
</head>

<body>

<%@ include file="../includes/admin-header.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@ include file="../includes/admin-sidebar.jsp" %>
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div
                    class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <div class="d-flex">
                    <img src="assets/images/icons/add_product_icon.png">
                    <h1 class="">Edit Product</h1>
                </div>
            </div>
            <div>
                <form action="" method="" id="form" class="my-3">

                    <div class="row">
                        <div class="form-group my-2 col-sm-6">
                            <label for="productName" class="my-1">&nbsp;&nbsp;&nbsp;Name</label>
                            <input type="text" class="form-control" id="productName" size="150"
                                   placeholder="Product Name" value="${productDto.getProductName()}" required>
                            <div class="error"></div>
                        </div>
                        <div class="form-group my-2 col-sm-6">
                            <label for="category" class="my-1">Category</label>
                            <div class="row">
                                <div class="col-10 gx-0">

                                    <select class="form-control" id="category" required>
                                        <option selected disabled value="">${productDto.getCategory()}</option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                    </select>
                                </div>
                                <div class="col-2 btn btn-success">
                                    <img src="assets/images/icons/white_plus_icon-removebg-preview.png"
                                         style="width: 30px;">
                                </div>
                            </div>
                            <div class="error"></div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group my-2 col-sm-6 ">
                            <label for="price" class="my-1">&nbsp;&nbsp;&nbsp;Price</label>
                            <input type="number" class="form-control" id="price" min="0"
                                   placeholder="Product Price" value="${productDto.getPrice()}" required>
                            <div class="error"></div>
                        </div>
                        <div class="form-group my-2  col-sm-6 gx-0">
                            <label for="stock" class="my-1">&nbsp;&nbsp;&nbsp;Quantity</label>
                            <input type="number" class="form-control" id="stock" min="0"
                                   placeholder="Product Quantity" value="${productDto.getStock()}" required>
                            <div class="error"></div>
                        </div>
                    </div>
                    <div class="form-group my-2">
                        <div id="imagesArea"
                             style="min-height: 200px; border: 1px dashed rgb(184, 182, 182);" class="p-2">
                            Choose Product Images
                            <input type="file" class="form-control w-50 m-auto my-1" id="images"
                                   accept=".jpeg,.jpg,.png,.gif" required>
                            <div class="error"></div>
                        </div>
                    </div>
                    <div class="form-group my-2">
                        <label for="desc" class="my-1">&nbsp;&nbsp;&nbsp;Description</label>
                        <textarea class="form-control input" id="desc" rows="3" required>${productDto.getProductDesc()}</textarea>
                        <div class="error"></div>
                    </div>
                    <button type="submit" class="btn btn-success my-2">Edit Product</button>
                </form>
            </div>
        </main>
    </div>
</div>


<%@ include file="../includes/admin-script.jsp" %>
<script src="assets/scripts/forms-validator.js"></script>
<script src="assets/scripts/add-product.js"></script>

</body>

</html>