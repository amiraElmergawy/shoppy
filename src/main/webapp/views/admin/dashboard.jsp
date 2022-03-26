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
              <h1 class="h2">Dashboard</h1>
              <div class="btn-toolbar mb-2 mb-md-0">
                <div class="btn-group me-2">
                  <button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
                  <button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
                </div>
                <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
                  <span data-feather="calendar"></span>
                  This week
                </button>
              </div>
            </div>

            <canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>

          </main>
      </div>
    </div>
  <%@ include file="../includes/admin-script.jsp" %>
</body>

</html>