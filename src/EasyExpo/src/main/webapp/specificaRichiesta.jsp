<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.POJO.Prodotto" %>
<%@ page import="Model.POJO.ProdottoRichiesta" %>
<%@ page import="Model.POJO.RichiestaPreventivo" %><%--
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
            <jsp:param name="pageTitle" value="Specifica Richiesta"/>
        </jsp:include>
    </header>


    <!--======= SUB BANNER =========-->
    <section class="sub-bnr" data-stellar-background-ratio="0.5">
        <div class="position-center-center">
            <div class="container">
                <h4>${richiesta.titolo}</h4>
                <ol class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li class="active">BLOg details</li>
                </ol>
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
                                <span><i
                                        class="primary-color icon-user"></i> by ${cliente_specifica.nome} ${cliente_specifica.cognome}</span>
                                <span><i class="primary-color icon-calendar"></i> ${richiesta.dataRichiesta}</span>
                            </div>
                            <!-- Post Content  creare il metodo che ti restituisce anche l'altra tabella per i prodotti-->
                            <div class="text-left">
                                <h6 class="margin-top-80 margin-bottom-30">Descrizione Evento</h6>
                                <blockquote> ${richiesta.descrizioneEvento}</blockquote>
                                <h6 class="margin-top-80 margin-bottom-30">Nota per il fornitore</h6>
                                <p>${richiesta.nota}</p>

                                <!-- Fornitore/cliente info da fare il choose a seconda di chi lo apre -->
                                <div class="admin-info">
                                    <div class="media-body">
                                        <h6>${clifor.nome} ${clifor.cognome} <span>Cliente </span>
                                            <span>${clifor.luogoUbicazione}</span></h6>
                                        <span>CONTATTI</span> <br>
                                        <span>${clifor.email}</span><br>
                                        <span>${clifor.telefono}</span>
                                        <div class="admin-social"><a href="#."><i class="icon-social-facebook"></i></a>
                                            <a href="#."><i class="icon-social-twitter"></i></a></div>
                                    </div>
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

                        <%
                            RichiestaPreventivo richiesta = (RichiestaPreventivo) session.getAttribute("richiesta");
                            if(richiesta.getStato().toString().equals("IN_ATTESA")){
                        %>

                        <c:choose>
                            <c:when test="${fornitore != null and fornitore.abbonato == true}">
                                <form action="CompilaPreventivoServlet" method="post" >
                                    <input type="hidden" name="idRichiesta" value="<c:out value="${richiesta.idRichiesta}"/>">
                                    <li class="col-xs-6"><input class="btn" type="submit" value="COMPILA PREVENTIVO">
                                    </li>
                                </form>
                            </c:when>
                        </c:choose>

                        <%}%>
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
