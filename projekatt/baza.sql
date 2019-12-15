-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: lagoon
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `comment` (
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `photo_id` bigint(20) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `photo_photo_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `FK2a79ga7slc2j7flu67pnltua5` (`photo_photo_id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,'ovo je ok slika',1,'pera',1),(2,'nije lose',2,'pera',2),(3,'pa onako je ',1,'badr',1),(4,'nice pic',3,'badr',3),(5,'ok slika',3,'k',3),(6,'test test',2,'admin',2),(7,'test komentar',8,'admin',8),(8,'komentar na sliku somi ',9,'somi',9),(9,'super slika',10,'admin',10),(10,'ok slika',2,'admin',2),(11,'ok je slika',10,'vuk',10),(12,'nije lose',1,'vuk',1),(13,'asdasdasdasdasdasdasd',2,'somix',2);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1),(1),(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `photo`
--

DROP TABLE IF EXISTS `photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `photo` (
  `photo_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_name` varchar(255) DEFAULT NULL,
  `likes` int(11) NOT NULL,
  `photo_name` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`photo_id`),
  KEY `FK3x37qjpkh5hfcc22mto8s5x9c` (`user_user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photo`
--

LOCK TABLES `photo` WRITE;
/*!40000 ALTER TABLE `photo` DISABLE KEYS */;
INSERT INTO `photo` VALUES (1,'2019-09-21 10:04:31','aa','178964_4421378504832_661249187_n.jpg',4,'a','a',2),(2,'2019-09-21 10:05:48','tt','1185193_621067647915522_1107139072_n.jpg',3,'t','t',2),(3,'2019-09-21 10:08:07','op','43335366_2250334808529667_4568644892728754176_n.jpg',1,'op','op',4),(4,'2019-09-25 00:34:29','test','12733985_884498735005874_2584338587586529761_n.jpg',0,'test','test',6),(5,'2019-09-25 06:37:30','test','12733985_884498735005874_2584338587586529761_n.jpg',0,'test','test',7),(6,'2019-09-25 06:43:28','ll','12733985_884498735005874_2584338587586529761_n.jpg',0,'ll','ll',8),(7,'2019-10-09 19:30:46','proba','pu.jpg',1,'proba','proba',6),(8,'2019-11-25 18:40:26','aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa','10171694_725009874255639_8875970131732511376_n.jpg',0,'probaOfflineUser','probaOfflineUserprobaOfflineUser',6),(9,'2019-11-25 19:03:28','proba somi slika 1','17191270_958975350868895_6430771944629478058_n.jpg',0,'somi proba','naslovna slika',3),(10,'2019-11-25 19:47:07','slika test','10455696_788005131289446_406070312359016869_n.jpg',1,'naziv','naslov',6),(11,'2019-11-28 20:18:16','dodavanje slikeee','29683350_1777082605689845_5002133348637211559_n.jpg',0,'test','dadadasd',10),(12,'2019-11-30 16:27:34','dijagram koji se koristi u dokumentaciji','1.jpg',0,'slucaj koriscenja','Dijagram slucaja koriscenja',6),(13,'2019-11-30 16:41:11','ssssss','1.jpg',0,'ss','ss',6),(14,'2019-11-30 16:42:40','aaaa','1.drawio',0,'test','asd',6),(15,'2019-12-02 19:36:42','prva slika prva slika prva slika prva slika prva slika prva slika prva slika prva slika prva slika ','theirongiant.jpg',0,'prva slika ','prva slika ',6);
/*!40000 ALTER TABLE `photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2019-09-20 10:11:28','q','q','w','q'),(2,'2019-09-20 12:12:09','pera','pera','123','pera'),(3,'2019-09-20 19:08:39','somi','somi','1','somi'),(4,'2019-09-21 10:06:50','badr','hari','1','badr'),(5,'2019-09-24 19:33:59','aaaaa','sss','111','pera'),(6,'2019-09-24 19:35:44','admin','admin','admin','admin'),(7,'2019-09-25 06:34:23','aaaa','aaaa','a','aaaa'),(8,'2019-09-25 06:42:29','kk','kk','k','k'),(9,'2019-11-25 19:48:28','Vuk','Vujosevic','vuk','vuk'),(10,'2019-11-28 20:09:13','Lazar','Dragovic','lazar','lazar'),(12,'2019-12-01 16:36:26','perazdera','perazdera','perazdera','perazdera'),(13,'2019-12-02 16:21:16','somix','somix','somix','somix');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_liked_photo_list`
--

DROP TABLE IF EXISTS `user_liked_photo_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_liked_photo_list` (
  `user_user_id` bigint(20) NOT NULL,
  `liked_photo_list_photo_id` bigint(20) NOT NULL,
  KEY `FKkfyksnl7s0ahflko9vafcu6ib` (`liked_photo_list_photo_id`),
  KEY `FKndw8al6omf7t33rwr8y96jds3` (`user_user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_liked_photo_list`
--

LOCK TABLES `user_liked_photo_list` WRITE;
/*!40000 ALTER TABLE `user_liked_photo_list` DISABLE KEYS */;
INSERT INTO `user_liked_photo_list` VALUES (2,1),(2,2),(4,1),(4,3),(8,1),(6,2),(9,10),(9,1),(6,10),(6,7),(13,2);
/*!40000 ALTER TABLE `user_liked_photo_list` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-12 21:25:46
