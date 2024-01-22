package com.dulcemordidaService.usuario.controller;

import com.dulcemordidaService.usuario.entity.Usuario;
import com.dulcemordidaService.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        return ResponseEntity.ok(this.usuarioService.getAllUsuarios());
    }

    @GetMapping(value="{correo}/{contraseña}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable("correo") String correo, @PathVariable("contraseña") String contraseña) {
        return ResponseEntity.ok(this.usuarioService.getUsuario(correo, contraseña));
    }
}
