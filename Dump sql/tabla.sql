-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: tabla
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `recla`
--

DROP TABLE IF EXISTS `recla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recla` (
  `idReclamo` int NOT NULL,
  `descripcion` text NOT NULL,
  `fecha` date NOT NULL,
  `categoria` text NOT NULL,
  `domicilio` longtext NOT NULL,
  `usu_idUsuario` int NOT NULL,
  PRIMARY KEY (`idReclamo`),
  KEY `fk_recla_usu_idx` (`usu_idUsuario`),
  CONSTRAINT `fk_recla_usu` FOREIGN KEY (`usu_idUsuario`) REFERENCES `usu` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recla`
--

LOCK TABLES `recla` WRITE;
/*!40000 ALTER TABLE `recla` DISABLE KEYS */;
INSERT INTO `recla` VALUES (1,'Arbol caido','1996-07-07','ARBOLADO','algo 123',1),(2,'arbol ilegal','2010-04-13','ARBOLADO','algo 1234',3),(3,'auto abandonado','2012-06-12','LIMPIEZA','algo 1235',3),(4,'Cambio de baldosas','2014-11-11','PLUBIAL','algo 1236',1),(5,'lo sque de mi sql','2020-04-20','LIMPIEZA','algo 1237',1),(6,'Lograste sacar datos de SQL','2021-11-18','ARBOLADO','algo 1238',3);
/*!40000 ALTER TABLE `recla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usu`
--

DROP TABLE IF EXISTS `usu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usu` (
  `idUsuario` int NOT NULL,
  `usuario` text NOT NULL,
  `clave` text NOT NULL,
  `rol` text NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usu`
--

LOCK TABLES `usu` WRITE;
/*!40000 ALTER TABLE `usu` DISABLE KEYS */;
INSERT INTO `usu` VALUES (1,'juampi','1234','0'),(2,'yoshi','mario','1'),(3,'elver','no','0');
/*!40000 ALTER TABLE `usu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-01 11:44:11
