package com.duoc.reviews.controller;

import com.duoc.reviews.model.dto.ReviewDTO;
import com.duoc.reviews.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewDTO> crearReview(@Valid @RequestBody ReviewDTO reviewDTO) {
        ReviewDTO nueva = reviewService.crearReview(reviewDTO);
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ReviewDTO>> listarTodas() {
        return ResponseEntity.ok(reviewService.listarTodas());
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<ReviewDTO>> listarPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(reviewService.listarPorUsuario(usuarioId));
    }

    @GetMapping("/contenido/{contenidoId}")
    public ResponseEntity<List<ReviewDTO>> listarPorContenido(@PathVariable Long contenidoId) {
        return ResponseEntity.ok(reviewService.listarPorContenido(contenidoId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReview(@PathVariable Long id) {
        reviewService.eliminarReview(id);
        return ResponseEntity.noContent().build();
    }
}
