Drop Database if exists EasyExpo;
CREATE DATABASE EasyExpo;
use EasyExpo;

CREATE TABLE Cliente(
	codiceFiscale varchar(16) not null primary key,
    nome varchar(30) not null,
    cognome varchar(30) not null,
    telefono int,
    luogoUbicazione varchar(30),
    password varchar(50) not null,
    email varchar(50) not null
);

CREATE TABLE Fornitore(
	partitaIva varchar(11) not null primary key,
    nome varchar(30) not null,
    cognome varchar(30) not null,
    telefono int,
    luogoUbicazione varchar(30),
	password varchar(50) not null,
    email varchar(50) not null,
    ragioneSociale varchar(30) not null
);

CREATE TABLE Admin(
    email varchar(50) not null primary key,
	password varchar(50) not null
);

CREATE TABLE Prodotto(
	idProdotto int auto_increment not null,
    partitaIva varchar(11) not null,
    titolo varchar(30) not null,
    descrizione varchar(1024) not null,
    prezzo decimal not null,
    tipo varchar(20) not null,
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
    primary key(idTag, idProdotto),
	foreign key(idTag) references Tag(idTag)
    on delete cascade
    on update cascade,
	foreign key(idProdotto) references Prodotto(idProdotto)
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
    prezzo decimal not null,
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
	numeroCarta int not null primary key,
    partitaIva varchar(11) not null,
    nomeIntestatario varchar(50) not null,
    dataScadenza date not null,
    cvv int not null,
    foreign key(partitaIva) references Fornitore(partitaIva)
    on delete cascade
    on update cascade
);