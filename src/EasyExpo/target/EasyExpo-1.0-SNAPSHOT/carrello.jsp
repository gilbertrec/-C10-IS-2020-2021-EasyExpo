<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.POJO.Prodotto" %><%--
  Created by IntelliJ IDEA.
  User: Katia Monaco De Simone
  Date: 05/01/2021
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<body>

<!-- header -->
<header>
    <jsp:include page="/header.jsp">
        <jsp:param name="pageTitle" value="Prodotto"/>
    </jsp:include>
</header>

<!-- LOADER -->
<div id="loader">
    <div class="position-center-center">
        <div class="ldr"></div>
    </div>
</div>

<!-- Wrap -->
<div id="wrap">

    <!--======= SUB BANNER =========-->
    <section class="sub-bnr" data-stellar-background-ratio="0.5">
        <div class="position-center-center">
            <div class="container">
                <h4>CARRELLO</h4>
                <p style="color: black">Visualizza qui tutti i prodotti e servizi nel tuo carrello e procedi ad inoltrare un preventivo
                ad ognuno dei fornitori da te selezionati.</p>

                <!--<ol class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">SHOP</a></li>
                    <li class="active">SHOPPING CART</li>
                </ol>-->

            </div>
        </div>
    </section>

    <!-- Content -->
    <div id="content">

        <!--======= PAGES INNER =========-->
        <section class="padding-top-100 padding-bottom-100 pages-in chart-page">
            <div class="container">

                <!-- Payments Steps -->
                <div class="shopping-cart text-center">
                    <div class="cart-head">
                        <ul class="row">
                            <!-- FORNITORE -->
                            <li class="col-sm-2 text-left">
                                <!-- <h6>FORNITORE</h6> -->


                            <c:forEach items="${carrello.getLista()}" var="ProdottiFornitori">
                                <c:forEach items="ProdottiFornitori" var="prodotto">
                                <h4><c:out value="${carrello.get(prodotto)}" /></h4>
                                </c:forEach>
                            </c:forEach>
                            </li>
                            <!--  -->
                            <li class="col-sm-4 text-left">
                                <h6>N</h6>
                            </li>
                            <!-- PRICE -->
                            <li class="col-sm-2">

                            </li>
                            <!-- QTY -->
                            <li class="col-sm-1">
                                <h6>QTY</h6>
                            </li>

                            <!-- TOTAL PRICE -->
                            <li class="col-sm-2">
                                <h6>TOTAL</h6>
                            </li>
                            <li class="col-sm-1"> </li>
                        </ul>
                    </div>

                    <!-- Cart Details -->
                    <ul class="row cart-details">
                        <li class="col-sm-6">
                            <div class="media">
                                <!-- Media Image -->
                                <div class="media-left media-middle"> <a href="#." class="item-img"> <img class="media-object" src="images/cart-img-1.jpg" alt=""> </a> </div>

                                <!-- Item Name -->
                                <div class="media-body">
                                    <div class="position-center-center">
                                        <h5>wood chair</h5>
                                        <p>Lorem ipsum dolor sit amet</p>
                                    </div>
                                </div>
                            </div>
                        </li>

                        <!-- PRICE -->
                        <li class="col-sm-2">
                            <div class="position-center-center"> <span class="price"><small>$</small>299</span> </div>
                        </li>

                        <!-- QTY -->
                        <li class="col-sm-1">
                            <div class="position-center-center">
                                <div class="quinty">
                                    <!-- QTY -->
                                    <select class="selectpicker">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                    </select>
                                </div>
                            </div>
                        </li>

                        <!-- TOTAL PRICE -->
                        <li class="col-sm-2">
                            <div class="position-center-center"> <span class="price"><small>$</small>299</span> </div>
                        </li>

                        <!-- REMOVE -->
                        <li class="col-sm-1">
                            <div class="position-center-center"> <a href="#."><i class="icon-close"></i></a> </div>
                        </li>
                    </ul>

                    <!-- Cart Details -->
                    <ul class="row cart-details">
                        <li class="col-sm-6">
                            <div class="media">
                                <!-- Media Image -->
                                <div class="media-left media-middle"> <a href="#." class="item-img"> <img class="media-object" src="images/cart-img-2.jpg" alt=""> </a> </div>

                                <!-- Item Name -->
                                <div class="media-body">
                                    <div class="position-center-center">
                                        <h5>STOOL</h5>
                                        <p>Lorem ipsum dolor sit amet</p>
                                    </div>
                                </div>
                            </div>
                        </li>

                        <!-- PRICE -->
                        <li class="col-sm-2">
                            <div class="position-center-center"> <span class="price"><small>$</small>299</span> </div>
                        </li>

                        <!-- QTY -->
                        <li class="col-sm-1">
                            <div class="position-center-center">
                                <div class="quinty">
                                    <!-- QTY -->
                                    <select class="selectpicker">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                    </select>
                                </div>
                            </div>
                        </li>

                        <!-- TOTAL PRICE -->
                        <li class="col-sm-2">
                            <div class="position-center-center"> <span class="price"><small>$</small>299</span> </div>
                        </li>

                        <!-- REMOVE -->
                        <li class="col-sm-1">
                            <div class="position-center-center"> <a href="#."><i class="icon-close"></i></a> </div>
                        </li>
                    </ul>

                    <!-- Cart Details -->
                    <ul class="row cart-details">
                        <li class="col-sm-6">
                            <div class="media">
                                <!-- Media Image -->
                                <div class="media-left media-middle"> <a href="#." class="item-img"> <img class="media-object" src="images/cart-img-3.jpg" alt=""> </a> </div>

                                <!-- Item Name -->
                                <div class="media-body">
                                    <div class="position-center-center">
                                        <h5>wood SPOON</h5>
                                        <p>Lorem ipsum dolor sit amet</p>
                                    </div>
                                </div>
                            </div>
                        </li>

                        <!-- PRICE -->
                        <li class="col-sm-2">
                            <div class="position-center-center"> <span class="price"><small>$</small>299</span> </div>
                        </li>

                        <!-- QTY -->
                        <li class="col-sm-1">
                            <div class="position-center-center">
                                <div class="quinty">
                                    <!-- QTY -->
                                    <select class="selectpicker">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                    </select>
                                </div>
                            </div>
                        </li>

                        <!-- TOTAL PRICE -->
                        <li class="col-sm-2">
                            <div class="position-center-center"> <span class="price"><small>$</small>299</span> </div>
                        </li>

                        <!-- REMOVE -->
                        <li class="col-sm-1">
                            <div class="position-center-center"> <a href="#."><i class="icon-close"></i></a> </div>
                        </li>
                    </ul>
                </div>
            </div>
        </section>

        <!--======= PAGES INNER =========-->
        <section class="padding-top-100 padding-bottom-100 light-gray-bg shopping-cart small-cart">
            <div class="container">

                <!-- SHOPPING INFORMATION -->
                <div class="cart-ship-info margin-top-0">
                    <div class="row">

                        <!-- PREVENTIVO -->
                        <div class="col-sm-7">
                            <h6>INVIA UN PREVENTIVO AD OGNI FORNITORE</h6>
                            <!-- <div class="coupn-btn"> <a href="#." class="btn">continue shopping</a> <a href="#." class="btn">update cart</a> </div> -->
                        </div>

                        <!-- SUB TOTAL -->
                        <div class="col-sm-5">
                            <h6>grand total</h6>
                            <div class="grand-total">
                                <div class="order-detail">
                                    <p>WOOD CHAIR <span>$598 </span></p>
                                    <p>STOOL <span>$199 </span></p>
                                    <p>WOOD SPOON <span> $139</span></p>

                                    <!-- SUB TOTAL -->
                                    <p class="all-total">TOTAL COST <span> $998</span></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>


    </div>


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
<script src="js/main.js"></script>


<!--======= FOOTER =========-->
<footer>
    <jsp:include page="/footer.jsp"/>
</footer>

</body>
</html>
