











USE master;  
GO  

-- CREATE DATABASE osama_raccolta_dati2;

-- GO
use osama_raccolta_dati;
GO 

-- disable all constraints
EXEC sp_MSforeachtable "ALTER TABLE ? NOCHECK CONSTRAINT all";
GO

--
-- Table structure for table campioni
--

DROP TABLE IF EXISTS campioni;




CREATE TABLE campioni (
  id bigint NOT NULL IDENTITY(1,1),
  nome text NOT NULL,
  DISABLED tinyint NOT NULL DEFAULT '0',
  DT_INSERIMENTO datetime NOT NULL DEFAULT GETDATE(),
  DT_MODIFICA datetime NOT NULL DEFAULT GETDATE(),
  LAST_USER_MODIFIED bigint NOT NULL,
  FIRST_USER bigint NOT NULL,
  PRIMARY KEY (id)
);

GO



--
-- Dumping data for table campioni
--

-- SET IDENTITY_INSERT campioni ON;
-- GO


-- INSERT INTO campioni (id, nome, DISABLED, DT_INSERIMENTO, DT_MODIFICA, LAST_USER_MODIFIED, FIRST_USER) VALUES (1,'Free',0,'2023-03-03 16:30:34','2023-03-03 16:30:34',1,1),(2,'Real cost',0,'2023-03-03 16:30:34','2023-03-03 16:30:34',1,1),(3,'Double than real',0,'2023-03-03 16:30:34','2023-03-03 16:30:34',1,1);

-- SET IDENTITY_INSERT campioni OFF;
-- GO


--
-- Table structure for table certificazioni_fabbrica
--

DROP TABLE IF EXISTS certificazioni_fabbrica;


CREATE TABLE certificazioni_fabbrica (
  id bigint NOT NULL IDENTITY(1,1),
  nome text NOT NULL,
  DISABLED tinyint NOT NULL DEFAULT '0',
  DT_INSERIMENTO datetime NOT NULL DEFAULT GETDATE(),
  DT_MODIFICA datetime NOT NULL DEFAULT GETDATE(),
  LAST_USER_MODIFIED bigint NOT NULL,
  FIRST_USER bigint NOT NULL,
  PRIMARY KEY (id)
);
GO



--
-- Dumping data for table certificazioni_fabbrica
--

SET IDENTITY_INSERT certificazioni_fabbrica ON;
GO


INSERT INTO certificazioni_fabbrica (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (1,'AUDIT',0,'2023-03-03 16:15:17','2023-03-03 16:15:17',1,1),(2,'BSCI',0,'2023-03-03 16:15:17','2023-03-03 16:15:17',1,1),(3,'SEDEX',0,'2023-03-03 16:15:17','2023-03-03 16:15:17',1,1),(4,'ISO',0,'2023-03-03 16:15:17','2023-03-03 16:15:17',1,1);

SET IDENTITY_INSERT certificazioni_fabbrica OFF;
GO

--
-- Table structure for table certificazioni_materiali
--

DROP TABLE IF EXISTS certificazioni_materiali;


CREATE TABLE certificazioni_materiali (
  id bigint NOT NULL IDENTITY(1,1),
  nome text NOT NULL,
  DISABLED tinyint NOT NULL DEFAULT '0',
  DT_INSERIMENTO datetime NOT NULL DEFAULT GETDATE(),
  DT_MODIFICA datetime NOT NULL DEFAULT GETDATE(),
  LAST_USER_MODIFIED bigint NOT NULL,
  FIRST_USER bigint NOT NULL,
  PRIMARY KEY (id)
);
GO



--
-- Dumping data for table certificazioni_materiali
--

SET IDENTITY_INSERT certificazioni_materiali ON;
GO


INSERT INTO certificazioni_materiali (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (1,'REACH',0,'2023-03-03 16:18:31','2023-03-03 16:18:31',1,1),(2,'OEKO TEX',0,'2023-03-03 16:18:31','2023-03-03 16:18:31',1,1);

SET IDENTITY_INSERT certificazioni_materiali OFF;
GO

--
-- Table structure for table contatto
--

DROP TABLE IF EXISTS contatto;


CREATE TABLE contatto (
  id bigint NOT NULL IDENTITY(1,1),
  nome text NOT NULL,
  posizione text NOT NULL,
  DISABLED tinyint NOT NULL DEFAULT '0',
  DT_INSERIMENTO datetime NOT NULL DEFAULT GETDATE(),
  DT_MODIFICA datetime NOT NULL DEFAULT GETDATE(),
  LAST_USER_MODIFIED bigint NOT NULL,
  FIRST_USER bigint NOT NULL,
  PRIMARY KEY (id)
);
GO




--
-- Table structure for table dimensioni
--

DROP TABLE IF EXISTS dimensioni;


CREATE TABLE dimensioni (
  id bigint NOT NULL IDENTITY(1,1),
  nome text NOT NULL,
  DISABLED tinyint NOT NULL DEFAULT '0',
  DT_INSERIMENTO datetime NOT NULL DEFAULT GETDATE(),
  DT_MODIFICA datetime NOT NULL DEFAULT GETDATE(),
  LAST_USER_MODIFIED bigint NOT NULL,
  FIRST_USER bigint NOT NULL,
  PRIMARY KEY (id)
);
GO



--
-- Dumping data for table dimensioni
--






--
-- Table structure for table fornitore
--

DROP TABLE IF EXISTS fornitore;


CREATE TABLE fornitore (
  id bigint NOT NULL IDENTITY(1,1),
  ragione_sociale text NOT NULL,
  tempo_mercato text NOT NULL,
  id_categoria bigint DEFAULT NULL,
  id_subcategoria bigint DEFAULT NULL,
  fat_tot text NOT NULL,
  fat_it text NOT NULL,
  numero_dipendenti bigint DEFAULT NULL,
  rd_interno tinyint NOT NULL DEFAULT '0',
  id_trading bigint DEFAULT NULL,
  id_contatto bigint DEFAULT NULL,
  DISABLED tinyint NOT NULL DEFAULT '0',
  DT_INSERIMENTO datetime NOT NULL DEFAULT GETDATE(),
  DT_MODIFICA datetime NOT NULL DEFAULT GETDATE(),
  LAST_USER_MODIFIED bigint NOT NULL,
  FIRST_USER bigint NOT NULL,
  PRIMARY KEY (id),
  KEY FK_fornitore_categoria (id_categoria),
  KEY FK_fornitore_subcategoria (id_subcategoria),
  KEY FK_fornitore_trading (id_trading),
  KEY FK_fornitore_contatto (id_contatto),
  CONSTRAINT FK_fornitore_categoria FOREIGN KEY (id_categoria) REFERENCES fornitore_categoria (id),
  CONSTRAINT FK_fornitore_contatto FOREIGN KEY (id_contatto) REFERENCES contatto (id),
  CONSTRAINT FK_fornitore_subcategoria FOREIGN KEY (id_subcategoria) REFERENCES fornitore_subcategoria (id),
  CONSTRAINT FK_fornitore_trading FOREIGN KEY (id_trading) REFERENCES trading (id)
);
GO



--
-- Dumping data for table fornitore
--

SET IDENTITY_INSERT fornitore ON;
GO


INSERT INTO fornitore (id,ragione_sociale,tempo_mercato,id_categoria,id_subcategoria,fat_tot,fat_it,numero_dipendenti,rd_interno,id_trading,id_contatto,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (1,'Rag soc test1','un tempo',NULL,NULL,'100€','100€',50,0,1,7,1,'2023-03-07 08:25:07','2023-03-07 08:25:07',1,1),(2,'Rag soc test1','un tempo',NULL,NULL,'100€','100€',50,0,1,8,1,'2023-03-07 08:35:07','2023-03-07 08:35:07',1,1),(3,'Rag soc test1','un tempo',NULL,NULL,'100€','100€',50,0,1,9,0,'2023-03-07 11:51:05','2023-03-07 11:51:05',1,1),(4,'Rag soc test1','un tempo',NULL,NULL,'100€','100€',50,0,1,10,0,'2023-03-07 13:17:29','2023-03-07 13:17:29',1,1),(5,'Rag soc test1','un tempo',NULL,NULL,'100€','100€',50,0,1,11,0,'2023-03-07 13:30:48','2023-03-07 13:30:48',1,1),(6,'Rag soc test1','un tempo',NULL,NULL,'100€','100€',50,0,1,12,0,'2023-03-07 13:32:52','2023-03-07 13:32:52',1,1),(7,'Rag soc test1','un tempo',NULL,NULL,'100€','100€',50,0,1,13,0,'2023-03-07 13:37:51','2023-03-07 13:37:51',1,1);

SET IDENTITY_INSERT fornitore OFF;
GO

--
-- Table structure for table fornitore_categoria
--

DROP TABLE IF EXISTS fornitore_categoria;


CREATE TABLE fornitore_categoria (
  id bigint NOT NULL IDENTITY(1,1),
  nome text NOT NULL,
  DISABLED tinyint NOT NULL DEFAULT '0',
  DT_INSERIMENTO datetime NOT NULL DEFAULT GETDATE(),
  DT_MODIFICA datetime NOT NULL DEFAULT GETDATE(),
  LAST_USER_MODIFIED bigint NOT NULL,
  FIRST_USER bigint NOT NULL,
  PRIMARY KEY (id)
);
GO



--
-- Dumping data for table fornitore_categoria
--

SET IDENTITY_INSERT fornitore_categoria ON;
GO


INSERT INTO fornitore_categoria (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (1,'Writing',0,'2023-03-03 16:24:52','2023-03-03 16:24:52',1,1),(2,'Accessori scrittura',0,'2023-03-03 16:24:52','2023-03-03 16:24:52',1,1),(3,'Diary / Notes',0,'2023-03-03 16:24:52','2023-03-03 16:24:52',1,1),(4,'Living',0,'2023-03-03 16:24:52','2023-03-03 16:24:52',1,1),(5,'Accessori / Casalinghi ',0,'2023-03-03 16:24:52','2023-03-03 16:24:52',1,1),(6,'Arredo casa',0,'2023-03-03 16:24:52','2023-03-03 16:24:52',1,1),(7,'Storage',0,'2023-03-03 16:24:52','2023-03-03 16:24:52',1,1),(8,'Scatole / Gif Box',0,'2023-03-03 16:24:52','2023-03-03 16:24:52',1,1),(9,'Bags / Accessories',0,'2023-03-03 16:24:52','2023-03-03 16:24:52',1,1);

SET IDENTITY_INSERT fornitore_categoria OFF;
GO

--
-- Table structure for table fornitore_certificati
--

DROP TABLE IF EXISTS fornitore_certificati;


CREATE TABLE fornitore_certificati (
  id_fornitore bigint NOT NULL,
  id_certificazione bigint NOT NULL,
  PRIMARY KEY (id_fornitore,id_certificazione),
  KEY FK_fornitore_certificati (id_certificazione),
  CONSTRAINT FK_certificati_fornitore FOREIGN KEY (id_fornitore) REFERENCES fornitore (id),
  CONSTRAINT FK_fornitore_certificati FOREIGN KEY (id_certificazione) REFERENCES certificazioni_fabbrica (id)
);
GO



--
-- Dumping data for table fornitore_certificati
--






--
-- Table structure for table fornitore_geolocalizzazione
--

DROP TABLE IF EXISTS fornitore_geolocalizzazione;


CREATE TABLE fornitore_geolocalizzazione (
  id bigint NOT NULL IDENTITY(1,1),
  id_fornitore bigint NOT NULL,
  area text NOT NULL,
  citta text NOT NULL,
  DISABLED tinyint NOT NULL DEFAULT '0',
  DT_INSERIMENTO datetime NOT NULL DEFAULT GETDATE(),
  DT_MODIFICA datetime NOT NULL DEFAULT GETDATE(),
  LAST_USER_MODIFIED bigint NOT NULL,
  FIRST_USER bigint NOT NULL,
  PRIMARY KEY (id),
  KEY FK_fornitore_Geolocalizzazione (id_fornitore),
  CONSTRAINT FK_fornitore_Geolocalizzazione FOREIGN KEY (id_fornitore) REFERENCES fornitore (id)
);
GO



--
-- Dumping data for table fornitore_geolocalizzazione
--






--
-- Table structure for table fornitore_subcategoria
--

DROP TABLE IF EXISTS fornitore_subcategoria;


CREATE TABLE fornitore_subcategoria (
  id bigint NOT NULL IDENTITY(1,1),
  nome text NOT NULL,
  id_categoria bigint NOT NULL,
  DISABLED tinyint NOT NULL DEFAULT '0',
  DT_INSERIMENTO datetime NOT NULL DEFAULT GETDATE(),
  DT_MODIFICA datetime NOT NULL DEFAULT GETDATE(),
  LAST_USER_MODIFIED bigint NOT NULL,
  FIRST_USER bigint NOT NULL,
  PRIMARY KEY (id),
  KEY FK_categoria (id_categoria),
  CONSTRAINT FK_categoria FOREIGN KEY (id_categoria) REFERENCES fornitore_categoria (id)
);
GO



--
-- Dumping data for table fornitore_subcategoria
--

SET IDENTITY_INSERT fornitore_subcategoria ON;
GO


INSERT INTO fornitore_subcategoria  (id,nome,id_categoria,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (1,'Penne',1,0,'2023-03-03 16:28:01','2023-03-03 16:28:01',1,1),(2,'Pennarelli',1,0,'2023-03-03 16:28:01','2023-03-03 16:28:01',1,1),(3,'Matite',1,0,'2023-03-03 16:28:01','2023-03-03 16:28:01',1,1),(4,'Correttori',1,0,'2023-03-03 16:28:01','2023-03-03 16:28:01',1,1),(5,'Towel - Spugna',4,0,'2023-03-03 16:28:01','2023-03-03 16:28:01',1,1),(6,'Bed sheet',4,0,'2023-03-03 16:28:01','2023-03-03 16:28:01',1,1),(7,'Tableware',4,0,'2023-03-03 16:28:01','2023-03-03 16:28:01',1,1);

SET IDENTITY_INSERT fornitore_subcategoria OFF;
GO

--
-- Table structure for table foto
--

DROP TABLE IF EXISTS foto;


CREATE TABLE foto (
  id bigint NOT NULL IDENTITY(1,1),
  titolo text NOT NULL,
  path_file text NOT NULL,
  id_oggetto bigint NOT NULL,
  id_tipo_oggetto bigint NOT NULL,
  DISABLED tinyint NOT NULL DEFAULT '0',
  DT_INSERIMENTO datetime NOT NULL DEFAULT GETDATE(),
  DT_MODIFICA datetime NOT NULL DEFAULT GETDATE(),
  LAST_USER_MODIFIED bigint NOT NULL,
  FIRST_USER bigint NOT NULL,
  PRIMARY KEY (id),
  KEY FK_foto_tipo_Oggetto (id_tipo_oggetto),
  CONSTRAINT FK_foto_tipo_Oggetto FOREIGN KEY (id_tipo_oggetto) REFERENCES foto_tipo_oggetto (id)
);
GO



--
-- Dumping data for table foto
--






--
-- Table structure for table foto_tipo_oggetto
--

DROP TABLE IF EXISTS foto_tipo_oggetto;


CREATE TABLE foto_tipo_oggetto (
  id bigint NOT NULL IDENTITY(1,1),
  nome text NOT NULL,
  DISABLED tinyint NOT NULL DEFAULT '0',
  DT_INSERIMENTO datetime NOT NULL DEFAULT GETDATE(),
  DT_MODIFICA datetime NOT NULL DEFAULT GETDATE(),
  LAST_USER_MODIFIED bigint NOT NULL,
  FIRST_USER bigint NOT NULL,
  PRIMARY KEY (id)
);
GO



--
-- Dumping data for table foto_tipo_oggetto
--

SET IDENTITY_INSERT foto_tipo_oggetto ON;
GO


INSERT INTO foto_tipo_oggetto (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (1,'fornitore',0,'2023-03-06 15:00:02','2023-03-06 15:00:02',1,1),(2,'prodotto',0,'2023-03-06 15:00:02','2023-03-06 15:00:02',1,1);

SET IDENTITY_INSERT foto_tipo_oggetto OFF;
GO

--
-- Table structure for table materiale
--

DROP TABLE IF EXISTS materiale;


CREATE TABLE materiale (
  id bigint NOT NULL IDENTITY(1,1),
  nome text NOT NULL,
  DISABLED tinyint NOT NULL DEFAULT '0',
  DT_INSERIMENTO datetime NOT NULL DEFAULT GETDATE(),
  DT_MODIFICA datetime NOT NULL DEFAULT GETDATE(),
  LAST_USER_MODIFIED bigint NOT NULL,
  FIRST_USER bigint NOT NULL,
  PRIMARY KEY (id)
);
GO



--
-- Dumping data for table materiale
--






--
-- Table structure for table moq
--

DROP TABLE IF EXISTS moq;


CREATE TABLE moq (
  id bigint NOT NULL IDENTITY(1,1),
  nome text NOT NULL,
  DISABLED tinyint NOT NULL DEFAULT '0',
  DT_INSERIMENTO datetime NOT NULL DEFAULT GETDATE(),
  DT_MODIFICA datetime NOT NULL DEFAULT GETDATE(),
  LAST_USER_MODIFIED bigint NOT NULL,
  FIRST_USER bigint NOT NULL,
  PRIMARY KEY (id)
);
GO



--
-- Dumping data for table moq
--

SET IDENTITY_INSERT moq ON;
GO


INSERT INTO moq (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (1,'Per articolo',0,'2023-03-03 16:29:22','2023-03-03 16:29:22',1,1),(2,'Per colore',0,'2023-03-03 16:29:22','2023-03-03 16:29:22',1,1),(3,'Per Taglia',0,'2023-03-03 16:29:22','2023-03-03 16:29:22',1,1),(4,'Per ordine di acquisto',0,'2023-03-03 16:29:22','2023-03-03 16:29:22',1,1),(5,'Per spedizione',0,'2023-03-03 16:29:22','2023-03-03 16:29:22',1,1);

SET IDENTITY_INSERT moq OFF;
GO

--
-- Table structure for table pagamento
--

DROP TABLE IF EXISTS pagamento;


CREATE TABLE pagamento (
  id bigint NOT NULL,
  id_campione bigint NOT NULL,
  id_produzione bigint NOT NULL,
  DISABLED tinyint NOT NULL DEFAULT '0',
  DT_INSERIMENTO datetime NOT NULL DEFAULT GETDATE(),
  DT_MODIFICA datetime NOT NULL DEFAULT GETDATE(),
  LAST_USER_MODIFIED bigint NOT NULL,
  FIRST_USER bigint NOT NULL,
  PRIMARY KEY (id_campione,id_produzione),
  KEY FK_pagamento_produzione (id_produzione),
  CONSTRAINT FK_pagamento_campioni FOREIGN KEY (id_campione) REFERENCES campioni (id),
  CONSTRAINT FK_pagamento_produzione FOREIGN KEY (id_produzione) REFERENCES produzione (id)
);
GO



--
-- Dumping data for table pagamento
--






--
-- Table structure for table prezzo
--

DROP TABLE IF EXISTS prezzo;


CREATE TABLE prezzo (
  id bigint NOT NULL IDENTITY(1,1),
  nome text NOT NULL,
  DISABLED tinyint NOT NULL DEFAULT '0',
  DT_INSERIMENTO datetime NOT NULL DEFAULT GETDATE(),
  DT_MODIFICA datetime NOT NULL DEFAULT GETDATE(),
  LAST_USER_MODIFIED bigint NOT NULL,
  FIRST_USER bigint NOT NULL,
  PRIMARY KEY (id)
);
GO



--
-- Dumping data for table prezzo
--






--
-- Table structure for table prodotto
--

DROP TABLE IF EXISTS prodotto;


CREATE TABLE prodotto (
  id bigint NOT NULL IDENTITY(1,1),
  cod_articolo text NOT NULL,
  id_materiale bigint DEFAULT NULL,
  id_dimensioni bigint DEFAULT NULL,
  id_moq bigint DEFAULT NULL,
  id_prezzo bigint DEFAULT NULL,
  DISABLED tinyint NOT NULL DEFAULT '0',
  DT_INSERIMENTO datetime NOT NULL DEFAULT GETDATE(),
  DT_MODIFICA datetime NOT NULL DEFAULT GETDATE(),
  LAST_USER_MODIFIED bigint NOT NULL,
  FIRST_USER bigint NOT NULL,
  id_fornitore bigint NOT NULL,
  PRIMARY KEY (id),
  KEY FK_prodotto_materiale (id_materiale),
  KEY K_prodotto_dimensioni (id_dimensioni),
  KEY K_prodotto_moq (id_moq),
  KEY K_prodotto_prezzo (id_prezzo),
  KEY prodotto_FK (id_fornitore),
  CONSTRAINT FK_prodotto_materiale FOREIGN KEY (id_materiale) REFERENCES materiale (id),
  CONSTRAINT K_prodotto_dimensioni FOREIGN KEY (id_dimensioni) REFERENCES dimensioni (id),
  CONSTRAINT K_prodotto_moq FOREIGN KEY (id_moq) REFERENCES moq (id),
  CONSTRAINT K_prodotto_prezzo FOREIGN KEY (id_prezzo) REFERENCES prezzo (id),
  CONSTRAINT prodotto_FK FOREIGN KEY (id_fornitore) REFERENCES fornitore (id) ON DELETE CASCADE ON UPDATE CASCADE
);
GO



--
-- Dumping data for table prodotto
--

--
-- Table structure for table produzione
--

DROP TABLE IF EXISTS produzione;


CREATE TABLE produzione (
  id bigint NOT NULL IDENTITY(1,1),
  nome text NOT NULL,
  DISABLED tinyint NOT NULL DEFAULT '0',
  DT_INSERIMENTO datetime NOT NULL DEFAULT GETDATE(),
  DT_MODIFICA datetime NOT NULL DEFAULT GETDATE(),
  LAST_USER_MODIFIED bigint NOT NULL,
  FIRST_USER bigint NOT NULL,
  PRIMARY KEY (id)
);
GO



--
-- Dumping data for table produzione
--

SET IDENTITY_INSERT produzione ON;
GO


INSERT INTO produzione (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (1,'TT deposit',0,'2023-03-03 16:32:02','2023-03-03 16:32:02',1,1),(2,'LC',0,'2023-03-03 16:32:02','2023-03-03 16:32:02',1,1),(3,'30% deposit + 70% against BL',0,'2023-03-03 16:32:02','2023-03-03 16:32:02',1,1),(4,'30gg after goods arrival',0,'2023-03-03 16:32:02','2023-03-03 16:32:02',1,1),(5,'60gg after goods arrival',0,'2023-03-03 16:32:02','2023-03-03 16:32:02',1,1);


SET IDENTITY_INSERT produzione OFF;
GO
--
-- Table structure for table trading
--

DROP TABLE IF EXISTS trading;


CREATE TABLE trading (
  id bigint NOT NULL IDENTITY(1,1),
  nome text NOT NULL,
  DISABLED tinyint NOT NULL DEFAULT '0',
  DT_INSERIMENTO datetime NOT NULL DEFAULT GETDATE(),
  DT_MODIFICA datetime NOT NULL DEFAULT GETDATE(),
  LAST_USER_MODIFIED bigint NOT NULL,
  FIRST_USER bigint NOT NULL,
  PRIMARY KEY (id)
);
GO



--
-- Dumping data for table trading
--

SET IDENTITY_INSERT trading ON;
GO


INSERT INTO trading (id,nome,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (1,'Fabrica',0,'2023-03-03 16:12:58','2023-03-03 16:12:58',1,1),(2,'Real Maker',0,'2023-03-03 16:12:58','2023-03-03 16:12:58',1,1);

SET IDENTITY_INSERT trading OFF;
GO

--
-- Table structure for table utente
--

DROP TABLE IF EXISTS utente;


CREATE TABLE utente (
  id bigint NOT NULL IDENTITY(1,1),
  username varchar(50) NOT NULL,
  nome varchar(50) NOT NULL,
  cognome varchar(50) NOT NULL,
  email varchar(45) NOT NULL,
  password varchar(100) NOT NULL,
  DISABLED tinyint NOT NULL DEFAULT '0',
  DT_INSERIMENTO datetime NOT NULL DEFAULT GETDATE(),
  DT_MODIFICA datetime NOT NULL DEFAULT GETDATE(),
  LAST_USER_MODIFIED bigint NOT NULL,
  FIRST_USER bigint NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY email (email)
);
GO



--
-- Dumping data for table utente
--

SET IDENTITY_INSERT utente ON;
GO


INSERT INTO utente (id,username,nome,cognome,email,password,DISABLED,DT_INSERIMENTO,DT_MODIFICA,LAST_USER_MODIFIED,FIRST_USER) VALUES (1,'ANdreaTest','Andrea','Zamma','andrea.zammataro@kedos-srl.it','{SHA}a94a8fe5ccb19ba61c4c0873d391e987982fbbd3',0,'2023-03-02 16:52:06','2023-03-02 16:52:06',1,1);

SET IDENTITY_INSERT utente OFF;
GO


GO
-- enable all constraints
exec sp_MSforeachtable @command1="print '?'", @command2="ALTER TABLE ? WITH CHECK CHECK CONSTRAINT all";


GO
--
-- Dumping events for database 'osama_raccolta_dati'
--

--
-- Dumping routines for database 'osama_raccolta_dati'
--










-- Dump completed on 2023-03-07 16:25:58
