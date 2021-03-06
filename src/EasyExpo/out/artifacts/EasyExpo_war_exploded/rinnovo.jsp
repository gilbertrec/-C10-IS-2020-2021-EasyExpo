<%--
  Created by IntelliJ IDEA.
  User: lucreziarobustelli
  Date: 27/12/2020
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                            <li class="dropdown active"><a href="areaFornitore.jsp" class="dropdown-toggle">Home</a>
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
                                    <li><a href="areaFornitore.jsp">CATALOGO</a></li>
                                    <li><a href="areaFornitore.jsp">AREA CLIENTE</a></li>
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
                <h4>ABBONAMENTO</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec faucibus maximus vehicula.
                    Sed feugiat, tellus vel tristique posuere, diam</p>
                <ol class="breadcrumb">
                    <li><a href="areaFornitore.jsp">Area Personale</a></li>
                    <li class="active">Abbonamento</li>
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
                                <h6>Inserisci metodo di pagamento</h6>
                                <form action="RinnovoAbbonamentoServlet" method="post">
                                    <input type="hidden" name="partitaIva" value="${fornitore.partitaIva}">
                                    <ul class="row">

                                        <!-- CARTE INSERITE -->
                                        <li class="col-md-6">

                                            <label> CARTE
                                                <div class="quinty">
                                                    <select class="selectpicker" name="tipo">
                                                        <c:forEach items="${metodi}" var="pr">
                                                            <option><c:out value="${pr.numeroCarta}"/></option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </label>

                                        </li>
                                    </ul>

                                    <li class="col-md-6" style="width: 20%">
                                        <form>
                                            <button type="submit" class="btn">RINNOVA</button>
                                        </form>
                                    </li>

                                    <!-- PHONE -->
                                    <li class="col-md-6">
                                        <form action="abbonamento.jsp">
                                            <button type="submit" class="btn">NUOVO METODO</button>
                                        </form>
                                    </li>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
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