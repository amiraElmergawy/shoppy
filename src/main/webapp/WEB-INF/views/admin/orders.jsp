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
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>56</td>
                    <td>hesham@git.com</td>
                    <td>9/9/2022</td>
                    <td>445$</td>
                    <td>
                        <a href="" style="color: #333333">
                            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-arrow-right-circle-fill" viewBox="0 0 16 16">
                                <path d="M8 0a8 8 0 1 1 0 16A8 8 0 0 1 8 0zM4.5 7.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H4.5z"/>
                            </svg>
                        </a>
                    </td>
                </tr>
                </tbody>
            </table>
        </main>
    </div>
</div>
<%@ include file="../includes/admin-script.jsp" %>
</body>

</html>