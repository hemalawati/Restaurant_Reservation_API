CREATE DATABASE  IF NOT EXISTS `hema_restaurant` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hema_restaurant`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hema_restaurant
-- ------------------------------------------------------
-- Server version	5.7.8-rc-log

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(45) DEFAULT NULL,
  `c_phone` varchar(45) DEFAULT NULL,
  `c_email` varchar(45) DEFAULT NULL,
  `c_address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (101,'Bobby Shaw','4-(311)418-5186','bshaw0@ft.com','2643 Spohn Circle'),(102,'Raymond Reyes','2-(279)915-5172','rreyes1@tumblr.com','4272 Kropf Center'),(103,'Gary Wilson','4-(033)547-8752','gwilson2@privacy.gov.au','69410 Summer Ridge Road'),(104,'Judith Morris','0-(539)472-7741','jmorris3@sbwire.com','12 Hollow Ridge Place'),(105,'Jonathan Gray','0-(029)886-6936','jgray4@alibaba.com','27632 Express Place'),(106,'Earl Gonzalez','1-(854)044-7057','egonzalez5@joomla.org','18 Mockingbird Plaza'),(107,'Laura Owens','9-(946)010-5963','lowens6@cornell.edu','28 Hansons Drive'),(109,'Hema Lawati','4-(301)427-5120','hlawati0@ft.net','2000 Bay Area');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `owner`
--

DROP TABLE IF EXISTS `owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `owner` (
  `o_id` int(11) NOT NULL AUTO_INCREMENT,
  `o_name` varchar(45) DEFAULT NULL,
  `o_title` varchar(45) NOT NULL,
  PRIMARY KEY (`o_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner`
--

LOCK TABLES `owner` WRITE;
/*!40000 ALTER TABLE `owner` DISABLE KEYS */;
INSERT INTO `owner` VALUES (1,'Cheryl Banks','Owner'),(2,'Amanda Larson','General Manager'),(3,'Daniel Fields','Assistant Manager'),(4,'Emily Hughes','Shift Supervisor');
/*!40000 ALTER TABLE `owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation` (
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_id` int(11) NOT NULL,
  `c_name` varchar(45) DEFAULT NULL,
  `t_id` int(11) NOT NULL,
  `r_size` int(11) DEFAULT NULL,
  `r_status` varchar(45) DEFAULT NULL,
  `r_reservation_date` datetime DEFAULT NULL,
  `r_today_date` datetime DEFAULT NULL,
  `r_confirmation` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (1,101,'Bobby Shaw',1,4,'Complete','2015-10-27 19:37:40','2015-09-06 21:24:18','BS101'),(2,102,'Raymond Reyes',2,6,'Complete','2015-10-23 20:50:40','2015-09-04 09:22:59','RR102'),(3,103,'Gary Wilson',4,2,'Complete','2015-09-26 02:41:43','2015-09-02 21:17:33','GW103'),(4,104,'Judith Morris',6,3,'Complete','2015-10-06 13:18:41','2015-09-06 05:10:22','JM104'),(5,105,'Jonathan Gray',7,7,'Waiting','2015-10-13 11:51:08','2015-09-09 14:49:27','JG105'),(6,106,'Earl Gonzalez',8,10,'Waiting','2015-10-06 04:29:49','2015-08-29 08:02:40','EG106'),(7,109,'Hema Lawati',9,9,'Complete','2015-10-08 00:00:00','2015-09-04 00:00:00','HL109');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seating_table`
--

DROP TABLE IF EXISTS `seating_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seating_table` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seating_table`
--

LOCK TABLES `seating_table` WRITE;
/*!40000 ALTER TABLE `seating_table` DISABLE KEYS */;
INSERT INTO `seating_table` VALUES (1,'Reserved'),(2,'Reserved'),(3,'Empty'),(4,'Reserved'),(5,'Empty'),(6,'Reseved'),(7,'Reserved'),(8,'Reserved'),(9,'Reserved'),(10,'Empty');
/*!40000 ALTER TABLE `seating_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-04 16:46:14
