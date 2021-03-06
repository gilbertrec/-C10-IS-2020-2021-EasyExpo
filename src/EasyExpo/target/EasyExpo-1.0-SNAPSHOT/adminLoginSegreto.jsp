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
<head>
    <title>Login Admin</title>
</head>
<body>

<!--Controllo Sessione Admin -->
<%
    if(request.getSession().getAttribute("LeaderSupremo")!=null){
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/adminHome.jsp");
        requestDispatcher.forward(request,response);
    }
%>

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
                                <form action = "LoginAdminServlet" method="post">
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

                                        <!--Controllo Errore login -->
                                        <%
                                            if(request.getSession().getAttribute("Errore") != null){
                                                out.append("<p style=\"color:red;\">    Email e/o Password errati , si prega di riprovare</p> ");
                                                request.getSession().removeAttribute("Errore");
                                            }
                                        %>

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
