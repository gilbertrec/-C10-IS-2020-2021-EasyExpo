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
            <div class="logo"><a href="./"><img class="img-responsive" src="images/logomacchia2.png" alt=""></a>
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
                                <li><a href="#">CARRELLO</a></li>
                                <li><a href="#">AREA CLIENTE</a></li>
                                <li><a href="#">LOG OUT</a></li>
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
