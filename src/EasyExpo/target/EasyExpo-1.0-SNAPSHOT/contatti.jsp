<%--
  Created by IntelliJ IDEA.
  User: lucreziarobustelli
  Date: 21/12/2020
  Time: 18:44
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
    <title>EASYEXPO - Contatti</title>

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
        <jsp:include page="/header.jsp">
            <jsp:param name="pageTitle" value="Contatti"/>
        </jsp:include>
    </header>
<<<<<<< HEAD:src/EasyExpo/target/EasyExpo-1.0-SNAPSHOT/contatti.jsp
<!--======= SUB BANNER =========-->
<section class="sub-bnr-contatti" data-stellar-background-ratio="0.5">
    <div class="position-center-center">
        <div class="container">
            <h4>contattaci ora</h4>
            <p>Ti lasciamo di seguito i nostri recapiti per contattarci. I nostri operatori ti risponderanno nel minor tempo possibile!</p>
            <ol class="breadcrumb">
                <li><a href="index.jsp">Home</a></li>
                <li class="active">contatti</li>
            </ol>
=======
    <!--======= SUB BANNER =========-->
    <section class="sub-bnr-contatti" data-stellar-background-ratio="0.5">
        <div class="position-center-center">
            <div class="container">
                <h4 style="color: #ffe115;">contattaci ora</h4>
                <p style="    color: #2d3a4b;
    background-color: rgba(255,255,255,0.60);">Ti lasciamo di seguito i nostri recapiti per contattarci. I nostri
                    operatori ti risponderanno nel minor tempo possibile!</p>
                <ol class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li class="active">contatti</li>
                </ol>
            </div>
>>>>>>> 8341f7d544825fd7df35aa2544706456e6b4494d:src/EasyExpo/target/EasyExpo-1.0-SNAPSHOT/WEB-INF/jsp/contatti.jsp
        </div>
    </section>

    <!-- Content -->
    <div id="content">

        <!--======= CONATACT  =========-->
        <section class="contact padding-top-100 padding-bottom-100">
            <div class="container">
                <div class="contact-form">
                    <div class="row">

                        <!--======= ADDRESS INFO  =========-->
                        <div class="col-md-4">
                            <div class="contact-info" style="margin-left: 410px; margin-right: -410px">
                                <h6>I NOSTRI INDIRIZZI</h6>
                                <ul>
                                    <li><i class="icon-map-pin"></i> Via Giovanni Paolo II, 132 . <br>
                                        - 84084 Fisciano (SA)
                                    </li>
                                    <li><i class="icon-call-end"></i> 081 564738</li>
                                    <li><i class="icon-envelope"></i> <a href="mailto:someone@example.com"
                                                                         target="_top">info@EASYEXPO.com</a></li>

                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!--======= MAP =========-->
        <div id="map"></div>

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

<<<<<<< HEAD:src/EasyExpo/target/EasyExpo-1.0-SNAPSHOT/contatti.jsp
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
=======
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
        <jsp:include page="/WEB-INF/jsp/footer.jsp"/>
    </footer>
>>>>>>> 8341f7d544825fd7df35aa2544706456e6b4494d:src/EasyExpo/target/EasyExpo-1.0-SNAPSHOT/WEB-INF/jsp/contatti.jsp
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

<!-- Begin Map Script -->
<script type='text/javascript' src='http://maps.google.com/maps/api/js?sensor=false'></script>
<script type="text/javascript">
    /*==========  Map  ==========*/
    var map;

    function initialize_map() {
        if ($('#map').length) {
            var myLatLng = new google.maps.LatLng(40.7687676088294, 14.79166543928102);
            var mapOptions = {
                zoom: 17,
                center: myLatLng,
                scrollwheel: false,
                panControl: false,
                zoomControl: true,
                scaleControl: false,
                mapTypeControl: false,
                streetViewControl: false
            };
            map = new google.maps.Map(document.getElementById('map'), mapOptions);
            var marker = new google.maps.Marker({
                position: myLatLng,
                map: map,
                tittle: 'Envato',
                icon: './images/map-locator.png'
            });
        } else {
            return false;
        }
    }

    google.maps.event.addDomListener(window, 'load', initialize_map);
</script>
</body>
</html>
