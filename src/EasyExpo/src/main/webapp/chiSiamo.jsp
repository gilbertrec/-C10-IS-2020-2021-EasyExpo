<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<body>

<!-- LOADER -->
<div id="loader">
    <div class="position-center-center">
        <div class="ldr"></div>
    </div>
</div>

<!-- Wrap -->
<div id="wrap">

    <!-- header -->
    <header>
        <jsp:include page="/header.jsp">
            <jsp:param name="pageTitle" value="Chi Siamo"/>
        </jsp:include>
    </header>

    <!--======= SUB BANNER =========-->
    <section class="sub-bnr" data-stellar-background-ratio="0.5"
             style="background:url(images/chiSiamo.jpg) center center no-repeat">
        <div class="position-center-center">
            <div class="container">
                <h4>CHI SIAMO?</h4>
                <p>In questa pagina è presente la nostra storia, le specifiche del sito e i componenti del Team
                    che ha sviluppato questo portale!</p>
                <ol class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li class="active">CHI SIAMO</li>
                </ol>
            </div>
        </div>
    </section>

    <!-- Content -->
    <div id="content">

        <!-- History -->
        <section class="history-block padding-top-100 padding-bottom-100">
            <div class="container">
                <div class="row">
                    <div class="col-xs-10 center-block">
                        <div class="col-sm-10 center-block">
                            <h4>La nostra Storia</h4>
                            <p> Siamo un gruppo di universitari che sognano la laurea in Informatica. Il progetto nasce
                                per conseguire il nostro sogno e fornire uno strumento di supporto agli organizzatori di
                                eventi
                                e ai fornitori di attrezzature, per consentire loro una facile comunicazione con
                                trasparenza, rapidità ed efficienza
                                tramite scambio di preventivi per il noleggio di attrezzature o servizi.
                                <br>
                                <br>
                                Ogni cliente potrà usare il portale per ricercare nell'apposita barra di ricerca,
                                tramite nome o tag,
                                un prodotto o un fornitore dal quale desidera rifornirsi, potrà visionare le specifiche
                                di ogni prodotto, aggiungerlo al carrello
                                e procedere alla compilazione, tramite apposito pulsante, di una richiesta di preventivo
                                grazie alla quale
                                potrà prendere accordi dettagliati con il fornitore in questione.
                                Ogni fornitore invece, dopo aver sottoscritto un abbonamento mensile, potrà aggiungere
                                prodotti al proprio catalogo e utilizzare
                                la propria area personale come se fosse una vetrina, tramite la quale potrà ampliare la
                                propria clientela. Potrà ricevere e visualizzare le richieste per
                                i prodotti che sono presenti nel catalogo personale e potrà procedere, tramite apposito
                                pulsante, alla compilazione di un preventivo grazie al quale
                                stipulerà accordi dettagliati con il cliente in questione.</p>

                            <!-- IMG -->
                            <div class="relative"><img class="img-responsive margin-top-80 margin-bottom-80"
                                                       src="images/chiSiamo2.jpg" alt="">
                                <div class="position-center-center"> <span class="huge-text">il nostro
                                team</span></div>
                            </div>
                            <p> Avere un portale dove confrontare i vari preventivi e poter essere in collegamento
                                diretto con i vari Fornitori
                                giova sia ai Fornitori meno conosciuti, pubblicando le proprie attrezzature e i propri
                                servizi,
                                sia agli organizzatori di eventi, che hanno modo di trovare l’offerta più conveniente
                                per le proprie
                                necessità richiedendo uno o anche più preventivi. <br>
                                <br>
                            </p>
                            <img class="margin-top-50" src="images/firma.png" alt=""></div>
                    </div>
                </div>
            </div>
        </section>



        <!-- Client Img  -->
        <section class="fun-facts padding-top-150 padding-bottom-80">
            <div class="container">
                <div class="row">
            </div>
        </section>
    </div>

    <!--======= FOOTER =========-->
    <footer>
        <jsp:include page="/footer.jsp"/>
    </footer>
</div>

</body>
</html>