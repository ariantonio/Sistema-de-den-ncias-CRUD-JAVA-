CREATE DATABASE A3_PSC;

use A3_PSC;

create table Tbl_Cidadao(
id_Cidadao int auto_increment not null primary key,
nome varchar(100) not null,
dt_nascimento date not null,
email varchar(100) not null,
senha varchar(8) not null
);

create table Tbl_Fun_GOV(
id_Cidadao int auto_increment not null primary key,
nome varchar(100) not null,
orgao varchar(20) not null,
cargo varchar(40) not null,
dt_nascimento date not null,
email varchar(100) not null,
senha varchar(8) not null
);

create table Tbl_Politico(
id_Cidadao int auto_increment not null primary key,
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
imagem_anexada longblob
);
#------------------------------------
Select * from Tbl_Cidadao;

insert into Tbl_Cidadao (nome, dt_nascimento, email, senha) values ();
#-------------------------------------
ALTER TABLE Tbl_Fun_GOV
ADD CONSTRAINT fk_Cidadao_fun_gov
FOREIGN KEY (id_Cidadao) REFERENCES Tbl_Cidadao(id_Cidadao);

ALTER TABLE Tbl_Politico
ADD CONSTRAINT fk_Cidadao_politico
FOREIGN KEY (id_Cidadao) REFERENCES Tbl_Cidadao(id_Cidadao);

ALTER TABLE Tbl_Cidadao
ADD CONSTRAINT ck_tamanho_senha_Cidadao
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