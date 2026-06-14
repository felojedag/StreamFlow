package com.duoc.catalogo.controller;

import com.duoc.catalogo.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/catalogo")
public class CatalogoController {

    @Autowired
    private CatalogoService service;

    @GetMapping("/estado")
    public ResponseEntity<String> estado() {
        return ResponseEntity.ok(service.obtenerEstado());
    }
}