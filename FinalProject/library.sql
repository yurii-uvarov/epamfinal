
-- -----------------------------------------------------
-- Schema librarydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `librarydb` ;

-- -----------------------------------------------------
-- Schema librarydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `librarydb` DEFAULT CHARACTER SET cp1251 ;
USE `librarydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`genres`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `librarydb`.`genres` ;

CREATE TABLE IF NOT EXISTS `librarydb`.`genres` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`book_groups`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `librarydb`.`book_groups` ;

CREATE TABLE IF NOT EXISTS `librarydb`.`book_groups` (
  `groupId` INT NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`groupId`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`books`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `librarydb`.`books` ;

CREATE TABLE IF NOT EXISTS `librarydb`.`books` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `author` VARCHAR(45) NULL,
  `edition` VARCHAR(45) NULL,
  `date of publication` DATE NULL,
  `genreId` INT NOT NULL,
  `groupId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_books_genres1_idx` (`genreId` ASC),
  INDEX `fk_books_book_groups1_idx` (`groupId` ASC),
  CONSTRAINT `fk_books_borrows1`
  FOREIGN KEY (`id`)
  REFERENCES `librarydb`.`orders` (`bookId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_books_genres1`
  FOREIGN KEY (`genreId`)
  REFERENCES `librarydb`.`genres` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_books_book_groups1`
  FOREIGN KEY (`groupId`)
  REFERENCES `librarydb`.`book_groups` (`groupId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `librarydb`.`users` ;

CREATE TABLE IF NOT EXISTS `librarydb`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `surname` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `blocked` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `librarydb`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `librarydb`.`orders` ;

CREATE TABLE IF NOT EXISTS `librarydb`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `bookId` INT NOT NULL,
  `userId` INT NOT NULL,
  `date_borrow` DATE NOT NULL,
  `date_expected` DATE NOT NULL,
  `date_actual` DATE NULL,
  `place` VARCHAR(45) NOT NULL,
  `status` TINYINT(1) NOT NULL DEFAULT 0,
  INDEX `fk_borrows_users1_idx` (`userId` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_borrows_users1`
  FOREIGN KEY (`userId`)
  REFERENCES `librarydb`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;




