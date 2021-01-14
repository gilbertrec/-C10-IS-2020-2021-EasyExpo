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
    %>
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
            <% for (Fornitore fornitore:fornitori) { %>
            <tr>
                <td></td>
                    <%
                        out.append("<td>" + fornitore.getPartitaIva() + " </td> ");
                    %>

                    <%
                        out.append("<td>" + fornitore.getNome() + " </td> ");
                    %>

                    <%
                        out.append("<td>" + fornitore.getCognome() + " </td> ");
                    %>

                    <%
                        out.append("<td>" + fornitore.getRagioneSociale() + " </td> ");
                    %>

                <td>
                    <a class="icon-ban" href="/EasyExpo_war_exploded/SospendiUtenteServlet?id=<%=fornitore.getPartitaIva()%>">
                    </a>
                    <a class="icon-user-female " href="/EasyExpo_war_exploded/ListaProdottiServlet?id=<%=fornitore.getPartitaIva()%>">
                    </a>
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
