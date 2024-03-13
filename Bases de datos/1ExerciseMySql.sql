
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

