CREATE DATABASE  IF NOT EXISTS `clashroyale` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `clashroyale`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: clashroyale
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.21-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `baraja`
--

DROP TABLE IF EXISTS `baraja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `baraja` (
  `jugador` varchar(90) NOT NULL,
  `carta` varchar(90) NOT NULL,
  `nivel` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`jugador`,`carta`),
  KEY `fk_nombre_carta_idx` (`carta`),
  KEY `fk_nombre_jugador_idx` (`jugador`),
  CONSTRAINT `fk_nombre_carta` FOREIGN KEY (`carta`) REFERENCES `carta` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_nombre_jugador` FOREIGN KEY (`jugador`) REFERENCES `jugador` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baraja`
--

LOCK TABLES `baraja` WRITE;
/*!40000 ALTER TABLE `baraja` DISABLE KEYS */;
INSERT INTO `baraja` VALUES ('admin','Ballesta',1,2),('admin','Bebe Dragon',1,1),('admin','Caballero',1,2),('admin','Cañón',1,1),('admin','Megaesbirro',1,1),('admin','Mini P.E.K.K.A.',1,1),('admin','Mosquetera',1,3);
/*!40000 ALTER TABLE `baraja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carta`
--

DROP TABLE IF EXISTS `carta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carta` (
  `nombre` varchar(90) NOT NULL,
  `vida` int(11) NOT NULL,
  `ataque` int(11) NOT NULL,
  `velocidad` int(11) NOT NULL,
  `elixir` int(11) NOT NULL,
  `categoria` varchar(90) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carta`
--

LOCK TABLES `carta` WRITE;
/*!40000 ALTER TABLE `carta` DISABLE KEYS */;
INSERT INTO `carta` VALUES ('Ballesta',1330,260,3,6,'estructura'),('Bebe Dragon',1168,146,16,4,'volador'),('Caballero',1399,159,11,3,'terrestre'),('Cañón',815,139,10,3,'estructura'),('Megaesbirro',695,258,15,3,'volador'),('Mini P.E.K.K.A.',1056,572,18,4,'terrestre'),('Mosquetera',598,176,11,4,'terrestre');
/*!40000 ALTER TABLE `carta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jugador`
--

DROP TABLE IF EXISTS `jugador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jugador` (
  `nombre` varchar(90) NOT NULL,
  `nivel` int(11) NOT NULL,
  `oro` int(11) NOT NULL,
  `password` varchar(90) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugador`
--

LOCK TABLES `jugador` WRITE;
/*!40000 ALTER TABLE `jugador` DISABLE KEYS */;
INSERT INTO `jugador` VALUES ('admin',1,150,'21232f297a57a5a743894a0e4a801fc3');
/*!40000 ALTER TABLE `jugador` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-14 22:38:16
