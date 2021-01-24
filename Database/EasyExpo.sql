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
    nota varchar(200), 
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
("QTTMCR53R61E406B", "Mariacristina", "Quattroquarti", 3890720375, "Lagnasco", "quattroquarti@gmail.com", sha2('Cristina99', 512),"ATTIVO"),
("BRZRTN02H50C293D","Viola","Criscuoli", 3498364820, "Ponza", "violetta@gmail.com", sha2('iolaCri00', 512),"ATTIVO"),
("IULGAE99C23R123R", "Gaetano", "Iuliano", 3998765987, "Terzigno", "gaetano99@gmail.com", sha2('gae99*', 512),"SOSPESO");

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
(1, "01391350129", "Casse amplificatori da palco", "Il set altoparlanti Fenton SPB-8 e' composto da una cassa attiva e da una passiva e garantisce un sound potente dall'ottima pressione audio. La struttura robusta della coppia di altoparlanti, composta da un telaio in MDF e pratiche maniglie nella parte superiore, ne consente il trasporto e l'utilizzo anche all'aperto.", "ATTREZZATURA", 5, 99.00, "images/images.jpg"),
(1, "01602620930", "Catering", "Una certezza nell’organizzazione catering per i vostri eventi. Grazie alla competenza ventennale acquisita, in grado di operare miscelando professionalita', esperienza, attenzione e armonia per trasformare un ricevimento, una festa o un evento in un giorno indimenticabile. Il cliente viene seguito in tutte le fasi, dalla scelta della location alla cura dell’atmosfera e del tema dell’evento, alla creazione del menu'. Il tutto all’insegna dell’innovazione artistica e del buon gusto, spaziando tra Ville d’Epoca e Castelli, case private, sedi di aziende, Centri Congressuali e molto altro ancora.", "SERVIZIO", 9, 50.00, "images/download-4.jpg"),
(2, "01602620930", "Cassa musicale per feste", "McGrey, DJ Party altoparlante 2x300W coppia, efficienza ancora maggiore, di nuova concezione bassi i driver chiave di volta, nuova progettazione in legno", "ATTREZZATURA", 50, 150.00, "images/download-5.jpg"),
(1, "03271170361", "Servizio di Dj", "Un servizio perfetto: mi occupo della musica per le sfilate e delle promozioni per le feste. Affidatevi a me perche' so interpretare le svariate situazioni dei vostri eventi con bella musica e animazioni", "SERVIZIO", 40, 180.00, "images/download-6.jpg");

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
(124, "Catering");

INSERT INTO TagProdotto VALUES
(123, 1, "03271170361"),
(124, 2, "01602620930");

INSERT INTO RichiestaPreventivo VALUES
(1000, "IULGAE99C23R123R", "01391350129", "Allestimento fiera dello sport", "Polignano a mare", "Un nuovo appuntamento dedicato al mondo del calcio, Calcio Expo, organizzato nella Fortezza da Basso a Firenze e rivolto ad addetti ai lavori, aziende, pubblico di appassionati. Obiettivo dell’evento Calcio Expo è quello di riunire e far incontrare le persone che per professione o per passione sono legate a questo sport. A Calcio Expo parteciperanno squadre, scuole, associazioni, enti e federazioni sportive, dirigenti , allenatori, calciatori di diverse squadre e ancora gestori di centri sportivi, arbitri, sponsor. Ognuna di queste figure avrà l’occasione di confrontarsi su temi quali la competizione, l’agonismo, il divertimento e il fair play, anime di uno sport che in Italia rappresenta lo sport per eccellenza.", "Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pro", 20201230, "RIFIUTATO"),
(1001, "IULGAE99C23R123R", "01602620930", "Allestimento Matrimonio con Ylenia", "Sant'antonio Abate", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur?", null, 20201222, "CONFERMATO"),
(1003, "BRZRTN02H50C293D", "01602620930", "Fiera dell'est", "Lagonegro", "Gregorio Samsa, svegliandosi una mattina da sogni agitati, si trovò trasformato, nel suo letto, in un enorme insetto immondo. Riposava sulla schiena, dura come una corazza, e sollevando un poco il capo vedeva il suo ventre arcuato, bruno e diviso in tanti segmenti ricurvi, in cima a cui la coperta da letto, vicina a scivolar giù tutta, si manteneva a fatica. Le gambe, numerose e sottili da far pietà, rispetto alla sua corporatura normale, tremolavano senza tregua in un confuso luccichio dinanzi ai suoi occhi. Cosa m’è avvenuto? pensò. Non era un sogno. La sua camera, una stanzetta di giuste proporzioni, soltanto un po’ piccola, se ne stava tranquilla fra le quattro ben note pareti.", null, 20201124, "CONFERMATO"),
(1004, "BRZRTN02H50C293D", "01391350129", "Concerto", "Sarno", "In una terra lontana, dietro le montagne Parole, lontani dalle terre di Vocalia e Consonantia, vivono i testi casuali. Vivono isolati nella cittadina di Lettere, sulle coste del Semantico, un immenso oceano linguistico. Un piccolo ruscello chiamato Devoto Oli attraversa quei luoghi, rifornendoli di tutte le regolalie di cui hanno bisogno. È una terra paradismatica, un paese della cuccagna in cui golose porzioni di proposizioni arrostite volano in bocca a chi le desideri. Non una volta i testi casuali sono stati dominati dall’onnipotente Interpunzione, una vita davvero non ortografica. Un giorno però accadde che la piccola riga di un testo casuale, di nome Lorem ipsum, decise di andare a espl", "Ma la volpe col suo balzo ha raggiunto il quieto Fido. Quel vituperabile xenofobo zelante assaggia il whisky ed esclama: alleluja! Aquel vituperable xenófobo apasionado prueba su güisqui y exclama: ¡A", 20210113, "IN_ATTESA");

INSERT INTO ProdottoRichiesta VALUES
(4000, 1000, 1, "01391350129", 4, 99.00,  20200130, 20220103),
(4002, 1001, 1, "01602620930", 23, 50.00, 20210303, 20210513),
(4003, 1003, 2, "01602620930", 12, 150.00, 20201202, 20201212),
(4004, 1004, 2, "01391350129", 12, 99.00, 20201124, 20201212);

INSERT INTO Preventivo VALUES
(7000, 1000, "01391350129", "IULGAE99C23R123R", 20200112, 90.00, null),
(7001, 1001, "01602620930", "IULGAE99C23R123R",  20201230, 100.00, "sovraccarico prezzo di servizi aggiuntivi"),
(7002, 1003, "01602620930", "BRZRTN02H50C293D", 20201124, 150.00, null),
(7003, 1004, "01391350129", "BRZRTN02H50C293D", 20210116, 99.00, null);