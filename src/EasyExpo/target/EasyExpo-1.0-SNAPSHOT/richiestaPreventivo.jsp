<%@ page import="Model.POJO.Prodotto" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.POJO.ProdottoRichiesta" %>
<%@ page import="Model.POJO.RichiestaPreventivo" %>
<%@ page import="Model.POJO.Carrello" %>
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
            <jsp:param name="pageTitle" value="RichiestaPreventivo"/>
        </jsp:include>
    </header>

    <!--======= SUB BANNER =========-->
    <section class="sub-bnr" data-stellar-background-ratio="0.5">
        <div class="position-center-center">
            <div class="container">
                <h4>RICHIESTA PREVENTIVO</h4>
            </div>
        </div>
    </section>

    <!-- Content -->
    <div id="content">

        <!--======= PAGES INNER =========-->
        <section class="chart-page padding-top-100 padding-bottom-100">
            <div class="container">

                <!-- Payments Steps -->
                <div class="shopping-cart">

                    <!-- SHOPPING INFORMATION -->
                    <div class="cart-ship-info register">
                        <div class="row">

                            <!-- ESTIMATE SHIPPING & TAX -->
                            <div class="col-sm-12">
                                <h6>RICHIEDI UN PREVENTIVO</h6>
                                <form action="CompilaRichiesta">
                                    <ul class="row">

                                        <!-- TITOLO -->
                                        <li class="col-md-6">
                                            <label> TITOLO
                                                <input type="text" name="titolo" value="" placeholder="">
                                            </label>
                                        </li>

                                        <!-- LUOGO EVENTO -->
                                        <li class="col-md-6">
                                            <label> LUOGO EVENTO
                                                <input type="text" name="luogo" value="" placeholder="">
                                            </label>
                                        </li>

                                        <!-- NOTA -->
                                        <li class="col-md-6">
                                            <label> NOTA
                                                <input type="text" name="nota" value="" placeholder="">
                                            </label>
                                        </li>

                                        <!-- DESCRIZIONE EVENTO -->
                                        <li class="col-md-6">
                                            <label> DESCRIZIONE EVENTO
                                                <textarea name="descrizione" rows="5"
                                                          cols="80"></textarea>
                                            </label>
                                        </li>

                                    </ul>
                                    <h5 class="shop-title margin-top-60 margin-bottom-30">PRODOTTI</h5>
                                    <ul class="papu-post margin-top-20">
                                        <%
                                            ArrayList<Carrello.ProdottoQuantita> listaProdotti = (ArrayList<Carrello.ProdottoQuantita>) session.getAttribute("listaProdotti");

                                            for (int i = 0; i < listaProdotti.size(); i++) {
                                        %>

                                        <li class="col-md-6">
                                            <div class="media-left media-middle"><a href="#"> <img class="media-object"
                                                                                      src="<%=listaProdotti.get(i).getProdotto().getImmagine()%>"
                                                                                      alt="" width="170px" height="170px"></a></div>
                                            <div class="media-body"><a class="media-heading"
                                                                       href="#."><small>€</small><%=listaProdotti.get(i)
                                                    .getProdotto().getPrezzo()%> x <%=listaProdotti.get(i)
                                                    .getQuantita()%>
                                                <span><% float totale = listaProdotti.get(i).getProdotto().getPrezzo() * listaProdotti.get(i).getQuantita();%>
                                            <%=totale%></span>
                                            </a>
                                                <span><%=listaProdotti.get(i).getProdotto().getTitolo()%></span></div>
                                        </li>
                                        <!-- DATA INIZIO NOLEGGIO -->
                                        <li class="col-md-6">
                                            <label> DATA INIZIO NOLEGGIO
                                                <input type="date" name="dataInizio" value="" placeholder="">
                                            </label>
                                        <!-- DATA FINE NOLEGGIO -->
                                            <label> DATA FINE NOLEGGIO
                                                <input type="date" name="dataFine" value="" placeholder="">
                                            </label>
                                        </li>
                                        <%}%>
                                    </ul>
                                    <!-- INOLTRA -->
                                    <li class="col-md-6">
                                        <button type="submit" class="btn">INOLTRA</button>
                                    </li>
                                </form>
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

        <!--======= FOOTER =========-->
        <footer>
            <jsp:include page="/footer.jsp"/>
        </footer>

    </div>
</div>
</body>
</html>
