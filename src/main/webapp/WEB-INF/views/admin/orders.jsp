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
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">Orders</h1>
                <div class="btn-toolbar mb-2 mb-md-0">
                    <div class="btn-group me-2">

                    </div>
                </div>
            </div>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Customer Id</th>
                    <th scope="col">Customer Email</th>
                    <th scope="col">Date of Order</th>
                    <th scope="col">Total price</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="orders" items="${orders.getOrdersDtoList()}">
                <tr>
                    <th scope="row">${orders.getId()}</th>
                    <td>${orders.getCustomer().getId()}</td>
                    <td>${orders.getCustomer().getEmail()}</td>
                    <td>${orders.getCreatedAt()}</td>
                    <td>${orders.getTotalPrice()}</td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </main>
    </div>
</div>
<%@ include file="../includes/admin-script.jsp" %>
</body>

</html>