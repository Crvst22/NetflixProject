CREATE DATABASE Netflix_DB;

USE Netflix_DB;




CREATE TABLE planes(
	codigo smallint primary key,
	nombre varchar(30),
	precio int,
	cantidadUsuarios int
)

CREATE TABLE cuenta(

	codigoCuenta smallint IDENTITY(1,1) primary key,
	codigoPlan smallint  foreign key(codigoPlan) references Planes(codigo),
	nombre varchar(30) not null,
	apellido varchar(30),
	correo varchar(30) unique,
	
)

 
 CREATE TABLE perfil(
	
	codigoCuenta smallint foreign key(codigoCuenta) references Cuenta(codigoCuenta) on delete cascade,
	nombre varchar(30),
	contraseña varchar(20),
	fechaInscripcion date,
	imagen image

	constraint pk_perfil primary key(codigoCuenta,nombre) 
 )

 CREATE TABLE contenido(
	
	codigo smallint IDENTITY(1,1) primary key,
	titulo varchar(20),
	duracion int
 )

 CREATE TABLE visualizaciones(
 
	codigoCuenta smallint,
	nombrePerfil varchar(30),
	codigoContenido smallint,
	fechaVisualizacion date,

	constraint fk_cuenta foreign key (codigoCuenta,nombrePerfil) references Perfil(codigoCuenta,nombre) on delete cascade,
	constraint fk_contenido foreign key (codigoContenido) references Contenido(codigo) on delete cascade,
	constraint pk_visualizaciones primary key(codigoCuenta,nombrePerfil,codigoContenido) 
 )



 CREATE TABLE recomendaciones(
	
	codigoContenido smallint foreign key (codigoContenido) references Contenido(codigo) on delete cascade,
	codigoContenido2 smallint,

	constraint pk_recomendaciones primary key(codigoContenido,codigoContenido2) 
 )



 CREATE TABLE metodoPago(
 
	numeroTarjeta int primary key,
	nombre varchar(20),
	apellido varchar(20),
	fechaVencimiento date,
	codigoCuenta smallint foreign key (codigoCuenta) references Cuenta(codigoCuenta) on delete cascade
 )



 CREATE TABLE generos(
 
	codGenero smallint primary key,
	nombre varchar(20)
 )

 CREATE TABLE series(
	
	codigoContenido smallint primary key (codigoContenido) references Contenido(codigo),
	cantTemporadas smallint
 )

 CREATE TABLE documentales(
 
	codigoContenido smallint primary key (codigoContenido) references Contenido(codigo),
	tematica varchar(20)
 )

 CREATE TABLE peliculas(
 
	codigoContenido smallint primary key (codigoContenido) references Contenido(codigo),
	codGenero smallint foreign key (codGenero) references Generos(codGenero) on delete cascade
 )

 

 INSERT INTO planes VALUES (1,'Individual',3200,1);
 INSERT INTO planes VALUES (2,'Doble',4200,2);
 INSERT INTO planes VALUES (3,'Familiar',6200,4);

