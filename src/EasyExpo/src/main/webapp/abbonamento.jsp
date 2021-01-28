<%--
  Created by IntelliJ IDEA.
  User: lucreziarobustelli
  Date: 27/12/2020
  Time: 11:27
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
        <jsp:include page="/header.jsp">
            <jsp:param name="pageTitle" value="Area Abbonamento"/>
        </jsp:include>
    </header>


    <!--======= SUB BANNER =========-->
    <section class="sub-bnr" data-stellar-background-ratio="0.5">
        <div class="position-center-center">
            <div class="container">
                <h4>ABBONAMENTO</h4>
                <ol class="breadcrumb">
                    <li><a href="areaFornitore.jsp">Area Personale</a></li>
                    <li class="active">Abbonamento</li>
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
                                <h6>Inserisci metodo di pagamento</h6>
                                <form action="SottoscrizioneAbbonamentoServlet" method="post">
                                    <input type="hidden" name="partitaIva" value="${fornitore.partitaIva}">
                                    <ul class="row">

                                        <!-- NUMERO CARTA -->
                                        <li class="col-md-6">
                                            <label> NUMERO CARTA
                                                <input type="text" name="numeroCarta" value="" placeholder="" required>
                                            </label>
                                        </li>

                                        <!-- NOME INTESTATARIO -->
                                        <li class="col-md-6">
                                            <label> NOME INTESTATARIO
                                                <input type="text" name="nomeIntestatario" value="" placeholder="" required pattern="[A-Z a-z]{1,80}" title="Stringa di massimo 50 caratteri">
                                            </label>
                                        </li>

                                        <!-- DATA SCADENZA -->
                                        <li class="col-md-6">
                                            <label> DATA SCADENZA
                                                <input type="date" name="dataScadenza" value="" placeholder="" required>
                                            </label>
                                        </li>

                                        <!-- CVV -->
                                        <li class="col-md-6">
                                            <label> CVV
                                                <input type="number" name="cvv" value="" placeholder="" min="100"
                                                       max="999" required>
                                            </label>
                                        </li>

                                    </ul>
                                    <!-- PHONE -->
                                    <li class="col-md-6">
                                        <button type="submit" class="btn">ABBONA</button>
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