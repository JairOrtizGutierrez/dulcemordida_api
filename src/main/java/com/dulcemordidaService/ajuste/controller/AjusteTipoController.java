package com.dulcemordidaService.ajuste.controller;

import com.dulcemordidaService.ajuste.entity.AjusteTipo;
import com.dulcemordidaService.ajuste.service.AjusteTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ajustesTipo")
public class AjusteTipoController {
    @Autowired
    AjusteTipoService ajusteTipoService;

    @GetMapping
    public ResponseEntity<List<AjusteTipo>> getAllAjustesTipo() {
        return ResponseEntity.ok(this.ajusteTipoService.getAllAjustesTipo());
    }
}