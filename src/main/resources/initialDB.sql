CREATE DATABASE  IF NOT EXISTS `elibmanager` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `elibmanager`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: elibmanager
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `apply`
--

DROP TABLE IF EXISTS `apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apply` (
  `applyId` int(11) NOT NULL,
  `grandTotal` double NOT NULL,
  `studentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`applyId`),
  KEY `FKdg36oenagekpo8bo52emdmj0v` (`studentId`),
  CONSTRAINT `FKdg36oenagekpo8bo52emdmj0v` FOREIGN KEY (`studentId`) REFERENCES `student` (`studentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apply`
--

LOCK TABLES `apply` WRITE;
/*!40000 ALTER TABLE `apply` DISABLE KEYS */;
INSERT INTO `apply` VALUES (4,0,1);
/*!40000 ALTER TABLE `apply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `applyitem`
--

DROP TABLE IF EXISTS `applyitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `applyitem` (
  `applyItemId` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `totalPrice` double NOT NULL,
  `applyId` int(11) DEFAULT NULL,
  `bookId` int(11) DEFAULT NULL,
  PRIMARY KEY (`applyItemId`),
  KEY `FKaf1fcbwi3ensdasrmw60u2nt3` (`applyId`),
  KEY `FK4aty7k4ar94yrvglfvtsjagcq` (`bookId`),
  CONSTRAINT `FK4aty7k4ar94yrvglfvtsjagcq` FOREIGN KEY (`bookId`) REFERENCES `book` (`bookId`),
  CONSTRAINT `FKaf1fcbwi3ensdasrmw60u2nt3` FOREIGN KEY (`applyId`) REFERENCES `apply` (`applyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applyitem`
--

LOCK TABLES `applyitem` WRITE;
/*!40000 ALTER TABLE `applyitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `applyitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authorities` (
  `anthoritiesId` int(11) NOT NULL,
  `authority` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`anthoritiesId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES (0,'ROLE_ADMIN','admin'),(3,'ROLE_USER','username1');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `bookId` int(11) NOT NULL,
  `bookAuthor` varchar(255) DEFAULT NULL,
  `bookEdition` varchar(255) DEFAULT NULL,
  `bookISBN` varchar(255) DEFAULT NULL,
  `bookName` varchar(255) NOT NULL,
  `bookOwner` varchar(255) DEFAULT NULL,
  `bookPress` varchar(255) DEFAULT NULL,
  `bookPrice` double NOT NULL,
  `bookStatus` varchar(255) DEFAULT NULL,
  `studentId` int(11) DEFAULT NULL,
  `studentOrderId` int(11) DEFAULT NULL,
  PRIMARY KEY (`bookId`),
  KEY `FK6ilx05054xcx8s37butr9c2v` (`studentId`),
  KEY `FKbaeqvgo49c2yrvthhqd9xheor` (`studentOrderId`),
  CONSTRAINT `FK6ilx05054xcx8s37butr9c2v` FOREIGN KEY (`studentId`) REFERENCES `student` (`studentId`),
  CONSTRAINT `FKbaeqvgo49c2yrvthhqd9xheor` FOREIGN KEY (`studentOrderId`) REFERENCES `studentorder` (`studentOrderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookinfo`
--

DROP TABLE IF EXISTS `bookinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookinfo` (
  `id` int(11) NOT NULL,
  `bookAuthor` varchar(255) DEFAULT NULL,
  `bookEdition` varchar(255) DEFAULT NULL,
  `bookISBN` varchar(255) DEFAULT NULL,
  `bookImage` varchar(255) DEFAULT NULL,
  `bookName` varchar(255) DEFAULT NULL,
  `bookPress` varchar(255) DEFAULT NULL,
  `bookPrice` varchar(255) DEFAULT NULL,
  `bookUrl` varchar(255) DEFAULT NULL,
  `update_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookinfo`
--

LOCK TABLES `bookinfo` WRITE;
/*!40000 ALTER TABLE `bookinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `bookinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (5),(5),(5),(5),(5),(5),(5),(5);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `studentId` int(11) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) NOT NULL,
  `studentEmail` varchar(255) NOT NULL,
  `studentName` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `applyId` int(11) DEFAULT NULL,
  PRIMARY KEY (`studentId`),
  KEY `FKdkopp5kqwah5gbj72b71vhr7e` (`applyId`),
  CONSTRAINT `FKdkopp5kqwah5gbj72b71vhr7e` FOREIGN KEY (`applyId`) REFERENCES `apply` (`applyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'','112358','user1@163.com','user1','username1',4);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentorder`
--

DROP TABLE IF EXISTS `studentorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studentorder` (
  `studentOrderId` int(11) NOT NULL,
  `applyId` int(11) DEFAULT NULL,
  `studentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`studentOrderId`),
  KEY `FKfwo77r74rd9jjav4s88uqso0b` (`applyId`),
  KEY `FKte2nu2jwks2b6jc5leuiejoc5` (`studentId`),
  CONSTRAINT `FKfwo77r74rd9jjav4s88uqso0b` FOREIGN KEY (`applyId`) REFERENCES `apply` (`applyId`),
  CONSTRAINT `FKte2nu2jwks2b6jc5leuiejoc5` FOREIGN KEY (`studentId`) REFERENCES `student` (`studentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentorder`
--

LOCK TABLES `studentorder` WRITE;
/*!40000 ALTER TABLE `studentorder` DISABLE KEYS */;
/*!40000 ALTER TABLE `studentorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `usersId` int(11) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `studentId` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`usersId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (0,'','admin',-1,'admin'),(2,'','112358',1,'username1');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-06 20:25:27
