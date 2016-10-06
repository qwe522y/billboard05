CREATE TABLE `billboard_formats` (
  `id` INT NOT NULL,
  `name` VARCHAR(255) CHARACTER SET 'utf8' DEFAULT NULL,
  PRIMARY KEY (`id`));

DELETE FROM billboard_formats;
INSERT INTO billboard_formats VALUES
  (1, "Статика"),
  (2, "Динамика");