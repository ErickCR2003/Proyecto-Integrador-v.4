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
imp_precAlquiler DECIMAL(18, 0) NOT NULL,
imp_descuento DECIMAL(18, 0) NOT NULL,
imp_montofinal DECIMAL(18, 0) NOT NULL
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
fecAdquisicion DATETIME NOT NULL,
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
VALUES('admin', 'admin', 'Juan', 'Pérez', '987595324', 'juan@gmail.com', '1989-05-29', 'ADMINISTRADOR', 'masculino', '42158697', true) 


