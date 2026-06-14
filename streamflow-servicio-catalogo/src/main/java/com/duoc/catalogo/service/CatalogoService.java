package com.duoc.catalogo.service;

import com.duoc.catalogo.repository.CatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogoService {
    @Autowired
    private CatalogoRepository repository;

    public String obtenerEstado() {
        return "El servicio de Catálogo está funcionando correctamente.";
    }
}