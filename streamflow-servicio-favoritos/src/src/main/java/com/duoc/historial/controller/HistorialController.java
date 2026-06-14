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
    private HistorialService historialService;

    @PostMapping
    public ResponseEntity<HistorialDTO> registrarReproduccion(@Valid @RequestBody HistorialDTO historialDTO) {
        HistorialDTO nuevo = historialService.registrarReproduccion(historialDTO);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<HistorialDTO>> listarTodos() {
        return ResponseEntity.ok(historialService.listarTodos());
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<HistorialDTO>> listarPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(historialService.listarPorUsuario(usuarioId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRegistro(@PathVariable Long id) {
        historialService.eliminarRegistro(id);
        return ResponseEntity.noContent().build();
    }
}
