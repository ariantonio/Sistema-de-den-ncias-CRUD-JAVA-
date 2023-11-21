CREATE DATABASE A3_PSC;

use A3_PSC;

create table Tbl_Usuario(
id_Usuario int auto_increment not null primary key,
nome varchar(100) not null,
dt_nascimento date not null,
email varchar(100) not null,
senha varchar(8) not null
);

create table Tbl_Fun_GOV(
id_Usuario int auto_increment not null primary key,
nome varchar(100) not null,
orgao varchar(20) not null,
cargo varchar(40) not null,
dt_nascimento date not null,
email varchar(100) not null,
senha varchar(8) not null
);

create table Tbl_Politico(
id_Usuario int auto_increment not null primary key,
nome varchar(100) not null,
filiacao varchar(10) not null,
cargo varchar(40) not null,
dt_nascimento date not null,
email varchar(100) not null,
senha varchar(8) not null
);

create table Tbl_Denuncia(
id_Tipo_de_problema int auto_increment not null primary key,
descrição varchar(2000) not null,
status_atualizacao varchar(40) not null,
localizacao varchar(250) not null,
imagem_anexada longblob NOT NULL
);
#------------------------------------
Select * from Tbl_Usuario;

insert into Tbl_Usuario (nome, dt_nascimento, email, senha) values ();
#-------------------------------------
ALTER TABLE Tbl_Fun_GOV
ADD CONSTRAINT fk_usuario_fun_gov
FOREIGN KEY (id_Usuario) REFERENCES Tbl_Usuario(id_Usuario);

ALTER TABLE Tbl_Politico
ADD CONSTRAINT fk_usuario_politico
FOREIGN KEY (id_Usuario) REFERENCES Tbl_Usuario(id_Usuario);

ALTER TABLE Tbl_Usuario
ADD CONSTRAINT ck_tamanho_senha_usuario
CHECK (LENGTH(senha) = 8);

ALTER TABLE Tbl_Fun_GOV
ADD CONSTRAINT ck_tamanho_senha_fun_gov
CHECK (LENGTH(senha) = 8);

ALTER TABLE Tbl_Politico
ADD CONSTRAINT ck_tamanho_senha_politico
CHECK (LENGTH(senha) = 8);

ALTER TABLE Tbl_Denuncia
ADD CONSTRAINT ck_status_atualizacao
CHECK (status_atualizacao IN ('Em andamento', 'Concluída', 'Pendente'));

ALTER TABLE Tbl_Denuncia
ADD CONSTRAINT pk_id_tipo_problema
PRIMARY KEY (id_Tipo_de_problema);
#--------------------------------------