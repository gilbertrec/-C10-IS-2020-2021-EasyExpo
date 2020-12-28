<%--
  Created by IntelliJ IDEA.
  User: lucreziarobustelli
  Date: 22/12/2020
  Time: 16:26
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
                <div class="logo"><a href="areaFornitore.jsp"><img class="img-responsive" src="images/logomacchia2.png"
                                                                   alt=""></a></div>
                <nav class="navbar ownmenu">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                                data-target="#nav-open-btn" aria-expanded="false"><span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"><i class="fa fa-navicon"></i></span></button>
                    </div>

                    <!-- NAV -->
                    <div class="collapse navbar-collapse" id="nav-open-btn">
                        <ul class="nav">
                            <li class="dropdown active"><a href="areaFornitore.jsp" class="dropdown-toggle">Profilo</a>
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
                                        <h6>Ciao! ${fornitore.nome}</h6>
                                    </li>
                                    <li><a href="areaFornitore.jsp">CATALOGO</a></li>
                                    <li><a href="areaFornitore.jsp">AREA CLIENTE</a></li>
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
                <h4>${fornitore.nome} ${fornitore.cognome}</h4>
                <p> P. IVA : ${fornitore.partitaIva} <br>
                    Telefono: ${fornitore.telefono}<br>
                    Luogo di ubicazione: ${fornitore.luogoUbicazione}<br>
                    Email: ${fornitore.email}<br>
                    Ragione Sociale: ${fornitore.ragioneSociale}</p>
                <ol class="breadcrumb">
                    <li><form action="SottoscrizioneAbbonamentoServlet" method="post">
                        <input type="hidden" name="partitaIva" value="${fornitore.partitaIva}">
                        <a href="SottoscrizioneAbbonamentoServlet">ABBONAMENTO</a>
                    </form></li>
                </ol>
            </div>
        </div>
    </section>

    <!-- Content -->
    <div id="content">

        <!-- Popular Products -->
        <section class="shop-page padding-top-100 padding-bottom-100">
            <div class="container">
                <div class="item-display">
                    <div class="row">
                        <div class="col-xs-6"><span
                                class="product-num">Mostrando 1 - 10 di 30 prodotti ${num_prodotti}</span></div>

                        <!-- Products Select -->
                        <div class="col-xs-6">
                            <div class="pull-right">

                                <ol class="breadcrumb">
                                    <li><a href="aggiuntaProdotto.jsp">Aggiungi Prodotto</a></li>
                                </ol>
                            </div>
                        </div>
                    </div>

                    <!-- Popular Item Slide -->
                    <div class="papular-block row">

                        <!-- Item -->
                        <div class="col-md-3">
                            <div class="item">
                                <!-- Item img -->
                                <div class="item-img"><img class="img-1" src="images/product-2-1.jpg" alt=""> <img
                                        class="img-2" src="images/product-2.jpg" alt="">
                                    <!-- Overlay -->
                                    <div class="overlay">
                                        <div class="position-center-center">
                                            <div class="inn"><a href="images/product-2-1.jpg" data-lighter><i
                                                    class="icon-magnifier"></i><a href="EliminaProdottoServlet"><i
                                                    class="icon-trash"></i><a href="ModificaProdottoServlet" name="idProdotto" <c:out value="${prodotto.id}"/><i
                                                    class="icon-pencil"></i></a></div>
                                        </div>
                                    </div>
                                </div>
                                <!-- Item Name -->
                                <div class="item-name"><a href="#.">stone cup</a>
                                    <p>Lorem ipsum dolor sit amet</p>
                                </div>
                                <!-- Price -->
                                <span class="price"><small>$</small>299</span></div>
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
        <div class="container">

            <!-- ABOUT Location -->
            <div class="col-md-3">
                <div class="about-footer"><img class="margin-bottom-30" src="images/logomacchia.png" alt="">
                    <p><i class="icon-pointer"></i> Via Giovanni Paolo II, 132 . <br>
                        - 84084 Fisciano (SA)</p>
                    <p><i class="icon-call-end"></i> 081 564738</p>
                    <p><i class="icon-envelope"></i> info@EASYEXPO.com</p>
                </div>
            </div>


            <!-- INFO -->
            <div class="col-md-3">
                <h6>INFO</h6>
                <ul class="link">
                    <li><a href="chiSiamo.jsp"> Chi Siamo</a></li>
                    <li><a href="contatti.jsp"> Contatti</a></li>
                </ul>
            </div>

            <!-- MY ACCOUNT -->
            <div class="col-md-3">
                <h6>ACCOUNT FORNITORE</h6>
                <ul class="link">
                    <li><a href="areaFornitore.jsp"> Area Fornitore</a></li>
                    <li><a href="areaFornitore.jsp"> Catalogo</a></li>
                    <li><a href="#."> Abbonamento</a></li>
                </ul>
            </div>

            <!-- Rights -->

            <div class="rights">
                <p>© 2020 EASYEXPO Tutti i diritti riservati. </p>
                <div class="scroll"><a href="#wrap" class="go-up"><i class="lnr lnr-arrow-up"></i></a></div>
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