<%@ page import="Controller.HttpServlet" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.POJO.Fornitore" %>
<%@ page import="Model.POJO.Prodotto" %><%--
  Created by IntelliJ IDEA.
  User: Sabatino
  Date: 12/01/2021
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestione Prodotti</title>
</head>
<body>
<div id="wrap">
    <header>
        <jsp:include page="/headeradmin.jsp">
            <jsp:param name="pageTitle" value="Gestione Prodotti"/>
        </jsp:include>
    </header>
        <%
        if(request.getSession().getAttribute("LeaderSupremo")==null){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/adminLoginSegreto.jsp");
            requestDispatcher.forward(request,response);
        }
        if(request.getSession().getAttribute("prodotti") == null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ListaProdottiServlet");
            requestDispatcher.forward(request,response);
        }
    %>
        <% List<Prodotto> prodotti = (List<Prodotto>) request.getSession().getAttribute("prodotti");%>
    <div id="content">
        <section class="chart-page padding-top-100 padding-bottom-100">
            <div class="container">
                <!-- Payments Steps -->
                <div class="shopping-cart">
                    <!-- SHOPPING INFORMATION -->
                    <div class="cart-ship-info register">
                        <h6>GESTIONE PRODOTTI</h6>
                        <table class="table">
                            <tr class="row">
                                <th class="col-6">
                                    Foto
                                </th>
                                <th class="col-6">
                                    Titolo
                                </th>
                                <th class="col-6">
                                    Descrizione
                                </th>
                                <th class="col-6">
                                    Tipo
                                </th>
                                <th class="col-6">
                                    Prezzo
                                </th>
                                <th class="col-6">
                                    Azioni
                                </th>
                            </tr>
                            <% for (Prodotto prodotto:prodotti) { %>
                            <tr>
                                <td></td>
                                <%
                                    out.append("<td>" + "<img src=\""+prodotto.getImmagine()+"\" width=\"100px\" height=\"100px\">"+" </td> ");
                                    out.append("<td>" + prodotto.getTitolo() + " </td> ");
                                    out.append("<td>" + prodotto.getDescrizione() + " </td> ");
                                    out.append("<td>" + prodotto.getTipo().toString() + " </td> ");
                                    out.append("<td>" + prodotto.getPrezzo() + " </td> ");
                                %>
                                <td>
                                    <a class="icon-trash" title="Elimina" href="/EasyExpo_war_exploded/EliminaProdottoServlet?id=<%=prodotto.getIdProdotto()%>&partitaIva=<%=prodotto.getPartitaIva()%>"></a>
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

