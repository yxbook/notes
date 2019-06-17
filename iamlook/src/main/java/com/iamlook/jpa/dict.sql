CREATE TABLE `region_dict` (
  `id` varchar(36) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_code` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4