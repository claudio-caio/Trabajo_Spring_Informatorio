package com.trabajo.info_market.service.producto;

import com.trabajo.info_market.dto.producto.ProductoStockCeroDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ProductoStockService {
    List<ProductoStockCeroDTO> obtenerProductosSinStockEnCarritosAbiertos(BigDecimal precioMinimo, LocalDateTime fechaCreacion);
}
