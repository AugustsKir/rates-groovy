

--liquibase formatted sql
--changeset admin:1

create table currency_rates (
    currency varchar(255) not null,
    rate decimal(19,4) not null ,
    date date not null,
    id int primary key auto_increment
)