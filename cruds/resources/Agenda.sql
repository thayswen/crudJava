create database agenda;

use agenda;

create table contatos(
id_contatos int not null auto_increment,
nome varchar(40),
idade int,
dataCadastro date,
primary key(id_contatos));

select * from contatos;