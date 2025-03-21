create database asistencias;

create table usuarios(
id_usuario int primary key auto_increment,
nombre varchar(45),
edad int,
sexo varchar(10),
cargo varchar(45),
area varchar(45),
usuario varchar(45),
contrasenia varchar(45),
sueldo double,
acceso varchar(45)
);

create table asistencia(
id int primary key auto_increment,
h_entrada varchar(100),
h_salida varchar(100),
fecha date,
id_usuario int,
CONSTRAINT asistencia FOREIGN KEY (id_usuario) REFERENCES usuarios (id_usuario)
);

insert into usuarios values (null,'ADMIN', 00, 'HOMBRE', 'ADMIN','ADMIN','ADMIN','admin',0.0,'DIRECTOR');
