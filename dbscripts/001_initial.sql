CREATE TABLE `billboards` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) DEFAULT NULL,
  `city` INT NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `type` INT NOT NULL,
  `light` TINYINT(1) NOT NULL,
  `rent` DECIMAL(10,2) NOT NULL,
  `location` VARCHAR(255) NOT NULL,
  `owner_id` INT NOT NULL,
  `agent_id` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`));
