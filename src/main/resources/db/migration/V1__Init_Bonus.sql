CREATE schema public;

create table public.bonus (
    bonuses int4,
    first_name varchar(255),
    last_name varchar(255),
    phone varchar(255) not null,
    primary key (phone)
                          );