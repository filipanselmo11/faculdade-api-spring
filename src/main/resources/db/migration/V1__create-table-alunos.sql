-- create database if not exists faculdade_api;
create table alunos (
    id bigint not null auto_increment primary key,
    nome varchar(100) not null,
    matricula varchar(100) not null unique,
    email varchar(100) not null unique,
);