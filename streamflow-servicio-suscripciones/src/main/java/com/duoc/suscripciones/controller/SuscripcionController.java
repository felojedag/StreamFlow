package com.duoc.suscripciones.controller;

import com.duoc.suscripciones.model.entity.SuscripcionEntity;
import com.duoc.suscripciones.service.SuscripcionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suscripciones")
public class SuscripcionController {

    @Autowired
    private SuscripcionService suscripcionService;

    @PostMapping
    public ResponseEntity<?> crearSuscripcion(@Valid @RequestBody SuscripcionEntity suscripcion) {
        try {
            SuscripcionEntity nueva = suscripcionService.crearSuscripcion(suscripcion);
            return new ResponseEntity<>(nueva, HttpStatus.CREATED);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}