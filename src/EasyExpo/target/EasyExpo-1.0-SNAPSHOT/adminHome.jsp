<%--
  Created by IntelliJ IDEA.
  User: Davide Pappalardo
  Date: 09/01/2021
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- Wrap -->
<div id="wrap">
    <header>
        <jsp:include page="/header.jsp">
            <jsp:param name="pageTitle" value="Login"/>
        </jsp:include>
    </header>

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
    </div>
</div>
<!--======= FOOTER =========-->
<footer>
    <jsp:include page="/footer.jsp"/>
</footer>

</body>
</html>
