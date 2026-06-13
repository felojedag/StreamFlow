package com.duoc.usuarios.service;

import com.duoc.usuarios.model.dto.UsuarioDTO;
import com.duoc.usuarios.model.entity.UsuarioEntity;
import com.duoc.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDTO crearUsuario(UsuarioEntity usuario) {
        if (usuarioRepository.findByCorreo(usuario.getCorreo()).isPresent()) {
            throw new IllegalArgumentException("El correo ya se encuentra registrado");
        }
        UsuarioEntity guardado = usuarioRepository.save(usuario);
        return convertToDTO(guardado);
    }

    public List<UsuarioDTO> listarTodos() {
        List<UsuarioEntity> entidades = usuarioRepository.findAll();
        List<UsuarioDTO> dtos = new ArrayList<>();

        for (UsuarioEntity entity : entidades) {
            dtos.add(convertToDTO(entity));
        }
        return dtos;
    }

    private UsuarioDTO convertToDTO(UsuarioEntity entity) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setCorreo(entity.getCorreo());
        return dto;
    }
}