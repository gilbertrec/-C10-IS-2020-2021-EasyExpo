<%@ page import="Model.POJO.Prodotto" %>
<%@ page import="Model.POJO.ProdottoRichiesta" %>
<%@ page import="java.util.ArrayList" %>
<%--
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
<head>
    <script>

        function conferma() {
            document.getElementById('info').innerHTML = ' <h6> ${clifor.nome} ${clifor.cognome} </h6> <br> ${clifor.ragioneSociale} - ${clifor.luogoUbicazione} <br> CONTATTI: <br> ${clifor.email} <br>${clifor.telefono}';

        }


    </script>

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

    <header>
        <jsp:include page="/header.jsp">
            <jsp:param name="pageTitle" value="Specifica Preventivo"/>
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
        <section class="blog-list blog-list-3 single-post padding-top-100 padding-bottom-100">
            <div class="container">
                <div class="row">
                    <div class="col-md-9">

                        <!-- Article -->
                        <article>
                            <!-- Title -->
                            <div class="post-tittle left"><a href="#." class="tittle">${richiesta.titolo}</a>
                                <!-- Post Info -->
                                <span><i class="primary-color icon-user"></i> by ${fornitore.nome} ${fornitore.cognome}</span>
                                <span><i class="primary-color icon-calendar"></i> ${preventivo.dataPreventivo}</span>
                            </div>
                            <!-- Post Content  creare il metodo che ti restituisce anche l'altra tabella per i prodotti-->
                            <div class="text-left">
                                <h6 class="margin-top-80 margin-bottom-30">Descrizione Evento</h6>
                                <p> ${richiesta.descrizioneEvento}</p>
                                <h6 class="margin-top-80 margin-bottom-30">Prezzo Totale</h6>
                                <p><small>€</small>${preventivo.prezzoTotale}</p>
                                <h6 class="margin-top-80 margin-bottom-30">Nota del fornitore</h6>
                                <p>${preventivo.nota}</p>


                                <!-- Fornitore/cliente info da fare il choose a seconda di chi lo apre -->
                                <div class="admin-info" id="info">

                                    <c:choose>
                                        <c:when test="${cliente != null}">
                                            <input class="btn" style="margin-left: 320px;" type="submit"
                                                   value="CONFERMA" onclick="conferma()">
                                        </c:when>
                                    </c:choose>
                                </div>
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
                                        <span><%
                                            float totale =
                                                    prodotto.get(i).getPrezzo() * prichiesta.get(i).getNumColli();%>
                                            <%=totale%></span>
                                    </a><span><%=prodotto.get(i).getTitolo()%></span></div>
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

    </div>


    <!--======= FOOTER =========-->
    <footer>
        <jsp:include page="/footer.jsp"/>
    </footer>

</div>
</body>
</html>
