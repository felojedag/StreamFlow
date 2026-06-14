package com.duoc.pagos.controller;

import com.duoc.pagos.model.dto.PagoDTO;
import com.duoc.pagos.service.PagoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @PostMapping
    public ResponseEntity<PagoDTO> registrarPago(@Valid @RequestBody PagoDTO pagoDTO) {
        PagoDTO nuevoPago = pagoService.registrarPago(pagoDTO);
        return new ResponseEntity<>(nuevoPago, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PagoDTO>> listarPagos() {
        return ResponseEntity.ok(pagoService.listarPagos());
    }
}