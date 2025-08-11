create table usuarios(

    id bigint not null auto_increment,
    nombre varchar (50) not null unique,
    email varchar (50) not null unique,
    fechaCreacion varchar(20) not null,
    password varchar (255) not null,

    primary key(id)

);