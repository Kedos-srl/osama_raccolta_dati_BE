drop database if exist `osama_raccolta_dati`;
create database `osama_raccolta_dati`;
use `osama_raccolta_dati`;
SET FOREIGN_KEY_CHECKS=0;

-- utente

DROP TABLE IF EXISTS `utente`;

CREATE TABLE `utente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cognome` varchar(50) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB;

-- trading

DROP TABLE IF EXISTS `trading`;

CREATE TABLE `trading` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;


-- produzione

DROP TABLE IF EXISTS `produzione`;

CREATE TABLE `produzione` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;


-- moq

DROP TABLE IF EXISTS `moq`;

CREATE TABLE `moq` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;



-- materiale

DROP TABLE IF EXISTS `materiale`;

CREATE TABLE `materiale` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;


-- foto Tipo Oggetto

DROP TABLE IF EXISTS `foto_tipo_oggetto`;

CREATE TABLE `foto_tipo_oggetto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- foto

DROP TABLE IF EXISTS `foto`;

CREATE TABLE `foto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `titolo` text NOT NULL,
  `path_file` text NOT NULL,
  `id_oggetto` bigint NOT NULL,
  `id_tipo_oggetto` bigint NOT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_foto_tipo_Oggetto` FOREIGN KEY (`id_tipo_oggetto`) REFERENCES `foto_tipo_oggetto` (`id`)
) ENGINE=InnoDB;

-- fornitore categoria

DROP TABLE IF EXISTS `fornitore_categoria`;

CREATE TABLE `fornitore_categoria` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- fornitore subcategoria

DROP TABLE IF EXISTS `fornitore_subcategoria`;

CREATE TABLE `fornitore_subcategoria` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `id_categoria` bigint NOT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `fornitore_categoria` (`id`)
) ENGINE=InnoDB;

-- Fornitore certificati 

DROP TABLE IF EXISTS `fornitore_certificati`;

CREATE TABLE `fornitore_certificati` (
  `id_fornitore` bigint NOT NULL,
  `id_certificazione` bigint NOT NULL,
  PRIMARY KEY (`id_fornitore`,`id_certificazione`),
  CONSTRAINT `FK_fornitore_certificati` FOREIGN KEY (`id_certificazione`) REFERENCES `certificati` (`id`),
  CONSTRAINT `FK_certificati_fornitore` FOREIGN KEY (`id_fornitore`) REFERENCES `fornitore` (`id`)
) ENGINE=InnoDB;

-- dimensioni

DROP TABLE IF EXISTS `dimensioni`;

CREATE TABLE `dimensioni` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- contatto

DROP TABLE IF EXISTS `contatto`;

CREATE TABLE `contatto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `posizione` text NOT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- certificati

DROP TABLE IF EXISTS `certificati`;

CREATE TABLE `certificati` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- campioni

DROP TABLE IF EXISTS `campioni`;

CREATE TABLE `campioni` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

-- prezzo

DROP TABLE IF EXISTS `prezzo`;

CREATE TABLE `prezzo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;


-- pagamento

DROP TABLE IF EXISTS `pagamento`;

CREATE TABLE `pagamento` (
  `id` bigint NOT NULL,
  `id_campione` bigint NOT NULL,
  `id_produzione` bigint NOT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id_campione`,`id_produzione`),
  CONSTRAINT `FK_pagamento_campioni` FOREIGN KEY (`id_campione`) REFERENCES `campioni` (`id`),
  CONSTRAINT `FK_pagamento_produzione` FOREIGN KEY (`id_produzione`) REFERENCES `produzione` (`id`)
) ENGINE=InnoDB;


-- prodotto

DROP TABLE IF EXISTS `prodotto`;

CREATE TABLE `prodotto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cod_articolo` text NOT NULL,
  `id_materiale` bigint DEFAULT null,
  `id_dimensioni` bigint DEFAULT null,
  `id_moq` bigint DEFAULT null,
  `id_prezzo` bigint DEFAULT null,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_prodotto_materiale` FOREIGN KEY (`id_materiale`) REFERENCES `materiale` (`id`),
  CONSTRAINT `K_prodotto_dimensioni` FOREIGN KEY (`id_dimensioni`) REFERENCES `dimensioni` (`id`),
  CONSTRAINT `K_prodotto_moq` FOREIGN KEY (`id_moq`) REFERENCES `moq` (`id`),
  CONSTRAINT `K_prodotto_prezzo` FOREIGN KEY (`id_prezzo`) REFERENCES `prezzo` (`id`)
) ENGINE=InnoDB;

-- fornitore

DROP TABLE IF EXISTS `fornitore`;

CREATE TABLE `fornitore` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ragione_sociale` text NOT NULL,
  `tempo_mercato` text NOT NULL,
  `id_categoria` bigint DEFAULT null,
  `id_subcategoria` bigint DEFAULT null,
  `fat_tot` text NOT NULL,  
  `fat_it` text NOT NULL,
  `numero_dipendenti` bigint DEFAULT null,
  `rd_interno` tinyint(1) NOT NULL DEFAULT '0',
  `id_trading` bigint DEFAULT null,
  `id_contatto` bigint DEFAULT null,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_fornitore_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `fornitore_categoria` (`id`),
  CONSTRAINT `FK_fornitore_subcategoria` FOREIGN KEY (`id_subcategoria`) REFERENCES `fornitore_subcategoria` (`id`),
  CONSTRAINT `FK_fornitore_trading` FOREIGN KEY (`id_trading`) REFERENCES `trading` (`id`),
  CONSTRAINT `FK_fornitore_contatto` FOREIGN KEY (`id_contatto`) REFERENCES `contatto` (`id`)
) ENGINE=InnoDB;

-- fornitore geolocalizzazione

DROP TABLE IF EXISTS `fornitore_geolocalizzazione`;

CREATE TABLE `fornitore_geolocalizzazione` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_fornitore` bigint NOT NULL,
  `area` text NOT NULL,
  `citta` text NOT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_fornitore_Geolocalizzazione` FOREIGN KEY (`id_fornitore`) REFERENCES `fornitore` (`id`)
) ENGINE=InnoDB;


SET FOREIGN_KEY_CHECKS=1;



