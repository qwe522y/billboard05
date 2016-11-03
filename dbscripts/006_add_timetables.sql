CREATE TABLE `timetables` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `side_id` INT NOT NULL,
  `surface` INT NOT NULL,
  `year` int NOT NULL,
  `month` INT NOT NULL,
  `rent` DECIMAL(10,2) NOT NULL,
  `status` INT NOT NULL,
  `create_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`));