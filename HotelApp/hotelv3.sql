-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 03, 2018 at 05:56 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotel`
--

-- --------------------------------------------------------

--
-- Table structure for table `factura`
--

CREATE TABLE `factura` (
  `facturaID` int(11) NOT NULL,
  `serie` varchar(45) DEFAULT NULL,
  `numfact` varchar(80) DEFAULT NULL,
  `total` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `factura`
--

INSERT INTO `factura` (`facturaID`, `serie`, `numfact`, `total`) VALUES
(2, 'FACE-3B90', '162018102420181026', 700),
(4, 'FACE-3B90', '120181102', 30);

-- --------------------------------------------------------

--
-- Table structure for table `facturadto`
--

CREATE TABLE `facturadto` (
  `facturaID` int(11) DEFAULT NULL,
  `itemID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `facturadto`
--

INSERT INTO `facturadto` (`facturaID`, `itemID`) VALUES
(2, 3),
(4, 5);

-- --------------------------------------------------------

--
-- Table structure for table `huesped`
--

CREATE TABLE `huesped` (
  `huespedID` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `edad` varchar(50) DEFAULT NULL,
  `genero` varchar(50) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `dpi` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `huesped`
--

INSERT INTO `huesped` (`huespedID`, `nombre`, `apellido`, `direccion`, `edad`, `genero`, `telefono`, `dpi`) VALUES
(1, 'Pedro', 'Flores', '20 calle 34-15 zona 7', '21', 'Hombre', 55197447, 43434233);

-- --------------------------------------------------------

--
-- Table structure for table `huespeddto`
--

CREATE TABLE `huespeddto` (
  `huespedID` int(11) DEFAULT NULL,
  `roomID` int(11) DEFAULT NULL,
  `facturaID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `huespeddto`
--

INSERT INTO `huespeddto` (`huespedID`, `roomID`, `facturaID`) VALUES
(1, 1, NULL),
(1, 1, 2),
(1, NULL, 4);

-- --------------------------------------------------------

--
-- Table structure for table `itemfact`
--

CREATE TABLE `itemfact` (
  `itemID` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `total` float DEFAULT NULL,
  `idProducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `itemfact`
--

INSERT INTO `itemfact` (`itemID`, `cantidad`, `total`, `idProducto`) VALUES
(3, 2, 700, 3),
(5, 1, 30, 4);

-- --------------------------------------------------------

--
-- Table structure for table `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `producto` varchar(50) NOT NULL,
  `costo` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `producto`
--

INSERT INTO `producto` (`idProducto`, `producto`, `costo`) VALUES
(3, 'Suite prueba', 350),
(4, 'Llamadas a mexico', 10);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `roomID` int(11) NOT NULL,
  `room` varchar(100) DEFAULT NULL,
  `tarifaID` int(11) DEFAULT NULL,
  `checkin` date DEFAULT NULL,
  `checkout` date DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`roomID`, `room`, `tarifaID`, `checkin`, `checkout`, `status`) VALUES
(1, 'Suite imperial 2', 2, '2018-10-25', '2018-10-26', 'O'),
(6, 'Suite prueba', 4, '2018-10-24', '2018-10-26', 'O');

-- --------------------------------------------------------

--
-- Table structure for table `tarifa`
--

CREATE TABLE `tarifa` (
  `tarifaID` int(11) NOT NULL,
  `tarifa` varchar(100) NOT NULL,
  `costo` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tarifa`
--

INSERT INTO `tarifa` (`tarifaID`, `tarifa`, `costo`) VALUES
(1, 'Llamadas a EEUU', 344),
(2, 'Noche vip', 1000),
(3, 'Noche Regular', 500),
(4, 'Noche Simple', 350),
(5, 'Medio dia', 100);

-- --------------------------------------------------------

--
-- Table structure for table `tipoempleado`
--

CREATE TABLE `tipoempleado` (
  `tipoEmpleadoID` int(11) NOT NULL,
  `nombreTipoEmpleado` varchar(45) DEFAULT NULL,
  `permisos` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipoempleado`
--

INSERT INTO `tipoempleado` (`tipoEmpleadoID`, `nombreTipoEmpleado`, `permisos`) VALUES
(1, 'Administradors', ''),
(3, 'Operador', '');

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `usuarioID` int(11) NOT NULL,
  `nombreUsuario` varchar(45) DEFAULT NULL,
  `apellidoUsuario` varchar(45) DEFAULT NULL,
  `direccionUsuario` varchar(45) DEFAULT NULL,
  `telefonoUsuario` varchar(10) DEFAULT NULL,
  `emailUsuario` varchar(25) DEFAULT NULL,
  `tipoEmpleadoID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`usuarioID`, `nombreUsuario`, `apellidoUsuario`, `direccionUsuario`, `telefonoUsuario`, `emailUsuario`, `tipoEmpleadoID`) VALUES
(1, 'Pedro', 'Flores', 'Zona 7', '55197443', '2010330pedro@gmail.com', 1),
(2, 'Luis', 'Dominguez', 'zona 3', '23243023', 'test@mmai.com', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`facturaID`);

--
-- Indexes for table `facturadto`
--
ALTER TABLE `facturadto`
  ADD KEY `facturaID` (`facturaID`),
  ADD KEY `itemID` (`itemID`);

--
-- Indexes for table `huesped`
--
ALTER TABLE `huesped`
  ADD PRIMARY KEY (`huespedID`);

--
-- Indexes for table `huespeddto`
--
ALTER TABLE `huespeddto`
  ADD KEY `huespedID` (`huespedID`),
  ADD KEY `facturaID` (`facturaID`),
  ADD KEY `roomId` (`roomID`);

--
-- Indexes for table `itemfact`
--
ALTER TABLE `itemfact`
  ADD PRIMARY KEY (`itemID`),
  ADD KEY `fk_producto` (`idProducto`);

--
-- Indexes for table `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`roomID`),
  ADD KEY `tarifaID` (`tarifaID`);

--
-- Indexes for table `tarifa`
--
ALTER TABLE `tarifa`
  ADD PRIMARY KEY (`tarifaID`);

--
-- Indexes for table `tipoempleado`
--
ALTER TABLE `tipoempleado`
  ADD PRIMARY KEY (`tipoEmpleadoID`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`usuarioID`),
  ADD KEY `usuario_ibfk_1` (`tipoEmpleadoID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `factura`
--
ALTER TABLE `factura`
  MODIFY `facturaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `huesped`
--
ALTER TABLE `huesped`
  MODIFY `huespedID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `itemfact`
--
ALTER TABLE `itemfact`
  MODIFY `itemID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `roomID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tarifa`
--
ALTER TABLE `tarifa`
  MODIFY `tarifaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tipoempleado`
--
ALTER TABLE `tipoempleado`
  MODIFY `tipoEmpleadoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `usuarioID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `facturadto`
--
ALTER TABLE `facturadto`
  ADD CONSTRAINT `facturadto_ibfk_1` FOREIGN KEY (`facturaID`) REFERENCES `factura` (`facturaID`) ON DELETE CASCADE,
  ADD CONSTRAINT `facturadto_ibfk_2` FOREIGN KEY (`itemID`) REFERENCES `itemfact` (`itemID`) ON DELETE CASCADE;

--
-- Constraints for table `huespeddto`
--
ALTER TABLE `huespeddto`
  ADD CONSTRAINT `huespeddto_ibfk_1` FOREIGN KEY (`huespedID`) REFERENCES `huesped` (`huespedID`) ON DELETE CASCADE,
  ADD CONSTRAINT `huespeddto_ibfk_2` FOREIGN KEY (`facturaID`) REFERENCES `factura` (`facturaID`) ON DELETE CASCADE,
  ADD CONSTRAINT `huespeddto_ibfk_3` FOREIGN KEY (`roomID`) REFERENCES `room` (`roomID`) ON DELETE CASCADE;

--
-- Constraints for table `itemfact`
--
ALTER TABLE `itemfact`
  ADD CONSTRAINT `fk_producto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE CASCADE;

--
-- Constraints for table `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `room_ibfk_1` FOREIGN KEY (`tarifaID`) REFERENCES `tarifa` (`tarifaID`) ON DELETE CASCADE;

--
-- Constraints for table `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`tipoEmpleadoID`) REFERENCES `tipoempleado` (`tipoEmpleadoID`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
