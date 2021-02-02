<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                            <small class="font-regular"></small>${prezzo} </div>
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
                            Trova tutto
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
                            ciò che cerchi!
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
                             style="z-index: 8;"></div>
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
                            <small class="font-regular"></small>${prezzo} </div>
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
                            Organizza
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
                            il tuo evento
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
                             style="z-index: 8;"></div>
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

                    <!-- Item 0 -->

                    <div class="itema">
                        <!-- Item img -->
                        <div class="item-img"><img class="img-1" src="${prodottiNuovi.get(0).immagine}" alt="" width="270px" height="352px">
                        </div>
                        <!-- Item Name -->
                        <div class="item-name"><a href="ProdottoServlet?id=<c:out value="${prodottiNuovi.get(0).idProdotto}"/>&partitaIva=<c:out value="${prodottiNuovi.get(0).partitaIva}"/>"> <c:out value="${prodottiNuovi.get(0).getTitolo()}" /></a>
                        </div>
                        <!-- Price -->
                        <span class="price"><small>€</small>${prodottiNuovi.get(0).prezzo}</span></div>

                    <!-- Item 1-->
                    <div class="itema">
                        <!-- Item img -->
                        <div class="item-img"><img class="img-1" src="${prodottiNuovi.get(1).immagine}" alt="" width="270px" height="352px">
                        </div>
                        <!-- Item Name -->
                        <div class="item-name"><a href="ProdottoServlet?id=<c:out value="${prodottiNuovi.get(1).idProdotto}"/>&partitaIva=<c:out value="${prodottiNuovi.get(1).partitaIva}"/>"><c:out value="${prodottiNuovi.get(1).getTitolo()}" /></a>
                        </div>
                        <!-- Price -->
                        <span class="price"><small>€</small>${prodottiNuovi.get(1).prezzo}</span></div>

                    <!-- Item 2-->
                    <div class="itema">
                        <!-- Item img -->
                        <div class="item-img"><img class="img-1" src="${prodottiNuovi.get(2).immagine}" alt="" width="270px" height="352px">
                        </div>
                        <!-- Item Name -->
                        <div class="item-name"><a href="ProdottoServlet?id=<c:out value="${prodottiNuovi.get(2).idProdotto}"/>&partitaIva=<c:out value="${prodottiNuovi.get(2).partitaIva}"/>"><c:out value="${prodottiNuovi.get(2).getTitolo()}" /></a>
                        </div>
                        <!-- Price -->
                        <span class="price"><small>€</small>${prodottiNuovi.get(2).prezzo}</span></div>

                    <!-- Item 3-->
                    <div class="itema">
                        <!-- Item img -->
                        <div class="item-img"><img class="img-1" src="${prodottiNuovi.get(3).immagine}" alt="" width="270px" height="352px">
                        </div>
                        <!-- Item Name -->
                        <div class="item-name"><a href="ProdottoServlet?id=<c:out value="${prodottiNuovi.get(3).idProdotto}"/>&partitaIva=<c:out value="${prodottiNuovi.get(3).partitaIva}"/>"><c:out value="${prodottiNuovi.get(3).getTitolo()}" /></a>
                        </div>
                        <!-- Price -->
                        <span class="price"><small>€</small>${prodottiNuovi.get(3).prezzo}</span></div>
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
