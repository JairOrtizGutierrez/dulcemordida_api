package com.dulcemordidaService.usuario.service;

import com.dulcemordidaService.usuario.entity.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> getAllUsuarios();

    Usuario getUsuario(String correo, String contraseña);
}
