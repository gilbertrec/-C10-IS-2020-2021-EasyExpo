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
            <jsp:param name="pageTitle" value="Area Fornitore"/>
        </jsp:include>
    </header>

    <!--======= SUB BANNER =========-->
    <section class="sub-bnr" data-stellar-background-ratio="0.5">
        <div class="position-center-center">
            <div class="container">
                <h4>${fornitore.nome} ${fornitore.cognome}</h4>
                <p> P. IVA : ${fornitore.partitaIva} <br>
                    Telefono: ${fornitore.telefono}<br>
                    Luogo di ubicazione: ${fornitore.luogoUbicazione}<br>
                    Email: ${fornitore.email}<br>
                    Ragione Sociale: ${fornitore.ragioneSociale}<br>
                    Abbonato: ${fornitore.abbonato}<br></p>
                <li>
                    <form action="AbbonamentoServlet" method="post">
                        <input type="hidden" name="partitaIva" value="${fornitore.partitaIva}">
                        <button style="webkit-appearance: button; cursor: pointer; background: none; margin: 0px; height: 40px; margin-top: 30px;
                             padding: 0px 40px; background: #2d3a4b; display: inline-block; border-radius: 20px; color: white; font-size: 12px; border: 0px">
                            ABBONAMENTO
                        </button>
                    </form>
                </li>
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
                                <c:if test="${fornitore.abbonato == true}">
                                    <ol class="breadcrumb">

                                        <li><a href="aggiuntaProdotto.jsp">Aggiungi Prodotto</a></li>
                                    </ol>
                                </c:if>
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
                                    <div class="item-img"><img class="imma" src="${contenuto.immagine}" width="260px"
                                                               height="280px" alt="">
                                        <!-- Overlay -->
                                        <div class="overlay">
                                            <div class="position-center-center">
                                                <div class="inn">
                                                    <a href="${contenuto.immagine}" data-lighter><i
                                                            class="icon-magnifier"></i></a>
                                                    <c:if test="${fornitore.abbonato == true}">
                                                        <a href="ModificaProdottoServlet?id=<c:out value="${contenuto.idProdotto}"/>&partitaIva=<c:out value="${contenuto.partitaIva}"/>"><i
                                                                class="icon-pencil"></i></a>
                                                        <a href="ELiminaProdottoServlet?id=<c:out value="${contenuto.idProdotto}"/>&partitaIva=<c:out value="${contenuto.partitaIva}"/>"><i
                                                                class="icon-trash"></i></a>
                                                    </c:if>
                                                </div>
                                            </div>
                                        </div>
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
        </section>
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
