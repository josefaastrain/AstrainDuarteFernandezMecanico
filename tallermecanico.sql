-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-06-2025 a las 22:29:22
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tallermecanico`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autos`
--

CREATE TABLE `autos` (
  `id_auto` int(11) NOT NULL,
  `marca` varchar(25) NOT NULL,
  `modelo` varchar(25) NOT NULL,
  `anio` int(4) NOT NULL,
  `patente` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `autos`
--

INSERT INTO `autos` (`id_auto`, `marca`, `modelo`, `anio`, `patente`) VALUES
(1, 'Peugeot', '206 Xr 1.4', 2000, 'TT4913'),
(2, 'Toyota', 'RAV4 2.0 AWD', 2016, 'HTXV89'),
(3, 'Chevrolet', 'Spark LS 1.4', 2018, 'BBDS63'),
(5, 'Haval', 'Jolion Turbo DCT 1.5', 2023, 'SLWD21'),
(6, 'Hyundai', 'Elantra GLS 2.0', 2019, 'IJ445K'),
(7, 'Toyota', 'rav4', 2015, 'TUTU73'),
(8, 'Renault', 'Sandero Stepway 1.6', 2015, 'MN901O'),
(9, 'Nissan', 'Sentra SR 2.0', 2022, 'LM890N'),
(11, 'Fiat', 'Mobi Easy 1.0', 2016, 'ST870U'),
(12, 'Citroën', 'C4 Cactus Feel 1.6', 2020, 'UV383X'),
(14, 'Honda', 'Fit EX 1.5 i-VTEC', 2018, 'YZ719A'),
(15, 'Suzuki', 'Baleno GLX 1.4', 2017, 'ZA042B'),
(16, 'Subaru', 'XV AWD 2.0 CVT', 2022, 'BC385D'),
(17, 'Chery', 'Arrizo 5 GX 1.5T', 2021, 'DE678F'),
(18, 'Geely', 'Coolray Sport 1.5 Turbo', 2023, 'FG901H'),
(19, 'Dodge', 'Journey SXT 2.4', 2015, 'HI284J'),
(20, 'Mitsubishi', 'Mirage G4 1.2 CVT', 2019, 'JK017L');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `rut` varchar(25) NOT NULL,
  `telefono` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nombre`, `rut`, `telefono`) VALUES
(1, 'Napoleón Bonaparte', '13.479.172-k', '9 13849757'),
(2, 'María Loyola', '4.663.954-5', '9 23787211'),
(3, 'José Ramírez', '16.456.367-7', '9 56640330'),
(4, 'Paula Gutiérrez', '19.174.016-5', '9 87466043'),
(5, 'Carlos Peña', '9.210.855-4', '9 36090891'),
(6, 'Daniela Araya', '18.351.570-5', '9 62338388'),
(7, 'Luis Soto', '10.904.417-2', '9 36099764'),
(8, 'Romina Salinas', '15.899.307-4', '9 91340236'),
(9, 'Vicente Núñez', '18.031.209-9', '9 88289942'),
(10, 'Camila Rojas', '20.391.646-9', '9 36096753'),
(11, 'Ricardo Paredes', '11.898.106-5', '9 74180513'),
(12, 'Fernanda Díaz', '15.000.708-9', '9 55577853'),
(13, 'Matías Fuenzalida', '12.455.685-6', '9 30590917'),
(14, 'Valeria Carrasco', '18.227.962-5', '9 30822163'),
(15, 'Ignacio Toro', '21.370.236-K', '9 30397044'),
(16, 'Antonia Herrera', '17.864.482-3', '9 34194197'),
(17, 'Gabriel Leiva', '24.783.222-K', '9 55581977'),
(18, 'Martina López', '21.389.344-0', '9 32333141'),
(19, 'Esteban Cáceres', '12.196.542-9', '9 36082506'),
(20, 'Alejandra Muñoz', '13.622.396-8', '9 62928902'),
(21, 'Joaquín Reyes', '7.950.869-1', '9 48891576');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `herramientas`
--

CREATE TABLE `herramientas` (
  `id_herramienta` int(11) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `tipo` varchar(25) NOT NULL,
  `estado` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `herramientas`
--

INSERT INTO `herramientas` (`id_herramienta`, `nombre`, `tipo`, `estado`) VALUES
(1, 'Chicharra', 'Trinquete', 'En uso'),
(2, 'Llave Corona', 'Manual', 'Disponible'),
(3, 'Llave inglesa', 'Manual', 'En uso'),
(4, 'Destornillador', 'Manual', 'En uso'),
(5, 'Gato hidráulico', 'Hidráulica', 'Disponible'),
(6, 'Compresor', 'Eléctrica', 'En uso'),
(7, 'Multímetro', 'Eléctrica', 'Disponible'),
(8, 'Alicate', 'Manual', 'Disponible'),
(9, 'Llave de tubo', 'Manual', 'Disponible'),
(10, 'Taladro', 'Eléctrica', 'En uso'),
(11, 'Soldadora', 'Eléctrica', 'Disponible'),
(12, 'Manómetro', 'Medición', 'En uso'),
(13, 'Torque wrench', 'Manual', 'En uso'),
(14, 'Escáner OBD2', 'Diagnóstico', 'Disponible'),
(15, 'Polímetro', 'Medición', 'Disponible'),
(16, 'Cinta métrica', 'Medición', 'Disponible'),
(17, 'Martillo', 'Manual', 'Disponible'),
(18, 'Cortafrío', 'Manual', 'Disponible'),
(19, 'Extractor de poleas', 'Manual', 'En uso'),
(20, 'Medidor de compresión', 'Medición', 'En uso'),
(21, 'Lámpara portátil', 'Eléctrica', 'Disponible'),
(22, 'Engrasadora', 'Manual', 'En uso');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mecanicos`
--

CREATE TABLE `mecanicos` (
  `id_mecanico` int(11) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `especialidad` varchar(25) NOT NULL,
  `aniosExp` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mecanicos`
--

INSERT INTO `mecanicos` (`id_mecanico`, `nombre`, `especialidad`, `aniosExp`) VALUES
(1, 'Miguel Pato Menacho', 'Dar la vuelta', 1),
(2, 'Ye-min Fu Aguilar', 'Cambiar ruedas', 8),
(3, 'Ruperto Cid', 'Cambio de aceite', 3),
(4, 'Daniela Blatter', 'Computadores', 12),
(5, 'Ximena Aguirre Gay', 'Sistema electrico', 5),
(6, 'Carolina Bon Aqueveque', 'Cambio Pastillas', 7),
(7, 'Patricia Ona', 'Scanner', 1),
(8, 'Mauricio Aro Aro', 'Arranque', 8),
(9, 'Jonathan Zúñiga', 'Transmisión', 6),
(10, 'Diego Ignacio', 'Dirección hidráulica', 4),
(11, 'Marcelo Ríos', 'Frenos ABS', 9),
(12, 'Alfonso Soto', 'Embrague', 5),
(13, 'Jorge Yáñez', 'Aire acondicionado', 10),
(14, 'Juan Aldasoro', 'Diagnóstico electrónico', 7),
(15, 'Ross Brawn', 'Sistema de escape', 3),
(16, 'Renato Muñoz', 'Refrigeración', 6),
(17, 'Guy Martin', 'Motor', 11),
(18, 'Tomás Godoy', 'Chapa y pintura', 4),
(19, 'Andrea Zúñiga', 'Inyección electrónica', 8),
(20, 'Sebastián Pérez', 'Cambio de correa', 2),
(21, 'María José Palma', 'Luces y fusibles', 5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autos`
--
ALTER TABLE `autos`
  ADD PRIMARY KEY (`id_auto`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `herramientas`
--
ALTER TABLE `herramientas`
  ADD PRIMARY KEY (`id_herramienta`);

--
-- Indices de la tabla `mecanicos`
--
ALTER TABLE `mecanicos`
  ADD PRIMARY KEY (`id_mecanico`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `autos`
--
ALTER TABLE `autos`
  MODIFY `id_auto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `herramientas`
--
ALTER TABLE `herramientas`
  MODIFY `id_herramienta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `mecanicos`
--
ALTER TABLE `mecanicos`
  MODIFY `id_mecanico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
