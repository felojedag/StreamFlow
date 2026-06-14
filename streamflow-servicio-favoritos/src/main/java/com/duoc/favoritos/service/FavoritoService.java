package com.duoc.favoritos.service;

import com.duoc.favoritos.model.dto.FavoritoDTO;
import com.duoc.favoritos.model.entity.FavoritoEntity;
import com.duoc.favoritos.repository.FavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoritoService {

    @Autowired
    private FavoritoRepository favoritoRepository;

    public FavoritoDTO agregarFavorito(FavoritoDTO dto) {
        // Verificar si ya existe
        favoritoRepository.findByUsuarioIdAndContenidoId(dto.getUsuarioId(), dto.getContenidoId())
                .ifPresent(f -> {
                    throw new RuntimeException("El contenido ya está en favoritos del usuario");
                });

        FavoritoEntity entity = new FavoritoEntity();
        entity.setUsuarioId(dto.getUsuarioId());
        entity.setContenidoId(dto.getContenidoId());
        entity.setTipoContenido(dto.getTipoContenido().toUpperCase());

        FavoritoEntity guardado = favoritoRepository.save(entity);
        return toDTO(guardado);
    }

    public List<FavoritoDTO> listarPorUsuario(Long usuarioId) {
        return favoritoRepository.findByUsuarioId(usuarioId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<FavoritoDTO> listarTodos() {
        return favoritoRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public void eliminarFavorito(Long id) {
        favoritoRepository.deleteById(id);
    }

    private FavoritoDTO toDTO(FavoritoEntity entity) {
        FavoritoDTO dto = new FavoritoDTO();
        dto.setId(entity.getId());
        dto.setUsuarioId(entity.getUsuarioId());
        dto.setContenidoId(entity.getContenidoId());
        dto.setTipoContenido(entity.getTipoContenido());
        dto.setFechaAgregado(entity.getFechaAgregado());
        return dto;
    }
}
