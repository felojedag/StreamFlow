package com.duoc.pagos.service;

import com.duoc.pagos.model.dto.PagoDTO;
import com.duoc.pagos.model.entity.PagoEntity;
import com.duoc.pagos.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public PagoDTO registrarPago(PagoDTO dto) {
        PagoEntity entity = new PagoEntity();
        entity.setUsuarioId(dto.getUsuarioId());
        entity.setMonto(dto.getMonto());

        PagoEntity guardado = pagoRepository.save(entity);
        dto.setId(guardado.getId());
        return dto;
    }

    public List<PagoDTO> listarPagos() {
        return pagoRepository.findAll().stream().map(entity -> {
            PagoDTO dto = new PagoDTO();
            dto.setId(entity.getId());
            dto.setUsuarioId(entity.getUsuarioId());
            dto.setMonto(entity.getMonto());
            return dto;
        }).collect(Collectors.toList());
    }
}