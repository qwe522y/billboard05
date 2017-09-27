CREATE TABLE `billboard_types` (
  `id` INT NOT NULL,
  `name` VARCHAR(255) CHARACTER SET 'utf8' DEFAULT NULL,
  PRIMARY KEY (`id`));

DELETE FROM billboard_types;
INSERT INTO billboard_types VALUES
  (1, "Билборд"),
  (2, "Пиларс"),
  (3, "Призматрон");