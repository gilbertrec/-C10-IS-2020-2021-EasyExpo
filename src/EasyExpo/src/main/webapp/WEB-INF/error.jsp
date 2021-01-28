<%--
  Created by IntelliJ IDEA.
  User: lucreziarobustelli
  Date: 22/12/2020
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title> ERROR ${requestScope['javax.servlet.error.status_code']} </title>
</head>
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


    <!-- Content -->
    <div id="content">

        <!--======= PAGES INNER =========-->
        <section class="chart-page padding-top-100 padding-bottom-100">
            <div class="container">

                <!-- Payments Steps -->
                <div class="shopping-cart">

                    <!-- SHOPPING INFORMATION -->
                    <div class="cart-ship-info">

                        <h4>ERROR ${requestScope['javax.servlet.error.status_code']}</h4>
                        <pre>
                            <%
                            if (exception != null) {
                                out.flush();%>

                            <h2> C'è stato un problema, si prega di riprovare. </h2>

                            <%}
                        %></pre>


                    </div>
                </div>
            </div>
        </section>

    </div>
</div>


</body>
</html>