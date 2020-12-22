<%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 21/12/2020
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
            <form action="LoginServlet" method="post" id="formLogin">
                <input type="text" name="email" placeholder="Email">
                <input type="password" name="password" placeholder="Password">
                <input type="submit" id="buttonLogin" value="Login">
            </form>

            <div class="registrazione">
                <a href="RegistrazioneForm" id="buttonRegistrazione">Registrazione</a>
            </div>
</body>
</html>
