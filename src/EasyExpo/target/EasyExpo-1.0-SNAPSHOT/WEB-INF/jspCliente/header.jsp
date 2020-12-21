<%--
  Created by IntelliJ IDEA.
  User: lucreziarobustelli
  Date: 21/12/2020
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="M_Adnan">
    <title>EASYEXPO - ${param.pageTitle}</title>

    <!-- SLIDER REVOLUTION 4.x CSS SETTINGS -->
    <link rel="stylesheet" type="text/css" href="rs-plugin/css/settings.css" media="screen"/>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="css/ionicons.min.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/responsive.css" rel="stylesheet">

    <!-- JavaScripts -->
    <script src="js/modernizr.js"></script>

    <!-- Online Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Playfair+Display:400,700,900' rel='stylesheet' type='text/css'>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<!-- header -->
<header>
    <div class="sticky">
        <div class="container">

            <!-- Logo -->
            <div class="logo"><a href="index.html"><img class="img-responsive" src="images/logomacchia2.png" alt=""></a>
            </div>
            <nav class="navbar ownmenu">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#nav-open-btn" aria-expanded="false"><span
                            class="sr-only">Toggle navigation</span> <span class="icon-bar"><i
                            class="fa fa-navicon"></i></span></button>
                </div>

                <!-- NAV -->
                <div class="collapse navbar-collapse" id="nav-open-btn">
                    <ul class="nav">
                        <li class="dropdown active"><a href="index.html" class="dropdown-toggle" data-toggle="dropdown">Home</a>
                        </li>
                        <li class="dropdown"><a href="#." class="dropdown-toggle" data-toggle="dropdown">Pages</a>
                            <ul class="dropdown-menu">
                                <li><a href="shop_01.html">Shop 01 </a></li>
                                <li><a href="shop_04.html">Shop 04 </a></li>
                                <li><a href="product-detail_01.html">Product Detail 01</a></li>
                                <li><a href="shopping-cart.html">Shopping Cart</a></li>
                                <li><a href="checkout.html">Checkout</a></li>
                                <li><a href="about-us_01.html">About 01</a></li>
                                <li><a href="about-us_02.html">About 02</a></li>
                                <li><a href="contact.html">Contact</a></li>
                                <li><a href="blog-list_01.html">Blog List 01</a></li>
                                <li><a href="blog-list_02.html">Blog List 02</a></li>
                                <li><a href="blog-list_03.html">Blog List 03 </a></li>
                                <li><a href="blog-detail_01.html">Blog Detail 01 </a></li>
                            </ul>
                        </li>
                        <li><a href="about-us_01.html">About </a></li>


                        <!-- MEGA MENU -->
                        <li class="dropdown megamenu"><a href="#." class="dropdown-toggle"
                                                         data-toggle="dropdown">store</a>
                            <div class="dropdown-menu">
                                <div class="row">

                                    <!-- Shop Pages -->
                                    <div class="col-md-3">
                                        <h6>Shop Pages</h6>
                                        <ul>
                                            <li><a href="shop_01.html">Shop 01 </a></li>
                                            <li><a href="shop_02.html">Shop 02</a></li>
                                            <li><a href="shop_03.html">Shop 03 </a></li>
                                            <li><a href="shop_04.html">Shop 04 </a></li>
                                            <li><a href="product-detail_01.html">Product Detail 01</a></li>
                                            <li><a href="product-detail_02.html">Product Detail 02</a></li>
                                            <li><a href="shopping-cart.html">Shopping Cart</a></li>
                                            <li><a href="checkout.html">Checkout</a></li>
                                        </ul>
                                    </div>

                                    <!-- TOp Rate Products -->
                                    <div class="col-md-4">
                                        <h6>TOp Rate Products</h6>
                                        <div class="top-rated">
                                            <ul>
                                                <li>
                                                    <div class="media-left">
                                                        <div class="cart-img"><a href="#"> <img
                                                                class="media-object img-responsive"
                                                                src="images/cart-img-1.jpg" alt="..."> </a></div>
                                                    </div>
                                                    <div class="media-body">
                                                        <h6 class="media-heading">WOOD CHAIR</h6>
                                                        <div class="stars"><i class="fa fa-star"></i> <i
                                                                class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                                                                class="fa fa-star"></i> <i class="fa fa-star"></i></div>
                                                        <span class="price">129.00 USD</span></div>
                                                </li>
                                                <li>
                                                    <div class="media-left">
                                                        <div class="cart-img"><a href="#"> <img
                                                                class="media-object img-responsive"
                                                                src="images/cart-img-2.jpg" alt="..."> </a></div>
                                                    </div>
                                                    <div class="media-body">
                                                        <h6 class="media-heading">STOOL</h6>
                                                        <div class="stars"><i class="fa fa-star"></i> <i
                                                                class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                                                                class="fa fa-star"></i> <i class="fa fa-star"></i></div>
                                                        <span class="price">129.00 USD</span></div>
                                                </li>
                                                <li>
                                                    <div class="media-left">
                                                        <div class="cart-img"><a href="#"> <img
                                                                class="media-object img-responsive"
                                                                src="images/cart-img-3.jpg" alt="..."> </a></div>
                                                    </div>
                                                    <div class="media-body">
                                                        <h6 class="media-heading">WOOD SPOON</h6>
                                                        <div class="stars"><i class="fa fa-star"></i> <i
                                                                class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                                                                class="fa fa-star"></i> <i class="fa fa-star"></i></div>
                                                        <span class="price">129.00 USD</span></div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>

                                    <!-- New Arrival -->
                                    <div class="col-md-5">
                                        <h5>NEW ARRIVAL 2016 <span>(Best Collection)</span></h5>
                                        <img class="nav-img" src="images/nav-img.png" alt="">
                                        <p>Lorem ipsum dolor sit amet,<br>
                                            consectetur adipiscing elit. <br>
                                            Donec faucibus maximus<br>
                                            vehicula.</p>
                                        <a href="#." class="btn btn-small btn-round">SHOP NOW</a></div>
                                </div>
                            </div>
                        </li>
                        <li><a href="contact.html"> contact</a></li>
                    </ul>
                </div>

                <!-- Nav Right -->
                <div class="nav-right">
                    <ul class="navbar-right">

                        <!-- USER INFO -->
                        <li class="dropdown user-acc"><a href="#" class="dropdown-toggle" data-toggle="dropdown"
                                                         role="button"><i class="icon-user"></i> </a>
                            <ul class="dropdown-menu">
                                <li>
                                    <h6>HELLO! Jhon Smith</h6>
                                </li>
                                <li><a href="#">MY CART</a></li>
                                <li><a href="#">ACCOUNT INFO</a></li>
                                <li><a href="#">LOG OUT</a></li>
                            </ul>
                        </li>

                        <!-- USER BASKET -->
                        <li class="dropdown user-basket"><a href="#" class="dropdown-toggle" data-toggle="dropdown"
                                                            role="button" aria-haspopup="true" aria-expanded="true"><i
                                class="icon-basket-loaded"></i> </a>
                            <ul class="dropdown-menu">
                                <li>
                                    <div class="media-left">
                                        <div class="cart-img"><a href="#"> <img class="media-object img-responsive"
                                                                                src="images/cart-img-1.jpg" alt="...">
                                        </a></div>
                                    </div>
                                    <div class="media-body">
                                        <h6 class="media-heading">WOOD CHAIR</h6>
                                        <span class="price">129.00 USD</span> <span class="qty">QTY: 01</span></div>
                                </li>
                                <li>
                                    <div class="media-left">
                                        <div class="cart-img"><a href="#"> <img class="media-object img-responsive"
                                                                                src="images/cart-img-2.jpg" alt="...">
                                        </a></div>
                                    </div>
                                    <div class="media-body">
                                        <h6 class="media-heading">WOOD STOOL</h6>
                                        <span class="price">129.00 USD</span> <span class="qty">QTY: 01</span></div>
                                </li>
                                <li>
                                    <h5 class="text-center">SUBTOTAL: 258.00 USD</h5>
                                </li>
                                <li class="margin-0">
                                    <div class="row">
                                        <div class="col-xs-6"><a href="shopping-cart.html" class="btn">VIEW CART</a>
                                        </div>
                                        <div class="col-xs-6 "><a href="checkout.html" class="btn">CHECK OUT</a></div>
                                    </div>
                                </li>
                            </ul>
                        </li>

                        <!-- SEARCH BAR -->
                        <li class="dropdown"><a href="javascript:void(0);" class="search-open"><i
                                class=" icon-magnifier"></i></a>
                            <div class="search-inside animated bounceInUp"><i class="icon-close search-close"></i>
                                <div class="search-overlay"></div>
                                <div class="position-center-center">
                                    <div class="search">
                                        <form>
                                            <input type="search" placeholder="Search Shop">
                                            <button type="submit"><i class="icon-check"></i></button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
</header>
</body>
</html>