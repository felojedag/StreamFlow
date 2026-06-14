package com.duoc.auth.service;

import com.duoc.auth.model.dto.LoginDTO;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public String procesarLogin(LoginDTO login) {
        if ("felipe@duoc.cl".equals(login.getCorreo()) && "123456".equals(login.getPassword())) {
            return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.SimulacionDeTokenValidoParaLaEvaluacion";
        }
        throw new IllegalArgumentException("Credenciales incorrectas");
    }
}