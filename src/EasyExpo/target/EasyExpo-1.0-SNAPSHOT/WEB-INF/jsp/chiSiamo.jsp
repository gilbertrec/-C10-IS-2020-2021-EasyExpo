<%--
  Created by IntelliJ IDEA.
  User: gaeta
  Date: 21-Dec-20
  Time: 17:38
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
    <title>PAVSHOP - Multipurpose eCommerce HTML5 Template</title>

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
        <jsp:include page="/WEB-INF/jsp/header.jsp">
            <jsp:param name="pageTitle" value="Homepage"/>
        </jsp:include>
    </header>

    <!--======= SUB BANNER =========-->
    <section class="sub-bnr" data-stellar-background-ratio="0.5"
             style="background:url(images/sub-bnr-bg-1.jpg) center center no-repeat">
        <div class="position-center-center">
            <div class="container">
                <h4>ABOUT PAVSHOP</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec faucibus maximus vehicula.
                    Sed feugiat, tellus vel tristique posuere, diam</p>
                <ol class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li class="active">ABOUT</li>
                </ol>
            </div>
        </div>
    </section>

    <!-- Content -->
    <div id="content">

        <!-- History -->
        <section class="history-block padding-top-100 padding-bottom-100">
            <div class="container">
                <div class="row">
                    <div class="col-xs-10 center-block">
                        <div class="col-sm-10 center-block">
                            <h4>A Brief History</h4>
                            <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam volutpat dui at lacus
                                aliquet, a consequat enim aliquet. Integer molestie sit amet sem et faucibus. Nunc
                                ornare pharetra dui, vitae auctor orci fringilla eget. Pellentesque in placerat felis.
                                Etiam mollis venenatis luctus. Morbi ac scelerisque mauris. Etiam sodales a nulla ornare
                                viverra. Nunc at blandit neque, bibendum varius purus. <br>
                                <br>
                                Nam sit amet sapien vitae enim vehicula tincidunt. Cum sociis natoque penatibus et
                                magnis dis parturient montes, nascetur ridiculus mus. Nunc faucibus imperdiet vulputate.
                                Morbi volutpat leo iaculis elit vehicula, eu convallis magna finibus. Suspendisse
                                tristique ullamcorper erat a elementum. Cras eget elit non nunc aliquam ullamcorper quis
                                sed metus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec malesuada,
                                erat in ullamcorper bibendum, elit lacus mattis lorem, quis luctus diam lorem vel
                                ligula. </p>

                            <!-- IMG -->
                            <div class="relative"><img class="img-responsive margin-top-80 margin-bottom-80"
                                                       src="images/about-img-1.jpg" alt="">
                                <div class="position-center-center"> <span class="huge-text">our team
                  united by love</span></div>
                            </div>
                            <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam volutpat dui at lacus
                                aliquet, a consequat enim aliquet. Integer molestie sit amet sem et faucibus. Nunc
                                ornare pharetra dui, vitae auctor orci fringilla eget. Pellentesque in placerat felis.
                                Etiam mollis venenatis luctus. Morbi ac scelerisque mauris. Etiam sodales a nulla ornare
                                viverra. Nunc at blandit neque, bibendum varius purus. <br>
                                <br>
                                Nam sit amet sapien vitae enim vehicula tincidunt. Cum sociis natoque penatibus et
                                magnis dis parturient montes, nascetur ridiculus mus. Nunc faucibus imperdiet vulputate.
                                Morbi volutpat leo iaculis elit vehicula, eu convallis magna finibus. Suspendisse
                                tristique ullamcorper erat a elementum. Cras eget elit non nunc aliquam ullamcorper quis
                                sed metus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec malesuada,
                                erat in ullamcorper bibendum, elit lacus mattis lorem, quis luctus diam lorem vel
                                ligula. </p>
                            <img class="margin-top-50" src="images/signature.jpg" alt=""></div>
                    </div>
                </div>
            </div>
        </section>

        <!-- Culture BLOCK -->
        <section class="cultur-block">
            <ul>
                <li><img src="images/cultur-img-1.jpg" alt=""></li>
                <li><img src="images/cultur-img-2.jpg" alt=""></li>
                <li><img src="images/cultur-img-3.jpg" alt=""></li>
                <li><img src="images/cultur-img-4.jpg" alt=""></li>
            </ul>

            <!-- Culture Text -->
            <div class="position-center-center">
                <div class="container">
                    <div class="col-sm-6 center-block">
                        <h4>awesome work culture</h4>
                        <p>Phasellus lacinia fermentutm bibendum. Interdum et malante ipuctus non. Nulla lacinia,
                            eros vel fermentum consectetur, ris dolor in ex. </p>
                    </div>
                </div>
            </div>
        </section>

        <!-- OUR TEAM -->
        <section class="our-team our-team-small  light-gray-bg padding-top-150 padding-bottom-80">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4">

                        <!-- HEADING -->
                        <div class="heading style-left">
                            <h4>our Team</h4>
                            <span>United by love & help to build great brands</span></div>
                    </div>

                    <!-- TEAM -->
                    <div class="col-lg-8">
                        <ul class="row">

                            <!-- Member -->
                            <li class="col-md-4 text-center animate fadeInUp" data-wow-delay="0.4s">
                                <article>
                                    <!-- abatar -->
                                    <div class="avatar"><img class="img-circle" src="images/team-1.jpg" alt="">
                                        <!-- Team hover -->
                                        <div class="team-hover">
                                            <div class="position-center-center">
                                                <div class="social-icons"><a href="#."><i
                                                        class="icon-social-facebook"></i></a> <a href="#."><i
                                                        class="icon-social-twitter"></i></a> <a href="#."><i
                                                        class="icon-social-dribbble"></i></a></div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Team Detail -->
                                    <div class="team-names">
                                        <h6>JOSEPH MARK</h6>
                                        <p>CEO & FOUNDER</p>
                                    </div>
                                </article>
                            </li>

                            <!-- Member -->
                            <li class="col-md-4 text-center animate fadeInUp" data-wow-delay="0.6s">
                                <article>
                                    <!-- abatar -->
                                    <div class="avatar"><img class="img-circle" src="images/team-2.jpg" alt="">
                                        <!-- Team hover -->
                                        <div class="team-hover">
                                            <div class="position-center-center">
                                                <div class="social-icons"><a href="#."><i
                                                        class="icon-social-facebook"></i></a> <a href="#."><i
                                                        class="icon-social-twitter"></i></a> <a href="#."><i
                                                        class="icon-social-dribbble"></i></a></div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Team Detail -->
                                    <div class="team-names">
                                        <h6>jennifer rod</h6>
                                        <p>DESIGNER</p>
                                    </div>
                                </article>
                            </li>

                            <!-- Member -->
                            <li class="col-md-4 text-center animate fadeInUp" data-wow-delay="0.8s">
                                <article>
                                    <!-- abatar -->
                                    <div class="avatar"><img class="img-circle" src="images/team-3.jpg" alt="">
                                        <!-- Team hover -->
                                        <div class="team-hover">
                                            <div class="position-center-center">
                                                <div class="social-icons"><a href="#."><i
                                                        class="icon-social-facebook"></i></a> <a href="#."><i
                                                        class="icon-social-twitter"></i></a> <a href="#."><i
                                                        class="icon-social-dribbble"></i></a></div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Team Detail -->
                                    <div class="team-names">
                                        <h6>natasha singh</h6>
                                        <p>DEVELOPER</p>
                                    </div>
                                </article>
                            </li>

                            <!-- Member -->
                            <li class="col-md-4 text-center">
                                <article>
                                    <!-- abatar -->
                                    <div class="avatar"><img class="img-circle" src="images/team-4.jpg" alt="">
                                        <!-- Team hover -->
                                        <div class="team-hover">
                                            <div class="position-center-center">
                                                <div class="social-icons"><a href="#."><i
                                                        class="icon-social-facebook"></i></a> <a href="#."><i
                                                        class="icon-social-twitter"></i></a> <a href="#."><i
                                                        class="icon-social-dribbble"></i></a></div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Team Detail -->
                                    <div class="team-names">
                                        <h6>JOSEPH MARK</h6>
                                        <p>Product Designer</p>
                                    </div>
                                </article>
                            </li>

                            <!-- Member -->
                            <li class="col-md-4 text-center">
                                <article>
                                    <!-- abatar -->
                                    <div class="avatar"><img class="img-circle" src="images/team-5.jpg" alt="">
                                        <!-- Team hover -->
                                        <div class="team-hover">
                                            <div class="position-center-center">
                                                <div class="social-icons"><a href="#."><i
                                                        class="icon-social-facebook"></i></a> <a href="#."><i
                                                        class="icon-social-twitter"></i></a> <a href="#."><i
                                                        class="icon-social-dribbble"></i></a></div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Team Detail -->
                                    <div class="team-names">
                                        <h6>jennifer rod</h6>
                                        <p>Quality Head</p>
                                    </div>
                                </article>
                            </li>

                            <!-- Member -->
                            <li class="col-md-4 text-center">
                                <article>
                                    <!-- abatar -->
                                    <div class="avatar"><img class="img-circle" src="images/team-6.jpg" alt="">
                                        <!-- Team hover -->
                                        <div class="team-hover">
                                            <div class="position-center-center">
                                                <div class="social-icons"><a href="#."><i
                                                        class="icon-social-facebook"></i></a> <a href="#."><i
                                                        class="icon-social-twitter"></i></a> <a href="#."><i
                                                        class="icon-social-dribbble"></i></a></div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Team Detail -->
                                    <div class="team-names">
                                        <h6>natasha singh</h6>
                                        <p>DEVELOPER</p>
                                    </div>
                                </article>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </section>

        <!-- Client Img  -->
        <section class="client-img-2 padding-top-150 padding-bottom-80">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4">

                        <!-- HEADING -->
                        <div class="heading style-left">
                            <h4>our sponsors</h4>
                            <span>Proud that we have awesome sponsors</span></div>
                    </div>

                    <!-- TEAM -->
                    <div class="col-lg-8">
                        <ul class="row">
                            <li class="col-sm-4"><img src="images/c-mg-1.png" alt=""></li>
                            <li class="col-sm-4"><img src="images/c-mg-2.png" alt=""></li>
                            <li class="col-sm-4"><img src="images/c-mg-3.png" alt=""></li>
                        </ul>
                    </div>
                </div>
            </div>
        </section>

        <!-- Client Img  -->
        <section class="fun-facts padding-top-150 padding-bottom-80">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4">

                        <!-- HEADING -->
                        <div class="heading style-left padding-right-20">
                            <h4>few Facts</h4>
                            <span>Awesome Numbers are good :)</span></div>
                    </div>

                    <!-- FUN FACTS -->
                    <div class="col-lg-8">
                        <ul class="row">

                            <!-- SALES -->
                            <li class="col-sm-4"><i class="icon-handbag"></i> <span>457</span>
                                <h5>sales</h5>
                            </li>

                            <!-- Products -->
                            <li class="col-sm-4"><i class="icon-grid"></i> <span>571</span>
                                <h5>products</h5>
                            </li>

                            <!-- Clients -->
                            <li class="col-sm-4"><i class="icon-users"></i> <span>289</span>
                                <h5>clients</h5>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </section>

        <!-- TWEET -->
        <section class="tweet padding-top-100 padding-bottom-100">
            <div class="container">
                <div class="col-md-8 center-block"><i class="icon-social-twitter"></i>
                    <p>Phasellus lacinia fermentum bibendum. Interdum et malesuada fames ac ante ipsumien lacus, eu
                        posuere
                        eros vel fermentum consectetur, risus purus tempc, et iaculis odio dolor in ex. </p>
                    <span><span class="primary-color">@johnsmith</span> 4 hours ago via Twitter</span></div>
            </div>
        </section>

        <!-- News Letter -->
        <section class="news-letter padding-top-150 padding-bottom-150">
            <div class="container">
                <div class="heading light-head text-center margin-bottom-30">
                    <h4>NEWSLETTER</h4>
                    <span>Phasellus lacinia fermentum bibendum. Interdum et malesuada fames ac ante ipsumien lacus, eu posuere odi </span>
                </div>
                <form>
                    <input type="email" placeholder="Enter your email address" required>
                    <button type="submit">SEND ME</button>
                </form>
            </div>
        </section>
    </div>

    <!--======= FOOTER =========-->
    <footer>
        <jsp:include page="/WEB-INF/jsp/footer.jsp"/>
    </footer>
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
            var myLatLng = new google.maps.LatLng(-37.814199, 144.961560);
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