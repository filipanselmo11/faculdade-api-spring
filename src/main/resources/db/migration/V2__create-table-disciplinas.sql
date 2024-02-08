-- create database if not exists faculdade_api;
create table disciplinas (


    id bigint not null auto_increment,
    titulo varchar(100) not null,
    codigo varchar(100) not null unique,
    turmas int not null unique,

    primary key(id)
    
);