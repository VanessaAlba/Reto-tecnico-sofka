-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-05-2022 a las 02:45:23
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `retosoftka`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `IdCategoria` int(5) NOT NULL,
  `NomCategoria` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`IdCategoria`, `NomCategoria`) VALUES
(1, 'Estadistica'),
(2, 'Economia'),
(3, 'Comunicacion de Datos'),
(4, 'Inteligencia Artificial'),
(5, 'Bases de datos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dificultad`
--

CREATE TABLE `dificultad` (
  `IdDificultad` int(5) NOT NULL,
  `NomDificultad` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `dificultad`
--

INSERT INTO `dificultad` (`IdDificultad`, `NomDificultad`) VALUES
(1, 'Muy facil'),
(2, 'Facil'),
(3, 'Intermedio'),
(4, 'Dificil'),
(5, 'Muy Dificil');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial`
--

CREATE TABLE `historial` (
  `IdPartida` int(5) NOT NULL,
  `Acumulado` int(20) NOT NULL,
  `IdJugador` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `historial`
--

INSERT INTO `historial` (`IdPartida`, `Acumulado`, `IdJugador`) VALUES
(1, 50, 1),
(2, 750, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE `jugador` (
  `IdJugador` int(5) NOT NULL,
  `Nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `jugador`
--

INSERT INTO `jugador` (`IdJugador`, `Nombre`) VALUES
(1, 'laura'),
(2, 'laura');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta`
--

CREATE TABLE `pregunta` (
  `IdPregunta` int(5) NOT NULL,
  `Enunciado` varchar(250) NOT NULL,
  `IdCategoria` int(5) NOT NULL,
  `IdDificultad` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pregunta`
--

INSERT INTO `pregunta` (`IdPregunta`, `Enunciado`, `IdCategoria`, `IdDificultad`) VALUES
(1, 'En estadística la moda es:', 1, 1),
(2, '¿ Calcule la media de los siguientes datos: 3,1,3,4,5,2?', 1, 2),
(3, '¿Numero de veces que se repite un dato?', 1, 3),
(4, '¿ A partir de que elemento se construyen los graficos?', 1, 4),
(5, '¿ Si en un campeonato de baloncesto un equipo ha ganado 12 partidos de 16 jugados, el porcentaje de ', 1, 5),
(6, 'cuales son los agentes economicos', 2, 1),
(7, 'cuales son los factores de produccion', 2, 2),
(8, '3 etapad o fases del proceso economico', 2, 3),
(9, 'que le da sentido a la existencia de un sistema economico con sus distintas actividades, agentes y las relaciones que se dan entre ellos', 2, 4),
(10, 'que tipo de mercado es cuando \" una unica empresa produce todos los bienes y ofrece todo el servicio que hay\"', 2, 5),
(11, 'herramienta de simulacion para diseñar y construir redes', 3, 1),
(12, 'que es el espectro electromagnetico', 3, 2),
(13, 'Sirve como un muro para proteger la red interna de trafico malicioso proveniente de la red externa', 3, 3),
(14, 'las redes de computadores se clasifican, según su alcance en:', 3, 4),
(15, 'que protocolo de routing dinamico se desarrollo para interconectar distintos proveedores de servicios de internet', 3, 5),
(16, 'la inteligencia artificial se desarrolla a partir de', 4, 1),
(17, 'quien se considera el padre de la IA ', 4, 2),
(18, 'que metodo utilizo alan turing para averiguuar si las maquinas pueden pensar', 4, 3),
(19, 'quien fue el cientifico que empezo el desarrollo del perceptron ', 4, 4),
(20, 'las formas de llevar a cabo el mecanismo de aprendizaje supervisado son:', 4, 5),
(21, 'la unidad minima de almacenamiento de informacion digital es:', 5, 1),
(22, 'de las siguiente opciones ¿Cuál NO es un gestor de bases de datos?', 5, 2),
(23, 'cual es el software que organiza los datos de forma estructurada', 5, 3),
(24, 'QUE ES EL data definition language (DDT)', 5, 4),
(25, 'en que año aparecene las BD relacionales', 5, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `premio`
--

CREATE TABLE `premio` (
  `IdPremio` int(5) NOT NULL,
  `Puntaje` int(20) NOT NULL,
  `IdRonda` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `premio`
--

INSERT INTO `premio` (`IdPremio`, `Puntaje`, `IdRonda`) VALUES
(1, 50, 1),
(2, 100, 2),
(3, 150, 3),
(4, 200, 4),
(5, 250, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuesta`
--

CREATE TABLE `respuesta` (
  `IdRespuesta` int(5) NOT NULL,
  `OpcValida` varchar(2) NOT NULL,
  `Opciones` varchar(100) NOT NULL,
  `IdPregunta` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `respuesta`
--

INSERT INTO `respuesta` (`IdRespuesta`, `OpcValida`, `Opciones`, `IdPregunta`) VALUES
(1, 'no', 'El valor mas grande ', 1),
(2, 'si', 'El dato que mas se repite', 1),
(3, 'no', 'La mitad de los datos ', 1),
(4, 'no', 'Valor promedio de los datos', 1),
(5, 'si', ' 3', 2),
(6, 'no', ' 4', 2),
(7, 'no', ' 3,5', 2),
(8, 'no', ' 2', 2),
(9, 'no', ' Frecuencia relativa', 3),
(10, 'si', ' Freciuencia Absoluta', 3),
(11, 'no', ' moda', 3),
(12, 'no', ' mediana', 3),
(13, 'si', ' Tabla de frecuencia', 4),
(14, 'no', ' Formula matematica', 4),
(15, 'no', ' conteo de datos', 4),
(16, 'no', ' de la media y la moda', 4),
(17, 'no', ' 75%', 5),
(18, 'no', ' 48%', 5),
(19, 'si', ' 25%', 5),
(20, 'no', ' 4%', 5),
(21, 'no', ' estado, familia, trabajo', 6),
(22, 'no', ' familia, trabajo, servicios', 6),
(23, 'si', ' empresa, estado, familia', 6),
(24, 'no', ' bienes, trabajo, familia', 6),
(25, 'no', ' tierra, trabajo, capital', 7),
(26, 'no', ' capital, tecnologia,estado, familia', 7),
(27, 'si', ' trabajo, capital, tierra, tecnologia', 7),
(28, 'no', ' familia, capital,tierra', 7),
(29, 'si', ' produccion, distribucion,consumo', 8),
(30, 'no', ' materia prima, trabajo,capital', 8),
(31, 'no', ' circulacion, trabajo,produccion', 8),
(32, 'no', ' consumo, empresa e inversion', 8),
(33, 'si', ' la escacez', 9),
(34, 'no', ' la abundancia', 9),
(35, 'no', ' el despilfarro', 9),
(36, 'no', ' Ninguna', 9),
(37, 'no', ' oligopolio', 10),
(38, 'si', ' monopolio', 10),
(39, 'no', ' mercado competencia perfecta', 10),
(40, 'no', ' mercado competencia imperfecta', 10),
(41, 'no', ' python', 11),
(42, 'si', ' Packet Tracert', 11),
(43, 'no', ' Tinkercard', 11),
(44, 'no', ' a y b', 11),
(45, 'si', ' conjunto de todas las frecuencias ordenadas por su frecuencia', 12),
(46, 'no', ' todas las ondas de radio', 12),
(47, 'no', ' todas las ondas infrarojas', 12),
(48, 'no', ' ninguna de las anteriores', 12),
(49, 'no', ' ips', 13),
(50, 'no', ' router', 13),
(51, 'no', ' ids', 13),
(52, 'si', ' firewall', 13),
(53, 'si', ' PAN,LAN,MAN,WAN', 14),
(54, 'no', ' entrada proceso salida', 14),
(55, 'no', ' estrella anillo bus', 14),
(56, 'no', ' cliente-servidor', 14),
(57, 'si', ' bgp', 15),
(58, 'no', ' eigrp', 15),
(59, 'no', ' ospf', 15),
(60, 'no', ' rip', 15),
(61, 'no', ' robots', 16),
(62, 'no', ' smartphones', 16),
(63, 'si', ' algoritmos', 16),
(64, 'no', ' bases de datos', 16),
(65, 'si', ' Alan turing', 17),
(66, 'no', ' marvin misky', 17),
(67, 'no', ' John McCarty', 17),
(68, 'no', ' frank rosenbalt', 17),
(69, 'no', ' el test de John McCarty', 18),
(70, 'no', ' el test de elisa', 18),
(71, 'si', ' el test de turing', 18),
(72, 'no', ' el test de la IA', 18),
(73, 'si', ' frank rosenblatt', 19),
(74, 'no', ' marvin misky', 19),
(75, 'no', ' misky y papert', 19),
(76, 'no', ' stephen grossberg', 19),
(77, 'no', ' por refuerzo, competitivo, estocastico', 20),
(78, 'si', ' por refuerzo, correcion de error,estocastico', 20),
(79, 'no', ' por refuerzo, correcion de error,hebbiano', 20),
(80, 'no', ' por refuerzo,competitivo,hebbiano', 20),
(81, 'no', ' bits', 21),
(82, 'no', ' byte', 21),
(83, 'si', ' bit', 21),
(84, 'no', ' ninguna', 21),
(85, 'no', ' python', 22),
(86, 'si', ' excel', 22),
(87, 'no', ' sql server', 22),
(88, 'no', ' oracle', 22),
(89, 'si', ' sistema de gestor de BD', 23),
(90, 'no', ' BD', 23),
(91, 'no', ' software gestor', 23),
(92, 'no', ' ficheros sistematicos de BD', 23),
(93, 'no', ' DEFINE LOS campos almacenados', 24),
(94, 'no', ' copia la base de datos de un lado a otro', 24),
(95, 'si', ' define las estructuras de las BD', 24),
(96, 'no', ' PARTE DEL ENTORNO DE BD simetricas', 24),
(97, 'si', ' 1970', 25),
(98, 'no', ' 1830', 25),
(99, 'no', ' 1940', 25),
(100, 'no', ' 1990', 25);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ronda`
--

CREATE TABLE `ronda` (
  `IdRonda` int(5) NOT NULL,
  `Nivel` int(2) NOT NULL,
  `IdDificultad` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ronda`
--

INSERT INTO `ronda` (`IdRonda`, `Nivel`, `IdDificultad`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rondahistorial`
--

CREATE TABLE `rondahistorial` (
  `IdRonda` int(5) NOT NULL,
  `IdPartida` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `rondahistorial`
--

INSERT INTO `rondahistorial` (`IdRonda`, `IdPartida`) VALUES
(1, 1),
(5, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`IdCategoria`);

--
-- Indices de la tabla `dificultad`
--
ALTER TABLE `dificultad`
  ADD PRIMARY KEY (`IdDificultad`);

--
-- Indices de la tabla `historial`
--
ALTER TABLE `historial`
  ADD PRIMARY KEY (`IdPartida`),
  ADD KEY `FKjugador` (`IdJugador`);

--
-- Indices de la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD PRIMARY KEY (`IdJugador`);

--
-- Indices de la tabla `pregunta`
--
ALTER TABLE `pregunta`
  ADD PRIMARY KEY (`IdPregunta`),
  ADD KEY `FKcategoria` (`IdCategoria`),
  ADD KEY `FKdificultad` (`IdDificultad`);

--
-- Indices de la tabla `premio`
--
ALTER TABLE `premio`
  ADD PRIMARY KEY (`IdPremio`),
  ADD KEY `FKronda` (`IdRonda`) USING BTREE;

--
-- Indices de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD PRIMARY KEY (`IdRespuesta`),
  ADD KEY `FKpregunta` (`IdPregunta`);

--
-- Indices de la tabla `ronda`
--
ALTER TABLE `ronda`
  ADD PRIMARY KEY (`IdRonda`),
  ADD KEY `FKdificultad` (`IdDificultad`) USING BTREE;

--
-- Indices de la tabla `rondahistorial`
--
ALTER TABLE `rondahistorial`
  ADD PRIMARY KEY (`IdRonda`,`IdPartida`),
  ADD KEY `FKronda` (`IdRonda`),
  ADD KEY `FKpartida` (`IdPartida`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `IdCategoria` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `dificultad`
--
ALTER TABLE `dificultad`
  MODIFY `IdDificultad` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `historial`
--
ALTER TABLE `historial`
  MODIFY `IdPartida` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `jugador`
--
ALTER TABLE `jugador`
  MODIFY `IdJugador` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `pregunta`
--
ALTER TABLE `pregunta`
  MODIFY `IdPregunta` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de la tabla `premio`
--
ALTER TABLE `premio`
  MODIFY `IdPremio` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  MODIFY `IdRespuesta` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=105;

--
-- AUTO_INCREMENT de la tabla `ronda`
--
ALTER TABLE `ronda`
  MODIFY `IdRonda` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `historial`
--
ALTER TABLE `historial`
  ADD CONSTRAINT `historial_ibfk_1` FOREIGN KEY (`IdJugador`) REFERENCES `jugador` (`IdJugador`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pregunta`
--
ALTER TABLE `pregunta`
  ADD CONSTRAINT `pregunta_ibfk_1` FOREIGN KEY (`IdCategoria`) REFERENCES `categoria` (`IdCategoria`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pregunta_ibfk_2` FOREIGN KEY (`IdDificultad`) REFERENCES `dificultad` (`IdDificultad`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `premio`
--
ALTER TABLE `premio`
  ADD CONSTRAINT `premio_ibfk_1` FOREIGN KEY (`IdRonda`) REFERENCES `ronda` (`IdRonda`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD CONSTRAINT `respuesta_ibfk_1` FOREIGN KEY (`IdPregunta`) REFERENCES `pregunta` (`IdPregunta`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ronda`
--
ALTER TABLE `ronda`
  ADD CONSTRAINT `ronda_ibfk_1` FOREIGN KEY (`IdDificultad`) REFERENCES `dificultad` (`IdDificultad`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `rondahistorial`
--
ALTER TABLE `rondahistorial`
  ADD CONSTRAINT `rondahistorial_ibfk_1` FOREIGN KEY (`IdPartida`) REFERENCES `historial` (`IdPartida`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rondahistorial_ibfk_2` FOREIGN KEY (`IdRonda`) REFERENCES `ronda` (`IdRonda`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
