-- Scripts para criação do projeto --

CREATE TABLE Tabela_de_grupo (
	id INT primary key, AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE tabela_contato (
	id INT primary key AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
 	telefone INT ,
  	email VARCHAR(100),
  	grupo VARCHAR(100) 
  	foreign key (grupo) references Tabela_de_grupo(id)
);
