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



    <div class="container" >

        <!-- Logo -->
        <div class="logo"><a href="adminHome.jsp"><img class="img-responsive" src="images/logomacchia2.png" alt=""></a>
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
            </div>

            <!-- Nav Right -->
            <div class="nav-right">
                <ul class="navbar-right">

                    <!-- USER INFO -->
                    <li class="dropdown user-acc"><a href="adminLoginSegreto.jsp" class="dropdown-toggle" data-toggle="dropdown"
                                                     role="button"><i class="icon-user"></i><h6>MENU</h6></a>
                        <ul class="dropdown-menu">
                            <c:choose>
                                <c:when test="${LeaderSupremo != null}">
                                    <li>
                                        <h6>Ciao!</h6>
                                    </li>
                                    <li><a href="adminHome.jsp">AREA ADMIN</a></li>

                                    <li><a href="LogoutServlet">LOGOUT</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li>
                                        <h6>Effettua login Admin !</h6>
                                    </li>
                                    <li><a href="adminLoginSegreto.jsp"> Login</a></li>
                                </c:otherwise>
                            </c:choose>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</header>
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
