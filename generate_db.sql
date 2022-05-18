CREATE DATABASE  IF NOT EXISTS `university` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `university`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: university
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `id_department` int NOT NULL AUTO_INCREMENT,
  `name` varchar(145) NOT NULL,
  `address` varchar(145) NOT NULL,
  `web_site` varchar(145) NOT NULL,
  `foundation_date` date NOT NULL,
  `id_head` int NOT NULL,
  PRIMARY KEY (`id_department`),
  KEY `head_idx` (`id_head`),
  CONSTRAINT `head` FOREIGN KEY (`id_head`) REFERENCES `lector` (`id_lector`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'ASU','st.Horodots','asu.com','2002-08-03',3),(2,'KN','st.Bandera','knm.ua','2008-12-15',1);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department_lector`
--

DROP TABLE IF EXISTS `department_lector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department_lector` (
  `id_department` int NOT NULL,
  `id_lector` int NOT NULL,
  KEY `department_idx` (`id_department`),
  KEY `lector_idx` (`id_lector`),
  CONSTRAINT `department` FOREIGN KEY (`id_department`) REFERENCES `department` (`id_department`),
  CONSTRAINT `lector` FOREIGN KEY (`id_lector`) REFERENCES `lector` (`id_lector`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department_lector`
--

LOCK TABLES `department_lector` WRITE;
/*!40000 ALTER TABLE `department_lector` DISABLE KEYS */;
INSERT INTO `department_lector` VALUES (1,3),(1,2),(1,1),(2,3);
/*!40000 ALTER TABLE `department_lector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lector`
--

DROP TABLE IF EXISTS `lector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lector` (
  `id_lector` int NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `salary` int NOT NULL,
  `start_teaching` date NOT NULL,
  `degree` enum('assistant','associate professor','professor') NOT NULL,
  PRIMARY KEY (`id_lector`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lector`
--

LOCK TABLES `lector` WRITE;
/*!40000 ALTER TABLE `lector` DISABLE KEYS */;
INSERT INTO `lector` VALUES (1,'Ivanov Stepan',2500,'2005-05-15','professor'),(2,'Stepanov Andrii',3100,'2001-08-03','assistant'),(3,'Shechenko Volodymyr',2000,'2007-12-03','associate professor');
/*!40000 ALTER TABLE `lector` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-18 22:20:40
