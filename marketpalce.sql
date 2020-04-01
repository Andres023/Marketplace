-- MariaDB dump 10.17  Distrib 10.4.11-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: marketpalce
-- ------------------------------------------------------
-- Server version	10.4.11-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administradores`
--

DROP TABLE IF EXISTS `administradores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administradores` (
  `idAdmin` int(11) NOT NULL AUTO_INCREMENT,
  `idPersona` int(11) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `clave` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`idAdmin`),
  KEY `fk_admin` (`idPersona`),
  CONSTRAINT `fk_admin` FOREIGN KEY (`idPersona`) REFERENCES `personas` (`idPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administradores`
--

LOCK TABLES `administradores` WRITE;
/*!40000 ALTER TABLE `administradores` DISABLE KEYS */;
/*!40000 ALTER TABLE `administradores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `descripcion`
--

DROP TABLE IF EXISTS `descripcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `descripcion` (
  `idDescripccion` int(11) NOT NULL AUTO_INCREMENT,
  `transporte` tinyint(1) NOT NULL,
  `hotel` tinyint(1) NOT NULL,
  `alimento` tinyint(1) NOT NULL,
  PRIMARY KEY (`idDescripccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descripcion`
--

LOCK TABLES `descripcion` WRITE;
/*!40000 ALTER TABLE `descripcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `descripcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadoreserva`
--

DROP TABLE IF EXISTS `estadoreserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadoreserva` (
  `idEstadoReserva` int(11) NOT NULL AUTO_INCREMENT,
  `estadoReserva` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idEstadoReserva`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadoreserva`
--

LOCK TABLES `estadoreserva` WRITE;
/*!40000 ALTER TABLE `estadoreserva` DISABLE KEYS */;
INSERT INTO `estadoreserva` VALUES (1,'Activa'),(2,'Cancelada');
/*!40000 ALTER TABLE `estadoreserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genero` (
  `idGenero` int(11) NOT NULL,
  `genero` varchar(10) NOT NULL,
  PRIMARY KEY (`idGenero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,'Masculino'),(2,'Femenino'),(3,'Otro');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personas` (
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `tipoDoc` int(11) NOT NULL,
  `numDoc` varchar(20) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `codigoPostal` varchar(10) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `genero` int(11) NOT NULL,
  PRIMARY KEY (`idPersona`),
  KEY `fk_genero` (`genero`),
  KEY `fk_tipoDoc` (`tipoDoc`),
  CONSTRAINT `fk_genero` FOREIGN KEY (`genero`) REFERENCES `genero` (`idGenero`),
  CONSTRAINT `fk_tipoDoc` FOREIGN KEY (`tipoDoc`) REFERENCES `tipodocumento` (`idTipoDocumento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedores` (
  `idProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `nombreEmpresa` varchar(45) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `correoContacto` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `tipoProveedor` int(11) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `clave` varchar(18) NOT NULL,
  PRIMARY KEY (`idProveedor`),
  KEY `fk_tipoProv` (`tipoProveedor`),
  CONSTRAINT `fk_tipoProv` FOREIGN KEY (`tipoProveedor`) REFERENCES `tipoproveedor` (`idTipoProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores_servicios`
--

DROP TABLE IF EXISTS `proveedores_servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedores_servicios` (
  `proveedor` int(11) NOT NULL,
  `servicio` int(11) NOT NULL,
  KEY `fk_proveedores` (`proveedor`),
  KEY `fk_servicios` (`servicio`),
  CONSTRAINT `fk_proveedores` FOREIGN KEY (`proveedor`) REFERENCES `proveedores` (`idProveedor`),
  CONSTRAINT `fk_servicios` FOREIGN KEY (`servicio`) REFERENCES `servicios` (`idServicio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores_servicios`
--

LOCK TABLES `proveedores_servicios` WRITE;
/*!40000 ALTER TABLE `proveedores_servicios` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedores_servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservas` (
  `idReserva` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` int(11) NOT NULL,
  `estadoReserva` int(11) NOT NULL,
  PRIMARY KEY (`idReserva`),
  KEY `fk_usuarios` (`usuario`),
  KEY `fk_estadoReserva` (`estadoReserva`),
  CONSTRAINT `fk_estadoReserva` FOREIGN KEY (`estadoReserva`) REFERENCES `estadoreserva` (`idEstadoReserva`),
  CONSTRAINT `fk_usuarios` FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservas_servicios`
--

DROP TABLE IF EXISTS `reservas_servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservas_servicios` (
  `idReserva` int(11) NOT NULL,
  `idServicio` int(11) NOT NULL,
  KEY `fk_reservas` (`idReserva`),
  KEY `fk_servicio` (`idServicio`),
  CONSTRAINT `fk_reservas` FOREIGN KEY (`idReserva`) REFERENCES `reservas` (`idReserva`),
  CONSTRAINT `fk_servicio` FOREIGN KEY (`idServicio`) REFERENCES `servicios` (`idServicio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas_servicios`
--

LOCK TABLES `reservas_servicios` WRITE;
/*!40000 ALTER TABLE `reservas_servicios` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservas_servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicios`
--

DROP TABLE IF EXISTS `servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicios` (
  `idServicio` int(11) NOT NULL AUTO_INCREMENT,
  `nombreServicio` varchar(30) NOT NULL,
  `costo` int(11) NOT NULL,
  `fechaPublicacion` date NOT NULL,
  `ciudadOrigen` varchar(45) NOT NULL,
  `descripcion` int(11) NOT NULL,
  PRIMARY KEY (`idServicio`),
  KEY `fk_descripccion` (`descripcion`),
  CONSTRAINT `fk_descripccion` FOREIGN KEY (`descripcion`) REFERENCES `descripcion` (`idDescripccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicios`
--

LOCK TABLES `servicios` WRITE;
/*!40000 ALTER TABLE `servicios` DISABLE KEYS */;
/*!40000 ALTER TABLE `servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipodocumento`
--

DROP TABLE IF EXISTS `tipodocumento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipodocumento` (
  `idTipoDocumento` int(11) NOT NULL AUTO_INCREMENT,
  `tipoDocumento` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`idTipoDocumento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipodocumento`
--

LOCK TABLES `tipodocumento` WRITE;
/*!40000 ALTER TABLE `tipodocumento` DISABLE KEYS */;
INSERT INTO `tipodocumento` VALUES (1,'CC'),(2,'CE'),(3,'PA'),(4,'TI');
/*!40000 ALTER TABLE `tipodocumento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipopago`
--

DROP TABLE IF EXISTS `tipopago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipopago` (
  `idTipoPago` int(11) NOT NULL AUTO_INCREMENT,
  `tipoPago` varchar(25) NOT NULL,
  PRIMARY KEY (`idTipoPago`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipopago`
--

LOCK TABLES `tipopago` WRITE;
/*!40000 ALTER TABLE `tipopago` DISABLE KEYS */;
INSERT INTO `tipopago` VALUES (1,'Debito'),(2,'Credito'),(3,'Efectivo');
/*!40000 ALTER TABLE `tipopago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoproveedor`
--

DROP TABLE IF EXISTS `tipoproveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoproveedor` (
  `idTipoProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `tipoProveedor` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idTipoProveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoproveedor`
--

LOCK TABLES `tipoproveedor` WRITE;
/*!40000 ALTER TABLE `tipoproveedor` DISABLE KEYS */;
INSERT INTO `tipoproveedor` VALUES (1,'Empresa'),(2,'Persona Natural');
/*!40000 ALTER TABLE `tipoproveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transacciones`
--

DROP TABLE IF EXISTS `transacciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transacciones` (
  `idTransaccion` int(11) NOT NULL AUTO_INCREMENT,
  `nombreTransaccion` varchar(40) NOT NULL,
  `tipoPago` int(11) NOT NULL,
  `idReserva` int(11) NOT NULL,
  PRIMARY KEY (`idTransaccion`),
  KEY `fk_tipoPago` (`tipoPago`),
  KEY `fk_reserva` (`idReserva`),
  CONSTRAINT `fk_reserva` FOREIGN KEY (`idReserva`) REFERENCES `reservas` (`idReserva`),
  CONSTRAINT `fk_tipoPago` FOREIGN KEY (`tipoPago`) REFERENCES `tipopago` (`idTipoPago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transacciones`
--

LOCK TABLES `transacciones` WRITE;
/*!40000 ALTER TABLE `transacciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `transacciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `idPersona` int(11) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `clave` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `fk_persona` (`idPersona`),
  CONSTRAINT `fk_persona` FOREIGN KEY (`idPersona`) REFERENCES `personas` (`idPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-30 15:09:09
