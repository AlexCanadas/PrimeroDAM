                                                -- CONSULTAS --

-- ¿Cuál es el total de pedidos realizados por cada cliente?
SELECT a.id_cliente, a.nombre, COUNT(DISTINCT b.id_pedido) numPedidos
FROM clientes a 
LEFT JOIN pedidos b USING(id_cliente)
GROUP BY a.id_cliente;

--¿Cuáles son los detalles de los pedidos realizados por cada cliente?
SELECT a.id_cliente, a.nombre, b.id_pedido, c.id_producto, c.cantidad, c.precio_unitario, c.subtotal
FROM clientes a 
LEFT JOIN pedidos b USING (id_cliente)
LEFT JOIN detalles_pedido c USING(id_pedido);

--¿Cuál es la valoración media de cada producto?
SELECT a.id_producto, a.nombre_producto, AVG(b.valoracion) valoracionMedia
FROM productos a 
LEFT JOIN comentarios_producto b USING (id_producto)
GROUP BY id_producto

--¿Cuál es el coste total de productos en cada línea de productos?
SELECT a.id_linea_producto, a.nombre_linea, SUM(b.coste_unitario * b.stock) costeTotal
FROM lineas_producto a 
LEFT JOIN productos b USING(id_linea_producto)
GROUP BY id_linea_producto;

-- Saca cuantos empleados reportan a que persona, incluyendo sus datos (sin resultados vacíos)
SELECT a.id_empleado, a.nombre, a.apellido, a.puesto, COUNT(b.id_empleado) numEmpleados 
FROM empleados a 
LEFT JOIN empleados b ON a.id_empleado = b.id_reporta_a
GROUP BY b.id_reporta_a
ORDER BY a.id_empleado ASC;


                                                    -- FUNCIONES --

--Pregunta: Crea una función que reciba el id_cliente como parámetro y devuelva el nombre del representante de ventas de ese cliente.
CREATE FUNCTION devolverRepVentasSegunCliente(cliente int)
RETURNS VARCHAR(50)
BEGIN 
	DECLARE representanteVentas VARCHAR(50);

    SELECT a.nombre INTO representanteVentas
    FROM empleados AS a
    LEFT JOIN clientes AS b ON a.id_empleado = b.id_representante_ventas
    WHERE b.id_cliente = cliente
    GROUP BY a.nombre;
    
    RETURN representanteVentas;
END;

--Pregunta: Crea una función que reciba el id_cliente como parámetro y devuelva el total de pedidos realizados por ese cliente.
CREATE FUNCTION calcularTotalPedidos(cliente INT)
RETURNS INT
BEGIN 
	DECLARE resultado INT;
    
    SELECT COUNT(DISTINCT id_pedido) INTO resultado
    FROM pedidos
    WHERE id_cliente = cliente;
                          
    RETURN resultado;                        
END;

-- Calcular la edad media de los clientes 
DELIMITER $
CREATE OR REPLACE FUNCTION edadPromedioClientes() 
RETURNS DECIMAL(5,2)
BEGIN
    DECLARE promedio DECIMAL(5,2);

    SELECT AVG(edad) INTO promedio
    FROM clientes;

    RETURN promedio;
END $


                                                -- PROCEDIMIENTOS --

-- Cambiar correo eléctronico según el idCliente
DELIMITER $
CREATE OR REPLACE PROCEDURE actualizarCorreoCliente(IN idCliente INT, IN nuevoCorreo VARCHAR(100))
BEGIN
    UPDATE clientes
    SET correo_electronico = nuevoCorreo
    WHERE id_cliente = idCliente;
END $

-- Actualizar la cantidad en inventario de un producto
DELIMITER $
CREATE OR REPLACE PROCEDURE actualizarCantidadInventario(IN idProducto INT, IN nuevaCantidad INT)
BEGIN
    UPDATE inventario
    SET cantidad = nuevaCantidad
    WHERE id_producto = idProducto;
END $


-- Escribe un procedimiento para actualizar la tabla de pedidos que reciba dos parámetros: un id_pedido y un descuento que puede ser 'A' o 'B'. 
-- Se debe actualizar total_pedido, aplicándole un descuento del 15% si el descuento es tipo A.
-- Si es tipo B el descuento debe ser del 25%. En cualquier otro caso no se aplicará ningún descuento.
DELIMITER $
CREATE OR REPLACE PROCEDURE actualizarPedido(IN numPedido INT, IN descuento CHAR(1))
BEGIN
IF descuento = 'A' THEN
UPDATE pedidos
SET total_pedido = total_pedido * 0.85
WHERE id_pedido = numPedido;
ELSEIF descuento = 'B' THEN
UPDATE pedidos
SET total_pedido = total_pedido * 0.75
WHERE id_pedido = numPedido;
ELSE
SELECT 'No se aplicará ningún descuento dado que el tipo no es A o B.' AS mensaje;
END IF;
END $