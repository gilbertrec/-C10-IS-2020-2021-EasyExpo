<%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 22/12/2020
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="registrazione" action="RegistrazioneFornitore" method="post">


    <div class="registrazioneNome">
        <label>Nome</label><br>
        <input type="text" class="textRegistrazione" name="nome">
    </div>

    <div class="registrazioneCognome">
        <label>Cognome</label><br>
        <input type="text" class="textRegistrazione" name="cognome">
    </div>

    <div class="registrazionePIVA">
        <label>Partita IVA</label><br>
        <input type="text" class="textRegistrazione" name="partitaIVA">
    </div>

    <div class="registrazioneTelefono">
        <label>Telefono</label><br>
        <input type="text" class="textRegistrazione" name="telefono">
    </div>

    <div class="registrazioneLuogoUbicazione">
        <label>Luogo di ubicazione</label><br>
        <input type="text" class="textRegistrazione" name="luogoUbicazione">
    </div>

    <div class="registrazioneRagioneSociale">
        <label>Ragione Sociale</label><br>
        <input type="text" class="textRegistrazione" name="ragioneSociale">
    </div>

    <div class="registrazioneEmail">
        <label>Indirizzo email</label><br>
        <input type="text" class="textRegistrazione" name="email">
    </div>

    <div class="registrazionePassword">
        <label>Password</label><br>
        <input type="password" class="textRegistrazione" name="password">
    </div>

    <div class="registrazioneConfermaPass">
        <label>Conferma password</label><br>
        <input type="password" class="textRegistrazione" name="passwordConferma">
    </div>

    <div class="buttonRegistrami">
        <input id="registrami" type="submit" value="Registrami">
    </div>
</form>


</body>
</html>
