<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.POJO.Prodotto" %>
<%@ page import="Model.POJO.ProdottoRichiesta" %><%--
  Created by IntelliJ IDEA.
  User: lucreziarobustelli
  Date: 05/01/2021
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
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
            <jsp:param name="pageTitle" value="Compila Preventivo"/>
        </jsp:include>
    </header>


    <!--======= SUB BANNER =========-->
    <section class="sub-bnr" data-stellar-background-ratio="0.5">
        <div class="position-center-center">
            <div class="container">
                <h4>PREVENTIVO ${richiesta.titolo}</h4>
            </div>
        </div>
    </section>

    <!-- Content -->
    <div id="content">

        <!-- Quotation List -->
        <section class="blog-list blog-list-3 single-post padding-top-100 padding-bottom-0">
            <div class="container">
                <div class="row">
                    <div class="col-md-9">

                        <!-- Article -->
                        <article>
                            <!-- Title -->
                            <div class="post-tittle left"><a href="#." class="tittle">${richiesta.titolo}</a>
                                <!-- Post Info -->
                                <span><i
                                        class="primary-color icon-user"></i> by ${cliente_specifica.nome} ${cliente_specifica.cognome}</span>
                                <span><i class="primary-color icon-calendar"></i> ${richiesta.dataRichiesta}</span>
                            </div>
                            <!-- Post Content  creare il metodo che ti restituisce anche l'altra tabella per i prodotti-->
                            <div class="text-left">
                                <h6 class="margin-top-80 margin-bottom-30" style="margin-top: 9px">Descrizione Evento</h6>
                                <p> ${richiesta.descrizioneEvento}</p>
                            </div>
                        </article>
                        <hr>
                    </div>

                    <!-- Sider Bar -->
                    <div class="col-md-3" style="padding-right: inherit">
                        <div class="shop-sidebar">

                            <!-- Recent Post -->
                            <h5 class="shop-tittle margin-top-60 margin-bottom-30">Prodotti richiesti</h5>
                            <ul class="papu-post margin-top-20">
                                <%
                                    ArrayList<Prodotto> prodotto =
                                            (ArrayList<Prodotto>) session.getAttribute("prodotto");
                                    ArrayList<ProdottoRichiesta> prichiesta =
                                            (ArrayList<ProdottoRichiesta>) session.getAttribute("prichiesta");

                                    for (int i = 0; i < prodotto.size(); i++) {
                                %>

                                <li class="media">
                                    <div class="media-left"><a href="#"> <img class="media-object"
                                                                              src="<%=prodotto.get(i).getImmagine()%>"
                                                                              alt=""></a></div>
                                    <div class="media-body"><a class="media-heading"
                                                               href="#."><small>€</small><%=prodotto.get(i)
                                            .getPrezzo()%> x <%=prichiesta.get(i)
                                            .getNumColli()%>
                                        <span><% float totale = prodotto.get(i).getPrezzo() * prichiesta.get(i).getNumColli();%>
                                            <%=totale%></span>
                                    </a>
                                        <span><%=prodotto.get(i).getTitolo()%></span></div>
                                    <div class="media-body"><a class="media-heading" href="#."><%=prichiesta.get(i)
                                            .getDataInizioNoleggio()%>
                                    </a> <a class="media-heading" href="#."><%=prichiesta.get(i).getDataFineNoleggio()%>
                                    </a></div>


                                </li>
                                <%}%>
                            </ul>
                        </div>
                    </div>

                </div>
            </div>
        </section>

        <!--======= PAGES INNER =========-->
        <section class="chart-page padding-top-0 padding-bottom-100">
            <div class="container">

                <!-- Payments Steps -->
                <div class="shopping-cart">

                    <!-- SHOPPING INFORMATION -->
                    <div class="cart-ship-info register">
                        <div class="row">

                            <!-- ESTIMATE SHIPPING & TAX -->
                            <div class="col-sm-12">
                                <h6>COMPILA</h6>
                                <form action="InoltroPreventivoServlet" method="post">
                                    <input type="hidden" name="partitaIva" value="${fornitore.partitaIva}">
                                    <input type="hidden" name="idRichiesta" value="${richiesta.idRichiesta}">
                                    <input type="hidden" name="codiceFiscale" value="${richiesta.codiceFiscale}">
                                    <ul class="row">
                                        <!-- PREZZO -->
                                        <li class="col-md-6">
                                            <label> PREZZO TOTALE
                                                <input type="text" name="prezzo" value="" placeholder="">
                                            </label>
                                        </li>

                                        <!-- DESCRIZIONE -->
                                        <li class="col-md-6">
                                            <label> NOTA PER IL CLIENTE
                                                <textarea name="nota" rows="5" cols="80"></textarea>
                                            </label>
                                        </li>
                                    </ul>
                                    <!-- PHONE -->
                                    <li class="col-md-6">
                                        <button type="submit" class="btn"> INOLTRA </button>
                                    </li>
                                </form>
                            </div>
                        </div>
                    </div>
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
