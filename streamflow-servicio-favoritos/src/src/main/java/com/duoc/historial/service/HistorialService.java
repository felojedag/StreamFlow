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
    private HistorialRepository historialRepository;

    public HistorialDTO registrarReproduccion(HistorialDTO dto) {
        HistorialEntity entity = new HistorialEntity();
        entity.setUsuarioId(dto.getUsuarioId());
        entity.setContenidoId(dto.getContenidoId());
        entity.setTipoContenido(dto.getTipoContenido().toUpperCase());
        entity.setProgresoPorcentaje(dto.getProgresoPorcentaje());

        HistorialEntity guardado = historialRepository.save(entity);
        return toDTO(guardado);
    }

    public List<HistorialDTO> listarTodos() {
        return historialRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<HistorialDTO> listarPorUsuario(Long usuarioId) {
        return historialRepository.findByUsuarioIdOrderByFechaReproduccionDesc(usuarioId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public void eliminarRegistro(Long id) {
        historialRepository.deleteById(id);
    }

    private HistorialDTO toDTO(HistorialEntity entity) {
        HistorialDTO dto = new HistorialDTO();
        dto.setId(entity.getId());
        dto.setUsuarioId(entity.getUsuarioId());
        dto.setContenidoId(entity.getContenidoId());
        dto.setTipoContenido(entity.getTipoContenido());
        dto.setProgresoPorcentaje(entity.getProgresoPorcentaje());
        dto.setFechaReproduccion(entity.getFechaReproduccion());
        return dto;
    }
}
