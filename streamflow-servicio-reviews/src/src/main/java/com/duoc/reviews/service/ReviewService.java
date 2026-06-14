package com.duoc.reviews.service;

import com.duoc.reviews.model.dto.ReviewDTO;
import com.duoc.reviews.model.entity.ReviewEntity;
import com.duoc.reviews.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public ReviewDTO crearReview(ReviewDTO dto) {
        ReviewEntity entity = new ReviewEntity();
        entity.setUsuarioId(dto.getUsuarioId());
        entity.setContenidoId(dto.getContenidoId());
        entity.setTipoContenido(dto.getTipoContenido().toUpperCase());
        entity.setCalificacion(dto.getCalificacion());
        entity.setComentario(dto.getComentario());

        ReviewEntity guardado = reviewRepository.save(entity);
        return toDTO(guardado);
    }

    public List<ReviewDTO> listarTodas() {
        return reviewRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<ReviewDTO> listarPorUsuario(Long usuarioId) {
        return reviewRepository.findByUsuarioId(usuarioId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<ReviewDTO> listarPorContenido(Long contenidoId) {
        return reviewRepository.findByContenidoId(contenidoId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public void eliminarReview(Long id) {
        reviewRepository.deleteById(id);
    }

    private ReviewDTO toDTO(ReviewEntity entity) {
        ReviewDTO dto = new ReviewDTO();
        dto.setId(entity.getId());
        dto.setUsuarioId(entity.getUsuarioId());
        dto.setContenidoId(entity.getContenidoId());
        dto.setTipoContenido(entity.getTipoContenido());
        dto.setCalificacion(entity.getCalificacion());
        dto.setComentario(entity.getComentario());
        dto.setFechaReview(entity.getFechaReview());
        return dto;
    }
}
