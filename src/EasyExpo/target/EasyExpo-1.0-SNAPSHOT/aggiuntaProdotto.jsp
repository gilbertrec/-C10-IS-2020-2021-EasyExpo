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
    <jsp:include page="/header.jsp">
        <jsp:param name="pageTitle" value="Aggiunta Prodotto"/>
    </jsp:include>


    <!--======= SUB BANNER =========-->
    <section class="sub-bnr" data-stellar-background-ratio="0.5">
        <div class="position-center-center">
            <div class="container">
                <h4>AGGIUNTA PRODOTTO</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec faucibus maximus vehicula.
                    Sed feugiat, tellus vel tristique posuere, diam</p>
                <ol class="breadcrumb">
                    <li><a href="areaFornitore.jsp">Area Personale</a></li>
                    <li class="active">Aggiunta Prodotto</li>
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
                                <h6>AGGIUNGI PRODOTTO</h6>
                                <form action="AggiungiProdottoServlet" method="post" enctype="multipart/form-data">
                                    <input type="hidden" name="partitaIva" value="${fornitore.partitaIva}">
                                    <ul class="row">

                                        <!-- TITOLO -->
                                        <li class="col-md-6">
                                            <label> TITOLO
                                                <input type="text" name="titolo" value="" placeholder="">
                                            </label>
                                        </li>

                                        <!-- TIPO -->
                                        <li class="col-md-6">
                                            <label> TIPO
                                                <div class="quinty">
                                                    <select class="selectpicker" name="tipo">
                                                        <option>ATTREZZATURA</option>
                                                        <option>SERVIZIO</option>
                                                    </select>
                                                </div>
                                                <!--<input type="text" name="tipo" value="" placeholder="">-->
                                            </label>
                                        </li>

                                        <!-- PREZZO -->
                                        <li class="col-md-6">
                                            <label> PREZZO
                                                <input type="text" name="prezzo" value="" placeholder="">
                                            </label>
                                        </li>

                                        <!-- QUANTITÀ -->
                                        <li class="col-md-6">
                                            <label> QUANTITÀ (1-999)
                                                <input type="number" name="quantita" value="" placeholder="" min="1"
                                                       max="999">
                                            </label>
                                        </li>

                                        <!-- DESCRIZIONE -->
                                        <li class="col-md-6">
                                            <label> DESCRIZIONE
                                                <textarea name="descrizione" rows="5" cols="80"></textarea>
                                            </label>
                                        </li>

                                        <li class="col-md-6">
                                            <label> FOTO
                                                <input type="file" name="foto" accept=".jpg, .png, .jpeg, .gif" placeholder="">
                                            </label>
                                        </li>

                                    </ul>
                                    <!-- PHONE -->
                                    <li class="col-md-6">
                                        <button type="submit" class="btn">AGGIUNGI PRODOTTO</button>
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