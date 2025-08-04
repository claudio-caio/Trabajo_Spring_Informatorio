package com.trabajo.info_market.repository.item;

import com.trabajo.info_market.domain.ItemCarrito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemCarritoRepository extends JpaRepository<ItemCarrito, UUID> {
}
