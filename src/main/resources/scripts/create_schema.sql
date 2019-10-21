CREATE DATABASE `deposit_db`;

DROP TABLE IF EXISTS `auto_prolonged_deposit`;
CREATE TABLE `auto_prolonged_deposit` (
  `id` int(11) NOT NULL,
  `deposit_type_id` int(11) DEFAULT NULL,
  `auto_prolongate` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `deposit_type_id` (`deposit_type_id`),
  CONSTRAINT `auto_prolonged_deposit_ibfk_1` FOREIGN KEY (`deposit_type_id`) REFERENCES `deposit` (`deposit_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `bank`;
CREATE TABLE `bank` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bank_name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `deposit`;
CREATE TABLE `deposit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deposit_type_id` int(11) DEFAULT NULL,
  `deposit_name` varchar(30) DEFAULT NULL,
  `minimum_sum` int(11) DEFAULT NULL,
  `deposited_sum` int(11) DEFAULT NULL,
  `cancellation` tinyint(4) DEFAULT NULL,
  `deposit_duration` int(11) DEFAULT NULL,
  `bank_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `deposit_type_id` (`deposit_type_id`),
  KEY `bank_id_key` (`bank_id`),
  CONSTRAINT `deposit_ibfk_1` FOREIGN KEY (`deposit_type_id`) REFERENCES `deposit_type` (`deposit_type_id`),
  CONSTRAINT `deposit_ibfk_2` FOREIGN KEY (`bank_id`) REFERENCES `bank` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `deposit_type`;
CREATE TABLE `deposit_type` (
  `deposit_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `deposit_type` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`deposit_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `frequency_strict_deposit`;
CREATE TABLE `frequency_strict_deposit` (
  `id` int(11) NOT NULL,
  `deposit_type_id` int(11) DEFAULT NULL,
  `frequency` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `deposit_type_id` (`deposit_type_id`),
  CONSTRAINT `frequency_strict_deposit_ibfk_1` FOREIGN KEY (`deposit_type_id`) REFERENCES `deposit` (`deposit_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `taxed_deposit`;
CREATE TABLE `taxed_deposit` (
  `id` int(11) NOT NULL,
  `deposit_type_id` int(11) DEFAULT NULL,
  `tax` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `deposit_type_id` (`deposit_type_id`),
  CONSTRAINT `taxed_deposit_ibfk_1` FOREIGN KEY (`deposit_type_id`) REFERENCES `deposit` (`deposit_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

