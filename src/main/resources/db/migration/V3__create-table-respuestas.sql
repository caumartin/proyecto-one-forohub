create table respuestas(

    id bigint not null auto_increment,
    mensaje varchar (255) not null,
    creador varchar (100) not null,
    fecha_creacion datetime not null,
    topico varchar (255) not null,

    primary key(id)

);