package com.trabajo.info_market.service.item;

import com.trabajo.info_market.domain.Carrito;
import com.trabajo.info_market.domain.ItemCarrito;
import com.trabajo.info_market.domain.Producto;

public interface ItemService {
    ItemCarrito crearItemCarrito(Carrito carrito, Producto producto, int cantidad);
}
