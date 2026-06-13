package com.duoc.auth.service;

import com.duoc.auth.model.dto.UsuarioDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @Mock
    private UsuarioFeignClient usuarioFeignClient;

    @InjectMocks
    private AuthService authService;

    @Test
    void testListarUsuariosDesdeAuth_DebeRetornarLista() {
        UsuarioDTO mockUsuario = new UsuarioDTO(1L, "Juan", "juan@correo.com");
        List<UsuarioDTO> listaSimulada = Arrays.asList(mockUsuario);

        when(usuarioFeignClient.obtenerTodosLosUsuarios())
                .thenReturn(ResponseEntity.ok(listaSimulada));

        List<UsuarioDTO> resultado = authService.listarUsuariosDesdeAuth();

        assertNotNull(resultado, "El resultado no debe ser nulo");
        assertEquals(1, resultado.size(), "Debe haber 1 usuario en la lista");
        assertEquals("juan@correo.com", resultado.get(0).getCorreo(), "El correo debe coincidir");
    }
}