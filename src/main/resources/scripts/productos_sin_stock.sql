-- Insertar productos con stock 0
INSERT INTO producto (id, nombre, descripcion, precio, stock, fecha_de_creacion)
VALUES 
(UUID(), 'Producto sin stock 1', 'Descripción del producto 1', 100.00, 0, CURRENT_TIMESTAMP),
(UUID(), 'Producto sin stock 2', 'Descripción del producto 2', 200.00, 0, CURRENT_TIMESTAMP),
(UUID(), 'Producto sin stock 3', 'Descripción del producto 3', 300.00, 0, CURRENT_TIMESTAMP),
(UUID(), 'Producto con stock 1', 'Descripción del producto 4', 400.00, 10, CURRENT_TIMESTAMP);

-- Insertar carritos abiertos
INSERT INTO carrito (id, estado, fecha_creacion)
VALUES 
(UUID(), 'ABIERTO', CURRENT_TIMESTAMP),
(UUID(), 'ABIERTO', CURRENT_TIMESTAMP);

-- Insertar items en carritos (relacionando productos sin stock con carritos abiertos)
INSERT INTO item_carrito (id, cantidad, carrito_id, producto_id)
SELECT UUID(), 1, c.id, p.id
FROM carrito c
CROSS JOIN producto p
WHERE p.stock = 0 AND c.estado = 'ABIERTO'
LIMIT 3;
