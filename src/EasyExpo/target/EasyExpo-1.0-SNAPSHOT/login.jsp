<%--
  Created by IntelliJ IDEA.
  User: lucreziarobustelli
  Date: 22/12/2020
  Time: 21:38
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

    <header>
        <jsp:include page="/header.jsp">
            <jsp:param name="pageTitle" value="Login"/>
        </jsp:include>
    </header>

    <!--======= SUB BANNER =========-->
    <section class="sub-bnr" data-stellar-background-ratio="0.5">
        <div class="position-center-center">
            <div class="container">
                <img class="easy" src="images/scritta-sola.png" width="500" height="300">
                <!--<h1 style="font-weight: 1000; color: #0f3e68"> <span class="scritta" style="color: #ffe115; background: #0f3e68; padding: 1px 6px;">EASY</span>EXPO</h1>-->
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
                    <div class="cart-ship-info">
                        <div class="row">

                            <!-- ESTIMATE SHIPPING & TAX -->
                            <div class="col-sm-7">
                                <h6>ACCEDI AL TUO ACCOUNT</h6>
                                <form action="LoginServlet" method="post">
                                    <ul class="row">

                                        <!-- Name -->

                                        <li class="col-md-12">
                                            <label> EMAIL
                                                <input type="text" name="email" placeholder="">
                                            </label>
                                        </li>
                                        <!-- LAST NAME -->
                                        <li class="col-md-12">
                                            <label> PASSWORD
                                                <input type="password" name="password" placeholder="">
                                            </label>
                                        </li>

                                        <!-- LOGIN -->
                                        <li class="col-md-4">
                                            <button type="submit" class="btn">LOGIN</button>
                                        </li>
                                    </ul>
                                </form>

                            </div>
                            <!-- SUB TOTAL -->
                            <div class="col-sm-5">
                                <h6 style="margin-bottom: 80px">REGISTRATI COME...</h6>

                                <ul class="login-with">
                                    <li>
                                        <a href="registrazioneCliente.jsp" style="background: #2d3a4b; color: white">CLIENTE</a>

                                    </li>

                                    <li>
                                        <a href="registrazioneFornitore.jsp"
                                           style="margin-top: 15px; background: #2d3a4b; color: white">FORNITORE</a>

                                    </li>
                                </ul>
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
</div>
<!--======= FOOTER =========-->
<footer>
    <jsp:include page="/footer.jsp"/>
</footer>

</body>
</html>