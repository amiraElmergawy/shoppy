<!-- back top top -->
<div class="back-to-top">
    <a href="#">
        <i class="fa fa-long-arrow-up"></i>
    </a>
</div>

<!-- menu mobie left -->

                <div id="mobile-pagemenu" class="mobile-boxpage d-flex hidden-md-up active d-md-none">
                    <div class="content-boxpage col">
                        <div class="box-header d-flex justify-content-between align-items-center">
                            <div class="title-box">Menu</div>
                            <div class="close-box">Close</div>
                        </div>
                        <div class="box-content">
                            <nav>
                                <!-- Brand and toggle get grouped for better mobile display -->
                                <div id="megamenu" class="clearfix">
                                    <ul class="menu level1">
                                        <li class="item home-page ">
                                            <a href="home" title="Home">
                                                <i class="fa fa-home" aria-hidden="true"></i>Home</a>
                                        </li>

                                        <li class="item group ">
                                            <a href="about-us" title="Page">
                                                <i class="fa fa-file-text-o" aria-hidden="true"></i>About Us</a>
                                        </li>
                                        <c:if test="${userId!=null}">
                                            <li class="item">
                                                <a href="profile" title="Log in to your customer account">
                                                    <i class="fa fa-cog" aria-hidden="true"></i>My Account</a>
                                            </li>
                                        </c:if>
                                        <c:if test="${userId==null}">
                                            <li class="item ">
                                                <a href="login" title="Log in to your customer account">
                                                    <i class="fa fa-sign-in" aria-hidden="true"></i>Sign in</a>
                                            </li>
                                        </c:if>
                                        <c:if test="${userId!=null}">
                                            <li class="item ">
                                                <a href="login" title="Log out">
                                                    <i class="fa fa-sign-out" aria-hidden="true"></i>Logout</a>
                                            </li>
                                        </c:if>


                                    </ul>
                                </div>
                            </nav>
                        </div>
                    </div>

                </div>


<!-- menu mobie right -->


