<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<!--======= FOOTER =========-->
<div class="container">

    <!-- ABOUT Location -->
    <div class="col-md-3">
        <div class="about-footer"><img class="margin-bottom-30" src="images/logomacchia.png" alt="">
            <p><i class="icon-pointer"></i> Via Giovanni Paolo II, 132 . <br>
                - 84084 Fisciano (SA)</p>
            <p><i class="icon-call-end"></i> 081 564738</p>
            <p><i class="icon-envelope"></i> info@EASYEXPO.com</p>
        </div>
    </div>


    <!-- INFO -->
    <div class="col-md-3">
        <h6>INFO</h6>
        <ul class="link">
            <li><a href="chiSiamo.jsp"> Chi Siamo</a></li>
            <li><a href="contatti.jsp"> Contatti</a></li>
        </ul>
    </div>

    <!-- MY ACCOUNT -->
    <div class="col-md-3">
        <c:choose>
            <c:when test="${cliente != null}">
                <h6>ACCOUNT CLIENTE</h6>
                <ul class="link">
                    <li><a href="areaCliente.jsp"> Area Cliente</a></li>
                </ul>
            </c:when>
            <c:when test="${fornitore != null}">
                <h6>ACCOUNT FORNITORE</h6>
                <ul class="link">
                    <li><a href="areaFornitore.jsp.jsp"> Area Fornitore</a></li>
                </ul>
            </c:when>
            <c:otherwise>
                <h6>NUOVO UTENTE</h6>
                <ul class="link">
                    <li><a href="login.jsp"> Login</a></li>
                    <li><a href="registrazioneCliente.jsp"> Registrazione Cliente</a></li>
                    <li><a href="registrazioneFornitore.jsp"> Registrazione Fornitore</a></li>
                </ul>
            </c:otherwise>
        </c:choose>
    </div>

    <!-- Rights -->

    <div class="rights">
        <p>© 2020 EASYEXPO Tutti i diritti riservati. </p>
        <div class="scroll"><a href="#wrap" class="go-up"><i class="lnr lnr-arrow-up"></i></a></div>
    </div>
</div>

</body>
</html>
