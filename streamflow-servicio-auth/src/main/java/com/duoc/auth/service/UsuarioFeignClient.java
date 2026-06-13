package com.duoc.auth.service;

import com.duoc.auth.model.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name = "streamflow-servicio-usuarios", url = "http://localhost:8081")
public interface UsuarioFeignClient {

    @GetMapping("/api/usuarios")
    ResponseEntity<List<UsuarioDTO>> obtenerTodosLosUsuarios();
}
