package com.trabajo.info_market.mapper.producto;

import com.trabajo.info_market.domain.Categoria;
import com.trabajo.info_market.domain.Producto;
import com.trabajo.info_market.dto.producto.ProductoCreateDto;
import com.trabajo.info_market.exception.notfound.NotFoundException;
import com.trabajo.info_market.repository.categoria.CategoriaRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ProductoCreateMapper {

    @Autowired
    protected CategoriaRepository categoriaRepository;

    @Mapping(target = "categorias", source = "categorias")
    public abstract Producto productDtoCreateToProducto(ProductoCreateDto productoCreateDto);

    protected Categoria map(Long id){
        return categoriaRepository.findById( id )
                .orElseThrow( () -> new NotFoundException("No se encontro la categoria con id : " + id));
    }


}
