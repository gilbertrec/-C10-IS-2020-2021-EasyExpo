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

    <!-- header -->
    <jsp:include page="/header.jsp">
        <jsp:param name="pageTitle" value="Rinnovo Abbonamento"/>
    </jsp:include>


    <!--======= SUB BANNER =========-->
    <section class="sub-bnr" data-stellar-background-ratio="0.5">
        <div class="position-center-center">
            <div class="container">
                <h4>ABBONAMENTO</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec faucibus maximus vehicula.
                    Sed feugiat, tellus vel tristique posuere, diam</p>
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
                                <form action="RinnovoAbbonamentoServlet" method="post">
                                    <input type="hidden" name="partitaIva" value="${fornitore.partitaIva}">
                                    <ul class="row">

                                        <!-- CARTE INSERITE -->
                                        <li class="col-md-6">

                                            <label> CARTE
                                                <div class="quinty">
                                                    <select class="selectpicker" name="tipo">
                                                        <c:forEach items="${metodi}" var="pr">
                                                            <option><c:out value="${pr.numeroCarta}"/></option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </label>

                                        </li>
                                    </ul>

                                    <li class="col-md-6" style="width: 20%">
                                        <form>
                                            <button type="submit" class="btn">RINNOVA</button>
                                        </form>
                                    </li>

                                    <!-- PHONE -->
                                    <li class="col-md-6">
                                        <form action="abbonamento.jsp">
                                            <button type="submit" class="btn">NUOVO METODO</button>
                                        </form>
                                    </li>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

    </div>

    <footer>
        <jsp:include page="/footer.jsp"/>
    </footer>

</div>

</body>
</html>