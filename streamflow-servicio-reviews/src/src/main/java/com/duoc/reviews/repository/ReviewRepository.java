package com.duoc.reviews.repository;

import com.duoc.reviews.model.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    List<ReviewEntity> findByUsuarioId(Long usuarioId);
    List<ReviewEntity> findByContenidoId(Long contenidoId);
}
