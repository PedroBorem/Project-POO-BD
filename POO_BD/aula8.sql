DROP DATABASE IF EXISTS exercicio;
CREATE DATABASE exercicio;
USE exercicio;

CREATE TABLE IF NOT EXISTS curso(
   id INT NOT NULL AUTO_INCREMENT,
   nome VARCHAR(45),
   PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS aluno(
  matricula INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(20),
  ano_nasc INT,
  sexo ENUM('F','M'),
  fk_idcurso INT,
  CONSTRAINT fk
   FOREIGN KEY(fk_idcurso) REFERENCES curso(id) ON UPDATE CASCADE
   );
  
  
 select * from aluno;
 select * from curso;