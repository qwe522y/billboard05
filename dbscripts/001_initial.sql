CREATE TABLE `billboards` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `city_id` INT NOT NULL,
  `address` VARCHAR(255) CHARACTER SET 'utf8' NOT NULL,
  `type_id` INT NOT NULL,
  `format_id` INT NOT NULL,
  `light` TINYINT(1) NOT NULL,
  `location` VARCHAR(255) NOT NULL,
  `owner_id` INT NOT NULL,
  `agent_id` INT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `billboard_sides` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `billboard_id` INT NOT NULL,
  `name` VARCHAR(255) CHARACTER SET 'utf8' NOT NULL,
  `rent` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC));
