<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<div class="sticky">
    <div class="container">

        <!-- Logo -->
        <c:choose>
        <c:when test="${cliente == null and fornitore == null}">
        <div class="logo"><a href="login.jsp"><img class="img-responsive" src="images/logomacchia2.png" alt=""></a>
        </div>
        <nav class="navbar ownmenu">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#nav-open-btn" aria-expanded="false"><span
                        class="sr-only">Toggle navigation</span> <span class="icon-bar"><i
                        class="fa fa-navicon"></i></span></button>
            </div>
            </c:when>
            <c:when test="${cliente != null}">
            <div class="logo"><a href="index.jsp"><img class="img-responsive" src="images/logomacchia2.png" alt=""></a>
            </div>
            <nav class="navbar ownmenu">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#nav-open-btn" aria-expanded="false"><span
                            class="sr-only">Toggle navigation</span> <span class="icon-bar"><i
                            class="fa fa-navicon"></i></span></button>
                </div>
                </c:when>
                <c:when test="${fornitore != null}">
                <div class="logo"><a href="areaFornitore.jsp"><img class="img-responsive"
                                                                   src="images/logomacchia2.png" alt=""></a>
                </div>
                <nav class="navbar ownmenu">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                                data-target="#nav-open-btn" aria-expanded="false"><span
                                class="sr-only">Toggle navigation</span> <span class="icon-bar"><i
                                class="fa fa-navicon"></i></span></button>
                    </div>
                    </c:when>
                    </c:choose>


                    <!-- NAV -->
                    <div class="collapse navbar-collapse" id="nav-open-btn">
                        <ul class="nav">
                            <c:choose>
                                <c:when test="${cliente == null and fornitore == null}">
                                    <li><a href="chiSiamo.jsp">Chi siamo</a></li>
                                    <li><a href="contatti.jsp">Contatti</a></li>
                                </c:when>
                                <c:when test="${cliente != null}">
                                    <li class="dropdown active"><a href="index.jsp" class="dropdown-toggle">Home</a>
                                    </li>
                                    <li><a href="chiSiamo.jsp">Chi siamo</a></li>
                                    <li><a href="contatti.jsp">Contatti</a></li>
                                </c:when>
                                <c:when test="${fornitore != null}">
                                    <li class="dropdown active"><a href="areaFornitore.jsp" class="dropdown-toggle">Profilo</a>
                                    </li>
                                    <li><a href="chiSiamo.jsp">Chi siamo</a></li>
                                    <li><a href="contatti.jsp">Contatti</a></li>
                                </c:when>
                            </c:choose>
                        </ul>
                    </div>

                    <!-- Nav Right -->
                    <div class="nav-right">
                        <ul class="navbar-right">

                            <!-- USER INFO -->
                            <li class="dropdown user-acc"><a href="login.jsp" class="dropdown-toggle"
                                                             data-toggle="dropdown"
                                                             role="button"><i class="icon-user"></i> </a>
                                <ul class="dropdown-menu">
                                    <c:choose>
                                        <c:when test="${cliente != null}">
                                            <li>
                                                <h6>Ciao ${cliente.nome} !</h6>
                                            </li>
                                            <li><a href="areaCliente.jsp">AREA CLIENTE</a></li>
                                            <li>
                                                <a href="RichiesteServlet?codiceFiscale=<c:out value="${cliente.codiceFiscale}"/>">RICHIESTE</a>
                                            </li>
                                            <li>
                                                <a href="PreventiviServlet?codiceFiscale=<c:out value="${cliente.codiceFiscale}"/>">PREVENTIVI</a>
                                            </li>
                                            <li><a href="LogoutServlet">LOGOUT</a></li>
                                        </c:when>
                                        <c:when test="${fornitore != null and fornitore.abbonato == true}">
                                            <li>
                                                <h6>Ciao ${fornitore.nome} !</h6>
                                            </li>
                                            <li><a href="areaFornitore.jsp"> AREA FORNITORE</a></li>
                                            <li><a href="areaFornitore.jsp"> CATALOGO</a></li>
                                            <li>
                                                <a href="RichiesteServlet?partitaIva=<c:out value="${fornitore.partitaIva}"/>">RICHIESTE</a>
                                            </li>
                                            <li>
                                                <a href="PreventiviServlet?partitaIva=<c:out value="${fornitore.partitaIva}"/>">PREVENTIVI</a>
                                            </li>
                                            <li><a href="LogoutServlet">LOGOUT</a></li>
                                        </c:when>
                                        <c:when test="${fornitore != null and fornitore.abbonato == false}">
                                            <li>
                                                <h6>Ciao ${fornitore.nome} !</h6>
                                            </li>
                                            <li><a href="areaFornitore.jsp"> AREA FORNITORE</a></li>
                                            <li><a href="areaFornitore.jsp"> CATALOGO</a></li>
                                            <li><a href="LogoutServlet">LOGOUT</a></li>
                                        </c:when>
                                        <c:otherwise>
                                            <li>
                                                <h6>Ciao Nuovo Utente !</h6>
                                            </li>
                                            <li><a href="login.jsp"> Login</a></li>
                                            <li><a href="registrazioneCliente.jsp"> Registrazione Cliente</a></li>
                                            <li><a href="registrazioneFornitore.jsp"> Registrazione Fornitore</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </ul>
                            </li>
                            <c:choose>
                                <c:when test="${cliente != null}">
                                    <!-- ICONA CARRELLO -->

                                    <li class="dropdown"><a href="carrello.jsp" class="search-open"><i
                                            class="icon-basket-loaded"></i></a>
                                    </li>

                                    <!-- <a href="carrello.jsp" class="dropdown-toggle"
                                    data-toggle="dropdown"
                                    role="button" aria-haspopup="true"
                                    aria-expanded="true"><i
                                    class="icon-basket-loaded"></i> </a> -->


                                    <!--<li class="dropdown user-basket">
                                    <ul class="dropdown-menu">

                                    <li>
                                    <h5 class="text-center">TOTALE:</h5>
                                    </li>
                                    <li class="margin-0">
                                    <div class="row">
                                    <div class="col-xs-6"><a href="shopping-cart.html" class="btn">CARRELLO</a>
                                    </div>
                                    </div>
                                    </li>
                                    </ul>
                                    </li> -->

                                    <!-- ICONA SEARCH -->

                                    <li class="dropdown"><a href="ricerca.jsp" class="search-open"><i
                                            class=" icon-magnifier"></i></a>
                                    </li>
                                </c:when>
                                <c:otherwise>

                                </c:otherwise>
                            </c:choose>
                        </ul>
                    </div>
                </nav>
    </div>
</div>
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/own-menu.js"></script>
<script src="js/jquery.lighter.js"></script>
<script src="js/owl.carousel.min.js"></script>

<!-- SLIDER REVOLUTION 4.x SCRIPTS -->
<script type="text/javascript" src="rs-plugin/js/jquery.tp.t.min.js"></script>
<script type="text/javascript" src="rs-plugin/js/jquery.tp.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>
