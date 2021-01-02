
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <link href="css/ricerca.css" rel="stylesheet">
    <script>
        function ricerca() {
            var ricercato=document.getElementById("search").value;
            var http= new XMLHttpRequest();
            http.open("GET", "RicercaServlet?search="+ricercato, true);

            http.onreadystatechange=function()
            {

                if(this.readyState==4 && this.status==200)
                {
                    var x = JSON.parse(this.responseText);

                    if(x[0].success)
                    {
                        document.getElementById("item").innerHTML= "";
                        for (var i = 0;i<x[0].data.length;i++)
                        {
                            if(x[0].data[i].titolo!=null) {

                                var html =
                                    '<div class="wrapper">' +
                                    '<div class="item-prodotto" data-id="'+x[0].data[i].id+'" data-partitaIVA="'+x[0].data[i].partitaIVA+'" onclick="prodotto(this.dataset.id,\''+x[0].data[i].partitaIVA+'\')">' +
                                    '<h5>' + x[0].data[i].titolo + '</h5>' +

                                    '<h6>' + x[0].data[i].prezzo + '€' + '</h6>' +
                                    '</div>' +
                                    '</div>';
                            }
                            if(x[0].data[i].nome!=null) {
                                var html =
                                    '<div class="wrapper">' +
                                    '<div class="item-fornitore" data-partitaIVA="'+x[0].data[i].partitaIVA+'" onclick="fornitore(\''+x[0].data[i].partitaIVA+'\')">' +
                                    '<h5>' + x[0].data[i].nome + '</h5>' +
                                    '<h5>' + x[0].data[i].cognome + '</h5>' +
                                    '<h8>' + 'si trova a:' + '<h8>' +
                                    '<h6 style="margin-top: 5px">' + x[0].data[i].luogoUbicazione + '</h6>' +
                                    '</div>' +
                                    '</div>';
                            }

                            document.getElementById("item").innerHTML += html;
                        }
                    }else{
                        alert(x[0].message);
                    }
                }
            };
            http.send();
        }

        function prodotto(id, partitaIva) {
            location.href="ProdottoServlet?id="+ id + "&partitaIva="+partitaIva;
        }

        function fornitore(partitaIva){
            location.href="FornitoreServlet?partitaIva=" + partitaIva;
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
                <input type="text" id="search" placeholder="Prodotto, Fornitore, Tag..." oninput="ricerca()" style="width: 90%; display: block; margin: auto; border: 2px solid #100f0f; border-radius: 5px">
            </form>
        </div>

    <div id="item" style="margin-left: 50px"></div>



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
