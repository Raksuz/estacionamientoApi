-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: estacionamiento
-- ------------------------------------------------------
-- Server version	8.0.28

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

--
-- Table structure for table `registro_estancia`
--

DROP TABLE IF EXISTS `registro_estancia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registro_estancia` (
  `id` int NOT NULL AUTO_INCREMENT,
  `entrada` datetime(6) DEFAULT NULL,
  `salida` datetime(6) DEFAULT NULL,
  `tiempo` bigint NOT NULL,
  `id_auto` int DEFAULT NULL,
  `importe` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlvsh38o70c3sxtjxayn77jjdu` (`id_auto`),
  CONSTRAINT `FKlvsh38o70c3sxtjxayn77jjdu` FOREIGN KEY (`id_auto`) REFERENCES `vehiculos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_estancia`
--

LOCK TABLES `registro_estancia` WRITE;
/*!40000 ALTER TABLE `registro_estancia` DISABLE KEYS */;
INSERT INTO `registro_estancia` VALUES (5,'2024-03-06 14:31:56.121031','2024-03-06 16:05:33.164608',0,2,0),(9,'2024-03-06 20:58:24.926095','2024-03-06 21:22:16.926070',0,5,0),(10,'2024-03-06 21:17:57.653874','2024-03-06 21:22:32.403239',0,5,0),(14,'2024-03-07 08:09:19.618833','2024-03-07 08:11:53.558015',2,8,0),(15,'2024-03-07 12:18:25.254178','2024-03-07 12:20:10.033256',1,8,0),(16,'2024-03-07 12:40:39.894234','2024-03-07 12:43:26.003302',2,8,0),(17,'2024-03-07 12:44:32.908852','2024-03-07 12:47:03.624285',2,8,1);
/*!40000 ALTER TABLE `registro_estancia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculos`
--

DROP TABLE IF EXISTS `vehiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehiculos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `num_placa` varchar(255) DEFAULT NULL,
  `tipo` enum('OFICIAL','RESIDENTE','NORESIDENTE') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculos`
--

LOCK TABLES `vehiculos` WRITE;
/*!40000 ALTER TABLE `vehiculos` DISABLE KEYS */;
INSERT INTO `vehiculos` VALUES (1,'CJ11','OFICIAL'),(2,'JX12','RESIDENTE'),(4,'LP14','OFICIAL'),(5,'AS18','RESIDENTE'),(7,'PR23','OFICIAL'),(8,'ZX09','NORESIDENTE');
/*!40000 ALTER TABLE `vehiculos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-07 13:03:07
