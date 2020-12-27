<%--
  Created by IntelliJ IDEA.
  User: lucreziarobustelli
  Date: 22/12/2020
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
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

    <!-- header -->
    <header>
        <jsp:include page="/WEB-INF/jsp/header.jsp">
            <jsp:param name="pageTitle" value="Chi Siamo"/>
        </jsp:include>
    </header>

    <!--======= SUB BANNER =========-->
    <section class="sub-bnr" data-stellar-background-ratio="0.5">
        <div class="position-center-center">
            <div class="container">
                <h4>AREA UTENTE</h4>
                <p>Di seguito sono riportati tutti i dati personali del cliente ${nomedelcliente}</p>
                <ol class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Pages</a></li>
                    <li class="active">REGISTER</li>
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
                                <h6>DATI PERSONALI</h6>
                                <form>
                                    <ul class="row">

                                        <!-- Nome -->
                                        <li class="col-md-6">
                                            <label> NOME
                                                <input type="text" name="first-name" value="" placeholder="">
                                            </label>
                                        </li>
                                        <!-- Cognome -->
                                        <li class="col-md-6">
                                            <label> COGNOME
                                                <input type="text" name="last-name" value="" placeholder="">
                                            </label>
                                        </li>

                                        <!-- Email -->
                                        <li class="col-md-6">
                                            <label> EMAIL
                                                <input type="text" name="contry-state" value="" placeholder="">
                                            </label>
                                        </li>

                                        <!-- Password -->
                                        <li class="col-md-6">
                                            <label> PASSWORD
                                                <input type="password" name="last-name" value="" placeholder="">
                                            </label>
                                        </li>

                                        <!-- CODICE FISCALE -->
                                        <li class="col-md-6">
                                        <label> CODICE FISCALE
                                            <input type="text" name="address" value="" placeholder="">
                                        </label>
                                        </li>

                                        <!-- Telefono -->
                                        <li class="col-md-6">
                                            <label> TELEFONO
                                                <input type="text" name="postal-code" value="" placeholder="">
                                            </label>
                                        </li>
                                        <li class="col-md-6">

                                            <!-- Luogo di Ubicazione -->
                                            <label> LUOGO DI UBICAZIONE
                                                <input type="text" name="address" value="" placeholder="">
                                            </label>
                                        </li>
                                        <li class="col-md-6">

                                        <!-- BOTTONE -->
                                        <li class="col-md-6">
                                            <button type="submit" class="btn">ELIMINA ACCOUNT</button>
                                        </li>
                                    </ul>
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

    </div>

    <!--======= FOOTER =========-->
    <footer>
        <jsp:include page="/WEB-INF/jsp/footer.jsp"/>
    </footer>
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

</body>
</html>