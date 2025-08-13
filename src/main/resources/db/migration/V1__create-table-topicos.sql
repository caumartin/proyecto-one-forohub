create table topicos(

    id bigint not null auto_increment,
    titulo varchar (100) not null unique,
    mensaje varchar (250) not null unique,
    fecha_creacion datetime not null,
    estado varchar (10) not null,
    creador varchar (100) not null,
    curso varchar (15) not null,
    respuestas varchar (250),

    primary key(id)

);