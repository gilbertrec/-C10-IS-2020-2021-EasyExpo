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
    <title>Title</title>
</head>
<body>
<div id="wrap">
    <header>
        <jsp:include page="/headeradmin.jsp">
            <jsp:param name="pageTitle" value="Gestione Fornitori"/>
        </jsp:include>
    </header>
    <% /*if (request.getSession().getAttribute("fornitori") == null) {

    }*/%>
    <% List<Fornitore> fornitori = (List<Fornitore>) request.getSession().getAttribute("fornitori");%>
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
                <td></td>
                    <%
                        out.append("<td>" + fornitori.get(i).getPartitaIva() + " </td> ");
                    %>

                    <%
                        out.append("<td>" + fornitori.get(i).getNome() + " </td> ");
                    %>

                    <%
                        out.append("<td>" + fornitori.get(i).getCognome() + " </td> ");
                    %>

                    <%
                        out.append("<td>" + fornitori.get(i).getRagioneSociale() + " </td> ");
                    %>

                <td>
                    <button type="submit"  formaction="/SospendiFornitore">Sospendi</button>
                    <button type="submit"  formaction="/VisualizzaProdotti">Prodotti</button>
                </td>
            </tr>
            <% } %>
        </table>
    </div>
</div>
<!--======= FOOTER =========-->
<footer>
    <jsp:include page="/footeradmin.jsp"/>
</footer>
</body>
</html>
