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
            <jsp:param name="pageTitle" value="RegistrazioneFornitore"/>
        </jsp:include>
    </header>

    <!--======= SUB BANNER =========-->
    <section class="sub-bnr" data-stellar-background-ratio="0.5">
        <div class="position-center-center">
            <div class="container">
                <h4>EASYEXPO</h4>
                <ol class="breadcrumb">
                    <li class="active">REGISTRAZIONE</li>
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
                                <h6>REGISTRATI</h6>
                                <form action="RegistrazioneFornitore">
                                    <ul class="row">

                                        <!-- NOME -->
                                        <li class="col-md-6">
                                            <label> NOME
                                                <input type="text" name="nome" value="" placeholder="">
                                            </label>
                                        </li>
                                        <!-- COGNOME -->
                                        <li class="col-md-6">
                                            <label> COGNOME
                                                <input type="text" name="cognome" value="" placeholder="">
                                            </label>
                                        </li>

                                        <!-- EMAIL -->
                                        <li class="col-md-6">
                                            <label> EMAIL
                                                <input type="text" name="email" value="" placeholder="">
                                            </label>
                                        </li>

                                        <!-- PASSWORD -->
                                        <li class="col-md-6">
                                            <label> PASSWORD
                                                <input type="password" name="password" value="" placeholder="">
                                            </label>
                                        </li>

                                        <!-- PASSWORD -->
                                        <li class="col-md-6">
                                            <label> CONFERMA PASSWORD
                                                <input type="password" name="passwordConferma" value="" placeholder="">
                                            </label>
                                        </li>

                                        <!-- PHONE -->
                                        <li class="col-md-6">
                                            <label> NUMERO DI TELEFONO
                                                <input type="text" name="telefono" value="" placeholder="">
                                            </label>
                                        </li>

                                        <!-- LUOGO DI UBICAZIONE -->
                                        <li class="col-md-6">
                                            <label> LUOGO DI UBICAZIONE
                                                <input type="text" name="luogoUbicazione" value="" placeholder="">
                                            </label>
                                        </li>

                                        <li class="col-md-6">
                                            <!-- PARTITA IVA -->
                                            <label> PARTITA IVA
                                                <input type="text" name="partitaIva" value="" placeholder="">
                                            </label>
                                        </li>

                                        <li class="col-md-6">
                                            <!-- RAGIONE SOCIALE -->
                                            <label> RAGIONE SOCIALE
                                                <input type="text" name="ragioneSociale" value="" placeholder="">
                                            </label>
                                        </li>

                                    </ul>
                                    <!-- PHONE -->
                                    <li class="col-md-6">
                                        <button type="submit" class="btn">REGISTRAMI</button>
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
