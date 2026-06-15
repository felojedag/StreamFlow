package com.duoc.historial.model.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class HistorialDTO {
    private Long id;

    @NotNull(message = "El ID de usuario es obligatorio")
    private Long usuarioId;

    @NotNull(message = "El ID del contenido es obligatorio")
    private Long contenidoId;

    private LocalDateTime fechaVisualizacion;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public Long getContenidoId() { return contenidoId; }
    public void setContenidoId(Long contenidoId) { this.contenidoId = contenidoId; }
    public LocalDateTime getFechaVisualizacion() { return fechaVisualizacion; }
    public void setFechaVisualizacion(LocalDateTime fechaVisualizacion) { this.fechaVisualizacion = fechaVisualizacion; }
}