
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
                        document.getElementById("item").innerHTML = "";
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
                <input type="search" id="search" placeholder="Prodotto, Fornitore, Tag..." oninput="ricerca()" style="width: 90%; display: block; margin: auto; border: 2px solid #100f0f; border-radius: 5px">

            </form>
        </div>

<!-- Item -->
<div id="item "class="item">
    <!-- Item img -->
    <div class="item-img"><img class="img-1" src="images/product-1.jpg" alt=""> <img class="img-2"
                                                                                     src="images/product-2.jpg"
                                                                                     alt="">
        <!-- Overlay -->
        <div class="overlay">
            <div class="position-center-center">
                <div class="inn"><a href="images/product-1.jpg" data-lighter><i
                        class="icon-magnifier"></i></a> <a href="#." data-toggle="tooltip" data-placement="top"
                                                           title="Aggiungi al Carrello"><i
                        class="icon-basket"></i></a></div>
            </div>
        </div>
    </div>
    <!-- Item Name -->
    <div class="item-name"><a href="SpecificheProdottoServlet">stone cup</a>
        <p>Lorem ipsum dolor sit amet</p>
    </div>
    <!-- Price -->
    <span class="price"><small>€</small>${prezzo}</span></div>


</body>
</html>
