SET @holamundo = "Hola mundo" --definir variable (volatil)
SELECT @holamundo --llamar a la variable 

--creamos tabla reseñas
CREATE TABLE reseñas (id_venta INT PRIMARY KEY, valoracion INT, texto_reseña VARCHAR(200), FOREIGN KEY (id_venta) REFERENCES ventas (id_venta))

SELECT libros.titulo INTO @miVariable --guardar dato en una variable (en este caso nombre de libro)
FROM ventas 
INNER JOIN libros USING (id_libro) 
WHERE id_venta = 123;

DELIMITER $ --si no se pone el delimiter acaba en el ;
SELECT * FROM libros $
CREATE FUNCTION miPrimeraFuncion () --declarar funcion
RETURNS VARCHAR(20)
BEGIN
DECLARE miVariable VARCHAR(20);
SET miVariable = "Hola mundo";
RETURN miVariable;
END$

DROP FUNCTION miPrimeraFuncion(); --eliminar funcion

DELIMITER $ 
SELECT * FROM libros $
CREATE OR REPLACE FUNCTION miPrimeraFuncion (varID INT) 
RETURNS VARCHAR(20)
BEGIN
DECLARE miVariable VARCHAR(20);
SELECT titulo INTO miVariable
FROM ventas LEFT JOIN libros USING(id_libro) 
WHERE id_venta = varID;
RETURN miVariable;
END$

--hacemos un IF
DELIMITER $ 
SELECT * FROM libros $
CREATE OR REPLACE FUNCTION miPrimeraFuncion (varID INT) 
RETURNS VARCHAR(20)
BEGIN
DECLARE miVariableResultado VARCHAR(20);
IF varID < 2 THEN
SELECT titulo INTO miVariable
FROM ventas LEFT JOIN libros USING(id_libro) 
WHERE id_venta = varID;
ELSEIF varID < 5 THEN 
SET miVariableResultado = "menorQue5";
ELSE
SET miVariableResultado = "otro";
END IF
RETURN miVariable;
END$

--bucle LOOP
DELIMITER $ 
SELECT * FROM libros $
CREATE OR REPLACE FUNCTION factorial (numero INT) 
RETURNS VARCHAR(50)
BEGIN
     DECLARA miVariableResultado INT;
     DECLARE numeroAux INT;
     SET miVariableResultado = numero;
     SET numeroAux = numero;
     bucle1: LOOP
        SET numeroAux = numeroAux -1;
        IF numeroAux = 1 THEN 
            LEAVE bucle1;
        ELSE SET miVariableResultado = miVariableResultado* numeroAux;
        END IF;
     END LOOP bucle1;

     RETURN miVariableResultado;
END$

--bucle WHILE
DELIMITER $ 
SELECT * FROM libros $
CREATE OR REPLACE FUNCTION factorial (numero INT) 
RETURNS VARCHAR(50)
BEGIN
     DECLARA miVariableResultado INT;
     DECLARE numeroAux INT;
     SET miVariableResultado = numero;
     SET numeroAux = numero;
     WHILE numeroAux > 1 DO 
        SET numeroAux = numeroAux -1;
        SET miVariableResultado = miVariableResultado* numeroAux;
     END WHILE;
     RETURN miVariableResultado;
END$

--bucle REPEAT
DELIMITER $ 
SELECT * FROM libros $
CREATE OR REPLACE FUNCTION factorial (numero INT) 
RETURNS VARCHAR(50)
BEGIN
     DECLARA miVariableResultado INT;
     DECLARE numeroAux INT;
     SET miVariableResultado = numero;
     SET numeroAux = numero;
     REPEAT 
        SET numeroAux = numeroAux -1;
        SET miVariableResultado = miVariableResultado* numeroAux;
     UNTIL numeroAux <=1 END REPEAT;
     RETURN miVariableResultado;
END$

SELECT miPrimeraFuncion(1); -- trae el titulo del libro con la variable =1

SELECT *, miPrimeraFuncion(ventas.id_venta) FROM ventas WHERE id_venta<10; -- se repite la funcion para 10 libros

DROP FUNCTION miPrimeraFuncion; --eliminar funcion

SHOW CREATE FUNCTION nombreDeLaFuncion; --ver una función creada