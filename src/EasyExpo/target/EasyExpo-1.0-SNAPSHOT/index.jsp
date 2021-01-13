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

    <header>
        <jsp:include page="/header.jsp">
            <jsp:param name="pageTitle" value="Homepage"/>
        </jsp:include>
    </header>

    <!--======= HOME MAIN SLIDER =========-->
    <section class="home-slider">

        <!-- SLIDE Start -->
        <div class="tp-banner-container">
            <div class="tp-banner">
                <ul>
                    <!-- SLIDE 1 -->
                    <li data-transition="random" data-slotamount="7" data-masterspeed="300" data-saveperformance="off">
                        <!-- MAIN IMAGE -->
                        <img src="images/casse72.jpg" alt="slider" data-bgposition="center center" data-bgfit="cover"
                             data-bgrepeat="no-repeat">
                        <!-- LAYERS -->
                        <!-- LAYER NR. 1 -->
                        <div class="tp-caption font-playfair sfb tp-resizeme"
                             data-x="left" data-hoffset="0"
                             data-y="center" data-voffset="-200"
                             data-speed="800"
                             data-start="500"
                             data-easing="Power3.easeInOut"
                             data-splitin="none"
                             data-splitout="none"
                             data-elementdelay="0.1"
                             data-endelementdelay="0.1"
                             data-endspeed="300"
                             style="z-index: 7; font-size:18px; color:#fff; max-width: auto; max-height: auto; white-space: nowrap;">
                            Prodotto da EASYEXPO
                        </div>
                        <!-- LAYER NR. 2 -->
                        <div class="tp-caption sfl font-extra-bold tp-resizeme"
                             data-x="left" data-hoffset="0"
                             data-y="center" data-voffset="-120"
                             data-speed="800"
                             data-start="800"
                             data-easing="Power3.easeInOut"
                             data-splitin="none"
                             data-splitout="none"
                             data-elementdelay="0.07"
                             data-endelementdelay="0.1"
                             data-endspeed="300"
                             style="z-index: 6; font-size:80px; color:#2d3a4b; text-transform:uppercase; white-space: nowrap;">
                            <small class="font-regular">€</small>${prezzo} </div>
                        <!-- LAYER NR. 2 -->
                        <div class="tp-caption sfr font-extra-bold tp-resizeme"
                             data-x="left" data-hoffset="0"
                             data-y="center" data-voffset="0"
                             data-speed="800"
                             data-start="800"
                             data-easing="Power3.easeInOut"
                             data-splitin="chars"
                             data-splitout="none"
                             data-elementdelay="0.07"
                             data-endelementdelay="0.1"
                             data-endspeed="300"
                             style="z-index: 6; font-size:100px; color:#fff; text-transform:uppercase; white-space: nowrap;">
                            casse
                        </div>
                        <!-- LAYER NR. 2 -->
                        <div class="tp-caption sfr font-extra-bold tp-resizeme"
                             data-x="left" data-hoffset="0"
                             data-y="center" data-voffset="110"
                             data-speed="800"
                             data-start="1300"
                             data-easing="Power3.easeInOut"
                             data-splitin="chars"
                             data-splitout="none"
                             data-elementdelay="0.07"
                             data-endelementdelay="0.1"
                             data-endspeed="300"
                             style="z-index: 6; font-size:100px; color:#fff; text-transform:uppercase; white-space: nowrap;">
                            da palco
                        </div>
                        <!-- LAYER NR. 4 -->
                        <div class="tp-caption lfb tp-resizeme"
                             data-x="left" data-hoffset="0"
                             data-y="center" data-voffset="240"
                             data-speed="800"
                             data-start="2200"
                             data-easing="Power3.easeInOut"
                             data-elementdelay="0.1"
                             data-endelementdelay="0.1"
                             data-endspeed="300"
                             data-scrolloffset="0"
                             style="z-index: 8;"><a href="#." class="btn">AGGIUNGI AL CARRELLO</a></div>
                    </li>

                    <!-- SLIDE 2 -->
                    <li data-transition="random" data-slotamount="7" data-masterspeed="300" data-saveperformance="off">
                        <!-- MAIN IMAGE -->
                        <img src="images/calculator.jpg" alt="slider" data-bgposition="center center" data-bgfit="cover"
                             data-bgrepeat="no-repeat">
                        <!-- LAYERS -->
                        <!-- LAYER NR. 1 -->
                        <div class="tp-caption font-playfair sfb tp-resizeme"
                             data-x="center" data-hoffset="0"
                             data-y="center" data-voffset="-150"
                             data-speed="800"
                             data-start="500"
                             data-easing="Power3.easeInOut"
                             data-splitin="none"
                             data-splitout="none"
                             data-elementdelay="0.1"
                             data-endelementdelay="0.1"
                             data-endspeed="300"
                             style="z-index: 7; font-size:18px; color:#fff; max-width: auto; max-height: auto; white-space: nowrap;">
                            Prodotto da EASYEXPO
                        </div>
                        <!-- LAYER NR. 2 -->
                        <div class="tp-caption sfr font-regular tp-resizeme letter-space-4"
                             data-x="center" data-hoffset="0"
                             data-y="center" data-voffset="-50"
                             data-speed="800"
                             data-start="800"
                             data-easing="Power3.easeInOut"
                             data-splitin="chars"
                             data-splitout="none"
                             data-elementdelay="0.07"
                             data-endelementdelay="0.1"
                             data-endspeed="300"
                             style="z-index: 6; font-size:68px; color:#fff; text-transform:uppercase; white-space: nowrap;">
                            richiedi
                        </div>
                        <!-- LAYER NR. 2 -->
                        <div class="tp-caption sfr font-extra-bold tp-resizeme letter-space-4"
                             data-x="center" data-hoffset="0"
                             data-y="center" data-voffset="60"
                             data-speed="800"
                             data-start="1300"
                             data-easing="Power3.easeInOut"
                             data-splitin="chars"
                             data-splitout="none"
                             data-elementdelay="0.07"
                             data-endelementdelay="0.1"
                             data-endspeed="300"
                             style="z-index: 6; font-size:100px; color:#fff; text-transform:uppercase; white-space: nowrap;">
                            un preventivo
                        </div>
                        <!-- LAYER NR. 4 -->
                        <div class="tp-caption sfb font-extra-bold tp-resizeme"
                             data-x="center" data-hoffset="120"
                             data-y="center" data-voffset="200"
                             data-speed="800"
                             data-start="2200"
                             data-easing="Power3.easeInOut"
                             data-splitin="none"
                             data-splitout="none"
                             data-elementdelay="0.07"
                             data-endelementdelay="0.1"
                             data-endspeed="300"
                             style="z-index: 6; font-size:60px; color:#fff; text-transform:uppercase; white-space: nowrap;">
                            <small class="font-regular">€</small> ${prezzo}
                        </div>
                        <!-- LAYER NR. 4 -->
                        <div class="tp-caption lfb tp-scrollbelowslider tp-resizeme"
                             data-x="center" data-hoffset="-120"
                             data-y="center" data-voffset="200"
                             data-speed="800"
                             data-start="2200"
                             data-easing="Power3.easeInOut"
                             data-elementdelay="0.1"
                             data-endelementdelay="0.1"
                             data-endspeed="300"
                             data-scrolloffset="0"
                             style="z-index: 8;"><a href="#." class="btn">RICHIEDI ORA</a></div>
                    </li>
                    <!-- SLIDE 3 -->
                    <li data-transition="random" data-slotamount="7" data-masterspeed="300" data-saveperformance="off">
                        <!-- MAIN IMAGE -->
                        <img src="images/casse72.jpg" alt="slider" data-bgposition="center center" data-bgfit="cover"
                             data-bgrepeat="no-repeat">
                        <!-- LAYERS -->
                        <!-- LAYER NR. 1 -->
                        <div class="tp-caption font-playfair sfb tp-resizeme"
                             data-x="left" data-hoffset="0"
                             data-y="center" data-voffset="-200"
                             data-speed="800"
                             data-start="500"
                             data-easing="Power3.easeInOut"
                             data-splitin="none"
                             data-splitout="none"
                             data-elementdelay="0.1"
                             data-endelementdelay="0.1"
                             data-endspeed="300"
                             style="z-index: 7; font-size:18px; color:#fff; max-width: auto; max-height: auto; white-space: nowrap;">
                            Prodotto da EASYEXPO1
                        </div>
                        <!-- LAYER NR. 2 -->
                        <div class="tp-caption sfl font-extra-bold tp-resizeme"
                             data-x="left" data-hoffset="0"
                             data-y="center" data-voffset="-120"
                             data-speed="800"
                             data-start="800"
                             data-easing="Power3.easeInOut"
                             data-splitin="none"
                             data-splitout="none"
                             data-elementdelay="0.07"
                             data-endelementdelay="0.1"
                             data-endspeed="300"
                             style="z-index: 6; font-size:80px; color:#2d3a4b; text-transform:uppercase; white-space: nowrap;">
                            <small class="font-regular">€</small>${prezzo} </div>
                        <!-- LAYER NR. 2 -->
                        <div class="tp-caption sfr font-extra-bold tp-resizeme"
                             data-x="left" data-hoffset="0"
                             data-y="center" data-voffset="0"
                             data-speed="800"
                             data-start="800"
                             data-easing="Power3.easeInOut"
                             data-splitin="chars"
                             data-splitout="none"
                             data-elementdelay="0.07"
                             data-endelementdelay="0.1"
                             data-endspeed="300"
                             style="z-index: 6; font-size:100px; color:#fff; text-transform:uppercase; white-space: nowrap;">
                            casse
                        </div>
                        <!-- LAYER NR. 2 -->
                        <div class="tp-caption sfr font-extra-bold tp-resizeme"
                             data-x="left" data-hoffset="0"
                             data-y="center" data-voffset="110"
                             data-speed="800"
                             data-start="1300"
                             data-easing="Power3.easeInOut"
                             data-splitin="chars"
                             data-splitout="none"
                             data-elementdelay="0.07"
                             data-endelementdelay="0.1"
                             data-endspeed="300"
                             style="z-index: 6; font-size:100px; color:#fff; text-transform:uppercase; white-space: nowrap;">
                            da palco
                        </div>
                        <!-- LAYER NR. 4 -->
                        <div class="tp-caption lfb tp-resizeme"
                             data-x="left" data-hoffset="0"
                             data-y="center" data-voffset="240"
                             data-speed="800"
                             data-start="2200"
                             data-easing="Power3.easeInOut"
                             data-elementdelay="0.1"
                             data-endelementdelay="0.1"
                             data-endspeed="300"
                             data-scrolloffset="0"
                             style="z-index: 8;"><a href="#." class="btn">AGGIUNGI AL CARRELLO</a></div>
                    </li>
                </ul>
            </div>
        </div>
    </section>

    <!-- Content -->
    <div id="content">

        <!-- Nuovi arrivi -->
        <section class="padding-top-50 padding-bottom-150">
            <div class="container">

                <!-- Main Heading -->
                <div class="heading text-center">
                    <h4>Nuovi arrivi</h4>
                    <span>Tutti i nuovi prodotti aggiunti al sito dai nostri Fornitori di fiducia!</span></div>

                <!-- Popular Item Slide -->
                <div class="papular-block block-slide">

                    <!-- Item -->
                    <div class="item">
                        <!-- Item img -->
                        <div class="item-img"><img class="img-1" src="images/product-1.jpg" alt=""> <img class="img-2"
                                                                                                         src="images/product-2.jpg"
                                                                                                         alt="">
                            <!-- Overlay -->
                            <div class="overlay">
                                <div class="position-center-center">
                                    <div class="inn"><a href="images/product-1.jpg" data-lighter><i
                                            class="icon-magnifier"></i></a> <a href="#." data-toggle="tooltip"
                                                                               data-placement="top"
                                                                               title="Aggiungi al Carrello"><i
                                            class="icon-basket"></i></a></div>
                                </div>
                            </div>
                        </div>
                        <!-- Item Name -->
                        <div class="item-name"><a href="SpecificheProdottoServlet">stone cup</a>
                            <p>Lorem ipsum dolor sit amet</p>
                        </div>
                        <!-- Price -->
                        <span class="price"><small>€</small>${prezzo}</span></div>

                    <!-- Item -->
                    <div class="item">
                        <!-- Item img -->
                        <div class="item-img"><img class="img-1" src="images/product-2.jpg" alt=""> <img class="img-2"
                                                                                                         src="images/product-2.jpg"
                                                                                                         alt="">
                            <!-- Overlay -->
                            <div class="overlay">
                                <div class="position-center-center">
                                    <div class="inn"><a href="images/product-2.jpg" data-lighter><i
                                            class="icon-magnifier"></i></a> <a href="#." data-toggle="tooltip"
                                                                               data-placement="top"
                                                                               title="Aggiungi al Carrello"><i
                                            class="icon-basket"></i></a></div>
                                </div>
                            </div>
                        </div>
                        <!-- Item Name -->
                        <div class="item-name"><a href="#.">gray bag</a>
                            <p>Lorem ipsum dolor sit amet</p>
                        </div>
                        <!-- Price -->
                        <span class="price"><small>€</small>${prezzo}</span></div>

                    <!-- Item -->
                    <div class="item">
                        <!-- Item img -->
                        <div class="item-img"><img class="img-1" src="images/product-3.jpg" alt=""> <img class="img-2"
                                                                                                         src="images/product-2.jpg"
                                                                                                         alt="">
                            <!-- Overlay -->
                            <div class="overlay">
                                <div class="position-center-center">
                                    <div class="inn"><a href="images/product-3.jpg" data-lighter><i
                                            class="icon-magnifier"></i></a> <a href="#." data-toggle="tooltip"
                                                                               data-placement="top"
                                                                               title="Aggiungi al Carrello"><i
                                            class="icon-basket"></i></a></div>
                                </div>
                            </div>
                        </div>
                        <!-- Item Name -->
                        <div class="item-name"><a href="#.">chiar</a>
                            <p>Lorem ipsum dolor sit amet</p>
                        </div>
                        <!-- Price -->
                        <span class="price"><small>€</small>${prezzo}</span></div>

                    <!-- Item -->
                    <div class="item">
                        <!-- Item img -->
                        <div class="item-img"><img class="img-1" src="images/product-4.jpg" alt=""> <img class="img-2"
                                                                                                         src="images/product-2.jpg"
                                                                                                         alt="">
                            <!-- Overlay -->
                            <div class="overlay">
                                <div class="position-center-center">
                                    <div class="inn"><a href="images/product-4.jpg" data-lighter><i
                                            class="icon-magnifier"></i></a> <a href="#." data-toggle="tooltip"
                                                                               data-placement="top"
                                                                               title="Aggiungi al Carrello"><i
                                            class="icon-basket"></i></a></div>
                                </div>
                            </div>
                        </div>
                        <!-- Item Name -->
                        <div class="item-name"><a href="#.">STool</a>
                            <p>Lorem ipsum dolor sit amet</p>
                        </div>
                        <!-- Price -->
                        <span class="price"><small>€</small>${prezzo}</span></div>
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
                    <!--<li><a href="#."><i class="icon-social-tumblr"></i></a></li>
                   <li><a href="#."><i class="icon-social-youtube"></i></a></li>
                   <li><a href="#."><i class="icon-social-dribbble"></i></a></li>-->
                </ul>
            </div>
        </section>
    </div>
    <!--FOOTER-->
    <footer>
        <jsp:include page="/footer.jsp"/>
    </footer>

    <!--======= RIGHTS =========-->

</div>
</body>
</html>
