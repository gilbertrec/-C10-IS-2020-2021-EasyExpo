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
            <jsp:param name="pageTitle" value="RegistrazioneCliente"/>
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
                                <form action="RegistrazioneCliente">
                                    <ul class="row">

                                        <!-- NOME -->
                                        <li class="col-md-6">
                                            <label> NOME
                                                <input type="text" name="nome" value="" placeholder="" required pattern="[A-Z a-z]{1,30}" title="Lunghezza minore di 30">
                                            </label>
                                        </li>
                                        <!-- COGNOME -->
                                        <li class="col-md-6">
                                            <label> COGNOME
                                                <input type="text" name="cognome" value="" placeholder="" required pattern="[A-Z a-z]{1,30}" title="Lunghezza minore di 30">
                                            </label>
                                        </li>

                                        <!-- EMAIL -->
                                        <li class="col-md-6">
                                            <label> EMAIL
                                                <input type="email" name="email" value="" placeholder="" required pattern="[a-z A-Z 0-9 ._]{8,50}@[a-z A-Z 0-9.]{4,50}.([a-z A-Z]{2,5})" title="Deve contenere la @ e il dominio (es. .com)">
                                            </label>
                                        </li>

                                        <!-- PASSWORD -->
                                        <li class="col-md-6">
                                            <label> PASSWORD
                                                <input type="password" name="password" value="" placeholder="" required pattern="[0-9 a-z A-Z.!#$%&'+\\=?^_`{|}~-]{8,512}" title="Deve contenere almeno 8 caratteri, una maiuscola, una minuscola e un carattere speciale (es. .!#$%&'+\\=?^_`{|}~-])">
                                            </label>
                                        </li>

                                        <!-- PASSWORD -->
                                        <li class="col-md-6">
                                            <label> CONFERMA PASSWORD
                                                <input type="password" name="passwordConferma" value="" placeholder="" required>
                                            </label>
                                        </li>

                                        <!-- PHONE -->
                                        <li class="col-md-6">
                                            <label> NUMERO DI TELEFONO
                                                <input type="tel" name="telefono" value="" placeholder="" required pattern="[0-9]{10}" title="Deve essere di 10 caratteri, tutti numerici">
                                            </label>
                                        </li>

                                        <!-- LUOGO DI UBICAZIONE -->
                                        <li class="col-md-6">
                                            <label> LUOGO DI UBICAZIONE
                                                <input type="text" name="luogoUbicazione" value="" placeholder="" required pattern="[a-z A-Z]{1,30}" title="Lunghezza minore di 30">
                                            </label>
                                        </li>

                                        <li class="col-md-6">
                                            <!-- CODICE FISCALE -->
                                            <label> CODICE FISCALE
                                                <input type="text" name="codiceFiscale" value="" placeholder="" required pattern="[A-Z 0-9]{16}" title="Deve essere di 16 caratteri alfanumerici, tutti maiuscoli">
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

