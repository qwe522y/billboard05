CREATE TABLE `contracts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `timetable_id` INT NOT NULL,
  `client_phone` VARCHAR(255) CHARACTER SET 'utf8' NOT NULL,
  `agent_comment` TEXT CHARACTER SET 'utf8',
  `client_comment` TEXT CHARACTER SET 'utf8',
  `status` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`));