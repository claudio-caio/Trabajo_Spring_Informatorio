-- Actualizar algunos productos para tener stock 0
UPDATE producto 
SET stock = 0 
WHERE id IN (
    'e3478027-63a6-490b-8f32-ef2c1ce37457', -- Set Compact 37 (originalmente stock 5)
    '14498916-6e49-49ee-bc83-2ef5d9662a65', -- Objeto Prime 11 (originalmente stock 13)
    '8e10f6a8-5195-4f93-b594-6ba3b8cc4b73'  -- Herramienta Flex 45 (originalmente stock 12)
);

-- Insertar carritos abiertos
INSERT INTO carrito (id, estado, fecha_creacion)
VALUES 
(UUID(), 'ABIERTO', CURRENT_TIMESTAMP),
(UUID(), 'ABIERTO', CURRENT_TIMESTAMP),
(UUID(), 'CERRADO', CURRENT_TIMESTAMP); -- Este carrito no debería aparecer en los resultados

-- Insertar items en carritos (relacionando productos con stock 0 con carritos abiertos)
INSERT INTO item_carrito (id, cantidad, carrito_id, producto_id)
SELECT 
    UUID(),
    1,
    c.id,
    p.id
FROM carrito c
CROSS JOIN producto p
WHERE p.stock = 0 
AND c.estado = 'ABIERTO';
