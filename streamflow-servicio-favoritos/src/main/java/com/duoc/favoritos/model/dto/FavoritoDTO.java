package com.duoc.favoritos.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class FavoritoDTO {

    private Long id;

    @NotNull(message = "El ID del usuario no puede estar vacío")
    private Long usuarioId;

    @NotNull(message = "El ID del contenido no puede estar vacío")
    private Long contenidoId;

    @NotBlank(message = "El tipo de contenido es obligatorio")
    private String tipoContenido;

    private LocalDateTime fechaAgregado;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public Long getContenidoId() { return contenidoId; }
    public void setContenidoId(Long contenidoId) { this.contenidoId = contenidoId; }
    public String getTipoContenido() { return tipoContenido; }
    public void setTipoContenido(String tipoContenido) { this.tipoContenido = tipoContenido; }
    public LocalDateTime getFechaAgregado() { return fechaAgregado; }
    public void setFechaAgregado(LocalDateTime fechaAgregado) { this.fechaAgregado = fechaAgregado; }
}
