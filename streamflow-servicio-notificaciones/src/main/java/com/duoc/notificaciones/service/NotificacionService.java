package com.duoc.notificaciones.service;

import com.duoc.notificaciones.model.dto.NotificacionDTO;
import com.duoc.notificaciones.model.entity.NotificacionEntity;
import com.duoc.notificaciones.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificacionService {

    @Autowired
    private NotificacionRepository repository;

    public NotificacionDTO enviarYRegistrar(NotificacionDTO dto) {
        NotificacionEntity entity = new NotificacionEntity();
        entity.setDestinatario(dto.getDestinatario());
        entity.setAsunto(dto.getAsunto());
        entity.setMensaje(dto.getMensaje());

        NotificacionEntity guardada = repository.save(entity);

        dto.setId(guardada.getId());
        dto.setFechaEnvio(guardada.getFechaEnvio());
        return dto;
    }

    public List<NotificacionDTO> listarHistorialNotificaciones() {
        return repository.findAll().stream().map(entity -> {
            NotificacionDTO dto = new NotificacionDTO();
            dto.setId(entity.getId());
            dto.setDestinatario(entity.getDestinatario());
            dto.setAsunto(entity.getAsunto());
            dto.setMensaje(entity.getMensaje());
            dto.setFechaEnvio(entity.getFechaEnvio());
            return dto;
        }).collect(Collectors.toList());
    }
}