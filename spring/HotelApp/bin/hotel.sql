cd..
cd.. 
cd xampp 
cd mysql
cd bin
mysql -h localhost -u root -p 

drop database if exists hotel;
create database hotel;

use hotel;

create table tarifa(
	tarifaID int auto_increment primary key,
	tarifaTotal varchar(200)not null,
        costo float not null
	
);

create table room( 
	roomID int auto_increment primary key,
	tarifaID int,
	checkin datetime,
	checkout datetime,
	status varchar(50)
	
);

alter table room add foreign key(tarifaID) references tarifa(tarifaID) on delete cascade;

create table huespedDTO(
	huespedID int ,
	roomID int,
	facturaID int
);

create table huesped(
	huespedID int auto_increment primary key,
	nombre varchar(45),
	apellido varchar(45),
	direccion varchar(50),
	edad varchar(50),
	genero varchar(50),
	telefono int, 
	dpi int
	
);

alter table huespedDTO add foreign key(huespedID) references huesped(huespedID) on delete cascade;

create table facturaDTO(
	facturaID int,
	itemID int
);



create table factura( 
	facturaID int  auto_increment primary key,
	serie varchar(45),
	numfact varchar(50)
	);

alter table facturaDTO add foreign key (facturaID) references factura(facturaID) on delete cascade;
alter table huespedDTO add foreign key (facturaID) references factura(facturaID) on delete cascade;

create table itemFact(
	itemID int auto_increment primary key,
	item varchar(100),
	costo float 
);

alter table facturaDTO add foreign key (itemID) references itemFact(itemID) on delete cascade;

create table Usuario(
	usuarioID int auto_increment primary key,
	nombreUsuario varchar(45),
	apellidoUsuario varchar(45),
	direccionUsuario varchar(45),
	telefonoUsuario varchar(10),
	emailUsuario varchar(25),
	IDtipoEmpleado int
);
 
create table tipoEmpleado(
	tipoEmpleadoID int auto_increment primary key,
	nombreTipoempleado varchar(45),
	permisos varchar(45)
);

alter table Usuario add foreign key (tipoEmpleadoID) references tipoEmpleado(tipoEmpleadoID) on delete cascade;



