CREATE TABLE usuario (
    id INTEGER PRIMARY KEY,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE tarjeta (
    id INTEGER PRIMARY KEY,
    titulo VARCHAR(20) NOT NULL,
    descripcion VARCHAR(1000) NULL,
    creada DATE NOT NULL,
    modificada DATE NOT NULL,
    eliminada DATE NOT NULL
);