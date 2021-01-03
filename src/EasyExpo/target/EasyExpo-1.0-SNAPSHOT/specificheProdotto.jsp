<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<body>
<!-- header -->
<header>
    <jsp:include page="/header.jsp">
        <jsp:param name="pageTitle" value="Prodotto"/>
    </jsp:include>
</header>

<!--======= SUB BANNER =========-->
<section class="sub-bnr" data-stellar-background-ratio="0.5">
    <div class="position-center-center">
        <div class="container">
            <h1 style="color: #ffe115; font-weight: 900;">${prodotti.titolo}</h1>
            <!--<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec faucibus maximus vehicula.
                Sed feugiat, tellus vel tristique posuere, diam</p>-->
            <ol class="breadcrumb">
                <li><a href="#">Home</a></li>
                <li class="active">Data</li>
            </ol>
        </div>
    </div>
</section>

<!-- Content -->
<div id="content">

    <!-- Popular Products -->
    <section class="padding-top-100 padding-bottom-100">
        <div class="container">

            <!-- SHOP DETAIL -->
            <div class="shop-detail">
                <div class="row">

                    <!-- Popular Images Slider -->
                    <div class="col-md-7">

                        <!-- Images Slider -->
                            <ul class="slides">
                                <div class="row">
                                    <div class="col-sm-6 margin-bottom-30"> <img class="img-responsive" src="${prodotti.immagine}" alt=""> </div>
                                </div>
                            </ul>
                        </div>

                    <!-- Content -->
                    <div class="col-md-5">
                        <h4>${prodotti.titolo}</h4>
                        <span class="price"><small>€</small>${prodotti.prezzo}</span>

                        <!-- Item Detail -->
                        <h6>${prodotti.tipo}</h6>

                        <!-- Short By -->
                        <div class="some-info">
                            <ul class="row margin-top-30">
                                <!--QUANTITA-->
                                <li class="col-md-6">
                                    <label> QUANTITÀ (1-999)
                                        <input type="number" name="quantita" value="${prodotti.quantità}" placeholder="" min="1" max="999">
                                    </label>
                                </li>

                                <!-- AGGIUNGI AL CARRELLO -->
                                <li class="col-xs-6"><a href="#." class="btn">AGGIUNGI</a></li>

                                        </ul>

                                        <!-- INFOMATION -->
                                        <div class="inner-info">
                                            <h6>INFORMAZIONI FORNITORE</h6>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum
                                                finibus ligula a
                                                scelerisque gravida. Nullam laoreet tortor ac maximus alique met,
                                                consectetur
                                                adipiscing elit. </p>

                                            <!-- TAGS -->
                                            <h5 class="shop-tittle margin-top-60 margin-bottom-30">POPULAR TAGS</h5>
                                            <ul class="shop-tags">
                                                <li><a href="#.">Musica</a></li>
                                                <li><a href="#.">Casse</a></li>


                                            </ul>


                                        </div>
                                    </div>
                                </div>
                        </div>
                    </div>

                    <!--======= PRODUCT DESCRIPTION =========-->
                    <div class="item-decribe">
                        <!-- Nav tabs -->
                        <ul class="nav nav-tabs animate fadeInUp" data-wow-delay="0.4s" role="tablist">
                            <li role="presentation" class="active"><a href="#descr" role="tab" data-toggle="tab">DESCRIPTION</a>
                            </li>
                        </ul>

                        <!-- Tab panes -->
                        <div class="tab-content animate fadeInUp" data-wow-delay="0.4s">
                            <!-- DESCRIPTION -->
                            <div role="tabpanel" class="tab-pane fade in active" id="descr">
                                <p style="font-size: 20px"> ${prodotti.descrizione} </p>
                            </div>

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


        </div>
    </section>

</div>



<!--======= FOOTER =========-->
<footer>
    <jsp:include page="/footer.jsp"/>
</footer>


</div>
</body>
</html>