package com.duoc.suscripciones.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "servicio-usuarios", url = "${URL_USUARIOS:http://localhost:8081}")
public interface UsuarioClient {

    @GetMapping("/api/usuarios/{id}/existe")
    boolean verificarExistencia(@PathVariable("id") Long id);
}