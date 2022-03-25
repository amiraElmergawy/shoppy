<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

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

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Poppins:400,500,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Nunito:400,600,700,800&display=swap" rel="stylesheet">
    <!-- libs CSS -->
    <link rel="stylesheet" type="text/css" href="../../assets/styles/user-forms.css">
    <link rel="stylesheet" type="text/css" href="../../assets/styles/validation-style.css">
    <!--scripts links-->
    <link rel="stylesheet" href="../../assets/libs/bootstrap/css/bootstrap.min.css">


</head>

<body class="user-login blog">

<div class="cont">
    <!--Sign In Form Starts-->
    <%@ include file="../shared/user-signin.jsp" %>
    <!--Sign In Form Ends-->

    <!--Sign Up Form Starts-->
    <div class="sub-cont">
        <div class="img">
            <div class="img-text m-up">
                <h2>New here?</h2>
                <p>Sign up and discover great amount of new opportunities!</p>
            </div>
            <div class="img-text m-in">
                <h2>One of us?</h2>
                <p>If you already has an account, just sign in. We've missed you!</p>
            </div>
            <div class="img-btn">
                <span class="m-up">Sign Up</span>
                <span class="m-in">Sign In</span>
            </div>
        </div>
        <div class="form sign-up sign-up-container">
            <h2>Sign Up</h2>
            <form id="sign-up-form" method="post" action="#">
                <div class="form-group">
                    <label>
                        <span>Name</span>
                    </label>
                    <input type="text" id="name" required>
                    <div class="error"></div>
                </div>
                <div class="form-group">
                    <label>
                        <span>Email</span>
                    </label>
                    <input type="email" id="sign-up-email" required>
                    <div class="error"></div>
                </div>

                <div class="form-group">
                    <label>
                        <span>Password</span>
                    </label>
                    <input type="password" id="sign-up-password" required>
                    <div class="error"></div>
                </div>
                <div class="form-group">
                    <label>
                        <span>Confirm Password</span>
                    </label>
                    <input type="password" id="confirm-password" required>
                    <div class="error"></div>
                </div>
                <div class="form-group" required>
                    <label>
                        <span>Your Birth Date</span>
                    </label>
                    <input type="date" id="date" required>
                    <div class="error"></div>
                </div>
                <div class="form-group">

                </div>
                <div class="form-group">
                    <label>
                        <span>Favourites </span>
                    </label>
                    <i class="fa fa-pencil"></i>
                    <select name="interests" id="interests" class="list" required>
                        <option value="Chairs">Chairs</option>
                        <option value="Rooms">Rooms</option>
                        <option value="Kitchen">Kitchen</option>
                        <option value="Accessories">Accessories</option>
                    </select>
                    <div class="error"></div>
                </div>
                <div class="form-group">
                    <label>
                        <span>Gender </span>
                    </label>
                    <select name="gender" id="gender" class="list" required>
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                    </select>
                    <div class="error"></div>
                </div>

                <button type="submit " class="submit submit-btn">Sign Up Now</button>
            </form>
        </div>
        <!--Sign Up Form Ends-->
    </div>
</div>

<!-- Vendor JS -->
<script src="../../assets/libs/jquery/jquery.min.js"></script>
<script src="../../assets/libs/bootstrap/js/bootstrap.min.js"></script>

<!-- Template JS -->
<script type="text/javascript" src="../../assets/scripts/forms.js"></script>
<script type="text/javascript" src="../../assets/scripts/forms-validator.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>


<!-- user-login11:10-->

</html>