CREATE TABLE `billboard_types` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) DEFAULT NULL,
  `surface` INT NOT NULL COMMENT 'кол-во рекламных поверхностей на объекте',
  PRIMARY KEY (`id`));
