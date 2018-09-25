CREATE DATABASE  IF NOT EXISTS `dbannonce` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dbannonce`;
-- MySQL dump 10.13  Distrib 5.7.23, for Win64 (x86_64)
--
-- Host: localhost    Database: dbannonce
-- ------------------------------------------------------
-- Server version	5.7.23-log

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
-- Table structure for table `annonce`
--

DROP TABLE IF EXISTS `annonce`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `annonce` (
  `IdAnnonce` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `IdUser` int(10) unsigned NOT NULL,
  `TitreAnnonce` varchar(45) NOT NULL,
  `DateAnnonce` varchar(45) NOT NULL,
  PRIMARY KEY (`IdAnnonce`),
  KEY `FK_annonce_1` (`IdUser`),
  CONSTRAINT `FK_annonce_1` FOREIGN KEY (`IdUser`) REFERENCES `user` (`IdUser`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `annonce`
--

LOCK TABLES `annonce` WRITE;
/*!40000 ALTER TABLE `annonce` DISABLE KEYS */;
INSERT INTO `annonce` VALUES (1,13,'Mercecedes Benz','01/06/2019'),(2,14,'Condo 31/2 A Loué','16/09/2018'),(3,15,'Porsche Cayen a louer','24/09/2018');
/*!40000 ALTER TABLE `annonce` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autres`
--

DROP TABLE IF EXISTS `autres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autres` (
  `IdAutres` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `TypeA` varchar(45) NOT NULL,
  `IdAnnonce` int(10) unsigned NOT NULL,
  `TxtA` varchar(500) NOT NULL,
  PRIMARY KEY (`IdAutres`) USING BTREE,
  KEY `FK_autres_1` (`IdAnnonce`),
  CONSTRAINT `FK_autres_1` FOREIGN KEY (`IdAnnonce`) REFERENCES `annonce` (`IdAnnonce`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autres`
--

LOCK TABLES `autres` WRITE;
/*!40000 ALTER TABLE `autres` DISABLE KEYS */;
/*!40000 ALTER TABLE `autres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorie_user`
--

DROP TABLE IF EXISTS `categorie_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorie_user` (
  `IdCat` int(10) unsigned NOT NULL,
  `Categorie` varchar(45) NOT NULL,
  PRIMARY KEY (`IdCat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorie_user`
--

LOCK TABLES `categorie_user` WRITE;
/*!40000 ALTER TABLE `categorie_user` DISABLE KEYS */;
INSERT INTO `categorie_user` VALUES (1,'Administrateur'),(2,'Utilisateur');
/*!40000 ALTER TABLE `categorie_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emploi`
--

DROP TABLE IF EXISTS `emploi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emploi` (
  `IdEmploi` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `IdAnnonce` int(10) unsigned NOT NULL,
  `TypeE` varchar(45) NOT NULL,
  `Salaire` varchar(45) NOT NULL,
  `Contrat` varchar(45) NOT NULL,
  `TxtE` varchar(500) NOT NULL,
  PRIMARY KEY (`IdEmploi`),
  KEY `FK_emploi_1` (`IdAnnonce`),
  CONSTRAINT `FK_emploi_1` FOREIGN KEY (`IdAnnonce`) REFERENCES `annonce` (`IdAnnonce`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emploi`
--

LOCK TABLES `emploi` WRITE;
/*!40000 ALTER TABLE `emploi` DISABLE KEYS */;
/*!40000 ALTER TABLE `emploi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `immobilier`
--

DROP TABLE IF EXISTS `immobilier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `immobilier` (
  `IdAI` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `IdAnnonce` int(10) unsigned NOT NULL,
  `TypeI` varchar(45) NOT NULL,
  `Adresse` varchar(45) NOT NULL,
  `Ville` varchar(45) NOT NULL,
  `Region` varchar(45) NOT NULL,
  `Pays` varchar(45) NOT NULL,
  `TxtI` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`IdAI`),
  KEY `FK_Immobilier_1` (`IdAnnonce`),
  CONSTRAINT `FK_Immobilier_1` FOREIGN KEY (`IdAnnonce`) REFERENCES `annonce` (`IdAnnonce`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `immobilier`
--

LOCK TABLES `immobilier` WRITE;
/*!40000 ALTER TABLE `immobilier` DISABLE KEYS */;
INSERT INTO `immobilier` VALUES (1,2,'Condo','25 Mont Belier','Mont Royale','Quebec','Canada','Salut les gars je loue mon appartment pour le mois de Juin, Juillet a 500CAD/mois si vous etes interesser envoyez moi votre message sur le 514-444-8888');
/*!40000 ALTER TABLE `immobilier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service` (
  `IdService` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `IdAnnonce` int(10) unsigned NOT NULL,
  `TypeS` varchar(45) NOT NULL,
  `TxtS` varchar(500) NOT NULL,
  PRIMARY KEY (`IdService`),
  KEY `FK_service_1` (`IdAnnonce`),
  CONSTRAINT `FK_service_1` FOREIGN KEY (`IdAnnonce`) REFERENCES `annonce` (`IdAnnonce`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `IdUser` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `IdCat` int(10) unsigned NOT NULL,
  `Nom` varchar(45) NOT NULL,
  `Prenom` varchar(45) NOT NULL,
  `NumTel` varchar(45) NOT NULL,
  `Adresse` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Ville` varchar(45) NOT NULL,
  `Region` varchar(45) NOT NULL,
  `Pays` varchar(45) NOT NULL,
  `Sexe` varchar(45) NOT NULL,
  `UserName` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`IdUser`),
  KEY `FK_user_1` (`IdCat`),
  CONSTRAINT `FK_user_1` FOREIGN KEY (`IdCat`) REFERENCES `categorie_user` (`IdCat`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (13,1,'Smith','Robert','4381111111','','rsmith@cgg.com','','','','Homme','admin','admin'),(14,2,'Rabih','Assaker','5141111111','','rassaker@cgg.com','','','','Homme','rassaker','rassaker'),(15,2,'derbali','lotfi','514-111-4444','mon adresse','lotfi@lotfimail.com','','','Canada','Homme','lotfi','lotfi');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicule`
--

DROP TABLE IF EXISTS `vehicule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicule` (
  `IdVehicule` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `IdAnnonce` int(10) unsigned NOT NULL,
  `Marque` varchar(45) NOT NULL,
  `Modele` varchar(45) NOT NULL,
  `TypeV` varchar(45) NOT NULL,
  `TxtV` varchar(500) NOT NULL,
  PRIMARY KEY (`IdVehicule`),
  KEY `FK_vehicule_1` (`IdAnnonce`),
  CONSTRAINT `FK_vehicule_1` FOREIGN KEY (`IdAnnonce`) REFERENCES `annonce` (`IdAnnonce`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicule`
--

LOCK TABLES `vehicule` WRITE;
/*!40000 ALTER TABLE `vehicule` DISABLE KEYS */;
INSERT INTO `vehicule` VALUES (1,1,'Mercedes','ML01/06/2016','Location','Je loue ma voiture https://www.google.ca/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjugsDw9L_dAhXGtlkKHZDnApAQjRx6BAgBEAU&url=https%3A%2F%2Fwww.mercedes-benz.ca%2Ffr%2Fvehicles%2Fclass%2Fc-class%2Fcoupe&psig=AOvVaw22tyKfPhl7sLG-OBQAHq-y&ust=1537200667313406'),(2,3,'Porshe','Cayen','Cayen','A louer 5000CAD par semaine');
/*!40000 ALTER TABLE `vehicule` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-25  6:38:32
