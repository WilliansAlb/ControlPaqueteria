-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: Paqueteria
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.18.04.1

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
-- Table structure for table `Bodega`
--

DROP TABLE IF EXISTS `Bodega`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Bodega` (
  `Codigo_Paquete` char(3) NOT NULL,
  `Ruta` int(4) NOT NULL,
  `Priorizado` tinyint(1) NOT NULL,
  `Numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Bodega`
--

LOCK TABLES `Bodega` WRITE;
/*!40000 ALTER TABLE `Bodega` DISABLE KEYS */;
INSERT INTO `Bodega` VALUES ('HFY',1,0,1),('WPT',1,0,3),('2IM',1,0,4),('SME',1,1,1),('0PJ',1,0,6),('JDW',2,0,7),('WP9',2,0,8),('3WE',2,0,9),('1TC',3,0,10),('JZH',3,0,11),('R7P',3,0,12),('YDO',4,0,13),('SB6',4,0,14),('ASM',4,0,15),('ZS5',5,0,16),('6ZO',5,0,17),('F9J',5,0,18);
/*!40000 ALTER TABLE `Bodega` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Clientes`
--

DROP TABLE IF EXISTS `Clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Clientes` (
  `nit_1` varchar(8) NOT NULL,
  `nombre` varchar(40) DEFAULT NULL,
  `ciudad` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`nit_1`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Clientes`
--

LOCK TABLES `Clientes` WRITE;
/*!40000 ALTER TABLE `Clientes` DISABLE KEYS */;
INSERT INTO `Clientes` VALUES ('34980838','Willians Alberto Orozco','San Lorenzo'),('36061697','Monica Jakeline','San Lorenzo'),('49817723','Juan Albino','San Lorenzo'),('51770390','René Arnulfo Orozco','San Andres Villaseca'),('59770390','Gary José López','Mazatenango'),('78745523','José Antonio López','San Lorenzo');
/*!40000 ALTER TABLE `Clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Ganancias`
--

DROP TABLE IF EXISTS `Ganancias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Ganancias` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `cod_paquete` char(3) NOT NULL,
  `no_ruta` int(3) NOT NULL,
  `costo_inicial` int(11) NOT NULL,
  `costo_final` int(11) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_final` date DEFAULT NULL,
  `ganancia` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ganancias`
--

LOCK TABLES `Ganancias` WRITE;
/*!40000 ALTER TABLE `Ganancias` DISABLE KEYS */;
INSERT INTO `Ganancias` VALUES (1,'HFY',1,160,0,NULL,NULL,0),(2,'WPT',1,160,0,NULL,NULL,0),(3,'2IM',1,310,0,NULL,NULL,0),(4,'SME',1,220,0,NULL,NULL,0),(5,'0PJ',1,240,0,NULL,NULL,0),(6,'JDW',2,365,0,NULL,NULL,0),(7,'WP9',2,195,0,NULL,NULL,0),(8,'3WE',2,195,0,NULL,NULL,0),(9,'1TC',3,250,0,NULL,NULL,0),(10,'JZH',3,140,0,NULL,NULL,0),(11,'R7P',3,370,0,NULL,NULL,0),(12,'YDO',4,90,0,NULL,NULL,0),(13,'SB6',4,270,0,NULL,NULL,0),(14,'ASM',4,290,0,NULL,NULL,0),(15,'ZS5',5,425,0,NULL,NULL,0),(16,'6ZO',5,160,0,NULL,NULL,0),(17,'F9J',5,305,0,NULL,NULL,0);
/*!40000 ALTER TABLE `Ganancias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Paquetes`
--

DROP TABLE IF EXISTS `Paquetes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Paquetes` (
  `id_paquete` char(3) NOT NULL,
  `ruta` int(3) NOT NULL,
  `punto` varchar(35) NOT NULL,
  `destinatario` varchar(30) NOT NULL,
  `remitente` varchar(30) NOT NULL,
  `tiempo` varchar(66) NOT NULL,
  `tarifa_global` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `priorizado` tinyint(1) NOT NULL,
  `nit` char(8) NOT NULL,
  `peso` int(3) NOT NULL,
  PRIMARY KEY (`id_paquete`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Paquetes`
--

LOCK TABLES `Paquetes` WRITE;
/*!40000 ALTER TABLE `Paquetes` DISABLE KEYS */;
INSERT INTO `Paquetes` VALUES ('0PJ',1,'BODEGA','Sheyla Ruiz','Sheyla Albino','',20,1,1,'34980838',5),('1TC',3,'BODEGA','Jose Luis Perales','Miguel Bose','',20,1,1,'49817723',6),('2IM',1,'BODEGA','Juan Lopez','Mario Perez','',20,1,0,'34980838',8),('3WE',2,'BODEGA','Alfredo Galdamez','Damian Hernandez','',20,1,0,'36061697',5),('6ZO',5,'BODEGA','Benito','Juarez','',10,1,0,'78745523',3),('ASM',4,'BODEGA','Marta Baute','Aristemis','',20,1,1,'51770390',8),('F9J',5,'BODEGA','Alberto','Antonio','',10,1,1,'78745523',7),('HFY',1,'BODEGA','Kosami','Admis','',20,1,0,'34980838',9),('JDW',2,'BODEGA','Maricarmen de Leon','Monica Roxana','',20,1,1,'36061697',10),('JZH',3,'BODEGA','Alfredo Gutierrez','Harry Potter','',20,1,0,'49817723',3),('R7P',3,'BODEGA','Roxana Garcia','Amanda Perez','',20,1,1,'49817723',10),('SB6',4,'BODEGA','Pedro Infante','Mario Lopez','',20,1,0,'51770390',8),('SME',1,'BODEGA','Perez Garcia','Obregon Lopez','',20,1,0,'34980838',5),('WP9',2,'BODEGA','Monica Lewiski','Pedro Paramo','',20,1,0,'36061697',5),('WPT',1,'BODEGA','Valentin Elizalde','Alberto Juarez','',20,1,0,'34980838',9),('YDO',4,'BODEGA','Pedro Fernandez','Jose Antonio','',20,1,0,'51770390',2),('ZS5',5,'BODEGA','Jesus','Alfredo','',10,1,1,'78745523',11);
/*!40000 ALTER TABLE `Paquetes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Puntos`
--

DROP TABLE IF EXISTS `Puntos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Puntos` (
  `id_ruta` int(3) NOT NULL,
  `id_punto` varchar(35) NOT NULL,
  `no_paquetes` int(4) NOT NULL,
  `no_punto` int(4) NOT NULL,
  `tarifa` int(5) DEFAULT NULL,
  `encargado` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id_punto`),
  KEY `FK_ENCARGADO` (`encargado`),
  CONSTRAINT `FK_ENCARGADO` FOREIGN KEY (`encargado`) REFERENCES `Usuarios` (`user`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Puntos`
--

LOCK TABLES `Puntos` WRITE;
/*!40000 ALTER TABLE `Puntos` DISABLE KEYS */;
INSERT INTO `Puntos` VALUES (2,'Aldali',12,1,120,'Aleja_Magno'),(4,'Ciudad de Guate',20,4,15,'Ro_24'),(5,'Cuyotenango',20,4,15,'Ro_24'),(2,'Dubai',10,2,6,'Aleja_Magno'),(3,'Hong Kong',20,4,15,'Cesar_23'),(1,'Jutiapa',15,1,12,NULL),(2,'Modesto',15,4,15,'Cesar_23'),(2,'Modesto-2',15,3,15,'Aleja_Magno'),(4,'Nevada',20,2,15,'Aleja_Magno'),(4,'Nevada-2',20,1,15,'Cesar_23'),(5,'Panajachel',20,1,15,'Aleja_Magno'),(1,'Peten',15,4,15,'Aleja_Magno'),(1,'Peten-2',15,3,15,'Aleja_Magno'),(1,'Puerto Barrios',20,2,15,'Ro_24'),(5,'San Antonio',20,2,15,NULL),(5,'San Bernandino',20,3,15,'Cesar_23'),(4,'Texas',20,3,15,'Cesar_23'),(3,'Vietnam',20,3,15,'Aleja_Magno'),(3,'Washington',15,2,15,'Aleja_Magno'),(3,'Washington-2',15,1,15,'Cesar_23'),(1,'Zacapa',13,5,15,'Cesar_23');
/*!40000 ALTER TABLE `Puntos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Ruta`
--

DROP TABLE IF EXISTS `Ruta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Ruta` (
  `codigo_ruta` int(11) NOT NULL AUTO_INCREMENT,
  `no_puntos` int(4) NOT NULL,
  `destino` varchar(35) NOT NULL,
  `cuota_destino` int(4) NOT NULL,
  `cuota_priori` int(4) NOT NULL,
  `tarifa_peso` int(4) NOT NULL,
  `estado_ruta` tinyint(1) NOT NULL,
  `tarifa_global` int(4) NOT NULL,
  PRIMARY KEY (`codigo_ruta`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ruta`
--

LOCK TABLES `Ruta` WRITE;
/*!40000 ALTER TABLE `Ruta` DISABLE KEYS */;
INSERT INTO `Ruta` VALUES (1,4,'Kazajistan',70,20,30,1,20),(2,4,'Afganistan',45,20,30,1,20),(3,4,'Dubai',50,20,30,1,20),(4,4,'California',30,20,30,1,20),(5,4,'Vietnam',70,25,30,1,10);
/*!40000 ALTER TABLE `Ruta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuarios`
--

DROP TABLE IF EXISTS `Usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuarios` (
  `user` varchar(12) NOT NULL,
  `pass` varchar(15) NOT NULL,
  `puesto` varchar(13) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuarios`
--

LOCK TABLES `Usuarios` WRITE;
/*!40000 ALTER TABLE `Usuarios` DISABLE KEYS */;
INSERT INTO `Usuarios` VALUES ('admin','12345','ADMINISTRADOR','Willians López'),('Alb_Orozco','admin2','ADMINISTRADOR','Alberto Orozco'),('Aleja_Magno','roma','OPERADOR','Alejandro Perez Magno'),('Cesar_23','pila','OPERADOR','Poncio Pilato'),('Ir_12','ara','RECEPCIONISTA','Irlandes Arabigo'),('lr2','laura','RECEPCIONISTA','Laura Jimenez'),('Maria_1','maria','RECEPCIONISTA','Maria Antonieta'),('Ro_24','1234','OPERADOR','Rodrigo Aguilar'),('Willians_Alb','admin','ADMINISTRADOR','Willians Alberto Orozco López');
/*!40000 ALTER TABLE `Usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-26 13:49:54
