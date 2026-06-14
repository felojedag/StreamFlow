package com.duoc.favoritos.repository;

import com.duoc.favoritos.model.entity.FavoritoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoritoRepository extends JpaRepository<FavoritoEntity, Long> {
    List<FavoritoEntity> findByUsuarioId(Long usuarioId);
    Optional<FavoritoEntity> findByUsuarioIdAndContenidoId(Long usuarioId, Long contenidoId);
}
