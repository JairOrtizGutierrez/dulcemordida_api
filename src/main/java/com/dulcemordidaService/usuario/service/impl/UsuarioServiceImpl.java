package com.dulcemordidaService.usuario.service.impl;

import com.dulcemordidaService.usuario.entity.Usuario;
import com.dulcemordidaService.usuario.repository.UsuarioRepository;
import com.dulcemordidaService.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAllUsuarios() {
        return this.usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuario(String correo, String contraseña) {
        return this.usuarioRepository.findOneByCorreoAndContraseña(correo, contraseña);
    }
}
