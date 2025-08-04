package com.trabajo.info_market.mapper.producto;

import com.trabajo.info_market.domain.Producto;
import com.trabajo.info_market.dto.producto.ProductoDto;

public interface ProductoMapper {
    ProductoDto productoToProductoDto(Producto producto);
}
