<%@ page import="Model.POJO.Tag" %>
<%@ page import="Model.DAO.TagDAO" %>
<%@ page import="Model.POJO.TagProdotto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.ArrayList" %>
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
            <h4 style="color: #ffe115; font-weight: 900;">${prodotti.titolo}</h4>

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
                                <div class="col-sm-6 margin-bottom-30"><img class="imma" src="${prodotti.immagine}"
                                                                            width="500px" height="600px" alt=""></div>
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

                                <!-- AGGIUNGI AL CARRELLO -->
                                <form action="Carrello" method="post">
                                    <!--QUANTITA-->
                                    <li class="col-md-6">
                                        <label> QUANTITÀ
                                            <input type="number" name="addNum" value="1" placeholder="" min="1"
                                                   max="${prodotti.quantità}">
                                        </label>
                                    </li>

                                    <input type="hidden" name="prodId" value="${prodotti.idProdotto}">
                                    <input type="hidden" name="partitaIva" value="${prodotti.partitaIva}">
                                    <!--<input type="hidden" name="addNum" value="1"> modifica numero di prodotti aggiunti -->
                                    <li class="col-xs-6"><input class="btn" type="submit" value="AGGIUNGI"></li>
                                    <!--<li class="col-xs-6"><a href="carrello.jsp" class="btn">AGGIUNGI</a></li>-->
                                </form>

                            </ul>

                            <!-- INFOMATION -->
                            <div class="inner-info">
                                <h6>INFORMAZIONI FORNITORE</h6>
                                <h5>
                                    <a href="FornitoreServlet?partitaIva=<c:out value="${fornitore.partitaIva}"/>"> ${fornitore.nome} ${fornitore.cognome}</a>
                                </h5>
                                <h7>Questo fornitore si trova a: ${fornitore.luogoUbicazione}</h7>
                            </div>
                            <!-- tag -->
                            <div class="inner-info">
                                <h6>TAG</h6>
                                <%
                                    ArrayList<Tag> tags = (ArrayList<Tag>) request.getAttribute("tags");
                                    for (int i = 0; i < tags.size(); i++) {%>
                                <p><%= tags.get(i).getNome()%>
                                </p>
                                <%}%>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

            <!--======= PRODUCT DESCRIPTION =========-->
            <div class="item-decribe">
                <!-- Nav tabs -->
                <ul class="nav nav-tabs animate fadeInUp" data-wow-delay="0.4s" role="tablist">
                    <li role="presentation" class="active"><a href="#descr" role="tab" data-toggle="tab">DESCRIZIONE</a>
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