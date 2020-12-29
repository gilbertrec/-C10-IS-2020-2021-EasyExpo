<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <script>
        function ricerca() {
            var ricercato = document.getElementById("search").value;
            var http = new XMLHttpRequest();
            http.open("GET", "RicercaServlet?search=" + ricercato, true);

            http.onreadystatechange = function () {

                if (this.readyState == 4 && this.status == 200) {
                    var x = JSON.parse(this.responseText);

                    if (x[0].success) {
                        document.getElementById("item").innerHTML = "";
                        for (var i = 0; i < x[0].data.length; i++) {
                            if (x[0].data[i].titolo != null) {
                                var html =
                                    '<div class="item-prodotto" style="padding: 3px">' +
                                    '<h5>' + x[0].data[i].titolo + '</h5>' +
                                    '</div>';
                            }
                            if (x[0].data[i].nome != null) {
                                var html =
                                    '<div class="item-fornitore" style="padding: 3px">' +
                                    '<h5 style="color: #606021">' + x[0].data[i].nome + '</h5>' +
                                    '</div>';
                            }

                            document.getElementById("item").innerHTML += html;
                        }
                    } else {
                        alert(x[0].message);
                    }
                }
            };
            http.send();
        }

        function prodotto(id, partitaIva) {
            location.href = "ProdottoServlet?id=" + id + "?partitaIva=" + partitaIva;
        }


    </script>

</head>

<body>
<!-- LOADER -->
<div id="loader">
    <div class="position-center-center">
        <div class="ldr"></div>
    </div>
</div>

<!-- Wrap -->
<div id="wrap">

    <header>
        <jsp:include page="/header.jsp">
            <jsp:param name="pageTitle" value="Homepage"/>
        </jsp:include>

    </header>


    <div class="search">
        <form>
            <input type="text" id="search" placeholder="Prodotto, Fornitore, Tag..." oninput="ricerca()"
                   style="width: 90%; display: block; margin: auto; border: 2px solid #100f0f; border-radius: 5px">
        </form>
    </div>

    <div id="item" style="margin-left: 70px"></div>

</div>
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/own-menu.js"></script>
<script src="js/jquery.lighter.js"></script>
<script src="js/owl.carousel.min.js"></script>

<!-- SLIDER REVOLUTION 4.x SCRIPTS  -->
<script type="text/javascript" src="rs-plugin/js/jquery.tp.t.min.js"></script>
<script type="text/javascript" src="rs-plugin/js/jquery.tp.min.js"></script>
<script src="js/main.js"></script>
<script src="js/main.js"></script>
</body>
</html>
