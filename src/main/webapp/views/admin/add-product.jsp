<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Shoppy Dashboard</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>


    <!-- Custom styles for this template -->
    <link href="../../styles/dashboard.css" rel="stylesheet">
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
                                <img src="./../../images/icons/add_product_icon.png">
                                <h1 class="">Add Product</h1>
                            </div>
                            <!-- <div class="btn-toolbar mb-2 mb-md-0">
                                <div class="btn-group me-2">
                                    <button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
                                    <button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
                                </div>
                                <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
                                    <span data-feather="calendar"></span>
                                    This week
                                </button>
                            </div> -->
                        </div>


                        <div>
                            <!--
                                pname varchar(150) not null,
	                            category_id integer not null,
	                            price double not null,
	                            stock integer not null,
	                            img_path text not null,
	                            desc text not null,
                            -->

                            <form action="" method="" class="my-3">

                                <div class="row">
                                    <div class="form-group col-6">
                                        <label for="productName" class="my-1">Name</label>
                                        <input type="text" class="form-control" id="productName" size="150"
                                        placeholder="Product Name">
                                    </div>
                                    <div class="form-group col-6">
                                        <label for="category" class="my-1">Category</label>
                                        <select class="form-control" id="category">
                                            <option selected disabled>Select Category...</option>
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                        </select>
                                    </div>
                                </div>
                                    <div class="form-group">
                                        <label for="exampleFormControlTextarea1">Example textarea</label>
                                        <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                                    </div>
                                <button type="submit" class="btn btn-success my-2">Save Product</button>
                            </form>
                        </div>
                    </main>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js"
            integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE"
            crossorigin="anonymous"></script>
        <!-- <script src="../../scripts/dashboard.js"></script> -->
</body>

</html>