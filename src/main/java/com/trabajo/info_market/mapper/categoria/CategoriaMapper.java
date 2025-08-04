package com.trabajo.info_market.mapper.categoria;

import com.trabajo.info_market.domain.Categoria;
import com.trabajo.info_market.dto.categoria.CategoriaDto;

public interface CategoriaMapper {
    CategoriaDto categoriaToCategoriaDto(Categoria categoria);
}
