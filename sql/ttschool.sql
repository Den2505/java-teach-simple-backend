DROP DATABASE IF EXISTS `ttschool`;
CREATE DATABASE `ttschool`; 
USE `ttschool`;

CREATE TABLE IF NOT EXISTS `school` (
  `id` INT NOT NULL auto_increment,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `year` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = INNODB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `group` (
  `id` INT NOT NULL auto_increment ,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `room` VARCHAR(45) NULL DEFAULT NULL,
  `school_id` INT,
  INDEX `fk_group_school1_idx` (`school_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_group_school1`
    FOREIGN KEY (`school_id`)
    REFERENCES `ttschool`.`school` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = INNODB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `trainee` (
  `id` INT NOT NULL auto_increment,
  `firstName` VARCHAR(45) NULL DEFAULT NULL,
  `lastName` VARCHAR(45) NULL DEFAULT NULL,
  `rating` INT NULL DEFAULT 0,
  `group_id` INT ,
  INDEX `fk_trainee_group_idx` (`group_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_trainee_group`
    FOREIGN KEY (`group_id`)
    REFERENCES `ttschool`.`group` (`id`)
    ON DELETE cascade
    ON UPDATE cascade)
ENGINE = INNODB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `subject` (
  `id` INT NOT NULL auto_increment,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `group_id` INT,
  KEY `fk_sabject_group_key`(`group_id`),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_subject_group`
    foreign key (`group_id`)
    references `group`(`id`)
    on delete cascade
    on update cascade
  )
ENGINE = INNODB
DEFAULT CHARACTER SET = utf8;