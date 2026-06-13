package com.duoc.auth.controller;

import com.duoc.auth.model.dto.LoginRequestDTO;
import com.duoc.auth.model.dto.UsuarioDTO;
import com.duoc.auth.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Autenticación", description = "Operaciones relacionadas al inicio de sesión y validación de usuarios")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Operation(summary = "Probar conexión", description = "Obtiene la lista de usuarios desde el microservicio vecino")
    @ApiResponse(responseCode = "200", description = "Conexión exitosa")
    @GetMapping("/test-usuarios")
    public List<UsuarioDTO> testConexion() {
        return authService.listarUsuariosDesdeAuth();
    }

    @Operation(summary = "Iniciar Sesión", description = "Valida las credenciales de un usuario")
    @ApiResponse(responseCode = "200", description = "Login exitoso")
    @ApiResponse(responseCode = "401", description = "Credenciales incorrectas")
    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequestDTO loginRequest) {
        List<UsuarioDTO> usuarios = authService.listarUsuariosDesdeAuth();

        boolean existeUsuario = usuarios.stream()
                .anyMatch(u -> u.getCorreo().equalsIgnoreCase(loginRequest.getCorreo()));

        if (existeUsuario) {
            return ResponseEntity.ok("¡Autenticación exitosa! Token generado simulado.");
        } else {
            return ResponseEntity.status(401).body("Error: Credenciales incorrectas o usuario no encontrado.");
        }
    }
}