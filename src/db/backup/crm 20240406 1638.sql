-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.15


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema crm
--

CREATE DATABASE IF NOT EXISTS crm;
USE crm;

--
-- Definition of table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `employeeId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `emailAddress` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `mobileNumber` bigint(20) unsigned DEFAULT NULL,
  `dateofBirth` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`employeeId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`employeeId`,`firstName`,`lastName`,`emailAddress`,`password`,`mobileNumber`,`dateofBirth`,`address`,`city`,`country`) VALUES 
 (1,'Jayaprakash','P','jayaprakash@gmail.com','jayaprakash',8825958422,'2008-07-09','Attur','Salem','India');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;


--
-- Definition of table `leads`
--

DROP TABLE IF EXISTS `leads`;
CREATE TABLE `leads` (
  `leadsId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `emailAddress` varchar(45) DEFAULT NULL,
  `mobileNumber` bigint(20) unsigned DEFAULT NULL,
  `companyName` varchar(45) DEFAULT NULL,
  `salary` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`leadsId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `leads`
--

/*!40000 ALTER TABLE `leads` DISABLE KEYS */;
INSERT INTO `leads` (`leadsId`,`firstName`,`lastName`,`emailAddress`,`mobileNumber`,`companyName`,`salary`,`address`,`city`,`state`,`country`) VALUES 
 (1,'Shanjai','Kumar','shanjaikumar@gmail.com',9876567890,'Softtwig','20000','Attur','Salem','Tamilnadu','India');
/*!40000 ALTER TABLE `leads` ENABLE KEYS */;


--
-- Definition of table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `loginId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`loginId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` (`loginId`,`userName`,`password`) VALUES 
 (1,'admin@gmail.com','admin'),
 (2,'jayaprakash@gmail.com','jayaprakash');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;


--
-- Definition of table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `productId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `productName` varchar(45) DEFAULT NULL,
  `productSpecification` varchar(45) DEFAULT NULL,
  `minimumStocks` varchar(45) DEFAULT NULL,
  `maximumStocks` varchar(45) DEFAULT NULL,
  `availableStocks` varchar(45) DEFAULT NULL,
  `price` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`productId`,`productName`,`productSpecification`,`minimumStocks`,`maximumStocks`,`availableStocks`,`price`) VALUES 
 (1,'Laptop','Acer good laptop','5','10','7',50000);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
