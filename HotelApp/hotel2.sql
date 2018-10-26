-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-10-2018 a las 00:45:07
-- Versión del servidor: 10.1.28-MariaDB
-- Versión de PHP: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hotel`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `facturaID` int(11) NOT NULL,
  `serie` varchar(45) DEFAULT NULL,
  `numfact` varchar(50) DEFAULT NULL,
  `total` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturadto`
--

CREATE TABLE `facturadto` (
  `facturaID` int(11) DEFAULT NULL,
  `itemID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `huesped`
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
-- Volcado de datos para la tabla `huesped`
--

INSERT INTO `huesped` (`huespedID`, `nombre`, `apellido`, `direccion`, `edad`, `genero`, `telefono`, `dpi`) VALUES
(1, 'Pedro', 'Flores', '20 calle 34-15 zona 7', '21', 'Hombre', 55197447, 43434233);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `huespeddto`
--

CREATE TABLE `huespeddto` (
  `huespedID` int(11) DEFAULT NULL,
  `roomID` int(11) DEFAULT NULL,
  `facturaID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `huespeddto`
--

INSERT INTO `huespeddto` (`huespedID`, `roomID`, `facturaID`) VALUES
(1, 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `itemfact`
--

CREATE TABLE `itemfact` (
  `itemID` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `total` float DEFAULT NULL,
  `idProducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `producto` varchar(50) NOT NULL,
  `costo` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `room`
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
-- Volcado de datos para la tabla `room`
--

INSERT INTO `room` (`roomID`, `room`, `tarifaID`, `checkin`, `checkout`, `status`) VALUES
(1, 'Suite imperial 2', 2, '2018-10-25', '2018-10-26', 'D'),
(6, 'Suite prueba', 4, NULL, NULL, 'O');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarifa`
--

CREATE TABLE `tarifa` (
  `tarifaID` int(11) NOT NULL,
  `tarifa` varchar(100) NOT NULL,
  `costo` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tarifa`
--

INSERT INTO `tarifa` (`tarifaID`, `tarifa`, `costo`) VALUES
(1, 'Llamadas a EEUU', 344),
(2, 'Noche vip', 1000),
(3, 'Noche Regular', 500),
(4, 'Noche Simple', 350),
(5, 'Medio dia', 100);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoempleado`
--

CREATE TABLE `tipoempleado` (
  `tipoEmpleadoID` int(11) NOT NULL,
  `nombreTipoEmpleado` varchar(45) DEFAULT NULL,
  `permisos` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipoempleado`
--

INSERT INTO `tipoempleado` (`tipoEmpleadoID`, `nombreTipoEmpleado`, `permisos`) VALUES
(1, 'Administradors', ''),
(3, 'Operador', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
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
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`usuarioID`, `nombreUsuario`, `apellidoUsuario`, `direccionUsuario`, `telefonoUsuario`, `emailUsuario`, `tipoEmpleadoID`) VALUES
(1, 'Pedro', 'Flores', 'Zona 7', '55197443', '2010330pedro@gmail.com', 1),
(2, 'Luis', 'Dominguez', 'zona 3', '23243023', 'test@mmai.com', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`facturaID`);

--
-- Indices de la tabla `facturadto`
--
ALTER TABLE `facturadto`
  ADD KEY `facturaID` (`facturaID`),
  ADD KEY `itemID` (`itemID`);

--
-- Indices de la tabla `huesped`
--
ALTER TABLE `huesped`
  ADD PRIMARY KEY (`huespedID`);

--
-- Indices de la tabla `huespeddto`
--
ALTER TABLE `huespeddto`
  ADD KEY `huespedID` (`huespedID`),
  ADD KEY `facturaID` (`facturaID`),
  ADD KEY `roomId` (`roomID`);

--
-- Indices de la tabla `itemfact`
--
ALTER TABLE `itemfact`
  ADD PRIMARY KEY (`itemID`),
  ADD KEY `fk_producto` (`idProducto`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`roomID`),
  ADD KEY `tarifaID` (`tarifaID`);

--
-- Indices de la tabla `tarifa`
--
ALTER TABLE `tarifa`
  ADD PRIMARY KEY (`tarifaID`);

--
-- Indices de la tabla `tipoempleado`
--
ALTER TABLE `tipoempleado`
  ADD PRIMARY KEY (`tipoEmpleadoID`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`usuarioID`),
  ADD KEY `usuario_ibfk_1` (`tipoEmpleadoID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `facturaID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `huesped`
--
ALTER TABLE `huesped`
  MODIFY `huespedID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `itemfact`
--
ALTER TABLE `itemfact`
  MODIFY `itemID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `room`
--
ALTER TABLE `room`
  MODIFY `roomID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `tarifa`
--
ALTER TABLE `tarifa`
  MODIFY `tarifaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tipoempleado`
--
ALTER TABLE `tipoempleado`
  MODIFY `tipoEmpleadoID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `usuarioID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `facturadto`
--
ALTER TABLE `facturadto`
  ADD CONSTRAINT `facturadto_ibfk_1` FOREIGN KEY (`facturaID`) REFERENCES `factura` (`facturaID`) ON DELETE CASCADE,
  ADD CONSTRAINT `facturadto_ibfk_2` FOREIGN KEY (`itemID`) REFERENCES `itemfact` (`itemID`) ON DELETE CASCADE;

--
-- Filtros para la tabla `huespeddto`
--
ALTER TABLE `huespeddto`
  ADD CONSTRAINT `huespeddto_ibfk_1` FOREIGN KEY (`huespedID`) REFERENCES `huesped` (`huespedID`) ON DELETE CASCADE,
  ADD CONSTRAINT `huespeddto_ibfk_2` FOREIGN KEY (`facturaID`) REFERENCES `factura` (`facturaID`) ON DELETE CASCADE,
  ADD CONSTRAINT `huespeddto_ibfk_3` FOREIGN KEY (`roomID`) REFERENCES `room` (`roomID`) ON DELETE CASCADE;

--
-- Filtros para la tabla `itemfact`
--
ALTER TABLE `itemfact`
  ADD CONSTRAINT `fk_producto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE CASCADE;

--
-- Filtros para la tabla `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `room_ibfk_1` FOREIGN KEY (`tarifaID`) REFERENCES `tarifa` (`tarifaID`) ON DELETE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`tipoEmpleadoID`) REFERENCES `tipoempleado` (`tipoempleadoID`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
