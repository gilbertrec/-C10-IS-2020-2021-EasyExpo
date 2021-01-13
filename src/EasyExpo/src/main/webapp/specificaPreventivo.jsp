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
                            <div class="post-tittle left"> <a href="#." class="tittle">PREVENTIVO ${richiesta.titolo}</a>
                                <!-- Post Info -->
                                <span><i class="primary-color icon-user"></i> by admin</span> <span><i class="primary-color icon-calendar"></i> ${richiesta.dataRichiesta}</span> <span><i class="primary-color icon-tag"></i> Furniture</span> </div>
                            <!-- Post Content  creare il metodo che ti restituisce anche l'altra tabella per i prodotti-->
                            <div class="text-left">
                                <h6 class="margin-top-80 margin-bottom-30">Descrizione Evento</h6>
                                <p> ${richiesta.descrizioneEvento}</p>
                                <h6 class="margin-top-80 margin-bottom-30">Nota del fornitore</h6>
                                <blockquote>${preventivo.nota}</blockquote>

                                <!-- Fornitore/cliente info da fare il choose a seconda di chi lo apre -->
                                <div class="admin-info">
                                    <div class="media-left">
                                        <div class="admin-pic"> <img src="images/admin-avatar.jpg" alt=""> </div>
                                    </div>
                                    <div class="media-body">
                                        <h6>${clifor.nome} ${clifor.cognome} <span>Cliente</span></h6>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. NullamMorbi ac scelerisque mauris. Etiam sodales a nulla ornare viverra. Nunc at blandit neque, bociis natoque penatcing e scelerisque miscing elit. </p>
                                        <div class="admin-social"> <a href="#."><i class="icon-social-facebook"></i></a> <a href="#."><i class="icon-social-twitter"></i></a> <a href="#."><i class="icon-social-dribbble"></i></a> <a href="#."><i class="icon-envelope"></i></a> </div>
                                    </div>
                                </div>
                            </div>
                        </article>


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
