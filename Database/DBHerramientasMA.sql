CREATE DATABASE ServicioAlquiler;

USE ServicioAlquiler;

CREATE TABLE Alquiler(
ID INT AUTO_INCREMENT PRIMARY KEY,
fecHoraCreacion DATE NOT NULL,
diasAlquiler INT NOT NULL,
fecHoraSalida DATETIME NOT NULL,
fecHoraRetorno DATETIME,
imp_Total DECIMAL(18, 0) NOT NULL,
imp_Garantia DECIMAL(18, 0) NOT NULL,
imp_Traslado DECIMAL(18, 0) NOT NULL,
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
imp_montofinal DECIMAL(18, 0) NOT NULL
);

CREATE TABLE cliente(
ID INT AUTO_INCREMENT PRIMARY KEY,
nombrecompleto VARCHAR(80),
telefono VARCHAR(10),
direccion VARCHAR(50),
fecNacimiento DATE,
rucDni VARCHAR(20),
numeroIdentificacion VARCHAR(50)
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
imp_ValorReferencial DECIMAL(18, 0) NOT NULL,
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
fecHoraCreacion DATETIME NOT NULL,
idAlquiler INT NOT NULL,
imp_Total DECIMAL(18, 0) NOT NULL,
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

ALTER TABLE Alquiler ADD CONSTRAINT FK_Alquiler_Cliente FOREIGN KEY (idCliente) REFERENCES cliente (ID);
ALTER TABLE Alquiler ADD CONSTRAINT FK_Alquiler_Empleado FOREIGN KEY (idEmpleado) REFERENCES empleado (ID);
ALTER TABLE DetallesAlquiler ADD CONSTRAINT FK_DetallesAlquiler_Alquiler FOREIGN KEY (idAlquiler) REFERENCES Alquiler (ID);
ALTER TABLE DetallesAlquiler ADD CONSTRAINT FK_DetallesAlquiler_Herramienta FOREIGN KEY (idHerramienta) REFERENCES Herramienta (ID);
ALTER TABLE Herramienta ADD CONSTRAINT FK_Herramienta_tipoHerramienta FOREIGN KEY (idTipo) REFERENCES tipoHerramienta (ID);
ALTER TABLE Pago ADD CONSTRAINT FK_Pago_Alquiler FOREIGN KEY (idAlquiler) REFERENCES Alquiler (ID);

/*usuario inicial*/
INSERT INTO empleado(usuario, contraseña, nombre, apellido, telefono, email, fecNacimiento, tipo, genero, dni, activo) 
VALUES('admin', 'admin', 'Juan', 'Pérez', '987595324', 'juan@gmail.com', '1989-05-29', 'ADMINISTRADOR', 'masculino', '42158697', true); 

/*Tipos de herramienta iniciales*/
INSERT INTO tipoHerramienta(nombreTipo, descripcion)
VALUES('Taladros','eléctricos, inalámbricos');
VALUES('Escaleras','simples, telescópicas, plegables, de tijera');
VALUES('Cierras','circulares, caladoras');
VALUES('Generadores','');
VALUES('Soldadoras','');
VALUES('Amoladoras','');



CREATE VIEW `lst_alquileres` AS
    SELECT 
        `c`.`nombrecompleto` AS `NomCliente`,
        `c`.`rucDni` AS `TipoRucDniCli`,
        `c`.`numeroIdentificacion` AS `RucDniCli`,
        `e`.`nombre` AS `NomEmpleado`,
        `a`.`ID` AS `ID`,
        `a`.`fecHoraCreacion` AS `fecHoraCreacion`,
        `a`.`fecHoraSalida` AS `fecHoraSalida`,
        `a`.`fecHoraRetorno` AS `fecHoraRetorno`,
        `a`.`imp_Total` AS `imp_Total`,
        `a`.`imp_Garantia` AS `imp_Garantia`,
        `a`.`imp_Traslado` AS `imp_Traslado`,
        `a`.`estado` AS `estado`,
        `a`.`serieCorrFacBol` AS `SerieCorrFacBol`
    FROM
        ((`alquiler` `a`
        JOIN `cliente` `c` ON ((`a`.`idCliente` = `c`.`ID`)))
        LEFT JOIN `empleado` `e` ON ((`a`.`idEmpleado` = `e`.`ID`)))
    ORDER BY `a`.`ID` DESC