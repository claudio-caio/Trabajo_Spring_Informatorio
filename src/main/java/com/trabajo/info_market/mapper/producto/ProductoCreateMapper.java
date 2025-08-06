package com.trabajo.info_market.mapper.producto;

import com.trabajo.info_market.domain.Categoria;
import com.trabajo.info_market.domain.Producto;
import com.trabajo.info_market.dto.producto.ProductoCreateDto;
import com.trabajo.info_market.exception.notfound.NotFoundException;
import com.trabajo.info_market.repository.categoria.CategoriaRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;


@Mapper(componentModel = "spring")
public abstract class ProductoCreateMapper {

    @Autowired
    protected static CategoriaRepository categoriaRepository;

    @Mapping(target = "fechaActualizacion", ignore = true)
    @Mapping(target = "fechaDeCreacion", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "categorias", source = "categorias", qualifiedByName = "categoriasMapper")
    public abstract Producto productDtoCreateToProducto(ProductoCreateDto productoCreateDto);

    protected static Categoria map(Long id){
        return categoriaRepository.findById( id )
                .orElseThrow( () -> new NotFoundException("No se encontro la categoria con id : " + id));
    }

    @Named("categoriasMapper")
    public static java.util.List<Categoria> categorias(java.util.List<Long> ids) {
        if (ids == null) return null;
        return ids.stream().map(ProductoCreateMapper::map).toList();
    }


}
