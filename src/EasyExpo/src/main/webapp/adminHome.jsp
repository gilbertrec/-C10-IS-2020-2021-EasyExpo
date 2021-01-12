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
            <jsp:param name="pageTitle" value="Gestione Admin"/>
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
                                <h6>GESTIONE ADMIN</h6>
                                <form>
                                    <ul class="row">

                                        <!-- Gestione fornitori -->
                                        <li class="col-md-6">
                                            <button type="submit" class="btn" formaction="/gestioneFornitori.jsp">Lista Fornitori</button>
                                        </li>
                                        <!-- Gestione Clienti -->
                                        <li class="col-md-6">
                                            <button type="submit" class="btn" formaction="/gestioneclienti.jsp">Lista Clienti</button>
                                        </li>
                                    </ul>
                                    <ul class="row">
                                        <!-- Gestione fornitori sospesi -->
                                        <li class="col-md-6">
                                            <button type="submit" class="btn" formaction="/fornitoriSospesi.jsp">Lista Fornitori sospesi</button>
                                        </li>

                                        <!-- Gestione Clienti sospesi -->
                                        <li class="col-md-6">
                                            <button type="submit" class="btn" formaction="/clientiSospesi.jsp">Lista Fornitori sospesi</button>
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
