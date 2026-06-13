package com.duoc.auth.service;

import com.duoc.auth.model.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthService {

    @Autowired
    private UsuarioFeignClient usuarioFeignClient;

    public List<UsuarioDTO> listarUsuariosDesdeAuth() {
        return usuarioFeignClient.obtenerTodosLosUsuarios().getBody();
    }
}