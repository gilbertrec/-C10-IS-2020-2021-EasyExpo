ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'basedidati';
Drop Database if exists EasyExpo;
CREATE DATABASE EasyExpo;
use EasyExpo;

CREATE TABLE Cliente(
	codiceFiscale varchar(16) not null primary key,
    nome varchar(30) not null,
    cognome varchar(30) not null,
    telefono varchar(10),
    luogoUbicazione varchar(30),
    email varchar(50) not null,
    password varchar(512) not null,
    stato ENUM('ATTIVO','SOSPESO') not null
);

CREATE TABLE Fornitore(
	partitaIva varchar(11) not null primary key,
    nome varchar(30) not null,
    cognome varchar(30) not null,
    telefono varchar(10),
    luogoUbicazione varchar(30),
    email varchar(50) not null,
	password varchar(512) not null,
    ragioneSociale varchar(30) not null,
    abbonato boolean,
    stato ENUM('ATTIVO','SOSPESO') not null
);

CREATE TABLE Admin(
    email varchar(50) not null primary key,
	password varchar(512) not null
);

CREATE TABLE Prodotto(
	idProdotto int auto_increment not null,
    partitaIva varchar(11) not null,
    titolo varchar(100) not null,
    descrizione varchar(1024) not null,
    tipo ENUM('SERVIZIO', 'ATTREZZATURA'),
    quantita int not null,
    prezzo decimal not null,
    immagine varchar(3000),
    primary key(idProdotto, partitaIva),
    foreign key(partitaIva) references Fornitore(partitaIva)
    on delete cascade
    on update cascade
);

CREATE TABLE Tag(
	idTag int auto_increment not null primary key, 
    nome varchar(20) not null
);

CREATE TABLE TagProdotto(
    idTag int not null,
    idProdotto int not null,
    partitaIva varchar(11) not null,
    primary key(idTag, partitaIva, idProdotto),
	foreign key(idTag) references Tag(idTag)
    on delete cascade
    on update cascade,
	foreign key(idProdotto) references Prodotto(idProdotto)
    on delete cascade
    on update cascade,
    foreign key(partitaIva) references Prodotto(partitaIva)
    on delete cascade
    on update cascade
);

CREATE TABLE RichiestaPreventivo(
	idRichiesta int auto_increment not null primary key,
    codiceFiscale varchar(16) not null,
    partitaIva varchar(11) not null,
    titolo varchar(50) not null,
    luogoEvento varchar(32) not null,
    descrizioneEvento varchar(1024) not null,
    nota varchar(300),
    dataRichiesta date not null,
    stato ENUM('IN_ATTESA', 'CONFERMATO', 'RIFIUTATO') not null,
    foreign key(codiceFiscale) references Cliente(codiceFiscale)
    on delete cascade
    on update cascade,
    foreign key(partitaIva) references Fornitore(partitaIva)
    on delete cascade
    on update cascade
);

CREATE TABLE ProdottoRichiesta(
	id int auto_increment not null primary key,
    idRichiesta int not null,
    idProdotto int not null,
    partitaIva varchar(11) not null,
    numColli int not null,
    prezzo decimal not null,
    dataInizioNoleggio date not null,
    dataFineNoleggio date not null,
    foreign key(idRichiesta) references RichiestaPreventivo(idRichiesta)
    on delete cascade
    on update cascade,
    foreign key(idProdotto) references Prodotto(idProdotto)
    on delete cascade
    on update cascade,
    foreign key(partitaIva) references Prodotto(partitaIva)
    on delete cascade
    on update cascade
);

CREATE TABLE Preventivo(
	idPreventivo int auto_increment not null primary key,
    idRichiesta int not null,
    partitaIva varchar(11) not null,
    codiceFiscale varchar(16) not null,
    dataPreventivo date not null,
    prezzoTotale decimal not null,
    nota varchar(300), 
	foreign key(idRichiesta) references RichiestaPreventivo(idRichiesta)
    on delete cascade
    on update cascade,
    foreign key(partitaIva) references Fornitore(partitaIva)
    on delete cascade
    on update cascade,
	foreign key(codiceFiscale) references Cliente(codiceFiscale)
    on delete cascade
    on update cascade
);

CREATE TABLE Abbonamento(
	idAbbonamento int auto_increment not null primary key,
    partitaIva varchar(11) not null,
    dataInizio date not null,
    dataFine date not null,
	foreign key(partitaIva) references Fornitore(partitaIva)
    on delete cascade
    on update cascade
);

CREATE TABLE MetodoPagamento(
	numeroCarta varchar(16) not null primary key,
    partitaIva varchar(11) not null,
    nomeIntestatario varchar(50) not null,
    dataScadenza date not null,
    cvv int not null,
    foreign key(partitaIva) references Fornitore(partitaIva)
    on delete cascade
    on update cascade
);

INSERT INTO Cliente VALUES
("QTTMCR53R61E406B", "Mariacristina", "Quattroquarti", 3890720375, "Lagnasco", "quattroquarti@gmail.com", sha2('Cristina99', 512),"SOSPESO"),
("BRZRTN02H50C293D","Viola","Criscuoli", 3498364820, "Ponza", "violetta@gmail.com", sha2('iolaCri00', 512),"ATTIVO"),
("IULGAE99C23R123R", "Gaetano", "Iuliano", 3998765987, "Terzigno", "gaetano99@gmail.com", sha2('Gaetano99*', 512),"ATTIVO");

INSERT INTO Fornitore VALUES
("03271170361", "Susanna", "Zaidane", 3249878965, "Modena", "zaidane68a@mailstop.it", sha2('SusannaZ68', 512), "privato",false, "ATTIVO"),
("01391350129","Filomena","Blevi", 3778254760, "Pulsano", "filly@gmail.com", sha2('FilBlevi78', 512), "privato",true, "ATTIVO"),
("01602620930", "Nicola", "Bortuzzo", 3934567659, "Pordenone", "absvirgilio.it", sha2('AziendaAbs*', 512), "Abs Snc",false, "SOSPESO");

INSERT INTO Admin VALUES
("lucrezia.robustelli@gmail.com", sha2('lucry00*', 512)),
("katia.monaco@gmail.com", sha2('katia99', 512)),
("gaetano99@virgilio.it", sha2('GaeIu66', 512)),
("peppe.avino@gmail.com", sha2('peppino34_', 512)),
("davidepappa@virgilio.it", sha2('davide.45', 512)),
("strumolos@virgilio.it", sha2('sabatinostrumolo*', 512));

INSERT INTO Prodotto VALUES
(1, "01391350129", "Casse amplificatori da palco", "Il set altoparlanti Fenton SPB-8 e' composto da una cassa attiva e da una passiva e garantisce un sound potente dall'ottima pressione audio. La struttura robusta della coppia di altoparlanti, composta da un telaio in MDF e pratiche maniglie nella parte superiore, ne consente il trasporto e l'utilizzo anche all'aperto.", "ATTREZZATURA", 5, 99.00, "images/amplificatore.jpg"),
(2, "01391350129", "Gazebo", "Struttura in legno di abete e copertura in PVC.", "ATTREZZATURA", 65, 499.00, "images/gazebo.jpg"),
(3, "01391350129", "Montaggio Palco", "Cotruzione di Palchi modulati per spettacoli per manifestazioni, eventi pubblici o privati. Si dispone di una squadra di esperti per il montaggio non solo di palcoscenico. A seconda della dimensione del palco il prezzo potrebbe variare.", "SERVIZIO", 65, 700.00, "images/palco.jpg"),
(1, "01602620930", "Catering", "Una certezza nell’organizzazione catering per i vostri eventi. Grazie alla competenza ventennale acquisita, in grado di operare miscelando professionalita', esperienza, attenzione e armonia per trasformare un ricevimento, una festa o un evento in un giorno indimenticabile. Il cliente viene seguito in tutte le fasi, dalla scelta della location alla cura dell’atmosfera e del tema dell’evento, alla creazione del menu'. Il tutto all’insegna dell’innovazione artistica e del buon gusto, spaziando tra Ville d’Epoca e Castelli, case private, sedi di aziende, Centri Congressuali e molto altro ancora.", "SERVIZIO", 9, 50.00, "images/catering.jpg"),
(2, "01602620930", "Cassa musicale per feste", "McGrey, DJ Party altoparlante 2x300W coppia, efficienza ancora maggiore, di nuova concezione bassi i driver chiave di volta, nuova progettazione in legno", "ATTREZZATURA", 50, 150.00, "images/casse4.jpg"),
(1, "03271170361", "Servizio di Dj", "Un servizio perfetto: mi occupo della musica per le sfilate e delle promozioni per le feste. Affidatevi a me perche' so interpretare le svariate situazioni dei vostri eventi con bella musica e animazioni", "SERVIZIO", 40, 180.00, "images/download-6.jpg"),
(4, "01391350129", "Divisori Covid 2020", "La protezione e la sicurezza prima di tutto! L’attuale emergenza sanitaria dovuto al Covid-19 ha cambiato inevitabilmente il nostro modo di vivere e ci obbliga a prendere provvedimenti nella vita quotidiana e nel lavoro per evitare i contagi e il propagarsi del virus.", "ATTREZZATURA", 120, 50.00, "images/divisori.jpg");

INSERT INTO Abbonamento VALUES
(1,"01391350129", 20201113, 20200213),
(2,"01391350129", 20190605, 20190705),
(3,"03271170361", 20200713, 20200813),
(4,"01391350129", 20210114, 20210214);

INSERT INTO MetodoPagamento VALUES
("1452896574587589", "03271170361", "Susanna Zaidane", 20221210, 523),
("8000425678567582", "01391350129", "Filomena Blevi", 20230925, 412),
("4522656596232265", "01391350129", "Filomena Blevi", 20200514, 278);

INSERT INTO Tag VALUES
(123, "Musica"),
(124, "Catering"),
(131, "Plexiglass"),
(125, "DJ"),
(126, "DJSet"),
(127, "Allestimento"),
(129, "Fiera"),
(130, "Servizio");

INSERT INTO TagProdotto VALUES
(123, 1, "01391350129"),
(127, 2, "01391350129"),
(129, 2, "01391350129"),
(130, 3, "01391350129"),
(124, 1, "01602620930"),
(130, 1, "01602620930"),
(131, 4, "01391350129"),
(127, 4, "01391350129"),
(125, 1, "03271170361"),
(126, 1, "03271170361");

INSERT INTO RichiestaPreventivo VALUES
(1000, "IULGAE99C23R123R", "01391350129", "Allestimento fiera dello sport", "Polignano a mare", "Un nuovo appuntamento dedicato al mondo del calcio, Calcio Expo, organizzato nella Fortezza da Basso a Firenze e rivolto ad addetti ai lavori, aziende, pubblico di appassionati. Obiettivo dell’evento Calcio Expo è quello di riunire e far incontrare le persone che per professione o per passione sono legate a questo sport. A Calcio Expo parteciperanno squadre, scuole, associazioni, enti e federazioni sportive, dirigenti , allenatori, calciatori di diverse squadre e ancora gestori di centri sportivi, arbitri, sponsor. Ognuna di queste figure avrà l’occasione di confrontarsi su temi quali la competizione, l’agonismo, il divertimento e il fair play, anime di uno sport che in Italia rappresenta lo sport per eccellenza.", "Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pro", 20201230, "RIFIUTATO"),
(1001, "IULGAE99C23R123R", "01602620930", "Allestimento Matrimonio con Ylenia", "Sant'antonio Abate", "Un matrimonio da sogno elegante e raffinato è un matrimonio in cui la vera differenza è fatta da piccoli ma meravigliosi particolari. Cerca allora di stupire i tuoi invitati differenziandoti proprio nella cura del dettaglio", null, 20211222, "CONFERMATO"),
(1003, "BRZRTN02H50C293D", "01602620930", "Fiera dell'est", "Lagonegro", "Fiera dell' Est organizza, ospita e gestisce eventi di livello internazionale nei suoi padiglioni e nel mondo, dal 1920. Abbiamo bisogno di poter accogliere un numero elevato di gente e un numero elevanto di attrezzatura per fiere.", null, 20221124, "CONFERMATO"),
(1004, "IULGAE99C23R123R", "01391350129", "Concerto", "Sarno", "Concerto dei Pinguini Tattici Nucleari, piccolo paese deve contente una grande folla ma in tempo di covid dobbiamo anche preventire danni e effetti collaterali.", "Grande professionalità e pagamento ala consegna", 20220113, "IN_ATTESA"),
(1005, "BRZRTN02H50C293D", "01391350129", "E3", "Napoli", "Grandissima Fiera del Gaming che riunisce tutti i più grandi youtubers di Italia che i svolge a Napoli nella Fiera d'oltremare e eabbiamo bisogno di moltissimo materiale per permttere il divertimento delle persone", null,   20210113, "CONFERMATO");

INSERT INTO ProdottoRichiesta VALUES
(4000, 1000, 1, "01391350129", 4, 396.00,  20191220, 20220103),
(4001, 1000, 2, "01391350129", 23, 11477.00,  20191220, 20220103),
(4002, 1001, 1, "01602620930", 2, 100.00, 20211222, 20211222),
(4003, 1003, 2, "01602620930", 12, 5988.00, 20221002, 20201130),
(4004, 1004, 2, "01391350129", 3, 1497.00, 20220110, 20220120),
(4006, 1004, 4, "01391350129", 30, 1500.00, 20220110, 20220110),
(4007, 1005, 1, "01391350129", 30, 2970.00, 20210110, 20210130),
(4008, 1005, 2, "01391350129", 50, 24950.00, 20210110, 20210130),
(4009, 1005, 3, "01391350129", 1, 700.00, 20210110, 20210130);

INSERT INTO Preventivo VALUES
(7001, 1001, "01602620930", "IULGAE99C23R123R",  20201230, 300.00, "Sovraccarico prezzo di servizi aggiuntivi"),
(7002, 1003, "01602620930", "BRZRTN02H50C293D", 20201224, 5500.00, null),
(7003, 1005, "01391350129", "BRZRTN02H50C293D", 20201224, 28500.00, "Sconto Fedeltà");