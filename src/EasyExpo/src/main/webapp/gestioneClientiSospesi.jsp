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
    %>
    <% List<Cliente> cliente = (List<Cliente>) request.getSession().getAttribute("clienti");%>
    <div id="content">
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
            <% for (int i=0;i<cliente.size();i++) { %>
            <tr>
                <td></td>
                <%
                    out.append("<td>" + cliente.get(i).getCodiceFiscale() + " </td> ");
                %>

                <%
                    out.append("<td>" + cliente.get(i).getNome() + " </td> ");
                %>

                <%
                    out.append("<td>" + cliente.get(i).getCognome() + " </td> ");
                %>

                <%
                    out.append("<td>" + cliente.get(i).getTelefono() + " </td> ");
                %>

                <td>
                    <button type="submit"  formaction="/RiabilitaCliente">Riabilita</button>
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
