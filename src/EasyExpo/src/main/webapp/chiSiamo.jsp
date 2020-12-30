<%--
  Created by IntelliJ IDEA.
  User: gaeta
  Date: 21-Dec-20
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="M_Adnan">
    <title>EASYEXPO - ChiSiamo</title>

    <!-- SLIDER REVOLUTION 4.x CSS SETTINGS -->
    <link rel="stylesheet" type="text/css" href="rs-plugin/css/settings.css" media="screen"/>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="css/ionicons.min.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/responsive.css" rel="stylesheet">

    <!-- JavaScripts -->
    <script src="js/modernizr.js"></script>

    <!-- Online Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Playfair+Display:400,700,900' rel='stylesheet' type='text/css'>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

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
                                per conseguire il nostro sogno e fornire uno strumento di supporto agli organizzatori di eventi
                                e ai fornitori di attrezzature, per consentire loro una facile comunicazione con trasparenza, rapidità ed efficienza
                                tramite scambio di preventivi per il noleggio di attrezzature o servizi.
                                <br>
                                <br>
                                Ogni cliente potrà usare il portale per ricercare nell'apposita barra di ricerca, tramite nome o tag,
                                un prodotto o un fornitore dal quale desidera rifornirsi, potrà visionare le specifiche di ogni prodotto, aggiungerlo al carrello
                                e procedere alla compilazione, tramite apposito pulsante, di una richiesta di preventivo grazie alla quale
                                potrà prendere accordi dettagliati con il fornitore in questione.
                                Ogni fornitore invece, dopo aver sottoscritto un abbonamento mensile, potrà aggiungere prodotti al proprio catalogo e utilizzare
                                la propria area personale come se fosse una vetrina, tramite la quale potrà ampliare la propria clientela. Potrà ricevere e visualizzare le richieste per
                                i prodotti che sono presenti nel catalogo personale e potrà procedere, tramite apposito pulsante, alla compilazione di un preventivo grazie al quale
                                stipulerà accordi dettagliati con il cliente in questione.</p>

                            <!-- IMG -->
                            <div class="relative"><img class="img-responsive margin-top-80 margin-bottom-80"
                                                       src="images/chiSiamo2.jpg" alt="">
                                <div class="position-center-center"> <span class="huge-text">il nostro
                                team</span></div>
                            </div>
                            <p> Avere un portale dove confrontare i vari preventivi e poter essere in collegamento diretto con i vari Fornitori
                                giova sia ai Fornitori meno conosciuti, pubblicando le proprie attrezzature e i propri servizi,
                                sia agli organizzatori di eventi, che hanno modo di trovare l’offerta più conveniente per le proprie
                                necessità richiedendo uno o anche più preventivi. <br>
                                <br>
                                </p>
                            <img class="margin-top-50" src="images/firma.png" alt=""></div>
                    </div>
                </div>
            </div>
        </section>

        <!-- IL NOSTRO TEAM -->
        <section class="our-team our-team-small  light-gray-bg padding-top-150 padding-bottom-80">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4">

                        <!-- HEADING -->
                        <div class="heading style-left">
                            <h4>il nostro team</h4>
                            <span>Uniti per supportare e aiutare gli stakeholder!</span></div>
                    </div>

                    <!-- TEAM -->
                    <div class="col-lg-8">
                        <ul class="row">

                            <!-- Member -->
                            <li class="col-md-4 text-center animate fadeInUp" data-wow-delay="0.4s">
                                <article>
                                    <!-- abatar -->
                                    <div class="avatar"><img class="img-circle" src="images/team-1.jpg" alt="">
                                        <!-- Team hover -->
                                        <div class="team-hover">
                                            <div class="position-center-center">
                                                <div class="social-icons"><a href="#."><i
                                                        class="icon-social-facebook"></i></a> <a href="#."><i
                                                        class="icon-social-twitter"></i></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Team Detail -->
                                    <div class="team-names">
                                        <h6>GAETANO IULIANO</h6>
                                        <p>MEMBRO</p>
                                    </div>
                                </article>
                            </li>

                            <!-- Member -->
                            <li class="col-md-4 text-center animate fadeInUp" data-wow-delay="0.6s">
                                <article>
                                    <!-- abatar -->
                                    <div class="avatar"><img class="img-circle" src="images/team-2.jpg" alt="">
                                        <!-- Team hover -->
                                        <div class="team-hover">
                                            <div class="position-center-center">
                                                <div class="social-icons"><a href="#."><i
                                                        class="icon-social-facebook"></i></a> <a href="#."><i
                                                        class="icon-social-twitter"></i></a></div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Team Detail -->
                                    <div class="team-names">
                                        <h6>LUCREZIA ROBUSTELLI</h6>
                                        <p>MEMBRO</p>
                                    </div>
                                </article>
                            </li>

                            <!-- Member -->
                            <li class="col-md-4 text-center animate fadeInUp" data-wow-delay="0.8s">
                                <article>
                                    <!-- abatar -->
                                    <div class="avatar"><img class="img-circle" src="images/team-3.jpg" alt="">
                                        <!-- Team hover -->
                                        <div class="team-hover">
                                            <div class="position-center-center">
                                                <div class="social-icons"><a href="#."><i
                                                        class="icon-social-facebook"></i></a> <a href="#."><i
                                                        class="icon-social-twitter"></i></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Team Detail -->
                                    <div class="team-names">
                                        <h6>GIUSEPPE AVINO</h6>
                                        <p>MEMBRO</p>
                                    </div>
                                </article>
                            </li>

                            <!-- Member -->
                            <li class="col-md-4 text-center">
                                <article>
                                    <!-- abatar -->
                                    <div class="avatar"><img class="img-circle" src="images/team-4.jpg" alt="">
                                        <!-- Team hover -->
                                        <div class="team-hover">
                                            <div class="position-center-center">
                                                <div class="social-icons"><a href="#."><i
                                                        class="icon-social-facebook"></i></a> <a href="#."><i
                                                        class="icon-social-twitter"></i></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Team Detail -->
                                    <div class="team-names">
                                        <h6>KATIA MONACO DE SIMONE</h6>
                                        <p>MEMBRO</p>
                                    </div>
                                </article>
                            </li>

                            <!-- Member -->
                            <li class="col-md-4 text-center">
                                <article>
                                    <!-- abatar -->
                                    <div class="avatar"><img class="img-circle" src="images/team-5.jpg" alt="">
                                        <!-- Team hover -->
                                        <div class="team-hover">
                                            <div class="position-center-center">
                                                <div class="social-icons"><a href="#."><i
                                                        class="icon-social-facebook"></i></a> <a href="#."><i
                                                        class="icon-social-twitter"></i></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Team Detail -->
                                    <div class="team-names">
                                        <h6>SABATINO STRUMOLO</h6>
                                        <p>MEMBRO</p>
                                    </div>
                                </article>
                            </li>

                            <!-- Member -->
                            <li class="col-md-4 text-center">
                                <article>
                                    <!-- abatar -->
                                    <div class="avatar"><img class="img-circle" src="images/team-6.jpg" alt="">
                                        <!-- Team hover -->
                                        <div class="team-hover">
                                            <div class="position-center-center">
                                                <div class="social-icons"><a href="#."><i
                                                        class="icon-social-facebook"></i></a> <a href="#."><i
                                                        class="icon-social-twitter"></i></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Team Detail -->
                                    <div class="team-names">
                                        <h6>DAVIDE PAPPALARDO</h6>
                                        <p>MEMBRO</p>
                                    </div>
                                </article>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </section>


        <!-- Client Img  -->
        <section class="fun-facts padding-top-150 padding-bottom-80">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4">

                        <!-- HEADING -->
                        <div class="heading style-left padding-right-20">
                            <h4>qualche Dato</h4>
                            <span>La nostra grande Community :)</span></div>
                    </div>

                    <!-- Qualche Dato -->
                    <div class="col-lg-8">
                        <ul class="row">

                            <!-- Fornitori -->
                            <li class="col-sm-4"><i class="icon-handbag"></i> <span> 3 ${prezzo}</span>
                                <h5>fornitori</h5>
                            </li>

                            <!-- Prodotti -->
                            <li class="col-sm-4"><i class="icon-grid"></i> <span> 4 ${prezzo}</span>
                                <h5>prodotti</h5>
                            </li>

                            <!-- Clienti -->
                            <li class="col-sm-4"><i class="icon-users"></i> <span> 3 ${prezzo}</span>
                                <h5>clienti</h5>
                            </li>
                        </ul>
                    </div>
                </div>
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