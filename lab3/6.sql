CREATE DATABASE lab6;
dishUSE lab6;

CREATE TABLE IF NOT EXISTS `lab6`.`restaurant` (
  `idR` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `descriprion` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  
  PRIMARY KEY (`idR`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `lab6`.`dish` (
  `idD` INT NOT NULL,
  `dishName` VARCHAR(45) NULL,
  `price` INT NOT NULL,
  `isStudent` BOOLEAN NOT NULL,
`idR` INT NOT NULL,
  PRIMARY KEY (`idD`),
INDEX `fk_dish_restaurant_idx` (`idD` ASC),
  CONSTRAINT `fk_dish_restaurant`
    FOREIGN KEY (`idR`)
    REFERENCES `lab6`.`restaurant` (`idR`)
    ON DELETE NO ACTION  ON UPDATE NO ACTION)
ENGINE = InnoDB

