package com.duoc.notificaciones.controller;

import com.duoc.notificaciones.model.dto.NotificacionDTO;
import com.duoc.notificaciones.service.NotificacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService service;

    @PostMapping("/enviar")
    public ResponseEntity<NotificacionDTO> enviar(@Valid @RequestBody NotificacionDTO dto) {
        return new ResponseEntity<>(service.enviarYRegistrar(dto), HttpStatus.CREATED);
    }

    @GetMapping("/historial")
    public ResponseEntity<List<NotificacionDTO>> historial() {
        return ResponseEntity.ok(service.listarHistorialNotificaciones());
    }
}
