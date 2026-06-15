package com.duoc.notificaciones.repository;

import com.duoc.notificaciones.model.entity.NotificacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionRepository extends JpaRepository<NotificacionEntity, Long> {
}