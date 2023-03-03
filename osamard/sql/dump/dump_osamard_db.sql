-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: osama_raccolta_dati
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

create database IF NOT EXISTS `osama_raccolta_dati`;


use `osama_raccolta_dati`;

--
-- Table structure for table `campioni`
--

DROP TABLE IF EXISTS `campioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `campioni` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campioni`
--

LOCK TABLES `campioni` WRITE;
/*!40000 ALTER TABLE `campioni` DISABLE KEYS */;
/*!40000 ALTER TABLE `campioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certificati`
--

DROP TABLE IF EXISTS `certificati`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `certificati` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificati`
--

LOCK TABLES `certificati` WRITE;
/*!40000 ALTER TABLE `certificati` DISABLE KEYS */;
/*!40000 ALTER TABLE `certificati` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contatto`
--

DROP TABLE IF EXISTS `contatto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contatto`
--

LOCK TABLES `contatto` WRITE;
/*!40000 ALTER TABLE `contatto` DISABLE KEYS */;
/*!40000 ALTER TABLE `contatto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dimensioni`
--

DROP TABLE IF EXISTS `dimensioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dimensioni` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dimensioni`
--

LOCK TABLES `dimensioni` WRITE;
/*!40000 ALTER TABLE `dimensioni` DISABLE KEYS */;
/*!40000 ALTER TABLE `dimensioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornitore`
--

DROP TABLE IF EXISTS `fornitore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fornitore` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ragione_sociale` text NOT NULL,
  `tempo_mercato` text NOT NULL,
  `id_categoria` bigint DEFAULT NULL,
  `id_subcategoria` bigint DEFAULT NULL,
  `fat_tot` text NOT NULL,
  `fat_it` text NOT NULL,
  `numero_dipendenti` bigint DEFAULT NULL,
  `rd_interno` tinyint(1) NOT NULL DEFAULT '0',
  `id_trading` bigint DEFAULT NULL,
  `id_contatto` bigint DEFAULT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_fornitore_categoria` (`id_categoria`),
  KEY `FK_fornitore_subcategoria` (`id_subcategoria`),
  KEY `FK_fornitore_trading` (`id_trading`),
  KEY `FK_fornitore_contatto` (`id_contatto`),
  CONSTRAINT `FK_fornitore_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `fornitore_categoria` (`id`),
  CONSTRAINT `FK_fornitore_contatto` FOREIGN KEY (`id_contatto`) REFERENCES `contatto` (`id`),
  CONSTRAINT `FK_fornitore_subcategoria` FOREIGN KEY (`id_subcategoria`) REFERENCES `fornitore_subcategoria` (`id`),
  CONSTRAINT `FK_fornitore_trading` FOREIGN KEY (`id_trading`) REFERENCES `trading` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornitore`
--

LOCK TABLES `fornitore` WRITE;
/*!40000 ALTER TABLE `fornitore` DISABLE KEYS */;
/*!40000 ALTER TABLE `fornitore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornitore_categoria`
--

DROP TABLE IF EXISTS `fornitore_categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fornitore_categoria` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornitore_categoria`
--

LOCK TABLES `fornitore_categoria` WRITE;
/*!40000 ALTER TABLE `fornitore_categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `fornitore_categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornitore_certificati`
--

DROP TABLE IF EXISTS `fornitore_certificati`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fornitore_certificati` (
  `id_fornitore` bigint NOT NULL,
  `id_certificazione` bigint NOT NULL,
  PRIMARY KEY (`id_fornitore`,`id_certificazione`),
  KEY `FK_fornitore_certificati` (`id_certificazione`),
  CONSTRAINT `FK_certificati_fornitore` FOREIGN KEY (`id_fornitore`) REFERENCES `fornitore` (`id`),
  CONSTRAINT `FK_fornitore_certificati` FOREIGN KEY (`id_certificazione`) REFERENCES `certificati` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornitore_certificati`
--

LOCK TABLES `fornitore_certificati` WRITE;
/*!40000 ALTER TABLE `fornitore_certificati` DISABLE KEYS */;
/*!40000 ALTER TABLE `fornitore_certificati` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornitore_geolocalizzazione`
--

DROP TABLE IF EXISTS `fornitore_geolocalizzazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
  KEY `FK_fornitore_Geolocalizzazione` (`id_fornitore`),
  CONSTRAINT `FK_fornitore_Geolocalizzazione` FOREIGN KEY (`id_fornitore`) REFERENCES `fornitore` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornitore_geolocalizzazione`
--

LOCK TABLES `fornitore_geolocalizzazione` WRITE;
/*!40000 ALTER TABLE `fornitore_geolocalizzazione` DISABLE KEYS */;
/*!40000 ALTER TABLE `fornitore_geolocalizzazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornitore_subcategoria`
--

DROP TABLE IF EXISTS `fornitore_subcategoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
  KEY `FK_categoria` (`id_categoria`),
  CONSTRAINT `FK_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `fornitore_categoria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornitore_subcategoria`
--

LOCK TABLES `fornitore_subcategoria` WRITE;
/*!40000 ALTER TABLE `fornitore_subcategoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `fornitore_subcategoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foto`
--

DROP TABLE IF EXISTS `foto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
  KEY `FK_foto_tipo_Oggetto` (`id_tipo_oggetto`),
  CONSTRAINT `FK_foto_tipo_Oggetto` FOREIGN KEY (`id_tipo_oggetto`) REFERENCES `foto_tipo_oggetto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foto`
--

LOCK TABLES `foto` WRITE;
/*!40000 ALTER TABLE `foto` DISABLE KEYS */;
/*!40000 ALTER TABLE `foto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foto_tipo_oggetto`
--

DROP TABLE IF EXISTS `foto_tipo_oggetto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `foto_tipo_oggetto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foto_tipo_oggetto`
--

LOCK TABLES `foto_tipo_oggetto` WRITE;
/*!40000 ALTER TABLE `foto_tipo_oggetto` DISABLE KEYS */;
/*!40000 ALTER TABLE `foto_tipo_oggetto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materiale`
--

DROP TABLE IF EXISTS `materiale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materiale` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materiale`
--

LOCK TABLES `materiale` WRITE;
/*!40000 ALTER TABLE `materiale` DISABLE KEYS */;
/*!40000 ALTER TABLE `materiale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `moq`
--

DROP TABLE IF EXISTS `moq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `moq` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moq`
--

LOCK TABLES `moq` WRITE;
/*!40000 ALTER TABLE `moq` DISABLE KEYS */;
/*!40000 ALTER TABLE `moq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamento`
--

DROP TABLE IF EXISTS `pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
  KEY `FK_pagamento_produzione` (`id_produzione`),
  CONSTRAINT `FK_pagamento_campioni` FOREIGN KEY (`id_campione`) REFERENCES `campioni` (`id`),
  CONSTRAINT `FK_pagamento_produzione` FOREIGN KEY (`id_produzione`) REFERENCES `produzione` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamento`
--

LOCK TABLES `pagamento` WRITE;
/*!40000 ALTER TABLE `pagamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prezzo`
--

DROP TABLE IF EXISTS `prezzo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prezzo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prezzo`
--

LOCK TABLES `prezzo` WRITE;
/*!40000 ALTER TABLE `prezzo` DISABLE KEYS */;
/*!40000 ALTER TABLE `prezzo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prodotto`
--

DROP TABLE IF EXISTS `prodotto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prodotto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cod_articolo` text NOT NULL,
  `id_materiale` bigint DEFAULT NULL,
  `id_dimensioni` bigint DEFAULT NULL,
  `id_moq` bigint DEFAULT NULL,
  `id_prezzo` bigint DEFAULT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_prodotto_materiale` (`id_materiale`),
  KEY `K_prodotto_dimensioni` (`id_dimensioni`),
  KEY `K_prodotto_moq` (`id_moq`),
  KEY `K_prodotto_prezzo` (`id_prezzo`),
  CONSTRAINT `FK_prodotto_materiale` FOREIGN KEY (`id_materiale`) REFERENCES `materiale` (`id`),
  CONSTRAINT `K_prodotto_dimensioni` FOREIGN KEY (`id_dimensioni`) REFERENCES `dimensioni` (`id`),
  CONSTRAINT `K_prodotto_moq` FOREIGN KEY (`id_moq`) REFERENCES `moq` (`id`),
  CONSTRAINT `K_prodotto_prezzo` FOREIGN KEY (`id_prezzo`) REFERENCES `prezzo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodotto`
--

LOCK TABLES `prodotto` WRITE;
/*!40000 ALTER TABLE `prodotto` DISABLE KEYS */;
/*!40000 ALTER TABLE `prodotto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produzione`
--

DROP TABLE IF EXISTS `produzione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produzione` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produzione`
--

LOCK TABLES `produzione` WRITE;
/*!40000 ALTER TABLE `produzione` DISABLE KEYS */;
/*!40000 ALTER TABLE `produzione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trading`
--

DROP TABLE IF EXISTS `trading`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trading` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` text NOT NULL,
  `DISABLED` tinyint(1) NOT NULL DEFAULT '0',
  `DT_INSERIMENTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DT_MODIFICA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LAST_USER_MODIFIED` bigint NOT NULL,
  `FIRST_USER` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trading`
--

LOCK TABLES `trading` WRITE;
/*!40000 ALTER TABLE `trading` DISABLE KEYS */;
/*!40000 ALTER TABLE `trading` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (1,'ANdreaTest','Andrea','Zamma','andrea.zammataro@kedos-srl.it','{SHA}a94a8fe5ccb19ba61c4c0873d391e987982fbbd3',0,'2023-03-02 16:52:06','2023-03-02 16:52:06',1,1);
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'osama_raccolta_dati'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-03 12:21:15
