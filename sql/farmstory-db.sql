-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
SET @@session.restrict_fk_on_non_standard_key=OFF;
-- -----------------------------------------------------
-- Schema Farmstory
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Farmstory
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Farmstory` DEFAULT CHARACTER SET utf8 ;
USE `Farmstory` ;

-- -----------------------------------------------------
-- Table `Farmstory`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Farmstory`.`user` (
  `id` VARCHAR(10) NOT NULL,
  `password` VARCHAR(64) NOT NULL,
  `name` VARCHAR(10) NOT NULL,
  `nickname` VARCHAR(8) NOT NULL,
  `point` INT NULL DEFAULT 0,
  `level` TINYINT NULL DEFAULT 0,
  `email` VARCHAR(254) NOT NULL,
  `phone_num` CHAR(13) NOT NULL,
  `zip` CHAR(5) NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  `address_detail` VARCHAR(50) NOT NULL,
  `register_date` DATETIME NULL,
  `leave_date` DATETIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `phone_num_UNIQUE` (`phone_num` ASC) VISIBLE,
  UNIQUE INDEX `nickname_UNIQUE` (`nickname` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Farmstory`.`company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Farmstory`.`company` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `company_name` VARCHAR(30) NOT NULL,
  `manager_name` VARCHAR(45) NOT NULL,
  `contact` VARCHAR(20) NOT NULL,
  `addr` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Farmstory`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Farmstory`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `company_id` INT NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `category` VARCHAR(10) NOT NULL,
  `price` INT NOT NULL,
  `point` INT NULL,
  `discount_rate` FLOAT NULL,
  `delivery_fee` INT NOT NULL DEFAULT 0,
  `stock` INT NOT NULL DEFAULT 0,
  `image_id` INT NULL,
  `register_date` DATETIME NULL,
  PRIMARY KEY (`id`, `company_id`),
  INDEX `fk_product_company1_idx` (`company_id` ASC) VISIBLE,
  CONSTRAINT `fk_product_company1`
    FOREIGN KEY (`company_id`)
    REFERENCES `Farmstory`.`company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Farmstory`.`product_image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Farmstory`.`product_image` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `thumbnail_location` VARCHAR(100) NULL,
  `info_location` VARCHAR(100) NULL,
  `detail_location` VARCHAR(100) NULL,
  PRIMARY KEY (`id`, `product_id`),
  INDEX `fk_product_image_product_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `fk_product_image_product`
    FOREIGN KEY (`product_id`)
    REFERENCES `Farmstory`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Farmstory`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Farmstory`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(10) NOT NULL,
  `product_id` INT NOT NULL,
  `amount` INT NULL,
  `placed_date` DATETIME NULL,
  PRIMARY KEY (`id`, `user_id`),
  INDEX `fk_order_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_order_product1_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `fk_order_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `Farmstory`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `Farmstory`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Farmstory`.`wishlist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Farmstory`.`wishlist` (
  `id` INT NOT NULL,
  `user_id` VARCHAR(10) NOT NULL,
  `product_id` INT NOT NULL,
  `amount` INT NOT NULL DEFAULT 1,
  INDEX `fk_wishlist_product1_idx` (`product_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_wishlist_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `Farmstory`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_wishlist_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `Farmstory`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Farmstory`.`article`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Farmstory`.`article` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(10) NOT NULL,
  `title` VARCHAR(50) NOT NULL,
  `author` VARCHAR(8) NOT NULL,
  `content` TEXT NOT NULL,
  `file_id` INT NULL DEFAULT NULL,
  `comment_number` INT NULL DEFAULT 0,
  `view_number` INT NULL DEFAULT 0,
  `register_date` DATE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_article_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_article_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `Farmstory`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Farmstory`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Farmstory`.`comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `article_id` INT NOT NULL,
  `author` VARCHAR(20) NOT NULL,
  `content` VARCHAR(300) NOT NULL,
  `register_date` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comment_article1_idx` (`article_id` ASC) VISIBLE,
  CONSTRAINT `fk_comment_article1`
    FOREIGN KEY (`article_id`)
    REFERENCES `Farmstory`.`article` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Farmstory`.`article_file`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Farmstory`.`article_file` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `article_id` INT NOT NULL,
  `location` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_article_file_article1_idx` (`article_id` ASC) VISIBLE,
  CONSTRAINT `fk_article_file_article1`
    FOREIGN KEY (`article_id`)
    REFERENCES `Farmstory`.`article` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Farmstory`.`point_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Farmstory`.`point_history` (
  `id` INT NOT NULL,
  `user_id` VARCHAR(10) NOT NULL,
  `amount` INT NULL,
  `description` VARCHAR(50) NULL,
  `earn_date` DATE NULL,
  PRIMARY KEY (`id`, `user_id`),
  INDEX `fk_point_history_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_point_history_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `Farmstory`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Farmstory`.`term`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Farmstory`.`term` (
  `id` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `content` TEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Farmstory`.`event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Farmstory`.`event` (
  `id` INT NOT NULL,
  `title` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
