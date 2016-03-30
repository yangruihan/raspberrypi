CREATE DATABASE  IF NOT EXISTS `sharingcar` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sharingcar`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: sharingcar
-- ------------------------------------------------------
-- Server version	5.5.39

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
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `driverID` int(11) NOT NULL,
  `licensePlateNumber` varchar(10) NOT NULL,
  `type` varchar(20) NOT NULL,
  `seatNumber` int(11) NOT NULL,
  `haveAirCondition` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_have2` (`driverID`),
  CONSTRAINT `FK_have2` FOREIGN KEY (`driverID`) REFERENCES `driver` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `city2cityinfo`
--

DROP TABLE IF EXISTS `city2cityinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city2cityinfo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `start` varchar(50) NOT NULL,
  `end` varchar(50) NOT NULL,
  `mileage` float NOT NULL,
  `spendTime` varchar(50) NOT NULL,
  `oilCost` float NOT NULL,
  `roadToll` float NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=79041 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `complain`
--

DROP TABLE IF EXISTS `complain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `complain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `passid` int(11) NOT NULL,
  `drivid` int(11) NOT NULL,
  `content` varchar(128) DEFAULT NULL,
  `type` int(11) NOT NULL COMMENT '0:乘客对司机的投诉\n1:司机对乘客的投诉 ',
  `state` int(11) NOT NULL DEFAULT '0',
  `passName` varchar(32) DEFAULT NULL,
  `drivName` varchar(32) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `drievaluation`
--

DROP TABLE IF EXISTS `drievaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `drievaluation` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `pasID` int(11) NOT NULL,
  `driverID` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `score` int(11) NOT NULL,
  `leaveMsg` text,
  PRIMARY KEY (`ID`),
  KEY `FK_to3` (`driverID`),
  KEY `FK_to7` (`pasID`),
  CONSTRAINT `FK_to3` FOREIGN KEY (`driverID`) REFERENCES `driver` (`ID`),
  CONSTRAINT `FK_to7` FOREIGN KEY (`pasID`) REFERENCES `passenger` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=200027 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `driver` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `drivingYears` int(11) DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  `phoneNum` varchar(11) NOT NULL,
  `score` int(11) NOT NULL DEFAULT '80',
  `evaluateNum` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10460 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pasevaluation`
--

DROP TABLE IF EXISTS `pasevaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pasevaluation` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `pasID` int(11) NOT NULL,
  `driverID` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `score` int(11) NOT NULL,
  `leaveMsg` text,
  PRIMARY KEY (`ID`),
  KEY `FK_to` (`pasID`),
  KEY `FK_to5` (`driverID`),
  CONSTRAINT `FK_to` FOREIGN KEY (`pasID`) REFERENCES `passenger` (`ID`),
  CONSTRAINT `FK_to5` FOREIGN KEY (`driverID`) REFERENCES `driver` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=100016 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passenger` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `phoneNum` varchar(11) NOT NULL,
  `score` int(11) NOT NULL DEFAULT '80',
  `evaluateNum` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10617 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sharingcarapply`
--

DROP TABLE IF EXISTS `sharingcarapply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sharingcarapply` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `pasID` int(11) NOT NULL,
  `price` float NOT NULL,
  `carType` varchar(20) NOT NULL,
  `sharingCarType` varchar(50) NOT NULL,
  `start` varchar(50) NOT NULL,
  `end` varchar(50) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_apply` (`pasID`),
  CONSTRAINT `FK_apply` FOREIGN KEY (`pasID`) REFERENCES `passenger` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=366 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sharingcarconfirm`
--

DROP TABLE IF EXISTS `sharingcarconfirm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sharingcarconfirm` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `pasID` int(11) DEFAULT NULL,
  `driverID` int(11) DEFAULT NULL,
  `carApply` int(11) DEFAULT NULL,
  `carInfo` int(11) DEFAULT NULL,
  `confirm` datetime NOT NULL,
  `driv_safe_time` datetime DEFAULT NULL,
  `driv_safe_num` varchar(11) DEFAULT NULL,
  `pass_safe_time` datetime DEFAULT NULL,
  `pass_safe_num` varchar(11) DEFAULT NULL,
  `driv_confirm` int(11) DEFAULT '0',
  `pass_confirm` int(11) DEFAULT '0',
  `driverConfirm` int(11) NOT NULL,
  `pasConfirm` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_trigger3_idx` (`driverID`),
  KEY `Fk_sharing_car_idx` (`carApply`),
  KEY `Fk_car_info_idx` (`carInfo`),
  KEY `FK_trigger2` (`pasID`),
  CONSTRAINT `Fk_car_apply` FOREIGN KEY (`carApply`) REFERENCES `sharingcarapply` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_car_info` FOREIGN KEY (`carInfo`) REFERENCES `sharingcarinfo` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_trigger2` FOREIGN KEY (`pasID`) REFERENCES `passenger` (`ID`),
  CONSTRAINT `FK_trigger3` FOREIGN KEY (`driverID`) REFERENCES `driver` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sharingcarinfo`
--

DROP TABLE IF EXISTS `sharingcarinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sharingcarinfo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `driverID` int(11) NOT NULL,
  `totalDistance` float NOT NULL,
  `start` varchar(50) NOT NULL,
  `end` varchar(50) NOT NULL,
  `time` datetime NOT NULL,
  `state` int(11) DEFAULT '0',
  `carType` varchar(20) DEFAULT NULL,
  `gasolineCosts` float DEFAULT NULL,
  `onewayCosts` float DEFAULT NULL,
  `maxPasNum` int(11) NOT NULL,
  `nowPasNum` int(11) NOT NULL DEFAULT '0',
  `addedInfo` text,
  PRIMARY KEY (`ID`),
  KEY `fk_driver_idx` (`driverID`),
  CONSTRAINT `fk_driver` FOREIGN KEY (`driverID`) REFERENCES `driver` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1943 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  `TELEPHONE` varchar(15) DEFAULT NULL,
  `USERNAME` varchar(45) DEFAULT NULL,
  `ISADMIN` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping events for database 'sharingcar'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-14 21:29:01
