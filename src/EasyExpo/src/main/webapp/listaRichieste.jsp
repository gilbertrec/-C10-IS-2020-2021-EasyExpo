<%@ page import="Model.POJO.RichiestaPreventivo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.POJO.Cliente" %><%--
  Created by IntelliJ IDEA.
  User: lucreziarobustelli
  Date: 05/01/2021
  Time: 14:33
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
            <jsp:param name="pageTitle" value="Lista Richieste"/>
        </jsp:include>
    </header>

    <!--======= SUB BANNER =========-->
    <section class="sub-bnr" data-stellar-background-ratio="0.5">
        <div class="position-center-center">
            <div class="container">
                <h4>RICHIESTE DI PREVENTIVO</h4>
            </div>
        </div>
    </section>

    <!-- Content -->
    <div id="content">

        <!-- Quotation List -->
        <section class="blog-list blog-list-3 padding-top-100 padding-bottom-100">
            <div class="container">
                <div class="row" style="margin-left: 110px; margin-right: -110px">
                    <div class="col-md-9">

                        <%
                            ArrayList<RichiestaPreventivo> richieste =
                                    (ArrayList<RichiestaPreventivo>) session.getAttribute("richieste");
                            ArrayList<Cliente> clienti = (ArrayList<Cliente>) session.getAttribute("clienti");

                            for (int i = 0; i < richieste.size(); i++) {
                        %>
                        <article>
                            <div class="row" style="margin-left: 100px; margin-right: -450px">
                                <div class="col-sm-7">
                                    <!-- Tittle -->
                                    <div class="post-tittle left"><a href="#." class="tittle"><%=richieste.get(i)
                                            .getTitolo()%>
                                    </a>
                                        <!-- Post Info -->
                                        <span><i class="primary-color icon-user"></i> by <%=clienti.get(i)
                                                .getNome()%> <%=clienti.get(i).getCognome()%></span> <span><i
                                                class="primary-color icon-calendar"></i> <%=richieste.get(i)
                                                .getDataRichiesta()%> </span> <span><%=richieste.get(i)
                                                .getStato().toString()%></span></div>
                                    <!-- Post Content -->
                                    <div class="text-left">
                                        <p><%=richieste.get(i).getDescrizioneEvento()%>
                                        </p>
                                        <a href="SpecificaServlet?idRichiesta=<%=richieste.get(i).getIdRichiesta()%>"
                                           class="red-more">READ MORE</a>
                                        <c:choose>
                                            <c:when test="${fornitore != null and fornitore.abbonato == true}">
                                                <a href="DeclineServlet?idRichiesta=<%=richieste.get(i).getIdRichiesta()%>"
                                                   class="red-more" style="margin-left: 320px">DECLINE</a>
                                            </c:when>
                                        </c:choose>
                                    </div>
                                </div>
                            </div>
                        </article>
                        <%}%>
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