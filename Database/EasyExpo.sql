Drop Database if exists EasyExpo;
CREATE DATABASE EasyExpo;
use EasyExpo;

CREATE TABLE Cliente(
	codiceFiscale varchar(16) not null primary key,
    nome varchar(30) not null,
    cognome varchar(30) not null,
    telefono bigint unsigned,
    luogoUbicazione varchar(30),
    email varchar(50) not null,
    password varchar(512) not null
);

CREATE TABLE Fornitore(
	partitaIva varchar(11) not null primary key,
    nome varchar(30) not null,
    cognome varchar(30) not null,
    telefono bigint unsigned,
    luogoUbicazione varchar(30),
    email varchar(50) not null,
	password varchar(512) not null,
    ragioneSociale varchar(30) not null
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
    tipo ENUM('servizio', 'attrezzatura'),
    quantita int not null,
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
    primary key(idTag, idProdotto, partitaIva),
	foreign key(idTag) references Tag(idTag)
    on delete cascade
    on update cascade,
	foreign key(idProdotto) references Prodotto(idProdotto)
    on delete cascade
    on update cascade,
    foreign key(partitaIva) references Fornitore(partitaIva)
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
    stato ENUM('in attesa', 'confermato', 'rifiutato') not null,
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
    numColli int not null,
    dataInizioNoleggio date not null,
    dataFineNoleggio date not null,
    foreign key(idRichiesta) references RichiestaPreventivo(idRichiesta)
    on delete cascade
    on update cascade,
    foreign key(idProdotto) references Prodotto(idProdotto)
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
	numeroCarta bigint unsigned not null primary key,
    partitaIva varchar(11) not null,
    nomeIntestatario varchar(50) not null,
    dataScadenza date not null,
    cvv int not null,
    foreign key(partitaIva) references Fornitore(partitaIva)
    on delete cascade
    on update cascade
);

INSERT INTO Cliente VALUES
("QTTMCR53R61E406B", "Mariacristina", "Quattroquarti", 3890720375, "Lagnasco", "quattroquarti@gmail.com", sha2('Cristina99', 512)),
("BRZRTN02H50C293D","Viola","Criscuoli", 3498364820, "Ponza", "violetta@gmail.com", sha2('iolaCri00', 512)),
("IULGAE99C23R123R", "Gaetano", "Iuliano", 3998765987, "Terzigno", "gaetano99@gmail.com", sha2('gae99*', 512));

INSERT INTO Fornitore VALUES
("03271170361", "Susanna", "Zaidane", 3249878965, "Modena", "zaidane68a@mailstop.it", sha2('SusannaZ68', 512), "privato"),
("01391350129","Filomena","Blevi", 3778254760, "Pulsano", "filly@gmail.com", sha2('FilBlevi78', 512), "privato"),
("01602620930", "Nicola", "Bortuzzo", 3934567659, "Pordenone", "absvirgilio.it", sha2('AziendaAbs*', 512), "Abs Snc");

INSERT INTO Admin VALUES
("lucrezia.robustelli@gmail.com", sha2('lucry00*', 512)),
("katia.monaco@gmail.com", sha2('katia99', 512)),
("gaetano99@virgilio.it", sha2('GaeIu66', 512)),
("peppe.avino@gmail.com", sha2('peppino34_', 512)),
("davidepappa@virgilio.it", sha2('davide.45', 512)),
("strumolos@virgilio.it", sha2('sabatinostrumolo*', 512));

INSERT INTO Prodotto VALUES
(1, "01391350129", "Casse amplificatori da palco", "Il set altoparlanti Fenton SPB-8 e' composto da una cassa attiva e da una passiva e garantisce un sound potente dall'ottima pressione audio. La struttura robusta della coppia di altoparlanti, composta da un telaio in MDF e pratiche maniglie nella parte superiore, ne consente il trasporto e l'utilizzo anche all'aperto.", "attrezzatura", 5),
(1, "01602620930", "Catering", "Una certezza nell’organizzazione catering per i vostri eventi. Grazie alla competenza ventennale acquisita, in grado di operare miscelando professionalita', esperienza, attenzione e armonia per trasformare un ricevimento, una festa o un evento in un giorno indimenticabile. Il cliente viene seguito in tutte le fasi, dalla scelta della location alla cura dell’atmosfera e del tema dell’evento, alla creazione del menu'. Il tutto all’insegna dell’innovazione artistica e del buon gusto, spaziando tra Ville d’Epoca e Castelli, case private, sedi di aziende, Centri Congressuali e molto altro ancora.", "servizio", 9),
(2, "01602620930", "Cassa musicale per feste", "McGrey, DJ Party altoparlante 2x300W coppia, efficienza ancora maggiore, di nuova concezione bassi i driver chiave di volta, nuova progettazione in legno", "attrezzatura", 50),
(1, "03271170361", "Servizio di Dj", "Un servizio perfetto: mi occupo della musica per le sfilate e delle promozioni per le feste. Affidatevi a me perche' so interpretare le svariate situazioni dei vostri eventi con bella musica e animazioni", "servizio", 40);

INSERT INTO Abbonamento VALUES
(1,"01391350129", 20191101, 20191201),
(2,"01391350129", 20190605, 20190705),
(3,"03271170361", 20200713, 20200813);

INSERT INTO MetodoPagamento VALUES
("1452896574587589", "03271170361", "Susanna Zaidane", 20221210, "523"),
("8000425678567582", "01391350129", "Filomena Blevi", 20230925, "412"),
("4522656596232265", "01391350129", "Filomena Blevi", 20200514, "278"),
("1232566511515165", "01602620930", "Nicola Bortuzzo", 20230612, "148");

INSERT INTO Tag VALUES
(123, "Musica"),
(124, "Catering");

INSERT INTO TagProdotto VALUES
(123, 1, "01391350129"),
(124, 2, "01602620930");


