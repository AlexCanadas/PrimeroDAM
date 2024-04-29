
-- Muestra los productos, su precio de compra, la cantidad de producto vendido y su precio
SELECT a.productCode, a.productName, a.buyPrice, b.quantityOrdered, b.priceEach
FROM products AS a
LEFT JOIN orderdetails AS b
USING(productCode);


-- Muestra el beneficio total de la compañía por cada producto de mayor a menor. 
--(JOIN, operaciones con columnas, GROUP BY, ORDER BY)
SELECT a.productCode, a.productName, b.ingresoTotal-(a.buyPrice*b.quantityOrdered) AS totalProfit
FROM products AS a
LEFT JOIN (SELECT productCode, SUM(quantityOrdered) AS quantityOrdered, SUM(priceEach*quantityOrdered) AS ingresoTotal FROM orderdetails
GROUP BY productCode) AS b
USING(productCode)
ORDER BY totalProfit DESC;


-- Muestra los 5 empleados que más dinero hayan generado con los pagos de sus clientes 
-- (JOIN, GROUP BY, ORDER BY, LIMIT)
SELECT a.employeeNumber, a.lastName, a.firstName, d.TotalVentas
FROM employees AS a
LEFT JOIN (
    SELECT b.salesRepEmployeeNumber, SUM(c.TotalVentas) AS TotalVentas
    FROM customers AS b
    LEFT JOIN (
        SELECT customerNumber, SUM(amount) AS TotalVentas
        FROM payments
        GROUP BY customerNumber
    ) AS c
    ON b.customerNumber = c.customerNumber
    GROUP BY b.salesRepEmployeeNumber
) AS d
ON a.employeeNumber = d.salesRepEmployeeNumber
ORDER BY d.TotalVentas DESC
LIMIT 5;


-- Muestra el número de pedidos y el precio medio de todos los pedidos que hayan realizado los clientes de cada empleado.
SELECT A.employeeNumber, A.lastName, A.firstName, COUNT(A.orderNumber) AS numeroPedidos, AVG(A.subtotal_Aux) AS precioMedioPedidos 
FROM (
    SELECT employees.employeeNumber, employees.lastName, employees.firstName, orders.orderNumber, SUM(orderdetails.quantityOrdered * orderdetails.priceEach) AS subtotal_Aux 
    FROM employees 
    LEFT JOIN customers ON employees.employeeNumber = customers.salesRepEmployeeNumber 
    LEFT JOIN orders USING(customernumber) 
    LEFT JOIN orderdetails USING(orderNumber) 
    GROUP BY employees.employeeNumber, employees.lastName, employees.firstName, orders.orderNumber 
    ) A 
    GROUP BY A.employeeNumber, A.lastName, A.firstName;


-- Muestra la cantidad total de productos vendidos por línea de producto.
SELECT productLine, SUM(quantityInStock) AS qtyInStock, SUM(qtyOrdered) AS qtyOrdered
FROM (
SELECT a.productLine, a.productCode, a.quantityInStock, b.qtyOrdered
FROM products AS a
LEFT JOIN (
    SELECT productCode, SUM(quantityOrdered) AS qtyOrdered
    FROM orderDetails GROUP BY productCode
) AS b
USING(productCode)
) AS q
GROUP BY productLine;


/* Crea una función EsPar que reciba un número y devuelva 1 si el número es par
o 0 si es impar */
DELIMITER $
CREATE FUNCTION EsPar (num int)
RETURNS INT
BEGIN
    DECLARE resultado INT;
    
    IF num % 2 = 0 THEN
        SET resultado =1; -- En caso de que sea par resultado=1
    ELSE
        SET resultado = 0; -- En caso de que sea impar resultado=0
    END IF;

    RETURN resultado;
END $


/* Crea una función que reciba un número de cliente (customerNumber) y
devuelva la suma de todos sus pagos. */
DELIMITER $
CREATE FUNCTION paymentsSum (customerNumber INT)
RETURNS DOUBLE
BEGIN
    DECLARE totalAmount DOUBLE;

    SELECT SUM(amount) INTO totalAmount
    FROM payments
    WHERE payments.customerNumber = customerNumber;

    RETURN totalAmount;
END $


/* Crea una función que reciba un número de cliente (customerNumber) y
devuelva la suma de todos sus pagos si el customerNumber es par o el número
total de pagos si el customerNumber es impar. */
DELIMITER $
CREATE FUNCTION returnParOImpar (customerNumber INT)
RETURNS double
BEGIN
    DECLARE output DOUBLE;

    IF customerNumber % 2 = 0 THEN
        SELECT SUM(amount) INTO output
        FROM payments
        WHERE payments.customerNumber = customerNumber;
    ELSE
        SELECT COUNT(checkNumber) INTO output
        FROM payments
        WHERE payments.customerNumber = customerNumber;
    END IF;

    RETURN output;
END $


/* Crea una función que para un número entero cualquiera N calcule sumatorio
de 1 a N, esto es sumar todos los números enteros desde 1 hasta N (incluido).
Si el número introducido es <= 0 debe devolver 0. */
DELIMITER $
CREATE FUNCTION sumarN (nNum INT)
RETURNS INT
BEGIN
    DECLARE total INT;
    DECLARE i INT;

    IF nNum <= 0 THEN
        RETURN 0;
    END IF;
    SET total = 0;
    SET i = 1;

    WHILE i <= nNum DO
        SET total = total + i;
        SET i = i + 1;
    END WHILE;
    RETURN total;
END $


-- Escribe una función que dado el ID de un pedido devuelva el precio total de ese pedido, calculándolo a partir de detalles_pedido
DELIMITER $
CREATE FUNCTION precioTotalPedido(numPedido INT)
RETURNS DOUBLE
BEGIN 
DECLARE resultado DOUBLE;
SELECT SUM(subtotal) INTO resultado
FROM detalles_pedido
WHERE id_pedido = numPedido;
RETURN resultado;
END$


-- Escribe un procedimiento para actualizar la tabla de empleados que reciba como parámetro id_empleado e id_oficina. 
-- Tras comprobar si la oficina introducida existe debemos actualizar si existe y no hacer nada si no existe.
DELIMITER $ 
CREATE PROCEDURE actualizarEmpleados(numEmpleado INT, numOficina INT)
BEGIN
    DECLARE oficina_existe BOOLEAN;

    -- Verificar si la oficina con numOficina existe
    SELECT COUNT(*) > 0 INTO oficina_existe
    FROM oficinas
    WHERE id_oficina = numOficina;

    -- Si oficina_existe es TRUE, actualizar el id_oficina del empleado numEmpleado
    IF oficina_existe THEN
        UPDATE empleados
        SET id_oficina = numOficina
        WHERE id_empleado = numEmpleado;
        SELECT 'Empleado actualizado correctamente.' AS mensaje;
    ELSE
        SELECT 'La oficina especificada no existe.' AS mensaje;
    END IF;
END$

