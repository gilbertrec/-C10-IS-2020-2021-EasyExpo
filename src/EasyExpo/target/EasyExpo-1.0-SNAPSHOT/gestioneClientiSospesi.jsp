<%@ page import="Controller.HttpServlet" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.POJO.Cliente" %><%--
  Created by IntelliJ IDEA.
  User: Sabatino
  Date: 12/01/2021
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="js/Notifiche.js"></script>
    <title>Gestione Clienti Sospesi</title>
</head>
<body>
<div id="wrap">
    <header>
        <jsp:include page="/headeradmin.jsp">
            <jsp:param name="pageTitle" value="Gestione Clienti Sospesi"/>
        </jsp:include>
    </header>
    <%
        if(request.getSession().getAttribute("LeaderSupremo")==null){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/adminLoginSegreto.jsp");
            requestDispatcher.forward(request,response);
        }
        if(request.getSession().getAttribute("clienti") == null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ListaClientiSospesiServlet");
            requestDispatcher.forward(request,response);
        }
        String url;
    %>
    <% List<Cliente> clienti = (List<Cliente>) request.getSession().getAttribute("clienti");%>
    <div id="content">
        <section class="chart-page padding-top-100 padding-bottom-100">
            <div class="container">
                <!-- Payments Steps -->
                <div class="shopping-cart">
                    <!-- SHOPPING INFORMATION -->
                    <div class="cart-ship-info register">
                        <h6>GESTIONE CLIENTI SOSPESI</h6>
                        <table class="table">
                            <tr class="row">
                                <th class="col-6">
                                    Codice Fiscale
                                </th>
                                <th class="col-6">
                                    Nome
                                </th>
                                <th class="col-6">
                                    Cognome
                                </th>
                                <th class="col-6">
                                    Telefono
                                </th>
                                <th class="col-6">
                                    Azioni
                                </th>
                            </tr>
                            <%for(Cliente cliente:clienti) { %>
                            <tr class="row">
                                <td></td>
                                <%
                                    out.append("<td>" + cliente.getCodiceFiscale() + " </td> ");
                                    out.append("<td>" + cliente.getNome() + " </td> ");
                                    out.append("<td>" + cliente.getCognome() + " </td> ");
                                    out.append("<td>" + cliente.getTelefono() + " </td> ");
                                %>
                                <td>
                                    <% url = "/EasyExpo_war_exploded/RiabilitaUtenteServlet?id=".concat(cliente.getCodiceFiscale().concat("&flag=2"));%>
                                    <a class="icon-check" onclick="notificaRiabilitazione('<%=url%>')"></a>
                                </td>
                            </tr>
                            <% } %>
                        </table>
                    </div>
                </div>
            </div>
        </section>
    </div>
<!--======= FOOTER =========-->
<footer>
    <jsp:include page="/footeradmin.jsp"/>
</footer>
</body>
</html>
