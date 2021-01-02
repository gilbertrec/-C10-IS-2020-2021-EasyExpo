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

    <!--======= SUB BANNER =========-->
    <section class="sub-bnr-contatti" data-stellar-background-ratio="0.5">
        <div class="position-center-center">
            <div class="container">
                <h4 style="color: #ffe115;">contattaci ora</h4>
                <p style="color: #2d3a4b; background-color: rgba(255,255,255,0.60);">Ti lasciamo di
                    seguito i nostri recapiti per contattarci. I nostri
                    operatori ti risponderanno nel minor tempo possibile!</p>
                <ol class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li class="active">contatti</li>
                </ol>
            </div>
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
                                    <li><i class="icon-envelope"></i> <a href="#" target="_top">info@EASYEXPO.com</a>
                                    </li>

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

</div>


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
