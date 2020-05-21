-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_example
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `element`
--

DROP TABLE IF EXISTS `element`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `element` (
  `id` int NOT NULL,
  `amount` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` double DEFAULT NULL,
  `producer` varchar(255) NOT NULL,
  `type` int NOT NULL,
  `value` double NOT NULL,
  `voltage` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `element`
--

LOCK TABLES `element` WRITE;
/*!40000 ALTER TABLE `element` DISABLE KEYS */;
INSERT INTO `element` VALUES (2,27886,'Glass fuse 5x200 100mA 250V',1.5,'Global Tone',6,0.1,250),(3,645,'Glass fuse 4x11 100mA 250V',5,'Hollyland',6,0.1,250),(5,12641,'Glass fuse 3.6x10 3A 250V',4,'KLS',6,3,250),(6,21227,'Resistor 3,6 Ohm 5% 0.125W',0.3,'Uni Ohm',5,3.6,0.125),(7,20704,'Resistor 33 Ohm 5% 0.125W',0.3,'Uni Ohm',5,33,0.125),(8,8320,'Resistor 270 kOhm 1% 0.125W',0.5,'Cinetech',5,270000,0.125),(9,13359,'Resistor 270 kOhm 5% 0.125W',0.3,'Uni Ohm',5,270000,0.125),(10,251,'Resistor 47 kOhm 5% 5W',2.5,'Hitano',5,47000,5),(11,11,'Resistor 82 Ohm 5% 5W',2.5,'Hitano',5,82,5),(12,18292,'Capacitor 100 uF 25V',2,'Hitano',4,0.0001,25),(13,17826,'Capacitor 100 uF 16V',1,'Hitano',4,0.0001,16),(15,15537,'Capacitor 100 uF 10V',1.5,'Hitano',4,0.0001,10),(16,149,'Capacitor 100 uF 10V',0.75,'Rubycon',4,0.0001,10),(19,868,'Capacitor 18000 uF 6.3V',8,'CapXon',4,0.018,6.3),(21,65285,'Diode 1N4007 1A 1000V',0.5,'YJ/Microsemi',2,1,1000),(22,31095,'Diode 1N5408 3A 1000V',1.5,'YJ/Microsemi',2,3,1000),(23,22607,'Diode 1N4448 0.2A 100V',1,'YJ/Philips',2,0.2,100),(24,3377,'Diode SM4007 1A 1000V',1.5,'YJ/DC/SMK',2,1,1000),(25,2858,'Diode S1M-01-W001 1A 1000V',1,'YJ',2,1,1000),(26,40260,'LED KLS9-L-5013URC red 5mm 2.25V',1.2,'KLS',3,5,2.25),(27,31372,'LED KLS9-L-5013GC green 5mm 2.2V',1.5,'KLS',3,5,2.2),(28,19356,'KX-K 16.0 MHz (49S-SMD-16M-20PF-30PPM – Crystal Units)',5.5,'Crystal',7,16000000,0),(29,781,'KX-3H 16.0 MHz (20pF, 30PPM)',6,'Geyer/Strong',7,16000000,0),(30,471,'HC49U 16.00000MHz (30pF, 30PPM)',5,'Cinetech',7,16000000,0),(31,12273,'Resistor 82 Ohm 5% 0.25W',0.4,'Hitano',5,82,0.25),(32,10000,'Resistor 10 Ohm 5% 0.25W',0.4,'Hitano',5,10,0.25),(33,3255,'Resistor 10 Ohm 5% 0.25W',0.4,'SR PASSIVES',5,10,0.25),(34,0,'Resistor 10 Ohm 5% 0.25W',0.4,'Cinetech',5,10,0.25),(35,100000,'Resistor 10 Ohm 5% 0.25W',0.6,'MFR',5,10,0.25),(36,868,'Capacitor 18000 uF 6.3V',8,'CapXon',4,0.018,6.3),(40,130000,'Resistor 1 kOhm 5% 0.25W',0.4,'Hitano',5,1000,0.25),(56,403,'Capacitor 2,2 uF 400V',3,'Jamicon',4,0.0022,400),(57,403,'Capacitor 2,2 uF 400V',3,'Jamicon',4,0.0022,400),(63,10452,'Capacitor 220 uF 10V',2,'Hitano',4,0.00022,10),(65,10452,'Capacitor 220 uF 10V',2,'Hitano',4,0.00022,10),(67,10452,'Capacitor 220 uF 10V',2,'Hitano',4,0.00022,10),(69,10652,'Capacitor 2,2 uF 16V',2,'Hitano',4,0.0022,16),(71,1652,'Capacitor 4,7 uF 16V',2.2,'Hitano',4,0.0047,16),(72,403,'Capacitor 2,2 uF 400V',3,'Jamicon',4,0.0022,400),(74,403,'Capacitor 2,2 uF 400V',3,'Jamicon',4,0.0022,400),(76,8025,'Capacitor 470 nF 100V',1.3,'Epcos',4,0.00000047,100),(78,8425,'Capacitor 480 nF 100V',1.3,'Epcos',4,0.00000048,100);
/*!40000 ALTER TABLE `element` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (79),(79);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequences`
--

DROP TABLE IF EXISTS `hibernate_sequences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequences` (
  `sequence_name` varchar(255) NOT NULL,
  `next_val` bigint DEFAULT NULL,
  PRIMARY KEY (`sequence_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequences`
--

LOCK TABLES `hibernate_sequences` WRITE;
/*!40000 ALTER TABLE `hibernate_sequences` DISABLE KEYS */;
INSERT INTO `hibernate_sequences` VALUES ('default',0);
/*!40000 ALTER TABLE `hibernate_sequences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kit`
--

DROP TABLE IF EXISTS `kit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kit` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `producer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kit`
--

LOCK TABLES `kit` WRITE;
/*!40000 ALTER TABLE `kit` DISABLE KEYS */;
INSERT INTO `kit` VALUES (17,'testKitName1',84.99,'DAGU'),(20,'testKitName2',129.99,'DFROBOT'),(58,'testKitName5',700.99,'Sparkfun'),(64,'testKitName6',150,'Chang'),(66,'testKitName6',150,'Chang'),(68,'testKitName6',150,'Chang'),(70,'testKitName9',180,'Coolbass'),(73,'testKitName5',700.99,'Sparkfun'),(75,'testKitName5',700.99,'Sparkfun');
/*!40000 ALTER TABLE `kit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kit_elements`
--

DROP TABLE IF EXISTS `kit_elements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kit_elements` (
  `kit_id` int NOT NULL,
  `element_id` int NOT NULL,
  PRIMARY KEY (`kit_id`,`element_id`),
  KEY `FK2vy9njxdi2clj618f7oyfmfea` (`element_id`),
  CONSTRAINT `FK2vy9njxdi2clj618f7oyfmfea` FOREIGN KEY (`element_id`) REFERENCES `element` (`id`),
  CONSTRAINT `FKfycekvodm626uopne39552c11` FOREIGN KEY (`kit_id`) REFERENCES `kit` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kit_elements`
--

LOCK TABLES `kit_elements` WRITE;
/*!40000 ALTER TABLE `kit_elements` DISABLE KEYS */;
INSERT INTO `kit_elements` VALUES (58,2),(73,2),(75,2),(17,3),(20,3),(20,6),(58,6),(73,6),(75,6),(20,7),(58,7),(73,7),(75,7),(20,9),(58,9),(73,9),(75,9),(20,12),(58,13),(73,13),(75,13),(20,16),(58,16),(73,16),(75,16),(20,19),(58,21),(73,21),(75,21),(58,57),(64,63),(66,65),(68,67),(70,69),(73,72),(75,74);
/*!40000 ALTER TABLE `kit_elements` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-21 19:35:46
