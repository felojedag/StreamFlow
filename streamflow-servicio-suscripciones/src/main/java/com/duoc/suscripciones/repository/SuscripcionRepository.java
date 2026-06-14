package com.duoc.suscripciones.repository;

import com.duoc.suscripciones.model.entity.SuscripcionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuscripcionRepository extends JpaRepository<SuscripcionEntity, Long> {
}