package com.duoc.suscripciones.service;

import com.duoc.suscripciones.client.UsuarioClient;
import com.duoc.suscripciones.model.entity.SuscripcionEntity;
import com.duoc.suscripciones.repository.SuscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuscripcionService {

    @Autowired
    private SuscripcionRepository suscripcionRepository;

    @Autowired
    private UsuarioClient usuarioClient;

    public SuscripcionEntity crearSuscripcion(SuscripcionEntity suscripcion) {
        boolean usuarioExiste = usuarioClient.verificarExistencia(suscripcion.getUsuarioId());

        if (!usuarioExiste) {
            throw new IllegalArgumentException("El usuario con ID " + suscripcion.getUsuarioId() + " no existe. No se puede crear la suscripción.");
        }

        return suscripcionRepository.save(suscripcion);
    }
}