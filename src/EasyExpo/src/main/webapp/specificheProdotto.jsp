<%--
  Created by IntelliJ IDEA.
  User: lucreziarobustelli
  Date: 27/12/2020
  Time: 18:55
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
            <div class="logo"><a href="index.jsp"><img class="img-responsive" src="images/logomacchia2.png" alt=""></a>
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
                        <li class="dropdown active"><a href="index.jsp" class="dropdown-toggle">Home</a>
                        </li>
                        <li><a href="chiSiamo.jsp">Chi siamo</a></li>
                        <li><a href="contatti.jsp">Contatti</a></li>
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
                                <li><a href="#">CARRELLO</a></li>
                                <li><a href="areaCliente.jsp">AREA CLIENTE</a></li>
                                <li><a href="LogoutServlet">LOGOUT</a></li>
                            </ul>
                        </li>

                        <!-- USER BASKET -->
                        <li class="dropdown user-basket"><a href="#" class="dropdown-toggle" data-toggle="dropdown"
                                                            role="button" aria-haspopup="true" aria-expanded="true"><i
                                class="icon-basket-loaded"></i> </a>
                            <ul class="dropdown-menu">

                                <li>
                                    <h5 class="text-center">TOTALE: ${prezzo}</h5>
                                </li>
                                <li class="margin-0">
                                    <div class="row">
                                        <div class="col-xs-6"><a href="shopping-cart.html" class="btn">CARRELLO</a>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </li>

                        <!-- SEARCH BAR -->

                        <li class="dropdown"><a href="ricerca.jsp" class="search-open"><i
                                class=" icon-magnifier"></i></a>
                            <div class="search-inside animated bounceInUp"><i class="icon-close search-close"></i>
                                <div class="search-overlay"></div>
                                <div class="position-center-top">
                                    <div class="search">
                                        <form>
                                            <input type="search" id="search" placeholder="Prodotto, Fornitore, Tag..." oninput="ricerca()">
                                            <!-- <button type="submit"><i class="icon-check"></i></button> -->
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

    <!--======= SUB BANNER =========-->
    <section class="sub-bnr" data-stellar-background-ratio="0.5">
        <div class="position-center-center">
            <div class="container">
                <h4>WOOD CHAIR</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec faucibus maximus vehicula.
                    Sed feugiat, tellus vel tristique posuere, diam</p>
                <ol class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li class="active">Data</li>
                </ol>
            </div>
        </div>
    </section>

    <!-- Content -->
    <div id="content">

        <!-- Popular Products -->
        <section class="padding-top-100 padding-bottom-100">
            <div class="container">

                <!-- SHOP DETAIL -->
                <div class="shop-detail">
                    <div class="row">

                        <!-- Popular Images Slider -->
                        <div class="col-md-7">

                            <!-- Images Slider -->
                            <div class="images-slider">
                                <ul class="slides">
                                    <li data-thumb="images/large-img-1.jpg"> <img class="img-responsive" src="images/large-img-1.jpg"  alt=""> </li>
                                    <li data-thumb="images/large-img-2.jpg"> <img class="img-responsive" src="images/large-img-2.jpg"  alt=""> </li>
                                    <li data-thumb="images/large-img-3.jpg"> <img class="img-responsive" src="images/large-img-3.jpg"  alt=""> </li>
                                </ul>
                            </div>
                        </div>

                        <!-- Content -->
                        <div class="col-md-5">
                            <h4>wood chair</h4>
                            <span class="price"><small>$</small>299</span>

                            <!-- Item Detail -->
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum finibus ligula a scelerisque gravida. Nullam laoreet tortor ac maximus alique met, consectetur adipiscing elit. Vestibulum finibus ligula a scelerisque gravida. Nullam</p>

                            <!-- Short By -->
                            <div class="some-info">
                                <ul class="row margin-top-30">
                                    <li class="col-xs-4">
                                        <div class="quinty">
                                            <!-- QTY -->
                                            <select class="selectpicker">
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                            </select>
                                        </div>
                                    </li>

                                    <!-- AGGIUNGI AL CARRELLO -->
                                    <li class="col-xs-6"> <a href="#." class="btn">AGGIUNGI</a> </li>

                                </ul>

                                <!-- INFOMATION -->
                                <div class="inner-info">
                                    <h6>INFORMAZIONI FORNITORE</h6>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum finibus ligula a scelerisque gravida. Nullam laoreet tortor ac maximus alique met, consectetur adipiscing elit. </p>

                                    <!-- TAGS -->
                                    <h5 class="shop-tittle margin-top-60 margin-bottom-30">POPULAR TAGS</h5>
                                    <ul class="shop-tags">
                                        <li><a href="#.">Musica</a></li>
                                        <li><a href="#.">Casse</a></li>

                                    </ul>

                                    <!-- Social Icons -->
                                    <ul class="social_icons">
                                        <li><a href="#."><i class="icon-social-facebook"></i></a></li>
                                        <li><a href="#."><i class="icon-social-twitter"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!--======= PRODUCT DESCRIPTION =========-->
                <div class="item-decribe">
                    <!-- Nav tabs -->
                    <ul class="nav nav-tabs animate fadeInUp" data-wow-delay="0.4s" role="tablist">
                        <li role="presentation" class="active"><a href="#descr" role="tab" data-toggle="tab">DESCRIPTION</a></li>
                    </ul>

                    <!-- Tab panes -->
                    <div class="tab-content animate fadeInUp" data-wow-delay="0.4s">
                        <!-- DESCRIPTION -->
                        <div role="tabpanel" class="tab-pane fade in active" id="descr">
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sed lectus id nisi interdum mollis. Nam congue tellus quis elit mattis congue. Aenean eu massa sed mauris hendrerit ornare sed eget ante.
                                Vestibulum id eros quam. Nunc volutpat at magna gravida eleifend. Phasellus sit amet nisi tempus, tincidunt elit ac, tempor metus. <br>
                            </p>
                            <h6>THE SIMPLE FACTS</h6>
                            <ul>
                                <li>
                                    <p>Praesent faucibus, leo vitae maximus dictum,</p>
                                </li>
                                <li>
                                    <p> Donec porta ut lectus </p>
                                </li>
                                <li>
                                    <p> Phasellus maximus velit id nisl</p>
                                </li>
                                <li>
                                    <p> Quisque a tellus et sapien aliquam sus</p>
                                </li>
                                <li>
                                    <p> Donec porta ut lectus </p>
                                </li>
                                <li>
                                    <p> Phasellus maximus velit id nisl</p>
                                </li>
                            </ul>
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
                    <h4>Cos'è EASYEXPO</h4>
                    <p>La piattaforma EasyExpo è un sistema di comunicazione tra gli organizzatori di
                        eventi e i Fornitori di attrezzature, è un portale dove confrontare i vari
                        preventivi e poter essere in collegamento diretto con i vari Fornitori.</p>
                </div>

                <!-- Social Icons -->
                <ul class="social_icons">
                    <li><a href="#."><i class="icon-social-facebook"></i></a></li>
                    <li><a href="#."><i class="icon-social-twitter"></i></a></li>
                </ul>
            </div>
        </section>

    </div>

    <!--======= FOOTER =========-->
    <footer>
        <jsp:include page="/footer.jsp"/>
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