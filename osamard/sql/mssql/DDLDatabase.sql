


USE master;  
GO  

CREATE DATABASE osama_raccolta_dati;
GO 
-- GO
use osama_raccolta_dati;
GO 


-- campioni definition

-- Drop table

-- DROP TABLE campioni;

CREATE TABLE campioni (
	id bigint IDENTITY(1,1) NOT NULL,
	nome text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	DISABLED tinyint DEFAULT '0' NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__campioni__3213E83FEC7D1DA5 PRIMARY KEY (id)
);


-- certificazioni_fabbrica definition

-- Drop table

-- DROP TABLE certificazioni_fabbrica;

CREATE TABLE certificazioni_fabbrica (
	id bigint IDENTITY(1,1) NOT NULL,
	nome text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	DISABLED tinyint DEFAULT '0' NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__certific__3213E83FD525B6B6 PRIMARY KEY (id)
);


-- certificazioni_materiali definition

-- Drop table

-- DROP TABLE certificazioni_materiali;

CREATE TABLE certificazioni_materiali (
	id bigint IDENTITY(1,1) NOT NULL,
	nome text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	DISABLED tinyint DEFAULT '0' NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__certific__3213E83FD5E5EE2B PRIMARY KEY (id)
);


-- contatto definition

-- Drop table

-- DROP TABLE contatto;

CREATE TABLE contatto (
	id bigint IDENTITY(1,1) NOT NULL,
	nome text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	posizione text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	DISABLED tinyint DEFAULT '0' NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__contatto__3213E83FC620BB76 PRIMARY KEY (id)
);


-- dimensioni definition

-- Drop table

-- DROP TABLE dimensioni;

CREATE TABLE dimensioni (
	id bigint IDENTITY(1,1) NOT NULL,
	nome text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	DISABLED tinyint DEFAULT '0' NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__dimensio__3213E83F7EA33127 PRIMARY KEY (id)
);


-- fornitore_categoria definition

-- Drop table

-- DROP TABLE fornitore_categoria;

CREATE TABLE fornitore_categoria (
	id bigint IDENTITY(1,1) NOT NULL,
	nome text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	DISABLED tinyint DEFAULT 0 NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__fornitor__3213E83F4501F2E7 PRIMARY KEY (id)
);


-- foto_tipo_oggetto definition

-- Drop table

-- DROP TABLE foto_tipo_oggetto;

CREATE TABLE foto_tipo_oggetto (
	id bigint IDENTITY(1,1) NOT NULL,
	nome text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	DISABLED tinyint DEFAULT 0 NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__foto_tip__3213E83F2805FDD8 PRIMARY KEY (id)
);


-- materiale definition

-- Drop table

-- DROP TABLE materiale;

CREATE TABLE materiale (
	id bigint IDENTITY(1,1) NOT NULL,
	nome text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	DISABLED tinyint DEFAULT '0' NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__material__3213E83F662EE09A PRIMARY KEY (id)
);


-- moq definition

-- Drop table

-- DROP TABLE moq;

CREATE TABLE moq (
	id bigint IDENTITY(1,1) NOT NULL,
	nome text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	DISABLED tinyint DEFAULT '0' NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__moq__3213E83FE1C015E9 PRIMARY KEY (id)
);


-- prezzo definition

-- Drop table

-- DROP TABLE prezzo;

CREATE TABLE prezzo (
	id bigint IDENTITY(1,1) NOT NULL,
	nome text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	DISABLED tinyint DEFAULT '0' NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__prezzo__3213E83FA4C0749F PRIMARY KEY (id)
);


-- produzione definition

-- Drop table

-- DROP TABLE produzione;

CREATE TABLE produzione (
	id bigint IDENTITY(1,1) NOT NULL,
	nome text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	DISABLED tinyint DEFAULT 0 NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__produzio__3213E83FC85DB70A PRIMARY KEY (id)
);


-- trading definition

-- Drop table

-- DROP TABLE trading;

CREATE TABLE trading (
	id bigint IDENTITY(1,1) NOT NULL,
	nome text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	DISABLED tinyint DEFAULT 0 NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__trading__3213E83F3F410DC2 PRIMARY KEY (id)
);


-- utente definition

-- Drop table

-- DROP TABLE utente;

CREATE TABLE utente (
	id bigint IDENTITY(1,1) NOT NULL,
	username varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	nome varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	cognome varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	email varchar(45) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	password varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	DISABLED tinyint DEFAULT '0' NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__utente__3213E83FC7FA533C PRIMARY KEY (id),
	CONSTRAINT UQ__utente__AB6E61641019D6F5 UNIQUE (email)
);


-- fornitore_subcategoria definition

-- Drop table

-- DROP TABLE fornitore_subcategoria;

CREATE TABLE fornitore_subcategoria (
	id bigint IDENTITY(1,1) NOT NULL,
	nome text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	id_categoria bigint NOT NULL,
	DISABLED tinyint DEFAULT 0 NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__fornitor__3213E83F0ED67887 PRIMARY KEY (id),
	CONSTRAINT FK_categoria FOREIGN KEY (id_categoria) REFERENCES fornitore_categoria(id)
);


-- foto definition

-- Drop table

-- DROP TABLE foto;

CREATE TABLE foto (
	id bigint IDENTITY(1,1) NOT NULL,
	titolo text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	path_file text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	id_oggetto bigint NOT NULL,
	id_tipo_oggetto bigint NOT NULL,
	DISABLED tinyint DEFAULT '0' NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT FK_foto_tipo_Oggetto FOREIGN KEY (id_tipo_oggetto) REFERENCES foto_tipo_oggetto(id)
);


-- pagamento definition

-- Drop table

-- DROP TABLE pagamento;

CREATE TABLE pagamento (
	id bigint NOT NULL,
	id_campione bigint NOT NULL,
	id_produzione bigint NOT NULL,
	DISABLED tinyint DEFAULT '0' NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__pagament__52960AC3CA174B31 PRIMARY KEY (id_campione,id_produzione),
	CONSTRAINT FK_pagamento_campioni2 FOREIGN KEY (id_campione) REFERENCES campioni(id),
	CONSTRAINT FK_pagamento_produzione2 FOREIGN KEY (id_produzione) REFERENCES produzione(id)
);


-- fornitore definition

-- Drop table

-- DROP TABLE fornitore;

CREATE TABLE fornitore (
	id bigint IDENTITY(1,1) NOT NULL,
	ragione_sociale text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	tempo_mercato text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	id_categoria bigint DEFAULT NULL NULL,
	id_subcategoria bigint DEFAULT NULL NULL,
	fat_tot text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	fat_it text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	numero_dipendenti bigint DEFAULT NULL NULL,
	rd_interno tinyint DEFAULT '0' NOT NULL,
	id_trading bigint DEFAULT NULL NULL,
	id_contatto bigint DEFAULT NULL NULL,
	DISABLED tinyint DEFAULT '0' NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__fornitor__3213E83FA9EE80F2 PRIMARY KEY (id),
	CONSTRAINT FK_fornitore_categoria FOREIGN KEY (id_categoria) REFERENCES fornitore_categoria(id),
	CONSTRAINT FK_fornitore_contatto FOREIGN KEY (id_contatto) REFERENCES contatto(id),
	CONSTRAINT FK_fornitore_subcategoria FOREIGN KEY (id_subcategoria) REFERENCES fornitore_subcategoria(id),
	CONSTRAINT FK_fornitore_trading FOREIGN KEY (id_trading) REFERENCES trading(id)
);


-- fornitore_certificati definition

-- Drop table

-- DROP TABLE fornitore_certificati;

CREATE TABLE fornitore_certificati (
	id_fornitore bigint NOT NULL,
	id_certificazione bigint NOT NULL,
	CONSTRAINT PK__fornitor__7941109CCB0D393C PRIMARY KEY (id_fornitore,id_certificazione),
	CONSTRAINT FK_certificati_fornitore FOREIGN KEY (id_fornitore) REFERENCES fornitore(id),
	CONSTRAINT FK_fornitore_certificati FOREIGN KEY (id_certificazione) REFERENCES certificazioni_fabbrica(id)
);


-- fornitore_geolocalizzazione definition

-- Drop table

-- DROP TABLE fornitore_geolocalizzazione;

CREATE TABLE fornitore_geolocalizzazione (
	id bigint IDENTITY(1,1) NOT NULL,
	id_fornitore bigint NOT NULL,
	area text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	citta text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	DISABLED tinyint DEFAULT '0' NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__fornitor__3213E83F18A2730E PRIMARY KEY (id),
	CONSTRAINT FK_fornitore_Geolocalizzazione FOREIGN KEY (id_fornitore) REFERENCES fornitore(id)
);


-- prodotto definition

-- Drop table

-- DROP TABLE prodotto;

CREATE TABLE prodotto (
	id bigint IDENTITY(1,1) NOT NULL,
	cod_articolo text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	id_materiale bigint DEFAULT NULL NULL,
	id_dimensioni bigint DEFAULT NULL NULL,
	id_moq bigint DEFAULT NULL NULL,
	id_prezzo bigint DEFAULT NULL NULL,
	DISABLED tinyint DEFAULT '0' NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	id_fornitore bigint NOT NULL,
	CONSTRAINT PK__prodotto__3213E83F4189A959 PRIMARY KEY (id),
	CONSTRAINT FK_prodotto_materiale FOREIGN KEY (id_materiale) REFERENCES materiale(id),
	CONSTRAINT K_prodotto_dimensioni FOREIGN KEY (id_dimensioni) REFERENCES dimensioni(id),
	CONSTRAINT K_prodotto_moq FOREIGN KEY (id_moq) REFERENCES moq(id),
	CONSTRAINT K_prodotto_prezzo FOREIGN KEY (id_prezzo) REFERENCES prezzo(id),
	CONSTRAINT prodotto_FK FOREIGN KEY (id_fornitore) REFERENCES fornitore(id) ON DELETE CASCADE ON UPDATE CASCADE
);
