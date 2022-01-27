CREATE schema if not exists zerno;

create table if not exists zerno.bonus (
                                           id int4 generated by default as identity,
                                           bonuses int4,
                                           first_name varchar(255),
                                           last_name varchar(255),
                                           phone_id int4,
                                           primary key (id)
);

create table if not exists zerno.staff (
                                           id int4 generated by default as identity,
                                           address varchar(255),
                                           first_name varchar(255),
                                           last_name varchar(255),
                                           phone_id int4,
                                           position varchar(255),
                                           salary float8,
                                           primary key (id)
);

create table if not exists zerno.phone (
                                           id int generated by default as identity,
                                           number varchar(255),
                                           primary key (id)
);

ALTER table zerno.staff
    ADD CONSTRAINT IF NOT EXISTS fk_phone_number
        FOREIGN KEY (id)
            REFERENCES zerno.phone (id);

ALTER table zerno.bonus
    ADD CONSTRAINT IF NOT EXISTS fk_phone_number
        FOREIGN KEY (id)
            REFERENCES zerno.phone (id);