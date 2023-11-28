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
id_Fun_GOV int auto_increment not null primary key,
nome varchar(100) not null,
orgao varchar(20) not null,
cargo varchar(40) not null,
dt_nascimento date not null,
email varchar(100) not null,
senha varchar(8) not null
);

create table Tbl_Denuncia(
id_Denuncia int auto_increment not null primary key,
descrição varchar(2000) not null,
status_atualizacao varchar(40),
localizacao varchar(250) not null,
imagem_anexada longblob
);
## ALTERAR DADO NA TABELA (NESTE CASO EM ESPECIFICO ADICIONAR FK & CONSTRAINT)
ALTER TABLE Tbl_Cidadao
ADD CONSTRAINT uq_email UNIQUE (email);


ALTER TABLE Tbl_Denuncia
ADD COLUMN fk_id_Cidadao int not null,
ADD CONSTRAINT fk_Cidadao_Denuncia
    FOREIGN KEY (fk_id_Cidadao)
    REFERENCES Tbl_Cidadao(id_Cidadao);

## INSERIR INFORMACAO NO BANCO
##Select * from Tbl_Cidadao;
##INSERT INTO Tbl_Cidadao (nome, dt_nascimento, email, senha)
##VALUES ('VITOR', '1991-02-03', 'VITOR@example.com', '12345678');

## CONSULTA NO BANCO
##select * from Tbl_Cidadao
##where nome = 'VITOR';