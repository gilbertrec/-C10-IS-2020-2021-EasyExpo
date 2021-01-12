<%@ page import="Controller.HttpServlet" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.POJO.Fornitore" %>
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
    <title>Title</title>
</head>
<body>
<div id="wrap">
    <header>
        <jsp:include page="/header.jsp">
            <jsp:param name="pageTitle" value="Gestione Fornitori"/>
        </jsp:include>
    </header>
    <% List<Cliente> clienti = (List<Cliente>) request.getSession().getAttribute("clienti");%>
    <div id="content">
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
            <% for (int i=0;i<fornitori.size();i++) { %>
            <tr>
                <td>
                    <%
                        fornitori.get(i).getPartitaIva();
                    %>
                </td>
                <td>
                    <%
                        fornitori.get(i).getNome();
                    %>
                </td>
                <td>
                    <%
                        fornitori.get(i).getCognome();
                    %>
                </td>
                <td>
                    <%
                        fornitori.get(i).getRagioneSociale();
                    %>
                </td>
                <td>
                    <!--da rivedere -->
                    <button type="submit" class="btn" formaction="/SospendiFornitore">Sospendi</button>
                    <button type="submit" class="btn" formaction="/VisualizzaProdotti">Prodotti</button>
                </td>
            </tr>
            <% } %>
        </table>
    </div>
</div>
</body>
</html>