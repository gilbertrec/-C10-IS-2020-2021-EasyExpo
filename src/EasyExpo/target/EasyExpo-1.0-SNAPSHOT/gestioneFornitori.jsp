<%@ page import="Controller.HttpServlet" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.POJO.Fornitore" %><%--
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
    <title>Gestione Fornitori</title>
</head>
<body>
<div id="wrap">
    <header>
        <jsp:include page="/headeradmin.jsp">
            <jsp:param name="pageTitle" value="Gestione Fornitori"/>
        </jsp:include>
    </header>
    <%
        if(request.getSession().getAttribute("LeaderSupremo")==null){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/adminLoginSegreto.jsp");
            requestDispatcher.forward(request,response);
        }
        if(request.getAttribute("fornitori") == null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ListaFornitoriServlet");
            requestDispatcher.forward(request,response);
        }
        String url;
    %>
    <% List<Fornitore> fornitori = (List<Fornitore>) request.getAttribute("fornitori");%>
    <div id="content">
        <section class="chart-page padding-top-100 padding-bottom-100">
            <div class="container">
                <!-- Payments Steps -->
                <div class="shopping-cart">
                    <!-- SHOPPING INFORMATION -->
                    <div class="cart-ship-info register">
                        <h6>GESTIONE FORNITORI</h6>
                        <table class="table">
                            <tr class="row">
                                <th class="col-6">
                                    Partita IVA
                                </th>
                                <th class="col-6">
                                    Nome
                                </th>
                                <th class="col-6">
                                    Cognome
                                </th>
                                <th class="col-6">
                                    Ragione Sociale
                                </th>
                                <th class="col-6">
                                    Azioni
                                </th>
                            </tr>
                            <% for (Fornitore fornitore:fornitori) { %>
                            <tr>
                                <td></td>
                                <%
                                    out.append("<td>" + fornitore.getPartitaIva() + " </td> ");
                                    out.append("<td>" + fornitore.getNome() + " </td> ");
                                    out.append("<td>" + fornitore.getCognome() + " </td> ");
                                    out.append("<td>" + fornitore.getRagioneSociale() + " </td> ");
                                %>
                                <td>
                                    <% url ="SospendiUtenteServlet?id=".concat(fornitore.getPartitaIva().concat("&flag=1"));%>
                                    <a class="icon-ban" title="Sospendi" onclick="notificaSospensione('<%=url%>')"></a>
                                    <a class="icon-handbag" title="Lista Prodotti" href="ListaProdottiServlet?id=<%=fornitore.getPartitaIva()%>"></a>
                                </td>
                            </tr>
                            <% } %>
                        </table>
                        <%

                            if(fornitori.size()==0){
                                out.append("<p><b> NON E' PRESENTE ALCUN FORNITORE </b></p> ");
                            }
                        %>
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
