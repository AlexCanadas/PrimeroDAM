
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

--¿Qué clientes dejaron comentarios para un producto específico?
SELECT a.id_producto, c.nombre_producto, a.id_comentario, a.comentario ,b.id_cliente, b.nombre
FROM comentarios_producto a 
LEFT JOIN clientes b USING (id_cliente)
LEFT JOIN productos c USING (id_producto)
WHERE a.id_producto = 1;

--¿Cuántos empleados trabajan en cada oficina?
SELECT a.id_oficina, a.nombre_oficina, COUNT(b.id_empleado) numEmpleados
FROM oficinas a
LEFT JOIN empleados b USING(id_oficina)
GROUP BY id_oficina;

--¿Quiénes son los empleados que reportan a un supervisor específico?
SELECT a.id_representante_ventas, a.nombre, b.id_empleado, b.nombre, b.apellido
FROM clientes a 
LEFT JOIN empleados b ON a.id_representante_ventas = b.id_empleado
WHERE a.id_representante_ventas = 3;

--¿Cuál es el total de pagos realizados por cada cliente?
SELECT a.id_cliente, a.nombre, COUNT(b.id_pago) totalNumPagos
FROM clientes a
LEFT JOIN pagos b USING (id_cliente)
GROUP BY id_cliente;

--¿Cuál es el coste total de productos en cada línea de productos?
SELECT a.id_linea_producto, a.nombre_linea, SUM(b.coste_unitario * b.stock) costeTotal
FROM lineas_producto a 
LEFT JOIN productos b USING(id_linea_producto)
GROUP BY id_linea_producto;

--¿Cuál es el total de ventas de cada representante de ventas?
SELECT a.id_representante_ventas, b.nombre, SUM(DISTINCT c.id_pedido) totalVentas
FROM clientes a 
LEFT JOIN empleados b ON a.id_representante_ventas = b.id_empleado
LEFT JOIN pedidos c USING(id_cliente)
GROUP BY a.id_representante_ventas;

--¿Cuál es la proporción de pedidos a pagos realizados por cada cliente?
SELECT a.id_cliente, a.nombre, COUNT(DISTINCT b.id_pedido) numPedidos, COUNT(DISTINCT c.id_pago) numPagos
FROM clientes a 
LEFT JOIN pedidos b USING(id_cliente)
LEFT JOIN pagos c USING(id_cliente)
GROUP BY id_cliente;
