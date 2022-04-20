<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.lang.Math" %>
<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if IE 9 ]><html class="ie ie9" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<!--<![endif]-->
<html lang="zxx">

<head>
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


<%@ include file="../includes/customer-mobile-menu.jsp" %>
<%@ include file="../includes/customer-footer.jsp" %>
<%@ include file="../includes/customer-script.jsp" %>

</body>


<!-- index06:45-->
</html>