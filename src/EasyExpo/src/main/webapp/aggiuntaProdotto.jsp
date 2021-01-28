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
            <jsp:param name="pageTitle" value="Aggiunta Prodotto"/>
        </jsp:include>
    </header>


    <!--======= SUB BANNER =========-->
    <section class="sub-bnr" data-stellar-background-ratio="0.5">
        <div class="position-center-center">
            <div class="container">
                <h4>AGGIUNTA PRODOTTO</h4>
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
                                                <input type="text" name="titolo" value="" placeholder="" required
                                                       pattern="[A-Z a-z 0-9]{1,30}"
                                                       title="Deve essere stringa alfanumerica con lunghezza minore di 30">
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
                                            </label>
                                        </li>

                                        <!-- PREZZO -->
                                        <li class="col-md-6">
                                            <label> PREZZO
                                                <input type="text" name="prezzo" value="" placeholder="" required
                                                       pattern="[0-9]{1,5}.[0-9]{2}"
                                                       title="Deve contenere un numero decimale con due cifre dopo il punto e massimo 5 cifre prima">
                                            </label>
                                        </li>

                                        <!-- QUANTITÀ -->
                                        <li class="col-md-6">
                                            <label> QUANTITÀ (1-999)
                                                <input type="number" name="quantita" value="" placeholder="" min="1"
                                                       max="999" required>
                                            </label>
                                        </li>

                                        <!-- DESCRIZIONE -->
                                        <li class="col-md-6">
                                            <label> DESCRIZIONE
                                                <textarea name="descrizione" rows="5" cols="80" required></textarea>
                                            </label>
                                        </li>

                                        <li class="col-md-6">
                                            <label> FOTO
                                                <input type="file" name="foto" accept=".jpg, .png, .jpeg, .gif"
                                                       placeholder="">
                                            </label>
                                        </li>
                                        <!-- TAG -->
                                        <li class="col-md-6">
                                            <label> INSERISCI TAG
                                                <input type="text" name="tag" value=""
                                                       placeholder="Tag1, Tag2, Tag3, Tag4, Tag5, ..." pattern="([A-Z a-z]{0,30},)*" title="Inserire tag separati da una virgola e virgola finale.">
                                            </label>
                                        </li>

                                    </ul>
                                    <!-- BUTTON -->
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