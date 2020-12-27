<%--
  Created by IntelliJ IDEA.
  User: lucreziarobustelli
  Date: 27/12/2020
  Time: 11:27
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
    <title>EASYEXPO - </title>

    <!-- SLIDER REVOLUTION 4.x CSS SETTINGS -->
    <link rel="stylesheet" type="text/css" href="rs-plugin/css/settings.css" media="screen" />

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

<!-- LOADER -->
<div id="loader">
    <div class="position-center-center">
        <div class="ldr"></div>
    </div>
</div>

<!-- Wrap -->
<div id="wrap">

    <!-- header -->
    <header>
        <div class="sticky">
            <div class="container">

                <!-- Logo -->
                <div class="logo"> <a href="index.html"><img class="img-responsive" src="images/logomacchia2.png" alt="" ></a> </div>
                <nav class="navbar ownmenu">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#nav-open-btn" aria-expanded="false"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"><i class="fa fa-navicon"></i></span> </button>
                    </div>

                    <!-- NAV -->
                    <div class="collapse navbar-collapse" id="nav-open-btn">
                        <ul class="nav">
                            <li class="dropdown active"><a href="./" class="dropdown-toggle">Home</a>
                            </li>
                            <li><a href="ChiSiamoServlet">Chi siamo</a></li>
                            <li><a href="ContattiServlet">Contatti</a></li>
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
                                        <h6>Ciao! ${cliente.nome}</h6>
                                    </li>
                                    <li><a href="#">CATALOGO</a></li>
                                    <li><a href="#">AREA CLIENTE</a></li>
                                    <li><a href="#">ABBONAMENTO</a></li>
                                    <li><a href="LogoutServlet">LOGOUT</a></li>
                                </ul>
                            </li>
                        </ul>
                        </li>

                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </header>


    <!--======= SUB BANNER =========-->
    <section class="sub-bnr" data-stellar-background-ratio="0.5">
        <div class="position-center-center">
            <div class="container">
                <h4>AGGIUNTA PRODOTTO</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec faucibus maximus vehicula.
                    Sed feugiat, tellus vel tristique posuere, diam</p>
                <ol class="breadcrumb">
                    <li><a href="#">Area Personale</a></li>
                    <li class="active">Aggiunta Prodotto</li>
                </ol>
            </div>
        </div>
    </section>

    <!-- Content -->
    <div id="content">

        <!--======= PAGES INNER =========-->
        <section class="chart-page padding-top-100 padding-bottom-100">
            <div class="container">

                <!-- Payments Steps -->
                <div class="shopping-cart">

                    <!-- SHOPPING INFORMATION -->
                    <div class="cart-ship-info register">
                        <div class="row">

                            <!-- ESTIMATE SHIPPING & TAX -->
                            <div class="col-sm-12">
                                <h6>AGGIUNGI PRODOTTO</h6>
                                <form>
                                    <ul class="row">

                                        <!-- TITOLO -->
                                        <li class="col-md-6">
                                            <label> TITOLO
                                                <input type="text" name="titolo" value="" placeholder="">
                                            </label>
                                        </li>

                                        <!-- TIPO -->
                                        <li class="col-md-6">
                                            <label> TIPO
                                                <input type="text" name="tipo" value="" placeholder="">
                                            </label>
                                        </li>

                                        <!-- PREZZO -->
                                        <li class="col-md-6">
                                            <label> PREZZO
                                                <input type="text" name="prezzo" value="" placeholder="">
                                            </label>
                                        </li>

                                        <!-- QUANTITÀ -->
                                        <li class="col-md-6">
                                            <label> QUANTITÀ
                                                <input type="text" name="descrizione" value="" placeholder="">
                                            </label>
                                        </li>

                                        <!-- DESCRIZIONE -->
                                        <li class="col-md-6">
                                            <label> DESCRIZIONE
                                                <input type="textArea" name="descrizione" value="" placeholder="" style="height: 150px">
                                            </label>
                                        </li>

                                        <!-- PHONE -->
                                        <li class="col-md-6">
                                            <button type="submit" class="btn">AGGIUNGI PRODOTTO</button>
                                        </li>
                                    </ul>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- About -->
        <section class="small-about padding-top-150 padding-bottom-150">
            <div class="container">

                <!-- Main Heading -->
                <div class="heading text-center">
                    <h4>about PAVSHOP</h4>
                    <p>Phasellus lacinia fermentum bibendum. Interdum et malesuada fames ac ante ipsumien lacus, eu posuere odio luctus non. Nulla lacinia,
                        eros vel fermentum consectetur, risus purus tempc, et iaculis odio dolor in ex. </p>
                </div>

                <!-- Social Icons -->
                <ul class="social_icons">
                    <li><a href="#."><i class="icon-social-facebook"></i></a></li>
                    <li><a href="#."><i class="icon-social-twitter"></i></a></li>
                    <li><a href="#."><i class="icon-social-tumblr"></i></a></li>
                    <li><a href="#."><i class="icon-social-youtube"></i></a></li>
                    <li><a href="#."><i class="icon-social-dribbble"></i></a></li>
                </ul>
            </div>
        </section>

        <!-- News Letter -->
        <section class="news-letter padding-top-150 padding-bottom-150">
            <div class="container">
                <div class="heading light-head text-center margin-bottom-30">
                    <h4>NEWSLETTER</h4>
                    <span>Phasellus lacinia fermentum bibendum. Interdum et malesuada fames ac ante ipsumien lacus, eu posuere odi </span> </div>
                <form>
                    <input type="email" placeholder="Enter your email address" required>
                    <button type="submit">SEND ME</button>
                </form>
            </div>
        </section>
    </div>

    <!--======= FOOTER =========-->
    <footer>
        <div class="container">

            <!-- ABOUT Location -->
            <div class="col-md-3">
                <div class="about-footer"> <img class="margin-bottom-30" src="images/logo-foot.png" alt="" >
                    <p><i class="icon-pointer"></i> Street No. 12, Newyork 12, <br>
                        MD - 123, USA.</p>
                    <p><i class="icon-call-end"></i> 1.800.123.456789</p>
                    <p><i class="icon-envelope"></i> info@PAVSHOP.com</p>
                </div>
            </div>

            <!-- HELPFUL LINKS -->
            <div class="col-md-3">
                <h6>HELPFUL LINKS</h6>
                <ul class="link">
                    <li><a href="#."> Products</a></li>
                    <li><a href="#."> Find a Store</a></li>
                    <li><a href="#."> Features</a></li>
                    <li><a href="#."> Privacy Policy</a></li>
                    <li><a href="#."> Blog</a></li>
                    <li><a href="#."> Press Kit </a></li>
                </ul>
            </div>

            <!-- SHOP -->
            <div class="col-md-3">
                <h6>SHOP</h6>
                <ul class="link">
                    <li><a href="#."> About Us</a></li>
                    <li><a href="#."> Career</a></li>
                    <li><a href="#."> Shipping Methods</a></li>
                    <li><a href="#."> Contact</a></li>
                    <li><a href="#."> Support</a></li>
                    <li><a href="#."> Retailer</a></li>
                </ul>
            </div>

            <!-- MY ACCOUNT -->
            <div class="col-md-3">
                <h6>MY ACCOUNT</h6>
                <ul class="link">
                    <li><a href="#."> Login</a></li>
                    <li><a href="#."> My Account</a></li>
                    <li><a href="#."> My Cart</a></li>
                    <li><a href="#."> Wishlist</a></li>
                    <li><a href="#."> Checkout</a></li>
                </ul>
            </div>

            <!-- Rights -->

            <div class="rights">
                <p>©  2016 PAVSHOP All right reserved. </p>
                <div class="scroll"> <a href="#wrap" class="go-up"><i class="lnr lnr-arrow-up"></i></a> </div>
            </div>
        </div>
    </footer>

    <!--======= RIGHTS =========-->

</div>
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/own-menu.js"></script>
<script src="js/jquery.lighter.js"></script>
<script src="js/owl.carousel.min.js"></script>

<!-- SLIDER REVOLUTION 4.x SCRIPTS  -->
<script type="text/javascript" src="rs-plugin/js/jquery.tp.t.min.js"></script>
<script type="text/javascript" src="rs-plugin/js/jquery.tp.min.js"></script>
<script src="js/main.js"></script>
<script src="js/main.js"></script>
</body>
</html>
