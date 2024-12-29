-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: doconnect_qna
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
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `ques_id` int NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (1,'Browsers can only read JavaScript objects but JSX in not a regular JavaScript object. Thus to enable a browser to read JSX, first','../assets/answer1.png',1,'approved','ganesh'),(2,'we need to transform JSX file into a JavaScript object using JSX transformers like Babel and then pass it to the browser.','../assets/',1,'approved','arvind'),(3,'You can use babel to transform your jsx into native javascript and HTML which browser can understand.','../assets/',1,'approved','venkatesh'),(4,'Using Spring Initializr.','../assets/',2,'approved','harkirat'),(5,'Using Spring Maven Project','../assets/image4.png',2,'approved','jayasri'),(6,'You can enable the HTTP/2 support in Spring Boot by: server.http2.enabled=true','../assets/',3,'approved','jayasri'),(7,'@Bean public ConfigurableServletWebServerFactory tomcatCustomizer () { TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory ();','../assets/',3,'pending','harkirat'),(8,'LinkedList descendingIterator() returns an iterator that iterates over the element in reverse order.','../assets/',4,'approved','arvind'),(9,'By writing our own function(Using additional space): reverseLinkedList() method contains logic for reversing string objects in a linked list.','../assets/image3.png',4,'approved','ganesh'),(10,'to use the SimpleDateFormat class to format the date string','../assets/answer1.png',5,'approved','ganesh'),(11,'The DateFormat class in Java is used for formatting dates. A specified date can be formatted into the Data/Time string.','../assets/',5,'pending','harkirat');
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-21 13:15:54
