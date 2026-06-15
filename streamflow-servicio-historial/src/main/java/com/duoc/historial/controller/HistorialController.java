package com.duoc.historial.controller;

import com.duoc.historial.model.dto.HistorialDTO;
import com.duoc.historial.service.HistorialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/historial")
public class HistorialController {

    @Autowired
    private HistorialService service;

    @PostMapping
    public ResponseEntity<HistorialDTO> guardar(@Valid @RequestBody HistorialDTO dto) {
        return new ResponseEntity<>(service.registrarVisualizacion(dto), HttpStatus.CREATED);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<HistorialDTO>> listarPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(service.obtenerHistorialPorUsuario(usuarioId));
    }
}