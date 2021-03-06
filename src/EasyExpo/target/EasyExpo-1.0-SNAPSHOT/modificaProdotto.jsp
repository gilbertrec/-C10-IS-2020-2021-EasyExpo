<%--
  Created by IntelliJ IDEA.
  User: lucreziarobustelli
  Date: 27/12/2020
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <jsp:param name="pageTitle" value="Modifica Prodotto"/>
        </jsp:include>
    </header>


    <!--======= SUB BANNER =========-->
    <section class="sub-bnr" data-stellar-background-ratio="0.5">
        <div class="position-center-center">
            <div class="container">
                <h4>MODIFICA PRODOTTO</h4>
                <ol class="breadcrumb">
                    <li><a href="areaFornitore.jsp">Area Personale</a></li>
                    <li><a href="#">${prodotto.titolo}</a></li>
                    <li class="active">Modifica Prodotto</li>
                </ol>
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
                                <h6>MODIFICA PRODOTTO</h6>
                                <form action="ModificaServlet" method="post" enctype="multipart/form-data">
                                    <input type="hidden" name="partitaIva" value="${prodotto.partitaIva}">
                                    <input type="hidden" name="idProdotto" value="${prodotto.idProdotto}">
                                    <ul class="row">

                                        <!-- TITOLO -->
                                        <li class="col-md-6">
                                            <label> TITOLO
                                                <input type="text" name="titolo" value="${prodotto.titolo}"
                                                       placeholder="" required pattern="[A-Z a-z 0-9]{1,30}" title="Deve essere stringa alfanumerica con lunghezza minore di 30">
                                            </label>
                                        </li>

                                        <!-- TIPO -->
                                        <li class="col-md-6">
                                            <label> TIPO
                                                <div class="quinty">
                                                    <select class="selectpicker" name="tipo">
                                                        <option>${prodotto.tipo}</option>
                                                        <c:choose>
                                                            <c:when test="${prodotto.tipo == 'ATTREZZATURA'}">
                                                                <option>SERVIZIO</option>
                                                            </c:when>
                                                            <c:when test="${prodotto.tipo == 'SERVIZIO'}">
                                                                <option>ATTREZZATURA</option>
                                                            </c:when>
                                                        </c:choose>
                                                    </select>
                                                </div>
                                            </label>
                                        </li>

                                        <!-- PREZZO -->
                                        <li class="col-md-6">
                                            <label> PREZZO
                                                <input type="text" name="prezzo" value="${prodotto.prezzo}"
                                                       placeholder="" required pattern="[0-9]{1,5}.[0-9]{2}" title="Deve contenere un numero decimale con due cifre dopo il punto e massimo 5 cifre prima">
                                            </label>
                                        </li>

                                        <!-- QUANTITÀ -->
                                        <li class="col-md-6">
                                            <label> QUANTITÀ (1-999)
                                                <input type="number" name="quantita" value="${prodotto.quantità}"
                                                       placeholder="" min="1" max="999" required>
                                            </label>
                                        </li>

                                        <!-- DESCRIZIONE -->
                                        <li class="col-md-6">
                                            <label> DESCRIZIONE
                                                <textarea name="descrizione" rows="5"
                                                          cols="80" required>${prodotto.descrizione}</textarea>
                                            </label>
                                        </li>

                                        <li class="col-md-6">
                                            <label> FOTO
                                                <input type="file" name="foto" accept=".jpg, .png, .jpeg, .gif"
                                                       placeholder="" required title="Immagine non inserita">
                                            </label>
                                        </li>

                                    </ul>
                                    <!-- PHONE -->
                                    <li class="col-md-6">
                                        <button type="submit" class="btn">MODIFICA PRODOTTO</button>
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


    <!--======= RIGHTS =========-->

</div>
</body>
</html>