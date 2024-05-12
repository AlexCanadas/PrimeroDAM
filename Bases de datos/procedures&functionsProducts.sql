--Pregunta: Crea un procedimiento que reciba el id_cliente como parámetro y devuelva todos los pedidos realizados por ese cliente.
CREATE PROCEDURE totalPedidosCliente(cliente INT)
BEGIN
	DECLARE resultado INT;
    
    SELECT COUNT(DISTINCT id_pedido) INTO resultado
    FROM pedidos
    WHERE id_cliente = cliente;
    
    IF resultado > 0 THEN 
        SELECT resultado AS totalpedidos;
    ELSEIF resultado = 0 THEN
        SELECT 'Este cliente no tiene pedidos realizados' AS mensaje;
    ELSE
        SELECT 'No existe ese id_cliente en la tabla clientes' AS mensaje;
	END IF;

END;
--Pregunta: Crea un procedimiento que reciba el id_representante como parámetro y devuelva el total de ventas realizadas por ese representante.
CREATE PROCEDURE totalVentasRepSegunCliente(representante int) 
BEGIN 
    DECLARE totalVentas INT;

    SELECT COUNT(DISTINCT b.id_pedido) INTO totalVentas
    FROM clientes AS a
    LEFT JOIN pedidos AS b USING(id_cliente)
    WHERE a.id_representante_ventas = representante;

    IF totalVentas > 0 THEN 
    SELECT totalVentas;
    ELSEIF totalVentas = 0 THEN 
    SELECT 'Este representante no tuvo ventas' AS mensaje;
    ELSE 
    SELECT 'Este representante no existe en la tabla clientes' AS mensaje;
END IF;

END;
--Pregunta: Crea un procedimiento que reciba el id_producto como parámetro y devuelva todos los comentarios para ese producto.

--Pregunta: Crea un procedimiento que reciba una fecha de inicio y una fecha de fin, y devuelva las ventas totales realizadas entre esas fechas.

--Pregunta: Crea un procedimiento que reciba el id_cliente como parámetro y devuelva el total de pagos pendientes para ese cliente.


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
--Pregunta: Crea una función que reciba el id_producto como parámetro y devuelva el número de comentarios positivos (valoración >= 4) para ese producto.

--Pregunta: Crea una función que reciba el id_producto como parámetro y devuelva el coste total de ese producto basado en el coste unitario y el stock.


