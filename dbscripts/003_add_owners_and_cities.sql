CREATE TABLE `cities` (
  `id` INT NOT NULL,
  `name` VARCHAR(255) CHARACTER SET 'utf8' DEFAULT NULL,
  `location` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `owners` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) CHARACTER SET 'utf8' DEFAULT NULL,
  `phone` VARCHAR(255) NOT NULL,
  `agent_id` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`));

DELETE FROM cities;
INSERT INTO `cities` VALUES
  (1,'Махачкала','123.123.123'),
  (2,'Каспийск','123.123.123'),
  (3,'Дербент','123.123.123'),
  (4,'Хасавюрт','123.123.124'),
  (5,'Буйнакск','123.123.123'),
  (6,'Кизляр','123.123.123'),
  (7,'Кизилюрт','123.123.123');
