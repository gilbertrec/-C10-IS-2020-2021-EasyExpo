<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <jsp:param name="pageTitle" value="Fornitore"/>
        </jsp:include>
    </header>

    <!--======= SUB BANNER =========-->
    <section class="sub-bnr" data-stellar-background-ratio="0.5">
        <div class="position-center-center">
            <div class="container">
                <h1 style="color: #ffe115; font-weight: 900">${fornitore.nome} ${fornitore.cognome}</>
                <p style="color: #2d3a4b; font-size: 20px"> P. IVA : ${fornitore.partitaIva} <br>
                    Telefono: ${fornitore.telefono}<br>
                    Luogo di ubicazione: ${fornitore.luogoUbicazione}<br>
                    Email: ${fornitore.email}<br>
                    Ragione Sociale: ${fornitore.ragioneSociale}</p>
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

                                <!-- <ol class="breadcrumb">
                                    <li><a href="aggiuntaProdotto.jsp">Aggiungi Prodotto</a></li>
                                </ol> -->
                            </div>
                        </div>
                    </div>

                    <!-- Popular Item Slide -->
                    <div class="papular-block row">
                        <!-- Item -->
                        <c:forEach items="${prodotti}" var="contenuto">
                            <div class="col-md-3">
                                <div class="item">
                                    <!-- Item img -->
                                    <div class="item-img"><img class="img-1" src="images/product-2-1.jpg" alt=""> <img
                                            class="img-2" src="images/product-2.jpg" alt="">
                                    </div>
                                    <!-- Item Name -->
                                    <div class="item-name"><a
                                            href="ProdottoServlet?id=<c:out value="${contenuto.idProdotto}"/>&partitaIva=<c:out value="${contenuto.partitaIva}"/>">${contenuto.titolo}</a>
                                    </div>
                                    <!-- Price -->
                                    <span class="price"><small>€</small><c:out value="${contenuto.prezzo}"/></span>
                                </div>
                            </div>
                        </c:forEach>

                    </div>
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
</body>
</html>