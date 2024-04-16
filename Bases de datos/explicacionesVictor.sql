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

CALL miPrimeraFuncion(); -- llamar a la función


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


-- Ejemplo de IF
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


-- Ejemplo bucle que suma números desde el número que llegue a 100
DELIMITER $ 
CREATE ejemploWhile (miNumero INT) 
RETURNS INT
BEGIN
   -- Código de la función (terminado con ;)
   DECLARE resultado INT;
   DECLARE contador INT;
   SET contador = miNumero;
   SET resultado = 0;
   
   WHILE contador <= 100 DO
      SET resultado = resultado + contador;
      SET contador = contador + 1;
   END WHILE;
   RETURN resultado;
END$


-- Ejemplo de LOOP
DELIMITER $ 
CREATE ejemploWhile (miNumero INT) 
RETURNS INT
BEGIN
   -- Código de la función (terminado con ;)
   DECLARE resultado INT;
   DECLARE contador INT;
   SET contador = miNumero;
   SET resultado = 0;
   miBucle: LOOP
      IF contador <= 100 THEN 
         SET resultado = resultado + contador;
         SET contador = contador + 1;
      ELSE 
         -- Intrucción para salir del bucle
         LEAVE miBucle;
   END IF;
   RETURN resultado;
END$


-- Ejemplo de REPEAT / UNTIL
DELIMITER $
CREATE FUNCTION ejemploRepeat (miNumero INT)
RETURNS INT
BEGIN
	-- codigo de la función (terminado con ;)
    -- el bucle suma numeros desde el numero que llegue a 100
    -- si llega 50 el resultado es 50 + 51 + 52... + 100
    DECLARE resultado INT;
    DECLARE contador INT;
    SET contador = miNumero;
    SET resultado = 0;
    REPEAT
		SET resultado = resultado + contador;
        SET contador = contador + 1;
    UNTIL contador >= 100 END REPEAT;
    RETURN resultado;
END$

-- Ejemplo de cursor
DELIMITER $
CREATE PROCEDURE calificacionLetra ()
BEGIN
   DECLARE miIdCalificacion INT,
   DECLARE miCalificacion FLOAT,
   DECLARE miIdCalificacionLetra VARCHAR (2);
   DECLARE variableFinal INT;
   DECLARE miCursor CURSOR FOR SELECT id_calificacion, calificacion FROM `calificaciones`;
   DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET variableFinal = 1;
   SET variableFinal = 0;
   OPEN miCursor;
   miLoop: LOOP
      FETCH miCursor INTO miIdCalificacion, miCalificacion
      IF miCalificacion < 5 THEN 
         SET miIdCalificacionLetra = 'NM' -- < 5 Necesita mejorar
      ELSEIF miCalificacion < 7 THEN
         SET miIdCalificacionLetra = 'BNM' -- 5 y 6 Bien
      ELSEIF miCalificacion < 9 THEN
         SET miIdCalificacionLetra = 'N' -- 7 y 8 Notable
      ELSE 
         SET miIdCalificacionLetra = 'SB' -- 9 y 10 Sobresaliente
      END IF;
   UPDATE calificaciones SET calificaciones.calificacionLetra = miIdCalificacionLetra
   WHERE calificaciones.id_calificacion = miIdCalificacion;
   IF variableFinal = 1 THEN
      LEAVE miLoop;
   END IF;
END LOOP miLoop;
END$