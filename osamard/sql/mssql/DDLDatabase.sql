


USE master;  
GO  

CREATE DATABASE osama_raccolta_dati;
GO 
-- GO
use osama_raccolta_dati;
GO 

-- osama_raccolta_dati.dbo.campioni definition

-- Drop table

-- DROP TABLE osama_raccolta_dati.dbo.campioni;

CREATE TABLE osama_raccolta_dati.dbo.campioni (
	id bigint IDENTITY(1,1) NOT NULL,
	nome text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	DISABLED tinyint DEFAULT '0' NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__campioni__3213E83FEC7D1DA5 PRIMARY KEY (id)
);


-- osama_raccolta_dati.dbo.certificazioni_fabbrica definition

-- Drop table

-- DROP TABLE osama_raccolta_dati.dbo.certificazioni_fabbrica;

CREATE TABLE osama_raccolta_dati.dbo.certificazioni_fabbrica (
	id bigint IDENTITY(1,1) NOT NULL,
	nome text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	DISABLED tinyint DEFAULT '0' NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__certific__3213E83FD525B6B6 PRIMARY KEY (id)
);


-- osama_raccolta_dati.dbo.certificazioni_materiali definition

-- Drop table

-- DROP TABLE osama_raccolta_dati.dbo.certificazioni_materiali;

CREATE TABLE osama_raccolta_dati.dbo.certificazioni_materiali (
	id bigint IDENTITY(1,1) NOT NULL,
	nome text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	DISABLED tinyint DEFAULT '0' NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__certific__3213E83FD5E5EE2B PRIMARY KEY (id)
);


-- osama_raccolta_dati.dbo.contatto definition

-- Drop table

-- DROP TABLE osama_raccolta_dati.dbo.contatto;

CREATE TABLE osama_raccolta_dati.dbo.contatto (
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


-- osama_raccolta_dati.dbo.dimensioni definition

-- Drop table

-- DROP TABLE osama_raccolta_dati.dbo.dimensioni;

CREATE TABLE osama_raccolta_dati.dbo.dimensioni (
	id bigint IDENTITY(1,1) NOT NULL,
	nome text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	DISABLED tinyint DEFAULT '0' NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__dimensio__3213E83F7EA33127 PRIMARY KEY (id)
);


-- osama_raccolta_dati.dbo.fornitore_categoria definition

-- Drop table

-- DROP TABLE osama_raccolta_dati.dbo.fornitore_categoria;

CREATE TABLE osama_raccolta_dati.dbo.fornitore_categoria (
	id bigint IDENTITY(1,1) NOT NULL,
	nome text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	DISABLED tinyint DEFAULT 0 NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__fornitor__3213E83F4501F2E7 PRIMARY KEY (id)
);


-- osama_raccolta_dati.dbo.foto_tipo_oggetto definition

-- Drop table

-- DROP TABLE osama_raccolta_dati.dbo.foto_tipo_oggetto;

CREATE TABLE osama_raccolta_dati.dbo.foto_tipo_oggetto (
	id bigint IDENTITY(1,1) NOT NULL,
	nome text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	DISABLED tinyint DEFAULT 0 NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__foto_tip__3213E83F2805FDD8 PRIMARY KEY (id)
);


-- osama_raccolta_dati.dbo.materiale definition

-- Drop table

-- DROP TABLE osama_raccolta_dati.dbo.materiale;

CREATE TABLE osama_raccolta_dati.dbo.materiale (
	id bigint IDENTITY(1,1) NOT NULL,
	nome text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	DISABLED tinyint DEFAULT '0' NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__material__3213E83F662EE09A PRIMARY KEY (id)
);


-- osama_raccolta_dati.dbo.moq definition

-- Drop table

-- DROP TABLE osama_raccolta_dati.dbo.moq;

CREATE TABLE osama_raccolta_dati.dbo.moq (
	id bigint IDENTITY(1,1) NOT NULL,
	nome text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	DISABLED tinyint DEFAULT '0' NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__moq__3213E83FE1C015E9 PRIMARY KEY (id)
);


-- osama_raccolta_dati.dbo.prezzo definition

-- Drop table

-- DROP TABLE osama_raccolta_dati.dbo.prezzo;

CREATE TABLE osama_raccolta_dati.dbo.prezzo (
	id bigint IDENTITY(1,1) NOT NULL,
	nome text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	DISABLED tinyint DEFAULT '0' NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__prezzo__3213E83FA4C0749F PRIMARY KEY (id)
);


-- osama_raccolta_dati.dbo.produzione definition

-- Drop table

-- DROP TABLE osama_raccolta_dati.dbo.produzione;

CREATE TABLE osama_raccolta_dati.dbo.produzione (
	id bigint IDENTITY(1,1) NOT NULL,
	nome text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	DISABLED tinyint DEFAULT 0 NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__produzio__3213E83FC85DB70A PRIMARY KEY (id)
);


-- osama_raccolta_dati.dbo.trading definition

-- Drop table

-- DROP TABLE osama_raccolta_dati.dbo.trading;

CREATE TABLE osama_raccolta_dati.dbo.trading (
	id bigint IDENTITY(1,1) NOT NULL,
	nome text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	DISABLED tinyint DEFAULT 0 NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__trading__3213E83F3F410DC2 PRIMARY KEY (id)
);


-- osama_raccolta_dati.dbo.utente definition

-- Drop table

-- DROP TABLE osama_raccolta_dati.dbo.utente;

CREATE TABLE osama_raccolta_dati.dbo.utente (
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


-- osama_raccolta_dati.dbo.fornitore definition

-- Drop table

-- DROP TABLE osama_raccolta_dati.dbo.fornitore;

CREATE TABLE osama_raccolta_dati.dbo.fornitore (
	id bigint IDENTITY(1,1) NOT NULL,
	ragione_sociale text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	tempo_mercato text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
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
	CONSTRAINT FK_fornitore_contatto FOREIGN KEY (id_contatto) REFERENCES osama_raccolta_dati.dbo.contatto(id),
	CONSTRAINT FK_fornitore_trading FOREIGN KEY (id_trading) REFERENCES osama_raccolta_dati.dbo.trading(id)
);


-- osama_raccolta_dati.dbo.fornitore_certificazioni_fabbrica definition

-- Drop table

-- DROP TABLE osama_raccolta_dati.dbo.fornitore_certificazioni_fabbrica;

CREATE TABLE osama_raccolta_dati.dbo.fornitore_certificazioni_fabbrica (
	id_fornitore bigint NOT NULL,
	id_certificazione bigint NOT NULL,
	CONSTRAINT PK__fornitor__7941109CCB0D393C PRIMARY KEY (id_fornitore,id_certificazione),
	CONSTRAINT FK_certificati_fornitore FOREIGN KEY (id_fornitore) REFERENCES osama_raccolta_dati.dbo.fornitore(id),
	CONSTRAINT FK_fornitore_certificati FOREIGN KEY (id_certificazione) REFERENCES osama_raccolta_dati.dbo.certificazioni_fabbrica(id)
);


-- osama_raccolta_dati.dbo.fornitore_certificazioni_materiali definition

-- Drop table

-- DROP TABLE osama_raccolta_dati.dbo.fornitore_certificazioni_materiali;

CREATE TABLE osama_raccolta_dati.dbo.fornitore_certificazioni_materiali (
	id_fornitore bigint NOT NULL,
	id_certificazione bigint NOT NULL,
	CONSTRAINT PK__fornitor__7941109C91BBF1C3 PRIMARY KEY (id_fornitore,id_certificazione),
	CONSTRAINT FK_certificati_fornitore_materiali FOREIGN KEY (id_fornitore) REFERENCES osama_raccolta_dati.dbo.fornitore(id),
	CONSTRAINT FK_fornitore_certificati_materiali FOREIGN KEY (id_certificazione) REFERENCES osama_raccolta_dati.dbo.certificazioni_materiali(id)
);


-- osama_raccolta_dati.dbo.fornitore_geolocalizzazione definition

-- Drop table

-- DROP TABLE osama_raccolta_dati.dbo.fornitore_geolocalizzazione;

CREATE TABLE osama_raccolta_dati.dbo.fornitore_geolocalizzazione (
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
	CONSTRAINT FK_fornitore_Geolocalizzazione FOREIGN KEY (id_fornitore) REFERENCES osama_raccolta_dati.dbo.fornitore(id)
);


-- osama_raccolta_dati.dbo.fornitore_subcategoria definition

-- Drop table

-- DROP TABLE osama_raccolta_dati.dbo.fornitore_subcategoria;

CREATE TABLE osama_raccolta_dati.dbo.fornitore_subcategoria (
	id bigint IDENTITY(1,1) NOT NULL,
	nome text COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	id_categoria bigint NOT NULL,
	DISABLED tinyint DEFAULT 0 NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__fornitor__3213E83F0ED67887 PRIMARY KEY (id),
	CONSTRAINT FK_categoria FOREIGN KEY (id_categoria) REFERENCES osama_raccolta_dati.dbo.fornitore_categoria(id)
);


-- osama_raccolta_dati.dbo.foto definition

-- Drop table

-- DROP TABLE osama_raccolta_dati.dbo.foto;

CREATE TABLE osama_raccolta_dati.dbo.foto (
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
	CONSTRAINT FK_foto_tipo_Oggetto FOREIGN KEY (id_tipo_oggetto) REFERENCES osama_raccolta_dati.dbo.foto_tipo_oggetto(id)
);


-- osama_raccolta_dati.dbo.pagamento definition

-- Drop table

-- DROP TABLE osama_raccolta_dati.dbo.pagamento;

CREATE TABLE osama_raccolta_dati.dbo.pagamento (
	id bigint NOT NULL,
	id_campione bigint NOT NULL,
	id_produzione bigint NOT NULL,
	DISABLED tinyint DEFAULT '0' NOT NULL,
	DT_INSERIMENTO datetime DEFAULT getdate() NOT NULL,
	DT_MODIFICA datetime DEFAULT getdate() NOT NULL,
	LAST_USER_MODIFIED bigint NOT NULL,
	FIRST_USER bigint NOT NULL,
	CONSTRAINT PK__pagament__52960AC3CA174B31 PRIMARY KEY (id_campione,id_produzione),
	CONSTRAINT FK_pagamento_campioni2 FOREIGN KEY (id_campione) REFERENCES osama_raccolta_dati.dbo.campioni(id),
	CONSTRAINT FK_pagamento_produzione2 FOREIGN KEY (id_produzione) REFERENCES osama_raccolta_dati.dbo.produzione(id)
);


-- osama_raccolta_dati.dbo.prodotto definition

-- Drop table

-- DROP TABLE osama_raccolta_dati.dbo.prodotto;

CREATE TABLE osama_raccolta_dati.dbo.prodotto (
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
	CONSTRAINT FK_prodotto_materiale FOREIGN KEY (id_materiale) REFERENCES osama_raccolta_dati.dbo.materiale(id),
	CONSTRAINT K_prodotto_dimensioni FOREIGN KEY (id_dimensioni) REFERENCES osama_raccolta_dati.dbo.dimensioni(id),
	CONSTRAINT K_prodotto_moq FOREIGN KEY (id_moq) REFERENCES osama_raccolta_dati.dbo.moq(id),
	CONSTRAINT K_prodotto_prezzo FOREIGN KEY (id_prezzo) REFERENCES osama_raccolta_dati.dbo.prezzo(id),
	CONSTRAINT prodotto_FK FOREIGN KEY (id_fornitore) REFERENCES osama_raccolta_dati.dbo.fornitore(id) ON DELETE CASCADE ON UPDATE CASCADE
);


-- osama_raccolta_dati.dbo.fornitore_categoria_subcategoria definition

-- Drop table

-- DROP TABLE osama_raccolta_dati.dbo.fornitore_categoria_subcategoria;

CREATE TABLE osama_raccolta_dati.dbo.fornitore_categoria_subcategoria (
	id bigint IDENTITY(1,1) NOT NULL,
	id_fornitore bigint NOT NULL,
	id_categoria bigint DEFAULT NULL NULL,
	id_subcategoria bigint DEFAULT NULL NULL,
	CONSTRAINT PK__fornitor__3213E83F35074444 PRIMARY KEY (id),
	CONSTRAINT FK_fornitore_categoria_subcategoria FOREIGN KEY (id_fornitore) REFERENCES osama_raccolta_dati.dbo.fornitore(id),
	CONSTRAINT FK_fornitore_categoria_subcategoria_c FOREIGN KEY (id_categoria) REFERENCES osama_raccolta_dati.dbo.fornitore_categoria(id),
	CONSTRAINT FK_fornitore_categoria_subcategoria_s FOREIGN KEY (id_subcategoria) REFERENCES osama_raccolta_dati.dbo.fornitore_subcategoria(id)
);
