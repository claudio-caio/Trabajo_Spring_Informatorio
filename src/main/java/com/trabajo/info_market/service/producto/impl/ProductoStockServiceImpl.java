package com.trabajo.info_market.service.producto.impl;

import com.trabajo.info_market.domain.Producto;
import com.trabajo.info_market.dto.producto.ProductoStockCeroDTO;
import com.trabajo.info_market.repository.producto.ProductoRepository;
import com.trabajo.info_market.service.producto.ProductoStockService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductoStockServiceImpl implements ProductoStockService {

    private final ProductoRepository productoRepository;

    @Override
    public List<ProductoStockCeroDTO> obtenerProductosSinStockEnCarritosAbiertos(BigDecimal precioMinimo, LocalDateTime fechaCreacion) {
        // Si no se proporciona fecha, usar la fecha actual
        LocalDateTime fechaFiltro = fechaCreacion != null ? fechaCreacion : LocalDateTime.now();

        List<Producto> productos;
        try {
            productos = productoRepository.findProductosSinStockEnCarritosAbiertos(fechaFiltro);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener productos sin stock en carritos abiertos", e);
        }

        return productos.stream()
                .filter(producto -> precioMinimo == null || BigDecimal.valueOf(producto.getPrecio()).compareTo(precioMinimo) >= 0)
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private ProductoStockCeroDTO mapToDTO(Producto producto) {
        return ProductoStockCeroDTO.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .precio(BigDecimal.valueOf(producto.getPrecio()))
                .stock(producto.getStock())
                .fechaCreacion(producto.getFechaDeCreacion().atStartOfDay())
                .categoria(producto.getCategorias() != null && !producto.getCategorias().isEmpty() ? 
                    producto.getCategorias().iterator().next().getNombre() : null)
                .build();
    }
}
