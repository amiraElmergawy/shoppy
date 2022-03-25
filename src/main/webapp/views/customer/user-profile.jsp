<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 3/25/2022
  Time: 7:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if IE 9 ]><html class="ie ie9" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<!--<![endif]-->
<html lang="en">


<!-- user-acount11:10-->

<head>
    <!-- Basic Page Needs -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Furnitica - Minimalist Furniture HTML Template</title>

    <meta name="keywords" content="Furniture, Decor, Interior">
    <meta name="description" content="Furnitica - Minimalist Furniture HTML Template">
    <meta name="author" content="tivatheme">

    <!-- Mobile Meta -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <%@ include file="../includes/customer-head.jsp" %>

    <!-- Template CSS -->
    <link rel="stylesheet" type="text/css" href="../../assets/styles/reponsive.css">
    <link rel="stylesheet" type="text/css" href="../../assets/styles/style.css">
    <link rel="stylesheet" type="text/css" href="../../assets/styles/user-profile.css">
</head>

<body class="user-acount">
<%@ include file="../includes/customer-header.jsp" %>

<!-- main content -->
<div class="main-content">
    <div class="wrap-banner">

        <!-- breadcrumb -->
        <nav class="breadcrumb-bg">
            <div class="container no-index">
                <div class="breadcrumb">
                    <ol>
                        <li>
                            <a href="#">
                                <span>Home</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span>My Account</span>
                            </a>
                        </li>
                    </ol>
                </div>
            </div>
        </nav>

        <div class="acount head-acount">
            <div class="container">
                <div id="main">
                    <h1 class="title-page">My Account</h1>

                    <a href="#">
                        <i class="fa fa-pencil edit-pen"></i>
                    </a>
                    <div class="content" id="block-history">
                        <form>
                            <!-- 2 column grid layout with text inputs for the first and last names -->

                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form6Example1">Name</label>
                                        <input type="text" id="form6Example1" class="form-control" />

                                    </div>




                            <!-- Text input -->
                            <div class="form-outline mb-4">
                                <label class="form-label" for="form6Example3">Jop</label>
                                <input type="text" id="form6Example3" class="form-control" />

                            </div>

                            <!-- Text input -->
                            <div class="form-outline mb-4">

                                <label class="form-label" >Address</label>
                                <input type="text" id="floor" class="form-control" />
                            </div>

                            <!-- Email input -->
                            <div class="form-outline mb-4">
                                <label class="form-label" for="form6Example5">Email</label>
                                <input type="email" id="form6Example5" class="form-control" disabled/>

                            </div>

                            <div class="form-outline mb-4">

                                <label class="form-label" for="date">Birth Date</label>
                                <input type="date" id="date" class="form-control" />
                            </div>
                            <div class="form-outline mb-4">
                                <label class="form-label" for="gender">Gender</label>
                                <input type="text" id="gender" class="form-control" />

                            </div>

                            <div class="form-outline mb-4">
                                <label class="form-label" for="gender">Favourites</label>
                                <input type="text" id="interestes" class="form-control" />

                            </div>

                            <!-- Submit button -->
                            <button type="submit" class="btn btn-primary btn-block mb-4" style="display: none">Place order</button>
                        </form>

                    </div>
                    <button class="btn btn-primary" data-link-action="sign-in" type="button">
                        Change Password
                    </button>
                    <div class="order">
                        <h4>Order
                            <span class="detail">History</span>
                        </h4>
                        <p>You haven't placed any orders yet.</p>
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

<%@ include file="../includes/customer-footer.jsp" %>
<script src="../../assets/scripts/forms-validator.js"></script>
<script src="../../assets/scripts/user-profile-validator.js"></script>

</body>


<!-- user-acount11:10-->

</html>
