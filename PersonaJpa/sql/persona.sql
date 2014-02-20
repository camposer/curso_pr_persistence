DROP TABLE persona;
CREATE TABLE persona
(
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	nombre VARCHAR(50) NOT NULL,
	apellido varchar(50) NOT NULL,
	fecha_nacimiento DATE,
	altura FLOAT,
	PRIMARY KEY (id)

);

INSERT INTO  persona ( nombre,apellido, fecha_nacimiento, altura)
VALUES ('Juan','Perez','1980-01-03',180);
INSERT INTO  persona ( nombre,apellido, fecha_nacimiento, altura)
VALUES ('Maria','Gonzalez','1970-04-20',160);
INSERT INTO  persona ( nombre,apellido, fecha_nacimiento, altura)
VALUES ('Pedro','Garcia','1971-05-18',170);

SELECT * FROM persona;

DROP TABLE ordenador;
CREATE TABLE ordenador
(
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	persona_id INT NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	serial VARCHAR(50) NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (persona_id) REFERENCES persona(id)
);

INSERT INTO ordenador(persona_id, nombre, serial) VALUES(1, 'uno', '123');
INSERT INTO ordenador(persona_id, nombre, serial) VALUES(2, 'dos', '456');
INSERT INTO ordenador(persona_id, nombre, serial) VALUES(3, 'tres', '789');

SELECT * FROM persona p
INNER JOIN ordenador o ON o.persona_id = p.id

SELECT * FROM persona p
JOIN ordenador o ON o.persona_id = p.id

SELECT * FROM persona p, ordenador o
WHERE o.persona_id = p.id


