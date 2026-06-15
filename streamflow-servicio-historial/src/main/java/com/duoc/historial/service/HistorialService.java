package com.duoc.historial.service;

import com.duoc.historial.model.dto.HistorialDTO;
import com.duoc.historial.model.entity.HistorialEntity;
import com.duoc.historial.repository.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistorialService {

    @Autowired
    private HistorialRepository repository;

    public HistorialDTO registrarVisualizacion(HistorialDTO dto) {
        HistorialEntity entity = new HistorialEntity();
        entity.setUsuarioId(dto.getUsuarioId());
        entity.setContenidoId(dto.getContenidoId());

        HistorialEntity guardado = repository.save(entity);
        dto.setId(guardado.getId());
        dto.setFechaVisualizacion(guardado.getFechaVisualizacion());
        return dto;
    }

    public List<HistorialDTO> obtenerHistorialPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId).stream().map(entity -> {
            HistorialDTO dto = new HistorialDTO();
            dto.setId(entity.getId());
            dto.setUsuarioId(entity.getUsuarioId());
            dto.setContenidoId(entity.getContenidoId());
            dto.setFechaVisualizacion(entity.getFechaVisualizacion());
            return dto;
        }).collect(Collectors.toList());
    }
}
