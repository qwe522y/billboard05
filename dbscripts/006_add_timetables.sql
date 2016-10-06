CREATE TABLE `timetables` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `billboard_id` INT NOT NULL,
  `side` INT NOT NULL,
  `surface` INT NOT NULL,
  `year` int NOT NULL,
  `month` INT NOT NULL,
  `rent` DECIMAL(10,2) NOT NULL,
  `create_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`));