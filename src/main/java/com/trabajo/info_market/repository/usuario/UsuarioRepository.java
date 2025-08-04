package com.trabajo.info_market.repository.usuario;

import com.trabajo.info_market.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
}
