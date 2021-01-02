<%--
  Created by IntelliJ IDEA.
  User: lucreziarobustelli
  Date: 27/12/2020
  Time: 11:27
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
            <jsp:param name="pageTitle" value="Modifica Prodotto"/>
        </jsp:include>
    </header>


    <!--======= SUB BANNER =========-->
    <section class="sub-bnr" data-stellar-background-ratio="0.5">
        <div class="position-center-center">
            <div class="container">
                <h4>MODIFICA PRODOTTO</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec faucibus maximus vehicula.
                    Sed feugiat, tellus vel tristique posuere, diam</p>
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
                                <form>
                                    <ul class="row">

                                        <!-- TITOLO -->
                                        <li class="col-md-6">
                                            <label> TITOLO
                                                <input type="text" name="titolo" value="${prodotto.titolo}"
                                                       placeholder="">
                                            </label>
                                        </li>

                                        <!-- TIPO -->
                                        <li class="col-md-6">
                                            <label> TIPO
                                                <div class="quinty">
                                                    <select class="selectpicker">
                                                        <option>${prodotto.tipo}</option>
                                                        <option>ATTREZZATURA</option>
                                                        <option>SERVIZIO</option>
                                                    </select>
                                                </div>
                                            </label>
                                        </li>

                                        <!-- PREZZO -->
                                        <li class="col-md-6">
                                            <label> PREZZO
                                                <input type="text" name="prezzo" value="${prodotto.prezzo}"
                                                       placeholder="">
                                            </label>
                                        </li>

                                        <!-- QUANTITÀ -->
                                        <li class="col-md-6">
                                            <label> QUANTITÀ (1-999)
                                                <input type="number" name="quantita" value="${prodotto.quantità}"
                                                       placeholder="" min="1" max="999">
                                            </label>
                                        </li>

                                        <!-- DESCRIZIONE -->
                                        <li class="col-md-6">
                                            <label> DESCRIZIONE
                                                <textarea type="textArea" name="descrizione"
                                                          value="${prodotto.descrizione}" placeholder=""
                                                          style="height: 150px; width: 550px">

                                                </textarea>
                                            </label>
                                        </li>

                                        <li class="col-md-6">
                                            <label> FOTO
                                                <input type="file" name="foto" accept=".jpg, .png, .jpeg, .gif"
                                                       placeholder="" multiple>
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
        <div class="container">

            <!-- ABOUT Location -->
            <div class="col-md-3">
                <div class="about-footer"><img class="margin-bottom-30" src="images/logomacchia.png" alt="">
                    <p><i class="icon-pointer"></i> Via Giovanni Paolo II, 132 . <br>
                        - 84084 Fisciano (SA)</p>
                    <p><i class="icon-call-end"></i> 081 564738</p>
                    <p><i class="icon-envelope"></i> info@EASYEXPO.com</p>
                </div>
            </div>


            <!-- INFO -->
            <div class="col-md-3">
                <h6>INFO</h6>
                <ul class="link">
                    <li><a href="chiSiamo.jsp"> Chi Siamo</a></li>
                    <li><a href="contatti.jsp"> Contatti</a></li>
                </ul>
            </div>

            <!-- MY ACCOUNT -->
            <div class="col-md-3">
                <h6>ACCOUNT FORNITORE</h6>
                <ul class="link">
                    <li><a href="areaFornitore.jsp"> Area Fornitore</a></li>
                    <li><a href="areaFornitore.jsp"> Catalogo</a></li>
                    <li><a href="#."> Abbonamento</a></li>
                </ul>
            </div>

            <!-- Rights -->

            <div class="rights">
                <p>© 2020 EASYEXPO Tutti i diritti riservati. </p>
                <div class="scroll"><a href="#wrap" class="go-up"><i class="lnr lnr-arrow-up"></i></a></div>
            </div>
        </div>
    </footer>


    <!--======= RIGHTS =========-->

</div>
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/own-menu.js"></script>
<script src="js/jquery.lighter.js"></script>
<script src="js/owl.carousel.min.js"></script>

<!-- SLIDER REVOLUTION 4.x SCRIPTS  -->
<script type="text/javascript" src="rs-plugin/js/jquery.tp.t.min.js"></script>
<script type="text/javascript" src="rs-plugin/js/jquery.tp.min.js"></script>
<script src="js/main.js"></script>
<script src="js/main.js"></script>
</body>
</html>