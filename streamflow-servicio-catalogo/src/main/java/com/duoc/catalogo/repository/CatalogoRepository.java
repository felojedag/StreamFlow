package com.duoc.catalogo.repository;

import com.duoc.catalogo.model.entity.CatalogoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogoRepository extends JpaRepository<CatalogoEntity, Long> {
}