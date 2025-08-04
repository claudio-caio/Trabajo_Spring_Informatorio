package com.trabajo.info_market.controller.producto;

import com.trabajo.info_market.dto.producto.ProductoStockCeroDTO;
import com.trabajo.info_market.service.producto.ProductoStockService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/productos/stock")
@AllArgsConstructor
public class ProductoStockController {

    private final ProductoStockService productoStockService;

    @GetMapping("/sin-stock-en-carritos")
    public ResponseEntity<List<ProductoStockCeroDTO>> getProductosSinStockEnCarritosAbiertos(
            @RequestParam(required = false) BigDecimal precioMinimo,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaCreacion) {
        
        return ResponseEntity.ok(productoStockService.obtenerProductosSinStockEnCarritosAbiertos(precioMinimo, fechaCreacion));
    }
}
