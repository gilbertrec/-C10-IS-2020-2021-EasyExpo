<%--
  Created by IntelliJ IDEA.
  User: Sabatino
  Date: 09/01/2021
  Time: 15:20
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
        <jsp:include page="/headeradmin.jsp">
            <jsp:param name="pageTitle" value="Login Admin"/>
        </jsp:include>
    </header>

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

                            <!-- Login Form -->
                            <div class="col-sm-7">
                                <h6>ACCEDI AL TUO ACCOUNT</h6>
                                <form action = "LoginServlet" method="post">
                                    <ul class="row">

                                        <!-- Email -->
                                        <li class="col-md-12">
                                            <label> EMAIL
                                                <input type="text" name="email" placeholder="">
                                            </label>
                                        </li>
                                        <!-- Password -->
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
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>
<!--======= FOOTER =========-->
<footer>
    <jsp:include page="/footeradmin.jsp"/>
</footer>

</body>
</html>
