ALTER TABLE `billboards` ADD COLUMN `width` INT NOT NULL DEFAULT 0 AFTER `agent_id`;
ALTER TABLE `billboards` ADD COLUMN `height` INT NOT NULL DEFAULT 0 AFTER `width`;
