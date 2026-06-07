
CREATE TABLE videojuegos(
	codigo VARCHAR(10) PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL,
	plataforma VARCHAR(50) NOT NULL,
	precio  NUMERIC(10,2) NOT NULL,
	disponible BOOLEAN NOT NULL,
	genero VARCHAR(50)
);

SELECT * FROM videojuegos;