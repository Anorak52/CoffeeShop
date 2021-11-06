create sequence hibernate_sequence start 1 increment 1;

create table bonus_entity (
    bonus int4,
    first_name varchar(255),
    last_name varchar(255),
    phone varchar(255) not null,
    primary key (phone)
                          );