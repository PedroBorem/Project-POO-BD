-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Continente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Continente` (
  `idContinente` INT ZEROFILL NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`idContinente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Partida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Partida` (
  `idPartida` INT ZEROFILL NOT NULL AUTO_INCREMENT,
  `modo` BIT(1) NULL,
  `pontos` DOUBLE ZEROFILL NOT NULL,
  `time` DOUBLE ZEROFILL NOT NULL,
  `Continente_idContinente` INT ZEROFILL NOT NULL,
  PRIMARY KEY (`idPartida`),
  INDEX `fk_Partida_Continente1_idx` (`Continente_idContinente` ASC) VISIBLE,
  CONSTRAINT `fk_Partida_Continente1`
    FOREIGN KEY (`Continente_idContinente`)
    REFERENCES `mydb`.`Continente` (`idContinente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Jogador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Jogador` (
  `idJogador` INT ZEROFILL NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `highScoreAll` DOUBLE ZEROFILL NOT NULL,
  `highScoreContinente` DOUBLE ZEROFILL NOT NULL,
  `Partida_idPartida` INT ZEROFILL NOT NULL,
  PRIMARY KEY (`idJogador`),
  INDEX `fk_Jogador_Partida1_idx` (`Partida_idPartida` ASC) VISIBLE,
  CONSTRAINT `fk_Jogador_Partida1`
    FOREIGN KEY (`Partida_idPartida`)
    REFERENCES `mydb`.`Partida` (`idPartida`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Paises`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Paises` (
  `idPaises` INT ZEROFILL NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `longitude` DOUBLE NULL,
  `latitude` DOUBLE NULL,
  PRIMARY KEY (`idPaises`)
  )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Rank`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Rank` (
  `idRank` INT ZEROFILL NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`idRank`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Jogador_has_Rank`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Jogador_has_Rank` (
  `Jogador_idJogador` INT ZEROFILL NOT NULL,
  `Rank_idRank` INT ZEROFILL NOT NULL,
  PRIMARY KEY (`Jogador_idJogador`, `Rank_idRank`),
  INDEX `fk_Jogador_has_Rank_Rank1_idx` (`Rank_idRank` ASC) VISIBLE,
  INDEX `fk_Jogador_has_Rank_Jogador_idx` (`Jogador_idJogador` ASC) VISIBLE,
  CONSTRAINT `fk_Jogador_has_Rank_Jogador`
    FOREIGN KEY (`Jogador_idJogador`)
    REFERENCES `mydb`.`Jogador` (`idJogador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Jogador_has_Rank_Rank1`
    FOREIGN KEY (`Rank_idRank`)
    REFERENCES `mydb`.`Rank` (`idRank`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Partida_has_Paises`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Partida_has_Paises` (
  `Partida_idPartida` INT ZEROFILL NOT NULL,
  `Paises_idPaises` INT ZEROFILL NOT NULL,
  PRIMARY KEY (`Partida_idPartida`, `Paises_idPaises`),
  INDEX `fk_Partida_has_Pais_Pais1_idx` (`Paises_idPaises` ASC) VISIBLE,
  INDEX `fk_Partida_has_Pais_Partida1_idx` (`Partida_idPartida` ASC) VISIBLE,
  CONSTRAINT `fk_Partida_has_Pais_Partida1`
    FOREIGN KEY (`Partida_idPartida`)
    REFERENCES `mydb`.`Partida` (`idPartida`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Partida_has_Pais_Pais1`
    FOREIGN KEY (`Paises_idPaises`)
    REFERENCES `mydb`.`Paises` (`idPaises`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;

select * from Paises;


