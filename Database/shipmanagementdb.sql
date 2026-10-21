-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: shipmanagementdb
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `s_shipment`
--

DROP TABLE IF EXISTS `s_shipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `s_shipment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `receiver_address` varchar(255) DEFAULT NULL,
  `receiver_email` varchar(255) DEFAULT NULL,
  `receiver_mobile` varchar(255) DEFAULT NULL,
  `receiver_name` varchar(255) DEFAULT NULL,
  `sender_addres` varchar(255) DEFAULT NULL,
  `sender_email` varchar(255) DEFAULT NULL,
  `sender_mobile` varchar(255) DEFAULT NULL,
  `sender_name` varchar(255) DEFAULT NULL,
  `shipment_detail` varchar(455) DEFAULT NULL,
  `weight` bigint DEFAULT NULL,
  `tracking_id` bigint DEFAULT '1000000',
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_rhhicpvrs15vr0l0eq1ris1a4` (`tracking_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_shipment`
--

LOCK TABLES `s_shipment` WRITE;
/*!40000 ALTER TABLE `s_shipment` DISABLE KEYS */;
INSERT INTO `s_shipment` VALUES (1,'test@test.com','2022-08-02 12:31:55.487000','test@test.com','2022-08-02 12:31:55.487000','Near D L School','demo@demo.com','8856325412','Demo','Shivaji Nagar','test@test.com','9999999999','TestUser','1 Bicycle',120,10000001,2),(3,'demo@gmail.com','2022-08-02 12:40:40.680000','demo@gmail.com','2022-08-02 12:40:40.680000','Near H K Street','demo2@gmail.com','8888888888','Demo2','Near S.K street','demo@gmail.com','9999999999','Demo','Goods',50,10000002,3);
/*!40000 ALTER TABLE `s_shipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_tracking`
--

DROP TABLE IF EXISTS `s_tracking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `s_tracking` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `shipment_id` bigint DEFAULT NULL,
  `shipmentid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf34a4qa50hopui885t9qdablt` (`shipmentid`),
  CONSTRAINT `FKf34a4qa50hopui885t9qdablt` FOREIGN KEY (`shipmentid`) REFERENCES `s_shipment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_tracking`
--

LOCK TABLES `s_tracking` WRITE;
/*!40000 ALTER TABLE `s_tracking` DISABLE KEYS */;
INSERT INTO `s_tracking` VALUES (1,'admin@admin.com','2022-08-02 12:32:57.761000','admin@admin.com','2022-08-02 12:32:57.761000',NULL,'In shipping',1,1),(3,'admin@admin.com','2022-08-02 12:45:56.244000','admin@admin.com','2022-08-02 12:45:56.244000',NULL,'In processing',3,3);
/*!40000 ALTER TABLE `s_tracking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_updatecost`
--

DROP TABLE IF EXISTS `s_updatecost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `s_updatecost` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `cost_1` bigint DEFAULT NULL,
  `cost_2` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_updatecost`
--

LOCK TABLES `s_updatecost` WRITE;
/*!40000 ALTER TABLE `s_updatecost` DISABLE KEYS */;
INSERT INTO `s_updatecost` VALUES (1,'admin@admin.com','2022-08-02 12:27:17.726000','admin@admin.com','2022-08-02 12:27:17.726000',20,30);
/*!40000 ALTER TABLE `s_updatecost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s_user`
--

DROP TABLE IF EXISTS `s_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `s_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `mobile_no` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role_id` bigint DEFAULT NULL,
  `role_name` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s_user`
--

LOCK TABLES `s_user` WRITE;
/*!40000 ALTER TABLE `s_user` DISABLE KEYS */;
INSERT INTO `s_user` VALUES (1,NULL,NULL,NULL,NULL,'Admin','Male','Admin','admin@admin.com','8888888888','Admin@123',1,'ADMIN'),(2,'root','2022-08-02 12:28:47.315000','root','2022-08-02 12:28:47.315000','Test','Female','User','test@test.com','9999999999','Test@123',2,'User'),(3,'root','2022-08-02 12:35:24.551000','root','2022-08-02 12:35:24.551000','Demo','Female','Demo','demo@gmail.com','9635525663','Demo@123',2,'User');
/*!40000 ALTER TABLE `s_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-02 12:49:55
