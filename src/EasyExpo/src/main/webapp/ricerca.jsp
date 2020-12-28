
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
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
                        document.getElementById("prodotti").innerHTML = "";
                        for (var i = 0;i<x[0].data.length;i++)
                        {
                            var html =
                                '<div class="immagine" data-idprodotto="'+x[0].data[i].id+'" data-partitaIva="'+x[0].data[i].partitaIVA+'" onclick="prodotto(this.dataset.idprodotto, this.dataset.partitaIva)">' +
                                <!--'<img class="preview" src="img/'+ x[0].data[i].img +'">' +-->
                                '<h4>' + x[0].data[i].titolo +'</h4>' +
                                '<h5>' + x[0].data[i].tipo + '</h5>' +
                                '</div>';
                            document.getElementById("prodotti").innerHTML += html;
                        }
                    }else{
                        alert(x[0].message);
                    }
                }
            };
            http.send();
        }

        function prodotto(id, partitaIva) {
            location.href="ProdottoServlet?id="+id+"?partitaIva="+partitaIva;
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

    <div id="prodotti"></div>

</body>
</html>
