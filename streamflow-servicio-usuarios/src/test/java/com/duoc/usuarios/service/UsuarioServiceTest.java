package com.duoc.usuarios.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.duoc.usuarios.model.dto.UsuarioDTO;
import com.duoc.usuarios.model.entity.UsuarioEntity;
import com.duoc.usuarios.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    private UsuarioEntity usuarioFalso;
    @BeforeEach
    void setUp() {
        usuarioFalso = new UsuarioEntity();
        usuarioFalso.setId(1L);
        usuarioFalso.setNombre("Felipe");
        usuarioFalso.setEmail("felipe@duoc.cl");
        usuarioFalso.setPassword("123456");
    }

    @Test
    void crearUsuario_CuandoCorreoNoExiste_RetornaUsuarioDTO() {
        when(usuarioRepository.findByEmail("felipe@duoc.cl")).thenReturn(Optional.empty());
        when(usuarioRepository.save(any(UsuarioEntity.class))).thenReturn(usuarioFalso);

        UsuarioDTO resultado = usuarioService.crearUsuario(usuarioFalso);

        assertNotNull(resultado);
        assertEquals("Felipe", resultado.getNombre());
        assertEquals("felipe@duoc.cl", resultado.getEmail());
        verify(usuarioRepository, times(1)).save(any(UsuarioEntity.class));
    }

    @Test
    void crearUsuario_CuandoCorreoYaExiste_LanzaExcepcion() {
        when(usuarioRepository.findByEmail("felipe@duoc.cl")).thenReturn(Optional.of(usuarioFalso));

        IllegalArgumentException excepcion = assertThrows(IllegalArgumentException.class, () -> {
            usuarioService.crearUsuario(usuarioFalso);
        });

        assertEquals("El correo ya se encuentra registrado", excepcion.getMessage());

        verify(usuarioRepository, never()).save(any(UsuarioEntity.class));
    }
}