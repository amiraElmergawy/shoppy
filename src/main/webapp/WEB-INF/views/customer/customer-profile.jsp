<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 4/11/2022
  Time: 11:08 PM
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


    <%@ include file="../includes/customer-head.jsp" %>

    <!-- Template CSS -->
    <link rel="stylesheet" type="text/css" href="assets/styles/reponsive.css">
    <link rel="stylesheet" type="text/css" href="assets/styles/style.css">
    <link rel="stylesheet" type="text/css" href="assets/styles/customer-profile.css">
    <link rel="stylesheet" type="text/css" href="assets/styles/validation-style.css">
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


                    <i class="fa fa-pencil edit-pen" id="edit"></i>

                    <div class="content" id="block-history">
                        <form id="edit-form">
                            <!-- 2 column grid layout with text inputs for the first and last names -->

                            <div class="form-outline mb-1 form-group">
                                <label class="form-label" for="name">Name</label>
                                <input type="text" id="name" class="form-control" disabled="disabled" required/>
                                <div class="error"></div>

                            </div>
                            <!-- Text input -->
                            <div class="form-outline mb-1 form-group">
                                <label class="form-label" for="jop">Jop</label>
                                <input type="text" id="jop" class="form-control" disabled="disabled" required/>
                                <div class="error"></div>
                            </div>

                            <!-- Text input -->
                            <div class="form-outline mb-1 form-group">

                                <label class="form-label" >City</label>
                                <input type="text" id="city" class="form-control" disabled="disabled" required/>
                                <div class="error"></div>
                            </div>
                            <div class="form-outline mb-1 form-group">

                                <label class="form-label" >street</label>
                                <input type="text" id="street" class="form-control" disabled="disabled" required/>
                                <div class="error"></div>
                            </div>
                            <div class="form-outline mb-1 form-group">

                                <label class="form-label" >Building Number</label>
                                <input type="text" id="building-number" class="form-control" disabled="disabled" required/>
                                <div class="error"></div>
                            </div>
                            <div class="form-outline mb-1 form-group">

                                <label class="form-label" >Floor Number</label>
                                <input type="text" id="floor-number" class="form-control" disabled="disabled" required/>
                                <div class="error"></div>
                            </div>

                            <!-- Email input -->
                            <div class="form-outline mb-1 form-group">
                                <label class="form-label" for="email">Email</label>
                                <input type="email" id="email" class="form-control" disabled="disabled"/>
                                <div class="error"></div>

                            </div>

                            <div class="form-outline mb-1 form-group">

                                <label class="form-label" for="date">Birth Date</label>
                                <input type="date" id="date" class="form-control" disabled="disabled" required/>
                                <div class="error"></div>
                            </div>
                            <div class="form-outline mb-1 form-group">
                                <label class="form-label" for="gender">Gender</label>
                                <input type="text" id="gender" class="form-control" disabled="disabled" required/>
                                <div class="error"></div>

                            </div>

                            <div class="form-outline mb-1 form-group">
                                <label class="form-label" for="interests">Favourites</label>
                                <input type="text" id="interests" class="form-control" disabled="disabled" required/>
                                <div class="error"></div>

                            </div>

                            <!-- Submit button -->
                            <button type="submit" id="submit" class="btn btn-primary btn-block mb-4 non_visible" >Save</button>
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
<script src="assets/scripts/customer-profile-validator.js"></script>
<script src="assets/scripts/forms-validator.js"></script>

</body>


<!-- user-acount11:10-->

</html>
