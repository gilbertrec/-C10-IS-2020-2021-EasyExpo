<%@ page import="Model.POJO.RichiestaPreventivo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.POJO.Preventivo" %><%--
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
            <jsp:param name="pageTitle" value="Lista Preventivi"/>
        </jsp:include>
    </header>

    <!--======= SUB BANNER =========-->
    <section class="sub-bnr" data-stellar-background-ratio="0.5">
        <div class="position-center-center">
            <div class="container">
                <h4>PREVENTIVI</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec faucibus maximus vehicula.
                    Sed feugiat, tellus vel tristique posuere, diam</p>
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
                            ArrayList<RichiestaPreventivo> richieste = (ArrayList<RichiestaPreventivo>) session.getAttribute("richieste");
                            ArrayList<Preventivo> preventivi = (ArrayList<Preventivo>) session.getAttribute("preventivi");

                            for(int i = 0; i < preventivi.size(); i++){
                        %>

                        <article>
                            <div class="row" style="margin-left: 100px; margin-right: -450px">
                                <div class="col-sm-7">
                                    <!-- Tittle -->
                                    <div class="post-tittle left"> <a href="#." class="tittle">PREVENTIVO <%=richieste.get(i).getTitolo()%></a>
                                        <!-- Post Info -->
                                        <span><i class="primary-color icon-user"></i> by admin</span> <span><i class="primary-color icon-calendar"></i><%=preventivi.get(i).getDataPreventivo()%></span> <span><i class="primary-color icon-tag"></i> Furniture</span> </div>
                                    <!-- Post Content -->
                                    <div class="text-left">
                                        <p><%=richieste.get(i).getDescrizioneEvento()%></p>
                                        <a href="SpecificaServlet?idRichiesta=<%=preventivi.get(i).getIdPreventivo()%>" class="red-more">READ MORE</a> </div>
                                </div>
                            </div>
                        </article>


                        </li>
                        <%}%>

                        <!-- Pagination -->
                        <ul class="pagination in-center">
                            <li><a href="#"><i class="fa fa-angle-left"></i></a></li>
                            <li class="active"><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#"><i class="fa fa-angle-right"></i></a></li>
                        </ul>
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