<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.POJO.Prodotto" %>
<%@ page import="Model.POJO.Carrello" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="Model.POJO.Fornitore" %>
<%@ page import="java.util.Collection" %>

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

<!-- LOADER -->
<div id="loader">
    <div class="position-center-center">
        <div class="ldr"></div>
    </div>
</div>

<!-- Wrap -->
<div id="wrap">

    <!--======= SUB BANNER =========-->
    <section class="sub-bnr" data-stellar-background-ratio="0.5">
        <div class="position-center-center">
            <div class="container">
                <h4>CARRELLO</h4>
                <p style="color: black">Visualizza qui tutti i prodotti e servizi nel tuo carrello e procedi ad
                    inoltrare un preventivo
                    ad ognuno dei fornitori da te selezionati.</p>

                <!--<ol class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">SHOP</a></li>
                    <li class="active">SHOPPING CART</li>
                </ol>-->

            </div>
        </div>
    </section>

    <!-- Content -->
    <div id="content">

        <!--======= PAGES INNER =========-->
        <section class="padding-top-100 padding-bottom-100 pages-in chart-page">
            <div class="container">

                    <% Carrello carrello = (Carrello) session.getAttribute("carrello");
                    ArrayList<Fornitore> listaFornitori = (ArrayList<Fornitore>) session.getAttribute("listaFornitori");
                    /*ciclo su listaPI e per ogni stringa get dal carrello*/
                    /*ListProd è l'arrayList di prodotti associata ad ogni fornitore*/
                    /*faccio un ciclo per ogni ListProd ed ottengo il prodotto singolo*/
                    /*per ogni prodotto posso stampare gli attributi*/

                %>

                            <% if(carrello==null) {%>
                        <h1> Nessun prodotto nel carrello. </h1>
                            <%}%>

                            <% if(carrello!=null){
                                    if(carrello.getProdottiFornitori().isEmpty()){%>
                                        <h1> Nessun prodotto nel carrello. </h1>
                            <% }%>





                <!-- Payments Steps -->
                            <% if(!carrello.getProdottiFornitori().isEmpty()) {%>

                <div class="shopping-cart text-center">
                    <!-- un div fornitore per ogni fornitore nella lista -->

                    <c:forEach items="${listaFornitori}" var="fornitori">
                        <c:set var="TOT" value="0"/>
                        <div class="fornitoreCarrello" style="border: #ffe115 solid 3px; padding: 40px 30px">
                            <div class="cart-head">
                                <ul class="row">
                                    <!-- FORNITORE -->
                                    <li class="col-sm-2 text-left">
                                        <h5>FORNITORE: </h5>
                                    </li>
                                    <!-- NOME FORNITORE -->
                                    <li class="col-sm-4 text-left">
                                        <h5><a href="FornitoreServlet?partitaIva=<c:out value="${fornitori.partitaIva}"/>"> <c:out value="${fornitori.nome}"/> <c:out
                                                value="${fornitori.cognome}"/> </a> </h5>
                                    </li>
                                    <!-- PRICE -->
                                    <li class="col-sm-2">
                                        <h5 style="font-size: 15px">PREZZO</h5>
                                    </li>
                                    <!-- QTY -->
                                    <li class="col-sm-1">
                                        <h5 style="font-size: 15px">QTA</h5>
                                    </li>

                                    <!-- TOTAL PRICE -->
                                    <li class="col-sm-2">
                                        <h5 style="font-size: 15px">TOTAL</h5>
                                    </li>
                                    <li class="col-sm-1"></li>
                                </ul>
                            </div>

                            <c:forEach items="${carrello.get(fornitori.partitaIva)}" var="ListaProd">

                                <!-- Cart Details -->
                                <ul class="row cart-details">
                                    <li class="col-sm-6">
                                        <!-- Media Image -->
                                        <div class="media-left media-middle"><a href="ProdottoServlet?id=<c:out value="${ListaProd.prodotto.idProdotto}"/>&partitaIva=<c:out value="${ListaProd.prodotto.partitaIva}"/>" class="item-img"> <img
                                                class="media-object" src="${ListaProd.prodotto.immagine}" width="170px"
                                                height="170px" alt=""> </a></div>


                                        <!-- Item Name -->
                                        <div class="media-body">
                                            <div class="position-center-center">

                                                <h5><c:out value="${ListaProd.prodotto.titolo}"/></h5>
                                            </div>
                                        </div>

                                    </li>

                                    <!-- PREZZO -->
                                    <li class="col-sm-2">
                                        <div class="position-center-center"><span class="price"><small>€</small> <c:out
                                                value="${ListaProd.prodotto.prezzo}"/></span></div>
                                    </li>

                                    <!-- QTA -->
                                    <li class="col-sm-1">
                                        <div class="position-center-center">
                                            <h4 style="font-size: 18px"><c:out value="${ListaProd.quantita}"/></h4>
                                            <!-- QTY
                                            <div class="quinty">

                                                <select class="selectpicker">
                                                    <option>1</option>
                                                    <option>2</option>
                                                    <option>3</option>
                                                </select>
                                            </div>
                                            -->
                                        </div>
                                    </li>



                                    <!-- TOTAL PRICE -->
                                    <li class="col-sm-2">
                                        <div class="position-center-center"><span
                                                class="price"><small>€</small>
                                            <c:set var="TOTparziale" value="${ListaProd.prodotto.prezzo * ListaProd.quantita}"/>
                                            <c:out value="${TOTparziale}"/></span></div>

                                            <c:set var="TOT" value="${TOT = TOT + TOTparziale}"/>

                                    </li>

                                    <!-- REMOVE -->
                                    <li class="col-sm-1">
                                        <div class="position-center-center"><a href="Carrello?prodId=<c:out value="${ListaProd.prodotto.idProdotto}"/>&partitaIva=<c:out value="${ListaProd.prodotto.partitaIva}"/>"> <i class="icon-close"></i></a>
                                        </div>
                                    </li>
                                </ul>
                            </c:forEach>


                            <div class="cart-ship-info margin-top-0">
                                <div class="row">

                                    <!-- PREVENTIVO -->
                                    <form action="CompilaRichiesta" method="post">
                                    <div class="col-sm-7">
                                        <input type="hidden" name="carrello" value="${carrello}">
                                        <input type="hidden" name="fornitore" value="${fornitori.partitaIva}">
                                        <input class="btn" style="font-size: 18px; padding: 0px 100px; margin-top: 19px" type="submit" value="INVIA UN PREVENTIVO A QUESTO FORNITORE">
                                    </div>
                                    </form>

                                    <!-- SUB TOTAL -->
                                    <div class="col-sm-5">
                                        <div class="grand-total">
                                            <div class="order-detail">
                                                <!-- SUB TOTAL -->
                                                <p class="all-total">COSTO TOTALE <span>€ <c:out value="${TOT}"/> </span></p>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>

                        </div>


                    </c:forEach>

                </div>
        </section>

        <%}}%>

    </div>


</div>


<!--======= FOOTER =========-->
<footer>
    <jsp:include page="/footer.jsp"/>
</footer>

</body>
</html>
