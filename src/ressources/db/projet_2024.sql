-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 19 déc. 2024 à 10:57
-- Version du serveur : 5.7.36
-- Version de PHP : 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projet_2024`
--

-- --------------------------------------------------------

--
-- Structure de la table `programmeur`
--

CREATE TABLE `programmeur` (
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `addresse` varchar(100) NOT NULL,
  `pseudo` varchar(100) NOT NULL,
  `responsable` varchar(100) NOT NULL,
  `hobby` varchar(100) NOT NULL,
  `an_naissance` int(11) NOT NULL,
  `salaire` float NOT NULL,
  `prime` float NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `programmeur`
--

INSERT INTO `programmeur` (`nom`, `prenom`, `addresse`, `pseudo`, `responsable`, `hobby`, `an_naissance`, `salaire`, `prime`) VALUES
('Mickey', 'Johan', '10 via Della Via', 'Mister Mystic', 'Jean Claude Van Dahm', 'poney ride', 2000, 2900, 20);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
