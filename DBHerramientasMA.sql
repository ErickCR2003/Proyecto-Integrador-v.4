CREATE DATABASE ServicioAlquiler;

USE ServicioAlquiler;

CREATE TABLE Alquiler(
ID INT AUTO_INCREMENT PRIMARY KEY,
fecHoraCreacion DATE NOT NULL,
diasAlquiler INT NOT NULL,
fecHoraSalida DATE NOT NULL,
fecHoraRetorno DATE,
imp_Alquiler DECIMAL(16, 2) NOT NULL,
imp_Garantia DECIMAL(16, 2) NOT NULL,
imp_Traslado DECIMAL(16, 2) NOT NULL,
imp_Total DECIMAL(16, 2) NOT NULL,
idEmpleado INT NOT NULL,
idCliente INT NOT NULL,
estado VARCHAR(15),
conTraslado BIT NOT NULL,
direccionEntrega VARCHAR(200),
SerieFacBol VARCHAR(4) NOT NULL,
NroFacBol INT NOT NULL,
serieCorrFacBol VARCHAR(12) NOT NULL
);

CREATE TABLE DetallesAlquiler(
ID INT AUTO_INCREMENT PRIMARY KEY,
idAlquiler INT NOT NULL,
idHerramienta INT NOT NULL,
imp_precAlquiler DECIMAL(16, 20) NOT NULL,
imp_descuento DECIMAL(16, 2) NOT NULL,
imp_montofinal DECIMAL(16, 2) NOT NULL
);

CREATE TABLE cliente(
ID INT AUTO_INCREMENT PRIMARY KEY,
nombrecompleto VARCHAR(80),
telefono VARCHAR(10),
direccion VARCHAR(50),
fecNacimiento DATE,
rucDni VARCHAR(20),
numeroIdentifacion VARCHAR(50)
);

CREATE TABLE empleado(
ID INT AUTO_INCREMENT PRIMARY KEY,
usuario VARCHAR(50),
contraseña VARCHAR(50),
nombre VARCHAR(50),
apellido VARCHAR(50),
telefono VARCHAR(9),
email VARCHAR(50),
fecNacimiento DATE,
tipo VARCHAR(15),
genero VARCHAR(10),
dni VARCHAR(12),
activo BIT
);

CREATE TABLE Herramienta (
ID INT AUTO_INCREMENT NOT NULL,
nroSerie VARCHAR(50) NULL,
nombre VARCHAR(50) NULL,
idTipo TINYINT NOT NULL,
imp_ValorReferencia DECIMAL(18, 0) NOT NULL,
anioFabricacion int NULL,
descripcion VARCHAR(100) NULL,
peso DECIMAL(18, 0) NULL,
imp_PrecioAlquiler DECIMAL(18, 0) NOT NULL,
fecAdquisicion DATE NOT NULL,
nroAlquileres INT NOT NULL,
estado VARCHAR(50) NULL,
PRIMARY KEY (ID)
); 

CREATE TABLE Pago (
ID INT AUTO_INCREMENT NOT NULL,
fecHoraCreacion DATE NOT NULL,
idAlquiler INT NOT NULL,
imp_Total DECIMAL(16, 2) NOT NULL,
formaDePago VARCHAR(20) NOT NULL,
nroTransaccion VARCHAR(30) NULL,
PRIMARY KEY (ID),
FOREIGN KEY (idAlquiler) REFERENCES Alquiler (ID)
); 

CREATE TABLE tipoHerramienta (
ID TINYINT AUTO_INCREMENT NOT NULL,
nombreTipo VARCHAR(50) NULL,
descripcion VARCHAR(50) NULL,
PRIMARY KEY (ID)
); 

CREATE TABLE movimiento (
ID INT auto_increment PRIMARY KEY NOT NULL,
idAlquiler INT NULL,
idEmpleado INT NOT NULL,
fecEjecucion DATE NOT NULL,
tipoIngresoSalida VARCHAR(15) NOT NULL,
concepto VARCHAR(20) NOT NULL, 
tipoEfectivoElectronico VARCHAR(15) NOT NULL,
monto DECIMAL(16,2) NOT NULL,
observ VARCHAR(200) NULL,
anulado BIT NOT NULL
);

CREATE TABLE caja(
ID INT auto_increment PRIMARY KEY NOT NULL,
montoEfectivo DECIMAL(8,2) NOT NULL
);

CREATE TABLE OrdenMantenimiento(
ID INT AUTO_INCREMENT PRIMARY KEY,
fecCreacion DATE NOT NULL,
fecCierre DATE NULL,
estado VARCHAR(15),
problema VARCHAR(1000),
reparacion VARCHAR(1000),
costoReparacion DECIMAL(16, 2) NULL,
idHerramienta INT NOT NULL,
idEmpleado INT NOT NULL
); 


ALTER TABLE Alquiler ADD CONSTRAINT FK_Alquiler_Cliente FOREIGN KEY (idCliente) REFERENCES cliente (ID);
ALTER TABLE Alquiler ADD CONSTRAINT FK_Alquiler_Empleado FOREIGN KEY (idEmpleado) REFERENCES empleado (ID);
ALTER TABLE DetallesAlquiler ADD CONSTRAINT FK_DetallesAlquiler_Alquiler FOREIGN KEY (idAlquiler) REFERENCES Alquiler (ID);
ALTER TABLE DetallesAlquiler ADD CONSTRAINT FK_DetallesAlquiler_Herramienta FOREIGN KEY (idHerramienta) REFERENCES Herramienta (ID);
ALTER TABLE Herramienta ADD CONSTRAINT FK_Herramienta_tipoHerramienta FOREIGN KEY (idTipo) REFERENCES tipoHerramienta (ID);
ALTER TABLE Pago ADD CONSTRAINT FK_Pago_Alquiler FOREIGN KEY (idAlquiler) REFERENCES Alquiler (ID);
ALTER TABLE OrdenMantenimiento ADD CONSTRAINT FK_OrdenMantenimiento_Herramienta FOREIGN KEY (idHerramienta) REFERENCES Herramienta (ID);
ALTER TABLE OrdenMantenimiento ADD CONSTRAINT FK_OrdenMantenimiento_empleado FOREIGN KEY (idEmpleado) REFERENCES empleado (ID);


CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `lst_alquileres` AS select `c`.`nombrecompleto` AS `NomCliente`,`c`.`rucDni` 
AS `TipoRucDniCli`,`c`.`numeroIdentificacion` AS `RucDniCli`,`e`.`nombre` AS `NomEmpleado`,`a`.`ID` AS `ID`,`a`.`fecHoraCreacion` AS `fecHoraCreacion`,`a`.`fecHoraSalida` 
AS `fecHoraSalida`,`a`.`fecHoraRetorno` AS `fecHoraRetorno`,`a`.`imp_Total` AS `imp_Total`,`a`.`imp_Garantia` AS `imp_Garantia`,`a`.`imp_Traslado` 
AS `imp_Traslado`,`a`.`imp_Alquiler` AS `imp_Alquiler`,`a`.`estado` AS `estado`,`a`.`serieCorrFacBol` AS `SerieCorrFacBol` 
from ((`alquiler` `a` join `cliente` `c` on((`a`.`idCliente` = `c`.`ID`))) left join `empleado` `e` on((`a`.`idEmpleado` = `e`.`ID`))) 
order by `a`.`ID` desc;

INSERT INTO caja(montoEfectivo) VALUES(0)


/*usuario inicial*/
INSERT INTO empleado(usuario, contraseña, nombre, apellido, telefono, email, fecNacimiento, tipo, genero, dni, activo) 
VALUES('admin', 'admin', 'Juan', 'Pérez', '987595324', 'juan@gmail.com', '1989-05-29', 'ADMINISTRADOR', 'masculino', '42158697', true) 


