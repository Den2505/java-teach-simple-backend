DROP DATABASE IF EXISTS `ttschool`;
CREATE DATABASE `ttschool`; 
USE `ttschool`;

start transaction;

CREATE TABLE IF NOT EXISTS `school` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `year` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = INNODB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `group` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `room` VARCHAR(45) NULL DEFAULT NULL,
  `school_id` INT NULL DEFAULT NULL,
  INDEX `fk_group_school1_idx` (`school_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_group_school1`
    FOREIGN KEY (`school_id`)
    REFERENCES `school` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = INNODB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `trainee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NULL DEFAULT NULL,
  `lastName` VARCHAR(45) NULL DEFAULT NULL,
  `rating` INT NULL DEFAULT 0,
  `group_id` INT NULL DEFAULT NULL,
  INDEX `fk_trainee_group_idx` (`group_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_trainee_group`
    FOREIGN KEY (`group_id`)
    REFERENCES `ttschool`.`group` (`id`)
    ON DELETE set null
    ON UPDATE cascade)
ENGINE = INNODB
DEFAULT CHARACTER SET = utf8;
  
  
CREATE TABLE IF NOT EXISTS `subject` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = INNODB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `group_has_subject` (
  `group_id` INT NOT NULL,
  `subject_id` INT NOT NULL,
  PRIMARY KEY (`group_id`, `subject_id`),
  INDEX `fk_group_has_subject_subject1_idx` (`subject_id` ASC),
  INDEX `fk_group_has_subject_group1_idx` (`group_id` ASC),
  CONSTRAINT `fk_group_has_subject_group1`
    FOREIGN KEY (`group_id`)
    REFERENCES `ttschool`.`group` (`id`)
    ON DELETE cascade
    ON UPDATE cascade,
  CONSTRAINT `fk_group_has_subject_subject1`
    FOREIGN KEY (`subject_id`)
    REFERENCES `ttschool`.`subject` (`id`)
    ON DELETE cascade
    ON UPDATE cascade)
ENGINE = INNODB
DEFAULT CHARACTER SET = utf8;

commit;