package com.dulcemordidaService.usuario.repository;

import com.dulcemordidaService.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findOneByCorreoAndContraseña(String correo, String contraseña);
}
